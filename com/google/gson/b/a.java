package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type inP;
    final Class<? super T> ipd;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.inP = A(getClass());
        this.ipd = (Class<? super T>) C$Gson$Types.g(this.inP);
        this.hashCode = this.inP.hashCode();
    }

    a(Type type) {
        this.inP = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.ipd = (Class<? super T>) C$Gson$Types.g(this.inP);
        this.hashCode = this.inP.hashCode();
    }

    static Type A(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bYN() {
        return this.ipd;
    }

    public final Type bYO() {
        return this.inP;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.inP, ((a) obj).inP);
    }

    public final String toString() {
        return C$Gson$Types.h(this.inP);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> B(Class<T> cls) {
        return new a<>(cls);
    }
}
