package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double oOO;
    public static final int oOP;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.oOO);
        public static final int oOQ = (int) (120.0d * b.oOO);
        public static final int oOR = (int) (400.0d * b.oOO);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1017b {
        public static final int small = (int) (50.0d * b.oOO);
        public static final int oOQ = (int) (90.0d * b.oOO);
        public static final int oOR = (int) (120.0d * b.oOO);
        public static final int oOS = (int) (150.0d * b.oOO);
    }

    static {
        oOO = 1.0d;
        if (h.elS() != null) {
            oOO = h.emv().getDisplayMetrics().density / 2.0d;
        }
        oOP = (int) (oOO * 550.0d);
    }
}
