package com.kwad.sdk.emotion.model;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f10052a;

    /* renamed from: com.kwad.sdk.emotion.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1124a {

        /* renamed from: a  reason: collision with root package name */
        private final a f10053a;

        private C1124a() {
            this.f10053a = new a();
        }

        public C1124a a(String str) {
            this.f10053a.f10052a = str;
            return this;
        }

        public a a() {
            return new a(this.f10053a.f10052a);
        }
    }

    private a() {
    }

    private a(String str) {
        this.f10052a = str;
    }

    public static C1124a a() {
        return new C1124a();
    }

    public String b() {
        return this.f10052a;
    }
}
