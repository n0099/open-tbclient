package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f67415a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f67416b;

    /* renamed from: c  reason: collision with root package name */
    public String f67417c;

    /* renamed from: d  reason: collision with root package name */
    public Object f67418d;

    public a(Object obj) {
        this.f67418d = obj;
    }

    public a(String str) {
        this.f67417c = str;
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
        Class<?> cls = this.f67416b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f67418d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f67415a.get(this.f67417c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f67417c);
            f67415a.put(this.f67417c, cls3);
            return cls3;
        }
        return cls2;
    }
}
