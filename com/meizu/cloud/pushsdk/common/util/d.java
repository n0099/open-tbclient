package com.meizu.cloud.pushsdk.common.util;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes3.dex */
public abstract class d {
    private static HashMap<String, Class<?>> d = new HashMap<>();
    private static HashMap<Class<?>, HashMap<String, Method>> e = new HashMap<>();
    private static HashMap<String, Field> f = new HashMap<>();
    protected Object[] a;
    protected Class<?>[] b;
    protected String c;

    public abstract <T> c<T> a();

    public static d a(Class<?> cls) {
        return new a(cls);
    }

    public static d a(String str) {
        Class<?> cls = d.get(str);
        if (cls == null) {
            try {
                cls = Class.forName(str);
                d.put(str, cls);
            } catch (ClassNotFoundException e2) {
                Logger.a("Reflector", e2);
            }
        }
        return a(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<?>[] c(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method b(Class<?> cls, String str, Class... clsArr) throws NoSuchMethodException {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e3) {
                return c(cls, str, clsArr);
            }
        }
    }

    private static Method c(Class<?> cls, String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Method method;
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i = 0;
        while (true) {
            if (i < length) {
                method = methods[i];
                if (a(method, str, clsArr)) {
                    break;
                }
                i++;
            } else {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length2 = declaredMethods.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    method = declaredMethods[i2];
                    if (!a(method, str, clsArr)) {
                    }
                }
                throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + cls);
            }
        }
        return method;
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && a(method.getParameterTypes(), clsArr);
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length == clsArr2.length) {
            for (int i = 0; i < clsArr2.length; i++) {
                if (clsArr2[i] != b.class && !b(clsArr[i]).isAssignableFrom(b(clsArr2[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public d a(Object[] objArr) {
        this.a = objArr;
        return this;
    }

    public d b(String str) {
        this.c = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends d {
        private Class<?> d;

        public a(Class<?> cls) {
            this.d = cls;
        }

        @Override // com.meizu.cloud.pushsdk.common.util.d
        public <T> c<T> a() {
            HashMap hashMap;
            c<T> cVar = new c<>();
            if (this.d != null && !TextUtils.isEmpty(this.c)) {
                if (this.a != null && this.a.length > 0 && this.b == null) {
                    this.b = d.c(this.a);
                }
                try {
                    HashMap hashMap2 = (HashMap) d.e.get(this.d);
                    if (hashMap2 == null) {
                        HashMap hashMap3 = new HashMap();
                        d.e.put(this.d, hashMap3);
                        hashMap = hashMap3;
                    } else {
                        hashMap = hashMap2;
                    }
                    Method method = (Method) hashMap.get(this.c);
                    if (method == null) {
                        method = d.b(this.d, this.c, this.b);
                        if (!method.isAccessible()) {
                            method.setAccessible(true);
                        }
                        hashMap.put(this.c, method);
                    }
                    cVar.b = (T) method.invoke(this.d, this.a);
                    cVar.a = true;
                } catch (Exception e) {
                    Logger.a("Reflector", e);
                }
            }
            Logger.a("Reflector", "[Clz.invoke]:, mMethodName='" + this.c + ", \nmTypes=" + Arrays.toString(this.b) + ", \nmArgs=" + Arrays.toString(this.a) + ", \nresult=" + cVar);
            return cVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class c<T> {
        public boolean a = false;
        public T b;

        public String toString() {
            return "Result{ok=" + this.a + ", value=" + this.b + '}';
        }
    }

    public static Class<?> b(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                return Boolean.class;
            }
            if (Integer.TYPE == cls) {
                return Integer.class;
            }
            if (Long.TYPE == cls) {
                return Long.class;
            }
            if (Short.TYPE == cls) {
                return Short.class;
            }
            if (Byte.TYPE == cls) {
                return Byte.class;
            }
            if (Double.TYPE == cls) {
                return Double.class;
            }
            if (Float.TYPE == cls) {
                return Float.class;
            }
            if (Character.TYPE == cls) {
                return Character.class;
            }
            if (Void.TYPE == cls) {
                return Void.class;
            }
            return cls;
        }
        return cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class b {
        private b() {
        }
    }
}
