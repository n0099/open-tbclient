package com.repackage;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class o16 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755492515, "Lcom/repackage/o16;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755492515, "Lcom/repackage/o16;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final boolean a(g06 g06Var, g06 g06Var2, g26 g26Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{g06Var, g06Var2, g26Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = g26Var.getWidth();
            float q = g06Var.f().q();
            float q2 = g06Var2.f().q();
            long j3 = j - g06Var.j();
            float f = width;
            float f2 = (float) j2;
            return f - ((q2 + f) * (((float) (j - g06Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q;
        }
        return invokeCommon.booleanValue;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Bitmap) invokeV.objValue;
    }

    public static final boolean c(g06 g06Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, g06Var, j)) == null) {
            Intrinsics.checkNotNullParameter(g06Var, "<this>");
            return j - g06Var.j() < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(g06 g06Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, g06Var, j)) == null) {
            Intrinsics.checkNotNullParameter(g06Var, "<this>");
            return e(g06Var, j) || c(g06Var, j);
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(g06 g06Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, g06Var, j)) == null) {
            Intrinsics.checkNotNullParameter(g06Var, "<this>");
            return j - g06Var.j() > g06Var.g();
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(g06 g06Var, g06 danmaku, g26 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{g06Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(g06Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(g06Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - g06Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(g06Var, j) || e(danmaku, j)) {
                return false;
            }
            return g06Var.e().j() == 5 || g06Var.e().j() == 4 || a(g06Var, danmaku, displayer, j, j2) || a(g06Var, danmaku, displayer, j + j2, j2);
        }
        return invokeCommon.booleanValue;
    }
}
