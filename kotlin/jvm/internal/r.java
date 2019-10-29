package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String gsK;
    private final Class<?> kwa;

    public r(Class<?> cls, String str) {
        p.i(cls, "jClass");
        p.i(str, "moduleName");
        this.kwa = cls;
        this.gsK = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cMW() {
        return this.kwa;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.f(cMW(), ((r) obj).cMW());
    }

    public int hashCode() {
        return cMW().hashCode();
    }

    public String toString() {
        return cMW().toString() + " (Kotlin reflection is not available)";
    }
}
