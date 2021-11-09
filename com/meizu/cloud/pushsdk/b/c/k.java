package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f67340a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67341b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67342c;

    /* renamed from: d  reason: collision with root package name */
    public final c f67343d;

    /* renamed from: e  reason: collision with root package name */
    public final l f67344e;

    /* renamed from: f  reason: collision with root package name */
    public k f67345f;

    /* renamed from: g  reason: collision with root package name */
    public k f67346g;

    /* renamed from: h  reason: collision with root package name */
    public final k f67347h;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f67348a;

        /* renamed from: c  reason: collision with root package name */
        public String f67350c;

        /* renamed from: e  reason: collision with root package name */
        public l f67352e;

        /* renamed from: f  reason: collision with root package name */
        public k f67353f;

        /* renamed from: g  reason: collision with root package name */
        public k f67354g;

        /* renamed from: h  reason: collision with root package name */
        public k f67355h;

        /* renamed from: b  reason: collision with root package name */
        public int f67349b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f67351d = new c.a();

        public a a(int i2) {
            this.f67349b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f67351d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f67348a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f67352e = lVar;
            return this;
        }

        public a a(String str) {
            this.f67350c = str;
            return this;
        }

        public k a() {
            if (this.f67348a != null) {
                if (this.f67349b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f67349b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f67340a = aVar.f67348a;
        this.f67341b = aVar.f67349b;
        this.f67342c = aVar.f67350c;
        this.f67343d = aVar.f67351d.a();
        this.f67344e = aVar.f67352e;
        this.f67345f = aVar.f67353f;
        this.f67346g = aVar.f67354g;
        this.f67347h = aVar.f67355h;
    }

    public int a() {
        return this.f67341b;
    }

    public l b() {
        return this.f67344e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f67341b + ", message=" + this.f67342c + ", url=" + this.f67340a.a() + ExtendedMessageFormat.END_FE;
    }
}
