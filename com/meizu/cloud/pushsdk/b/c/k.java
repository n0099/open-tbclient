package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f74243a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74244b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74245c;

    /* renamed from: d  reason: collision with root package name */
    public final c f74246d;

    /* renamed from: e  reason: collision with root package name */
    public final l f74247e;

    /* renamed from: f  reason: collision with root package name */
    public k f74248f;

    /* renamed from: g  reason: collision with root package name */
    public k f74249g;

    /* renamed from: h  reason: collision with root package name */
    public final k f74250h;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f74251a;

        /* renamed from: c  reason: collision with root package name */
        public String f74253c;

        /* renamed from: e  reason: collision with root package name */
        public l f74255e;

        /* renamed from: f  reason: collision with root package name */
        public k f74256f;

        /* renamed from: g  reason: collision with root package name */
        public k f74257g;

        /* renamed from: h  reason: collision with root package name */
        public k f74258h;

        /* renamed from: b  reason: collision with root package name */
        public int f74252b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f74254d = new c.a();

        public a a(int i2) {
            this.f74252b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f74254d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f74251a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f74255e = lVar;
            return this;
        }

        public a a(String str) {
            this.f74253c = str;
            return this;
        }

        public k a() {
            if (this.f74251a != null) {
                if (this.f74252b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f74252b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f74243a = aVar.f74251a;
        this.f74244b = aVar.f74252b;
        this.f74245c = aVar.f74253c;
        this.f74246d = aVar.f74254d.a();
        this.f74247e = aVar.f74255e;
        this.f74248f = aVar.f74256f;
        this.f74249g = aVar.f74257g;
        this.f74250h = aVar.f74258h;
    }

    public int a() {
        return this.f74244b;
    }

    public l b() {
        return this.f74247e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f74244b + ", message=" + this.f74245c + ", url=" + this.f74243a.a() + ExtendedMessageFormat.END_FE;
    }
}
