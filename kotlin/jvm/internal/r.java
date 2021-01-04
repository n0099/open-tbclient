package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes5.dex */
public final class r implements l {
    private final String kqq;
    private final Class<?> qmh;

    public r(Class<?> cls, String str) {
        p.o(cls, "jClass");
        p.o(str, "moduleName");
        this.qmh = cls;
        this.kqq = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eMg() {
        return this.qmh;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eMg(), ((r) obj).eMg());
    }

    public int hashCode() {
        return eMg().hashCode();
    }

    public String toString() {
        return eMg().toString() + " (Kotlin reflection is not available)";
    }
}
