package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f38007a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f38008b;

    /* renamed from: c  reason: collision with root package name */
    public String f38009c;

    /* renamed from: d  reason: collision with root package name */
    public Object f38010d;

    public a(Object obj) {
        this.f38010d = obj;
    }

    public a(String str) {
        this.f38009c = str;
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
        Class<?> cls = this.f38008b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f38010d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f38007a.get(this.f38009c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f38009c);
            f38007a.put(this.f38009c, cls3);
            return cls3;
        }
        return cls2;
    }
}
