package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes20.dex */
public final class s implements l {
    private final String iYO;
    private final Class<?> osS;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.osS = cls;
        this.iYO = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> egq() {
        return this.osS;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(egq(), ((s) obj).egq());
    }

    public int hashCode() {
        return egq().hashCode();
    }

    public String toString() {
        return egq().toString() + " (Kotlin reflection is not available)";
    }
}
