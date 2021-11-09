package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes2.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f67522d;

    /* renamed from: e  reason: collision with root package name */
    public String f67523e;

    /* renamed from: f  reason: collision with root package name */
    public String f67524f;

    /* renamed from: g  reason: collision with root package name */
    public String f67525g;

    /* renamed from: h  reason: collision with root package name */
    public String f67526h;

    /* renamed from: i  reason: collision with root package name */
    public String f67527i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes2.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC1953a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f67528a;

        /* renamed from: b  reason: collision with root package name */
        public String f67529b;

        /* renamed from: c  reason: collision with root package name */
        public String f67530c;

        /* renamed from: d  reason: collision with root package name */
        public String f67531d;

        /* renamed from: e  reason: collision with root package name */
        public String f67532e;

        /* renamed from: f  reason: collision with root package name */
        public String f67533f;

        /* renamed from: g  reason: collision with root package name */
        public String f67534g;

        /* renamed from: h  reason: collision with root package name */
        public String f67535h;

        /* renamed from: i  reason: collision with root package name */
        public int f67536i = 0;

        public T a(int i2) {
            this.f67536i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f67528a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f67529b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f67530c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f67531d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f67532e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f67533f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f67534g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f67535h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1954b extends a<C1954b> {
        public C1954b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC1953a
        /* renamed from: c */
        public C1954b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f67523e = aVar.f67529b;
        this.f67524f = aVar.f67530c;
        this.f67522d = aVar.f67528a;
        this.f67525g = aVar.f67531d;
        this.f67526h = aVar.f67532e;
        this.f67527i = aVar.f67533f;
        this.j = aVar.f67534g;
        this.k = aVar.f67535h;
        this.l = aVar.f67536i;
    }

    public static a<?> d() {
        return new C1954b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.f37503a, this.f67522d);
        cVar.a("ti", this.f67523e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f67524f);
        cVar.a("pv", this.f67525g);
        cVar.a("pn", this.f67526h);
        cVar.a("si", this.f67527i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
