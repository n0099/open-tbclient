package com.googlecode.mp4parser.h264;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ShortBuffer;
/* loaded from: classes7.dex */
public class Debug {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean debug = false;
    public transient /* synthetic */ FieldHolder $fh;

    public Debug() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void print(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65537, null, i) == null) {
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
            int i = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    System.out.printf("%3d, ", Short.valueOf(sArr[i]));
                    i++;
                }
                System.out.println();
            }
        }
    }

    public static final void print8x8(int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, iArr) == null) {
            int i = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    System.out.printf("%3d, ", Integer.valueOf(iArr[i]));
                    i++;
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
        if (interceptable == null || interceptable.invokeL(65542, null, sArr) == null) {
            int i = 0;
            for (int i2 = 0; i2 < 8; i2++) {
                for (int i3 = 0; i3 < 8; i3++) {
                    System.out.printf("%3d, ", Short.valueOf(sArr[i]));
                    i++;
                }
                System.out.println();
            }
        }
    }

    public static final void print8x8(ShortBuffer shortBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, shortBuffer) == null) {
            for (int i = 0; i < 8; i++) {
                for (int i2 = 0; i2 < 8; i2++) {
                    System.out.printf("%3d, ", Short.valueOf(shortBuffer.get()));
                }
                System.out.println();
            }
        }
    }
}
