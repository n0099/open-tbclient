package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes7.dex */
public final class s implements l {
    private final String hlA;
    private final Class<?> nCn;

    public s(Class<?> cls, String str) {
        q.j(cls, "jClass");
        q.j(str, "moduleName");
        this.nCn = cls;
        this.hlA = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dKr() {
        return this.nCn;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.h(dKr(), ((s) obj).dKr());
    }

    public int hashCode() {
        return dKr().hashCode();
    }

    public String toString() {
        return dKr().toString() + " (Kotlin reflection is not available)";
    }
}
