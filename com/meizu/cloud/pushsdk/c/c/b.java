package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f37728d;

    /* renamed from: e  reason: collision with root package name */
    public String f37729e;

    /* renamed from: f  reason: collision with root package name */
    public String f37730f;

    /* renamed from: g  reason: collision with root package name */
    public String f37731g;

    /* renamed from: h  reason: collision with root package name */
    public String f37732h;
    public String i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0456a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f37733a;

        /* renamed from: b  reason: collision with root package name */
        public String f37734b;

        /* renamed from: c  reason: collision with root package name */
        public String f37735c;

        /* renamed from: d  reason: collision with root package name */
        public String f37736d;

        /* renamed from: e  reason: collision with root package name */
        public String f37737e;

        /* renamed from: f  reason: collision with root package name */
        public String f37738f;

        /* renamed from: g  reason: collision with root package name */
        public String f37739g;

        /* renamed from: h  reason: collision with root package name */
        public String f37740h;
        public int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.f37733a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f37734b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f37735c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f37736d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f37737e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f37738f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f37739g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f37740h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0457b extends a<C0457b> {
        public C0457b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0456a
        /* renamed from: c */
        public C0457b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f37729e = aVar.f37734b;
        this.f37730f = aVar.f37735c;
        this.f37728d = aVar.f37733a;
        this.f37731g = aVar.f37736d;
        this.f37732h = aVar.f37737e;
        this.i = aVar.f37738f;
        this.j = aVar.f37739g;
        this.k = aVar.f37740h;
        this.l = aVar.i;
    }

    public static a<?> d() {
        return new C0457b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f37728d);
        cVar.a(Config.FEED_LIST_PART, this.f37729e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f37730f);
        cVar.a("pv", this.f37731g);
        cVar.a(Config.PACKAGE_NAME, this.f37732h);
        cVar.a("si", this.i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
