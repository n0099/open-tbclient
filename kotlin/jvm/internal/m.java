package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
@kotlin.e
/* loaded from: classes17.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> pKE;

    public m(Class<?> cls) {
        p.o(cls, "jClass");
        this.pKE = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> eDY() {
        return this.pKE;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        eDZ();
        throw null;
    }

    private final Void eDZ() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.l(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return eDY().toString() + " (Kotlin reflection is not available)";
    }
}
