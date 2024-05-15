package pl.sii.promocodes.services;

import org.springframework.stereotype.Service;
import pl.sii.promocodes.dao.PromoCode;
import pl.sii.promocodes.dao.PromoCodeRep;
import pl.sii.promocodes.dto.PromoCodeDTO;

@Service
public class PromoCodeService {

    private final PromoCodeRep promoCodeRep;

    public PromoCodeService(PromoCodeRep promoCodeRep) {
        this.promoCodeRep = promoCodeRep;
    }

    public PromoCode createPromoCode(PromoCodeDTO promoCodeDto) {
        PromoCode promoCode = new PromoCode();
        promoCode.setCode(promoCodeDto.getPromoName());
        return promoCodeRep.save(promoCode);
    }
}
