package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type khm;
    final Class<? super T> kiA;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.khm = B(getClass());
        this.kiA = (Class<? super T>) C$Gson$Types.g(this.khm);
        this.hashCode = this.khm.hashCode();
    }

    a(Type type) {
        this.khm = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kiA = (Class<? super T>) C$Gson$Types.g(this.khm);
        this.hashCode = this.khm.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cJs() {
        return this.kiA;
    }

    public final Type cJt() {
        return this.khm;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.khm, ((a) obj).khm);
    }

    public final String toString() {
        return C$Gson$Types.h(this.khm);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
