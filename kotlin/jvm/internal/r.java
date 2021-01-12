package kotlin.jvm.internal;
@kotlin.e
/* loaded from: classes5.dex */
public final class r implements l {
    private final String klL;
    private final Class<?> qjn;

    public r(Class<?> cls, String str) {
        p.o(cls, "jClass");
        p.o(str, "moduleName");
        this.qjn = cls;
        this.klL = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eIU() {
        return this.qjn;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.l(eIU(), ((r) obj).eIU());
    }

    public int hashCode() {
        return eIU().hashCode();
    }

    public String toString() {
        return eIU().toString() + " (Kotlin reflection is not available)";
    }
}
