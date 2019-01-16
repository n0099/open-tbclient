package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String eEG;
    private final Class<?> iCI;

    public r(Class<?> cls, String str) {
        p.j(cls, "jClass");
        p.j(str, "moduleName");
        this.iCI = cls;
        this.eEG = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cdk() {
        return this.iCI;
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
