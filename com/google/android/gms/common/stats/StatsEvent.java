package com.google.android.gms.common.stats;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
@KeepForSdk
@Deprecated
/* loaded from: classes7.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @KeepForSdk
    /* loaded from: classes7.dex */
    public interface Types {
        @KeepForSdk
        public static final int EVENT_TYPE_ACQUIRE_WAKE_LOCK = 7;
        @KeepForSdk
        public static final int EVENT_TYPE_RELEASE_WAKE_LOCK = 8;
    }

    public StatsEvent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long zzc = zzc();
            int zza = zza();
            long zzb = zzb();
            String zzd = zzd();
            StringBuilder sb = new StringBuilder(zzd.length() + 53);
            sb.append(zzc);
            sb.append("\t");
            sb.append(zza);
            sb.append("\t");
            sb.append(zzb);
            sb.append(zzd);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public abstract int zza();

    public abstract long zzb();

    public abstract long zzc();

    @NonNull
    public abstract String zzd();
}
