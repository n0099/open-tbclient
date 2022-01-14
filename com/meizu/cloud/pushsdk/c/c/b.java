package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes3.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f58703d;

    /* renamed from: e  reason: collision with root package name */
    public String f58704e;

    /* renamed from: f  reason: collision with root package name */
    public String f58705f;

    /* renamed from: g  reason: collision with root package name */
    public String f58706g;

    /* renamed from: h  reason: collision with root package name */
    public String f58707h;

    /* renamed from: i  reason: collision with root package name */
    public String f58708i;

    /* renamed from: j  reason: collision with root package name */
    public String f58709j;
    public String k;
    public int l;

    /* loaded from: classes3.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2169a<T> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58710b;

        /* renamed from: c  reason: collision with root package name */
        public String f58711c;

        /* renamed from: d  reason: collision with root package name */
        public String f58712d;

        /* renamed from: e  reason: collision with root package name */
        public String f58713e;

        /* renamed from: f  reason: collision with root package name */
        public String f58714f;

        /* renamed from: g  reason: collision with root package name */
        public String f58715g;

        /* renamed from: h  reason: collision with root package name */
        public String f58716h;

        /* renamed from: i  reason: collision with root package name */
        public int f58717i = 0;

        public T a(int i2) {
            this.f58717i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f58710b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f58711c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f58712d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f58713e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f58714f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f58715g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f58716h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C2170b extends a<C2170b> {
        public C2170b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2169a
        /* renamed from: c */
        public C2170b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f58704e = aVar.f58710b;
        this.f58705f = aVar.f58711c;
        this.f58703d = aVar.a;
        this.f58706g = aVar.f58712d;
        this.f58707h = aVar.f58713e;
        this.f58708i = aVar.f58714f;
        this.f58709j = aVar.f58715g;
        this.k = aVar.f58716h;
        this.l = aVar.f58717i;
    }

    public static a<?> d() {
        return new C2170b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.a, this.f58703d);
        cVar.a("ti", this.f58704e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f58705f);
        cVar.a("pv", this.f58706g);
        cVar.a("pn", this.f58707h);
        cVar.a("si", this.f58708i);
        cVar.a("ms", this.f58709j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
