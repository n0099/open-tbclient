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
/* loaded from: classes6.dex */
public class nb8 {
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

    public static rj0 d(@NonNull AdCard adCard) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, adCard)) == null) {
            if (hj0.a().query(adCard.getDownloadKey()) != null) {
                return hj0.a().query(adCard.getDownloadKey());
            }
            rj0 rj0Var = new rj0();
            rj0Var.g(adCard.getDownloadKey());
            if (adCard.downloadInfo != null) {
                if (TextUtils.isEmpty(rj0Var.d())) {
                    rj0Var.g(adCard.downloadInfo.b);
                }
                gb8 gb8Var = adCard.downloadInfo;
                rj0Var.g = gb8Var.b;
                rj0Var.d = gb8Var.a;
            }
            if (TextUtils.isEmpty(rj0Var.d())) {
                rj0Var.g(adCard.adId);
            }
            uj0 uj0Var = new uj0();
            uj0Var.j = adCard.adId;
            uj0Var.a = adCard.getExtInfo();
            bo4 bo4Var = adCard.appInfoModel;
            if (bo4Var != null) {
                uj0Var.g = bo4Var.b;
                uj0Var.h = bo4Var.c;
            }
            if (hi0.n(adCard.cmdScheme)) {
                uj0Var.c = adCard.cmdScheme;
            }
            rj0Var.p = uj0Var;
            sj0 sj0Var = new sj0();
            sj0Var.a = adCard.getAdvertAppInfo().j;
            sj0Var.q = kh5.a().b();
            sj0Var.p = kh5.a().h();
            rj0Var.q = sj0Var;
            return rj0Var;
        }
        return (rj0) invokeL.objValue;
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
        return (interceptable == null || (invokeIIII = interceptable.invokeIIII(65541, null, i, i2, i3, i4)) == null) ? es4.D(es4.k(fs4.y(), i), i2, i3, i4) : (Drawable) invokeIIII.objValue;
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
