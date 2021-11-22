package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f68253a;

    /* renamed from: b  reason: collision with root package name */
    public final int f68254b;

    /* renamed from: c  reason: collision with root package name */
    public final String f68255c;

    /* renamed from: d  reason: collision with root package name */
    public final c f68256d;

    /* renamed from: e  reason: collision with root package name */
    public final l f68257e;

    /* renamed from: f  reason: collision with root package name */
    public k f68258f;

    /* renamed from: g  reason: collision with root package name */
    public k f68259g;

    /* renamed from: h  reason: collision with root package name */
    public final k f68260h;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f68261a;

        /* renamed from: c  reason: collision with root package name */
        public String f68263c;

        /* renamed from: e  reason: collision with root package name */
        public l f68265e;

        /* renamed from: f  reason: collision with root package name */
        public k f68266f;

        /* renamed from: g  reason: collision with root package name */
        public k f68267g;

        /* renamed from: h  reason: collision with root package name */
        public k f68268h;

        /* renamed from: b  reason: collision with root package name */
        public int f68262b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f68264d = new c.a();

        public a a(int i2) {
            this.f68262b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f68264d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f68261a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f68265e = lVar;
            return this;
        }

        public a a(String str) {
            this.f68263c = str;
            return this;
        }

        public k a() {
            if (this.f68261a != null) {
                if (this.f68262b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f68262b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f68253a = aVar.f68261a;
        this.f68254b = aVar.f68262b;
        this.f68255c = aVar.f68263c;
        this.f68256d = aVar.f68264d.a();
        this.f68257e = aVar.f68265e;
        this.f68258f = aVar.f68266f;
        this.f68259g = aVar.f68267g;
        this.f68260h = aVar.f68268h;
    }

    public int a() {
        return this.f68254b;
    }

    public l b() {
        return this.f68257e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f68254b + ", message=" + this.f68255c + ", url=" + this.f68253a.a() + ExtendedMessageFormat.END_FE;
    }
}
