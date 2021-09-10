package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.f;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes10.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f74807d;

    /* renamed from: e  reason: collision with root package name */
    public String f74808e;

    /* renamed from: f  reason: collision with root package name */
    public String f74809f;

    /* renamed from: g  reason: collision with root package name */
    public String f74810g;

    /* renamed from: h  reason: collision with root package name */
    public String f74811h;

    /* renamed from: i  reason: collision with root package name */
    public String f74812i;

    /* renamed from: j  reason: collision with root package name */
    public String f74813j;
    public String k;
    public int l;

    /* loaded from: classes10.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2037a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f74814a;

        /* renamed from: b  reason: collision with root package name */
        public String f74815b;

        /* renamed from: c  reason: collision with root package name */
        public String f74816c;

        /* renamed from: d  reason: collision with root package name */
        public String f74817d;

        /* renamed from: e  reason: collision with root package name */
        public String f74818e;

        /* renamed from: f  reason: collision with root package name */
        public String f74819f;

        /* renamed from: g  reason: collision with root package name */
        public String f74820g;

        /* renamed from: h  reason: collision with root package name */
        public String f74821h;

        /* renamed from: i  reason: collision with root package name */
        public int f74822i = 0;

        public T a(int i2) {
            this.f74822i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f74814a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f74815b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f74816c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f74817d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f74818e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f74819f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f74820g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f74821h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2038b extends a<C2038b> {
        public C2038b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2037a
        /* renamed from: c */
        public C2038b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f74808e = aVar.f74815b;
        this.f74809f = aVar.f74816c;
        this.f74807d = aVar.f74814a;
        this.f74810g = aVar.f74817d;
        this.f74811h = aVar.f74818e;
        this.f74812i = aVar.f74819f;
        this.f74813j = aVar.f74820g;
        this.k = aVar.f74821h;
        this.l = aVar.f74822i;
    }

    public static a<?> d() {
        return new C2038b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(f.f39499a, this.f74807d);
        cVar.a("ti", this.f74808e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f74809f);
        cVar.a("pv", this.f74810g);
        cVar.a("pn", this.f74811h);
        cVar.a("si", this.f74812i);
        cVar.a("ms", this.f74813j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
