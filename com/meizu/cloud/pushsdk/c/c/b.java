package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes2.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f60431d;

    /* renamed from: e  reason: collision with root package name */
    public String f60432e;

    /* renamed from: f  reason: collision with root package name */
    public String f60433f;

    /* renamed from: g  reason: collision with root package name */
    public String f60434g;

    /* renamed from: h  reason: collision with root package name */
    public String f60435h;

    /* renamed from: i  reason: collision with root package name */
    public String f60436i;

    /* renamed from: j  reason: collision with root package name */
    public String f60437j;

    /* renamed from: k  reason: collision with root package name */
    public String f60438k;
    public int l;

    /* loaded from: classes2.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2084a<T> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f60439b;

        /* renamed from: c  reason: collision with root package name */
        public String f60440c;

        /* renamed from: d  reason: collision with root package name */
        public String f60441d;

        /* renamed from: e  reason: collision with root package name */
        public String f60442e;

        /* renamed from: f  reason: collision with root package name */
        public String f60443f;

        /* renamed from: g  reason: collision with root package name */
        public String f60444g;

        /* renamed from: h  reason: collision with root package name */
        public String f60445h;

        /* renamed from: i  reason: collision with root package name */
        public int f60446i = 0;

        public T a(int i2) {
            this.f60446i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f60439b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f60440c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f60441d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f60442e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f60443f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f60444g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f60445h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C2085b extends a<C2085b> {
        public C2085b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2084a
        /* renamed from: c */
        public C2085b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f60432e = aVar.f60439b;
        this.f60433f = aVar.f60440c;
        this.f60431d = aVar.a;
        this.f60434g = aVar.f60441d;
        this.f60435h = aVar.f60442e;
        this.f60436i = aVar.f60443f;
        this.f60437j = aVar.f60444g;
        this.f60438k = aVar.f60445h;
        this.l = aVar.f60446i;
    }

    public static a<?> d() {
        return new C2085b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.a, this.f60431d);
        cVar.a("ti", this.f60432e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f60433f);
        cVar.a("pv", this.f60434g);
        cVar.a("pn", this.f60435h);
        cVar.a("si", this.f60436i);
        cVar.a("ms", this.f60437j);
        cVar.a("ect", this.f60438k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
