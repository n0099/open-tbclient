package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f74317a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f74318b;

    /* renamed from: c  reason: collision with root package name */
    public String f74319c;

    /* renamed from: d  reason: collision with root package name */
    public Object f74320d;

    public a(Object obj) {
        this.f74320d = obj;
    }

    public a(String str) {
        this.f74319c = str;
    }

    public static a a(Object obj) {
        return new a(obj);
    }

    public static a a(String str) {
        return new a(str);
    }

    public b a(Class<?>... clsArr) {
        return new b(this, clsArr);
    }

    public c a(String str, Class<?>... clsArr) {
        return new c(this, str, clsArr);
    }

    public Class<?> a() throws ClassNotFoundException {
        Class<?> cls = this.f74318b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f74320d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f74317a.get(this.f74319c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f74319c);
            f74317a.put(this.f74319c, cls3);
            return cls3;
        }
        return cls2;
    }
}
