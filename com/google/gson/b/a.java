package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type kpq;
    final Class<? super T> kqD;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.kpq = B(getClass());
        this.kqD = (Class<? super T>) C$Gson$Types.g(this.kpq);
        this.hashCode = this.kpq.hashCode();
    }

    a(Type type) {
        this.kpq = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kqD = (Class<? super T>) C$Gson$Types.g(this.kpq);
        this.hashCode = this.kpq.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cKC() {
        return this.kqD;
    }

    public final Type cKD() {
        return this.kpq;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.kpq, ((a) obj).kpq);
    }

    public final String toString() {
        return C$Gson$Types.h(this.kpq);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
