package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.c.c;
/* loaded from: classes10.dex */
public class k {
    public final i a;
    public final int b;
    public final String c;
    public final c d;
    public final l e;
    public final k f;
    public final k g;
    public final k h;

    /* loaded from: classes10.dex */
    public static class a {
        public i a;
        public String c;
        public l e;
        public k f;
        public k g;
        public k h;
        public int b = -1;
        public c.a d = new c.a();

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.e = lVar;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public k a() {
            if (this.a != null) {
                if (this.b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d.a();
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public int a() {
        return this.b;
    }

    public l b() {
        return this.e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.b + ", message=" + this.c + ", url=" + this.a.a() + '}';
    }
}
