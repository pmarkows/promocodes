package pl.sii.promocodes.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sii.promocodes.dao.PromoCode;
import pl.sii.promocodes.dto.PromoCodeDTO;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PromoCodeServiceTest {

    @Autowired
    private PromoCodeService promoCodeService;

    // test containers tool java + docker, annotacje test containers , które uruchomią kontener docker - fajne do testów
    // jak skonfugurować aplkę żeby się uruchamiała jako obraz docker?
    // 1. magia springa
    // 2. własny docker file

    @Test
    void createPromoCode() {
        String promoCodeName = "test2";

        PromoCodeDTO promoCodeDTO = new PromoCodeDTO();
        promoCodeDTO.setPromoName(promoCodeName);
        PromoCode promoCode = promoCodeService.createPromoCode(promoCodeDTO);
        assertNotNull(promoCode.getId());
        assertEquals("test2", promoCode.getCode());
    }

    public PromoCodeService getPromoCodeService() {
        return promoCodeService;
    }

    public void setPromoCodeService(PromoCodeService promoCodeService) {
        this.promoCodeService = promoCodeService;
    }
}