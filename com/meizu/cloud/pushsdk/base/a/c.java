package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Method> f42031b = new HashMap<>();
    public String a = "ReflectMethod";

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.base.a.a f42032c;

    /* renamed from: d  reason: collision with root package name */
    public String f42033d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?>[] f42034e;

    /* loaded from: classes7.dex */
    public class a {
    }

    public c(com.meizu.cloud.pushsdk.base.a.a aVar, String str, Class<?>... clsArr) {
        this.f42032c = aVar;
        this.f42033d = str;
        this.f42034e = clsArr;
    }

    private Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    private Method a() throws NoSuchMethodException, ClassNotFoundException {
        Method[] methods;
        Method[] declaredMethods;
        Class<?> a2 = this.f42032c.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.f42033d, this.f42034e)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.f42033d, this.f42034e)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.f42033d + " with params " + Arrays.toString(this.f42034e) + " could be found on type " + a2);
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != a.class && !a(clsArr[i]).isAssignableFrom(a(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private String b() throws ClassNotFoundException {
        StringBuffer stringBuffer = new StringBuffer(this.f42032c.a().getName());
        stringBuffer.append(this.f42033d);
        for (Class<?> cls : this.f42034e) {
            stringBuffer.append(cls.getName());
        }
        return stringBuffer.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b2 = b();
            Method method = f42031b.get(b2);
            if (method == null) {
                if (this.f42034e.length == objArr.length) {
                    method = this.f42032c.a().getMethod(this.f42033d, this.f42034e);
                } else {
                    if (objArr.length > 0) {
                        this.f42034e = new Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.f42034e[i] = objArr[i].getClass();
                        }
                    }
                    method = a();
                }
                f42031b.put(b2, method);
            }
            method.setAccessible(true);
            dVar.f42035b = (T) method.invoke(obj, objArr);
            dVar.a = true;
        } catch (Exception e2) {
            h.b().a(this.a, "invoke", e2);
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.f42032c.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
