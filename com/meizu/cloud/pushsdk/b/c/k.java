package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class k {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60884b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60885c;

    /* renamed from: d  reason: collision with root package name */
    public final c f60886d;

    /* renamed from: e  reason: collision with root package name */
    public final l f60887e;

    /* renamed from: f  reason: collision with root package name */
    public k f60888f;

    /* renamed from: g  reason: collision with root package name */
    public k f60889g;

    /* renamed from: h  reason: collision with root package name */
    public final k f60890h;

    /* loaded from: classes3.dex */
    public static class a {
        public i a;

        /* renamed from: c  reason: collision with root package name */
        public String f60892c;

        /* renamed from: e  reason: collision with root package name */
        public l f60894e;

        /* renamed from: f  reason: collision with root package name */
        public k f60895f;

        /* renamed from: g  reason: collision with root package name */
        public k f60896g;

        /* renamed from: h  reason: collision with root package name */
        public k f60897h;

        /* renamed from: b  reason: collision with root package name */
        public int f60891b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f60893d = new c.a();

        public a a(int i2) {
            this.f60891b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f60893d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f60894e = lVar;
            return this;
        }

        public a a(String str) {
            this.f60892c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.f60891b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f60891b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f60884b = aVar.f60891b;
        this.f60885c = aVar.f60892c;
        this.f60886d = aVar.f60893d.a();
        this.f60887e = aVar.f60894e;
        this.f60888f = aVar.f60895f;
        this.f60889g = aVar.f60896g;
        this.f60890h = aVar.f60897h;
    }

    public int a() {
        return this.f60884b;
    }

    public l b() {
        return this.f60887e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f60884b + ", message=" + this.f60885c + ", url=" + this.a.a() + ExtendedMessageFormat.END_FE;
    }
}
