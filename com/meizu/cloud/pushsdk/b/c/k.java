package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes6.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final i f11475a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11476b;
    private final String c;
    private final c d;
    private final l e;
    private k f;
    private k g;
    private final k h;

    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private i f11477a;
        private String c;
        private l e;
        private k f;
        private k g;
        private k h;

        /* renamed from: b  reason: collision with root package name */
        private int f11478b = -1;
        private c.a d = new c.a();

        public a a(int i) {
            this.f11478b = i;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f11477a = iVar;
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
            if (this.f11477a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f11478b < 0) {
                throw new IllegalStateException("code < 0: " + this.f11478b);
            }
            return new k(this);
        }
    }

    private k(a aVar) {
        this.f11475a = aVar.f11477a;
        this.f11476b = aVar.f11478b;
        this.c = aVar.c;
        this.d = aVar.d.a();
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public int a() {
        return this.f11476b;
    }

    public l b() {
        return this.e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f11476b + ", message=" + this.c + ", url=" + this.f11475a.a() + '}';
    }
}
