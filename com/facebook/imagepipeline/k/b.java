package com.facebook.imagepipeline.k;
/* loaded from: classes17.dex */
public class b {
    public static final a pbU = new C0983b();
    private static volatile c pbV = null;

    /* loaded from: classes17.dex */
    public interface a {
    }

    /* loaded from: classes17.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        erX().beginSection(str);
    }

    public static void endSection() {
        erX().endSection();
    }

    private static c erX() {
        if (pbV == null) {
            synchronized (b.class) {
                if (pbV == null) {
                    pbV = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return pbV;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    private static final class C0983b implements a {
        private C0983b() {
        }
    }
}
