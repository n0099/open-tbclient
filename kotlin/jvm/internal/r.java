package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String gse;
    private final Class<?> krT;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.krT = cls;
        this.gse = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cNI() {
        return this.krT;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cNI(), ((r) obj).cNI());
    }

    public int hashCode() {
        return cNI().hashCode();
    }

    public String toString() {
        return cNI().toString() + " (Kotlin reflection is not available)";
    }
}
