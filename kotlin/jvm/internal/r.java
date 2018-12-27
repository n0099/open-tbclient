package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String eDU;
    private final Class<?> iBB;

    public r(Class<?> cls, String str) {
        p.j(cls, "jClass");
        p.j(str, "moduleName");
        this.iBB = cls;
        this.eDU = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> ccC() {
        return this.iBB;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(ccC(), ((r) obj).ccC());
    }

    public int hashCode() {
        return ccC().hashCode();
    }

    public String toString() {
        return ccC().toString() + " (Kotlin reflection is not available)";
    }
}
