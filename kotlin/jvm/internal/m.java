package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes10.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> pJl;

    public m(Class<?> cls) {
        q.n(cls, "jClass");
        this.pJl = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> exY() {
        return this.pJl;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        exZ();
        throw null;
    }

    private final Void exZ() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return exY().toString() + " (Kotlin reflection is not available)";
    }
}
