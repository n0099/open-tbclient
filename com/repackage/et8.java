package com.repackage;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public class et8 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = 48000;
            this.b = 1;
            this.c = 16;
            this.d = 0;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                int i = this.d;
                return i == 5 || i == 6 || i == 8 || i == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i = this.d;
                return i == 3 || i == 4 || i == 8 || i == 9;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.d;
                return i == 1 || i == 4 || i == 6 || i == 9;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-755725976, "Lcom/repackage/et8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-755725976, "Lcom/repackage/et8;");
        }
    }

    public static byte[] a(byte b, byte b2, byte b3, byte b4, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Byte.valueOf(b), Byte.valueOf(b2), Byte.valueOf(b3), Byte.valueOf(b4), Boolean.valueOf(z)})) == null) ? e((short) ((f(b, b2, z) / 2) + (f(b3, b4, z) / 2)), z) : (byte[]) invokeCommon.objValue;
    }

    public static byte[] b(int i, int i2, byte[] bArr) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, null, i, i2, bArr)) == null) {
            BdLog.e("convertChannelCount sourceByteWidth = " + i + " outputByteWidth = " + i2);
            if (i == i2) {
                return bArr;
            }
            int length = bArr.length;
            if (i != 1) {
                if (i == 2 && i2 == 1) {
                    int i3 = length / 2;
                    byte[] bArr2 = new byte[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        int i5 = i4 * 2;
                        bArr2[i4] = (byte) (f(bArr[i5], bArr[i5 + 1], a) / 256);
                    }
                    return bArr2;
                }
            } else if (i2 == 2) {
                byte[] bArr3 = new byte[length * 2];
                for (int i6 = 0; i6 < length; i6++) {
                    byte[] e = e((short) (bArr[i6] * 256), a);
                    int i7 = i6 * 2;
                    bArr3[i7] = e[0];
                    bArr3[i7 + 1] = e[1];
                }
                return bArr3;
            }
            return bArr;
        }
        return (byte[]) invokeIIL.objValue;
    }

    public static byte[] c(int i, int i2, int i3, byte[] bArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), bArr})) == null) {
            BdLog.e("convertChannelCount sourceChannelCount = " + i + " outputChannelCount = " + i2);
            if (i == i2) {
                return bArr;
            }
            if (i3 == 1 || i3 == 2) {
                int length = bArr.length;
                int i4 = 0;
                if (i != 1) {
                    if (i == 2 && i2 == 1) {
                        int i5 = length / 2;
                        byte[] bArr2 = new byte[i5];
                        if (i3 == 1) {
                            while (i4 < i5) {
                                int i6 = i4 * 2;
                                bArr2[i4] = (byte) (((short) (bArr[i6] + bArr[i6 + 1])) >> 1);
                                i4 += 2;
                            }
                        } else if (i3 == 2) {
                            for (int i7 = 0; i7 < i5; i7 += 2) {
                                int i8 = i7 * 2;
                                byte[] a2 = a(bArr[i8], bArr[i8 + 1], bArr[i8 + 2], bArr[i8 + 3], a);
                                bArr2[i7] = a2[0];
                                bArr2[i7 + 1] = a2[1];
                            }
                        }
                        return bArr2;
                    }
                } else if (i2 == 2) {
                    byte[] bArr3 = new byte[length * 2];
                    if (i3 == 1) {
                        while (i4 < length) {
                            byte b = bArr[i4];
                            int i9 = i4 * 2;
                            bArr3[i9] = b;
                            bArr3[i9 + 1] = b;
                            i4++;
                        }
                    } else if (i3 == 2) {
                        while (i4 < length) {
                            byte b2 = bArr[i4];
                            byte b3 = bArr[i4 + 1];
                            int i10 = i4 * 2;
                            bArr3[i10] = b2;
                            bArr3[i10 + 1] = b3;
                            bArr3[i10 + 2] = b2;
                            bArr3[i10 + 3] = b3;
                            i4 += 2;
                        }
                    }
                    return bArr3;
                }
                return bArr;
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    @TargetApi(16)
    public static a d(String str) {
        InterceptResult invokeL;
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(str);
                int i = 0;
                while (true) {
                    if (i >= mediaExtractor.getTrackCount()) {
                        mediaFormat = null;
                        break;
                    }
                    mediaFormat = mediaExtractor.getTrackFormat(i);
                    if (mediaFormat.getString("mime").startsWith("audio/")) {
                        mediaExtractor.selectTrack(i);
                        break;
                    }
                    i++;
                }
                if (mediaFormat == null) {
                    mediaExtractor.release();
                    return null;
                }
                a aVar = new a();
                aVar.a = mediaFormat.containsKey("sample-rate") ? mediaFormat.getInteger("sample-rate") : 48000;
                aVar.b = mediaFormat.containsKey("channel-count") ? mediaFormat.getInteger("channel-count") : 1;
                aVar.c = mediaFormat.containsKey("bit-width") ? mediaFormat.getInteger("bit-width") : 16;
                mediaExtractor.release();
                return aVar;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static byte[] e(short s, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Short.valueOf(s), Boolean.valueOf(z)})) == null) {
            byte[] bArr = new byte[2];
            if (z) {
                bArr[1] = (byte) (s & 255);
                bArr[0] = (byte) (((short) (s >> 8)) & 255);
            } else {
                bArr[0] = (byte) (s & 255);
                bArr[1] = (byte) (((short) (s >> 8)) & 255);
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    public static short f(byte b, byte b2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, null, new Object[]{Byte.valueOf(b), Byte.valueOf(b2), Boolean.valueOf(z)})) == null) {
            return (short) (z ? ((short) (((short) ((b & 255) | 0)) << 8)) | (b2 & 255) : (b & 255) | ((short) (((short) ((b2 & 255) | 0)) << 8)));
        }
        return invokeCommon.shortValue;
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                a = true;
            } else {
                a = false;
            }
        }
    }

    public static boolean h(a... aVarArr) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, aVarArr)) == null) {
            if (aVarArr == null || aVarArr.length < 2 || (aVar = aVarArr[0]) == null) {
                return false;
            }
            boolean z = true;
            for (int i = 1; i < aVarArr.length; i++) {
                if (aVar.a != aVarArr[i].a) {
                    aVarArr[i].d++;
                    z = false;
                }
                if (aVar.b != aVarArr[i].b) {
                    aVarArr[i].d += 3;
                    z = false;
                }
                if (aVar.c != aVarArr[i].c) {
                    aVarArr[i].d += 5;
                    z = false;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public static boolean i(String str, String str2, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65545, null, str, str2, i, i2)) == null) {
            BdLog.e("resampling sampleRate = " + i + " resampleRate = " + i2);
            if (i2 == i) {
                return false;
            }
            File file = new File(str);
            File file2 = new File(str2);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                new ht8(fileInputStream, fileOutputStream, i, i2, 2, 2, 1, Integer.MAX_VALUE, 0.0d, 0, true);
                fileInputStream.close();
                fileOutputStream.close();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeLLII.booleanValue;
    }
}
