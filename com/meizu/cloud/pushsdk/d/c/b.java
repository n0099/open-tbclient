package com.meizu.cloud.pushsdk.d.c;

import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes9.dex */
public class b extends com.meizu.cloud.pushsdk.d.c.a {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;

    /* loaded from: classes9.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC0683a<T> {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.a = str;
            return (T) a();
        }

        public T b(String str) {
            this.b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.c = str;
            return (T) a();
        }

        public T d(String str) {
            this.d = str;
            return (T) a();
        }

        public T e(String str) {
            this.e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f = str;
            return (T) a();
        }

        public T g(String str) {
            this.g = str;
            return (T) a();
        }

        public T h(String str) {
            this.h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0684b extends a<C0684b> {
        public C0684b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.d.c.a.AbstractC0683a
        /* renamed from: c */
        public C0684b a() {
            return this;
        }
    }

    public b(a<?> aVar) {
        super(aVar);
        this.b = aVar.b;
        this.c = aVar.c;
        this.a = aVar.a;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
    }

    public static a<?> d() {
        return new C0684b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.a);
        cVar.a(Config.FEED_LIST_PART, this.b);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.c);
        cVar.a("pv", this.d);
        cVar.a("pn", this.e);
        cVar.a("si", this.f);
        cVar.a("ms", this.g);
        cVar.a("ect", this.h);
        cVar.a("br", Integer.valueOf(this.i));
        return a(cVar);
    }
}
