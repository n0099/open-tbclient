package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String eEH;
    private final Class<?> iCJ;

    public r(Class<?> cls, String str) {
        p.j(cls, "jClass");
        p.j(str, "moduleName");
        this.iCJ = cls;
        this.eEH = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cdk() {
        return this.iCJ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cdk(), ((r) obj).cdk());
    }

    public int hashCode() {
        return cdk().hashCode();
    }

    public String toString() {
        return cdk().toString() + " (Kotlin reflection is not available)";
    }
}
