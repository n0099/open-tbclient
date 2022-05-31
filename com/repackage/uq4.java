package com.repackage;

import android.app.Application;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class uq4 {
    public static /* synthetic */ Interceptable $ic;
    public static final HashMap<String, HashMap<String, Integer>> a;
    public static final SparseArray<String> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755252327, "Lcom/repackage/uq4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755252327, "Lcom/repackage/uq4;");
                return;
            }
        }
        a = new HashMap<>();
        b = new SparseArray<>();
    }

    public static Drawable A(View view2, Drawable drawable, String[] strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, view2, drawable, strArr)) == null) {
            if (strArr != null && strArr.length == 3) {
                String[] split = strArr[2].split(",");
                if (split.length == 2) {
                    vq4 vq4Var = (vq4) c(drawable).clone();
                    vq4Var.L(j(strArr[0]));
                    vq4Var.M(n(strArr[1]));
                    vq4Var.I(n(split[0]));
                    vq4Var.J(n(split[1]));
                    return vq4Var.n(view2);
                }
                throw new IndexOutOfBoundsException("Please check the number of xy resource!");
            }
            throw new IndexOutOfBoundsException("Please check the number of shadow resource!");
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static float[] B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            String[] F = F(i);
            float[] fArr = new float[4];
            if (F != null && F.length == 3) {
                String[] split = F[2].split(",");
                if (split.length == 2) {
                    fArr[0] = j(F[0]);
                    fArr[1] = n(F[1]);
                    fArr[2] = n(split[0]);
                    fArr[3] = n(split[1]);
                    if (fArr[1] == 0.0f) {
                        fArr[1] = 0.01f;
                    }
                    return fArr;
                }
                throw new IndexOutOfBoundsException("Please check the number of xy resource!");
            }
            throw new IndexOutOfBoundsException("Please check the number of shadow resource!");
        }
        return (float[]) invokeI.objValue;
    }

    public static Drawable C(Drawable drawable, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, drawable, i, i2)) == null) {
            vq4 c = c(drawable);
            c.z();
            GradientDrawable l = c.l(i2);
            l.setColor(h(i));
            l.setStroke((int) c.t(), ef8.a(c.s(), c.r()));
            GradientDrawable l2 = c.l(i2);
            l2.setColor(ef8.a(h(i), SkinManager.RESOURCE_ALPHA_PRESS));
            l2.setStroke((int) c.t(), ef8.a(c.s(), SkinManager.RESOURCE_ALPHA_PRESS * c.r()));
            GradientDrawable l3 = c.l(i2);
            l3.setColor(ef8.a(h(i), SkinManager.RESOURCE_ALPHA_DISABLE));
            l3.setStroke((int) c.t(), ef8.a(c.s(), SkinManager.RESOURCE_ALPHA_DISABLE * c.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[]{-16842910}, l3);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLII.objValue;
    }

    public static Drawable D(Drawable drawable, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, drawable, i, i2, i3)) == null) {
            vq4 c = c(drawable);
            c.z();
            GradientDrawable l = c.l(i3);
            l.setColor(h(i));
            l.setStroke((int) c.t(), ef8.a(c.s(), c.r()));
            GradientDrawable l2 = c.l(i3);
            l2.setColor(h(i2));
            l2.setStroke((int) c.t(), ef8.a(c.s(), SkinManager.RESOURCE_ALPHA_PRESS * c.r()));
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842910, 16842919}, l2);
            stateListDrawable.addState(new int[]{16842910, 16842908}, l2);
            stateListDrawable.addState(new int[0], l);
            return stateListDrawable;
        }
        return (Drawable) invokeLIII.objValue;
    }

    public static String E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            int idByABTest = EMABTest.getIdByABTest(i, EMABTest.TYPE_STRING);
            return idByABTest == 0 ? "" : TbadkCoreApplication.getInst().getResources().getString(idByABTest);
        }
        return (String) invokeI.objValue;
    }

    public static String[] F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) ? TbadkCoreApplication.getInst().getResources().getStringArray(EMABTest.getIdByABTest(i, "array")) : (String[]) invokeI.objValue;
    }

    public static ColorStateList G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) ? SkinManager.createColorStateList(i) : (ColorStateList) invokeI.objValue;
    }

    public static Typeface H(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if ("bold".equals(str)) {
                return Typeface.DEFAULT_BOLD;
            }
            return Typeface.DEFAULT;
        }
        return (Typeface) invokeL.objValue;
    }

    public static float[] I(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65545, null, f)) == null) {
            float[] fArr = new float[8];
            Arrays.fill(fArr, f);
            return fArr;
        }
        return (float[]) invokeF.objValue;
    }

    public static float a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) ? jg.d(E(i), 0.0f) : invokeI.floatValue;
    }

    public static Drawable b(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.A(a(i));
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static vq4 c(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, drawable)) == null) {
            if (drawable instanceof vq4) {
                return (vq4) drawable;
            }
            return vq4.y();
        }
        return (vq4) invokeL.objValue;
    }

    public static vq4 d(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, view2)) == null) {
            Drawable background = view2.getBackground();
            if (background instanceof vq4) {
                return (vq4) background;
            }
            return vq4.y();
        }
        return (vq4) invokeL.objValue;
    }

    public static Drawable e(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.D(a(i));
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable f(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.E(h(i));
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable g(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.F(m(i));
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) ? SkinManager.getColor(i) : invokeI.intValue;
    }

    public static Drawable i(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.B(h(i));
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, str)) == null) ? h(s(str, "color")) : invokeL.intValue;
    }

    public static Drawable k(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65556, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.P(z(E(i).split(",")));
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable l(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65557, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.G(i);
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static int m(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65558, null, i)) == null) ? UtilHelper.getDimenPixelSize(i) : invokeI.intValue;
    }

    public static int n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, str)) == null) {
            return m(s("tbds" + str, EMABTest.TYPE_DIMEN));
        }
        return invokeL.intValue;
    }

    public static String o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65560, null, i)) == null) {
            try {
                String str = b.get(i);
                if (str == null) {
                    str = i == 0 ? "" : TbadkCoreApplication.getInst().getResources().getResourceEntryName(i);
                    b.put(i, str);
                }
                return str;
            } catch (ArrayIndexOutOfBoundsException e) {
                p79.g(e);
                return "";
            }
        }
        return (String) invokeI.objValue;
    }

    public static Drawable p(Drawable drawable, Direction direction, int[] iArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65561, null, drawable, direction, iArr)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            q(iArr);
            vq4Var.C(iArr);
            vq4Var.H(direction);
            return vq4Var;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static int[] q(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, iArr)) == null) {
            int length = iArr.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = h(iArr[i]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int[] r(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, strArr)) == null) {
            int length = strArr.length;
            int[] iArr = new int[length];
            for (int i = 0; i < length; i++) {
                iArr[i] = j(strArr[i]);
            }
            return iArr;
        }
        return (int[]) invokeL.objValue;
    }

    public static int s(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, str, str2)) == null) {
            HashMap<String, Integer> hashMap = a.get(str2);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                a.put(str2, hashMap);
            }
            Integer num = hashMap.get(str);
            if (num == null) {
                num = Integer.valueOf(TbadkCoreApplication.getInst().getResources().getIdentifier(str, str2, TbadkCoreApplication.getInst().getPackageName()));
                hashMap.put(str, num);
            }
            return num.intValue();
        }
        return invokeLL.intValue;
    }

    public static Drawable t(Drawable drawable, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65565, null, drawable, strArr)) == null) {
            if (strArr != null && strArr.length == 3) {
                String[] split = strArr[0].split(",");
                String[] split2 = strArr[1].split(",");
                String str = strArr[2];
                vq4 vq4Var = (vq4) c(drawable).clone();
                if (!TextUtils.isEmpty(str)) {
                    vq4Var.H(Direction.valueOf(str.toUpperCase()));
                }
                vq4Var.C(r(split));
                vq4Var.K(u(split2));
                return vq4Var;
            }
            throw new IndexOutOfBoundsException("Please check the number of mask resource!");
        }
        return (Drawable) invokeLL.objValue;
    }

    public static float[] u(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[min];
            for (int i = 0; i < min; i++) {
                fArr[i] = jg.d(strArr[i], 0.0f);
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }

    public static Drawable v(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65567, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.E(i);
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static Drawable w(Drawable drawable, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65568, null, drawable, i)) == null) {
            vq4 vq4Var = (vq4) c(drawable).clone();
            vq4Var.B(i);
            return vq4Var;
        }
        return (Drawable) invokeLI.objValue;
    }

    public static float x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, str)) == null) {
            if (str.endsWith("H")) {
                return Float.parseFloat(str.substring(0, str.length() - 1));
            }
            return n(str);
        }
        return invokeL.floatValue;
    }

    public static float[] y(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65570, null, i)) == null) {
            Application app = BdBaseApplication.getInst().getApp();
            if (app == null) {
                return I(0.0f);
            }
            String[] split = app.getString(i).split(",");
            int min = Math.min(split.length, 4);
            float[] fArr = new float[8];
            for (int i2 = 0; i2 < min; i2++) {
                float x = x(split[i2]);
                int i3 = i2 * 2;
                fArr[i3] = x;
                fArr[i3 + 1] = x;
            }
            return fArr;
        }
        return (float[]) invokeI.objValue;
    }

    public static float[] z(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, strArr)) == null) {
            int min = Math.min(strArr.length, 4);
            float[] fArr = new float[8];
            for (int i = 0; i < min; i++) {
                float x = x(strArr[i]);
                int i2 = i * 2;
                fArr[i2] = x;
                fArr[i2 + 1] = x;
            }
            return fArr;
        }
        return (float[]) invokeL.objValue;
    }
}
