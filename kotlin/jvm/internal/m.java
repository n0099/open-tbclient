package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes5.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> nBL;

    public m(Class<?> cls) {
        q.j(cls, "jClass");
        this.nBL = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> dJk() {
        return this.nBL;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        dJl();
        throw null;
    }

    private final Void dJl() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.h(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return dJk().toString() + " (Kotlin reflection is not available)";
    }
}
