package com.kwad.sdk.pngencrypt;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
/* loaded from: classes3.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public static Charset a;

    /* renamed from: b  reason: collision with root package name */
    public static Charset f59386b;

    /* renamed from: c  reason: collision with root package name */
    public static ThreadLocal<Boolean> f59387c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-743218843, "Lcom/kwad/sdk/pngencrypt/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-743218843, "Lcom/kwad/sdk/pngencrypt/n;");
                return;
            }
        }
        a = Charset.forName("ISO-8859-1");
        f59386b = Charset.forName("UTF-8");
        f59387c = new ThreadLocal<Boolean>() { // from class: com.kwad.sdk.pngencrypt.n.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.lang.ThreadLocal
            /* renamed from: a */
            public Boolean initialValue() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) ? Boolean.FALSE : (Boolean) invokeV.objValue;
            }
        };
    }

    public static double a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i2)) == null) ? i2 / 100000.0d : invokeI.doubleValue;
    }

    public static final int a(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(65538, null, i2, i3, i4)) == null) {
            int i5 = (i2 + i3) - i4;
            int i6 = i5 >= i2 ? i5 - i2 : i2 - i5;
            int i7 = i5 >= i3 ? i5 - i3 : i3 - i5;
            int i8 = i5 >= i4 ? i5 - i4 : i4 - i5;
            return (i6 > i7 || i6 > i8) ? i7 <= i8 ? i3 : i4 : i2;
        }
        return invokeIII.intValue;
    }

    public static int a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, inputStream)) == null) {
            try {
                return inputStream.read();
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, i2)) == null) ? bArr[i2] & 255 : invokeLI.intValue;
    }

    public static byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? new byte[]{-119, 80, 78, 71, 13, 10, 26, 10} : (byte[]) invokeV.objValue;
    }

    public static int b(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, inputStream)) == null) {
            try {
                int read = inputStream.read();
                int read2 = inputStream.read();
                int read3 = inputStream.read();
                int read4 = inputStream.read();
                if (read == -1 || read2 == -1 || read3 == -1 || read4 == -1) {
                    return -1;
                }
                return (read << 24) | (read2 << 16) | ((read3 << 8) + read4);
            } catch (IOException e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int b(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, bArr, i2)) == null) ? (bArr[i2 + 1] & 255) | ((bArr[i2] & 255) << 8) : invokeLI.intValue;
    }

    public static final int c(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, bArr, i2)) == null) ? (bArr[i2 + 3] & 255) | ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) : invokeLI.intValue;
    }
}
