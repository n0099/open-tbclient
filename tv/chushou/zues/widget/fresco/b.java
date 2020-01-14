package tv.chushou.zues.widget.fresco;

import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class b {
    private static double nXo;
    public static final int nXp;

    /* loaded from: classes4.dex */
    public static final class a {
        public static final int small = (int) (90.0d * b.nXo);
        public static final int medium = (int) (120.0d * b.nXo);
        public static final int nXq = (int) (400.0d * b.nXo);
    }

    /* renamed from: tv.chushou.zues.widget.fresco.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0808b {
        public static final int small = (int) (50.0d * b.nXo);
        public static final int medium = (int) (90.0d * b.nXo);
        public static final int nXq = (int) (120.0d * b.nXo);
        public static final int nXr = (int) (150.0d * b.nXo);
    }

    static {
        nXo = 1.0d;
        if (h.dOE() != null) {
            nXo = h.dPf().getDisplayMetrics().density / 2.0d;
        }
        nXp = (int) (nXo * 550.0d);
    }
}
