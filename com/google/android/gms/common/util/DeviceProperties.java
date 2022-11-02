package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;
@KeepForSdk
/* loaded from: classes7.dex */
public final class DeviceProperties {
    public static /* synthetic */ Interceptable $ic;
    @Nullable
    public static Boolean zza;
    @Nullable
    public static Boolean zzb;
    @Nullable
    public static Boolean zzc;
    @Nullable
    public static Boolean zzd;
    @Nullable
    public static Boolean zze;
    @Nullable
    public static Boolean zzf;
    @Nullable
    public static Boolean zzg;
    @Nullable
    public static Boolean zzh;
    @Nullable
    public static Boolean zzi;
    @Nullable
    public static Boolean zzj;
    @Nullable
    public static Boolean zzk;
    @Nullable
    public static Boolean zzl;
    public transient /* synthetic */ FieldHolder $fh;

    public DeviceProperties() {
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

    @KeepForSdk
    public static boolean isAuto(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (zzi == null) {
                boolean z = false;
                if (PlatformVersion.isAtLeastO() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                    z = true;
                }
                zzi = Boolean.valueOf(z);
            }
            return zzi.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isBstar(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (zzl == null) {
                boolean z = false;
                if (PlatformVersion.isAtLeastR() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                    z = true;
                }
                zzl = Boolean.valueOf(z);
            }
            return zzl.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isLatchsky(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (zzf == null) {
                PackageManager packageManager = context.getPackageManager();
                boolean z = false;
                if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                    z = true;
                }
                zzf = Boolean.valueOf(z);
            }
            return zzf.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, resources)) == null) {
            boolean z = false;
            if (resources == null) {
                return false;
            }
            if (zzb == null) {
                if ((resources.getConfiguration().screenLayout & 15) > 3 || zzc(resources)) {
                    z = true;
                }
                zzb = Boolean.valueOf(z);
            }
            return zzb.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isTv(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (zzj == null) {
                boolean z = true;
                if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                    z = false;
                }
                zzj = Boolean.valueOf(z);
            }
            return zzj.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    @TargetApi(20)
    public static boolean isWearable(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            PackageManager packageManager = context.getPackageManager();
            if (zzd == null) {
                boolean z = false;
                if (PlatformVersion.isAtLeastKitKatWatch() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                    z = true;
                }
                zzd = Boolean.valueOf(z);
            }
            return zzd.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @TargetApi(21)
    public static boolean zza(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            if (zze == null) {
                boolean z = false;
                if (PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google")) {
                    z = true;
                }
                zze = Boolean.valueOf(z);
            }
            return zze.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static boolean zzb(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (zzg == null) {
                boolean z = true;
                if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                    z = false;
                }
                zzg = Boolean.valueOf(z);
            }
            return zzg.booleanValue();
        }
        return invokeL.booleanValue;
    }

    public static boolean zzc(@NonNull Resources resources) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, resources)) == null) {
            boolean z = false;
            if (resources == null) {
                return false;
            }
            if (zzc == null) {
                Configuration configuration = resources.getConfiguration();
                if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                    z = true;
                }
                zzc = Boolean.valueOf(z);
            }
            return zzc.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isPhone(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (zza == null) {
                boolean z = false;
                if (!isTablet(context) && !isWearable(context) && !zzb(context)) {
                    if (zzh == null) {
                        zzh = Boolean.valueOf(context.getPackageManager().hasSystemFeature("org.chromium.arc"));
                    }
                    if (!zzh.booleanValue() && !isAuto(context) && !isTv(context)) {
                        if (zzk == null) {
                            zzk = Boolean.valueOf(context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE"));
                        }
                        if (!zzk.booleanValue() && !isBstar(context)) {
                            z = true;
                        }
                    }
                }
                zza = Boolean.valueOf(z);
            }
            return zza.booleanValue();
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isSevenInchTablet(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            return zzc(context.getResources());
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    @TargetApi(21)
    public static boolean isSidewinder(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return zza(context);
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isTablet(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            return isTablet(context.getResources());
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    @TargetApi(26)
    public static boolean isWearableWithoutPlayStore(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            if (isWearable(context)) {
                if (!PlatformVersion.isAtLeastN()) {
                    return true;
                }
                if (zza(context) && !PlatformVersion.isAtLeastO()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            int i = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
            return "user".equals(Build.TYPE);
        }
        return invokeV.booleanValue;
    }
}
