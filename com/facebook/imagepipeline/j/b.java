package com.facebook.imagepipeline.j;
/* loaded from: classes5.dex */
public class b {
    public static final a pQh = new C1069b();
    private static volatile c pQi = null;

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        eAA().beginSection(str);
    }

    public static void endSection() {
        eAA().endSection();
    }

    private static c eAA() {
        if (pQi == null) {
            synchronized (b.class) {
                if (pQi == null) {
                    pQi = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pQi;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C1069b implements a {
        private C1069b() {
        }
    }
}
