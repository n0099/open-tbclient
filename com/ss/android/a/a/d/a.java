package com.ss.android.a.a.d;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f12891a;

    /* renamed from: b  reason: collision with root package name */
    public String f12892b;
    public String c;
    public String d;
    public String e;

    public a(C1213a c1213a) {
        this.f12892b = "";
        this.f12891a = c1213a.f12893a;
        this.f12892b = c1213a.f12894b;
        this.c = c1213a.c;
        this.d = c1213a.d;
        this.e = c1213a.e;
    }

    /* renamed from: com.ss.android.a.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1213a {

        /* renamed from: a  reason: collision with root package name */
        private String f12893a;

        /* renamed from: b  reason: collision with root package name */
        private String f12894b;
        private String c;
        private String d;
        private String e;

        public C1213a Za(String str) {
            this.f12893a = str;
            return this;
        }

        public C1213a Zb(String str) {
            this.f12894b = str;
            return this;
        }

        public C1213a Zc(String str) {
            this.d = str;
            return this;
        }

        public C1213a Zd(String str) {
            this.e = str;
            return this;
        }

        public a eBK() {
            return new a(this);
        }
    }
}
