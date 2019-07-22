package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type kos;
    final Class<? super T> kpF;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.kos = D(getClass());
        this.kpF = (Class<? super T>) C$Gson$Types.g(this.kos);
        this.hashCode = this.kos.hashCode();
    }

    a(Type type) {
        this.kos = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kpF = (Class<? super T>) C$Gson$Types.g(this.kos);
        this.hashCode = this.kos.hashCode();
    }

    static Type D(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cMy() {
        return this.kpF;
    }

    public final Type cMz() {
        return this.kos;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.kos, ((a) obj).kos);
    }

    public final String toString() {
        return C$Gson$Types.h(this.kos);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> E(Class<T> cls) {
        return new a<>(cls);
    }
}
