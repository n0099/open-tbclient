package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes7.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {

    /* renamed from: d  reason: collision with root package name */
    public String f38519d;

    /* renamed from: e  reason: collision with root package name */
    public String f38520e;

    /* renamed from: f  reason: collision with root package name */
    public String f38521f;

    /* renamed from: g  reason: collision with root package name */
    public String f38522g;

    /* renamed from: h  reason: collision with root package name */
    public String f38523h;

    /* renamed from: i  reason: collision with root package name */
    public String f38524i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes7.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0456a<T> {

        /* renamed from: a  reason: collision with root package name */
        public String f38525a;

        /* renamed from: b  reason: collision with root package name */
        public String f38526b;

        /* renamed from: c  reason: collision with root package name */
        public String f38527c;

        /* renamed from: d  reason: collision with root package name */
        public String f38528d;

        /* renamed from: e  reason: collision with root package name */
        public String f38529e;

        /* renamed from: f  reason: collision with root package name */
        public String f38530f;

        /* renamed from: g  reason: collision with root package name */
        public String f38531g;

        /* renamed from: h  reason: collision with root package name */
        public String f38532h;

        /* renamed from: i  reason: collision with root package name */
        public int f38533i = 0;

        public T a(int i2) {
            this.f38533i = i2;
            return (T) a();
        }

        public T a(String str) {
            this.f38525a = str;
            return (T) a();
        }

        public T b(String str) {
            this.f38526b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f38527c = str;
            return (T) a();
        }

        public T d(String str) {
            this.f38528d = str;
            return (T) a();
        }

        public T e(String str) {
            this.f38529e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f38530f = str;
            return (T) a();
        }

        public T g(String str) {
            this.f38531g = str;
            return (T) a();
        }

        public T h(String str) {
            this.f38532h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0457b extends a<C0457b> {
        public C0457b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0456a
        /* renamed from: c */
        public C0457b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.f38520e = aVar.f38526b;
        this.f38521f = aVar.f38527c;
        this.f38519d = aVar.f38525a;
        this.f38522g = aVar.f38528d;
        this.f38523h = aVar.f38529e;
        this.f38524i = aVar.f38530f;
        this.j = aVar.f38531g;
        this.k = aVar.f38532h;
        this.l = aVar.f38533i;
    }

    public static a<?> d() {
        return new C0457b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f38519d);
        cVar.a(Config.FEED_LIST_PART, this.f38520e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f38521f);
        cVar.a("pv", this.f38522g);
        cVar.a(Config.PACKAGE_NAME, this.f38523h);
        cVar.a("si", this.f38524i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
