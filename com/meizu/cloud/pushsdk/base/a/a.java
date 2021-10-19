package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f75051a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f75052b;

    /* renamed from: c  reason: collision with root package name */
    public String f75053c;

    /* renamed from: d  reason: collision with root package name */
    public Object f75054d;

    public a(Object obj) {
        this.f75054d = obj;
    }

    public a(String str) {
        this.f75053c = str;
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
        Class<?> cls = this.f75052b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f75054d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f75051a.get(this.f75053c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f75053c);
            f75051a.put(this.f75053c, cls3);
            return cls3;
        }
        return cls2;
    }
}
