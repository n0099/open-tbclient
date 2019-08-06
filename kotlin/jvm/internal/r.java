package kotlin.jvm.internal;
/* loaded from: classes2.dex */
public final class r implements l {
    private final String gsW;
    private final Class<?> ksZ;

    public r(Class<?> cls, String str) {
        p.k(cls, "jClass");
        p.k(str, "moduleName");
        this.ksZ = cls;
        this.gsW = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cOd() {
        return this.ksZ;
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && p.h(cOd(), ((r) obj).cOd());
    }

    public int hashCode() {
        return cOd().hashCode();
    }

    public String toString() {
        return cOd().toString() + " (Kotlin reflection is not available)";
    }
}
