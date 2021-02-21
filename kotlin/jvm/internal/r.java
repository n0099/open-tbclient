package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes6.dex */
public final class r implements l {
    private final String kug;
    private final Class<?> qtS;

    public r(Class<?> cls, String str) {
        p.o(cls, "jClass");
        p.o(str, "moduleName");
        this.qtS = cls;
        this.kug = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eLs() {
        return this.qtS;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eLs(), ((r) obj).eLs());
    }

    public int hashCode() {
        return eLs().hashCode();
    }

    public String toString() {
        return eLs().toString() + " (Kotlin reflection is not available)";
    }
}
