package com.softbd.postrequestproject;

import com.google.gson.annotations.SerializedName;

public class PostData {

    @SerializedName("user_id")
    private Integer userId;

    private Integer eiin;

    @SerializedName("class_id")
    private Integer classId;

    @SerializedName("subject_id")
    private Integer subjectId;


    public PostData(Integer userId, Integer eiin, Integer classId, Integer subjectId) {
        this.userId = userId;
        this.eiin = eiin;
        this.classId = classId;
        this.subjectId = subjectId;
    }

    public Integer getUserId() {
        return userId;
    }


    public Integer getEiin() {
        return eiin;
    }


    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

}
