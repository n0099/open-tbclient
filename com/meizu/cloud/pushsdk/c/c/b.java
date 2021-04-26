package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f35666d;

    /* renamed from: e  reason: collision with root package name */
    public String f35667e;

    /* renamed from: f  reason: collision with root package name */
    public String f35668f;

    /* renamed from: g  reason: collision with root package name */
    public String f35669g;

    /* renamed from: h  reason: collision with root package name */
    public String f35670h;

    /* renamed from: i  reason: collision with root package name */
    public String f35671i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0417a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f35672a;

        /* renamed from: b  reason: collision with root package name */
        public String f35673b;

        /* renamed from: c  reason: collision with root package name */
        public String f35674c;

        /* renamed from: d  reason: collision with root package name */
        public String f35675d;

        /* renamed from: e  reason: collision with root package name */
        public String f35676e;

        /* renamed from: f  reason: collision with root package name */
        public String f35677f;

        /* renamed from: g  reason: collision with root package name */
        public String f35678g;

        /* renamed from: h  reason: collision with root package name */
        public String f35679h;

        /* renamed from: i  reason: collision with root package name */
        public int f35680i = 0;

        public T a(int i2) {
            this.f35680i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f35672a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f35673b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f35674c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f35675d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f35676e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f35677f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f35678g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f35679h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0418b extends a<C0418b> {
        public C0418b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0417a
        /* renamed from: c */
        public C0418b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f35667e = aVar.f35673b;
        this.f35668f = aVar.f35674c;
        this.f35666d = aVar.f35672a;
        this.f35669g = aVar.f35675d;
        this.f35670h = aVar.f35676e;
        this.f35671i = aVar.f35677f;
        this.j = aVar.f35678g;
        this.k = aVar.f35679h;
        this.l = aVar.f35680i;
    }

    public static a<?> d() {
        return new C0418b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f35666d);
        cVar.a(Config.FEED_LIST_PART, this.f35667e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f35668f);
        cVar.a("pv", this.f35669g);
        cVar.a(Config.PACKAGE_NAME, this.f35670h);
        cVar.a("si", this.f35671i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
