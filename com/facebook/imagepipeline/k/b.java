package com.facebook.imagepipeline.k;
/* loaded from: classes8.dex */
public class b {
    public static final a nzY = new C0874b();
    private static volatile c nzZ = null;

    /* loaded from: classes8.dex */
    public interface a {
    }

    /* loaded from: classes8.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        dWs().beginSection(str);
    }

    public static void endSection() {
        dWs().endSection();
    }

    private static c dWs() {
        if (nzZ == null) {
            synchronized (b.class) {
                if (nzZ == null) {
                    nzZ = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return nzZ;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    private static final class C0874b implements a {
        private C0874b() {
        }
    }
}
