package org.chromium.support_lib_boundary.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Collection;
@SuppressLint({"BanTargetApiAnnotation"})
/* loaded from: classes9.dex */
public class BoundaryInterfaceReflectionUtil {
    public static final /* synthetic */ boolean $assertionsDisabled = false;

    @TargetApi(19)
    /* loaded from: classes9.dex */
    public static class InvocationHandlerWithDelegateGetter implements InvocationHandler {
        public final Object mDelegate;

        public InvocationHandlerWithDelegateGetter(Object obj) {
            this.mDelegate = obj;
        }

        public Object getDelegate() {
            return this.mDelegate;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return BoundaryInterfaceReflectionUtil.dupeMethod(method, this.mDelegate.getClass().getClassLoader()).invoke(this.mDelegate, objArr);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            } catch (ReflectiveOperationException e2) {
                throw new RuntimeException("Reflection failed for method " + method, e2);
            }
        }
    }

    public static boolean isDebuggable() {
        if (!"eng".equals(Build.TYPE) && !"userdebug".equals(Build.TYPE)) {
            return false;
        }
        return true;
    }

    public static <T> T castToSuppLibClass(Class<T> cls, InvocationHandler invocationHandler) {
        return cls.cast(Proxy.newProxyInstance(BoundaryInterfaceReflectionUtil.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static boolean containsFeature(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (isDebuggable()) {
                if (collection.contains(str + Features.DEV_SUFFIX)) {
                }
            }
            return false;
        }
        return true;
    }

    public static Method dupeMethod(Method method, ClassLoader classLoader) throws ClassNotFoundException, NoSuchMethodException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    public static boolean instanceOfInOwnClassLoader(Object obj, String str) {
        try {
            return Class.forName(str, false, obj.getClass().getClassLoader()).isInstance(obj);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean containsFeature(String[] strArr, String str) {
        return containsFeature(Arrays.asList(strArr), str);
    }

    @TargetApi(19)
    public static InvocationHandler createInvocationHandlerFor(Object obj) {
        return new InvocationHandlerWithDelegateGetter(obj);
    }

    @TargetApi(19)
    public static InvocationHandler[] createInvocationHandlersForArray(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        int length = objArr.length;
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[length];
        for (int i = 0; i < length; i++) {
            invocationHandlerArr[i] = createInvocationHandlerFor(objArr[i]);
        }
        return invocationHandlerArr;
    }

    public static Object getDelegateFromInvocationHandler(InvocationHandler invocationHandler) {
        return ((InvocationHandlerWithDelegateGetter) invocationHandler).getDelegate();
    }
}
