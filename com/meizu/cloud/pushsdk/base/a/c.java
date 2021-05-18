package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Method> f34810b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String f34811a = "ReflectMethod";

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.base.a.a f34812c;

    /* renamed from: d  reason: collision with root package name */
    public String f34813d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?>[] f34814e;

    /* loaded from: classes6.dex */
    public class a {
    }

    public c(com.meizu.cloud.pushsdk.base.a.a aVar, String str, Class<?>... clsArr) {
        this.f34812c = aVar;
        this.f34813d = str;
        this.f34814e = clsArr;
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
        Class<?> a2 = this.f34812c.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.f34813d, this.f34814e)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.f34813d, this.f34814e)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.f34813d + " with params " + Arrays.toString(this.f34814e) + " could be found on type " + a2);
    }

    private boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i2 = 0; i2 < clsArr2.length; i2++) {
                if (clsArr2[i2] != a.class && !a(clsArr[i2]).isAssignableFrom(a(clsArr2[i2]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private String b() throws ClassNotFoundException {
        StringBuffer stringBuffer = new StringBuffer(this.f34812c.a().getName());
        stringBuffer.append(this.f34813d);
        for (Class<?> cls : this.f34814e) {
            stringBuffer.append(cls.getName());
        }
        return stringBuffer.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b2 = b();
            Method method = f34810b.get(b2);
            if (method == null) {
                if (this.f34814e.length == objArr.length) {
                    method = this.f34812c.a().getMethod(this.f34813d, this.f34814e);
                } else {
                    if (objArr.length > 0) {
                        this.f34814e = new Class[objArr.length];
                        for (int i2 = 0; i2 < objArr.length; i2++) {
                            this.f34814e[i2] = objArr[i2].getClass();
                        }
                    }
                    method = a();
                }
                f34810b.put(b2, method);
            }
            method.setAccessible(true);
            dVar.f34816b = (T) method.invoke(obj, objArr);
            dVar.f34815a = true;
        } catch (Exception e2) {
            h.b().a(this.f34811a, "invoke", e2);
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.f34812c.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
