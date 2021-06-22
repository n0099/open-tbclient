package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes7.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f38617d;

    /* renamed from: e  reason: collision with root package name */
    public String f38618e;

    /* renamed from: f  reason: collision with root package name */
    public String f38619f;

    /* renamed from: g  reason: collision with root package name */
    public String f38620g;

    /* renamed from: h  reason: collision with root package name */
    public String f38621h;

    /* renamed from: i  reason: collision with root package name */
    public String f38622i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes7.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0459a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f38623a;

        /* renamed from: b  reason: collision with root package name */
        public String f38624b;

        /* renamed from: c  reason: collision with root package name */
        public String f38625c;

        /* renamed from: d  reason: collision with root package name */
        public String f38626d;

        /* renamed from: e  reason: collision with root package name */
        public String f38627e;

        /* renamed from: f  reason: collision with root package name */
        public String f38628f;

        /* renamed from: g  reason: collision with root package name */
        public String f38629g;

        /* renamed from: h  reason: collision with root package name */
        public String f38630h;

        /* renamed from: i  reason: collision with root package name */
        public int f38631i = 0;

        public T a(int i2) {
            this.f38631i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f38623a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f38624b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f38625c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f38626d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f38627e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f38628f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f38629g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f38630h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0460b extends a<C0460b> {
        public C0460b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0459a
        /* renamed from: c */
        public C0460b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f38618e = aVar.f38624b;
        this.f38619f = aVar.f38625c;
        this.f38617d = aVar.f38623a;
        this.f38620g = aVar.f38626d;
        this.f38621h = aVar.f38627e;
        this.f38622i = aVar.f38628f;
        this.j = aVar.f38629g;
        this.k = aVar.f38630h;
        this.l = aVar.f38631i;
    }

    public static a<?> d() {
        return new C0460b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f38617d);
        cVar.a(Config.FEED_LIST_PART, this.f38618e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f38619f);
        cVar.a("pv", this.f38620g);
        cVar.a(Config.PACKAGE_NAME, this.f38621h);
        cVar.a("si", this.f38622i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
