package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Class<?>> f38509a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public Class<?> f38510b;

    /* renamed from: c  reason: collision with root package name */
    public String f38511c;

    /* renamed from: d  reason: collision with root package name */
    public Object f38512d;

    public a(Object obj) {
        this.f38512d = obj;
    }

    public a(String str) {
        this.f38511c = str;
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
        Class<?> cls = this.f38510b;
        if (cls != null) {
            return cls;
        }
        Object obj = this.f38512d;
        if (obj != null) {
            return obj.getClass();
        }
        Class<?> cls2 = f38509a.get(this.f38511c);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(this.f38511c);
            f38509a.put(this.f38511c, cls3);
            return cls3;
        }
        return cls2;
    }
}
