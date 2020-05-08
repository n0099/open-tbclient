package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a mgU = new C0731b();
    private static volatile c mgV = null;

    /* loaded from: classes13.dex */
    public interface a {
    }

    /* loaded from: classes13.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        duU().beginSection(str);
    }

    public static void endSection() {
        duU().endSection();
    }

    private static c duU() {
        if (mgV == null) {
            synchronized (b.class) {
                if (mgV == null) {
                    mgV = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return mgV;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0731b implements a {
        private C0731b() {
        }
    }
}
