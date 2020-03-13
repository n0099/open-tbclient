package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a lXA = new C0666b();
    private static volatile c lXB = null;

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
        dsE().beginSection(str);
    }

    public static void endSection() {
        dsE().endSection();
    }

    private static c dsE() {
        if (lXB == null) {
            synchronized (b.class) {
                if (lXB == null) {
                    lXB = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return lXB;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0666b implements a {
        private C0666b() {
        }
    }
}
