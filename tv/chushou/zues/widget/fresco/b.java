package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double oOw;
    public static final int oOx;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.oOw);
        public static final int oOy = (int) (120.0d * b.oOw);
        public static final int oOz = (int) (400.0d * b.oOw);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1017b {
        public static final int small = (int) (50.0d * b.oOw);
        public static final int oOy = (int) (90.0d * b.oOw);
        public static final int oOz = (int) (120.0d * b.oOw);
        public static final int oOA = (int) (150.0d * b.oOw);
    }

    static {
        oOw = 1.0d;
        if (h.elJ() != null) {
            oOw = h.emm().getDisplayMetrics().density / 2.0d;
        }
        oOx = (int) (oOw * 550.0d);
    }
}
