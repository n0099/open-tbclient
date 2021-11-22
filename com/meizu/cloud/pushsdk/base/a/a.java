package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f68327a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f68328b;

    /* renamed from: c  reason: collision with root package name */
    public String f68329c;

    /* renamed from: d  reason: collision with root package name */
    public Object f68330d;

    public a(Object obj) {
        this.f68330d = obj;
    }

    public a(String str) {
        this.f68329c = str;
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
        Class<?> cls = this.f68328b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f68330d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f68327a.get(this.f68329c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f68329c);
            f68327a.put(this.f68329c, cls3);
            return cls3;
        }
        return cls2;
    }
}
