package com.kwad.sdk.emotion.model;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f10051a;

    /* renamed from: com.kwad.sdk.emotion.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C1083a {

        /* renamed from: a  reason: collision with root package name */
        private final a f10052a;

        private C1083a() {
            this.f10052a = new a();
        }

        public C1083a a(String str) {
            this.f10052a.f10051a = str;
            return this;
        }

        public a a() {
            return new a(this.f10052a.f10051a);
        }
    }

    private a() {
    }

    private a(String str) {
        this.f10051a = str;
    }

    public static C1083a a() {
        return new C1083a();
    }

    public String b() {
        return this.f10051a;
    }
}
