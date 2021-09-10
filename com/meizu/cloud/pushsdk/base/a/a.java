package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f74697a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f74698b;

    /* renamed from: c  reason: collision with root package name */
    public String f74699c;

    /* renamed from: d  reason: collision with root package name */
    public Object f74700d;

    public a(Object obj) {
        this.f74700d = obj;
    }

    public a(String str) {
        this.f74699c = str;
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
        Class<?> cls = this.f74698b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f74700d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f74697a.get(this.f74699c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f74699c);
            f74697a.put(this.f74699c, cls3);
            return cls3;
        }
        return cls2;
    }
}
