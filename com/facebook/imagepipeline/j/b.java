package com.facebook.imagepipeline.j;
/* loaded from: classes5.dex */
public class b {
    public static final a pOc = new C1054b();
    private static volatile c pOd = null;

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
        eAr().beginSection(str);
    }

    public static void endSection() {
        eAr().endSection();
    }

    private static c eAr() {
        if (pOd == null) {
            synchronized (b.class) {
                if (pOd == null) {
                    pOd = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pOd;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C1054b implements a {
        private C1054b() {
        }
    }
}
