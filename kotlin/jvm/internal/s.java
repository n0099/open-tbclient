package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String hWX;
    private final Class<?> mXM;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.mXM = cls;
        this.hWX = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dDT() {
        return this.mXM;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.k(dDT(), ((s) obj).dDT());
    }

    public int hashCode() {
        return dDT().hashCode();
    }

    public String toString() {
        return dDT().toString() + " (Kotlin reflection is not available)";
    }
}
