package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.ss.android.a.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private String f7682a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private transient Object i;
    private int j;
    private boolean k;
    private boolean l;
    private String m;
    private JSONObject pzr;

    public b() {
    }

    private b(a aVar) {
        this.f7682a = aVar.f7683a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
        this.m = aVar.m;
        this.pzr = aVar.pzr;
    }

    @Override // com.ss.android.a.a.b.b
    public String a() {
        return this.m;
    }

    @Override // com.ss.android.a.a.b.b
    public String b() {
        return this.f7682a;
    }

    @Override // com.ss.android.a.a.b.b
    public String c() {
        return this.b;
    }

    @Override // com.ss.android.a.a.b.b
    public String d() {
        return this.c;
    }

    @Override // com.ss.android.a.a.b.b
    public String e() {
        return this.d;
    }

    @Override // com.ss.android.a.a.b.b
    public String f() {
        return this.e;
    }

    @Override // com.ss.android.a.a.b.b
    public String g() {
        return this.f;
    }

    @Override // com.ss.android.a.a.b.b
    public String h() {
        return this.g;
    }

    @Override // com.ss.android.a.a.b.b
    public String i() {
        return this.h;
    }

    @Override // com.ss.android.a.a.b.b
    public Object eEh() {
        return this.i;
    }

    @Override // com.ss.android.a.a.b.b
    public int k() {
        return this.j;
    }

    @Override // com.ss.android.a.a.b.b
    public boolean l() {
        return this.k;
    }

    @Override // com.ss.android.a.a.b.b
    public boolean m() {
        return this.l;
    }

    @Override // com.ss.android.a.a.b.b
    public JSONObject n() {
        return this.pzr;
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f7683a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private Object i;
        private int j;
        private boolean k = true;
        private boolean l = false;
        private String m;
        private JSONObject pzr;

        public a aaE(String str) {
            this.f7683a = str;
            return this;
        }

        public a aaF(String str) {
            this.b = str;
            return this;
        }

        public a aaG(String str) {
            this.d = str;
            return this;
        }

        public a aaH(String str) {
            this.e = str;
            return this;
        }

        public a aaI(String str) {
            this.f = str;
            return this;
        }

        public a aaJ(String str) {
            this.g = str;
            return this;
        }

        @Deprecated
        public a aaK(String str) {
            return this;
        }

        public a aaL(String str) {
            this.h = str;
            return this;
        }

        public a QU(int i) {
            this.j = i;
            return this;
        }

        public a BO(boolean z) {
            this.k = z;
            return this;
        }

        @Deprecated
        public a BP(boolean z) {
            return this;
        }

        public a BQ(boolean z) {
            this.l = z;
            return this;
        }

        public a aaM(String str) {
            this.m = str;
            return this;
        }

        public b eEr() {
            return new b(this);
        }
    }
}
