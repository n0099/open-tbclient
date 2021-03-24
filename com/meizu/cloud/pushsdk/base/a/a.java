package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f37622a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f37623b;

    /* renamed from: c  reason: collision with root package name */
    public String f37624c;

    /* renamed from: d  reason: collision with root package name */
    public Object f37625d;

    public a(Object obj) {
        this.f37625d = obj;
    }

    public a(String str) {
        this.f37624c = str;
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
        Class<?> cls = this.f37623b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f37625d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f37622a.get(this.f37624c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f37624c);
            f37622a.put(this.f37624c, cls3);
            return cls3;
        }
        return cls2;
    }
}
