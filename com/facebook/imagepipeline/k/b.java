package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a lXp = new C0666b();
    private static volatile c lXq = null;

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
        dsD().beginSection(str);
    }

    public static void endSection() {
        dsD().endSection();
    }

    private static c dsD() {
        if (lXq == null) {
            synchronized (b.class) {
                if (lXq == null) {
                    lXq = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return lXq;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0666b implements a {
        private C0666b() {
        }
    }
}
