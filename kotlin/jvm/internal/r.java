package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes6.dex */
public final class r implements l {
    private final String ktS;
    private final Class<?> qts;

    public r(Class<?> cls, String str) {
        p.o(cls, "jClass");
        p.o(str, "moduleName");
        this.qts = cls;
        this.ktS = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eLk() {
        return this.qts;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eLk(), ((r) obj).eLk());
    }

    public int hashCode() {
        return eLk().hashCode();
    }

    public String toString() {
        return eLk().toString() + " (Kotlin reflection is not available)";
    }
}
