package share.community.model;

public class User {
    private Integer userId;
    private String name;
    private String accountId;
    private String Token;
    private Long gmtCreateTime;
    private Long gmtModifiedTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Long getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Long gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Long getGmtModifiedTime() {
        return gmtModifiedTime;
    }

    public void setGmtModifiedTime(Long gmtModifiedTime) {
        this.gmtModifiedTime = gmtModifiedTime;
    }
}
