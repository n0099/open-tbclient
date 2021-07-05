package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f40272a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f40273b;

    /* renamed from: c  reason: collision with root package name */
    public String f40274c;

    /* renamed from: d  reason: collision with root package name */
    public Object f40275d;

    public a(Object obj) {
        this.f40275d = obj;
    }

    public a(String str) {
        this.f40274c = str;
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
        Class<?> cls = this.f40273b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f40275d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f40272a.get(this.f40274c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f40274c);
            f40272a.put(this.f40274c, cls3);
            return cls3;
        }
        return cls2;
    }
}
