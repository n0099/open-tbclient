package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f34732a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f34733b;

    /* renamed from: c  reason: collision with root package name */
    public String f34734c;

    /* renamed from: d  reason: collision with root package name */
    public Object f34735d;

    public a(Object obj) {
        this.f34735d = obj;
    }

    public a(String str) {
        this.f34734c = str;
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
        Class<?> cls = this.f34733b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f34735d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f34732a.get(this.f34734c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f34734c);
            f34732a.put(this.f34734c, cls3);
            return cls3;
        }
        return cls2;
    }
}
