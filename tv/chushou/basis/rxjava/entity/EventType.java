package tv.chushou.basis.rxjava.entity;
/* loaded from: classes4.dex */
public class EventType {
    private final Class<?> clazz;
    private final int hashCode;
    private final String tag;

    public EventType(String str, Class<?> cls) {
        if (str == null) {
            throw new NullPointerException("EventType Tag cannot be null.");
        }
        if (cls == null) {
            throw new NullPointerException("EventType Clazz cannot be null.");
        }
        this.tag = str;
        this.clazz = cls;
        this.hashCode = ((str.hashCode() + 31) * 31) + cls.hashCode();
    }

    public String toString() {
        return "[EventType " + this.tag + " && " + this.clazz + "]";
    }

    public int hashCode() {
        return this.hashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            EventType eventType = (EventType) obj;
            return this.tag.equals(eventType.tag) && this.clazz == eventType.clazz;
        }
        return false;
    }
}
