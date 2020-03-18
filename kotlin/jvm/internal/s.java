package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String hno;
    private final Class<?> nEn;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.nEn = cls;
        this.hno = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dKU() {
        return this.nEn;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.h(dKU(), ((s) obj).dKU());
    }

    public int hashCode() {
        return dKU().hashCode();
    }

    public String toString() {
        return dKU().toString() + " (Kotlin reflection is not available)";
    }
}
