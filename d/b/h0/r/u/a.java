package d.b.h0.r.u;

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
    public static String[] A(int i) {
        return TbadkCoreApplication.getInst().getResources().getStringArray(i);
    }

    public static ColorStateList B(int i) {
        return SkinManager.createColorStateList(i);
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

    public static float a(int i) {
        return d.b.c.e.m.b.c(z(i), 0.0f);
    }

    public static Drawable b(Drawable drawable, int i) {
        b bVar = (b) c(drawable).clone();
        bVar.A(a(i));
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

    public static Drawable e(Drawable drawable, int i) {
        b bVar = (b) c(drawable).clone();
        bVar.E(g(i));
        return bVar;
    }

    public static Drawable f(Drawable drawable, int i) {
        b bVar = (b) c(drawable).clone();
        bVar.F(l(i));
        return bVar;
    }

    public static int g(int i) {
        return SkinManager.getColor(i);
    }

    public static Drawable h(Drawable drawable, int i) {
        b bVar = (b) c(drawable).clone();
        bVar.B(g(i));
        return bVar;
    }

    public static int i(String str) {
        return g(q(str, "color"));
    }

    public static Drawable j(Drawable drawable, int i) {
        b bVar = (b) c(drawable).clone();
        bVar.P(v(z(i).split(",")));
        return bVar;
    }

    public static Drawable k(Drawable drawable, int i) {
        b bVar = (b) c(drawable).clone();
        bVar.G(i);
        return bVar;
    }

    public static int l(int i) {
        return TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
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
        for (int i = 0; i < length; i++) {
            iArr[i] = g(iArr[i]);
        }
        return iArr;
    }

    public static int[] p(String[] strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = i(strArr[i]);
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
        for (int i = 0; i < min; i++) {
            fArr[i] = d.b.c.e.m.b.c(strArr[i], 0.0f);
        }
        return fArr;
    }

    public static float t(String str) {
        if (str.endsWith("H")) {
            return Float.parseFloat(str.substring(0, str.length() - 1));
        }
        return m(str);
    }

    public static float[] u(int i) {
        Application app = BdBaseApplication.getInst().getApp();
        if (app == null) {
            return D(0.0f);
        }
        String[] split = app.getString(i).split(",");
        int min = Math.min(split.length, 4);
        float[] fArr = new float[8];
        for (int i2 = 0; i2 < min; i2++) {
            float t = t(split[i2]);
            int i3 = i2 * 2;
            fArr[i3] = t;
            fArr[i3 + 1] = t;
        }
        return fArr;
    }

    public static float[] v(String[] strArr) {
        int min = Math.min(strArr.length, 4);
        float[] fArr = new float[8];
        for (int i = 0; i < min; i++) {
            float t = t(strArr[i]);
            int i2 = i * 2;
            fArr[i2] = t;
            fArr[i2 + 1] = t;
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

    public static float[] x(int i) {
        String[] A = A(i);
        String[] split = A[2].split(",");
        float[] fArr = {i(A[0]), m(A[1]), m(split[0]), m(split[1])};
        if (fArr[1] == 0.0f) {
            fArr[1] = 0.01f;
        }
        return fArr;
    }

    public static Drawable y(Drawable drawable, int i, int i2, int i3) {
        b c2 = c(drawable);
        c2.z();
        GradientDrawable l = c2.l(i3);
        l.setColor(g(i));
        l.setStroke((int) c2.t(), d.b.i0.d3.c.a(c2.s(), c2.r()));
        GradientDrawable l2 = c2.l(i3);
        l2.setColor(g(i2));
        l2.setStroke((int) c2.t(), d.b.i0.d3.c.a(c2.s(), SkinManager.RESOURCE_ALPHA_PRESS * c2.r()));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
        stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
        stateListDrawable.addState(new int[0], l);
        return stateListDrawable;
    }

    public static String z(int i) {
        return TbadkCoreApplication.getInst().getResources().getString(i);
    }
}
