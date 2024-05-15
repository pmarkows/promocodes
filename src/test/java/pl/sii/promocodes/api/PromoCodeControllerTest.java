package pl.sii.promocodes.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import pl.sii.promocodes.dao.PromoCode;
import pl.sii.promocodes.dto.PromoCodeDTO;
import pl.sii.promocodes.services.PromoCodeService;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(PromoCodeController.class)
class PromoCodeControllerTest {

    public static final String PROMOCODE_NAME = "test3";
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PromoCodeService promoCodeService;

    @Test
    void createNewPromoCode() throws Exception {
        PromoCode promoCode = new PromoCode();
        promoCode.setId(3L);
        promoCode.setCode(PROMOCODE_NAME);
        Mockito.when(promoCodeService.createPromoCode(Mockito.any(PromoCodeDTO.class))).thenReturn(promoCode);

        mockMvc.perform(MockMvcRequestBuilders.post("/promocode")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
    """
    {"promoName":"test3"}
    """
        )).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }
}