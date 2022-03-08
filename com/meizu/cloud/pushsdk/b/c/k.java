package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
public class k {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final int f57139b;

    /* renamed from: c  reason: collision with root package name */
    public final String f57140c;

    /* renamed from: d  reason: collision with root package name */
    public final c f57141d;

    /* renamed from: e  reason: collision with root package name */
    public final l f57142e;

    /* renamed from: f  reason: collision with root package name */
    public k f57143f;

    /* renamed from: g  reason: collision with root package name */
    public k f57144g;

    /* renamed from: h  reason: collision with root package name */
    public final k f57145h;

    /* loaded from: classes8.dex */
    public static class a {
        public i a;

        /* renamed from: c  reason: collision with root package name */
        public String f57147c;

        /* renamed from: e  reason: collision with root package name */
        public l f57149e;

        /* renamed from: f  reason: collision with root package name */
        public k f57150f;

        /* renamed from: g  reason: collision with root package name */
        public k f57151g;

        /* renamed from: h  reason: collision with root package name */
        public k f57152h;

        /* renamed from: b  reason: collision with root package name */
        public int f57146b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f57148d = new c.a();

        public a a(int i2) {
            this.f57146b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f57148d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f57149e = lVar;
            return this;
        }

        public a a(String str) {
            this.f57147c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.f57146b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f57146b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f57139b = aVar.f57146b;
        this.f57140c = aVar.f57147c;
        this.f57141d = aVar.f57148d.a();
        this.f57142e = aVar.f57149e;
        this.f57143f = aVar.f57150f;
        this.f57144g = aVar.f57151g;
        this.f57145h = aVar.f57152h;
    }

    public int a() {
        return this.f57139b;
    }

    public l b() {
        return this.f57142e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f57139b + ", message=" + this.f57140c + ", url=" + this.a.a() + ExtendedMessageFormat.END_FE;
    }
}
