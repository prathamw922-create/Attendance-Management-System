package com.attendance.attendancesystem.service;

import com.attendance.attendancesystem.dto.AttendanceRequest;
import com.attendance.attendancesystem.model.Attendance;
import com.attendance.attendancesystem.model.Student;
import com.attendance.attendancesystem.model.Subject;
import com.attendance.attendancesystem.repository.AttendanceRepository;
import com.attendance.attendancesystem.repository.StudentRepository;
import com.attendance.attendancesystem.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public void markAttendance(List<AttendanceRequest> requests) {
        List<Attendance> attendances = new ArrayList<>();
        for (AttendanceRequest req : requests) {
            Student student = studentRepository.findById(req.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            // Allow dummy subject if not provided or default to 1
            Long subId = req.getSubjectId() != null ? req.getSubjectId() : 1L;
            Subject subject = subjectRepository.findById(subId)
                    .orElseGet(() -> {
                        Subject newSub = new Subject("General", "Admin");
                        newSub.setId(1L);
                        return subjectRepository.save(newSub);
                    });

            Attendance attendance = new Attendance(student, subject, req.getDate(), req.getStatus());
            attendances.add(attendance);
        }
        attendanceRepository.saveAll(attendances);
    }
}
