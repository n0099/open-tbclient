package com.google.android.gms.common;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzag;
import java.util.List;
/* loaded from: classes7.dex */
public final class zzx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String zza;
    public long zzb;
    public zzag<byte[]> zzc;
    public zzag<byte[]> zzd;

    public final zzx zza(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            this.zzb = j;
            return this;
        }
        return (zzx) invokeJ.objValue;
    }

    public final zzx zzd(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            this.zza = str;
            return this;
        }
        return (zzx) invokeL.objValue;
    }

    public zzx() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = null;
        this.zzb = -1L;
        this.zzc = zzag.zzl();
        this.zzd = zzag.zzl();
    }

    public final zzx zzb(List<byte[]> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            Preconditions.checkNotNull(list);
            this.zzd = zzag.zzk(list);
            return this;
        }
        return (zzx) invokeL.objValue;
    }

    public final zzx zzc(List<byte[]> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            Preconditions.checkNotNull(list);
            this.zzc = zzag.zzk(list);
            return this;
        }
        return (zzx) invokeL.objValue;
    }

    public final zzz zze() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.zza != null) {
                if (this.zzb >= 0) {
                    if (this.zzc.isEmpty() && this.zzd.isEmpty()) {
                        throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
                    }
                    return new zzz(this.zza, this.zzb, this.zzc, this.zzd, null);
                }
                throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
            }
            throw new IllegalStateException("packageName must be defined");
        }
        return (zzz) invokeV.objValue;
    }
}
