package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes10.dex */
public final class s implements l {
    private final String jIR;
    private final Class<?> pJl;

    public s(Class<?> cls, String str) {
        q.n(cls, "jClass");
        q.n(str, "moduleName");
        this.pJl = cls;
        this.jIR = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> exY() {
        return this.pJl;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(exY(), ((s) obj).exY());
    }

    public int hashCode() {
        return exY().hashCode();
    }

    public String toString() {
        return exY().toString() + " (Kotlin reflection is not available)";
    }
}
