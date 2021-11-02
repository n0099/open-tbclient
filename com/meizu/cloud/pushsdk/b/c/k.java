package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f67341a;

    /* renamed from: b  reason: collision with root package name */
    public final int f67342b;

    /* renamed from: c  reason: collision with root package name */
    public final String f67343c;

    /* renamed from: d  reason: collision with root package name */
    public final c f67344d;

    /* renamed from: e  reason: collision with root package name */
    public final l f67345e;

    /* renamed from: f  reason: collision with root package name */
    public k f67346f;

    /* renamed from: g  reason: collision with root package name */
    public k f67347g;

    /* renamed from: h  reason: collision with root package name */
    public final k f67348h;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f67349a;

        /* renamed from: c  reason: collision with root package name */
        public String f67351c;

        /* renamed from: e  reason: collision with root package name */
        public l f67353e;

        /* renamed from: f  reason: collision with root package name */
        public k f67354f;

        /* renamed from: g  reason: collision with root package name */
        public k f67355g;

        /* renamed from: h  reason: collision with root package name */
        public k f67356h;

        /* renamed from: b  reason: collision with root package name */
        public int f67350b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f67352d = new c.a();

        public a a(int i2) {
            this.f67350b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f67352d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f67349a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f67353e = lVar;
            return this;
        }

        public a a(String str) {
            this.f67351c = str;
            return this;
        }

        public k a() {
            if (this.f67349a != null) {
                if (this.f67350b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f67350b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f67341a = aVar.f67349a;
        this.f67342b = aVar.f67350b;
        this.f67343c = aVar.f67351c;
        this.f67344d = aVar.f67352d.a();
        this.f67345e = aVar.f67353e;
        this.f67346f = aVar.f67354f;
        this.f67347g = aVar.f67355g;
        this.f67348h = aVar.f67356h;
    }

    public int a() {
        return this.f67342b;
    }

    public l b() {
        return this.f67345e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f67342b + ", message=" + this.f67343c + ", url=" + this.f67341a.a() + ExtendedMessageFormat.END_FE;
    }
}
