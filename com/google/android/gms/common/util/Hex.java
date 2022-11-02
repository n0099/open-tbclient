package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
@ShowFirstParty
@KeepForSdk
/* loaded from: classes7.dex */
public class Hex {
    public static /* synthetic */ Interceptable $ic;
    public static final char[] zza;
    public static final char[] zzb;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1467427513, "Lcom/google/android/gms/common/util/Hex;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1467427513, "Lcom/google/android/gms/common/util/Hex;");
                return;
            }
        }
        zza = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        zzb = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public Hex() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static String bytesToStringLowercase(@NonNull byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            int length = bArr.length;
            char[] cArr = new char[length + length];
            int i = 0;
            for (byte b : bArr) {
                int i2 = b & 255;
                int i3 = i + 1;
                char[] cArr2 = zzb;
                cArr[i] = cArr2[i2 >>> 4];
                i = i3 + 1;
                cArr[i3] = cArr2[i2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static byte[] stringToBytes(@NonNull String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            int length = str.length();
            if (length % 2 == 0) {
                byte[] bArr = new byte[length / 2];
                int i = 0;
                while (i < length) {
                    int i2 = i + 2;
                    bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, i2), 16);
                    i = i2;
                }
                return bArr;
            }
            throw new IllegalArgumentException("Hex string has odd number of characters");
        }
        return (byte[]) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static String bytesToStringUppercase(@NonNull byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            return bytesToStringUppercase(bArr, false);
        }
        return (String) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static String bytesToStringUppercase(@NonNull byte[] bArr, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, z)) == null) {
            int length = bArr.length;
            StringBuilder sb = new StringBuilder(length + length);
            for (int i = 0; i < length && (!z || i != length - 1 || (bArr[i] & 255) != 0); i++) {
                sb.append(zza[(bArr[i] & 240) >>> 4]);
                sb.append(zza[bArr[i] & 15]);
            }
            return sb.toString();
        }
        return (String) invokeLZ.objValue;
    }
}
