package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f38017d;

    /* renamed from: e  reason: collision with root package name */
    public String f38018e;

    /* renamed from: f  reason: collision with root package name */
    public String f38019f;

    /* renamed from: g  reason: collision with root package name */
    public String f38020g;

    /* renamed from: h  reason: collision with root package name */
    public String f38021h;
    public String i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0470a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f38022a;

        /* renamed from: b  reason: collision with root package name */
        public String f38023b;

        /* renamed from: c  reason: collision with root package name */
        public String f38024c;

        /* renamed from: d  reason: collision with root package name */
        public String f38025d;

        /* renamed from: e  reason: collision with root package name */
        public String f38026e;

        /* renamed from: f  reason: collision with root package name */
        public String f38027f;

        /* renamed from: g  reason: collision with root package name */
        public String f38028g;

        /* renamed from: h  reason: collision with root package name */
        public String f38029h;
        public int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.f38022a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f38023b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f38024c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f38025d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f38026e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f38027f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f38028g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f38029h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0471b extends a<C0471b> {
        public C0471b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0470a
        /* renamed from: c */
        public C0471b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f38018e = aVar.f38023b;
        this.f38019f = aVar.f38024c;
        this.f38017d = aVar.f38022a;
        this.f38020g = aVar.f38025d;
        this.f38021h = aVar.f38026e;
        this.i = aVar.f38027f;
        this.j = aVar.f38028g;
        this.k = aVar.f38029h;
        this.l = aVar.i;
    }

    public static a<?> d() {
        return new C0471b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f38017d);
        cVar.a(Config.FEED_LIST_PART, this.f38018e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f38019f);
        cVar.a("pv", this.f38020g);
        cVar.a(Config.PACKAGE_NAME, this.f38021h);
        cVar.a("si", this.i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
