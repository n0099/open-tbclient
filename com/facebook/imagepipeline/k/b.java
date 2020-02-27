package com.facebook.imagepipeline.k;
/* loaded from: classes13.dex */
public class b {
    public static final a lXn = new C0666b();
    private static volatile c lXo = null;

    /* loaded from: classes13.dex */
    public interface a {
    }

    /* loaded from: classes13.dex */
    public interface c {
        void beginSection(String str);

        void endSection();
    }

    private b() {
    }

    public static void beginSection(String str) {
        dsB().beginSection(str);
    }

    public static void endSection() {
        dsB().endSection();
    }

    private static c dsB() {
        if (lXo == null) {
            synchronized (b.class) {
                if (lXo == null) {
                    lXo = new com.facebook.imagepipeline.k.a();
                }
            }
        }
        return lXo;
    }

    /* renamed from: com.facebook.imagepipeline.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    private static final class C0666b implements a {
        private C0666b() {
        }
    }
}
