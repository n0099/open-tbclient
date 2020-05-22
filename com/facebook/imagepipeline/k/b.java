package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a mAL = new C0786b();
    private static volatile c mAM = null;

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
        dCm().beginSection(str);
    }

    public static void endSection() {
        dCm().endSection();
    }

    private static c dCm() {
        if (mAM == null) {
            synchronized (b.class) {
                if (mAM == null) {
                    mAM = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return mAM;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0786b implements a {
        private C0786b() {
        }
    }
}
