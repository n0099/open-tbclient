package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f38435a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38436b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38437c;

    /* renamed from: d  reason: collision with root package name */
    public final c f38438d;

    /* renamed from: e  reason: collision with root package name */
    public final l f38439e;

    /* renamed from: f  reason: collision with root package name */
    public k f38440f;

    /* renamed from: g  reason: collision with root package name */
    public k f38441g;

    /* renamed from: h  reason: collision with root package name */
    public final k f38442h;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f38443a;

        /* renamed from: c  reason: collision with root package name */
        public String f38445c;

        /* renamed from: e  reason: collision with root package name */
        public l f38447e;

        /* renamed from: f  reason: collision with root package name */
        public k f38448f;

        /* renamed from: g  reason: collision with root package name */
        public k f38449g;

        /* renamed from: h  reason: collision with root package name */
        public k f38450h;

        /* renamed from: b  reason: collision with root package name */
        public int f38444b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f38446d = new c.a();

        public a a(int i2) {
            this.f38444b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f38446d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f38443a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f38447e = lVar;
            return this;
        }

        public a a(String str) {
            this.f38445c = str;
            return this;
        }

        public k a() {
            if (this.f38443a != null) {
                if (this.f38444b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f38444b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f38435a = aVar.f38443a;
        this.f38436b = aVar.f38444b;
        this.f38437c = aVar.f38445c;
        this.f38438d = aVar.f38446d.a();
        this.f38439e = aVar.f38447e;
        this.f38440f = aVar.f38448f;
        this.f38441g = aVar.f38449g;
        this.f38442h = aVar.f38450h;
    }

    public int a() {
        return this.f38436b;
    }

    public l b() {
        return this.f38439e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f38436b + ", message=" + this.f38437c + ", url=" + this.f38435a.a() + '}';
    }
}
