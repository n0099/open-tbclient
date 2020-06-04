package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String imD;
    private final Class<?> nub;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.nub = cls;
        this.imD = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dLY() {
        return this.nub;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(dLY(), ((s) obj).dLY());
    }

    public int hashCode() {
        return dLY().hashCode();
    }

    public String toString() {
        return dLY().toString() + " (Kotlin reflection is not available)";
    }
}
