package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type kqh;
    final Class<? super T> kru;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.kqh = B(getClass());
        this.kru = (Class<? super T>) C$Gson$Types.g(this.kqh);
        this.hashCode = this.kqh.hashCode();
    }

    a(Type type) {
        this.kqh = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kru = (Class<? super T>) C$Gson$Types.g(this.kqh);
        this.hashCode = this.kqh.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cKE() {
        return this.kru;
    }

    public final Type cKF() {
        return this.kqh;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.kqh, ((a) obj).kqh);
    }

    public final String toString() {
        return C$Gson$Types.h(this.kqh);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
