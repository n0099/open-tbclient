package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes7.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> nPO;

    public m(Class<?> cls) {
        q.m(cls, "jClass");
        this.nPO = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dQE() {
        return this.nPO;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        dQF();
        throw null;
    }

    private final Void dQF() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return dQE().toString() + " (Kotlin reflection is not available)";
    }
}
