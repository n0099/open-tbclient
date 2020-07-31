package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String iJI;
    private final Class<?> nYA;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.nYA = cls;
        this.iJI = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dUe() {
        return this.nYA;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(dUe(), ((s) obj).dUe());
    }

    public int hashCode() {
        return dUe().hashCode();
    }

    public String toString() {
        return dUe().toString() + " (Kotlin reflection is not available)";
    }
}
