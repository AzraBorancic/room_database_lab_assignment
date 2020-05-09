package ibu.edu.ba.roomdatabaselab;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "todos")
public class Todo { //todo_tasks
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String title;
    private String description;

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Ignore
    public Todo(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
