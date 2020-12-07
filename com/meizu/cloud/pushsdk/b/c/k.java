package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes16.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final i f4108a;
    private final int b;
    private final String c;
    private final c d;
    private final l e;
    private k f;
    private k g;
    private final k h;

    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private i f4109a;
        private String c;
        private l e;
        private k f;
        private k g;
        private k h;
        private int b = -1;
        private c.a d = new c.a();

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f4109a = iVar;
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
            if (this.f4109a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b < 0) {
                throw new IllegalStateException("code < 0: " + this.b);
            }
            return new k(this);
        }
    }

    private k(a aVar) {
        this.f4108a = aVar.f4109a;
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
        return "Response{protocol=, code=" + this.b + ", message=" + this.c + ", url=" + this.f4108a.a() + '}';
    }
}
