package com.asl.single_store_poc;

import com.asl.single_store_poc.model.IotRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IotRecordRepositry extends CrudRepository<IotRecord, Long> {

    @Query("SELECT * FROM iot_record WHERE type=:type and create_date_time BETWEEN :createdDateTimeFrom AND :createdDateTimeTo")
    List<IotRecord> findByTypeAndCreatedDateTime(int type, Date createdDateTimeFrom, Date createdDateTimeTo);

}