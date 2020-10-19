package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes10.dex */
public final class s implements l {
    private final String jws;
    private final Class<?> oRO;

    public s(Class<?> cls, String str) {
        q.n(cls, "jClass");
        q.n(str, "moduleName");
        this.oRO = cls;
        this.jws = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> enZ() {
        return this.oRO;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(enZ(), ((s) obj).enZ());
    }

    public int hashCode() {
        return enZ().hashCode();
    }

    public String toString() {
        return enZ().toString() + " (Kotlin reflection is not available)";
    }
}
