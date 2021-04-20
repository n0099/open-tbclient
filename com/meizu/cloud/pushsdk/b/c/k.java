package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f37838a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37839b;

    /* renamed from: c  reason: collision with root package name */
    public final String f37840c;

    /* renamed from: d  reason: collision with root package name */
    public final c f37841d;

    /* renamed from: e  reason: collision with root package name */
    public final l f37842e;

    /* renamed from: f  reason: collision with root package name */
    public k f37843f;

    /* renamed from: g  reason: collision with root package name */
    public k f37844g;

    /* renamed from: h  reason: collision with root package name */
    public final k f37845h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f37846a;

        /* renamed from: c  reason: collision with root package name */
        public String f37848c;

        /* renamed from: e  reason: collision with root package name */
        public l f37850e;

        /* renamed from: f  reason: collision with root package name */
        public k f37851f;

        /* renamed from: g  reason: collision with root package name */
        public k f37852g;

        /* renamed from: h  reason: collision with root package name */
        public k f37853h;

        /* renamed from: b  reason: collision with root package name */
        public int f37847b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f37849d = new c.a();

        public a a(int i) {
            this.f37847b = i;
            return this;
        }

        public a a(c cVar) {
            this.f37849d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f37846a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f37850e = lVar;
            return this;
        }

        public a a(String str) {
            this.f37848c = str;
            return this;
        }

        public k a() {
            if (this.f37846a != null) {
                if (this.f37847b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f37847b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f37838a = aVar.f37846a;
        this.f37839b = aVar.f37847b;
        this.f37840c = aVar.f37848c;
        this.f37841d = aVar.f37849d.a();
        this.f37842e = aVar.f37850e;
        this.f37843f = aVar.f37851f;
        this.f37844g = aVar.f37852g;
        this.f37845h = aVar.f37853h;
    }

    public int a() {
        return this.f37839b;
    }

    public l b() {
        return this.f37842e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f37839b + ", message=" + this.f37840c + ", url=" + this.f37838a.a() + '}';
    }
}
