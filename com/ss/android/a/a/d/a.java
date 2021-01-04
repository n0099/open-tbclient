package com.ss.android.a.a.d;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f13190a;

    /* renamed from: b  reason: collision with root package name */
    public String f13191b;
    public String c;
    public String d;
    public String e;

    public a(C1189a c1189a) {
        this.f13191b = "";
        this.f13190a = c1189a.f13192a;
        this.f13191b = c1189a.f13193b;
        this.c = c1189a.c;
        this.d = c1189a.d;
        this.e = c1189a.e;
    }

    /* renamed from: com.ss.android.a.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1189a {

        /* renamed from: a  reason: collision with root package name */
        private String f13192a;

        /* renamed from: b  reason: collision with root package name */
        private String f13193b;
        private String c;
        private String d;
        private String e;

        public C1189a aag(String str) {
            this.f13192a = str;
            return this;
        }

        public C1189a aah(String str) {
            this.f13193b = str;
            return this;
        }

        public C1189a aai(String str) {
            this.d = str;
            return this;
        }

        public C1189a aaj(String str) {
            this.e = str;
            return this;
        }

        public a eEX() {
            return new a(this);
        }
    }
}
