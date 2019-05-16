package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String glO;
    private final Class<?> kkq;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.kkq = cls;
        this.glO = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cJX() {
        return this.kkq;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cJX(), ((r) obj).cJX());
    }

    public int hashCode() {
        return cJX().hashCode();
    }

    public String toString() {
        return cJX().toString() + " (Kotlin reflection is not available)";
    }
}
