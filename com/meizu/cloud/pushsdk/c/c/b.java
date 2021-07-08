package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f37394d;

    /* renamed from: e  reason: collision with root package name */
    public String f37395e;

    /* renamed from: f  reason: collision with root package name */
    public String f37396f;

    /* renamed from: g  reason: collision with root package name */
    public String f37397g;

    /* renamed from: h  reason: collision with root package name */
    public String f37398h;

    /* renamed from: i  reason: collision with root package name */
    public String f37399i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0464a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f37400a;

        /* renamed from: b  reason: collision with root package name */
        public String f37401b;

        /* renamed from: c  reason: collision with root package name */
        public String f37402c;

        /* renamed from: d  reason: collision with root package name */
        public String f37403d;

        /* renamed from: e  reason: collision with root package name */
        public String f37404e;

        /* renamed from: f  reason: collision with root package name */
        public String f37405f;

        /* renamed from: g  reason: collision with root package name */
        public String f37406g;

        /* renamed from: h  reason: collision with root package name */
        public String f37407h;

        /* renamed from: i  reason: collision with root package name */
        public int f37408i = 0;

        public T a(int i2) {
            this.f37408i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f37400a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f37401b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f37402c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f37403d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f37404e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f37405f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f37406g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f37407h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0465b extends a<C0465b> {
        public C0465b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0464a
        /* renamed from: c */
        public C0465b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f37395e = aVar.f37401b;
        this.f37396f = aVar.f37402c;
        this.f37394d = aVar.f37400a;
        this.f37397g = aVar.f37403d;
        this.f37398h = aVar.f37404e;
        this.f37399i = aVar.f37405f;
        this.j = aVar.f37406g;
        this.k = aVar.f37407h;
        this.l = aVar.f37408i;
    }

    public static a<?> d() {
        return new C0465b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f37394d);
        cVar.a(Config.FEED_LIST_PART, this.f37395e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f37396f);
        cVar.a("pv", this.f37397g);
        cVar.a(Config.PACKAGE_NAME, this.f37398h);
        cVar.a("si", this.f37399i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
