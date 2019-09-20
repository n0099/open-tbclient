package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type krV;
    final Class<? super T> kti;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.krV = D(getClass());
        this.kti = (Class<? super T>) C$Gson$Types.g(this.krV);
        this.hashCode = this.krV.hashCode();
    }

    a(Type type) {
        this.krV = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kti = (Class<? super T>) C$Gson$Types.g(this.krV);
        this.hashCode = this.krV.hashCode();
    }

    static Type D(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cNH() {
        return this.kti;
    }

    public final Type cNI() {
        return this.krV;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.krV, ((a) obj).krV);
    }

    public final String toString() {
        return C$Gson$Types.h(this.krV);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> E(Class<T> cls) {
        return new a<>(cls);
    }
}
