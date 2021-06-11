package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes7.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f38337a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38338b;

    /* renamed from: c  reason: collision with root package name */
    public final String f38339c;

    /* renamed from: d  reason: collision with root package name */
    public final c f38340d;

    /* renamed from: e  reason: collision with root package name */
    public final l f38341e;

    /* renamed from: f  reason: collision with root package name */
    public k f38342f;

    /* renamed from: g  reason: collision with root package name */
    public k f38343g;

    /* renamed from: h  reason: collision with root package name */
    public final k f38344h;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f38345a;

        /* renamed from: c  reason: collision with root package name */
        public String f38347c;

        /* renamed from: e  reason: collision with root package name */
        public l f38349e;

        /* renamed from: f  reason: collision with root package name */
        public k f38350f;

        /* renamed from: g  reason: collision with root package name */
        public k f38351g;

        /* renamed from: h  reason: collision with root package name */
        public k f38352h;

        /* renamed from: b  reason: collision with root package name */
        public int f38346b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f38348d = new c.a();

        public a a(int i2) {
            this.f38346b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f38348d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f38345a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f38349e = lVar;
            return this;
        }

        public a a(String str) {
            this.f38347c = str;
            return this;
        }

        public k a() {
            if (this.f38345a != null) {
                if (this.f38346b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f38346b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f38337a = aVar.f38345a;
        this.f38338b = aVar.f38346b;
        this.f38339c = aVar.f38347c;
        this.f38340d = aVar.f38348d.a();
        this.f38341e = aVar.f38349e;
        this.f38342f = aVar.f38350f;
        this.f38343g = aVar.f38351g;
        this.f38344h = aVar.f38352h;
    }

    public int a() {
        return this.f38338b;
    }

    public l b() {
        return this.f38341e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f38338b + ", message=" + this.f38339c + ", url=" + this.f38337a.a() + '}';
    }
}
