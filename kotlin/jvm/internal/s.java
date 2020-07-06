package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String iDE;
    private final Class<?> nPR;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.nPR = cls;
        this.iDE = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dQI() {
        return this.nPR;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(dQI(), ((s) obj).dQI());
    }

    public int hashCode() {
        return dQI().hashCode();
    }

    public String toString() {
        return dQI().toString() + " (Kotlin reflection is not available)";
    }
}
