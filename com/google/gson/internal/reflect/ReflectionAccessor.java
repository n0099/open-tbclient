package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;
/* loaded from: classes10.dex */
public abstract class ReflectionAccessor {
    public static final ReflectionAccessor instance;

    public abstract void makeAccessible(AccessibleObject accessibleObject);

    static {
        ReflectionAccessor unsafeReflectionAccessor;
        if (JavaVersion.getMajorJavaVersion() < 9) {
            unsafeReflectionAccessor = new PreJava9ReflectionAccessor();
        } else {
            unsafeReflectionAccessor = new UnsafeReflectionAccessor();
        }
        instance = unsafeReflectionAccessor;
    }

    public static ReflectionAccessor getInstance() {
        return instance;
    }
}
