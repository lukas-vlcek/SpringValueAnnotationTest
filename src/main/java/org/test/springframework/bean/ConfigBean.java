package org.test.springframework.bean;

import org.springframework.beans.factory.annotation.Value;

public class ConfigBean {

    @Value("#{ values['one'] }") private int one;
    @Value("#{ values['two'] }") private int two;

    // testing the default value expression
    @Value("#{ values['three']?:'3' }") private int three;

    public int getOne() {
        return this.one;
    }

    public int getTwo() {
        return this.two;
    }

    public int getThree() {
        return this.three;
    }
}
