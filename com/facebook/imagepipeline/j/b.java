package com.facebook.imagepipeline.j;
/* loaded from: classes6.dex */
public class b {
    public static final a pGo = new C1024b();
    private static volatile c pGp = null;

    /* loaded from: classes6.dex */
    public interface a {
    }

    /* loaded from: classes6.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        eBf().beginSection(str);
    }

    public static void endSection() {
        eBf().endSection();
    }

    private static c eBf() {
        if (pGp == null) {
            synchronized (b.class) {
                if (pGp == null) {
                    pGp = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pGp;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private static final class C1024b implements a {
        private C1024b() {
        }
    }
}
