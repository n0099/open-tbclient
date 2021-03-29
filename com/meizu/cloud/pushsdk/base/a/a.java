package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f37623a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f37624b;

    /* renamed from: c  reason: collision with root package name */
    public String f37625c;

    /* renamed from: d  reason: collision with root package name */
    public Object f37626d;

    public a(Object obj) {
        this.f37626d = obj;
    }

    public a(String str) {
        this.f37625c = str;
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
        Class<?> cls = this.f37624b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f37626d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f37623a.get(this.f37625c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f37625c);
            f37623a.put(this.f37625c, cls3);
            return cls3;
        }
        return cls2;
    }
}
