package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double olU;
    public static final int olV;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.olU);
        public static final int olW = (int) (120.0d * b.olU);
        public static final int olX = (int) (400.0d * b.olU);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0943b {
        public static final int small = (int) (50.0d * b.olU);
        public static final int olW = (int) (90.0d * b.olU);
        public static final int olX = (int) (120.0d * b.olU);
        public static final int olY = (int) (150.0d * b.olU);
    }

    static {
        olU = 1.0d;
        if (h.dWe() != null) {
            olU = h.dWI().getDisplayMetrics().density / 2.0d;
        }
        olV = (int) (olU * 550.0d);
    }
}
