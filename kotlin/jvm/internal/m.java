package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes2.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> krT;

    public m(Class<?> cls) {
        p.k(cls, "jClass");
        this.krT = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cNI() {
        return this.krT;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        cNJ();
        throw null;
    }

    private final Void cNJ() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.h(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return cNI().toString() + " (Kotlin reflection is not available)";
    }
}
