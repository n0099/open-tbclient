package com.facebook.imagepipeline.j;
/* loaded from: classes7.dex */
public class b {
    public static final a pqM = new C0998b();
    private static volatile c pqN = null;

    /* loaded from: classes7.dex */
    public interface a {
    }

    /* loaded from: classes7.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        exx().beginSection(str);
    }

    public static void endSection() {
        exx().endSection();
    }

    private static c exx() {
        if (pqN == null) {
            synchronized (b.class) {
                if (pqN == null) {
                    pqN = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pqN;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static final class C0998b implements a {
        private C0998b() {
        }
    }
}
