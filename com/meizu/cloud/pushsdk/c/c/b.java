package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.f;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes10.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f74427d;

    /* renamed from: e  reason: collision with root package name */
    public String f74428e;

    /* renamed from: f  reason: collision with root package name */
    public String f74429f;

    /* renamed from: g  reason: collision with root package name */
    public String f74430g;

    /* renamed from: h  reason: collision with root package name */
    public String f74431h;

    /* renamed from: i  reason: collision with root package name */
    public String f74432i;

    /* renamed from: j  reason: collision with root package name */
    public String f74433j;
    public String k;
    public int l;

    /* loaded from: classes10.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2033a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f74434a;

        /* renamed from: b  reason: collision with root package name */
        public String f74435b;

        /* renamed from: c  reason: collision with root package name */
        public String f74436c;

        /* renamed from: d  reason: collision with root package name */
        public String f74437d;

        /* renamed from: e  reason: collision with root package name */
        public String f74438e;

        /* renamed from: f  reason: collision with root package name */
        public String f74439f;

        /* renamed from: g  reason: collision with root package name */
        public String f74440g;

        /* renamed from: h  reason: collision with root package name */
        public String f74441h;

        /* renamed from: i  reason: collision with root package name */
        public int f74442i = 0;

        public T a(int i2) {
            this.f74442i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f74434a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f74435b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f74436c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f74437d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f74438e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f74439f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f74440g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f74441h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2034b extends a<C2034b> {
        public C2034b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2033a
        /* renamed from: c */
        public C2034b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f74428e = aVar.f74435b;
        this.f74429f = aVar.f74436c;
        this.f74427d = aVar.f74434a;
        this.f74430g = aVar.f74437d;
        this.f74431h = aVar.f74438e;
        this.f74432i = aVar.f74439f;
        this.f74433j = aVar.f74440g;
        this.k = aVar.f74441h;
        this.l = aVar.f74442i;
    }

    public static a<?> d() {
        return new C2034b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(f.f39281a, this.f74427d);
        cVar.a("ti", this.f74428e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f74429f);
        cVar.a("pv", this.f74430g);
        cVar.a("pn", this.f74431h);
        cVar.a("si", this.f74432i);
        cVar.a("ms", this.f74433j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
