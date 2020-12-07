package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes17.dex */
public final class r implements l {
    private final String kdc;
    private final Class<?> pKC;

    public r(Class<?> cls, String str) {
        p.o(cls, "jClass");
        p.o(str, "moduleName");
        this.pKC = cls;
        this.kdc = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eDX() {
        return this.pKC;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eDX(), ((r) obj).eDX());
    }

    public int hashCode() {
        return eDX().hashCode();
    }

    public String toString() {
        return eDX().toString() + " (Kotlin reflection is not available)";
    }
}
