package com.google.android.gms.internal.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class zzx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zzo zza;
    public final boolean zzb;
    public final zzu zzc;

    public zzx(zzu zzuVar, boolean z, zzo zzoVar, int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zzuVar, Boolean.valueOf(z), zzoVar, Integer.valueOf(i), bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzc = zzuVar;
        this.zzb = z;
        this.zza = zzoVar;
    }

    public static zzx zzc(zzo zzoVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zzoVar)) == null) ? new zzx(new zzu(zzoVar), false, zzn.zza, Integer.MAX_VALUE, null) : (zzx) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Iterator<String> zzh(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, charSequence)) == null) ? new zzt(this.zzc, this, charSequence) : (Iterator) invokeL.objValue;
    }

    public final zzx zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new zzx(this.zzc, true, this.zza, Integer.MAX_VALUE, null) : (zzx) invokeV.objValue;
    }

    public final Iterable<String> zzd(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) ? new zzv(this, charSequence) : (Iterable) invokeL.objValue;
    }

    public final List<String> zzf(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence)) == null) {
            if (charSequence != null) {
                Iterator<String> zzh = zzh(charSequence);
                ArrayList arrayList = new ArrayList();
                while (zzh.hasNext()) {
                    arrayList.add(zzh.next());
                }
                return Collections.unmodifiableList(arrayList);
            }
            throw null;
        }
        return (List) invokeL.objValue;
    }
}
