package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String fUA;
    private final Class<?> jRY;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.jRY = cls;
        this.fUA = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cCr() {
        return this.jRY;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cCr(), ((r) obj).cCr());
    }

    public int hashCode() {
        return cCr().hashCode();
    }

    public String toString() {
        return cCr().toString() + " (Kotlin reflection is not available)";
    }
}
