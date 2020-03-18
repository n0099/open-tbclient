package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a lZg = new C0667b();
    private static volatile c lZh = null;

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
        dtb().beginSection(str);
    }

    public static void endSection() {
        dtb().endSection();
    }

    private static c dtb() {
        if (lZh == null) {
            synchronized (b.class) {
                if (lZh == null) {
                    lZh = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return lZh;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0667b implements a {
        private C0667b() {
        }
    }
}
