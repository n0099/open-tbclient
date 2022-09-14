package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
@KeepForSdk
/* loaded from: classes7.dex */
public class PackageManagerWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final Context zza;

    public PackageManagerWrapper(@NonNull Context context) {
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
        this.zza = context;
    }

    @KeepForSdk
    public int checkCallingOrSelfPermission(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.zza.checkCallingOrSelfPermission(str) : invokeL.intValue;
    }

    @KeepForSdk
    public int checkPermission(@NonNull String str, @NonNull String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) ? this.zza.getPackageManager().checkPermission(str, str2) : invokeLL.intValue;
    }

    @NonNull
    @KeepForSdk
    public ApplicationInfo getApplicationInfo(@NonNull String str, int i) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) ? this.zza.getPackageManager().getApplicationInfo(str, i) : (ApplicationInfo) invokeLI.objValue;
    }

    @NonNull
    @KeepForSdk
    public CharSequence getApplicationLabel(@NonNull String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.zza.getPackageManager().getApplicationLabel(this.zza.getPackageManager().getApplicationInfo(str, 0)) : (CharSequence) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public Pair<CharSequence, Drawable> getApplicationLabelAndIcon(@NonNull String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ApplicationInfo applicationInfo = this.zza.getPackageManager().getApplicationInfo(str, 0);
            return Pair.create(this.zza.getPackageManager().getApplicationLabel(applicationInfo), this.zza.getPackageManager().getApplicationIcon(applicationInfo));
        }
        return (Pair) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public PackageInfo getPackageInfo(@NonNull String str, int i) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) ? this.zza.getPackageManager().getPackageInfo(str, i) : (PackageInfo) invokeLI.objValue;
    }

    @KeepForSdk
    public boolean isCallerInstantApp() {
        InterceptResult invokeV;
        String nameForUid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Binder.getCallingUid() == Process.myUid()) {
                return InstantApps.isInstantApp(this.zza);
            }
            if (!PlatformVersion.isAtLeastO() || (nameForUid = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
                return false;
            }
            return this.zza.getPackageManager().isInstantApp(nameForUid);
        }
        return invokeV.booleanValue;
    }

    @TargetApi(19)
    public final boolean zza(int i, @NonNull String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, str)) == null) {
            if (PlatformVersion.isAtLeastKitKat()) {
                try {
                    AppOpsManager appOpsManager = (AppOpsManager) this.zza.getSystemService("appops");
                    if (appOpsManager != null) {
                        appOpsManager.checkPackage(i, str);
                        return true;
                    }
                    throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
                } catch (SecurityException unused) {
                    return false;
                }
            }
            String[] packagesForUid = this.zza.getPackageManager().getPackagesForUid(i);
            if (str != null && packagesForUid != null) {
                for (String str2 : packagesForUid) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeIL.booleanValue;
    }
}
