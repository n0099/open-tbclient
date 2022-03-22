package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes7.dex */
public class k {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final int f41978b;

    /* renamed from: c  reason: collision with root package name */
    public final String f41979c;

    /* renamed from: d  reason: collision with root package name */
    public final c f41980d;

    /* renamed from: e  reason: collision with root package name */
    public final l f41981e;

    /* renamed from: f  reason: collision with root package name */
    public k f41982f;

    /* renamed from: g  reason: collision with root package name */
    public k f41983g;

    /* renamed from: h  reason: collision with root package name */
    public final k f41984h;

    /* loaded from: classes7.dex */
    public static class a {
        public i a;

        /* renamed from: c  reason: collision with root package name */
        public String f41986c;

        /* renamed from: e  reason: collision with root package name */
        public l f41988e;

        /* renamed from: f  reason: collision with root package name */
        public k f41989f;

        /* renamed from: g  reason: collision with root package name */
        public k f41990g;

        /* renamed from: h  reason: collision with root package name */
        public k f41991h;

        /* renamed from: b  reason: collision with root package name */
        public int f41985b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f41987d = new c.a();

        public a a(int i) {
            this.f41985b = i;
            return this;
        }

        public a a(c cVar) {
            this.f41987d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f41988e = lVar;
            return this;
        }

        public a a(String str) {
            this.f41986c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.f41985b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f41985b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f41978b = aVar.f41985b;
        this.f41979c = aVar.f41986c;
        this.f41980d = aVar.f41987d.a();
        this.f41981e = aVar.f41988e;
        this.f41982f = aVar.f41989f;
        this.f41983g = aVar.f41990g;
        this.f41984h = aVar.f41991h;
    }

    public int a() {
        return this.f41978b;
    }

    public l b() {
        return this.f41981e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f41978b + ", message=" + this.f41979c + ", url=" + this.a.a() + '}';
    }
}
