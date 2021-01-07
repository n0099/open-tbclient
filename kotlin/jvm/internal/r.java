package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes5.dex */
public final class r implements l {
    private final String kqq;
    private final Class<?> qnP;

    public r(Class<?> cls, String str) {
        p.o(cls, "jClass");
        p.o(str, "moduleName");
        this.qnP = cls;
        this.kqq = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eMK() {
        return this.qnP;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eMK(), ((r) obj).eMK());
    }

    public int hashCode() {
        return eMK().hashCode();
    }

    public String toString() {
        return eMK().toString() + " (Kotlin reflection is not available)";
    }
}
