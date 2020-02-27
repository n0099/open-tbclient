package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double nYc;
    public static final int nYd;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.nYc);
        public static final int medium = (int) (120.0d * b.nYc);
        public static final int nYe = (int) (400.0d * b.nYc);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0816b {
        public static final int small = (int) (50.0d * b.nYc);
        public static final int medium = (int) (90.0d * b.nYc);
        public static final int nYe = (int) (120.0d * b.nYc);
        public static final int nYf = (int) (150.0d * b.nYc);
    }

    static {
        nYc = 1.0d;
        if (h.dPR() != null) {
            nYc = h.dQs().getDisplayMetrics().density / 2.0d;
        }
        nYd = (int) (nYc * 550.0d);
    }
}
