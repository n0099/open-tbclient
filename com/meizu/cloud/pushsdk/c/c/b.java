package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f34911d;

    /* renamed from: e  reason: collision with root package name */
    public String f34912e;

    /* renamed from: f  reason: collision with root package name */
    public String f34913f;

    /* renamed from: g  reason: collision with root package name */
    public String f34914g;

    /* renamed from: h  reason: collision with root package name */
    public String f34915h;

    /* renamed from: i  reason: collision with root package name */
    public String f34916i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0404a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f34917a;

        /* renamed from: b  reason: collision with root package name */
        public String f34918b;

        /* renamed from: c  reason: collision with root package name */
        public String f34919c;

        /* renamed from: d  reason: collision with root package name */
        public String f34920d;

        /* renamed from: e  reason: collision with root package name */
        public String f34921e;

        /* renamed from: f  reason: collision with root package name */
        public String f34922f;

        /* renamed from: g  reason: collision with root package name */
        public String f34923g;

        /* renamed from: h  reason: collision with root package name */
        public String f34924h;

        /* renamed from: i  reason: collision with root package name */
        public int f34925i = 0;

        public T a(int i2) {
            this.f34925i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f34917a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f34918b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f34919c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f34920d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f34921e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f34922f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f34923g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f34924h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0405b extends a<C0405b> {
        public C0405b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0404a
        /* renamed from: c */
        public C0405b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f34912e = aVar.f34918b;
        this.f34913f = aVar.f34919c;
        this.f34911d = aVar.f34917a;
        this.f34914g = aVar.f34920d;
        this.f34915h = aVar.f34921e;
        this.f34916i = aVar.f34922f;
        this.j = aVar.f34923g;
        this.k = aVar.f34924h;
        this.l = aVar.f34925i;
    }

    public static a<?> d() {
        return new C0405b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f34911d);
        cVar.a(Config.FEED_LIST_PART, this.f34912e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f34913f);
        cVar.a("pv", this.f34914g);
        cVar.a(Config.PACKAGE_NAME, this.f34915h);
        cVar.a("si", this.f34916i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
