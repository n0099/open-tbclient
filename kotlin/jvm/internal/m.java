package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes7.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> mXM;

    public m(Class<?> cls) {
        q.j(cls, "jClass");
        this.mXM = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dDT() {
        return this.mXM;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        dDU();
        throw null;
    }

    private final Void dDU() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.k(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return dDT().toString() + " (Kotlin reflection is not available)";
    }
}
