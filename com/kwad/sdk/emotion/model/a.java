package com.kwad.sdk.emotion.model;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f6456a;

    /* renamed from: com.kwad.sdk.emotion.model.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1130a {

        /* renamed from: a  reason: collision with root package name */
        private final a f6457a;

        private C1130a() {
            this.f6457a = new a();
        }

        public C1130a a(String str) {
            this.f6457a.f6456a = str;
            return this;
        }

        public a a() {
            return new a(this.f6457a.f6456a);
        }
    }

    private a() {
    }

    private a(String str) {
        this.f6456a = str;
    }

    public static C1130a a() {
        return new C1130a();
    }

    public String b() {
        return this.f6456a;
    }
}
