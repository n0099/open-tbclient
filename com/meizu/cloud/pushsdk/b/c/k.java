package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes4.dex */
public class k {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58789b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58790c;

    /* renamed from: d  reason: collision with root package name */
    public final c f58791d;

    /* renamed from: e  reason: collision with root package name */
    public final l f58792e;

    /* renamed from: f  reason: collision with root package name */
    public k f58793f;

    /* renamed from: g  reason: collision with root package name */
    public k f58794g;

    /* renamed from: h  reason: collision with root package name */
    public final k f58795h;

    /* loaded from: classes4.dex */
    public static class a {
        public i a;

        /* renamed from: c  reason: collision with root package name */
        public String f58797c;

        /* renamed from: e  reason: collision with root package name */
        public l f58799e;

        /* renamed from: f  reason: collision with root package name */
        public k f58800f;

        /* renamed from: g  reason: collision with root package name */
        public k f58801g;

        /* renamed from: h  reason: collision with root package name */
        public k f58802h;

        /* renamed from: b  reason: collision with root package name */
        public int f58796b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f58798d = new c.a();

        public a a(int i2) {
            this.f58796b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f58798d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f58799e = lVar;
            return this;
        }

        public a a(String str) {
            this.f58797c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.f58796b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f58796b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f58789b = aVar.f58796b;
        this.f58790c = aVar.f58797c;
        this.f58791d = aVar.f58798d.a();
        this.f58792e = aVar.f58799e;
        this.f58793f = aVar.f58800f;
        this.f58794g = aVar.f58801g;
        this.f58795h = aVar.f58802h;
    }

    public int a() {
        return this.f58789b;
    }

    public l b() {
        return this.f58792e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f58789b + ", message=" + this.f58790c + ", url=" + this.a.a() + ExtendedMessageFormat.END_FE;
    }
}
