package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes6.dex */
public class b {
    private static double qeY;
    public static final int qeZ;

    /* loaded from: classes6.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.qeY);
        public static final int qfa = (int) (120.0d * b.qeY);
        public static final int qfb = (int) (400.0d * b.qeY);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1104b {
        public static final int small = (int) (50.0d * b.qeY);
        public static final int qfa = (int) (90.0d * b.qeY);
        public static final int qfb = (int) (120.0d * b.qeY);
        public static final int qfc = (int) (150.0d * b.qeY);
    }

    static {
        qeY = 1.0d;
        if (h.eDz() != null) {
            qeY = h.eEc().getDisplayMetrics().density / 2.0d;
        }
        qeZ = (int) (qeY * 550.0d);
    }
}
