package com.facebook.imagepipeline.j;
/* loaded from: classes5.dex */
public class b {
    public static final a pDt = new C1048b();
    private static volatile c pDu = null;

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
        exR().beginSection(str);
    }

    public static void endSection() {
        exR().endSection();
    }

    private static c exR() {
        if (pDu == null) {
            synchronized (b.class) {
                if (pDu == null) {
                    pDu = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pDu;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C1048b implements a {
        private C1048b() {
        }
    }
}
