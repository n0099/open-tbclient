package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes5.dex */
public class b {
    private static double olX;
    public static final int olY;

    /* loaded from: classes5.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.olX);
        public static final int olZ = (int) (120.0d * b.olX);
        public static final int oma = (int) (400.0d * b.olX);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0944b {
        public static final int small = (int) (50.0d * b.olX);
        public static final int olZ = (int) (90.0d * b.olX);
        public static final int oma = (int) (120.0d * b.olX);
        public static final int omb = (int) (150.0d * b.olX);
    }

    static {
        olX = 1.0d;
        if (h.dWi() != null) {
            olX = h.dWM().getDisplayMetrics().density / 2.0d;
        }
        olY = (int) (olX * 550.0d);
    }
}
