package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.ss.android.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f13208a;

    /* renamed from: b  reason: collision with root package name */
    private int f13209b;
    private boolean c;
    private boolean d;
    private Object e;
    private boolean f;
    private int g;
    private JSONObject h;
    private Object i;

    public a() {
    }

    private a(C1231a c1231a) {
        this.f13208a = c1231a.f13210a;
        this.f13209b = c1231a.f13211b;
        this.c = c1231a.c;
        this.d = c1231a.d;
        this.e = c1231a.e;
        this.f = c1231a.f;
        this.g = c1231a.g;
        this.h = c1231a.h;
        this.i = c1231a.i;
    }

    @Override // com.ss.android.a.a.b.a
    public int a() {
        return this.f13208a;
    }

    @Override // com.ss.android.a.a.b.a
    public int b() {
        return this.f13209b;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean c() {
        return this.c;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean d() {
        return this.d;
    }

    /* renamed from: com.ss.android.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1231a {

        /* renamed from: a  reason: collision with root package name */
        private int f13210a;

        /* renamed from: b  reason: collision with root package name */
        private int f13211b;
        private boolean c;
        private boolean d;
        private Object e;
        private boolean f;
        private int g;
        private JSONObject h;
        private Object i;

        public C1231a RZ(int i) {
            this.f13210a = i;
            return this;
        }

        public C1231a Sa(int i) {
            this.f13211b = i;
            return this;
        }

        public C1231a Bw(boolean z) {
            this.c = z;
            return this;
        }

        public C1231a Bx(boolean z) {
            this.d = z;
            return this;
        }

        @Deprecated
        public C1231a By(boolean z) {
            return this;
        }

        public C1231a bG(Object obj) {
            this.e = obj;
            return this;
        }

        public C1231a Bz(boolean z) {
            this.f = z;
            return this;
        }

        public a eFE() {
            return new a(this);
        }
    }
}
