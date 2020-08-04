package com.facebook.imagepipeline.k;
/* loaded from: classes3.dex */
public class b {
    public static final a ngj = new C0816b();
    private static volatile c ngk = null;

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
        dKt().beginSection(str);
    }

    public static void endSection() {
        dKt().endSection();
    }

    private static c dKt() {
        if (ngk == null) {
            synchronized (b.class) {
                if (ngk == null) {
                    ngk = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return ngk;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0816b implements a {
        private C0816b() {
        }
    }
}
