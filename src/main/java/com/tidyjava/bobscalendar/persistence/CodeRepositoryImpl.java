package com.tidyjava.bobscalendar.persistence;

import com.tidyjava.bobscalendar.domain.Code;
import com.tidyjava.bobscalendar.domain.CodeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CodeRepositoryImpl implements CodeRepository {
    private Code code;

    @Override
    public Code get() {
        return code;
    }

    @Override
    public void store(Code code) {
        this.code = code;
    }
}
