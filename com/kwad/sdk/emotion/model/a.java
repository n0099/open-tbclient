package com.kwad.sdk.emotion.model;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f9752a;

    /* renamed from: com.kwad.sdk.emotion.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1107a {

        /* renamed from: a  reason: collision with root package name */
        private final a f9753a;

        private C1107a() {
            this.f9753a = new a();
        }

        public C1107a a(String str) {
            this.f9753a.f9752a = str;
            return this;
        }

        public a a() {
            return new a(this.f9753a.f9752a);
        }
    }

    private a() {
    }

    private a(String str) {
        this.f9752a = str;
    }

    public static C1107a a() {
        return new C1107a();
    }

    public String b() {
        return this.f9752a;
    }
}
