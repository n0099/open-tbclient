package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes4.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> mZe;

    public m(Class<?> cls) {
        p.j(cls, "jClass");
        this.mZe = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dEP() {
        return this.mZe;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        dEQ();
        throw null;
    }

    private final Void dEQ() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.h(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return dEP().toString() + " (Kotlin reflection is not available)";
    }
}
