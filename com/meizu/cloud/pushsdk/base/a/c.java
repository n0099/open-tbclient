package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, Method> f74704b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String f74705a = "ReflectMethod";

    /* renamed from: c  reason: collision with root package name */
    public com.meizu.cloud.pushsdk.base.a.a f74706c;

    /* renamed from: d  reason: collision with root package name */
    public String f74707d;

    /* renamed from: e  reason: collision with root package name */
    public Class<?>[] f74708e;

    /* loaded from: classes10.dex */
    public class a {
    }

    public c(com.meizu.cloud.pushsdk.base.a.a aVar, String str, Class<?>... clsArr) {
        this.f74706c = aVar;
        this.f74707d = str;
        this.f74708e = clsArr;
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
        Class<?> a2 = this.f74706c.a();
        for (Method method : a2.getMethods()) {
            if (a(method, this.f74707d, this.f74708e)) {
                return method;
            }
        }
        for (Method method2 : a2.getDeclaredMethods()) {
            if (a(method2, this.f74707d, this.f74708e)) {
                return method2;
            }
        }
        throw new NoSuchMethodException("No similar method " + this.f74707d + " with params " + Arrays.toString(this.f74708e) + " could be found on type " + a2);
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
        StringBuffer stringBuffer = new StringBuffer(this.f74706c.a().getName());
        stringBuffer.append(this.f74707d);
        for (Class<?> cls : this.f74708e) {
            stringBuffer.append(cls.getName());
        }
        return stringBuffer.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b2 = b();
            Method method = f74704b.get(b2);
            if (method == null) {
                if (this.f74708e.length == objArr.length) {
                    method = this.f74706c.a().getMethod(this.f74707d, this.f74708e);
                } else {
                    if (objArr.length > 0) {
                        this.f74708e = new Class[objArr.length];
                        for (int i2 = 0; i2 < objArr.length; i2++) {
                            this.f74708e[i2] = objArr[i2].getClass();
                        }
                    }
                    method = a();
                }
                f74704b.put(b2, method);
            }
            method.setAccessible(true);
            dVar.f74710b = (T) method.invoke(obj, objArr);
            dVar.f74709a = true;
        } catch (Exception e2) {
            h.b().a(this.f74705a, "invoke", e2);
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.f74706c.a(), objArr);
        } catch (ClassNotFoundException unused) {
            return new d<>();
        }
    }
}
