package com.repackage;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
/* loaded from: classes7.dex */
public class u88 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) ? (int) ((i * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) ? (int) ((i * 16.0d) / 9.0d) : invokeI.intValue;
    }

    public static int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? (int) ((i * 9.0d) / 16.0d) : invokeI.intValue;
    }

    public static ei0 d(@NonNull AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adCard)) == null) {
            if (uh0.a().query(adCard.getDownloadKey()) != null) {
                return uh0.a().query(adCard.getDownloadKey());
            }
            ei0 ei0Var = new ei0();
            ei0Var.g(adCard.getDownloadKey());
            if (adCard.downloadInfo != null) {
                if (TextUtils.isEmpty(ei0Var.d())) {
                    ei0Var.g(adCard.downloadInfo.b);
                }
                n88 n88Var = adCard.downloadInfo;
                ei0Var.g = n88Var.b;
                ei0Var.d = n88Var.a;
            }
            if (TextUtils.isEmpty(ei0Var.d())) {
                ei0Var.g(adCard.adId);
            }
            hi0 hi0Var = new hi0();
            hi0Var.j = adCard.adId;
            hi0Var.a = adCard.getExtInfo();
            qm4 qm4Var = adCard.appInfoModel;
            if (qm4Var != null) {
                hi0Var.g = qm4Var.b;
                hi0Var.h = qm4Var.c;
            }
            if (ug0.n(adCard.cmdScheme)) {
                hi0Var.c = adCard.cmdScheme;
            }
            ei0Var.p = hi0Var;
            fi0 fi0Var = new fi0();
            fi0Var.a = adCard.getAdvertAppInfo().j;
            fi0Var.q = dg5.a().b();
            fi0Var.p = dg5.a().h();
            ei0Var.q = fi0Var;
            return ei0Var;
        }
        return (ei0) invokeL.objValue;
    }

    public static String e(String str, String str2, float f, TextPaint textPaint) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Float.valueOf(f), textPaint})) == null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            CharSequence ellipsize = TextUtils.ellipsize(str, textPaint, f - textPaint.measureText(GlideException.IndentedAppendable.INDENT + str2), TextUtils.TruncateAt.END);
            if (ellipsize != null) {
                return ellipsize.toString() + GlideException.IndentedAppendable.INDENT + str2;
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public static Drawable f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65541, null, i, i2, i3, i4)) == null) ? uq4.D(uq4.k(vq4.y(), i), i2, i3, i4) : (Drawable) invokeIIII.objValue;
    }

    public static int g(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (i != i2 && f > 0.0f) {
                if (f >= 1.0f) {
                    return i2;
                }
                int red = Color.red(i);
                int green = Color.green(i);
                int blue = Color.blue(i);
                int alpha = Color.alpha(i);
                return Color.argb((int) (alpha + (f * (Color.alpha(i2) - alpha))), (int) (red + ((Color.red(i2) - red) * f)), (int) (green + ((Color.green(i2) - green) * f)), (int) (blue + ((Color.blue(i2) - blue) * f)));
            }
            return i;
        }
        return invokeCommon.intValue;
    }

    public static int h(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, str, i)) == null) {
            try {
                return Color.parseColor(str);
            } catch (Exception e) {
                e.printStackTrace();
                return i;
            }
        }
        return invokeLI.intValue;
    }
}
