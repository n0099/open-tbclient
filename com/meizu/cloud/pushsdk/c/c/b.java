package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes6.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f37727d;

    /* renamed from: e  reason: collision with root package name */
    public String f37728e;

    /* renamed from: f  reason: collision with root package name */
    public String f37729f;

    /* renamed from: g  reason: collision with root package name */
    public String f37730g;

    /* renamed from: h  reason: collision with root package name */
    public String f37731h;
    public String i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes6.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0455a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f37732a;

        /* renamed from: b  reason: collision with root package name */
        public String f37733b;

        /* renamed from: c  reason: collision with root package name */
        public String f37734c;

        /* renamed from: d  reason: collision with root package name */
        public String f37735d;

        /* renamed from: e  reason: collision with root package name */
        public String f37736e;

        /* renamed from: f  reason: collision with root package name */
        public String f37737f;

        /* renamed from: g  reason: collision with root package name */
        public String f37738g;

        /* renamed from: h  reason: collision with root package name */
        public String f37739h;
        public int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.f37732a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f37733b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f37734c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f37735d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f37736e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f37737f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f37738g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f37739h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0456b extends a<C0456b> {
        public C0456b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0455a
        /* renamed from: c */
        public C0456b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f37728e = aVar.f37733b;
        this.f37729f = aVar.f37734c;
        this.f37727d = aVar.f37732a;
        this.f37730g = aVar.f37735d;
        this.f37731h = aVar.f37736e;
        this.i = aVar.f37737f;
        this.j = aVar.f37738g;
        this.k = aVar.f37739h;
        this.l = aVar.i;
    }

    public static a<?> d() {
        return new C0456b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f37727d);
        cVar.a(Config.FEED_LIST_PART, this.f37728e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f37729f);
        cVar.a("pv", this.f37730g);
        cVar.a(Config.PACKAGE_NAME, this.f37731h);
        cVar.a("si", this.i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
