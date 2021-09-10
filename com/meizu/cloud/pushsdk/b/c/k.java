package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f74623a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74624b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74625c;

    /* renamed from: d  reason: collision with root package name */
    public final c f74626d;

    /* renamed from: e  reason: collision with root package name */
    public final l f74627e;

    /* renamed from: f  reason: collision with root package name */
    public k f74628f;

    /* renamed from: g  reason: collision with root package name */
    public k f74629g;

    /* renamed from: h  reason: collision with root package name */
    public final k f74630h;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f74631a;

        /* renamed from: c  reason: collision with root package name */
        public String f74633c;

        /* renamed from: e  reason: collision with root package name */
        public l f74635e;

        /* renamed from: f  reason: collision with root package name */
        public k f74636f;

        /* renamed from: g  reason: collision with root package name */
        public k f74637g;

        /* renamed from: h  reason: collision with root package name */
        public k f74638h;

        /* renamed from: b  reason: collision with root package name */
        public int f74632b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f74634d = new c.a();

        public a a(int i2) {
            this.f74632b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f74634d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f74631a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f74635e = lVar;
            return this;
        }

        public a a(String str) {
            this.f74633c = str;
            return this;
        }

        public k a() {
            if (this.f74631a != null) {
                if (this.f74632b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f74632b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f74623a = aVar.f74631a;
        this.f74624b = aVar.f74632b;
        this.f74625c = aVar.f74633c;
        this.f74626d = aVar.f74634d.a();
        this.f74627e = aVar.f74635e;
        this.f74628f = aVar.f74636f;
        this.f74629g = aVar.f74637g;
        this.f74630h = aVar.f74638h;
    }

    public int a() {
        return this.f74624b;
    }

    public l b() {
        return this.f74627e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f74624b + ", message=" + this.f74625c + ", url=" + this.f74623a.a() + ExtendedMessageFormat.END_FE;
    }
}
