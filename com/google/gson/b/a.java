package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Type imd;

    /* renamed from: int  reason: not valid java name */
    final Class<? super T> f0int;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.imd = A(getClass());
        this.f0int = (Class<? super T>) C$Gson$Types.g(this.imd);
        this.hashCode = this.imd.hashCode();
    }

    a(Type type) {
        this.imd = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.f0int = (Class<? super T>) C$Gson$Types.g(this.imd);
        this.hashCode = this.imd.hashCode();
    }

    static Type A(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> bZq() {
        return this.f0int;
    }

    public final Type bZr() {
        return this.imd;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.imd, ((a) obj).imd);
    }

    public final String toString() {
        return C$Gson$Types.h(this.imd);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> B(Class<T> cls) {
        return new a<>(cls);
    }
}
