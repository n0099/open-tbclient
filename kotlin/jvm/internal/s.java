package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String hlC;
    private final Class<?> nCp;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.nCp = cls;
        this.hlC = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dKt() {
        return this.nCp;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.h(dKt(), ((s) obj).dKt());
    }

    public int hashCode() {
        return dKt().hashCode();
    }

    public String toString() {
        return dKt().toString() + " (Kotlin reflection is not available)";
    }
}
