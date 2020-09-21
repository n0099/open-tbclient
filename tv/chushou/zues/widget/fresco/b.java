package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double oYq;
    public static final int oYr;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.oYq);
        public static final int oYs = (int) (120.0d * b.oYq);
        public static final int oYt = (int) (400.0d * b.oYq);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1014b {
        public static final int small = (int) (50.0d * b.oYq);
        public static final int oYs = (int) (90.0d * b.oYq);
        public static final int oYt = (int) (120.0d * b.oYq);
        public static final int oYu = (int) (150.0d * b.oYq);
    }

    static {
        oYq = 1.0d;
        if (h.epQ() != null) {
            oYq = h.eqt().getDisplayMetrics().density / 2.0d;
        }
        oYr = (int) (oYq * 550.0d);
    }
}
