package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class k {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final int f60303b;

    /* renamed from: c  reason: collision with root package name */
    public final String f60304c;

    /* renamed from: d  reason: collision with root package name */
    public final c f60305d;

    /* renamed from: e  reason: collision with root package name */
    public final l f60306e;

    /* renamed from: f  reason: collision with root package name */
    public k f60307f;

    /* renamed from: g  reason: collision with root package name */
    public k f60308g;

    /* renamed from: h  reason: collision with root package name */
    public final k f60309h;

    /* loaded from: classes2.dex */
    public static class a {
        public i a;

        /* renamed from: c  reason: collision with root package name */
        public String f60311c;

        /* renamed from: e  reason: collision with root package name */
        public l f60313e;

        /* renamed from: f  reason: collision with root package name */
        public k f60314f;

        /* renamed from: g  reason: collision with root package name */
        public k f60315g;

        /* renamed from: h  reason: collision with root package name */
        public k f60316h;

        /* renamed from: b  reason: collision with root package name */
        public int f60310b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f60312d = new c.a();

        public a a(int i2) {
            this.f60310b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f60312d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f60313e = lVar;
            return this;
        }

        public a a(String str) {
            this.f60311c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.f60310b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f60310b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f60303b = aVar.f60310b;
        this.f60304c = aVar.f60311c;
        this.f60305d = aVar.f60312d.a();
        this.f60306e = aVar.f60313e;
        this.f60307f = aVar.f60314f;
        this.f60308g = aVar.f60315g;
        this.f60309h = aVar.f60316h;
    }

    public int a() {
        return this.f60303b;
    }

    public l b() {
        return this.f60306e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f60303b + ", message=" + this.f60304c + ", url=" + this.a.a() + ExtendedMessageFormat.END_FE;
    }
}
