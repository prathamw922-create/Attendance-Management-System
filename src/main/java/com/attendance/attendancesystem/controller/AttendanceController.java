package com.attendance.attendancesystem.controller;

import com.attendance.attendancesystem.dto.AttendanceRequest;
import com.attendance.attendancesystem.model.Attendance;
import com.attendance.attendancesystem.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAttendanceRecords() {
        return attendanceService.getAllAttendance();
    }

    @PostMapping
    public ResponseEntity<String> markAttendance(@RequestBody List<AttendanceRequest> requests) {
        attendanceService.markAttendance(requests);
        return ResponseEntity.ok("Attendance marked successfully");
    }
}
