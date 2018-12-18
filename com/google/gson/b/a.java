package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type iuZ;
    final Class<? super T> iwn;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.iuZ = B(getClass());
        this.iwn = (Class<? super T>) C$Gson$Types.g(this.iuZ);
        this.hashCode = this.iuZ.hashCode();
    }

    a(Type type) {
        this.iuZ = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.iwn = (Class<? super T>) C$Gson$Types.g(this.iuZ);
        this.hashCode = this.iuZ.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> caS() {
        return this.iwn;
    }

    public final Type caT() {
        return this.iuZ;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.iuZ, ((a) obj).iuZ);
    }

    public final String toString() {
        return C$Gson$Types.h(this.iuZ);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
