package com.facebook.imagepipeline.j;
/* loaded from: classes11.dex */
public class b {
    public static final a lSM = new C0652b();
    private static volatile c lSN = null;

    /* loaded from: classes11.dex */
    public interface a {
    }

    /* loaded from: classes11.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        dqb().beginSection(str);
    }

    public static void endSection() {
        dqb().endSection();
    }

    private static c dqb() {
        if (lSN == null) {
            synchronized (b.class) {
                if (lSN == null) {
                    lSN = new com.facebook.imagepipeline.j.a();
                }
            }
        }
        return lSN;
    }

    /* renamed from: com.facebook.imagepipeline.j.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static final class C0652b implements a {
        private C0652b() {
        }
    }
}
