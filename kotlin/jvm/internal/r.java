package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes17.dex */
public final class r implements l {
    private final String kde;
    private final Class<?> pKE;

    public r(Class<?> cls, String str) {
        p.o(cls, "jClass");
        p.o(str, "moduleName");
        this.pKE = cls;
        this.kde = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eDY() {
        return this.pKE;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eDY(), ((r) obj).eDY());
    }

    public int hashCode() {
        return eDY().hashCode();
    }

    public String toString() {
        return eDY().toString() + " (Kotlin reflection is not available)";
    }
}
