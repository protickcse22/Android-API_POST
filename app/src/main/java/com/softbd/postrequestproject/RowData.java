package com.softbd.postrequestproject;

public class RowData {
    private Integer id;
    private String title;
    private String clues;


    public RowData(Integer id, String title, String clues) {
        this.id = id;
        this.title = title;
        this.clues = clues;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClues() {
        return clues;
    }

    public void setClues(String clues) {
        this.clues = clues;
    }
}
