package pl.sii.promocodes.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoCodeRep extends JpaRepository<PromoCode, Integer> {

}
