package pojos;

public class WorkSpacePojo {
    String created;
    String description;
    String id;
    String lastModified;
    String name;
    String userId;

    public WorkSpacePojo() {
    }

    public WorkSpacePojo(String created, String description, String id, String lastModified, String name, String userId) {
        this.created = created;
        this.description = description;
        this.id = id;
        this.lastModified = lastModified;
        this.name = name;
        this.userId = userId;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
