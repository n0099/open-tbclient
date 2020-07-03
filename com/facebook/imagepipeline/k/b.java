package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a mYd = new C0806b();
    private static volatile c mYe = null;

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
        dHc().beginSection(str);
    }

    public static void endSection() {
        dHc().endSection();
    }

    private static c dHc() {
        if (mYe == null) {
            synchronized (b.class) {
                if (mYe == null) {
                    mYe = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return mYe;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0806b implements a {
        private C0806b() {
        }
    }
}
