package com.facebook.imagepipeline.j;
/* loaded from: classes5.dex */
public class b {
    public static final a pNC = new C1052b();
    private static volatile c pND = null;

    /* loaded from: classes5.dex */
    public interface a {
    }

    /* loaded from: classes5.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        eAj().beginSection(str);
    }

    public static void endSection() {
        eAj().endSection();
    }

    private static c eAj() {
        if (pND == null) {
            synchronized (b.class) {
                if (pND == null) {
                    pND = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pND;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C1052b implements a {
        private C1052b() {
        }
    }
}
