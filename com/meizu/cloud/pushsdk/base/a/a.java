package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static HashMap<String, Class<?>> a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f60932b;

    /* renamed from: c  reason: collision with root package name */
    public String f60933c;

    /* renamed from: d  reason: collision with root package name */
    public Object f60934d;

    public a(Object obj) {
        this.f60934d = obj;
    }

    public a(String str) {
        this.f60933c = str;
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
        Class<?> cls = this.f60932b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f60934d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = a.get(this.f60933c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f60933c);
            a.put(this.f60933c, cls3);
            return cls3;
        }
        return cls2;
    }
}
