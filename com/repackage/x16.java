package com.repackage;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class x16 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755224396, "Lcom/repackage/x16;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755224396, "Lcom/repackage/x16;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final boolean a(p06 p06Var, p06 p06Var2, p26 p26Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{p06Var, p06Var2, p26Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = p26Var.getWidth();
            float q = p06Var.f().q();
            float q2 = p06Var2.f().q();
            long j3 = j - p06Var.j();
            float f = width;
            float f2 = (float) j2;
            return f - ((q2 + f) * (((float) (j - p06Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q;
        }
        return invokeCommon.booleanValue;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Bitmap) invokeV.objValue;
    }

    public static final boolean c(p06 p06Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, p06Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p06Var, "<this>");
            return j - p06Var.j() < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(p06 p06Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, p06Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p06Var, "<this>");
            return e(p06Var, j) || c(p06Var, j);
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(p06 p06Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, p06Var, j)) == null) {
            Intrinsics.checkNotNullParameter(p06Var, "<this>");
            return j - p06Var.j() > p06Var.g();
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(p06 p06Var, p06 danmaku, p26 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{p06Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(p06Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(p06Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - p06Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(p06Var, j) || e(danmaku, j)) {
                return false;
            }
            return p06Var.e().j() == 5 || p06Var.e().j() == 4 || a(p06Var, danmaku, displayer, j, j2) || a(p06Var, danmaku, displayer, j + j2, j2);
        }
        return invokeCommon.booleanValue;
    }
}
