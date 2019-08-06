package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type kpy;
    final Class<? super T> kqL;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.kpy = D(getClass());
        this.kqL = (Class<? super T>) C$Gson$Types.g(this.kpy);
        this.hashCode = this.kpy.hashCode();
    }

    a(Type type) {
        this.kpy = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kqL = (Class<? super T>) C$Gson$Types.g(this.kpy);
        this.hashCode = this.kpy.hashCode();
    }

    static Type D(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cMT() {
        return this.kqL;
    }

    public final Type cMU() {
        return this.kpy;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.kpy, ((a) obj).kpy);
    }

    public final String toString() {
        return C$Gson$Types.h(this.kpy);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> E(Class<T> cls) {
        return new a<>(cls);
    }
}
