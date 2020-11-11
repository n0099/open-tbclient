package com.meizu.cloud.pushsdk.base.a;

import com.meizu.cloud.pushsdk.base.h;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class c {
    private static HashMap<String, Method> b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private String f4366a = "ReflectMethod";
    private com.meizu.cloud.pushsdk.base.a.a c;
    private String d;
    private Class<?>[] e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.meizu.cloud.pushsdk.base.a.a aVar, String str, Class<?>... clsArr) {
        this.c = aVar;
        this.d = str;
        this.e = clsArr;
    }

    private Class<?> a(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Method a() throws NoSuchMethodException, ClassNotFoundException {
        Method method;
        Class<?> a2 = this.c.a();
        Method[] methods = a2.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                Method[] declaredMethods = a2.getDeclaredMethods();
                int length2 = declaredMethods.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    method = declaredMethods[i2];
                    if (!a(method, this.d, this.e)) {
                    }
                }
                throw new NoSuchMethodException("No similar method " + this.d + " with params " + Arrays.toString(this.e) + " could be found on type " + a2);
            }
            method = methods[i];
            if (a(method, this.d, this.e)) {
                break;
            }
            i++;
        }
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
        StringBuffer stringBuffer = new StringBuffer(this.c.a().getName());
        stringBuffer.append(this.d);
        for (Class<?> cls : this.e) {
            stringBuffer.append(cls.getName());
        }
        return stringBuffer.toString();
    }

    public <T> d<T> a(Object obj, Object... objArr) {
        d<T> dVar = new d<>();
        try {
            String b2 = b();
            Method method = b.get(b2);
            if (method == null) {
                if (this.e.length == objArr.length) {
                    method = this.c.a().getMethod(this.d, this.e);
                } else {
                    if (objArr.length > 0) {
                        this.e = new Class[objArr.length];
                        for (int i = 0; i < objArr.length; i++) {
                            this.e[i] = objArr[i].getClass();
                        }
                    }
                    method = a();
                }
                b.put(b2, method);
            }
            method.setAccessible(true);
            dVar.b = (T) method.invoke(obj, objArr);
            dVar.f4367a = true;
        } catch (Exception e) {
            h.b().a(this.f4366a, "invoke", e);
        }
        return dVar;
    }

    public <T> d<T> a(Object... objArr) {
        try {
            return a(this.c.a(), objArr);
        } catch (ClassNotFoundException e) {
            return new d<>();
        }
    }
}
