package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double ntZ;
    public static final int nua;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.ntZ);
        public static final int nub = (int) (120.0d * b.ntZ);
        public static final int nuc = (int) (400.0d * b.ntZ);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0861b {
        public static final int small = (int) (50.0d * b.ntZ);
        public static final int nub = (int) (90.0d * b.ntZ);
        public static final int nuc = (int) (120.0d * b.ntZ);
        public static final int nud = (int) (150.0d * b.ntZ);
    }

    static {
        ntZ = 1.0d;
        if (h.dJq() != null) {
            ntZ = h.dJU().getDisplayMetrics().density / 2.0d;
        }
        nua = (int) (ntZ * 550.0d);
    }
}
