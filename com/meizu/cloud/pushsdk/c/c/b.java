package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes2.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f68435d;

    /* renamed from: e  reason: collision with root package name */
    public String f68436e;

    /* renamed from: f  reason: collision with root package name */
    public String f68437f;

    /* renamed from: g  reason: collision with root package name */
    public String f68438g;

    /* renamed from: h  reason: collision with root package name */
    public String f68439h;

    /* renamed from: i  reason: collision with root package name */
    public String f68440i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes2.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC1993a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f68441a;

        /* renamed from: b  reason: collision with root package name */
        public String f68442b;

        /* renamed from: c  reason: collision with root package name */
        public String f68443c;

        /* renamed from: d  reason: collision with root package name */
        public String f68444d;

        /* renamed from: e  reason: collision with root package name */
        public String f68445e;

        /* renamed from: f  reason: collision with root package name */
        public String f68446f;

        /* renamed from: g  reason: collision with root package name */
        public String f68447g;

        /* renamed from: h  reason: collision with root package name */
        public String f68448h;

        /* renamed from: i  reason: collision with root package name */
        public int f68449i = 0;

        public T a(int i2) {
            this.f68449i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f68441a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f68442b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f68443c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f68444d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f68445e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f68446f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f68447g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f68448h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1994b extends a<C1994b> {
        public C1994b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC1993a
        /* renamed from: c */
        public C1994b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f68436e = aVar.f68442b;
        this.f68437f = aVar.f68443c;
        this.f68435d = aVar.f68441a;
        this.f68438g = aVar.f68444d;
        this.f68439h = aVar.f68445e;
        this.f68440i = aVar.f68446f;
        this.j = aVar.f68447g;
        this.k = aVar.f68448h;
        this.l = aVar.f68449i;
    }

    public static a<?> d() {
        return new C1994b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.f38333a, this.f68435d);
        cVar.a("ti", this.f68436e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f68437f);
        cVar.a("pv", this.f68438g);
        cVar.a("pn", this.f68439h);
        cVar.a("si", this.f68440i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
