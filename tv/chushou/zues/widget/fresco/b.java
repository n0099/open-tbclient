package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double ntW;
    public static final int ntX;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.ntW);
        public static final int ntY = (int) (120.0d * b.ntW);
        public static final int ntZ = (int) (400.0d * b.ntW);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0840b {
        public static final int small = (int) (50.0d * b.ntW);
        public static final int ntY = (int) (90.0d * b.ntW);
        public static final int ntZ = (int) (120.0d * b.ntW);
        public static final int nua = (int) (150.0d * b.ntW);
    }

    static {
        ntW = 1.0d;
        if (h.dJt() != null) {
            ntW = h.dJX().getDisplayMetrics().density / 2.0d;
        }
        ntX = (int) (ntW * 550.0d);
    }
}
