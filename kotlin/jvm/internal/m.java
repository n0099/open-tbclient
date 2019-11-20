package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes2.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> kvj;

    public m(Class<?> cls) {
        p.i(cls, "jClass");
        this.kvj = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cMU() {
        return this.kvj;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        cMV();
        throw null;
    }

    private final Void cMV() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.f(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return cMU().toString() + " (Kotlin reflection is not available)";
    }
}
