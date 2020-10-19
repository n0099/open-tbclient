package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes10.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> oRO;

    public m(Class<?> cls) {
        q.n(cls, "jClass");
        this.oRO = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> enZ() {
        return this.oRO;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        eoa();
        throw null;
    }

    private final Void eoa() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return enZ().toString() + " (Kotlin reflection is not available)";
    }
}
