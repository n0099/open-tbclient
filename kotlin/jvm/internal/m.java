package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.e
/* loaded from: classes6.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> qtS;

    public m(Class<?> cls) {
        p.o(cls, "jClass");
        this.qtS = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eLs() {
        return this.qtS;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        eLt();
        throw null;
    }

    private final Void eLt() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return eLs().toString() + " (Kotlin reflection is not available)";
    }
}
