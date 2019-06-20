package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String glR;
    private final Class<?> kku;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.kku = cls;
        this.glR = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cJY() {
        return this.kku;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cJY(), ((r) obj).cJY());
    }

    public int hashCode() {
        return cJY().hashCode();
    }

    public String toString() {
        return cJY().toString() + " (Kotlin reflection is not available)";
    }
}
