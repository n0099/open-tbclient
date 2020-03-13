package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String hlO;
    private final Class<?> nCA;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.nCA = cls;
        this.hlO = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dKu() {
        return this.nCA;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.h(dKu(), ((s) obj).dKu());
    }

    public int hashCode() {
        return dKu().hashCode();
    }

    public String toString() {
        return dKu().toString() + " (Kotlin reflection is not available)";
    }
}
