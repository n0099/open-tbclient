package com.meizu.cloud.pushsdk.base.a;

import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Class<?>> f11222a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Class<?> f11223b;
    private String c;
    private Object d;

    private a(Object obj) {
        this.d = obj;
    }

    private a(String str) {
        this.c = str;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class<?> a() throws ClassNotFoundException {
        if (this.f11223b != null) {
            return this.f11223b;
        }
        if (this.d != null) {
            return this.d.getClass();
        }
        Class<?> cls = f11222a.get(this.c);
        if (cls == null) {
            Class<?> cls2 = Class.forName(this.c);
            f11222a.put(this.c, cls2);
            return cls2;
        }
        return cls;
    }
}
