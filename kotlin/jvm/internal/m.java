package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes10.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> pSF;

    public m(Class<?> cls) {
        q.n(cls, "jClass");
        this.pSF = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eBN() {
        return this.pSF;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        eBO();
        throw null;
    }

    private final Void eBO() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return eBN().toString() + " (Kotlin reflection is not available)";
    }
}
