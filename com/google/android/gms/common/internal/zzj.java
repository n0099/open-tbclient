package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* loaded from: classes7.dex */
public final class zzj extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<zzj> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    @SafeParcelable.Field(id = 1)
    public Bundle zza;
    @SafeParcelable.Field(id = 2)
    public Feature[] zzb;
    @SafeParcelable.Field(defaultValue = "0", id = 3)
    public int zzc;
    @Nullable
    @SafeParcelable.Field(id = 4)
    public ConnectionTelemetryConfiguration zzd;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1907026403, "Lcom/google/android/gms/common/internal/zzj;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1907026403, "Lcom/google/android/gms/common/internal/zzj;");
                return;
            }
        }
        CREATOR = new zzk();
    }

    public zzj() {
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

    @SafeParcelable.Constructor
    public zzj(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) Feature[] featureArr, @SafeParcelable.Param(id = 3) int i, @Nullable @SafeParcelable.Param(id = 4) ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle, featureArr, Integer.valueOf(i), connectionTelemetryConfiguration};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.zza = bundle;
        this.zzb = featureArr;
        this.zzc = i;
        this.zzd = connectionTelemetryConfiguration;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
            SafeParcelWriter.writeTypedArray(parcel, 2, this.zzb, i, false);
            SafeParcelWriter.writeInt(parcel, 3, this.zzc);
            SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }
}
