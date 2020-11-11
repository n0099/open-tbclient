package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes10.dex */
public final class s implements l {
    private final String jOP;
    private final Class<?> pSF;

    public s(Class<?> cls, String str) {
        q.n(cls, "jClass");
        q.n(str, "moduleName");
        this.pSF = cls;
        this.jOP = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eBN() {
        return this.pSF;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(eBN(), ((s) obj).eBN());
    }

    public int hashCode() {
        return eBN().hashCode();
    }

    public String toString() {
        return eBN().toString() + " (Kotlin reflection is not available)";
    }
}
