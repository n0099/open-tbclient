package com.ss.android.a.a.d;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f13191a;

    /* renamed from: b  reason: collision with root package name */
    public String f13192b;
    public String c;
    public String d;
    public String e;

    public a(C1230a c1230a) {
        this.f13192b = "";
        this.f13191a = c1230a.f13193a;
        this.f13192b = c1230a.f13194b;
        this.c = c1230a.c;
        this.d = c1230a.d;
        this.e = c1230a.e;
    }

    /* renamed from: com.ss.android.a.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1230a {

        /* renamed from: a  reason: collision with root package name */
        private String f13193a;

        /* renamed from: b  reason: collision with root package name */
        private String f13194b;
        private String c;
        private String d;
        private String e;

        public C1230a aah(String str) {
            this.f13193a = str;
            return this;
        }

        public C1230a aai(String str) {
            this.f13194b = str;
            return this;
        }

        public C1230a aaj(String str) {
            this.d = str;
            return this;
        }

        public C1230a aak(String str) {
            this.e = str;
            return this;
        }

        public a eFB() {
            return new a(this);
        }
    }
}
