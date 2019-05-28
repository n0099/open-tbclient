package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String glP;
    private final Class<?> kkr;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.kkr = cls;
        this.glP = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cJZ() {
        return this.kkr;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cJZ(), ((r) obj).cJZ());
    }

    public int hashCode() {
        return cJZ().hashCode();
    }

    public String toString() {
        return cJZ().toString() + " (Kotlin reflection is not available)";
    }
}
