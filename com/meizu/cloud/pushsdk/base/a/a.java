package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {
    public static HashMap<String, Class<?>> a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f58837b;

    /* renamed from: c  reason: collision with root package name */
    public String f58838c;

    /* renamed from: d  reason: collision with root package name */
    public Object f58839d;

    public a(Object obj) {
        this.f58839d = obj;
    }

    public a(String str) {
        this.f58838c = str;
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
        Class<?> cls = this.f58837b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f58839d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = a.get(this.f58838c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f58838c);
            a.put(this.f58838c, cls3);
            return cls3;
        }
        return cls2;
    }
}
