package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type imc;
    final Class<? super T> inr;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.imc = A(getClass());
        this.inr = (Class<? super T>) C$Gson$Types.g(this.imc);
        this.hashCode = this.imc.hashCode();
    }

    a(Type type) {
        this.imc = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.inr = (Class<? super T>) C$Gson$Types.g(this.imc);
        this.hashCode = this.imc.hashCode();
    }

    static Type A(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bZq() {
        return this.inr;
    }

    public final Type bZr() {
        return this.imc;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.imc, ((a) obj).imc);
    }

    public final String toString() {
        return C$Gson$Types.h(this.imc);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> B(Class<T> cls) {
        return new a<>(cls);
    }
}
