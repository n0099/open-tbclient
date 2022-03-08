package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes8.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f57265d;

    /* renamed from: e  reason: collision with root package name */
    public String f57266e;

    /* renamed from: f  reason: collision with root package name */
    public String f57267f;

    /* renamed from: g  reason: collision with root package name */
    public String f57268g;

    /* renamed from: h  reason: collision with root package name */
    public String f57269h;

    /* renamed from: i  reason: collision with root package name */
    public String f57270i;

    /* renamed from: j  reason: collision with root package name */
    public String f57271j;
    public String k;
    public int l;

    /* loaded from: classes8.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2164a<T> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f57272b;

        /* renamed from: c  reason: collision with root package name */
        public String f57273c;

        /* renamed from: d  reason: collision with root package name */
        public String f57274d;

        /* renamed from: e  reason: collision with root package name */
        public String f57275e;

        /* renamed from: f  reason: collision with root package name */
        public String f57276f;

        /* renamed from: g  reason: collision with root package name */
        public String f57277g;

        /* renamed from: h  reason: collision with root package name */
        public String f57278h;

        /* renamed from: i  reason: collision with root package name */
        public int f57279i = 0;

        public T a(int i2) {
            this.f57279i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f57272b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f57273c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f57274d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f57275e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f57276f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f57277g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f57278h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C2165b extends a<C2165b> {
        public C2165b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2164a
        /* renamed from: c */
        public C2165b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f57266e = aVar.f57272b;
        this.f57267f = aVar.f57273c;
        this.f57265d = aVar.a;
        this.f57268g = aVar.f57274d;
        this.f57269h = aVar.f57275e;
        this.f57270i = aVar.f57276f;
        this.f57271j = aVar.f57277g;
        this.k = aVar.f57278h;
        this.l = aVar.f57279i;
    }

    public static a<?> d() {
        return new C2165b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.a, this.f57265d);
        cVar.a("ti", this.f57266e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f57267f);
        cVar.a("pv", this.f57268g);
        cVar.a("pn", this.f57269h);
        cVar.a("si", this.f57270i);
        cVar.a("ms", this.f57271j);
        cVar.a("ect", this.k);
        cVar.a(TtmlNode.TAG_BR, Integer.valueOf(this.l));
        return a(cVar);
    }
}
