package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f34729a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34730b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34731c;

    /* renamed from: d  reason: collision with root package name */
    public final c f34732d;

    /* renamed from: e  reason: collision with root package name */
    public final l f34733e;

    /* renamed from: f  reason: collision with root package name */
    public k f34734f;

    /* renamed from: g  reason: collision with root package name */
    public k f34735g;

    /* renamed from: h  reason: collision with root package name */
    public final k f34736h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f34737a;

        /* renamed from: c  reason: collision with root package name */
        public String f34739c;

        /* renamed from: e  reason: collision with root package name */
        public l f34741e;

        /* renamed from: f  reason: collision with root package name */
        public k f34742f;

        /* renamed from: g  reason: collision with root package name */
        public k f34743g;

        /* renamed from: h  reason: collision with root package name */
        public k f34744h;

        /* renamed from: b  reason: collision with root package name */
        public int f34738b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f34740d = new c.a();

        public a a(int i2) {
            this.f34738b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f34740d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f34737a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f34741e = lVar;
            return this;
        }

        public a a(String str) {
            this.f34739c = str;
            return this;
        }

        public k a() {
            if (this.f34737a != null) {
                if (this.f34738b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f34738b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f34729a = aVar.f34737a;
        this.f34730b = aVar.f34738b;
        this.f34731c = aVar.f34739c;
        this.f34732d = aVar.f34740d.a();
        this.f34733e = aVar.f34741e;
        this.f34734f = aVar.f34742f;
        this.f34735g = aVar.f34743g;
        this.f34736h = aVar.f34744h;
    }

    public int a() {
        return this.f34730b;
    }

    public l b() {
        return this.f34733e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f34730b + ", message=" + this.f34731c + ", url=" + this.f34729a.a() + '}';
    }
}
