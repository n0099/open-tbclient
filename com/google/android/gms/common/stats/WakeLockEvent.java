package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;
@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
/* loaded from: classes7.dex */
public final class WakeLockEvent extends StatsEvent {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    @SafeParcelable.VersionField(id = 1)
    public final int zza;
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    public final long zzb;
    @SafeParcelable.Field(getter = "getEventType", id = 11)
    public int zzc;
    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    public final String zzd;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    public final String zze;
    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    public final String zzf;
    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    public final int zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    public final List<String> zzh;
    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    public final String zzi;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    public final long zzj;
    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    public int zzk;
    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    public final String zzl;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    public final float zzm;
    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    public final long zzn;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    public final boolean zzo;
    public long zzp;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-721733818, "Lcom/google/android/gms/common/stats/WakeLockEvent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-721733818, "Lcom/google/android/gms/common/stats/WakeLockEvent;");
                return;
            }
        }
        CREATOR = new zza();
    }

    @SafeParcelable.Constructor
    public WakeLockEvent(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 11) int i2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i3, @SafeParcelable.Param(id = 6) @Nullable List<String> list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j2, @SafeParcelable.Param(id = 14) int i4, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f, @SafeParcelable.Param(id = 16) long j3, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), str, Integer.valueOf(i3), list, str2, Long.valueOf(j2), Integer.valueOf(i4), str3, str4, Float.valueOf(f), Long.valueOf(j3), str5, Boolean.valueOf(z)};
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
        this.zzb = j;
        this.zzc = i2;
        this.zzd = str;
        this.zze = str3;
        this.zzf = str5;
        this.zzg = i3;
        this.zzp = -1L;
        this.zzh = list;
        this.zzi = str2;
        this.zzj = j2;
        this.zzk = i4;
        this.zzl = str4;
        this.zzm = f;
        this.zzn = j3;
        this.zzo = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.zza);
            SafeParcelWriter.writeLong(parcel, 2, this.zzb);
            SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
            SafeParcelWriter.writeInt(parcel, 5, this.zzg);
            SafeParcelWriter.writeStringList(parcel, 6, this.zzh, false);
            SafeParcelWriter.writeLong(parcel, 8, this.zzj);
            SafeParcelWriter.writeString(parcel, 10, this.zze, false);
            SafeParcelWriter.writeInt(parcel, 11, this.zzc);
            SafeParcelWriter.writeString(parcel, 12, this.zzi, false);
            SafeParcelWriter.writeString(parcel, 13, this.zzl, false);
            SafeParcelWriter.writeInt(parcel, 14, this.zzk);
            SafeParcelWriter.writeFloat(parcel, 15, this.zzm);
            SafeParcelWriter.writeLong(parcel, 16, this.zzn);
            SafeParcelWriter.writeString(parcel, 17, this.zzf, false);
            SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzc : invokeV.intValue;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.zzp : invokeV.longValue;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zzb : invokeV.longValue;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    @NonNull
    public final String zzd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<String> list = this.zzh;
            String str = this.zzd;
            int i = this.zzg;
            String join = list == null ? "" : TextUtils.join(",", list);
            int i2 = this.zzk;
            String str2 = this.zze;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = this.zzl;
            if (str3 == null) {
                str3 = "";
            }
            float f = this.zzm;
            String str4 = this.zzf;
            String str5 = str4 != null ? str4 : "";
            boolean z = this.zzo;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + str2.length() + str3.length() + str5.length());
            sb.append("\t");
            sb.append(str);
            sb.append("\t");
            sb.append(i);
            sb.append("\t");
            sb.append(join);
            sb.append("\t");
            sb.append(i2);
            sb.append("\t");
            sb.append(str2);
            sb.append("\t");
            sb.append(str3);
            sb.append("\t");
            sb.append(f);
            sb.append("\t");
            sb.append(str5);
            sb.append("\t");
            sb.append(z);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
