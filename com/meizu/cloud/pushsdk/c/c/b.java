package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes7.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f42099d;

    /* renamed from: e  reason: collision with root package name */
    public String f42100e;

    /* renamed from: f  reason: collision with root package name */
    public String f42101f;

    /* renamed from: g  reason: collision with root package name */
    public String f42102g;

    /* renamed from: h  reason: collision with root package name */
    public String f42103h;
    public String i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes7.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2025a<T> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f42104b;

        /* renamed from: c  reason: collision with root package name */
        public String f42105c;

        /* renamed from: d  reason: collision with root package name */
        public String f42106d;

        /* renamed from: e  reason: collision with root package name */
        public String f42107e;

        /* renamed from: f  reason: collision with root package name */
        public String f42108f;

        /* renamed from: g  reason: collision with root package name */
        public String f42109g;

        /* renamed from: h  reason: collision with root package name */
        public String f42110h;
        public int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f42104b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f42105c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f42106d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f42107e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f42108f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f42109g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f42110h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C2026b extends a<C2026b> {
        public C2026b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2025a
        /* renamed from: c */
        public C2026b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f42100e = aVar.f42104b;
        this.f42101f = aVar.f42105c;
        this.f42099d = aVar.a;
        this.f42102g = aVar.f42106d;
        this.f42103h = aVar.f42107e;
        this.i = aVar.f42108f;
        this.j = aVar.f42109g;
        this.k = aVar.f42110h;
        this.l = aVar.i;
    }

    public static a<?> d() {
        return new C2026b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f42099d);
        cVar.a(Config.FEED_LIST_PART, this.f42100e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f42101f);
        cVar.a("pv", this.f42102g);
        cVar.a(Config.PACKAGE_NAME, this.f42103h);
        cVar.a("si", this.i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a(TtmlNode.TAG_BR, Integer.valueOf(this.l));
        return a(cVar);
    }
}
