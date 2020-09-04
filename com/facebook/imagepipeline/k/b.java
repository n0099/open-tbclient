package com.facebook.imagepipeline.k;
/* loaded from: classes8.dex */
public class b {
    public static final a nAq = new C0874b();
    private static volatile c nAr = null;

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* loaded from: classes8.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        dWB().beginSection(str);
    }

    public static void endSection() {
        dWB().endSection();
    }

    private static c dWB() {
        if (nAr == null) {
            synchronized (b.class) {
                if (nAr == null) {
                    nAr = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return nAr;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static final class C0874b implements a {
        private C0874b() {
        }
    }
}
