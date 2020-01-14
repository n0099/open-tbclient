package com.facebook.imagepipeline.k;
/* loaded from: classes12.dex */
public class b {
    public static final a lWG = new C0658b();
    private static volatile c lWH = null;

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
        drp().beginSection(str);
    }

    public static void endSection() {
        drp().endSection();
    }

    private static c drp() {
        if (lWH == null) {
            synchronized (b.class) {
                if (lWH == null) {
                    lWH = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return lWH;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C0658b implements a {
        private C0658b() {
        }
    }
}
