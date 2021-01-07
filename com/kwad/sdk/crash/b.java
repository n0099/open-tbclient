package com.kwad.sdk.crash;

import android.content.Context;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.b f9921a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.crash.model.a f9922b;
    public final f c;
    public final String[] d;
    public final String[] e;
    public final boolean f;
    public final Context g;
    public final e h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f9923a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f9924b;
        private boolean c = false;
        private Context d;
        private e e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private int n;
        private String o;
        private int p;
        private String q;
        private String r;
        private String s;
        private String t;
        private f u;
        private String[] v;

        public a a(int i) {
            this.n = i;
            return this;
        }

        public a a(Context context) {
            this.d = context;
            return this;
        }

        public a a(e eVar) {
            this.e = eVar;
            return this;
        }

        public a a(f fVar) {
            this.u = fVar;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a a(String[] strArr) {
            this.v = strArr;
            return this;
        }

        public b a() {
            return new b(this);
        }

        public a b(int i) {
            this.p = i;
            return this;
        }

        public a b(String str) {
            this.h = str;
            return this;
        }

        public a b(String[] strArr) {
            this.f9924b = strArr;
            return this;
        }

        public a c(int i) {
            this.f9923a = i;
            return this;
        }

        public a c(String str) {
            this.i = str;
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

    private b(a aVar) {
        this.f9921a = new com.kwad.sdk.crash.model.b();
        this.f9922b = new com.kwad.sdk.crash.model.a();
        this.f = aVar.c;
        this.g = aVar.d;
        this.h = aVar.e;
        this.i = aVar.f;
        this.j = aVar.g;
        this.k = aVar.h;
        this.l = aVar.i;
        this.m = aVar.j;
        this.n = aVar.k;
        this.f9922b.f9938a = aVar.q;
        this.f9922b.f9939b = aVar.r;
        this.f9922b.d = aVar.t;
        this.f9922b.c = aVar.s;
        this.f9921a.d = aVar.o;
        this.f9921a.e = aVar.p;
        this.f9921a.f9941b = aVar.m;
        this.f9921a.c = aVar.n;
        this.f9921a.f9940a = aVar.l;
        this.f9921a.f = aVar.f9923a;
        this.c = aVar.u;
        this.d = aVar.v;
        this.e = aVar.f9924b;
    }

    public e a() {
        return this.h;
    }

    public boolean b() {
        return this.f;
    }
}
