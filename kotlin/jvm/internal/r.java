package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String eBd;
    private final Class<?> iyr;

    public r(Class<?> cls, String str) {
        p.h((Object) cls, "jClass");
        p.h((Object) str, "moduleName");
        this.iyr = cls;
        this.eBd = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cbM() {
        return this.iyr;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cbM(), ((r) obj).cbM());
    }

    public int hashCode() {
        return cbM().hashCode();
    }

    public String toString() {
        return cbM().toString() + " (Kotlin reflection is not available)";
    }
}
