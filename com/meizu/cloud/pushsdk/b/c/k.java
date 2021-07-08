package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f37212a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37213b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37214c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37215d;

    /* renamed from: e  reason: collision with root package name */
    public final l f37216e;

    /* renamed from: f  reason: collision with root package name */
    public k f37217f;

    /* renamed from: g  reason: collision with root package name */
    public k f37218g;

    /* renamed from: h  reason: collision with root package name */
    public final k f37219h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f37220a;

        /* renamed from: c  reason: collision with root package name */
        public String f37222c;

        /* renamed from: e  reason: collision with root package name */
        public l f37224e;

        /* renamed from: f  reason: collision with root package name */
        public k f37225f;

        /* renamed from: g  reason: collision with root package name */
        public k f37226g;

        /* renamed from: h  reason: collision with root package name */
        public k f37227h;

        /* renamed from: b  reason: collision with root package name */
        public int f37221b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f37223d = new c.a();

        public a a(int i2) {
            this.f37221b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f37223d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f37220a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f37224e = lVar;
            return this;
        }

        public a a(String str) {
            this.f37222c = str;
            return this;
        }

        public k a() {
            if (this.f37220a != null) {
                if (this.f37221b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f37221b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f37212a = aVar.f37220a;
        this.f37213b = aVar.f37221b;
        this.f37214c = aVar.f37222c;
        this.f37215d = aVar.f37223d.a();
        this.f37216e = aVar.f37224e;
        this.f37217f = aVar.f37225f;
        this.f37218g = aVar.f37226g;
        this.f37219h = aVar.f37227h;
    }

    public int a() {
        return this.f37213b;
    }

    public l b() {
        return this.f37216e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f37213b + ", message=" + this.f37214c + ", url=" + this.f37212a.a() + '}';
    }
}
