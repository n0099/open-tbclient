package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double nYp;
    public static final int nYq;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.nYp);
        public static final int medium = (int) (120.0d * b.nYp);
        public static final int nYr = (int) (400.0d * b.nYp);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0816b {
        public static final int small = (int) (50.0d * b.nYp);
        public static final int medium = (int) (90.0d * b.nYp);
        public static final int nYr = (int) (120.0d * b.nYp);
        public static final int nYs = (int) (150.0d * b.nYp);
    }

    static {
        nYp = 1.0d;
        if (h.dPU() != null) {
            nYp = h.dQv().getDisplayMetrics().density / 2.0d;
        }
        nYq = (int) (nYp * 550.0d);
    }
}
