package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String euk;
    private final Class<?> irh;

    public r(Class<?> cls, String str) {
        p.h((Object) cls, "jClass");
        p.h((Object) str, "moduleName");
        this.irh = cls;
        this.euk = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> bZG() {
        return this.irh;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(bZG(), ((r) obj).bZG());
    }

    public int hashCode() {
        return bZG().hashCode();
    }

    public String toString() {
        return bZG().toString() + " (Kotlin reflection is not available)";
    }
}
