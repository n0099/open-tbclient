package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes20.dex */
public final class s implements l {
    private final String iYI;
    private final Class<?> osA;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.osA = cls;
        this.iYI = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> egh() {
        return this.osA;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(egh(), ((s) obj).egh());
    }

    public int hashCode() {
        return egh().hashCode();
    }

    public String toString() {
        return egh().toString() + " (Kotlin reflection is not available)";
    }
}
