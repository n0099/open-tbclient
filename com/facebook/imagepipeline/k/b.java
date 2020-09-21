package com.facebook.imagepipeline.k;
/* loaded from: classes12.dex */
public class b {
    public static final a nKn = new C0871b();
    private static volatile c nKo = null;

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
        eaz().beginSection(str);
    }

    public static void endSection() {
        eaz().endSection();
    }

    private static c eaz() {
        if (nKo == null) {
            synchronized (b.class) {
                if (nKo == null) {
                    nKo = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return nKo;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C0871b implements a {
        private C0871b() {
        }
    }
}
