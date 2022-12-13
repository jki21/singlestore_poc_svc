package com.asl.single_store_poc;

import com.asl.single_store_poc.model.IotRecord;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SingleStoreDBService {
    private final IotRecordRepositry repository;

    public SingleStoreDBService(IotRecordRepositry repository) {
        this.repository = repository;
    }

    public Long addIotRecord(IotRecord rec) {
        rec.setCreate_date_time(new Date());
        IotRecord result = repository.save(rec);
        return result.getIotRecordId();
    }

    public IotRecord findById(Long iotRecordId) {
        return repository.findById(iotRecordId).orElse(new IotRecord());
    }

    public List<IotRecord>  findByTypeAndDateRange(int type, Date dateFrom, Date dateTo) {
        return repository.findByTypeAndCreatedDateTime(type, dateFrom, dateTo);
    }
}

