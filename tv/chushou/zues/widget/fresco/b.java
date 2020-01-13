package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class b {
    private static double nXj;
    public static final int nXk;

    /* loaded from: classes4.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.nXj);
        public static final int medium = (int) (120.0d * b.nXj);
        public static final int nXl = (int) (400.0d * b.nXj);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0808b {
        public static final int small = (int) (50.0d * b.nXj);
        public static final int medium = (int) (90.0d * b.nXj);
        public static final int nXl = (int) (120.0d * b.nXj);
        public static final int nXm = (int) (150.0d * b.nXj);
    }

    static {
        nXj = 1.0d;
        if (h.dOC() != null) {
            nXj = h.dPd().getDisplayMetrics().density / 2.0d;
        }
        nXk = (int) (nXj * 550.0d);
    }
}
