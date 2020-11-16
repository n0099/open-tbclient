package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes9.dex */
public final class s implements l {
    private final String jPz;
    private final Class<?> pUi;

    public s(Class<?> cls, String str) {
        q.n(cls, "jClass");
        q.n(str, "moduleName");
        this.pUi = cls;
        this.jPz = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eBO() {
        return this.pUi;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(eBO(), ((s) obj).eBO());
    }

    public int hashCode() {
        return eBO().hashCode();
    }

    public String toString() {
        return eBO().toString() + " (Kotlin reflection is not available)";
    }
}
