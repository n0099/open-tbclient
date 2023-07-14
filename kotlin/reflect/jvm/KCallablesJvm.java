package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\",\u0010\u0003\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/reflect/KCallable;", "", "value", "isAccessible", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@JvmName(name = "KCallablesJvm")
/* loaded from: classes10.dex */
public final class KCallablesJvm {
    public static final boolean isAccessible(KCallable<?> kCallable) {
        boolean z;
        Object obj;
        boolean z2;
        boolean z3;
        Caller<?> defaultCaller;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field javaField = ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null) {
                z10 = javaField.isAccessible();
            } else {
                z10 = true;
            }
            if (!z10) {
                return false;
            }
            Method javaGetter = ReflectJvmMapping.getJavaGetter(kProperty);
            if (javaGetter != null) {
                z11 = javaGetter.isAccessible();
            } else {
                z11 = true;
            }
            if (!z11) {
                return false;
            }
            Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
            if (javaSetter != null) {
                z12 = javaSetter.isAccessible();
            } else {
                z12 = true;
            }
            if (!z12) {
                return false;
            }
        } else if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field javaField2 = ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null) {
                z8 = javaField2.isAccessible();
            } else {
                z8 = true;
            }
            if (!z8) {
                return false;
            }
            Method javaGetter2 = ReflectJvmMapping.getJavaGetter(kProperty2);
            if (javaGetter2 != null) {
                z9 = javaGetter2.isAccessible();
            } else {
                z9 = true;
            }
            if (!z9) {
                return false;
            }
        } else if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null) {
                z6 = javaField3.isAccessible();
            } else {
                z6 = true;
            }
            if (!z6) {
                return false;
            }
            Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod != null) {
                z7 = javaMethod.isAccessible();
            } else {
                z7 = true;
            }
            if (!z7) {
                return false;
            }
        } else if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null) {
                z4 = javaField4.isAccessible();
            } else {
                z4 = true;
            }
            if (!z4) {
                return false;
            }
            Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod2 != null) {
                z5 = javaMethod2.isAccessible();
            } else {
                z5 = true;
            }
            if (!z5) {
                return false;
            }
        } else if (kCallable instanceof KFunction) {
            KFunction kFunction = (KFunction) kCallable;
            Method javaMethod3 = ReflectJvmMapping.getJavaMethod(kFunction);
            if (javaMethod3 != null) {
                z = javaMethod3.isAccessible();
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
            KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
            AccessibleObject accessibleObject = null;
            if (asKCallableImpl != null && (defaultCaller = asKCallableImpl.getDefaultCaller()) != null) {
                obj = defaultCaller.mo2093getMember();
            } else {
                obj = null;
            }
            if (obj instanceof AccessibleObject) {
                accessibleObject = obj;
            }
            AccessibleObject accessibleObject2 = accessibleObject;
            if (accessibleObject2 != null) {
                z2 = accessibleObject2.isAccessible();
            } else {
                z2 = true;
            }
            if (!z2) {
                return false;
            }
            Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor(kFunction);
            if (javaConstructor != null) {
                z3 = javaConstructor.isAccessible();
            } else {
                z3 = true;
            }
            if (!z3) {
                return false;
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
        }
        return true;
    }

    public static final void setAccessible(KCallable<?> kCallable, boolean z) {
        Object obj;
        Caller<?> defaultCaller;
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field javaField = ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null) {
                javaField.setAccessible(z);
            }
            Method javaGetter = ReflectJvmMapping.getJavaGetter(kProperty);
            if (javaGetter != null) {
                javaGetter.setAccessible(z);
            }
            Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
            if (javaSetter != null) {
                javaSetter.setAccessible(z);
            }
        } else if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field javaField2 = ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null) {
                javaField2.setAccessible(z);
            }
            Method javaGetter2 = ReflectJvmMapping.getJavaGetter(kProperty2);
            if (javaGetter2 != null) {
                javaGetter2.setAccessible(z);
            }
        } else if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null) {
                javaField3.setAccessible(z);
            }
            Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod != null) {
                javaMethod.setAccessible(z);
            }
        } else if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null) {
                javaField4.setAccessible(z);
            }
            Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod2 != null) {
                javaMethod2.setAccessible(z);
            }
        } else if (kCallable instanceof KFunction) {
            KFunction kFunction = (KFunction) kCallable;
            Method javaMethod3 = ReflectJvmMapping.getJavaMethod(kFunction);
            if (javaMethod3 != null) {
                javaMethod3.setAccessible(z);
            }
            KCallableImpl<?> asKCallableImpl = UtilKt.asKCallableImpl(kCallable);
            AccessibleObject accessibleObject = null;
            if (asKCallableImpl != null && (defaultCaller = asKCallableImpl.getDefaultCaller()) != null) {
                obj = defaultCaller.mo2093getMember();
            } else {
                obj = null;
            }
            if (obj instanceof AccessibleObject) {
                accessibleObject = obj;
            }
            AccessibleObject accessibleObject2 = accessibleObject;
            if (accessibleObject2 != null) {
                accessibleObject2.setAccessible(true);
            }
            Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor(kFunction);
            if (javaConstructor != null) {
                javaConstructor.setAccessible(z);
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + ')');
        }
    }
}
