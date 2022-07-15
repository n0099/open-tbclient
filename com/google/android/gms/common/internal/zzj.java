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
import com.repackage.fk9;
import com.repackage.pk9;
/* loaded from: classes4.dex */
public final class zzj extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<zzj> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle zza;
    public Feature[] zzb;
    public int zzc;
    @Nullable
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
        CREATOR = new pk9();
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

    public zzj(Bundle bundle, Feature[] featureArr, int i, @Nullable ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
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
            int a = fk9.a(parcel);
            fk9.d(parcel, 1, this.zza, false);
            fk9.m(parcel, 2, this.zzb, i, false);
            fk9.g(parcel, 3, this.zzc);
            fk9.j(parcel, 4, this.zzd, i, false);
            fk9.b(parcel, a);
        }
    }
}
