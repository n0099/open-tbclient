package com.facebook.imagepipeline.k;
/* loaded from: classes3.dex */
public class b {
    public static final a ngh = new C0816b();
    private static volatile c ngi = null;

    /* loaded from: classes3.dex */
    public interface a {
    }

    /* loaded from: classes3.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        dKs().beginSection(str);
    }

    public static void endSection() {
        dKs().endSection();
    }

    private static c dKs() {
        if (ngi == null) {
            synchronized (b.class) {
                if (ngi == null) {
                    ngi = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return ngi;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0816b implements a {
        private C0816b() {
        }
    }
}
