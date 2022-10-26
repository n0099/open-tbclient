package com.meizu.cloud.pushsdk.c.c;

import com.baidu.mobstat.Config;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.meizu.cloud.pushsdk.c.a.c;
import com.meizu.cloud.pushsdk.c.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
/* loaded from: classes8.dex */
public class b extends com.meizu.cloud.pushsdk.c.c.a {
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;

    /* loaded from: classes8.dex */
    public abstract class a extends a.AbstractC0637a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public int i = 0;

        public a a(int i) {
            this.i = i;
            return (a) a();
        }

        public a a(String str) {
            this.a = str;
            return (a) a();
        }

        public a b(String str) {
            this.b = str;
            return (a) a();
        }

        public b b() {
            return new b(this);
        }

        public a c(String str) {
            this.c = str;
            return (a) a();
        }

        public a d(String str) {
            this.d = str;
            return (a) a();
        }

        public a e(String str) {
            this.e = str;
            return (a) a();
        }

        public a f(String str) {
            this.f = str;
            return (a) a();
        }

        public a g(String str) {
            this.g = str;
            return (a) a();
        }

        public a h(String str) {
            this.h = str;
            return (a) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0638b extends a {
        public C0638b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.meizu.cloud.pushsdk.c.c.a.AbstractC0637a
        /* renamed from: c */
        public C0638b a() {
            return this;
        }
    }

    public b(a aVar) {
        super(aVar);
        this.e = aVar.b;
        this.f = aVar.c;
        this.d = aVar.a;
        this.g = aVar.d;
        this.h = aVar.e;
        this.i = aVar.f;
        this.j = aVar.g;
        this.k = aVar.h;
        this.l = aVar.i;
    }

    public static a d() {
        return new C0638b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.d);
        cVar.a(Config.FEED_LIST_PART, this.e);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f);
        cVar.a("pv", this.g);
        cVar.a("pn", this.h);
        cVar.a("si", this.i);
        cVar.a("ms", this.j);
        cVar.a("ect", this.k);
        cVar.a(TtmlNode.TAG_BR, Integer.valueOf(this.l));
        return a(cVar);
    }
}
