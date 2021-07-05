package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f40198a;

    /* renamed from: b  reason: collision with root package name */
    public final int f40199b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40200c;

    /* renamed from: d  reason: collision with root package name */
    public final c f40201d;

    /* renamed from: e  reason: collision with root package name */
    public final l f40202e;

    /* renamed from: f  reason: collision with root package name */
    public k f40203f;

    /* renamed from: g  reason: collision with root package name */
    public k f40204g;

    /* renamed from: h  reason: collision with root package name */
    public final k f40205h;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f40206a;

        /* renamed from: c  reason: collision with root package name */
        public String f40208c;

        /* renamed from: e  reason: collision with root package name */
        public l f40210e;

        /* renamed from: f  reason: collision with root package name */
        public k f40211f;

        /* renamed from: g  reason: collision with root package name */
        public k f40212g;

        /* renamed from: h  reason: collision with root package name */
        public k f40213h;

        /* renamed from: b  reason: collision with root package name */
        public int f40207b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f40209d = new c.a();

        public a a(int i2) {
            this.f40207b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f40209d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f40206a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f40210e = lVar;
            return this;
        }

        public a a(String str) {
            this.f40208c = str;
            return this;
        }

        public k a() {
            if (this.f40206a != null) {
                if (this.f40207b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f40207b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f40198a = aVar.f40206a;
        this.f40199b = aVar.f40207b;
        this.f40200c = aVar.f40208c;
        this.f40201d = aVar.f40209d.a();
        this.f40202e = aVar.f40210e;
        this.f40203f = aVar.f40211f;
        this.f40204g = aVar.f40212g;
        this.f40205h = aVar.f40213h;
    }

    public int a() {
        return this.f40199b;
    }

    public l b() {
        return this.f40202e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f40199b + ", message=" + this.f40200c + ", url=" + this.f40198a.a() + '}';
    }
}
