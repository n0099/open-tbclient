package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String esQ;
    private final Class<?> ipx;

    public r(Class<?> cls, String str) {
        p.i(cls, "jClass");
        p.i(str, "moduleName");
        this.ipx = cls;
        this.esQ = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> caj() {
        return this.ipx;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(caj(), ((r) obj).caj());
    }

    public int hashCode() {
        return caj().hashCode();
    }

    public String toString() {
        return caj().toString() + " (Kotlin reflection is not available)";
    }
}
