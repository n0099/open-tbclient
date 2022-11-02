package com.google.android.gms.common;

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
import com.baidu.webkit.sdk.WebChromeClient;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
/* loaded from: classes7.dex */
public class Feature extends AbstractSafeParcelable {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static final Parcelable.Creator<Feature> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    @SafeParcelable.Field(getter = "getName", id = 1)
    public final String zza;
    @SafeParcelable.Field(getter = "getOldVersion", id = 2)
    @Deprecated
    public final int zzb;
    @SafeParcelable.Field(defaultValue = "-1", getter = WebChromeClient.MSG_METHOD_GETVERSION, id = 3)
    public final long zzc;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(383257131, "Lcom/google/android/gms/common/Feature;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(383257131, "Lcom/google/android/gms/common/Feature;");
                return;
            }
        }
        CREATOR = new zzc();
    }

    @SafeParcelable.Constructor
    public Feature(@NonNull @SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Long.valueOf(j)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }

    @KeepForSdk
    public Feature(@NonNull String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }

    @NonNull
    @KeepForSdk
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zza : (String) invokeV.objValue;
    }

    @KeepForSdk
    public long getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = this.zzc;
            return j == -1 ? this.zzb : j;
        }
        return invokeV.longValue;
    }

    public final boolean equals(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj instanceof Feature) {
                Feature feature = (Feature) obj;
                if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return Objects.hashCode(getName(), Long.valueOf(getVersion()));
        }
        return invokeV.intValue;
    }

    @NonNull
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
            stringHelper.add("name", getName());
            stringHelper.add("version", Long.valueOf(getVersion()));
            return stringHelper.toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i) == null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getName(), false);
            SafeParcelWriter.writeInt(parcel, 2, this.zzb);
            SafeParcelWriter.writeLong(parcel, 3, getVersion());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }
}
