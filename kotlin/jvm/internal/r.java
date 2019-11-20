package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String grT;
    private final Class<?> kvj;

    public r(Class<?> cls, String str) {
        p.i(cls, "jClass");
        p.i(str, "moduleName");
        this.kvj = cls;
        this.grT = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cMU() {
        return this.kvj;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.f(cMU(), ((r) obj).cMU());
    }

    public int hashCode() {
        return cMU().hashCode();
    }

    public String toString() {
        return cMU().toString() + " (Kotlin reflection is not available)";
    }
}
