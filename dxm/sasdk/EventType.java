package dxm.sasdk;
/* loaded from: classes7.dex */
public enum EventType {
    TRACK("track", true, false),
    TRACK_SIGNUP("track_signup", true, false),
    PROFILE_SET("profile_set", false, true),
    PROFILE_SET_ONCE("profile_set_once", false, true),
    PROFILE_UNSET("profile_unset", false, true),
    PROFILE_INCREMENT("profile_increment", false, true),
    PROFILE_APPEND("profile_append", false, true),
    PROFILE_DELETE("profile_delete", false, true),
    REGISTER_SUPER_PROPERTIES("register_super_properties", false, false);
    
    public String eventType;
    public boolean profile;
    public boolean track;

    EventType(String str, boolean z, boolean z2) {
        this.eventType = str;
        this.track = z;
        this.profile = z2;
    }

    public String getEventType() {
        return this.eventType;
    }

    public boolean isProfile() {
        return this.profile;
    }

    public boolean isTrack() {
        return this.track;
    }
}
