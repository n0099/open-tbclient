package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class k {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58622b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58623c;

    /* renamed from: d  reason: collision with root package name */
    public final c f58624d;

    /* renamed from: e  reason: collision with root package name */
    public final l f58625e;

    /* renamed from: f  reason: collision with root package name */
    public k f58626f;

    /* renamed from: g  reason: collision with root package name */
    public k f58627g;

    /* renamed from: h  reason: collision with root package name */
    public final k f58628h;

    /* loaded from: classes3.dex */
    public static class a {
        public i a;

        /* renamed from: c  reason: collision with root package name */
        public String f58630c;

        /* renamed from: e  reason: collision with root package name */
        public l f58632e;

        /* renamed from: f  reason: collision with root package name */
        public k f58633f;

        /* renamed from: g  reason: collision with root package name */
        public k f58634g;

        /* renamed from: h  reason: collision with root package name */
        public k f58635h;

        /* renamed from: b  reason: collision with root package name */
        public int f58629b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f58631d = new c.a();

        public a a(int i2) {
            this.f58629b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f58631d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f58632e = lVar;
            return this;
        }

        public a a(String str) {
            this.f58630c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.f58629b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f58629b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f58622b = aVar.f58629b;
        this.f58623c = aVar.f58630c;
        this.f58624d = aVar.f58631d.a();
        this.f58625e = aVar.f58632e;
        this.f58626f = aVar.f58633f;
        this.f58627g = aVar.f58634g;
        this.f58628h = aVar.f58635h;
    }

    public int a() {
        return this.f58622b;
    }

    public l b() {
        return this.f58625e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f58622b + ", message=" + this.f58623c + ", url=" + this.a.a() + ExtendedMessageFormat.END_FE;
    }
}
