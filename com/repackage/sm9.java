package com.repackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.zzi;
import com.google.android.gms.common.zzj;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class sm9 {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static sm9 b;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    public sm9(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context.getApplicationContext();
    }

    @NonNull
    public static sm9 a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            an9.d(context);
            synchronized (sm9.class) {
                if (b == null) {
                    ao9.a(context);
                    b = new sm9(context);
                }
            }
            return b;
        }
        return (sm9) invokeL.objValue;
    }

    @Nullable
    public static final zzi b(PackageInfo packageInfo, zzi... zziVarArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, packageInfo, zziVarArr)) == null) {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return null;
            }
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzj zzjVar = new zzj(packageInfo.signatures[0].toByteArray());
            for (int i = 0; i < zziVarArr.length; i++) {
                if (zziVarArr[i].equals(zzjVar)) {
                    return zziVarArr[i];
                }
            }
            return null;
        }
        return (zzi) invokeLL.objValue;
    }

    public static final boolean c(@NonNull PackageInfo packageInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65539, null, packageInfo, z)) == null) {
            if (packageInfo != null && packageInfo.signatures != null) {
                if ((z ? b(packageInfo, zn9.a) : b(packageInfo, zn9.a[0])) != null) {
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }
}
