package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double nQg;
    public static final int nQh;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.nQg);
        public static final int nQi = (int) (120.0d * b.nQg);
        public static final int nQj = (int) (400.0d * b.nQg);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0924b {
        public static final int small = (int) (50.0d * b.nQg);
        public static final int nQi = (int) (90.0d * b.nQg);
        public static final int nQj = (int) (120.0d * b.nQg);
        public static final int nQk = (int) (150.0d * b.nQg);
    }

    static {
        nQg = 1.0d;
        if (h.dRy() != null) {
            nQg = h.dSc().getDisplayMetrics().density / 2.0d;
        }
        nQh = (int) (nQg * 550.0d);
    }
}
