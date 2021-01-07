package com.bytedance.sdk.openadsdk.preload.geckox.a.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final int f7742a;

    /* renamed from: b  reason: collision with root package name */
    final c f7743b;
    private final b c;

    private a(C1042a c1042a) {
        this.f7742a = c1042a.f7744a;
        this.c = c1042a.f7745b;
        this.f7743b = c1042a.c;
    }

    public b a() {
        return this.c;
    }

    public int b() {
        return this.f7742a;
    }

    public c c() {
        return this.f7743b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1042a {

        /* renamed from: a  reason: collision with root package name */
        private int f7744a;

        /* renamed from: b  reason: collision with root package name */
        private b f7745b = b.f7746a;
        private c c;

        public C1042a a(int i) {
            this.f7744a = i;
            return this;
        }

        public C1042a a(b bVar) {
            if (bVar == null) {
                bVar = b.f7746a;
            }
            this.f7745b = bVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
