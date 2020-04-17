package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a mgQ = new C0710b();
    private static volatile c mgR = null;

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
        duX().beginSection(str);
    }

    public static void endSection() {
        duX().endSection();
    }

    private static c duX() {
        if (mgR == null) {
            synchronized (b.class) {
                if (mgR == null) {
                    mgR = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return mgR;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0710b implements a {
        private C0710b() {
        }
    }
}
