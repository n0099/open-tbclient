package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes7.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> nYA;

    public m(Class<?> cls) {
        q.m(cls, "jClass");
        this.nYA = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dUe() {
        return this.nYA;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        dUf();
        throw null;
    }

    private final Void dUf() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return dUe().toString() + " (Kotlin reflection is not available)";
    }
}
