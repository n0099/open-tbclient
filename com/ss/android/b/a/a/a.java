package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.ss.android.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f13207a;

    /* renamed from: b  reason: collision with root package name */
    private int f13208b;
    private boolean c;
    private boolean d;
    private Object e;
    private boolean f;
    private int g;
    private JSONObject h;
    private Object i;

    public a() {
    }

    private a(C1190a c1190a) {
        this.f13207a = c1190a.f13209a;
        this.f13208b = c1190a.f13210b;
        this.c = c1190a.c;
        this.d = c1190a.d;
        this.e = c1190a.e;
        this.f = c1190a.f;
        this.g = c1190a.g;
        this.h = c1190a.h;
        this.i = c1190a.i;
    }

    @Override // com.ss.android.a.a.b.a
    public int a() {
        return this.f13207a;
    }

    @Override // com.ss.android.a.a.b.a
    public int b() {
        return this.f13208b;
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
    public static final class C1190a {

        /* renamed from: a  reason: collision with root package name */
        private int f13209a;

        /* renamed from: b  reason: collision with root package name */
        private int f13210b;
        private boolean c;
        private boolean d;
        private Object e;
        private boolean f;
        private int g;
        private JSONObject h;
        private Object i;

        public C1190a RJ(int i) {
            this.f13209a = i;
            return this;
        }

        public C1190a RK(int i) {
            this.f13210b = i;
            return this;
        }

        public C1190a Bw(boolean z) {
            this.c = z;
            return this;
        }

        public C1190a Bx(boolean z) {
            this.d = z;
            return this;
        }

        @Deprecated
        public C1190a By(boolean z) {
            return this;
        }

        public C1190a bF(Object obj) {
            this.e = obj;
            return this;
        }

        public C1190a Bz(boolean z) {
            this.f = z;
            return this;
        }

        public a eFa() {
            return new a(this);
        }
    }
}
