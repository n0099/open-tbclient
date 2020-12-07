package com.meizu.cloud.pushsdk.c.c;

import com.baidu.fsg.base.statistics.h;
import com.baidu.mobstat.Config;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes16.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;

    /* loaded from: classes16.dex */
    public static abstract class a<T extends a<T>> extends a.AbstractC1010a<T> {

        /* renamed from: a  reason: collision with root package name */
        private String f4166a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.f4166a = str;
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

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    private static class C1011b extends a<C1011b> {
        private C1011b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC1010a
        /* renamed from: c */
        public C1011b a() {
            return this;
        }
    }

    protected b(a<?> aVar) {
        super(aVar);
        this.e = ((a) aVar).b;
        this.f = ((a) aVar).c;
        this.d = ((a) aVar).f4166a;
        this.g = ((a) aVar).d;
        this.h = ((a) aVar).e;
        this.i = ((a) aVar).f;
        this.j = ((a) aVar).g;
        this.k = ((a) aVar).h;
        this.l = ((a) aVar).i;
    }

    public static a<?> d() {
        return new C1011b();
    }

    public c e() {
        c cVar = new c();
        cVar.a(h.f1497a, this.d);
        cVar.a(Config.FEED_LIST_PART, this.e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f);
        cVar.a("pv", this.g);
        cVar.a(Config.PACKAGE_NAME, this.h);
        cVar.a("si", this.i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a("br", Integer.valueOf(this.l));
        return a(cVar);
    }
}
