package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f33008a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f33009b;

    /* renamed from: c  reason: collision with root package name */
    public final f f33010c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f33011d;

    /* renamed from: e  reason: collision with root package name */
    public final String[] f33012e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33013f;

    /* renamed from: g  reason: collision with root package name */
    public final Context f33014g;

    /* renamed from: h  reason: collision with root package name */
    public final e f33015h;

    /* renamed from: i  reason: collision with root package name */
    public final String f33016i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f33017a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f33018b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f33019c = false;

        /* renamed from: d  reason: collision with root package name */
        public Context f33020d;

        /* renamed from: e  reason: collision with root package name */
        public e f33021e;

        /* renamed from: f  reason: collision with root package name */
        public String f33022f;

        /* renamed from: g  reason: collision with root package name */
        public String f33023g;

        /* renamed from: h  reason: collision with root package name */
        public String f33024h;

        /* renamed from: i  reason: collision with root package name */
        public String f33025i;
        public String j;
        public String k;
        public String l;
        public String m;
        public int n;
        public String o;
        public int p;
        public String q;
        public String r;
        public String s;
        public String t;
        public f u;
        public String[] v;

        public a a(int i2) {
            this.n = i2;
            return this;
        }

        public a a(Context context) {
            this.f33020d = context;
            return this;
        }

        public a a(e eVar) {
            this.f33021e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f33022f = str;
            return this;
        }

        public a a(String[] strArr) {
            this.v = strArr;
            return this;
        }

        public b a() {
            return new b(this);
        }

        public a b(int i2) {
            this.p = i2;
            return this;
        }

        public a b(String str) {
            this.f33024h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f33018b = strArr;
            return this;
        }

        public a c(int i2) {
            this.f33017a = i2;
            return this;
        }

        public a c(String str) {
            this.f33025i = str;
            return this;
        }

        public a d(String str) {
            this.k = str;
            return this;
        }

        public a e(String str) {
            this.l = str;
            return this;
        }

        public a f(String str) {
            this.m = str;
            return this;
        }

        public a g(String str) {
            this.o = str;
            return this;
        }

        public a h(String str) {
            this.q = str;
            return this;
        }

        public a i(String str) {
            this.r = str;
            return this;
        }

        public a j(String str) {
            this.s = str;
            return this;
        }

        public a k(String str) {
            this.t = str;
            return this;
        }
    }

    public b(a aVar) {
        this.f33008a = new com.kwad.sdk.crash.model.b();
        this.f33009b = new com.kwad.sdk.crash.model.a();
        this.f33013f = aVar.f33019c;
        this.f33014g = aVar.f33020d;
        this.f33015h = aVar.f33021e;
        this.f33016i = aVar.f33022f;
        this.j = aVar.f33023g;
        this.k = aVar.f33024h;
        this.l = aVar.f33025i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f33009b.f33053a = aVar.q;
        this.f33009b.f33054b = aVar.r;
        this.f33009b.f33056d = aVar.t;
        this.f33009b.f33055c = aVar.s;
        this.f33008a.f33060d = aVar.o;
        this.f33008a.f33061e = aVar.p;
        this.f33008a.f33058b = aVar.m;
        this.f33008a.f33059c = aVar.n;
        this.f33008a.f33057a = aVar.l;
        this.f33008a.f33062f = aVar.f33017a;
        this.f33010c = aVar.u;
        this.f33011d = aVar.v;
        this.f33012e = aVar.f33018b;
    }

    public e a() {
        return this.f33015h;
    }

    public boolean b() {
        return this.f33013f;
    }
}
