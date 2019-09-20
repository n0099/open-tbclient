package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String guN;
    private final Class<?> kvs;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.kvs = cls;
        this.guN = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cOP() {
        return this.kvs;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cOP(), ((r) obj).cOP());
    }

    public int hashCode() {
        return cOP().hashCode();
    }

    public String toString() {
        return cOP().toString() + " (Kotlin reflection is not available)";
    }
}
