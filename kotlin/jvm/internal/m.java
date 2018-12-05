package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.KotlinReflectionNotSupportedError;
/* loaded from: classes2.dex */
public final class m implements l, kotlin.reflect.c<Object> {
    private final Class<?> iyr;

    public m(Class<?> cls) {
        p.h((Object) cls, "jClass");
        this.iyr = cls;
    }

    @Override // kotlin.jvm.internal.l
    public Class<?> cbM() {
        return this.iyr;
    }

    @Override // kotlin.reflect.a
    public List<Annotation> getAnnotations() {
        cbN();
        throw null;
    }

    private final Void cbN() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && p.h(kotlin.jvm.a.a(this), kotlin.jvm.a.a((kotlin.reflect.c) obj));
    }

    public int hashCode() {
        return kotlin.jvm.a.a(this).hashCode();
    }

    public String toString() {
        return cbM().toString() + " (Kotlin reflection is not available)";
    }
}
