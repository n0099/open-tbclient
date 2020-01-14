package com.kascend.cstvsdk.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/* loaded from: classes4.dex */
public class ReflectHelper {
    protected Class<?> a;
    private Field c;
    private Method d;
    private Constructor njG;

    /* loaded from: classes4.dex */
    public static class ReflectedException extends Exception {
        private static final long serialVersionUID = -8758438429752863693L;

        public ReflectedException(String str) {
            super(str);
        }

        public ReflectedException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static ReflectHelper K(@NonNull Class<?> cls) {
        ReflectHelper reflectHelper = new ReflectHelper();
        reflectHelper.a = cls;
        return reflectHelper;
    }

    private ReflectHelper() {
    }

    private Object a(@Nullable Object obj) throws ReflectedException {
        if (obj == null || this.a.isInstance(obj)) {
            return obj;
        }
        throw new ReflectedException("Caller [" + obj + "] is not a instance of type [" + this.a + "]!");
    }

    private void a(@Nullable Object obj, @Nullable Member member, @NonNull String str) throws ReflectedException {
        if (member == null) {
            throw new ReflectedException(str + " was null!");
        }
        if (obj == null && !Modifier.isStatic(member.getModifiers())) {
            throw new ReflectedException("Need a caller!");
        }
        a(obj);
    }

    public ReflectHelper QQ(@NonNull String str) throws ReflectedException {
        try {
            this.c = QR(str);
            this.c.setAccessible(true);
            this.njG = null;
            this.d = null;
            return this;
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }

    private Field QR(@NonNull String str) throws NoSuchFieldException {
        try {
            return this.a.getField(str);
        } catch (NoSuchFieldException e) {
            e = e;
            for (Class<?> cls = this.a; cls != null; cls = cls.getSuperclass()) {
                try {
                    return cls.getDeclaredField(str);
                } catch (NoSuchFieldException e2) {
                }
            }
            throw e;
        }
    }

    public ReflectHelper i(@Nullable Object obj, @Nullable Object obj2) throws ReflectedException {
        a(obj, this.c, "Field");
        try {
            this.c.set(obj, obj2);
            return this;
        } catch (Throwable th) {
            throw new ReflectedException("Oops!", th);
        }
    }
}
