package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f34803a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f34804b;

    /* renamed from: c  reason: collision with root package name */
    public String f34805c;

    /* renamed from: d  reason: collision with root package name */
    public Object f34806d;

    public a(Object obj) {
        this.f34806d = obj;
    }

    public a(String str) {
        this.f34805c = str;
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
        Class<?> cls = this.f34804b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f34806d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f34803a.get(this.f34805c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f34805c);
            f34803a.put(this.f34805c, cls3);
            return cls3;
        }
        return cls2;
    }
}
