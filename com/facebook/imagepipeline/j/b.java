package com.facebook.imagepipeline.j;
/* loaded from: classes5.dex */
public class b {
    public static final a pHU = new C1065b();
    private static volatile c pHV = null;

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
        eBJ().beginSection(str);
    }

    public static void endSection() {
        eBJ().endSection();
    }

    private static c eBJ() {
        if (pHV == null) {
            synchronized (b.class) {
                if (pHV == null) {
                    pHV = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return pHV;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    private static final class C1065b implements a {
        private C1065b() {
        }
    }
}
