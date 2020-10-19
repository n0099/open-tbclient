package com.facebook.imagepipeline.k;
/* loaded from: classes12.dex */
public class b {
    public static final a nZE = new C0889b();
    private static volatile c nZF = null;

    /* loaded from: classes12.dex */
    public interface a {
    }

    /* loaded from: classes12.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        eek().beginSection(str);
    }

    public static void endSection() {
        eek().endSection();
    }

    private static c eek() {
        if (nZF == null) {
            synchronized (b.class) {
                if (nZF == null) {
                    nZF = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return nZF;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C0889b implements a {
        private C0889b() {
        }
    }
}
