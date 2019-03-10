package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String fUN;
    private final Class<?> jSN;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.jSN = cls;
        this.fUN = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cCz() {
        return this.jSN;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cCz(), ((r) obj).cCz());
    }

    public int hashCode() {
        return cCz().hashCode();
    }

    public String toString() {
        return cCz().toString() + " (Kotlin reflection is not available)";
    }
}
