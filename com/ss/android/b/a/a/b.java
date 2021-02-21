package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements com.ss.android.a.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private String f12914a;

    /* renamed from: b  reason: collision with root package name */
    private String f12915b;
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
    private JSONObject pxm;

    public b() {
    }

    private b(a aVar) {
        this.f12914a = aVar.f12916a;
        this.f12915b = aVar.f12917b;
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
        this.pxm = aVar.pxm;
    }

    @Override // com.ss.android.a.a.b.b
    public String a() {
        return this.m;
    }

    @Override // com.ss.android.a.a.b.b
    public String b() {
        return this.f12914a;
    }

    @Override // com.ss.android.a.a.b.b
    public String c() {
        return this.f12915b;
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
    public Object eEb() {
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
    public JSONObject eEc() {
        return this.pxm;
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f12916a;

        /* renamed from: b  reason: collision with root package name */
        private String f12917b;
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
        private JSONObject pxm;

        public a aaz(String str) {
            this.f12916a = str;
            return this;
        }

        public a aaA(String str) {
            this.f12917b = str;
            return this;
        }

        public a aaB(String str) {
            this.d = str;
            return this;
        }

        public a aaC(String str) {
            this.e = str;
            return this;
        }

        public a aaD(String str) {
            this.f = str;
            return this;
        }

        public a aaE(String str) {
            this.g = str;
            return this;
        }

        @Deprecated
        public a aaF(String str) {
            return this;
        }

        public a aaG(String str) {
            this.h = str;
            return this;
        }

        public a QQ(int i) {
            this.j = i;
            return this;
        }

        public a BQ(boolean z) {
            this.k = z;
            return this;
        }

        @Deprecated
        public a BR(boolean z) {
            return this;
        }

        public a BS(boolean z) {
            this.l = z;
            return this;
        }

        public a aaH(String str) {
            this.m = str;
            return this;
        }

        public b eEn() {
            return new b(this);
        }
    }
}
