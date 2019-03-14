package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String fUM;
    private final Class<?> jSF;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.jSF = cls;
        this.fUM = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cCC() {
        return this.jSF;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cCC(), ((r) obj).cCC());
    }

    public int hashCode() {
        return cCC().hashCode();
    }

    public String toString() {
        return cCC().toString() + " (Kotlin reflection is not available)";
    }
}
