package pl.sii.promocodes.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sii.promocodes.dto.PromoCodeDTO;
import pl.sii.promocodes.services.PromoCodeService;

@RestController
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    public PromoCodeController(PromoCodeService promoCodeService) {
        this.promoCodeService = promoCodeService;
    }

    @PostMapping(path = "/promocode")
    @ResponseStatus(HttpStatus.CREATED)
    public Long createNewPromoCode(@RequestBody PromoCodeDTO promoCodeDTO) {
        return promoCodeService.createPromoCode(promoCodeDTO).getId();
    }
}
