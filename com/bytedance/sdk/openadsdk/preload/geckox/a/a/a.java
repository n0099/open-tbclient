package com.bytedance.sdk.openadsdk.preload.geckox.a.a;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final int f7741a;

    /* renamed from: b  reason: collision with root package name */
    final c f7742b;
    private final b c;

    private a(C1004a c1004a) {
        this.f7741a = c1004a.f7743a;
        this.c = c1004a.f7744b;
        this.f7742b = c1004a.c;
    }

    public b a() {
        return this.c;
    }

    public int b() {
        return this.f7741a;
    }

    public c c() {
        return this.f7742b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1004a {

        /* renamed from: a  reason: collision with root package name */
        private int f7743a;

        /* renamed from: b  reason: collision with root package name */
        private b f7744b = b.f7745a;
        private c c;

        public C1004a a(int i) {
            this.f7743a = i;
            return this;
        }

        public C1004a a(b bVar) {
            if (bVar == null) {
                bVar = b.f7745a;
            }
            this.f7744b = bVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
