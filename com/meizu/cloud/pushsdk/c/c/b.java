package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes3.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f58748d;

    /* renamed from: e  reason: collision with root package name */
    public String f58749e;

    /* renamed from: f  reason: collision with root package name */
    public String f58750f;

    /* renamed from: g  reason: collision with root package name */
    public String f58751g;

    /* renamed from: h  reason: collision with root package name */
    public String f58752h;

    /* renamed from: i  reason: collision with root package name */
    public String f58753i;

    /* renamed from: j  reason: collision with root package name */
    public String f58754j;
    public String k;
    public int l;

    /* loaded from: classes3.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2175a<T> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58755b;

        /* renamed from: c  reason: collision with root package name */
        public String f58756c;

        /* renamed from: d  reason: collision with root package name */
        public String f58757d;

        /* renamed from: e  reason: collision with root package name */
        public String f58758e;

        /* renamed from: f  reason: collision with root package name */
        public String f58759f;

        /* renamed from: g  reason: collision with root package name */
        public String f58760g;

        /* renamed from: h  reason: collision with root package name */
        public String f58761h;

        /* renamed from: i  reason: collision with root package name */
        public int f58762i = 0;

        public T a(int i2) {
            this.f58762i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f58755b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f58756c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f58757d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f58758e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f58759f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f58760g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f58761h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2176b extends a<C2176b> {
        public C2176b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2175a
        /* renamed from: c */
        public C2176b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f58749e = aVar.f58755b;
        this.f58750f = aVar.f58756c;
        this.f58748d = aVar.a;
        this.f58751g = aVar.f58757d;
        this.f58752h = aVar.f58758e;
        this.f58753i = aVar.f58759f;
        this.f58754j = aVar.f58760g;
        this.k = aVar.f58761h;
        this.l = aVar.f58762i;
    }

    public static a<?> d() {
        return new C2176b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.a, this.f58748d);
        cVar.a("ti", this.f58749e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f58750f);
        cVar.a("pv", this.f58751g);
        cVar.a("pn", this.f58752h);
        cVar.a("si", this.f58753i);
        cVar.a("ms", this.f58754j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
