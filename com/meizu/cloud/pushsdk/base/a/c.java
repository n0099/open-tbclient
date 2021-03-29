package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Method> f37630b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String f37631a = "ReflectMethod";

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.base.a.a f37632c;

    /* renamed from: d  reason: collision with root package name */
    public String f37633d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?>[] f37634e;

    /* loaded from: classes6.dex */
    public class a {
    }

    public c(com.meizu.cloud.pushsdk.base.a.a aVar, String str, Class<?>... clsArr) {
        this.f37632c = aVar;
        this.f37633d = str;
        this.f37634e = clsArr;
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
        Class<?> a2 = this.f37632c.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.f37633d, this.f37634e)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.f37633d, this.f37634e)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.f37633d + " with params " + Arrays.toString(this.f37634e) + " could be found on type " + a2);
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
        StringBuffer stringBuffer = new StringBuffer(this.f37632c.a().getName());
        stringBuffer.append(this.f37633d);
        for (Class<?> cls : this.f37634e) {
            stringBuffer.append(cls.getName());
        }
        return stringBuffer.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b2 = b();
            Method method = f37630b.get(b2);
            if (method == null) {
                if (this.f37634e.length == objArr.length) {
                    method = this.f37632c.a().getMethod(this.f37633d, this.f37634e);
                } else {
                    if (objArr.length > 0) {
                        this.f37634e = new Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.f37634e[i] = objArr[i].getClass();
                        }
                    }
                    method = a();
                }
                f37630b.put(b2, method);
            }
            method.setAccessible(true);
            dVar.f37636b = (T) method.invoke(obj, objArr);
            dVar.f37635a = true;
        } catch (Exception e2) {
            h.b().a(this.f37631a, "invoke", e2);
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.f37632c.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
