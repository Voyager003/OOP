package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP have to discount 10%")
    void vip_0(){
    //given
    Member member = new Member(1L,"memberVIP", Grade.VIP);
    //when
    int discount = discountPolicy.discount(member,10000);
    //then
    Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP have't to discount 10%")
    void vip_x(){
        //given
        Member member = new Member(1L,"memberVIP", Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member,10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }


    }