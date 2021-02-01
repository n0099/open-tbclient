package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
/* loaded from: classes15.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f13461a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<Class<?>, HashMap<String, Field>> f13462b = new HashMap<>();
    public static HashMap<Class<?>, HashMap<String, Method>> c = new HashMap<>();

    public static Object a(Class<?> cls, String str, Object obj) {
        HashMap<String, Field> hashMap;
        Field field;
        if (cls == null) {
            field = null;
        } else {
            try {
                HashMap<String, Field> hashMap2 = f13462b.get(cls);
                if (hashMap2 == null) {
                    HashMap<String, Field> hashMap3 = new HashMap<>();
                    f13462b.put(cls, hashMap3);
                    hashMap = hashMap3;
                } else {
                    hashMap = hashMap2;
                }
                field = hashMap.get(str);
                if (field == null) {
                    field = cls.getDeclaredField(str);
                }
                if (field == null) {
                    field = null;
                } else {
                    field.setAccessible(true);
                    hashMap.put(str, field);
                }
            }
        }
        if (field == null) {
            return null;
        }
        return field.get(obj);
    }

    public static Object a(String str, String str2) {
        try {
            Class<?> cls = f13461a.get(str);
            if (cls == null) {
                cls = Class.forName(str);
            }
            if (cls == null) {
                cls = null;
            } else {
                f13461a.put(str, cls);
            }
            return a(cls, str2, (Object) null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        HashMap<String, Method> hashMap;
        if (cls != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    StringBuffer stringBuffer = new StringBuffer(str);
                    if (clsArr != null) {
                        for (Class<?> cls2 : clsArr) {
                            stringBuffer.append("+");
                            stringBuffer.append(cls2.getName());
                        }
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    HashMap<String, Method> hashMap2 = c.get(cls);
                    if (hashMap2 == null) {
                        HashMap<String, Method> hashMap3 = new HashMap<>();
                        c.put(cls, hashMap3);
                        hashMap = hashMap3;
                    } else {
                        hashMap = hashMap2;
                    }
                    Method method = hashMap.get(stringBuffer2);
                    if (method == null) {
                        method = cls.getDeclaredMethod(str, clsArr);
                    }
                    if (method == null) {
                        return null;
                    }
                    method.setAccessible(true);
                    hashMap.put(stringBuffer2, method);
                    return method;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static Object b(Class<?> cls, String str, Object obj) {
        try {
            Method a2 = a(cls, str, (Class<?>[]) new Class[0]);
            if (a2 == null) {
                return null;
            }
            return a2.invoke(obj, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
