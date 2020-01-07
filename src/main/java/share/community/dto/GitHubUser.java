package share.community.dto;

import lombok.Data;

@Data
public class GitHubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;

    @Override
    public String toString() {
        return "GitHubUser [bio=" + bio + ", id=" + id + ", name=" + name + "]";
    }
}