package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
/* loaded from: classes7.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 2)
    public final int zzb;
    @SafeParcelable.Field(id = 3)
    public int zzc;
    @SafeParcelable.Field(id = 4)
    public String zzd;
    @SafeParcelable.Field(id = 5)
    public IBinder zze;
    @SafeParcelable.Field(id = 6)
    public Scope[] zzf;
    @SafeParcelable.Field(id = 7)
    public Bundle zzg;
    @Nullable
    @SafeParcelable.Field(id = 8)
    public Account zzh;
    @SafeParcelable.Field(id = 10)
    public Feature[] zzi;
    @SafeParcelable.Field(id = 11)
    public Feature[] zzj;
    @SafeParcelable.Field(id = 12)
    public boolean zzk;
    @SafeParcelable.Field(defaultValue = "0", id = 13)
    public int zzl;
    @SafeParcelable.Field(getter = "isRequestingTelemetryConfiguration", id = 14)
    public boolean zzm;
    @Nullable
    @SafeParcelable.Field(getter = "getAttributionTag", id = 15)
    public String zzn;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473230825, "Lcom/google/android/gms/common/internal/GetServiceRequest;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473230825, "Lcom/google/android/gms/common/internal/GetServiceRequest;");
                return;
            }
        }
        CREATOR = new zzm();
    }

    @SafeParcelable.Constructor
    public GetServiceRequest(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z, @SafeParcelable.Param(id = 13) int i4, @SafeParcelable.Param(id = 14) boolean z2, @Nullable @SafeParcelable.Param(id = 15) String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, Boolean.valueOf(z), Integer.valueOf(i4), Boolean.valueOf(z2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzd = "com.google.android.gms";
        } else {
            this.zzd = str;
        }
        if (i < 2) {
            this.zzh = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zze = iBinder;
            this.zzh = account;
        }
        this.zzf = scopeArr;
        this.zzg = bundle;
        this.zzi = featureArr;
        this.zzj = featureArr2;
        this.zzk = z;
        this.zzl = i4;
        this.zzm = z2;
        this.zzn = str2;
    }

    @NonNull
    @KeepForSdk
    public Bundle getExtraArgs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zzg : (Bundle) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
            zzm.zza(this, parcel, i);
        }
    }

    @Nullable
    public final String zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.zzn : (String) invokeV.objValue;
    }

    public GetServiceRequest(int i, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.zza = 6;
        this.zzc = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzb = i;
        this.zzk = true;
        this.zzn = str;
    }
}
