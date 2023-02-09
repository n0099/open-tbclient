package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzag;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
@Deprecated
/* loaded from: classes7.dex */
public final class GoogleServices {
    public static /* synthetic */ Interceptable $ic;
    public static final Object zza;
    @Nullable
    @GuardedBy("sLock")
    public static GoogleServices zzb;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final String zzc;
    public final Status zzd;
    public final boolean zze;
    public final boolean zzf;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(69512013, "Lcom/google/android/gms/common/api/internal/GoogleServices;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(69512013, "Lcom/google/android/gms/common/api/internal/GoogleServices;");
                return;
            }
        }
        zza = new Object();
    }

    @VisibleForTesting
    @KeepForSdk
    public GoogleServices(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.zzc = str;
        this.zzd = Status.RESULT_SUCCESS;
        this.zze = z;
        this.zzf = !z;
    }

    @VisibleForTesting
    @KeepForSdk
    public GoogleServices(Context context) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(R.string.obfuscated_res_0x7f0f0440));
        if (identifier != 0) {
            int integer = resources.getInteger(identifier);
            if (integer != 0) {
                z = false;
            } else {
                z = true;
            }
            r2 = integer != 0;
            this.zzf = z;
        } else {
            this.zzf = false;
        }
        this.zze = r2;
        String zzb2 = zzag.zzb(context);
        zzb2 = zzb2 == null ? new StringResourceValueReader(context).getString("google_app_id") : zzb2;
        if (TextUtils.isEmpty(zzb2)) {
            this.zzd = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzc = null;
            return;
        }
        this.zzc = zzb2;
        this.zzd = Status.RESULT_SUCCESS;
    }

    @KeepForSdk
    public static GoogleServices checkInitialized(String str) {
        InterceptResult invokeL;
        GoogleServices googleServices;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            synchronized (zza) {
                googleServices = zzb;
                if (googleServices == null) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                    sb.append("Initialize must be called before ");
                    sb.append(str);
                    sb.append(".");
                    throw new IllegalStateException(sb.toString());
                }
            }
            return googleServices;
        }
        return (GoogleServices) invokeL.objValue;
    }

    @VisibleForTesting
    @KeepForSdk
    public Status checkGoogleAppId(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = this.zzc;
            if (str2 != null && !str2.equals(str)) {
                String str3 = this.zzc;
                StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
                sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
                sb.append(str3);
                sb.append("'.");
                return new Status(10, sb.toString());
            }
            return Status.RESULT_SUCCESS;
        }
        return (Status) invokeL.objValue;
    }

    @VisibleForTesting
    @KeepForSdk
    public static void clearInstanceForTest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            synchronized (zza) {
                zzb = null;
            }
        }
    }

    @Nullable
    @KeepForSdk
    public static String getGoogleAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return checkInitialized("getGoogleAppId").zzc;
        }
        return (String) invokeV.objValue;
    }

    @KeepForSdk
    public static boolean isMeasurementEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            GoogleServices checkInitialized = checkInitialized("isMeasurementEnabled");
            if (checkInitialized.zzd.isSuccess() && checkInitialized.zze) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @KeepForSdk
    public static boolean isMeasurementExplicitlyDisabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return checkInitialized("isMeasurementExplicitlyDisabled").zzf;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context) {
        InterceptResult invokeL;
        Status status;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            Preconditions.checkNotNull(context, "Context must not be null.");
            synchronized (zza) {
                if (zzb == null) {
                    zzb = new GoogleServices(context);
                }
                status = zzb.zzd;
            }
            return status;
        }
        return (Status) invokeL.objValue;
    }

    @NonNull
    @KeepForSdk
    public static Status initialize(@NonNull Context context, @NonNull String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65543, null, context, str, z)) == null) {
            Preconditions.checkNotNull(context, "Context must not be null.");
            Preconditions.checkNotEmpty(str, "App ID must be nonempty.");
            synchronized (zza) {
                GoogleServices googleServices = zzb;
                if (googleServices != null) {
                    return googleServices.checkGoogleAppId(str);
                }
                GoogleServices googleServices2 = new GoogleServices(str, z);
                zzb = googleServices2;
                return googleServices2.zzd;
            }
        }
        return (Status) invokeLLZ.objValue;
    }
}
