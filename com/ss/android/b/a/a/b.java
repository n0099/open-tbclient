package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements com.ss.android.a.a.b.b {

    /* renamed from: a  reason: collision with root package name */
    private String f13212a;

    /* renamed from: b  reason: collision with root package name */
    private String f13213b;
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
    private JSONObject prb;

    public b() {
    }

    private b(a aVar) {
        this.f13212a = aVar.f13214a;
        this.f13213b = aVar.f13215b;
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
        this.prb = aVar.prb;
    }

    @Override // com.ss.android.a.a.b.b
    public String a() {
        return this.m;
    }

    @Override // com.ss.android.a.a.b.b
    public String b() {
        return this.f13212a;
    }

    @Override // com.ss.android.a.a.b.b
    public String c() {
        return this.f13213b;
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
    public Object eFt() {
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
    public JSONObject eFu() {
        return this.prb;
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f13214a;

        /* renamed from: b  reason: collision with root package name */
        private String f13215b;
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
        private JSONObject prb;

        public a aat(String str) {
            this.f13214a = str;
            return this;
        }

        public a aau(String str) {
            this.f13215b = str;
            return this;
        }

        public a aav(String str) {
            this.d = str;
            return this;
        }

        public a aaw(String str) {
            this.e = str;
            return this;
        }

        public a aax(String str) {
            this.f = str;
            return this;
        }

        public a aay(String str) {
            this.g = str;
            return this;
        }

        @Deprecated
        public a aaz(String str) {
            return this;
        }

        public a aaA(String str) {
            this.h = str;
            return this;
        }

        public a Sb(int i) {
            this.j = i;
            return this;
        }

        public a BA(boolean z) {
            this.k = z;
            return this;
        }

        @Deprecated
        public a BB(boolean z) {
            return this;
        }

        public a BC(boolean z) {
            this.l = z;
            return this;
        }

        public a aaB(String str) {
            this.m = str;
            return this;
        }

        public b eFF() {
            return new b(this);
        }
    }
}
