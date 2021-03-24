package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Method> f37629b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String f37630a = "ReflectMethod";

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.base.a.a f37631c;

    /* renamed from: d  reason: collision with root package name */
    public String f37632d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?>[] f37633e;

    /* loaded from: classes6.dex */
    public class a {
    }

    public c(com.meizu.cloud.pushsdk.base.a.a aVar, String str, Class<?>... clsArr) {
        this.f37631c = aVar;
        this.f37632d = str;
        this.f37633e = clsArr;
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
        Class<?> a2 = this.f37631c.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.f37632d, this.f37633e)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.f37632d, this.f37633e)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.f37632d + " with params " + Arrays.toString(this.f37633e) + " could be found on type " + a2);
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
        StringBuffer stringBuffer = new StringBuffer(this.f37631c.a().getName());
        stringBuffer.append(this.f37632d);
        for (Class<?> cls : this.f37633e) {
            stringBuffer.append(cls.getName());
        }
        return stringBuffer.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b2 = b();
            Method method = f37629b.get(b2);
            if (method == null) {
                if (this.f37633e.length == objArr.length) {
                    method = this.f37631c.a().getMethod(this.f37632d, this.f37633e);
                } else {
                    if (objArr.length > 0) {
                        this.f37633e = new Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.f37633e[i] = objArr[i].getClass();
                        }
                    }
                    method = a();
                }
                f37629b.put(b2, method);
            }
            method.setAccessible(true);
            dVar.f37635b = (T) method.invoke(obj, objArr);
            dVar.f37634a = true;
        } catch (Exception e2) {
            h.b().a(this.f37630a, "invoke", e2);
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.f37631c.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
