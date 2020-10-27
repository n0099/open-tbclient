package com.facebook.imagepipeline.k;
/* loaded from: classes12.dex */
public class b {
    public static final a oQW = new C0961b();
    private static volatile c oQX = null;

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
        eok().beginSection(str);
    }

    public static void endSection() {
        eok().endSection();
    }

    private static c eok() {
        if (oQX == null) {
            synchronized (b.class) {
                if (oQX == null) {
                    oQX = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return oQX;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    private static final class C0961b implements a {
        private C0961b() {
        }
    }
}
