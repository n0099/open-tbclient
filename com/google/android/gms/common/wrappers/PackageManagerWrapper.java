package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import androidx.core.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.util.PlatformVersion;
/* loaded from: classes7.dex */
public class PackageManagerWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context zza;

    public PackageManagerWrapper(Context context) {
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

    public int checkCallingOrSelfPermission(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.zza.checkCallingOrSelfPermission(str);
        }
        return invokeL.intValue;
    }

    public CharSequence getApplicationLabel(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return this.zza.getPackageManager().getApplicationLabel(this.zza.getPackageManager().getApplicationInfo(str, 0));
        }
        return (CharSequence) invokeL.objValue;
    }

    public int checkPermission(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
            return this.zza.getPackageManager().checkPermission(str, str2);
        }
        return invokeLL.intValue;
    }

    public ApplicationInfo getApplicationInfo(String str, int i) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            return this.zza.getPackageManager().getApplicationInfo(str, i);
        }
        return (ApplicationInfo) invokeLI.objValue;
    }

    public PackageInfo getPackageInfo(String str, int i) throws PackageManager.NameNotFoundException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            return this.zza.getPackageManager().getPackageInfo(str, i);
        }
        return (PackageInfo) invokeLI.objValue;
    }

    public Pair getApplicationLabelAndIcon(String str) throws PackageManager.NameNotFoundException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            ApplicationInfo applicationInfo = this.zza.getPackageManager().getApplicationInfo(str, 0);
            return Pair.create(this.zza.getPackageManager().getApplicationLabel(applicationInfo), this.zza.getPackageManager().getApplicationIcon(applicationInfo));
        }
        return (Pair) invokeL.objValue;
    }

    public boolean isCallerInstantApp() {
        InterceptResult invokeV;
        String nameForUid;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Binder.getCallingUid() == Process.myUid()) {
                return InstantApps.isInstantApp(this.zza);
            }
            if (PlatformVersion.isAtLeastO() && (nameForUid = this.zza.getPackageManager().getNameForUid(Binder.getCallingUid())) != null) {
                return this.zza.getPackageManager().isInstantApp(nameForUid);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean zza(int i, String str) {
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
