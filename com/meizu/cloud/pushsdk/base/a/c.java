package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Method> f38014b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String f38015a = "ReflectMethod";

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.base.a.a f38016c;

    /* renamed from: d  reason: collision with root package name */
    public String f38017d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?>[] f38018e;

    /* loaded from: classes6.dex */
    public class a {
    }

    public c(com.meizu.cloud.pushsdk.base.a.a aVar, String str, Class<?>... clsArr) {
        this.f38016c = aVar;
        this.f38017d = str;
        this.f38018e = clsArr;
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
        Class<?> a2 = this.f38016c.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.f38017d, this.f38018e)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.f38017d, this.f38018e)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.f38017d + " with params " + Arrays.toString(this.f38018e) + " could be found on type " + a2);
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
        StringBuffer stringBuffer = new StringBuffer(this.f38016c.a().getName());
        stringBuffer.append(this.f38017d);
        for (Class<?> cls : this.f38018e) {
            stringBuffer.append(cls.getName());
        }
        return stringBuffer.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b2 = b();
            Method method = f38014b.get(b2);
            if (method == null) {
                if (this.f38018e.length == objArr.length) {
                    method = this.f38016c.a().getMethod(this.f38017d, this.f38018e);
                } else {
                    if (objArr.length > 0) {
                        this.f38018e = new Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.f38018e[i] = objArr[i].getClass();
                        }
                    }
                    method = a();
                }
                f38014b.put(b2, method);
            }
            method.setAccessible(true);
            dVar.f38020b = (T) method.invoke(obj, objArr);
            dVar.f38019a = true;
        } catch (Exception e2) {
            h.b().a(this.f38015a, "invoke", e2);
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.f38016c.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
