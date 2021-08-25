package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f74443a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74444b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74445c;

    /* renamed from: d  reason: collision with root package name */
    public final c f74446d;

    /* renamed from: e  reason: collision with root package name */
    public final l f74447e;

    /* renamed from: f  reason: collision with root package name */
    public k f74448f;

    /* renamed from: g  reason: collision with root package name */
    public k f74449g;

    /* renamed from: h  reason: collision with root package name */
    public final k f74450h;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f74451a;

        /* renamed from: c  reason: collision with root package name */
        public String f74453c;

        /* renamed from: e  reason: collision with root package name */
        public l f74455e;

        /* renamed from: f  reason: collision with root package name */
        public k f74456f;

        /* renamed from: g  reason: collision with root package name */
        public k f74457g;

        /* renamed from: h  reason: collision with root package name */
        public k f74458h;

        /* renamed from: b  reason: collision with root package name */
        public int f74452b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f74454d = new c.a();

        public a a(int i2) {
            this.f74452b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f74454d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f74451a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f74455e = lVar;
            return this;
        }

        public a a(String str) {
            this.f74453c = str;
            return this;
        }

        public k a() {
            if (this.f74451a != null) {
                if (this.f74452b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f74452b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f74443a = aVar.f74451a;
        this.f74444b = aVar.f74452b;
        this.f74445c = aVar.f74453c;
        this.f74446d = aVar.f74454d.a();
        this.f74447e = aVar.f74455e;
        this.f74448f = aVar.f74456f;
        this.f74449g = aVar.f74457g;
        this.f74450h = aVar.f74458h;
    }

    public int a() {
        return this.f74444b;
    }

    public l b() {
        return this.f74447e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f74444b + ", message=" + this.f74445c + ", url=" + this.f74443a.a() + ExtendedMessageFormat.END_FE;
    }
}
