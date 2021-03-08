package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.ss.android.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f7680a;
    private int b;
    private boolean c;
    private boolean d;
    private Object e;
    private boolean f;
    private int g;
    private JSONObject h;
    private Object i;

    public a() {
    }

    private a(C1210a c1210a) {
        this.f7680a = c1210a.f7681a;
        this.b = c1210a.b;
        this.c = c1210a.c;
        this.d = c1210a.d;
        this.e = c1210a.e;
        this.f = c1210a.f;
        this.g = c1210a.g;
        this.h = c1210a.h;
        this.i = c1210a.i;
    }

    @Override // com.ss.android.a.a.b.a
    public int a() {
        return this.f7680a;
    }

    @Override // com.ss.android.a.a.b.a
    public int b() {
        return this.b;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean c() {
        return this.c;
    }

    @Override // com.ss.android.a.a.b.a
    public boolean d() {
        return this.d;
    }

    @Override // com.ss.android.a.a.b.a
    public void a(int i) {
        this.b = i;
    }

    /* renamed from: com.ss.android.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1210a {

        /* renamed from: a  reason: collision with root package name */
        private int f7681a;
        private int b;
        private boolean c;
        private boolean d;
        private Object e;
        private boolean f;
        private int g;
        private JSONObject h;
        private Object i;

        public C1210a QS(int i) {
            this.f7681a = i;
            return this;
        }

        public C1210a QT(int i) {
            this.b = i;
            return this;
        }

        public C1210a BK(boolean z) {
            this.c = z;
            return this;
        }

        public C1210a BL(boolean z) {
            this.d = z;
            return this;
        }

        @Deprecated
        public C1210a BM(boolean z) {
            return this;
        }

        public C1210a bI(Object obj) {
            this.e = obj;
            return this;
        }

        public C1210a BN(boolean z) {
            this.f = z;
            return this;
        }

        public a eEq() {
            return new a(this);
        }
    }
}
