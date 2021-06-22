package d.a.n0.r.u;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class a {
    public static Drawable A(Drawable drawable, int i2, int i3, int i4) {
        b c2 = c(drawable);
        c2.z();
        GradientDrawable l = c2.l(i4);
        l.setColor(h(i2));
        l.setStroke((int) c2.t(), d.a.o0.e3.c.a(c2.s(), c2.r()));
        GradientDrawable l2 = c2.l(i4);
        l2.setColor(h(i3));
        l2.setStroke((int) c2.t(), d.a.o0.e3.c.a(c2.s(), SkinManager.RESOURCE_ALPHA_PRESS * c2.r()));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
        stateListDrawable.addState(new int[0], l);
        return stateListDrawable;
    }

    public static String B(int i2) {
        return TbadkCoreApplication.getInst().getResources().getString(i2);
    }

    public static String[] C(int i2) {
        return TbadkCoreApplication.getInst().getResources().getStringArray(i2);
    }

    public static ColorStateList D(int i2) {
        return SkinManager.createColorStateList(i2);
    }

    public static Typeface E(String str) {
        if ("bold".equals(str)) {
            return Typeface.DEFAULT_BOLD;
        }
        return Typeface.DEFAULT;
    }

    public static float[] F(float f2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f2);
        return fArr;
    }

    public static float a(int i2) {
        return d.a.c.e.m.b.c(B(i2), 0.0f);
    }

    public static Drawable b(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.A(a(i2));
        return bVar;
    }

    public static b c(Drawable drawable) {
        if (drawable instanceof b) {
            return (b) drawable;
        }
        return b.y();
    }

    public static b d(View view) {
        Drawable background = view.getBackground();
        if (background instanceof b) {
            return (b) background;
        }
        return b.y();
    }

    public static Drawable e(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.D(a(i2));
        return bVar;
    }

    public static Drawable f(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.E(h(i2));
        return bVar;
    }

    public static Drawable g(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.F(m(i2));
        return bVar;
    }

    public static int h(int i2) {
        return SkinManager.getColor(i2);
    }

    public static Drawable i(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.B(h(i2));
        return bVar;
    }

    public static int j(String str) {
        return h(r(str, "color"));
    }

    public static Drawable k(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.P(w(B(i2).split(",")));
        return bVar;
    }

    public static Drawable l(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.G(i2);
        return bVar;
    }

    public static int m(int i2) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
    }

    public static int n(String str) {
        return m(r("tbds" + str, "dimen"));
    }

    public static Drawable o(Drawable drawable, int[] iArr) {
        b bVar = (b) c(drawable).clone();
        p(iArr);
        bVar.C(iArr);
        return bVar;
    }

    public static int[] p(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = h(iArr[i2]);
        }
        return iArr;
    }

    public static int[] q(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = j(strArr[i2]);
        }
        return iArr;
    }

    public static int r(String str, String str2) {
        return TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName());
    }

    public static Drawable s(Drawable drawable, String[] strArr) {
        String[] split = strArr[0].split(",");
        String[] split2 = strArr[1].split(",");
        String str = strArr[2];
        b bVar = (b) c(drawable).clone();
        bVar.C(q(split));
        bVar.K(t(split2));
        bVar.H(str);
        return bVar;
    }

    public static float[] t(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[min];
        for (int i2 = 0; i2 < min; i2++) {
            fArr[i2] = d.a.c.e.m.b.c(strArr[i2], 0.0f);
        }
        return fArr;
    }

    public static float u(String str) {
        if (str.endsWith("H")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        return n(str);
    }

    public static float[] v(int i2) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return F(0.0f);
        }
        String[] split = app.getString(i2).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i3 = 0; i3 < min; i3++) {
            float u = u(split[i3]);
            int i4 = i3 * 2;
            fArr[i4] = u;
            fArr[i4 + 1] = u;
        }
        return fArr;
    }

    public static float[] w(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float u = u(strArr[i2]);
            int i3 = i2 * 2;
            fArr[i3] = u;
            fArr[i3 + 1] = u;
        }
        return fArr;
    }

    public static Drawable x(View view, Drawable drawable, String[] strArr) {
        String[] split = strArr[2].split(",");
        b bVar = (b) c(drawable).clone();
        bVar.L(j(strArr[0]));
        bVar.M(n(strArr[1]));
        bVar.I(n(split[0]));
        bVar.J(n(split[1]));
        return bVar.n(view);
    }

    public static float[] y(int i2) {
        String[] C = C(i2);
        String[] split = C[2].split(",");
        float[] fArr = {j(C[0]), n(C[1]), n(split[0]), n(split[1])};
        if (fArr[1] == 0.0f) {
            fArr[1] = 0.01f;
        }
        return fArr;
    }

    public static Drawable z(Drawable drawable, int i2, int i3) {
        b c2 = c(drawable);
        c2.z();
        GradientDrawable l = c2.l(i3);
        l.setColor(h(i2));
        l.setStroke((int) c2.t(), d.a.o0.e3.c.a(c2.s(), c2.r()));
        GradientDrawable l2 = c2.l(i3);
        l2.setColor(d.a.o0.e3.c.a(h(i2), SkinManager.RESOURCE_ALPHA_PRESS));
        l2.setStroke((int) c2.t(), d.a.o0.e3.c.a(c2.s(), SkinManager.RESOURCE_ALPHA_PRESS * c2.r()));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
        stateListDrawable.addState(new int[0], l);
        return stateListDrawable;
    }
}
