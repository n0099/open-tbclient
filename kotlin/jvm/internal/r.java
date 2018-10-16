package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String esP;
    private final Class<?> ipw;

    public r(Class<?> cls, String str) {
        p.i(cls, "jClass");
        p.i(str, "moduleName");
        this.ipw = cls;
        this.esP = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> caj() {
        return this.ipw;
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
