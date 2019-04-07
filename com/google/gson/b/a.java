package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type jOG;
    final Class<? super T> jPU;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.jOG = D(getClass());
        this.jPU = (Class<? super T>) C$Gson$Types.g(this.jOG);
        this.hashCode = this.jOG.hashCode();
    }

    a(Type type) {
        this.jOG = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.jPU = (Class<? super T>) C$Gson$Types.g(this.jOG);
        this.hashCode = this.jOG.hashCode();
    }

    static Type D(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cBC() {
        return this.jPU;
    }

    public final Type cBD() {
        return this.jOG;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.jOG, ((a) obj).jOG);
    }

    public final String toString() {
        return C$Gson$Types.h(this.jOG);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> E(Class<T> cls) {
        return new a<>(cls);
    }
}
