package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String ilP;
    private final Class<?> nsR;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.nsR = cls;
        this.ilP = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dLK() {
        return this.nsR;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(dLK(), ((s) obj).dLK());
    }

    public int hashCode() {
        return dLK().hashCode();
    }

    public String toString() {
        return dLK().toString() + " (Kotlin reflection is not available)";
    }
}
