package d.a.o0.r.u;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Drawable A(Drawable drawable, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65536, null, drawable, i2, i3)) == null) {
            b c2 = c(drawable);
            c2.z();
            GradientDrawable l = c2.l(i3);
            l.setColor(h(i2));
            l.setStroke((int) c2.t(), d.a.p0.h3.c.a(c2.s(), c2.r()));
            GradientDrawable l2 = c2.l(i3);
            l2.setColor(d.a.p0.h3.c.a(h(i2), SkinManager.RESOURCE_ALPHA_PRESS));
            l2.setStroke((int) c2.t(), d.a.p0.h3.c.a(c2.s(), SkinManager.RESOURCE_ALPHA_PRESS * c2.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static Drawable B(Drawable drawable, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65537, null, drawable, i2, i3, i4)) == null) {
            b c2 = c(drawable);
            c2.z();
            GradientDrawable l = c2.l(i4);
            l.setColor(h(i2));
            l.setStroke((int) c2.t(), d.a.p0.h3.c.a(c2.s(), c2.r()));
            GradientDrawable l2 = c2.l(i4);
            l2.setColor(h(i3));
            l2.setStroke((int) c2.t(), d.a.p0.h3.c.a(c2.s(), SkinManager.RESOURCE_ALPHA_PRESS * c2.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLIII.objValue;
    }

    public static String C(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? TbadkCoreApplication.getInst().getResources().getString(i2) : (String) invokeI.objValue;
    }

    public static String[] D(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? TbadkCoreApplication.getInst().getResources().getStringArray(i2) : (String[]) invokeI.objValue;
    }

    public static ColorStateList E(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? SkinManager.createColorStateList(i2) : (ColorStateList) invokeI.objValue;
    }

    public static Typeface F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if ("bold".equals(str)) {
                return Typeface.DEFAULT_BOLD;
            }
            return Typeface.DEFAULT;
        }
        return (Typeface) invokeL.objValue;
    }

    public static float[] G(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(AdIconUtil.BAIDU_LOGO_ID, null, f2)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f2);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public static float a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) ? d.a.c.e.m.b.c(C(i2), 0.0f) : invokeI.floatValue;
    }

    public static Drawable b(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.A(a(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static b c(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, drawable)) == null) {
            if (drawable instanceof b) {
                return (b) drawable;
            }
            return b.y();
        }
        return (b) invokeL.objValue;
    }

    public static b d(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, view)) == null) {
            Drawable background = view.getBackground();
            if (background instanceof b) {
                return (b) background;
            }
            return b.y();
        }
        return (b) invokeL.objValue;
    }

    public static Drawable e(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.D(a(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable f(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.E(h(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable g(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65549, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.F(m(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65550, null, i2)) == null) ? SkinManager.getColor(i2) : invokeI.intValue;
    }

    public static Drawable i(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.B(h(i2));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? h(r(str, "color")) : invokeL.intValue;
    }

    public static Drawable k(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.P(x(C(i2).split(",")));
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable l(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.G(i2);
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int m(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65555, null, i2)) == null) ? TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i2) : invokeI.intValue;
    }

    public static int n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            return m(r("tbds" + str, "dimen"));
        }
        return invokeL.intValue;
    }

    public static Drawable o(Drawable drawable, int[] iArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, drawable, iArr)) == null) {
            b bVar = (b) c(drawable).clone();
            p(iArr);
            bVar.C(iArr);
            return bVar;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static int[] p(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, iArr)) == null) {
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = h(iArr[i2]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int[] q(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, strArr)) == null) {
            int length = strArr.length;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = j(strArr[i2]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int r(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, str, str2)) == null) ? TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName()) : invokeLL.intValue;
    }

    public static Drawable s(Drawable drawable, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65561, null, drawable, strArr)) == null) {
            String[] split = strArr[0].split(",");
            String[] split2 = strArr[1].split(",");
            String str = strArr[2];
            b bVar = (b) c(drawable).clone();
            bVar.C(q(split));
            bVar.K(t(split2));
            bVar.H(str);
            return bVar;
        }
        return (Drawable) invokeLL.objValue;
    }

    public static float[] t(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[min];
            for (int i2 = 0; i2 < min; i2++) {
                fArr[i2] = d.a.c.e.m.b.c(strArr[i2], 0.0f);
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static Drawable u(Drawable drawable, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65563, null, drawable, i2)) == null) {
            b bVar = (b) c(drawable).clone();
            bVar.B(i2);
            return bVar;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static float v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, str)) == null) {
            if (str.endsWith("H")) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            return n(str);
        }
        return invokeL.floatValue;
    }

    public static float[] w(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65565, null, i2)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return G(0.0f);
            }
            String[] split = app.getString(i2).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i3 = 0; i3 < min; i3++) {
                float v = v(split[i3]);
                int i4 = i3 * 2;
                fArr[i4] = v;
                fArr[i4 + 1] = v;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static float[] x(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float v = v(strArr[i2]);
                int i3 = i2 * 2;
                fArr[i3] = v;
                fArr[i3 + 1] = v;
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static Drawable y(View view, Drawable drawable, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65567, null, view, drawable, strArr)) == null) {
            String[] split = strArr[2].split(",");
            b bVar = (b) c(drawable).clone();
            bVar.L(j(strArr[0]));
            bVar.M(n(strArr[1]));
            bVar.I(n(split[0]));
            bVar.J(n(split[1]));
            return bVar.n(view);
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static float[] z(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65568, null, i2)) == null) {
            String[] D = D(i2);
            String[] split = D[2].split(",");
            float[] fArr = {j(D[0]), n(D[1]), n(split[0]), n(split[1])};
            if (fArr[1] == 0.0f) {
                fArr[1] = 0.01f;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }
}
