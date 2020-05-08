package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes7.dex */
public class a<T> {
    final int hashCode;
    final Class<? super T> mlR;
    final Type type;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.type = I(getClass());
        this.mlR = (Class<? super T>) C$Gson$Types.f(this.type);
        this.hashCode = this.type.hashCode();
    }

    a(Type type) {
        this.type = C$Gson$Types.e((Type) com.google.gson.internal.a.checkNotNull(type));
        this.mlR = (Class<? super T>) C$Gson$Types.f(this.type);
        this.hashCode = this.type.hashCode();
    }

    static Type I(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.e(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> dvZ() {
        return this.mlR;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.type, ((a) obj).type);
    }

    public final String toString() {
        return C$Gson$Types.g(this.type);
    }

    public static a<?> k(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> J(Class<T> cls) {
        return new a<>(cls);
    }
}
