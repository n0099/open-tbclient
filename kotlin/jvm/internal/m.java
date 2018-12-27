package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes2.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> iBB;

    public m(Class<?> cls) {
        p.j(cls, "jClass");
        this.iBB = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> ccC() {
        return this.iBB;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        ccD();
        throw null;
    }

    private final Void ccD() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.h(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return ccC().toString() + " (Kotlin reflection is not available)";
    }
}
