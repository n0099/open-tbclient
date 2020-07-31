package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double ouD;
    public static final int ouE;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.ouD);
        public static final int ouF = (int) (120.0d * b.ouD);
        public static final int ouG = (int) (400.0d * b.ouD);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0959b {
        public static final int small = (int) (50.0d * b.ouD);
        public static final int ouF = (int) (90.0d * b.ouD);
        public static final int ouG = (int) (120.0d * b.ouD);
        public static final int ouH = (int) (150.0d * b.ouD);
    }

    static {
        ouD = 1.0d;
        if (h.dZE() != null) {
            ouD = h.eai().getDisplayMetrics().density / 2.0d;
        }
        ouE = (int) (ouD * 550.0d);
    }
}
