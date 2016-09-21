package com.tidyjava.bobscalendar.domain;

public interface CodeRepository {

    Code get();

    void store(Code code);
}
