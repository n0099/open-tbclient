package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Class<? super T> iAE;
    final Type izq;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.izq = B(getClass());
        this.iAE = (Class<? super T>) C$Gson$Types.g(this.izq);
        this.hashCode = this.izq.hashCode();
    }

    a(Type type) {
        this.izq = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.iAE = (Class<? super T>) C$Gson$Types.g(this.izq);
        this.hashCode = this.izq.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> ccr() {
        return this.iAE;
    }

    public final Type ccs() {
        return this.izq;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.izq, ((a) obj).izq);
    }

    public final String toString() {
        return C$Gson$Types.h(this.izq);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
