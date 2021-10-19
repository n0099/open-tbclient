package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes10.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f75161d;

    /* renamed from: e  reason: collision with root package name */
    public String f75162e;

    /* renamed from: f  reason: collision with root package name */
    public String f75163f;

    /* renamed from: g  reason: collision with root package name */
    public String f75164g;

    /* renamed from: h  reason: collision with root package name */
    public String f75165h;

    /* renamed from: i  reason: collision with root package name */
    public String f75166i;

    /* renamed from: j  reason: collision with root package name */
    public String f75167j;
    public String k;
    public int l;

    /* loaded from: classes10.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2043a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f75168a;

        /* renamed from: b  reason: collision with root package name */
        public String f75169b;

        /* renamed from: c  reason: collision with root package name */
        public String f75170c;

        /* renamed from: d  reason: collision with root package name */
        public String f75171d;

        /* renamed from: e  reason: collision with root package name */
        public String f75172e;

        /* renamed from: f  reason: collision with root package name */
        public String f75173f;

        /* renamed from: g  reason: collision with root package name */
        public String f75174g;

        /* renamed from: h  reason: collision with root package name */
        public String f75175h;

        /* renamed from: i  reason: collision with root package name */
        public int f75176i = 0;

        public T a(int i2) {
            this.f75176i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f75168a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f75169b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f75170c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f75171d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f75172e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f75173f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f75174g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f75175h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2044b extends a<C2044b> {
        public C2044b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2043a
        /* renamed from: c */
        public C2044b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f75162e = aVar.f75169b;
        this.f75163f = aVar.f75170c;
        this.f75161d = aVar.f75168a;
        this.f75164g = aVar.f75171d;
        this.f75165h = aVar.f75172e;
        this.f75166i = aVar.f75173f;
        this.f75167j = aVar.f75174g;
        this.k = aVar.f75175h;
        this.l = aVar.f75176i;
    }

    public static a<?> d() {
        return new C2044b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.f39560a, this.f75161d);
        cVar.a("ti", this.f75162e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f75163f);
        cVar.a("pv", this.f75164g);
        cVar.a("pn", this.f75165h);
        cVar.a("si", this.f75166i);
        cVar.a("ms", this.f75167j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
