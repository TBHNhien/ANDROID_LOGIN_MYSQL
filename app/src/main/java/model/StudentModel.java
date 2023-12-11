package model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentModel {

    @Expose
    private Long status;
    @Expose
    private Object error;
    @Expose
    private List<StudentResponse> response = null;
    public StudentModel(Long status, Object error, List<StudentResponse> response) {
        super();
        this.status = status;
        this.error = error;
        this.response = response;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public List<StudentResponse> getResponse() {
        return response;
    }

    public void setResponse(List<StudentResponse> response) {
        this.response = response;
    }

}

