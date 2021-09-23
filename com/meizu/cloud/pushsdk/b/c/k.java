package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f74942a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74943b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74944c;

    /* renamed from: d  reason: collision with root package name */
    public final c f74945d;

    /* renamed from: e  reason: collision with root package name */
    public final l f74946e;

    /* renamed from: f  reason: collision with root package name */
    public k f74947f;

    /* renamed from: g  reason: collision with root package name */
    public k f74948g;

    /* renamed from: h  reason: collision with root package name */
    public final k f74949h;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f74950a;

        /* renamed from: c  reason: collision with root package name */
        public String f74952c;

        /* renamed from: e  reason: collision with root package name */
        public l f74954e;

        /* renamed from: f  reason: collision with root package name */
        public k f74955f;

        /* renamed from: g  reason: collision with root package name */
        public k f74956g;

        /* renamed from: h  reason: collision with root package name */
        public k f74957h;

        /* renamed from: b  reason: collision with root package name */
        public int f74951b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f74953d = new c.a();

        public a a(int i2) {
            this.f74951b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f74953d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f74950a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f74954e = lVar;
            return this;
        }

        public a a(String str) {
            this.f74952c = str;
            return this;
        }

        public k a() {
            if (this.f74950a != null) {
                if (this.f74951b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f74951b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f74942a = aVar.f74950a;
        this.f74943b = aVar.f74951b;
        this.f74944c = aVar.f74952c;
        this.f74945d = aVar.f74953d.a();
        this.f74946e = aVar.f74954e;
        this.f74947f = aVar.f74955f;
        this.f74948g = aVar.f74956g;
        this.f74949h = aVar.f74957h;
    }

    public int a() {
        return this.f74943b;
    }

    public l b() {
        return this.f74946e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f74943b + ", message=" + this.f74944c + ", url=" + this.f74942a.a() + ExtendedMessageFormat.END_FE;
    }
}
