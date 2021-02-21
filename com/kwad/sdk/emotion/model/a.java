package com.kwad.sdk.emotion.model;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f9754a;

    /* renamed from: com.kwad.sdk.emotion.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1113a {

        /* renamed from: a  reason: collision with root package name */
        private final a f9755a;

        private C1113a() {
            this.f9755a = new a();
        }

        public C1113a a(String str) {
            this.f9755a.f9754a = str;
            return this;
        }

        public a a() {
            return new a(this.f9755a.f9754a);
        }
    }

    private a() {
    }

    private a(String str) {
        this.f9754a = str;
    }

    public static C1113a a() {
        return new C1113a();
    }

    public String b() {
        return this.f9754a;
    }
}
