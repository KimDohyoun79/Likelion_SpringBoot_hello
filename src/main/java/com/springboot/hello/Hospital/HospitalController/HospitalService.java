package com.springboot.hello.Hospital.HospitalController;

import com.springboot.hello.Hospital.dao.HospitalDao;
import com.springboot.hello.Hospital.domain.Hospital;
import com.springboot.hello.Hospital.parser.ReadLineContext2;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HospitalService {
    private final ReadLineContext2<Hospital> hospitalReadLineContext;

    private final HospitalDao hospitalDao;

    public HospitalService(ReadLineContext2<Hospital> hospitalReadLineContext, HospitalDao hospitalDao) {
        this.hospitalReadLineContext = hospitalReadLineContext;
        this.hospitalDao = hospitalDao;
    }


    public int insertLargeVolumeHospitalData(String filename) {
        int cnt = 0;
        try {
            List<Hospital> hospitalList = hospitalReadLineContext.readByLine(filename);
            System.out.println("파싱이 끝났습니다.");
            for (Hospital hospital : hospitalList) { // loop구간
                try {
                    this.hospitalDao.add(hospital); // db에 insert하는 구간
                    cnt++;
                } catch (Exception e) {
                    System.out.printf("id:%d 레코드에 문제가 있습니다.",hospital.getId());
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cnt;
    }

}
