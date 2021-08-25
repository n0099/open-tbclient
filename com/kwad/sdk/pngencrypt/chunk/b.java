package com.kwad.sdk.pngencrypt.chunk;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f72954a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f72955b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f72956c;

    /* renamed from: d  reason: collision with root package name */
    public static final byte[] f72957d;

    /* renamed from: e  reason: collision with root package name */
    public static Pattern f72958e;

    /* renamed from: f  reason: collision with root package name */
    public static byte[] f72959f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1066534701, "Lcom/kwad/sdk/pngencrypt/chunk/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1066534701, "Lcom/kwad/sdk/pngencrypt/chunk/b;");
                return;
            }
        }
        f72954a = a("IHDR");
        f72955b = a("PLTE");
        f72956c = a("IDAT");
        f72957d = a("IEND");
        f72959f = new byte[4096];
        f72958e = Pattern.compile("[a-zA-Z][a-zA-Z][A-Z][a-zA-Z]");
    }

    public static String a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bArr)) == null) ? new String(bArr, com.kwad.sdk.pngencrypt.n.f73045a) : (String) invokeL.objValue;
    }

    public static String a(byte[] bArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, bArr, i2)) == null) ? (bArr == null || bArr.length < i2 + 4) ? "?" : a(bArr, i2, 4) : (String) invokeLI.objValue;
    }

    public static String a(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, bArr, i2, i3)) == null) ? new String(bArr, i2, i3, com.kwad.sdk.pngencrypt.n.f73045a) : (String) invokeLII.objValue;
    }

    public static List<PngChunk> a(List<PngChunk> list, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, cVar)) == null) {
            ArrayList arrayList = new ArrayList();
            for (PngChunk pngChunk : list) {
                if (cVar.a(pngChunk)) {
                    arrayList.add(pngChunk);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, inputStream, outputStream) == null) {
            synchronized (f72959f) {
                while (true) {
                    int read = inputStream.read(f72959f);
                    if (read > 0) {
                        outputStream.write(f72959f, 0, read);
                    }
                }
            }
        }
    }

    public static byte[] a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? str.getBytes(com.kwad.sdk.pngencrypt.n.f73045a) : (byte[]) invokeL.objValue;
    }

    public static byte[] a(byte[] bArr, int i2, int i3, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)})) == null) {
            try {
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i2, i3);
                if (!z) {
                    byteArrayInputStream = new InflaterInputStream(byteArrayInputStream);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStream deflaterOutputStream = z ? new DeflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream;
                a(byteArrayInputStream, deflaterOutputStream);
                byteArrayInputStream.close();
                deflaterOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return new byte[0];
            }
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, bArr)) == null) ? new String(bArr, com.kwad.sdk.pngencrypt.n.f73046b) : (String) invokeL.objValue;
    }

    public static String b(byte[] bArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(65545, null, bArr, i2, i3)) == null) ? new String(bArr, i2, i3, com.kwad.sdk.pngencrypt.n.f73046b) : (String) invokeLII.objValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? Character.isUpperCase(str.charAt(0)) : invokeL.booleanValue;
    }

    public static int c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, bArr)) == null) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                if (bArr[i2] == 0) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? Character.isUpperCase(str.charAt(1)) : invokeL.booleanValue;
    }

    public static boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? !Character.isUpperCase(str.charAt(3)) : invokeL.booleanValue;
    }
}
