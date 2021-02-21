package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements com.ss.android.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f12910a;

    /* renamed from: b  reason: collision with root package name */
    private int f12911b;
    private boolean c;
    private boolean d;
    private Object e;
    private boolean f;
    private int g;
    private JSONObject h;
    private Object i;

    public a() {
    }

    private a(C1220a c1220a) {
        this.f12910a = c1220a.f12912a;
        this.f12911b = c1220a.f12913b;
        this.c = c1220a.c;
        this.d = c1220a.d;
        this.e = c1220a.e;
        this.f = c1220a.f;
        this.g = c1220a.g;
        this.h = c1220a.h;
        this.i = c1220a.i;
    }

    @Override // com.ss.android.a.a.b.a
    public int a() {
        return this.f12910a;
    }

    @Override // com.ss.android.a.a.b.a
    public int b() {
        return this.f12911b;
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
    /* loaded from: classes6.dex */
    public static final class C1220a {

        /* renamed from: a  reason: collision with root package name */
        private int f12912a;

        /* renamed from: b  reason: collision with root package name */
        private int f12913b;
        private boolean c;
        private boolean d;
        private Object e;
        private boolean f;
        private int g;
        private JSONObject h;
        private Object i;

        public C1220a QO(int i) {
            this.f12912a = i;
            return this;
        }

        public C1220a QP(int i) {
            this.f12913b = i;
            return this;
        }

        public C1220a BM(boolean z) {
            this.c = z;
            return this;
        }

        public C1220a BN(boolean z) {
            this.d = z;
            return this;
        }

        @Deprecated
        public C1220a BO(boolean z) {
            return this;
        }

        public C1220a bG(Object obj) {
            this.e = obj;
            return this;
        }

        public C1220a BP(boolean z) {
            this.f = z;
            return this;
        }

        public a eEm() {
            return new a(this);
        }
    }
}
