package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentAdd {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("id")
    @Expose
    private Long id;

    /**
     * No args constructor for use in serialization
     *
     */
    public StudentAdd() {
    }

    /**
     *
     * @param id
     * @param status
     */
    public StudentAdd(String status, Long id) {
        super();
        this.status = status;
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}