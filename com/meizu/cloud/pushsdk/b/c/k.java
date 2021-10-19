package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f74977a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74978b;

    /* renamed from: c  reason: collision with root package name */
    public final String f74979c;

    /* renamed from: d  reason: collision with root package name */
    public final c f74980d;

    /* renamed from: e  reason: collision with root package name */
    public final l f74981e;

    /* renamed from: f  reason: collision with root package name */
    public k f74982f;

    /* renamed from: g  reason: collision with root package name */
    public k f74983g;

    /* renamed from: h  reason: collision with root package name */
    public final k f74984h;

    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f74985a;

        /* renamed from: c  reason: collision with root package name */
        public String f74987c;

        /* renamed from: e  reason: collision with root package name */
        public l f74989e;

        /* renamed from: f  reason: collision with root package name */
        public k f74990f;

        /* renamed from: g  reason: collision with root package name */
        public k f74991g;

        /* renamed from: h  reason: collision with root package name */
        public k f74992h;

        /* renamed from: b  reason: collision with root package name */
        public int f74986b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f74988d = new c.a();

        public a a(int i2) {
            this.f74986b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f74988d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f74985a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f74989e = lVar;
            return this;
        }

        public a a(String str) {
            this.f74987c = str;
            return this;
        }

        public k a() {
            if (this.f74985a != null) {
                if (this.f74986b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f74986b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f74977a = aVar.f74985a;
        this.f74978b = aVar.f74986b;
        this.f74979c = aVar.f74987c;
        this.f74980d = aVar.f74988d.a();
        this.f74981e = aVar.f74989e;
        this.f74982f = aVar.f74990f;
        this.f74983g = aVar.f74991g;
        this.f74984h = aVar.f74992h;
    }

    public int a() {
        return this.f74978b;
    }

    public l b() {
        return this.f74981e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f74978b + ", message=" + this.f74979c + ", url=" + this.f74977a.a() + ExtendedMessageFormat.END_FE;
    }
}
