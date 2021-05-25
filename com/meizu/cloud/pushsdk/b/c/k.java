package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f34658a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34659b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34660c;

    /* renamed from: d  reason: collision with root package name */
    public final c f34661d;

    /* renamed from: e  reason: collision with root package name */
    public final l f34662e;

    /* renamed from: f  reason: collision with root package name */
    public k f34663f;

    /* renamed from: g  reason: collision with root package name */
    public k f34664g;

    /* renamed from: h  reason: collision with root package name */
    public final k f34665h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f34666a;

        /* renamed from: c  reason: collision with root package name */
        public String f34668c;

        /* renamed from: e  reason: collision with root package name */
        public l f34670e;

        /* renamed from: f  reason: collision with root package name */
        public k f34671f;

        /* renamed from: g  reason: collision with root package name */
        public k f34672g;

        /* renamed from: h  reason: collision with root package name */
        public k f34673h;

        /* renamed from: b  reason: collision with root package name */
        public int f34667b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f34669d = new c.a();

        public a a(int i2) {
            this.f34667b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f34669d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f34666a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f34670e = lVar;
            return this;
        }

        public a a(String str) {
            this.f34668c = str;
            return this;
        }

        public k a() {
            if (this.f34666a != null) {
                if (this.f34667b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f34667b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f34658a = aVar.f34666a;
        this.f34659b = aVar.f34667b;
        this.f34660c = aVar.f34668c;
        this.f34661d = aVar.f34669d.a();
        this.f34662e = aVar.f34670e;
        this.f34663f = aVar.f34671f;
        this.f34664g = aVar.f34672g;
        this.f34665h = aVar.f34673h;
    }

    public int a() {
        return this.f34659b;
    }

    public l b() {
        return this.f34662e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f34659b + ", message=" + this.f34660c + ", url=" + this.f34658a.a() + '}';
    }
}
