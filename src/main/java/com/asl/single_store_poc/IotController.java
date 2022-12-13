package com.asl.single_store_poc;

import com.asl.single_store_poc.model.IotRecord;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/iot")
public class IotController {

    private final SingleStoreDBService dbService;

    public IotController(SingleStoreDBService dbService, IotRecordRepositry repository) {
        this.dbService = dbService;
    }

    @GetMapping("/")
    public String health() {
        return "alive";
    }

    @GetMapping("/{iotRecordId}")
    public IotRecord getUser(@PathVariable Long iotRecordId) {
        return dbService.findById(iotRecordId);
    }

    @PostMapping("")
    Long insert(@RequestBody IotRecord rec)
    {
        return dbService.addIotRecord(rec);
    }

    @GetMapping("/search-by-type")
    public List<IotRecord> search(@RequestParam("type") int type, @RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateFrom, @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateTo) {
        return dbService.findByTypeAndDateRange(type, dateFrom, dateTo);
    }


}