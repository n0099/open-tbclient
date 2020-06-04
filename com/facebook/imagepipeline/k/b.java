package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a mBW = new C0787b();
    private static volatile c mBX = null;

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
        dCA().beginSection(str);
    }

    public static void endSection() {
        dCA().endSection();
    }

    private static c dCA() {
        if (mBX == null) {
            synchronized (b.class) {
                if (mBX == null) {
                    mBX = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return mBX;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0787b implements a {
        private C0787b() {
        }
    }
}
