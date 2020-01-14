package kotlin.jvm.internal;
/* loaded from: classes5.dex */
public final class s implements l {
    private final String hjA;
    private final Class<?> nBL;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.nBL = cls;
        this.hjA = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dJk() {
        return this.nBL;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.h(dJk(), ((s) obj).dJk());
    }

    public int hashCode() {
        return dJk().hashCode();
    }

    public String toString() {
        return dJk().toString() + " (Kotlin reflection is not available)";
    }
}
