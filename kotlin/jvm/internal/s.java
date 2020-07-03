package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String iDE;
    private final Class<?> nPO;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.nPO = cls;
        this.iDE = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dQE() {
        return this.nPO;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(dQE(), ((s) obj).dQE());
    }

    public int hashCode() {
        return dQE().hashCode();
    }

    public String toString() {
        return dQE().toString() + " (Kotlin reflection is not available)";
    }
}
