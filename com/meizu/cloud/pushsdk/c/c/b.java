package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes3.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f61012d;

    /* renamed from: e  reason: collision with root package name */
    public String f61013e;

    /* renamed from: f  reason: collision with root package name */
    public String f61014f;

    /* renamed from: g  reason: collision with root package name */
    public String f61015g;

    /* renamed from: h  reason: collision with root package name */
    public String f61016h;

    /* renamed from: i  reason: collision with root package name */
    public String f61017i;

    /* renamed from: j  reason: collision with root package name */
    public String f61018j;

    /* renamed from: k  reason: collision with root package name */
    public String f61019k;
    public int l;

    /* loaded from: classes3.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2152a<T> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f61020b;

        /* renamed from: c  reason: collision with root package name */
        public String f61021c;

        /* renamed from: d  reason: collision with root package name */
        public String f61022d;

        /* renamed from: e  reason: collision with root package name */
        public String f61023e;

        /* renamed from: f  reason: collision with root package name */
        public String f61024f;

        /* renamed from: g  reason: collision with root package name */
        public String f61025g;

        /* renamed from: h  reason: collision with root package name */
        public String f61026h;

        /* renamed from: i  reason: collision with root package name */
        public int f61027i = 0;

        public T a(int i2) {
            this.f61027i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f61020b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f61021c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f61022d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f61023e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f61024f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f61025g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f61026h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2153b extends a<C2153b> {
        public C2153b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2152a
        /* renamed from: c */
        public C2153b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f61013e = aVar.f61020b;
        this.f61014f = aVar.f61021c;
        this.f61012d = aVar.a;
        this.f61015g = aVar.f61022d;
        this.f61016h = aVar.f61023e;
        this.f61017i = aVar.f61024f;
        this.f61018j = aVar.f61025g;
        this.f61019k = aVar.f61026h;
        this.l = aVar.f61027i;
    }

    public static a<?> d() {
        return new C2153b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.a, this.f61012d);
        cVar.a("ti", this.f61013e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f61014f);
        cVar.a("pv", this.f61015g);
        cVar.a("pn", this.f61016h);
        cVar.a("si", this.f61017i);
        cVar.a("ms", this.f61018j);
        cVar.a("ect", this.f61019k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
