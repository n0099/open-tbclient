package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String fUM;
    private final Class<?> jSu;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.jSu = cls;
        this.fUM = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cCp() {
        return this.jSu;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cCp(), ((r) obj).cCp());
    }

    public int hashCode() {
        return cCp().hashCode();
    }

    public String toString() {
        return cCp().toString() + " (Kotlin reflection is not available)";
    }
}
