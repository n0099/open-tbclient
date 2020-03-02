package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double nYe;
    public static final int nYf;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.nYe);
        public static final int medium = (int) (120.0d * b.nYe);
        public static final int nYg = (int) (400.0d * b.nYe);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0816b {
        public static final int small = (int) (50.0d * b.nYe);
        public static final int medium = (int) (90.0d * b.nYe);
        public static final int nYg = (int) (120.0d * b.nYe);
        public static final int nYh = (int) (150.0d * b.nYe);
    }

    static {
        nYe = 1.0d;
        if (h.dPT() != null) {
            nYe = h.dQu().getDisplayMetrics().density / 2.0d;
        }
        nYf = (int) (nYe * 550.0d);
    }
}
