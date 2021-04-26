package d.a.i0.r.u;

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
    public static String[] A(int i2) {
        return TbadkCoreApplication.getInst().getResources().getStringArray(i2);
    }

    public static ColorStateList B(int i2) {
        return SkinManager.createColorStateList(i2);
    }

    public static Typeface C(String str) {
        if ("bold".equals(str)) {
            return Typeface.DEFAULT_BOLD;
        }
        return Typeface.DEFAULT;
    }

    public static float[] D(float f2) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, f2);
        return fArr;
    }

    public static float a(int i2) {
        return d.a.c.e.m.b.c(z(i2), 0.0f);
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
        bVar.E(g(i2));
        return bVar;
    }

    public static Drawable f(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.F(l(i2));
        return bVar;
    }

    public static int g(int i2) {
        return SkinManager.getColor(i2);
    }

    public static Drawable h(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.B(g(i2));
        return bVar;
    }

    public static int i(String str) {
        return g(q(str, "color"));
    }

    public static Drawable j(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.P(v(z(i2).split(",")));
        return bVar;
    }

    public static Drawable k(Drawable drawable, int i2) {
        b bVar = (b) c(drawable).clone();
        bVar.G(i2);
        return bVar;
    }

    public static int l(int i2) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2);
    }

    public static int m(String str) {
        return l(q("tbds" + str, "dimen"));
    }

    public static Drawable n(Drawable drawable, int[] iArr) {
        b bVar = (b) c(drawable).clone();
        o(iArr);
        bVar.C(iArr);
        return bVar;
    }

    public static int[] o(int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = g(iArr[i2]);
        }
        return iArr;
    }

    public static int[] p(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = i(strArr[i2]);
        }
        return iArr;
    }

    public static int q(String str, String str2) {
        return TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName());
    }

    public static Drawable r(Drawable drawable, String[] strArr) {
        String[] split = strArr[0].split(",");
        String[] split2 = strArr[1].split(",");
        String str = strArr[2];
        b bVar = (b) c(drawable).clone();
        bVar.C(p(split));
        bVar.K(s(split2));
        bVar.H(str);
        return bVar;
    }

    public static float[] s(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[min];
        for (int i2 = 0; i2 < min; i2++) {
            fArr[i2] = d.a.c.e.m.b.c(strArr[i2], 0.0f);
        }
        return fArr;
    }

    public static float t(String str) {
        if (str.endsWith("H")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        return m(str);
    }

    public static float[] u(int i2) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return D(0.0f);
        }
        String[] split = app.getString(i2).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i3 = 0; i3 < min; i3++) {
            float t = t(split[i3]);
            int i4 = i3 * 2;
            fArr[i4] = t;
            fArr[i4 + 1] = t;
        }
        return fArr;
    }

    public static float[] v(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float t = t(strArr[i2]);
            int i3 = i2 * 2;
            fArr[i3] = t;
            fArr[i3 + 1] = t;
        }
        return fArr;
    }

    public static Drawable w(View view, Drawable drawable, String[] strArr) {
        String[] split = strArr[2].split(",");
        b bVar = (b) c(drawable).clone();
        bVar.L(i(strArr[0]));
        bVar.M(m(strArr[1]));
        bVar.I(m(split[0]));
        bVar.J(m(split[1]));
        return bVar.n(view);
    }

    public static float[] x(int i2) {
        String[] A = A(i2);
        String[] split = A[2].split(",");
        float[] fArr = {i(A[0]), m(A[1]), m(split[0]), m(split[1])};
        if (fArr[1] == 0.0f) {
            fArr[1] = 0.01f;
        }
        return fArr;
    }

    public static Drawable y(Drawable drawable, int i2, int i3, int i4) {
        b c2 = c(drawable);
        c2.z();
        GradientDrawable l = c2.l(i4);
        l.setColor(g(i2));
        l.setStroke((int) c2.t(), d.a.j0.d3.c.a(c2.s(), c2.r()));
        GradientDrawable l2 = c2.l(i4);
        l2.setColor(g(i3));
        l2.setStroke((int) c2.t(), d.a.j0.d3.c.a(c2.s(), SkinManager.RESOURCE_ALPHA_PRESS * c2.r()));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
        stateListDrawable.addState(new int[0], l);
        return stateListDrawable;
    }

    public static String z(int i2) {
        return TbadkCoreApplication.getInst().getResources().getString(i2);
    }
}
