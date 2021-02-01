package com.meizu.cloud.pushsdk.b.c;

import com.meizu.cloud.pushsdk.b.c.c;
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final i f11178a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11179b;
    private final String c;
    private final c d;
    private final l e;
    private k f;
    private k g;
    private final k h;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private i f11180a;
        private String c;
        private l e;
        private k f;
        private k g;
        private k h;

        /* renamed from: b  reason: collision with root package name */
        private int f11181b = -1;
        private c.a d = new c.a();

        public a a(int i) {
            this.f11181b = i;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f11180a = iVar;
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
            if (this.f11180a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f11181b < 0) {
                throw new IllegalStateException("code < 0: " + this.f11181b);
            }
            return new k(this);
        }
    }

    private k(a aVar) {
        this.f11178a = aVar.f11180a;
        this.f11179b = aVar.f11181b;
        this.c = aVar.c;
        this.d = aVar.d.a();
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public int a() {
        return this.f11179b;
    }

    public l b() {
        return this.e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.f11179b + ", message=" + this.c + ", url=" + this.f11178a.a() + '}';
    }
}
