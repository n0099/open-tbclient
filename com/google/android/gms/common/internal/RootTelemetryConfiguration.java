package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
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
import com.repackage.jk9;
/* loaded from: classes4.dex */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-428805264, "Lcom/google/android/gms/common/internal/RootTelemetryConfiguration;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-428805264, "Lcom/google/android/gms/common/internal/RootTelemetryConfiguration;");
                return;
            }
        }
        CREATOR = new jk9();
    }

    public RootTelemetryConfiguration(int i, boolean z, boolean z2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i2;
        this.zze = i3;
    }

    public int getBatchPeriodMillis() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zzd : invokeV.intValue;
    }

    public int getMaxMethodInvocationsInBatch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zze : invokeV.intValue;
    }

    public boolean getMethodInvocationTelemetryEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.zzb : invokeV.booleanValue;
    }

    public boolean getMethodTimingTelemetryEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zzc : invokeV.booleanValue;
    }

    public int getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zza : invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i) == null) {
            int a = fk9.a(parcel);
            fk9.g(parcel, 1, getVersion());
            fk9.c(parcel, 2, getMethodInvocationTelemetryEnabled());
            fk9.c(parcel, 3, getMethodTimingTelemetryEnabled());
            fk9.g(parcel, 4, getBatchPeriodMillis());
            fk9.g(parcel, 5, getMaxMethodInvocationsInBatch());
            fk9.b(parcel, a);
        }
    }
}
