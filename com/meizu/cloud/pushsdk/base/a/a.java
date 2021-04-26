package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f35558a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f35559b;

    /* renamed from: c  reason: collision with root package name */
    public String f35560c;

    /* renamed from: d  reason: collision with root package name */
    public Object f35561d;

    public a(Object obj) {
        this.f35561d = obj;
    }

    public a(String str) {
        this.f35560c = str;
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
        Class<?> cls = this.f35559b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f35561d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f35558a.get(this.f35560c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f35560c);
            f35558a.put(this.f35560c, cls3);
            return cls3;
        }
        return cls2;
    }
}
