package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String hXd;
    private final Class<?> mXP;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.mXP = cls;
        this.hXd = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dDQ() {
        return this.mXP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.k(dDQ(), ((s) obj).dDQ());
    }

    public int hashCode() {
        return dDQ().hashCode();
    }

    public String toString() {
        return dDQ().toString() + " (Kotlin reflection is not available)";
    }
}
