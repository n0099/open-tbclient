package com.facebook.imagepipeline.k;
/* loaded from: classes12.dex */
public class b {
    public static final a lWB = new C0658b();
    private static volatile c lWC = null;

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
        drn().beginSection(str);
    }

    public static void endSection() {
        drn().endSection();
    }

    private static c drn() {
        if (lWC == null) {
            synchronized (b.class) {
                if (lWC == null) {
                    lWC = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return lWC;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C0658b implements a {
        private C0658b() {
        }
    }
}
