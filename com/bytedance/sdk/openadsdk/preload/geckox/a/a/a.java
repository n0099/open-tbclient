package com.bytedance.sdk.openadsdk.preload.geckox.a.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final int f7442a;

    /* renamed from: b  reason: collision with root package name */
    final c f7443b;
    private final b c;

    private a(C1025a c1025a) {
        this.f7442a = c1025a.f7444a;
        this.c = c1025a.f7445b;
        this.f7443b = c1025a.c;
    }

    public b a() {
        return this.c;
    }

    public int b() {
        return this.f7442a;
    }

    public c c() {
        return this.f7443b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1025a {

        /* renamed from: a  reason: collision with root package name */
        private int f7444a;

        /* renamed from: b  reason: collision with root package name */
        private b f7445b = b.f7446a;
        private c c;

        public C1025a a(int i) {
            this.f7444a = i;
            return this;
        }

        public C1025a a(b bVar) {
            if (bVar == null) {
                bVar = b.f7446a;
            }
            this.f7445b = bVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
