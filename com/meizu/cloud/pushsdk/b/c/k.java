package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f37548a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37549b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37550c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37551d;

    /* renamed from: e  reason: collision with root package name */
    public final l f37552e;

    /* renamed from: f  reason: collision with root package name */
    public k f37553f;

    /* renamed from: g  reason: collision with root package name */
    public k f37554g;

    /* renamed from: h  reason: collision with root package name */
    public final k f37555h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f37556a;

        /* renamed from: c  reason: collision with root package name */
        public String f37558c;

        /* renamed from: e  reason: collision with root package name */
        public l f37560e;

        /* renamed from: f  reason: collision with root package name */
        public k f37561f;

        /* renamed from: g  reason: collision with root package name */
        public k f37562g;

        /* renamed from: h  reason: collision with root package name */
        public k f37563h;

        /* renamed from: b  reason: collision with root package name */
        public int f37557b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f37559d = new c.a();

        public a a(int i) {
            this.f37557b = i;
            return this;
        }

        public a a(c cVar) {
            this.f37559d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f37556a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f37560e = lVar;
            return this;
        }

        public a a(String str) {
            this.f37558c = str;
            return this;
        }

        public k a() {
            if (this.f37556a != null) {
                if (this.f37557b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f37557b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f37548a = aVar.f37556a;
        this.f37549b = aVar.f37557b;
        this.f37550c = aVar.f37558c;
        this.f37551d = aVar.f37559d.a();
        this.f37552e = aVar.f37560e;
        this.f37553f = aVar.f37561f;
        this.f37554g = aVar.f37562g;
        this.f37555h = aVar.f37563h;
    }

    public int a() {
        return this.f37549b;
    }

    public l b() {
        return this.f37552e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f37549b + ", message=" + this.f37550c + ", url=" + this.f37548a.a() + '}';
    }
}
