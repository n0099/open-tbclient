package com.facebook.imagepipeline.k;
/* loaded from: classes12.dex */
public class b {
    public static final a paq = new C0980b();
    private static volatile c par = null;

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
        erZ().beginSection(str);
    }

    public static void endSection() {
        erZ().endSection();
    }

    private static c erZ() {
        if (par == null) {
            synchronized (b.class) {
                if (par == null) {
                    par = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return par;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C0980b implements a {
        private C0980b() {
        }
    }
}
