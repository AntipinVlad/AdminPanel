package programfirebase.comdasd.example.javad.adminpanel;

/**
 * Created by javad on 07.06.2018.
 */

public class NoteModel {

    public String noteTitle;
    public String noteTime;
    public String noteLink;

    public NoteModel() {

    }

    public NoteModel(String noteTitle, String noteTime, String noteLink) {
        this.noteTitle = noteTitle;
        this.noteTime = noteTime;
        this.noteLink = noteLink;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(String noteTime) {
        this.noteTime = noteTime;
    }

    public String getNoteLink() {
        return noteLink;
    }

    public void setNoteLink(String noteLink) {this.noteTime = noteLink; }
}
