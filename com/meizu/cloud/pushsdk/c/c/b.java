package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f38112d;

    /* renamed from: e  reason: collision with root package name */
    public String f38113e;

    /* renamed from: f  reason: collision with root package name */
    public String f38114f;

    /* renamed from: g  reason: collision with root package name */
    public String f38115g;

    /* renamed from: h  reason: collision with root package name */
    public String f38116h;
    public String i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0473a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f38117a;

        /* renamed from: b  reason: collision with root package name */
        public String f38118b;

        /* renamed from: c  reason: collision with root package name */
        public String f38119c;

        /* renamed from: d  reason: collision with root package name */
        public String f38120d;

        /* renamed from: e  reason: collision with root package name */
        public String f38121e;

        /* renamed from: f  reason: collision with root package name */
        public String f38122f;

        /* renamed from: g  reason: collision with root package name */
        public String f38123g;

        /* renamed from: h  reason: collision with root package name */
        public String f38124h;
        public int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.f38117a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f38118b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f38119c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f38120d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f38121e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f38122f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f38123g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f38124h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0474b extends a<C0474b> {
        public C0474b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0473a
        /* renamed from: c */
        public C0474b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f38113e = aVar.f38118b;
        this.f38114f = aVar.f38119c;
        this.f38112d = aVar.f38117a;
        this.f38115g = aVar.f38120d;
        this.f38116h = aVar.f38121e;
        this.i = aVar.f38122f;
        this.j = aVar.f38123g;
        this.k = aVar.f38124h;
        this.l = aVar.i;
    }

    public static a<?> d() {
        return new C0474b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f38112d);
        cVar.a(Config.FEED_LIST_PART, this.f38113e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f38114f);
        cVar.a("pv", this.f38115g);
        cVar.a(Config.PACKAGE_NAME, this.f38116h);
        cVar.a("si", this.i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
