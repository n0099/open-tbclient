package com.facebook.imagepipeline.j;
/* loaded from: classes7.dex */
public class b {
    public static final a pqO = new C0998b();
    private static volatile c pqP = null;

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
        exy().beginSection(str);
    }

    public static void endSection() {
        exy().endSection();
    }

    private static c exy() {
        if (pqP == null) {
            synchronized (b.class) {
                if (pqP == null) {
                    pqP = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pqP;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private static final class C0998b implements a {
        private C0998b() {
        }
    }
}
