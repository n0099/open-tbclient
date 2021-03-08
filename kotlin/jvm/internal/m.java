package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.e
/* loaded from: classes14.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> quu;

    public m(Class<?> cls) {
        p.p(cls, "jClass");
        this.quu = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eLa() {
        return this.quu;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        eLb();
        throw null;
    }

    private final Void eLb() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return eLa().toString() + " (Kotlin reflection is not available)";
    }
}
