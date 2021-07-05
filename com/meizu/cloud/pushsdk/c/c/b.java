package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes7.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f40380d;

    /* renamed from: e  reason: collision with root package name */
    public String f40381e;

    /* renamed from: f  reason: collision with root package name */
    public String f40382f;

    /* renamed from: g  reason: collision with root package name */
    public String f40383g;

    /* renamed from: h  reason: collision with root package name */
    public String f40384h;

    /* renamed from: i  reason: collision with root package name */
    public String f40385i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes7.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0503a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f40386a;

        /* renamed from: b  reason: collision with root package name */
        public String f40387b;

        /* renamed from: c  reason: collision with root package name */
        public String f40388c;

        /* renamed from: d  reason: collision with root package name */
        public String f40389d;

        /* renamed from: e  reason: collision with root package name */
        public String f40390e;

        /* renamed from: f  reason: collision with root package name */
        public String f40391f;

        /* renamed from: g  reason: collision with root package name */
        public String f40392g;

        /* renamed from: h  reason: collision with root package name */
        public String f40393h;

        /* renamed from: i  reason: collision with root package name */
        public int f40394i = 0;

        public T a(int i2) {
            this.f40394i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f40386a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f40387b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f40388c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f40389d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f40390e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f40391f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f40392g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f40393h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0504b extends a<C0504b> {
        public C0504b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0503a
        /* renamed from: c */
        public C0504b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f40381e = aVar.f40387b;
        this.f40382f = aVar.f40388c;
        this.f40380d = aVar.f40386a;
        this.f40383g = aVar.f40389d;
        this.f40384h = aVar.f40390e;
        this.f40385i = aVar.f40391f;
        this.j = aVar.f40392g;
        this.k = aVar.f40393h;
        this.l = aVar.f40394i;
    }

    public static a<?> d() {
        return new C0504b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f40380d);
        cVar.a(Config.FEED_LIST_PART, this.f40381e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f40382f);
        cVar.a("pv", this.f40383g);
        cVar.a(Config.PACKAGE_NAME, this.f40384h);
        cVar.a("si", this.f40385i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
