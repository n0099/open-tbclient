package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f34840d;

    /* renamed from: e  reason: collision with root package name */
    public String f34841e;

    /* renamed from: f  reason: collision with root package name */
    public String f34842f;

    /* renamed from: g  reason: collision with root package name */
    public String f34843g;

    /* renamed from: h  reason: collision with root package name */
    public String f34844h;

    /* renamed from: i  reason: collision with root package name */
    public String f34845i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0405a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f34846a;

        /* renamed from: b  reason: collision with root package name */
        public String f34847b;

        /* renamed from: c  reason: collision with root package name */
        public String f34848c;

        /* renamed from: d  reason: collision with root package name */
        public String f34849d;

        /* renamed from: e  reason: collision with root package name */
        public String f34850e;

        /* renamed from: f  reason: collision with root package name */
        public String f34851f;

        /* renamed from: g  reason: collision with root package name */
        public String f34852g;

        /* renamed from: h  reason: collision with root package name */
        public String f34853h;

        /* renamed from: i  reason: collision with root package name */
        public int f34854i = 0;

        public T a(int i2) {
            this.f34854i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f34846a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f34847b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f34848c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f34849d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f34850e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f34851f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f34852g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f34853h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0406b extends a<C0406b> {
        public C0406b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0405a
        /* renamed from: c */
        public C0406b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f34841e = aVar.f34847b;
        this.f34842f = aVar.f34848c;
        this.f34840d = aVar.f34846a;
        this.f34843g = aVar.f34849d;
        this.f34844h = aVar.f34850e;
        this.f34845i = aVar.f34851f;
        this.j = aVar.f34852g;
        this.k = aVar.f34853h;
        this.l = aVar.f34854i;
    }

    public static a<?> d() {
        return new C0406b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f34840d);
        cVar.a(Config.FEED_LIST_PART, this.f34841e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f34842f);
        cVar.a("pv", this.f34843g);
        cVar.a(Config.PACKAGE_NAME, this.f34844h);
        cVar.a("si", this.f34845i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
