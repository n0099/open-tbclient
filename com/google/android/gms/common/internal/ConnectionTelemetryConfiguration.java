package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.repackage.fk9;
import com.repackage.qk9;
/* loaded from: classes4.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final RootTelemetryConfiguration zza;
    public final boolean zzb;
    public final boolean zzc;
    @Nullable
    public final int[] zzd;
    public final int zze;
    @Nullable
    public final int[] zzf;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-633980172, "Lcom/google/android/gms/common/internal/ConnectionTelemetryConfiguration;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-633980172, "Lcom/google/android/gms/common/internal/ConnectionTelemetryConfiguration;");
                return;
            }
        }
        CREATOR = new qk9();
    }

    public ConnectionTelemetryConfiguration(@NonNull RootTelemetryConfiguration rootTelemetryConfiguration, boolean z, boolean z2, @Nullable int[] iArr, int i, @Nullable int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rootTelemetryConfiguration, Boolean.valueOf(z), Boolean.valueOf(z2), iArr, Integer.valueOf(i), iArr2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = rootTelemetryConfiguration;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = iArr;
        this.zze = i;
        this.zzf = iArr2;
    }

    public int getMaxMethodInvocationsLogged() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zze : invokeV.intValue;
    }

    @Nullable
    public int[] getMethodInvocationMethodKeyAllowlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzd : (int[]) invokeV.objValue;
    }

    @Nullable
    public int[] getMethodInvocationMethodKeyDisallowlist() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.zzf : (int[]) invokeV.objValue;
    }

    public boolean getMethodInvocationTelemetryEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zzb : invokeV.booleanValue;
    }

    public boolean getMethodTimingTelemetryEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zzc : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i) == null) {
            int a = fk9.a(parcel);
            fk9.j(parcel, 1, this.zza, i, false);
            fk9.c(parcel, 2, getMethodInvocationTelemetryEnabled());
            fk9.c(parcel, 3, getMethodTimingTelemetryEnabled());
            fk9.h(parcel, 4, getMethodInvocationMethodKeyAllowlist(), false);
            fk9.g(parcel, 5, getMaxMethodInvocationsLogged());
            fk9.h(parcel, 6, getMethodInvocationMethodKeyDisallowlist(), false);
            fk9.b(parcel, a);
        }
    }

    @NonNull
    public final RootTelemetryConfiguration zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.zza : (RootTelemetryConfiguration) invokeV.objValue;
    }
}
