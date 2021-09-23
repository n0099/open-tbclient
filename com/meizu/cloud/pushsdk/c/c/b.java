package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes10.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f75126d;

    /* renamed from: e  reason: collision with root package name */
    public String f75127e;

    /* renamed from: f  reason: collision with root package name */
    public String f75128f;

    /* renamed from: g  reason: collision with root package name */
    public String f75129g;

    /* renamed from: h  reason: collision with root package name */
    public String f75130h;

    /* renamed from: i  reason: collision with root package name */
    public String f75131i;

    /* renamed from: j  reason: collision with root package name */
    public String f75132j;
    public String k;
    public int l;

    /* loaded from: classes10.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2041a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f75133a;

        /* renamed from: b  reason: collision with root package name */
        public String f75134b;

        /* renamed from: c  reason: collision with root package name */
        public String f75135c;

        /* renamed from: d  reason: collision with root package name */
        public String f75136d;

        /* renamed from: e  reason: collision with root package name */
        public String f75137e;

        /* renamed from: f  reason: collision with root package name */
        public String f75138f;

        /* renamed from: g  reason: collision with root package name */
        public String f75139g;

        /* renamed from: h  reason: collision with root package name */
        public String f75140h;

        /* renamed from: i  reason: collision with root package name */
        public int f75141i = 0;

        public T a(int i2) {
            this.f75141i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f75133a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f75134b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f75135c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f75136d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f75137e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f75138f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f75139g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f75140h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2042b extends a<C2042b> {
        public C2042b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2041a
        /* renamed from: c */
        public C2042b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f75127e = aVar.f75134b;
        this.f75128f = aVar.f75135c;
        this.f75126d = aVar.f75133a;
        this.f75129g = aVar.f75136d;
        this.f75130h = aVar.f75137e;
        this.f75131i = aVar.f75138f;
        this.f75132j = aVar.f75139g;
        this.k = aVar.f75140h;
        this.l = aVar.f75141i;
    }

    public static a<?> d() {
        return new C2042b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.f39556a, this.f75126d);
        cVar.a("ti", this.f75127e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f75128f);
        cVar.a("pv", this.f75129g);
        cVar.a("pn", this.f75130h);
        cVar.a("si", this.f75131i);
        cVar.a("ms", this.f75132j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
