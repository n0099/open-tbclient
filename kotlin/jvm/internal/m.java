package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes7.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> nYC;

    public m(Class<?> cls) {
        q.m(cls, "jClass");
        this.nYC = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dUf() {
        return this.nYC;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        dUg();
        throw null;
    }

    private final Void dUg() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return dUf().toString() + " (Kotlin reflection is not available)";
    }
}
