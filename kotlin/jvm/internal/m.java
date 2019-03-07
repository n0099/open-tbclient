package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes2.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> jSu;

    public m(Class<?> cls) {
        p.k(cls, "jClass");
        this.jSu = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cCp() {
        return this.jSu;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        cCq();
        throw null;
    }

    private final Void cCq() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.h(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return cCp().toString() + " (Kotlin reflection is not available)";
    }
}
