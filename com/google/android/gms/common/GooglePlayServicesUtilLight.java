package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;
@ShowFirstParty
@KeepForSdk
/* loaded from: classes7.dex */
public class GooglePlayServicesUtilLight {
    public static /* synthetic */ Interceptable $ic = null;
    @KeepForSdk
    public static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    @KeepForSdk
    public static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    @NonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @NonNull
    @KeepForSdk
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @KeepForSdk
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @NonNull
    @KeepForSdk
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @VisibleForTesting
    @KeepForSdk
    public static final AtomicBoolean sCanceledAvailabilityNotification;
    @VisibleForTesting
    public static boolean zza;
    public static boolean zzb;
    public static final AtomicBoolean zzc;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1786187112, "Lcom/google/android/gms/common/GooglePlayServicesUtilLight;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1786187112, "Lcom/google/android/gms/common/GooglePlayServicesUtilLight;");
                return;
            }
        }
        sCanceledAvailabilityNotification = new AtomicBoolean();
        zzc = new AtomicBoolean();
    }

    @KeepForSdk
    public GooglePlayServicesUtilLight() {
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

    @KeepForSdk
    @Deprecated
    public static void cancelAvailabilityErrorNotifications(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, context) == null) || sCanceledAvailabilityNotification.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);
            }
        } catch (SecurityException unused) {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static void enableUsingApkIndependentContext() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            zzc.set(true);
        }
    }

    @KeepForSdk
    @Deprecated
    public static void ensurePlayServicesAvailable(@NonNull Context context, int i) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, i) == null) || (isGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, i)) == 0) {
            return;
        }
        Intent errorResolutionIntent = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(context, isGooglePlayServicesAvailable, "e");
        StringBuilder sb = new StringBuilder(57);
        sb.append("GooglePlayServices not available due to error ");
        sb.append(isGooglePlayServicesAvailable);
        Log.e("GooglePlayServicesUtil", sb.toString());
        if (errorResolutionIntent == null) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", errorResolutionIntent);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int getApkVersion(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int getClientVersion(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            Preconditions.checkState(true);
            return ClientLibraryUtils.getClientVersion(context, context.getPackageName());
        }
        return invokeL.intValue;
    }

    @Nullable
    @KeepForSdk
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, @NonNull Context context, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Integer.valueOf(i), context, Integer.valueOf(i2)})) == null) ? GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, i, i2) : (PendingIntent) invokeCommon.objValue;
    }

    @NonNull
    @VisibleForTesting
    @Deprecated
    @KeepForSdk
    public static String getErrorString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65544, null, i)) == null) ? ConnectionResult.zza(i) : (String) invokeI.objValue;
    }

    @Deprecated
    @Nullable
    @ShowFirstParty
    @KeepForSdk
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65545, null, i)) == null) ? GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, i, null) : (Intent) invokeI.objValue;
    }

    @Nullable
    @KeepForSdk
    public static Context getRemoteContext(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            try {
                return context.createPackageContext("com.google.android.gms", 3);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (Context) invokeL.objValue;
    }

    @Nullable
    @KeepForSdk
    public static Resources getRemoteResource(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            try {
                return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
        return (Resources) invokeL.objValue;
    }

    @ShowFirstParty
    @KeepForSdk
    public static boolean honorsDebugCertificates(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            try {
                if (!zza) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.google.android.gms", 64);
                    GoogleSignatureVerifier.getInstance(context);
                    if (packageInfo == null || GoogleSignatureVerifier.zzb(packageInfo, false) || !GoogleSignatureVerifier.zzb(packageInfo, true)) {
                        zzb = false;
                    } else {
                        zzb = true;
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            } finally {
                zza = true;
            }
            return zzb || !DeviceProperties.isUserBuild();
        }
        return invokeL.booleanValue;
    }

    @HideFirstParty
    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE) : invokeL.intValue;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isGooglePlayServicesUid(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65551, null, context, i)) == null) ? UidVerifier.isGooglePlayServicesUid(context, i) : invokeLI.booleanValue;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65552, null, context, i)) == null) {
            if (i == 18) {
                return true;
            }
            if (i == 1) {
                return zza(context, "com.google.android.gms");
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, null, context, i)) == null) {
            if (i == 9) {
                return zza(context, "com.android.vending");
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @KeepForSdk
    @TargetApi(18)
    public static boolean isRestrictedUserProfile(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) {
            if (PlatformVersion.isAtLeastJellyBeanMR2()) {
                Object systemService = context.getSystemService("user");
                Preconditions.checkNotNull(systemService);
                Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
                return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @VisibleForTesting
    @Deprecated
    @ShowFirstParty
    @KeepForSdk
    public static boolean isSidewinderDevice(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65555, null, context)) == null) ? DeviceProperties.isSidewinder(context) : invokeL.booleanValue;
    }

    @KeepForSdk
    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65556, null, i)) == null) ? i == 1 || i == 2 || i == 3 || i == 9 : invokeI.booleanValue;
    }

    @KeepForSdk
    @TargetApi(19)
    @Deprecated
    public static boolean uidHasPackageName(@NonNull Context context, int i, @NonNull String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(65557, null, context, i, str)) == null) ? UidVerifier.uidHasPackageName(context, i, str) : invokeLIL.booleanValue;
    }

    @TargetApi(21)
    public static boolean zza(Context context, String str) {
        InterceptResult invokeLL;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, context, str)) == null) {
            boolean equals = str.equals("com.google.android.gms");
            if (PlatformVersion.isAtLeastLollipop()) {
                try {
                    for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                        if (str.equals(sessionInfo.getAppPackageName())) {
                            return true;
                        }
                    }
                } catch (Exception unused) {
                    return false;
                }
            }
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            } catch (PackageManager.NameNotFoundException unused2) {
            }
            if (equals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !isRestrictedUserProfile(context);
        }
        return invokeLL.booleanValue;
    }

    @KeepForSdk
    @Deprecated
    public static int isGooglePlayServicesAvailable(@NonNull Context context, int i) {
        InterceptResult invokeLI;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65550, null, context, i)) == null) {
            try {
                context.getResources().getString(com.baidu.tieba.R.string.obfuscated_res_0x7f0f041b);
            } catch (Throwable unused) {
                Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
            }
            if (!"com.google.android.gms".equals(context.getPackageName()) && !zzc.get()) {
                int zza2 = zzag.zza(context);
                if (zza2 != 0) {
                    if (zza2 != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
                        throw new GooglePlayServicesIncorrectManifestValueException(zza2);
                    }
                } else {
                    throw new GooglePlayServicesMissingManifestValueException();
                }
            }
            boolean z = (DeviceProperties.isWearableWithoutPlayStore(context) || DeviceProperties.zzb(context)) ? false : true;
            Preconditions.checkArgument(i >= 0);
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            if (z) {
                try {
                    packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                } catch (PackageManager.NameNotFoundException unused2) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                }
            } else {
                packageInfo = null;
            }
            try {
                PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                GoogleSignatureVerifier.getInstance(context);
                if (!GoogleSignatureVerifier.zzb(packageInfo2, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                } else {
                    if (z) {
                        Preconditions.checkNotNull(packageInfo);
                        if (!GoogleSignatureVerifier.zzb(packageInfo, true)) {
                            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                        }
                    }
                    if (z && packageInfo != null && !packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                    } else if (com.google.android.gms.common.util.zza.zza(packageInfo2.versionCode) < com.google.android.gms.common.util.zza.zza(i)) {
                        int i2 = packageInfo2.versionCode;
                        StringBuilder sb = new StringBuilder(String.valueOf(packageName).length() + 82);
                        sb.append("Google Play services out of date for ");
                        sb.append(packageName);
                        sb.append(".  Requires ");
                        sb.append(i);
                        sb.append(" but found ");
                        sb.append(i2);
                        Log.w("GooglePlayServicesUtil", sb.toString());
                        return 2;
                    } else {
                        ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException e) {
                                Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e);
                                return 1;
                            }
                        }
                        return !applicationInfo.enabled ? 3 : 0;
                    }
                }
                return 9;
            } catch (PackageManager.NameNotFoundException unused3) {
                Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
                return 1;
            }
        }
        return invokeLI.intValue;
    }
}
