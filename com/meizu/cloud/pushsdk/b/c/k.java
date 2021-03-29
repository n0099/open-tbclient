package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f37549a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37550b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37551c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37552d;

    /* renamed from: e  reason: collision with root package name */
    public final l f37553e;

    /* renamed from: f  reason: collision with root package name */
    public k f37554f;

    /* renamed from: g  reason: collision with root package name */
    public k f37555g;

    /* renamed from: h  reason: collision with root package name */
    public final k f37556h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f37557a;

        /* renamed from: c  reason: collision with root package name */
        public String f37559c;

        /* renamed from: e  reason: collision with root package name */
        public l f37561e;

        /* renamed from: f  reason: collision with root package name */
        public k f37562f;

        /* renamed from: g  reason: collision with root package name */
        public k f37563g;

        /* renamed from: h  reason: collision with root package name */
        public k f37564h;

        /* renamed from: b  reason: collision with root package name */
        public int f37558b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f37560d = new c.a();

        public a a(int i) {
            this.f37558b = i;
            return this;
        }

        public a a(c cVar) {
            this.f37560d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f37557a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f37561e = lVar;
            return this;
        }

        public a a(String str) {
            this.f37559c = str;
            return this;
        }

        public k a() {
            if (this.f37557a != null) {
                if (this.f37558b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f37558b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f37549a = aVar.f37557a;
        this.f37550b = aVar.f37558b;
        this.f37551c = aVar.f37559c;
        this.f37552d = aVar.f37560d.a();
        this.f37553e = aVar.f37561e;
        this.f37554f = aVar.f37562f;
        this.f37555g = aVar.f37563g;
        this.f37556h = aVar.f37564h;
    }

    public int a() {
        return this.f37550b;
    }

    public l b() {
        return this.f37553e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f37550b + ", message=" + this.f37551c + ", url=" + this.f37549a.a() + '}';
    }
}
