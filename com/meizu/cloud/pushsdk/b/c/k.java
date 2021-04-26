package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final i f35484a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35485b;

    /* renamed from: c  reason: collision with root package name */
    public final String f35486c;

    /* renamed from: d  reason: collision with root package name */
    public final c f35487d;

    /* renamed from: e  reason: collision with root package name */
    public final l f35488e;

    /* renamed from: f  reason: collision with root package name */
    public k f35489f;

    /* renamed from: g  reason: collision with root package name */
    public k f35490g;

    /* renamed from: h  reason: collision with root package name */
    public final k f35491h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public i f35492a;

        /* renamed from: c  reason: collision with root package name */
        public String f35494c;

        /* renamed from: e  reason: collision with root package name */
        public l f35496e;

        /* renamed from: f  reason: collision with root package name */
        public k f35497f;

        /* renamed from: g  reason: collision with root package name */
        public k f35498g;

        /* renamed from: h  reason: collision with root package name */
        public k f35499h;

        /* renamed from: b  reason: collision with root package name */
        public int f35493b = -1;

        /* renamed from: d  reason: collision with root package name */
        public c.a f35495d = new c.a();

        public a a(int i2) {
            this.f35493b = i2;
            return this;
        }

        public a a(c cVar) {
            this.f35495d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f35492a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.f35496e = lVar;
            return this;
        }

        public a a(String str) {
            this.f35494c = str;
            return this;
        }

        public k a() {
            if (this.f35492a != null) {
                if (this.f35493b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.f35493b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.f35484a = aVar.f35492a;
        this.f35485b = aVar.f35493b;
        this.f35486c = aVar.f35494c;
        this.f35487d = aVar.f35495d.a();
        this.f35488e = aVar.f35496e;
        this.f35489f = aVar.f35497f;
        this.f35490g = aVar.f35498g;
        this.f35491h = aVar.f35499h;
    }

    public int a() {
        return this.f35485b;
    }

    public l b() {
        return this.f35488e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f35485b + ", message=" + this.f35486c + ", url=" + this.f35484a.a() + '}';
    }
}
