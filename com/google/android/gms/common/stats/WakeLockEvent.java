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
import com.repackage.an9;
import com.repackage.on9;
import java.util.List;
import javax.annotation.Nullable;
@Deprecated
/* loaded from: classes5.dex */
public final class WakeLockEvent extends StatsEvent {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final int zza;
    public final long zzb;
    public int zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final int zzg;
    @Nullable
    public final List<String> zzh;
    public final String zzi;
    public final long zzj;
    public int zzk;
    public final String zzl;
    public final float zzm;
    public final long zzn;
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
        CREATOR = new on9();
    }

    public WakeLockEvent(int i, long j, int i2, String str, int i3, @Nullable List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5, boolean z) {
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
            int a = an9.a(parcel);
            an9.g(parcel, 1, this.zza);
            an9.i(parcel, 2, this.zzb);
            an9.k(parcel, 4, this.zzd, false);
            an9.g(parcel, 5, this.zzg);
            an9.l(parcel, 6, this.zzh, false);
            an9.i(parcel, 8, this.zzj);
            an9.k(parcel, 10, this.zze, false);
            an9.g(parcel, 11, this.zzc);
            an9.k(parcel, 12, this.zzi, false);
            an9.k(parcel, 13, this.zzl, false);
            an9.g(parcel, 14, this.zzk);
            an9.e(parcel, 15, this.zzm);
            an9.i(parcel, 16, this.zzn);
            an9.k(parcel, 17, this.zzf, false);
            an9.c(parcel, 18, this.zzo);
            an9.b(parcel, a);
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
