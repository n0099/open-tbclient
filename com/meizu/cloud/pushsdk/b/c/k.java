package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f37401a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37402b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37403c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37404d;

    /* renamed from: e  reason: collision with root package name */
    public final l f37405e;

    /* renamed from: f  reason: collision with root package name */
    public k f37406f;

    /* renamed from: g  reason: collision with root package name */
    public k f37407g;

    /* renamed from: h  reason: collision with root package name */
    public final k f37408h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f37409a;

        /* renamed from: c  reason: collision with root package name */
        public String f37411c;

        /* renamed from: e  reason: collision with root package name */
        public l f37413e;

        /* renamed from: f  reason: collision with root package name */
        public k f37414f;

        /* renamed from: g  reason: collision with root package name */
        public k f37415g;

        /* renamed from: h  reason: collision with root package name */
        public k f37416h;

        /* renamed from: b  reason: collision with root package name */
        public int f37410b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f37412d = new c.a();

        public a a(int i2) {
            this.f37410b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f37412d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f37409a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f37413e = lVar;
            return this;
        }

        public a a(String str) {
            this.f37411c = str;
            return this;
        }

        public k a() {
            if (this.f37409a != null) {
                if (this.f37410b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f37410b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f37401a = aVar.f37409a;
        this.f37402b = aVar.f37410b;
        this.f37403c = aVar.f37411c;
        this.f37404d = aVar.f37412d.a();
        this.f37405e = aVar.f37413e;
        this.f37406f = aVar.f37414f;
        this.f37407g = aVar.f37415g;
        this.f37408h = aVar.f37416h;
    }

    public int a() {
        return this.f37402b;
    }

    public l b() {
        return this.f37405e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f37402b + ", message=" + this.f37403c + ", url=" + this.f37401a.a() + '}';
    }
}
