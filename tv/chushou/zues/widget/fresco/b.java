package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double pnK;
    public static final int pnL;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.pnK);
        public static final int pnM = (int) (120.0d * b.pnK);
        public static final int pnN = (int) (400.0d * b.pnK);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1032b {
        public static final int small = (int) (50.0d * b.pnK);
        public static final int pnM = (int) (90.0d * b.pnK);
        public static final int pnN = (int) (120.0d * b.pnK);
        public static final int pnO = (int) (150.0d * b.pnK);
    }

    static {
        pnK = 1.0d;
        if (h.etB() != null) {
            pnK = h.eue().getDisplayMetrics().density / 2.0d;
        }
        pnL = (int) (pnK * 550.0d);
    }
}
