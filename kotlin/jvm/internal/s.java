package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String iJK;
    private final Class<?> nYC;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.nYC = cls;
        this.iJK = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dUf() {
        return this.nYC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(dUf(), ((s) obj).dUf());
    }

    public int hashCode() {
        return dUf().hashCode();
    }

    public String toString() {
        return dUf().toString() + " (Kotlin reflection is not available)";
    }
}
