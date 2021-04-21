package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f37933a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37934b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37935c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37936d;

    /* renamed from: e  reason: collision with root package name */
    public final l f37937e;

    /* renamed from: f  reason: collision with root package name */
    public k f37938f;

    /* renamed from: g  reason: collision with root package name */
    public k f37939g;

    /* renamed from: h  reason: collision with root package name */
    public final k f37940h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f37941a;

        /* renamed from: c  reason: collision with root package name */
        public String f37943c;

        /* renamed from: e  reason: collision with root package name */
        public l f37945e;

        /* renamed from: f  reason: collision with root package name */
        public k f37946f;

        /* renamed from: g  reason: collision with root package name */
        public k f37947g;

        /* renamed from: h  reason: collision with root package name */
        public k f37948h;

        /* renamed from: b  reason: collision with root package name */
        public int f37942b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f37944d = new c.a();

        public a a(int i) {
            this.f37942b = i;
            return this;
        }

        public a a(c cVar) {
            this.f37944d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f37941a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f37945e = lVar;
            return this;
        }

        public a a(String str) {
            this.f37943c = str;
            return this;
        }

        public k a() {
            if (this.f37941a != null) {
                if (this.f37942b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f37942b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f37933a = aVar.f37941a;
        this.f37934b = aVar.f37942b;
        this.f37935c = aVar.f37943c;
        this.f37936d = aVar.f37944d.a();
        this.f37937e = aVar.f37945e;
        this.f37938f = aVar.f37946f;
        this.f37939g = aVar.f37947g;
        this.f37940h = aVar.f37948h;
    }

    public int a() {
        return this.f37934b;
    }

    public l b() {
        return this.f37937e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f37934b + ", message=" + this.f37935c + ", url=" + this.f37933a.a() + '}';
    }
}
