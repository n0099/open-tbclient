package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes5.dex */
public final class b {
    public final com.kwad.sdk.crash.model.b a;
    public final com.kwad.sdk.crash.model.a b;
    public final g c;
    public final String[] d;
    public final String[] e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final Context j;
    public final e k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;

    /* loaded from: classes5.dex */
    public static class a {
        public int a;
        public String[] b;
        public Context g;
        public e h;
        public String i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public int q;
        public String r;
        public int s;
        public String t;
        public String u;
        public String v;
        public String w;
        public g x;
        public String[] y;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public String z = "";
        public String A = "";

        public final a a(int i) {
            this.q = i;
            return this;
        }

        public final a a(Context context) {
            this.g = context;
            return this;
        }

        public final a a(e eVar) {
            this.h = eVar;
            return this;
        }

        public final a a(g gVar) {
            this.x = gVar;
            return this;
        }

        public final a a(String str) {
            this.z = str;
            return this;
        }

        public final a a(boolean z) {
            this.d = z;
            return this;
        }

        public final a a(String[] strArr) {
            this.y = strArr;
            return this;
        }

        public final b a() {
            return new b(this, (byte) 0);
        }

        public final a b(int i) {
            this.s = i;
            return this;
        }

        public final a b(String str) {
            this.A = str;
            return this;
        }

        public final a b(boolean z) {
            this.e = z;
            return this;
        }

        public final a b(String[] strArr) {
            this.b = strArr;
            return this;
        }

        public final a c(int i) {
            this.a = 1;
            return this;
        }

        public final a c(String str) {
            this.i = str;
            return this;
        }

        public final a c(boolean z) {
            this.f = z;
            return this;
        }

        public final a d(String str) {
            this.k = str;
            return this;
        }

        public final a e(String str) {
            this.l = str;
            return this;
        }

        public final a f(String str) {
            this.n = str;
            return this;
        }

        public final a g(String str) {
            this.o = str;
            return this;
        }

        public final a h(String str) {
            this.p = str;
            return this;
        }

        public final a i(String str) {
            this.r = str;
            return this;
        }

        public final a j(String str) {
            this.t = str;
            return this;
        }

        public final a k(String str) {
            this.u = str;
            return this;
        }

        public final a l(String str) {
            this.v = str;
            return this;
        }

        public final a m(String str) {
            this.w = str;
            return this;
        }
    }

    public b(a aVar) {
        this.a = new com.kwad.sdk.crash.model.b();
        this.b = new com.kwad.sdk.crash.model.a();
        this.f = aVar.c;
        this.g = aVar.d;
        this.h = aVar.e;
        this.i = aVar.f;
        this.r = aVar.z;
        this.s = aVar.A;
        this.j = aVar.g;
        this.k = aVar.h;
        this.l = aVar.i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.o = aVar.l;
        this.p = aVar.m;
        this.q = aVar.n;
        this.b.a = aVar.t;
        this.b.b = aVar.u;
        this.b.d = aVar.w;
        this.b.c = aVar.v;
        this.a.d = aVar.r;
        this.a.e = aVar.s;
        this.a.b = aVar.p;
        this.a.c = aVar.q;
        this.a.a = aVar.o;
        this.a.f = aVar.a;
        this.c = aVar.x;
        this.d = aVar.y;
        this.e = aVar.b;
    }

    public /* synthetic */ b(a aVar, byte b) {
        this(aVar);
    }

    public final e a() {
        return this.k;
    }

    public final boolean b() {
        return this.f;
    }
}
