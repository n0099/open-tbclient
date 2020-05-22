package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double nOW;
    public static final int nOX;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.nOW);
        public static final int nOY = (int) (120.0d * b.nOW);
        public static final int nOZ = (int) (400.0d * b.nOW);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0923b {
        public static final int small = (int) (50.0d * b.nOW);
        public static final int nOY = (int) (90.0d * b.nOW);
        public static final int nOZ = (int) (120.0d * b.nOW);
        public static final int nPa = (int) (150.0d * b.nOW);
    }

    static {
        nOW = 1.0d;
        if (h.dRk() != null) {
            nOW = h.dRO().getDisplayMetrics().density / 2.0d;
        }
        nOX = (int) (nOW * 550.0d);
    }
}
