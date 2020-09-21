package kotlin.jvm.internal;
@kotlin.h
/* loaded from: classes5.dex */
public final class s implements l {
    private final String jht;
    private final Class<?> oCz;

    public s(Class<?> cls, String str) {
        q.m(cls, "jClass");
        q.m(str, "moduleName");
        this.oCz = cls;
        this.jht = str;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> ekn() {
        return this.oCz;
    }

    public boolean equals(Object obj) {
        return (obj instanceof s) && q.l(ekn(), ((s) obj).ekn());
    }

    public int hashCode() {
        return ekn().hashCode();
    }

    public String toString() {
        return ekn().toString() + " (Kotlin reflection is not available)";
    }
}
