package tv.chushou.zues.toolkit.d;

import android.view.View;
/* loaded from: classes6.dex */
public final class b {
    public static void setAlpha(View view, float f) {
        if (tv.chushou.zues.toolkit.d.a.NEEDS_PROXY) {
            tv.chushou.zues.toolkit.d.a.eo(view).setAlpha(f);
        } else {
            a.setAlpha(view, f);
        }
    }

    public static void setScaleX(View view, float f) {
        if (tv.chushou.zues.toolkit.d.a.NEEDS_PROXY) {
            tv.chushou.zues.toolkit.d.a.eo(view).setScaleX(f);
        } else {
            a.setScaleX(view, f);
        }
    }

    public static void setScaleY(View view, float f) {
        if (tv.chushou.zues.toolkit.d.a.NEEDS_PROXY) {
            tv.chushou.zues.toolkit.d.a.eo(view).setScaleY(f);
        } else {
            a.setScaleY(view, f);
        }
    }

    public static void setTranslationX(View view, float f) {
        if (tv.chushou.zues.toolkit.d.a.NEEDS_PROXY) {
            tv.chushou.zues.toolkit.d.a.eo(view).setTranslationX(f);
        } else {
            a.setTranslationX(view, f);
        }
    }

    public static void setTranslationY(View view, float f) {
        if (tv.chushou.zues.toolkit.d.a.NEEDS_PROXY) {
            tv.chushou.zues.toolkit.d.a.eo(view).setTranslationY(f);
        } else {
            a.setTranslationY(view, f);
        }
    }

    public static void setX(View view, float f) {
        if (tv.chushou.zues.toolkit.d.a.NEEDS_PROXY) {
            tv.chushou.zues.toolkit.d.a.eo(view).setX(f);
        } else {
            a.setX(view, f);
        }
    }

    public static void setY(View view, float f) {
        if (tv.chushou.zues.toolkit.d.a.NEEDS_PROXY) {
            tv.chushou.zues.toolkit.d.a.eo(view).setY(f);
        } else {
            a.setY(view, f);
        }
    }

    /* loaded from: classes6.dex */
    private static final class a {
        static void setAlpha(View view, float f) {
            view.setAlpha(f);
        }

        static void setScaleX(View view, float f) {
            view.setScaleX(f);
        }

        static void setScaleY(View view, float f) {
            view.setScaleY(f);
        }

        static void setTranslationX(View view, float f) {
            view.setTranslationX(f);
        }

        static void setTranslationY(View view, float f) {
            view.setTranslationY(f);
        }

        static void setX(View view, float f) {
            view.setX(f);
        }

        static void setY(View view, float f) {
            view.setY(f);
        }
    }
}
