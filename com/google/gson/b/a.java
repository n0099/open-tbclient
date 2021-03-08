package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes4.dex */
public class a<T> {
    final int hashCode;
    final Class<? super T> pWk;
    final Type type;

    protected a() {
        this.type = B(getClass());
        this.pWk = (Class<? super T>) C$Gson$Types.m(this.type);
        this.hashCode = this.type.hashCode();
    }

    a(Type type) {
        this.type = C$Gson$Types.l((Type) com.google.gson.internal.a.checkNotNull(type));
        this.pWk = (Class<? super T>) C$Gson$Types.m(this.type);
        this.hashCode = this.type.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.l(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> eCa() {
        return this.pWk;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.b(this.type, ((a) obj).type);
    }

    public final String toString() {
        return C$Gson$Types.n(this.type);
    }

    public static a<?> r(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
