package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double oac;
    public static final int oad;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.oac);
        public static final int medium = (int) (120.0d * b.oac);
        public static final int oae = (int) (400.0d * b.oac);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0817b {
        public static final int small = (int) (50.0d * b.oac);
        public static final int medium = (int) (90.0d * b.oac);
        public static final int oae = (int) (120.0d * b.oac);
        public static final int oaf = (int) (150.0d * b.oac);
    }

    static {
        oac = 1.0d;
        if (h.dQu() != null) {
            oac = h.dQV().getDisplayMetrics().density / 2.0d;
        }
        oad = (int) (oac * 550.0d);
    }
}
