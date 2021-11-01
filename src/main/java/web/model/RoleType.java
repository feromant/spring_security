package web.model;

public enum RoleType {
    ADMIN("ADMIN"),
    USER("USER");

    public static final RoleType[] ALL = { ADMIN, USER };

    String roleType;

    RoleType(String roleType) { this.roleType = roleType; }

    public String getRoleType() { return roleType; }
}
