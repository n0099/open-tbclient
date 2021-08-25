package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.f;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes10.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f74627d;

    /* renamed from: e  reason: collision with root package name */
    public String f74628e;

    /* renamed from: f  reason: collision with root package name */
    public String f74629f;

    /* renamed from: g  reason: collision with root package name */
    public String f74630g;

    /* renamed from: h  reason: collision with root package name */
    public String f74631h;

    /* renamed from: i  reason: collision with root package name */
    public String f74632i;

    /* renamed from: j  reason: collision with root package name */
    public String f74633j;
    public String k;
    public int l;

    /* loaded from: classes10.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC2037a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f74634a;

        /* renamed from: b  reason: collision with root package name */
        public String f74635b;

        /* renamed from: c  reason: collision with root package name */
        public String f74636c;

        /* renamed from: d  reason: collision with root package name */
        public String f74637d;

        /* renamed from: e  reason: collision with root package name */
        public String f74638e;

        /* renamed from: f  reason: collision with root package name */
        public String f74639f;

        /* renamed from: g  reason: collision with root package name */
        public String f74640g;

        /* renamed from: h  reason: collision with root package name */
        public String f74641h;

        /* renamed from: i  reason: collision with root package name */
        public int f74642i = 0;

        public T a(int i2) {
            this.f74642i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f74634a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f74635b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f74636c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f74637d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f74638e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f74639f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f74640g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f74641h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2038b extends a<C2038b> {
        public C2038b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC2037a
        /* renamed from: c */
        public C2038b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f74628e = aVar.f74635b;
        this.f74629f = aVar.f74636c;
        this.f74627d = aVar.f74634a;
        this.f74630g = aVar.f74637d;
        this.f74631h = aVar.f74638e;
        this.f74632i = aVar.f74639f;
        this.f74633j = aVar.f74640g;
        this.k = aVar.f74641h;
        this.l = aVar.f74642i;
    }

    public static a<?> d() {
        return new C2038b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(f.f39388a, this.f74627d);
        cVar.a("ti", this.f74628e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f74629f);
        cVar.a("pv", this.f74630g);
        cVar.a("pn", this.f74631h);
        cVar.a("si", this.f74632i);
        cVar.a("ms", this.f74633j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
