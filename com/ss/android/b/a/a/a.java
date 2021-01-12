package com.ss.android.b.a.a;

import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.ss.android.a.a.b.a {

    /* renamed from: a  reason: collision with root package name */
    private int f12908a;

    /* renamed from: b  reason: collision with root package name */
    private int f12909b;
    private boolean c;
    private boolean d;
    private Object e;
    private boolean f;
    private int g;
    private JSONObject h;
    private Object i;

    public a() {
    }

    private a(C1214a c1214a) {
        this.f12908a = c1214a.f12910a;
        this.f12909b = c1214a.f12911b;
        this.c = c1214a.c;
        this.d = c1214a.d;
        this.e = c1214a.e;
        this.f = c1214a.f;
        this.g = c1214a.g;
        this.h = c1214a.h;
        this.i = c1214a.i;
    }

    @Override // com.ss.android.a.a.b.a
    public int a() {
        return this.f12908a;
    }

    @Override // com.ss.android.a.a.b.a
    public int b() {
        return this.f12909b;
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
    public static final class C1214a {

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

        public C1214a Qs(int i) {
            this.f12910a = i;
            return this;
        }

        public C1214a Qt(int i) {
            this.f12911b = i;
            return this;
        }

        public C1214a Bs(boolean z) {
            this.c = z;
            return this;
        }

        public C1214a Bt(boolean z) {
            this.d = z;
            return this;
        }

        @Deprecated
        public C1214a Bu(boolean z) {
            return this;
        }

        public C1214a bG(Object obj) {
            this.e = obj;
            return this;
        }

        public C1214a Bv(boolean z) {
            this.f = z;
            return this;
        }

        public a eBN() {
            return new a(this);
        }
    }
}
