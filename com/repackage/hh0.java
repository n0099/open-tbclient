package com.repackage;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.mo0;
/* loaded from: classes6.dex */
public class hh0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(mo0 mo0Var) {
        InterceptResult invokeL;
        mo0.b bVar;
        mo0.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, mo0Var)) == null) {
            if (mo0Var == null) {
                return false;
            }
            return (TextUtils.isEmpty(mo0Var.f) && TextUtils.isEmpty(mo0Var.d) && ((bVar = mo0Var.g) == null || TextUtils.isEmpty(bVar.a)) && ((aVar = mo0Var.h) == null || TextUtils.isEmpty(aVar.a))) ? false : true;
        }
        return invokeL.booleanValue;
    }

    public static String b(String str, String str2, float f, TextPaint textPaint, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{str, str2, Float.valueOf(f), textPaint, Float.valueOf(f2)})) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f - (textPaint.measureText(GlideException.IndentedAppendable.INDENT) + f2), TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public static int c(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i != i2 && f > 0.0f) {
                if (f >= 1.0f) {
                    return i2;
                }
                int red = Color.red(i);
                int blue = Color.blue(i);
                int green = Color.green(i);
                int alpha = Color.alpha(i);
                return Color.argb((int) (alpha + (f * (Color.alpha(i2) - alpha))), (int) (red + ((Color.red(i2) - red) * f)), (int) (green + ((Color.green(i2) - green) * f)), (int) (blue + ((Color.blue(i2) - blue) * f)));
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public static String d(@FloatRange(from = 0.0d, to = 1.0d) float f, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Float.valueOf(f), str})) == null) {
            String hexString = Integer.toHexString(Math.round(f * 255.0f));
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            if (hexString.length() != 2) {
                return "";
            }
            return "#" + hexString + str;
        }
        return (String) invokeCommon.objValue;
    }

    public static int e(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i)) == null) {
            if (TextUtils.isEmpty(str)) {
                return ContextCompat.getColor(ki0.b(), i);
            }
            try {
                return Color.parseColor(str);
            } catch (IllegalArgumentException unused) {
                return ContextCompat.getColor(ki0.b(), i);
            }
        }
        return invokeLI.intValue;
    }

    public static void f(View view2) {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, view2) == null) || view2 == null || (viewGroup = (ViewGroup) view2.getParent()) == null) {
            return;
        }
        viewGroup.removeView(view2);
    }
}
