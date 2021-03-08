package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes14.dex */
public final class r implements l {
    private final String kwi;
    private final Class<?> quu;

    public r(Class<?> cls, String str) {
        p.p(cls, "jClass");
        p.p(str, "moduleName");
        this.quu = cls;
        this.kwi = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eLa() {
        return this.quu;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eLa(), ((r) obj).eLa());
    }

    public int hashCode() {
        return eLa().hashCode();
    }

    public String toString() {
        return eLa().toString() + " (Kotlin reflection is not available)";
    }
}
