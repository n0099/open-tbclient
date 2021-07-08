package com.googlecode.mp4parser.h264;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ShortBuffer;
/* loaded from: classes6.dex */
public class Debug {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean debug = false;
    public transient /* synthetic */ FieldHolder $fh;

    public Debug() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void print(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i2) == null) {
        }
    }

    public static void print(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
        }
    }

    public static void print(short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, sArr) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    System.out.printf("%3d, ", Short.valueOf(sArr[i2]));
                    i2++;
                }
                System.out.println();
            }
        }
    }

    public static final void print8x8(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, iArr) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    System.out.printf("%3d, ", Integer.valueOf(iArr[i2]));
                    i2++;
                }
                System.out.println();
            }
        }
    }

    public static void println(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
        }
    }

    public static void trace(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, objArr) == null) {
        }
    }

    public static final void print8x8(short[] sArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, sArr) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    System.out.printf("%3d, ", Short.valueOf(sArr[i2]));
                    i2++;
                }
                System.out.println();
            }
        }
    }

    public static final void print8x8(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, shortBuffer) == null) {
            for (int i2 = 0; i2 < 8; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    System.out.printf("%3d, ", Short.valueOf(shortBuffer.get()));
                }
                System.out.println();
            }
        }
    }
}
