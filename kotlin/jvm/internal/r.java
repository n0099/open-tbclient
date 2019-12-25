package kotlin.jvm.internal;
/* loaded from: classes4.dex */
public final class r implements l {
    private final String hfW;
    private final Class<?> mZe;

    public r(Class<?> cls, String str) {
        p.j(cls, "jClass");
        p.j(str, "moduleName");
        this.mZe = cls;
        this.hfW = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dEP() {
        return this.mZe;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(dEP(), ((r) obj).dEP());
    }

    public int hashCode() {
        return dEP().hashCode();
    }

    public String toString() {
        return dEP().toString() + " (Kotlin reflection is not available)";
    }
}
