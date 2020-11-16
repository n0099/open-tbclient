package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double qpW;
    public static final int qpX;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.qpW);
        public static final int qpY = (int) (120.0d * b.qpW);
        public static final int qpZ = (int) (400.0d * b.qpW);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1127b {
        public static final int small = (int) (50.0d * b.qpW);
        public static final int qpY = (int) (90.0d * b.qpW);
        public static final int qpZ = (int) (120.0d * b.qpW);
        public static final int qqa = (int) (150.0d * b.qpW);
    }

    static {
        qpW = 1.0d;
        if (h.eHp() != null) {
            qpW = h.eHS().getDisplayMetrics().density / 2.0d;
        }
        qpX = (int) (qpW * 550.0d);
    }
}
