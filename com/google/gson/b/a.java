package com.google.gson.b;

import com.google.gson.internal.C$Gson$Types;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes2.dex */
public class a<T> {
    final int hashCode;
    final Class<? super T> iAF;
    final Type izr;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        this.izr = B(getClass());
        this.iAF = (Class<? super T>) C$Gson$Types.g(this.izr);
        this.hashCode = this.izr.hashCode();
    }

    a(Type type) {
        this.izr = C$Gson$Types.f((Type) com.google.gson.internal.a.checkNotNull(type));
        this.iAF = (Class<? super T>) C$Gson$Types.g(this.izr);
        this.hashCode = this.izr.hashCode();
    }

    static Type B(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return C$Gson$Types.f(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final Class<? super T> ccr() {
        return this.iAF;
    }

    public final Type ccs() {
        return this.izr;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && C$Gson$Types.a(this.izr, ((a) obj).izr);
    }

    public final String toString() {
        return C$Gson$Types.h(this.izr);
    }

    public static a<?> l(Type type) {
        return new a<>(type);
    }

    public static <T> a<T> C(Class<T> cls) {
        return new a<>(cls);
    }
}
