package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type khj;
    final Class<? super T> kix;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.khj = B(getClass());
        this.kix = (Class<? super T>) C$Gson$Types.g(this.khj);
        this.hashCode = this.khj.hashCode();
    }

    a(Type type) {
        this.khj = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.kix = (Class<? super T>) C$Gson$Types.g(this.khj);
        this.hashCode = this.khj.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> cJt() {
        return this.kix;
    }

    public final Type cJu() {
        return this.khj;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.khj, ((a) obj).khj);
    }

    public final String toString() {
        return C$Gson$Types.h(this.khj);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
