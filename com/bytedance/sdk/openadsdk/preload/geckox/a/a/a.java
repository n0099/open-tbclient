package com.bytedance.sdk.openadsdk.preload.geckox.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final int f7444a;

    /* renamed from: b  reason: collision with root package name */
    final c f7445b;
    private final b c;

    private a(C1029a c1029a) {
        this.f7444a = c1029a.f7446a;
        this.c = c1029a.f7447b;
        this.f7445b = c1029a.c;
    }

    public b a() {
        return this.c;
    }

    public int b() {
        return this.f7444a;
    }

    public c c() {
        return this.f7445b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1029a {

        /* renamed from: a  reason: collision with root package name */
        private int f7446a;

        /* renamed from: b  reason: collision with root package name */
        private b f7447b = b.f7448a;
        private c c;

        public C1029a a(int i) {
            this.f7446a = i;
            return this;
        }

        public C1029a a(b bVar) {
            if (bVar == null) {
                bVar = b.f7448a;
            }
            this.f7447b = bVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
