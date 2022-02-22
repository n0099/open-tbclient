package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes4.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f58915d;

    /* renamed from: e  reason: collision with root package name */
    public String f58916e;

    /* renamed from: f  reason: collision with root package name */
    public String f58917f;

    /* renamed from: g  reason: collision with root package name */
    public String f58918g;

    /* renamed from: h  reason: collision with root package name */
    public String f58919h;

    /* renamed from: i  reason: collision with root package name */
    public String f58920i;

    /* renamed from: j  reason: collision with root package name */
    public String f58921j;
    public String k;
    public int l;

    /* loaded from: classes4.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2185a<T> {
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f58922b;

        /* renamed from: c  reason: collision with root package name */
        public String f58923c;

        /* renamed from: d  reason: collision with root package name */
        public String f58924d;

        /* renamed from: e  reason: collision with root package name */
        public String f58925e;

        /* renamed from: f  reason: collision with root package name */
        public String f58926f;

        /* renamed from: g  reason: collision with root package name */
        public String f58927g;

        /* renamed from: h  reason: collision with root package name */
        public String f58928h;

        /* renamed from: i  reason: collision with root package name */
        public int f58929i = 0;

        public T a(int i2) {
            this.f58929i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f58922b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f58923c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f58924d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f58925e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f58926f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f58927g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f58928h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C2186b extends a<C2186b> {
        public C2186b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2185a
        /* renamed from: c */
        public C2186b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f58916e = aVar.f58922b;
        this.f58917f = aVar.f58923c;
        this.f58915d = aVar.a;
        this.f58918g = aVar.f58924d;
        this.f58919h = aVar.f58925e;
        this.f58920i = aVar.f58926f;
        this.f58921j = aVar.f58927g;
        this.k = aVar.f58928h;
        this.l = aVar.f58929i;
    }

    public static a<?> d() {
        return new C2186b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.a, this.f58915d);
        cVar.a("ti", this.f58916e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f58917f);
        cVar.a("pv", this.f58918g);
        cVar.a("pn", this.f58919h);
        cVar.a("si", this.f58920i);
        cVar.a("ms", this.f58921j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
