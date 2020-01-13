package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes5.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> nBG;

    public m(Class<?> cls) {
        q.j(cls, "jClass");
        this.nBG = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dJi() {
        return this.nBG;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        dJj();
        throw null;
    }

    private final Void dJj() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.h(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return dJi().toString() + " (Kotlin reflection is not available)";
    }
}
