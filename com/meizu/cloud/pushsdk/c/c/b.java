package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f37583d;

    /* renamed from: e  reason: collision with root package name */
    public String f37584e;

    /* renamed from: f  reason: collision with root package name */
    public String f37585f;

    /* renamed from: g  reason: collision with root package name */
    public String f37586g;

    /* renamed from: h  reason: collision with root package name */
    public String f37587h;

    /* renamed from: i  reason: collision with root package name */
    public String f37588i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0466a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f37589a;

        /* renamed from: b  reason: collision with root package name */
        public String f37590b;

        /* renamed from: c  reason: collision with root package name */
        public String f37591c;

        /* renamed from: d  reason: collision with root package name */
        public String f37592d;

        /* renamed from: e  reason: collision with root package name */
        public String f37593e;

        /* renamed from: f  reason: collision with root package name */
        public String f37594f;

        /* renamed from: g  reason: collision with root package name */
        public String f37595g;

        /* renamed from: h  reason: collision with root package name */
        public String f37596h;

        /* renamed from: i  reason: collision with root package name */
        public int f37597i = 0;

        public T a(int i2) {
            this.f37597i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f37589a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f37590b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f37591c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f37592d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f37593e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f37594f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f37595g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f37596h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0467b extends a<C0467b> {
        public C0467b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0466a
        /* renamed from: c */
        public C0467b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f37584e = aVar.f37590b;
        this.f37585f = aVar.f37591c;
        this.f37583d = aVar.f37589a;
        this.f37586g = aVar.f37592d;
        this.f37587h = aVar.f37593e;
        this.f37588i = aVar.f37594f;
        this.j = aVar.f37595g;
        this.k = aVar.f37596h;
        this.l = aVar.f37597i;
    }

    public static a<?> d() {
        return new C0467b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f37583d);
        cVar.a(Config.FEED_LIST_PART, this.f37584e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f37585f);
        cVar.a("pv", this.f37586g);
        cVar.a(Config.PACKAGE_NAME, this.f37587h);
        cVar.a("si", this.f37588i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
