package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a mYg = new C0807b();
    private static volatile c mYh = null;

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
        dHg().beginSection(str);
    }

    public static void endSection() {
        dHg().endSection();
    }

    private static c dHg() {
        if (mYh == null) {
            synchronized (b.class) {
                if (mYh == null) {
                    mYh = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return mYh;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0807b implements a {
        private C0807b() {
        }
    }
}
