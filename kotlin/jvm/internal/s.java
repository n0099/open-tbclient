package kotlin.jvm.internal;
/* loaded from: classes5.dex */
public final class s implements l {
    private final String hjA;
    private final Class<?> nBG;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.nBG = cls;
        this.hjA = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dJi() {
        return this.nBG;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.h(dJi(), ((s) obj).dJi());
    }

    public int hashCode() {
        return dJi().hashCode();
    }

    public String toString() {
        return dJi().toString() + " (Kotlin reflection is not available)";
    }
}
