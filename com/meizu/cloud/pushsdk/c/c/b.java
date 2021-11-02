package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes2.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f67523d;

    /* renamed from: e  reason: collision with root package name */
    public String f67524e;

    /* renamed from: f  reason: collision with root package name */
    public String f67525f;

    /* renamed from: g  reason: collision with root package name */
    public String f67526g;

    /* renamed from: h  reason: collision with root package name */
    public String f67527h;

    /* renamed from: i  reason: collision with root package name */
    public String f67528i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes2.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC1953a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f67529a;

        /* renamed from: b  reason: collision with root package name */
        public String f67530b;

        /* renamed from: c  reason: collision with root package name */
        public String f67531c;

        /* renamed from: d  reason: collision with root package name */
        public String f67532d;

        /* renamed from: e  reason: collision with root package name */
        public String f67533e;

        /* renamed from: f  reason: collision with root package name */
        public String f67534f;

        /* renamed from: g  reason: collision with root package name */
        public String f67535g;

        /* renamed from: h  reason: collision with root package name */
        public String f67536h;

        /* renamed from: i  reason: collision with root package name */
        public int f67537i = 0;

        public T a(int i2) {
            this.f67537i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f67529a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f67530b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f67531c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f67532d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f67533e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f67534f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f67535g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f67536h = str;
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
        this.f67524e = aVar.f67530b;
        this.f67525f = aVar.f67531c;
        this.f67523d = aVar.f67529a;
        this.f67526g = aVar.f67532d;
        this.f67527h = aVar.f67533e;
        this.f67528i = aVar.f67534f;
        this.j = aVar.f67535g;
        this.k = aVar.f67536h;
        this.l = aVar.f67537i;
    }

    public static a<?> d() {
        return new C1954b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.f37503a, this.f67523d);
        cVar.a("ti", this.f67524e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f67525f);
        cVar.a("pv", this.f67526g);
        cVar.a("pn", this.f67527h);
        cVar.a("si", this.f67528i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
