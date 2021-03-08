package com.bytedance.sdk.openadsdk.preload.geckox.a.a;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    final int f5054a;
    final c b;
    private final b c;

    private a(C1045a c1045a) {
        this.f5054a = c1045a.f5055a;
        this.c = c1045a.b;
        this.b = c1045a.c;
    }

    public b a() {
        return this.c;
    }

    public int b() {
        return this.f5054a;
    }

    public c c() {
        return this.b;
    }

    /* renamed from: com.bytedance.sdk.openadsdk.preload.geckox.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1045a {

        /* renamed from: a  reason: collision with root package name */
        private int f5055a;
        private b b = b.f5056a;
        private c c;

        public C1045a a(int i) {
            this.f5055a = i;
            return this;
        }

        public C1045a a(b bVar) {
            if (bVar == null) {
                bVar = b.f5056a;
            }
            this.b = bVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }
}
