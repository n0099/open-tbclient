package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.h
/* loaded from: classes9.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> pUi;

    public m(Class<?> cls) {
        q.n(cls, "jClass");
        this.pUi = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eBO() {
        return this.pUi;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        eBP();
        throw null;
    }

    private final Void eBP() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && q.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return eBO().toString() + " (Kotlin reflection is not available)";
    }
}
