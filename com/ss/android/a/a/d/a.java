package com.ss.android.a.a.d;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f7671a;
    public String b;
    public String c;
    public String d;
    public String e;

    public a(C1209a c1209a) {
        this.b = "";
        this.f7671a = c1209a.f7672a;
        this.b = c1209a.b;
        this.c = c1209a.c;
        this.d = c1209a.d;
        this.e = c1209a.e;
    }

    /* renamed from: com.ss.android.a.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C1209a {

        /* renamed from: a  reason: collision with root package name */
        private String f7672a;
        private String b;
        private String c;
        private String d;
        private String e;

        public C1209a aas(String str) {
            this.f7672a = str;
            return this;
        }

        public C1209a aat(String str) {
            this.b = str;
            return this;
        }

        public C1209a aau(String str) {
            this.d = str;
            return this;
        }

        public C1209a aav(String str) {
            this.e = str;
            return this;
        }

        public a eEn() {
            return new a(this);
        }
    }
}
