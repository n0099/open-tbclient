package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type khi;
    final Class<? super T> kiw;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.khi = B(getClass());
        this.kiw = (Class<? super T>) C$Gson$Types.g(this.khi);
        this.hashCode = this.khi.hashCode();
    }

    a(Type type) {
        this.khi = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kiw = (Class<? super T>) C$Gson$Types.g(this.khi);
        this.hashCode = this.khi.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cJr() {
        return this.kiw;
    }

    public final Type cJs() {
        return this.khi;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.khi, ((a) obj).khi);
    }

    public final String toString() {
        return C$Gson$Types.h(this.khi);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
