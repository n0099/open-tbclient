package com.google.android.gms.common;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class zzv extends zzw {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable zzd;

    public /* synthetic */ zzv(Callable callable, zzu zzuVar) {
        super(false, null, null);
        this.zzd = callable;
    }

    @Override // com.google.android.gms.common.zzw
    public final String zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                return (String) this.zzd.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (String) invokeV.objValue;
    }
}
