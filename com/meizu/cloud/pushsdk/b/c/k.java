package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class k {
    public final i a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58577b;

    /* renamed from: c  reason: collision with root package name */
    public final String f58578c;

    /* renamed from: d  reason: collision with root package name */
    public final c f58579d;

    /* renamed from: e  reason: collision with root package name */
    public final l f58580e;

    /* renamed from: f  reason: collision with root package name */
    public k f58581f;

    /* renamed from: g  reason: collision with root package name */
    public k f58582g;

    /* renamed from: h  reason: collision with root package name */
    public final k f58583h;

    /* loaded from: classes3.dex */
    public static class a {
        public i a;

        /* renamed from: c  reason: collision with root package name */
        public String f58585c;

        /* renamed from: e  reason: collision with root package name */
        public l f58587e;

        /* renamed from: f  reason: collision with root package name */
        public k f58588f;

        /* renamed from: g  reason: collision with root package name */
        public k f58589g;

        /* renamed from: h  reason: collision with root package name */
        public k f58590h;

        /* renamed from: b  reason: collision with root package name */
        public int f58584b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f58586d = new c.a();

        public a a(int i2) {
            this.f58584b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f58586d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f58587e = lVar;
            return this;
        }

        public a a(String str) {
            this.f58585c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.f58584b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f58584b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f58577b = aVar.f58584b;
        this.f58578c = aVar.f58585c;
        this.f58579d = aVar.f58586d.a();
        this.f58580e = aVar.f58587e;
        this.f58581f = aVar.f58588f;
        this.f58582g = aVar.f58589g;
        this.f58583h = aVar.f58590h;
    }

    public int a() {
        return this.f58577b;
    }

    public l b() {
        return this.f58580e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f58577b + ", message=" + this.f58578c + ", url=" + this.a.a() + ExtendedMessageFormat.END_FE;
    }
}
