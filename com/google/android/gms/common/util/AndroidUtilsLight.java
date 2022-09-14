package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@ShowFirstParty
@KeepForSdk
/* loaded from: classes7.dex */
public class AndroidUtilsLight {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile int zza = -1;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1909627762, "Lcom/google/android/gms/common/util/AndroidUtilsLight;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1909627762, "Lcom/google/android/gms/common/util/AndroidUtilsLight;");
        }
    }

    public AndroidUtilsLight() {
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

    @Nullable
    @KeepForSdk
    @Deprecated
    public static byte[] getPackageCertificateHashBytes(@NonNull Context context, @NonNull String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLL;
        MessageDigest zza2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length != 1 || (zza2 = zza("SHA1")) == null) {
                return null;
            }
            return zza2.digest(packageInfo.signatures[0].toByteArray());
        }
        return (byte[]) invokeLL.objValue;
    }

    @Nullable
    public static MessageDigest zza(@NonNull String str) {
        InterceptResult invokeL;
        MessageDigest messageDigest;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            for (int i = 0; i < 2; i++) {
                try {
                    messageDigest = MessageDigest.getInstance(str);
                } catch (NoSuchAlgorithmException unused) {
                }
                if (messageDigest != null) {
                    return messageDigest;
                }
            }
            return null;
        }
        return (MessageDigest) invokeL.objValue;
    }
}
