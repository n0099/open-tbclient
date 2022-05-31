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
public final class zz5 {
    public static /* synthetic */ Interceptable $ic;
    public static final Bitmap a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755094692, "Lcom/repackage/zz5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755094692, "Lcom/repackage/zz5;");
                return;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(1, 1, Bitmap.Config.ARGB_8888)");
        a = createBitmap;
    }

    public static final boolean a(ry5 ry5Var, ry5 ry5Var2, r06 r06Var, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{ry5Var, ry5Var2, r06Var, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            int width = r06Var.getWidth();
            float q = ry5Var.f().q();
            float q2 = ry5Var2.f().q();
            long j3 = j - ry5Var.j();
            float f = width;
            float f2 = (float) j2;
            return f - ((q2 + f) * (((float) (j - ry5Var2.j())) / f2)) < (f - ((f + q) * (((float) j3) / f2))) + q;
        }
        return invokeCommon.booleanValue;
    }

    public static final Bitmap b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a : (Bitmap) invokeV.objValue;
    }

    public static final boolean c(ry5 ry5Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65539, null, ry5Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ry5Var, "<this>");
            return j - ry5Var.j() < 0;
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean d(ry5 ry5Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, ry5Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ry5Var, "<this>");
            return e(ry5Var, j) || c(ry5Var, j);
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean e(ry5 ry5Var, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, ry5Var, j)) == null) {
            Intrinsics.checkNotNullParameter(ry5Var, "<this>");
            return j - ry5Var.j() > ry5Var.g();
        }
        return invokeLJ.booleanValue;
    }

    public static final boolean f(ry5 ry5Var, ry5 danmaku, r06 displayer, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{ry5Var, danmaku, displayer, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            Intrinsics.checkNotNullParameter(ry5Var, "<this>");
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            if (d(ry5Var, j)) {
                return false;
            }
            long j3 = danmaku.j() - ry5Var.j();
            if (j3 <= 0) {
                return true;
            }
            if (Math.abs(j3) >= j2 || e(ry5Var, j) || e(danmaku, j)) {
                return false;
            }
            return ry5Var.e().j() == 5 || ry5Var.e().j() == 4 || a(ry5Var, danmaku, displayer, j, j2) || a(ry5Var, danmaku, displayer, j + j2, j2);
        }
        return invokeCommon.booleanValue;
    }
}
