package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double qot;
    public static final int qou;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.qot);
        public static final int qov = (int) (120.0d * b.qot);
        public static final int qow = (int) (400.0d * b.qot);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1124b {
        public static final int small = (int) (50.0d * b.qot);
        public static final int qov = (int) (90.0d * b.qot);
        public static final int qow = (int) (120.0d * b.qot);
        public static final int qox = (int) (150.0d * b.qot);
    }

    static {
        qot = 1.0d;
        if (h.eHo() != null) {
            qot = h.eHR().getDisplayMetrics().density / 2.0d;
        }
        qou = (int) (qot * 550.0d);
    }
}
