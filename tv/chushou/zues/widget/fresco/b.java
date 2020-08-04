package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double ouF;
    public static final int ouG;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.ouF);
        public static final int ouH = (int) (120.0d * b.ouF);
        public static final int ouI = (int) (400.0d * b.ouF);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0959b {
        public static final int small = (int) (50.0d * b.ouF);
        public static final int ouH = (int) (90.0d * b.ouF);
        public static final int ouI = (int) (120.0d * b.ouF);
        public static final int ouJ = (int) (150.0d * b.ouF);
    }

    static {
        ouF = 1.0d;
        if (h.dZF() != null) {
            ouF = h.eaj().getDisplayMetrics().density / 2.0d;
        }
        ouG = (int) (ouF * 550.0d);
    }
}
