package com.google.android.gms.internal.common;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.dp9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.CheckForNull;
/* loaded from: classes7.dex */
public final class zzaf extends zzag {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient int zza;
    public final transient int zzb;
    public final /* synthetic */ zzag zzc;

    public zzaf(zzag zzagVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zzagVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zzc = zzagVar;
        this.zza = i;
        this.zzb = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            dp9.a(i, this.zzb, "index");
            return this.zzc.get(i + this.zza);
        }
        return invokeI.objValue;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.zzb : invokeV.intValue;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.zzc.zzc() + this.zza + this.zzb : invokeV.intValue;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final int zzc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.zzc.zzc() + this.zza : invokeV.intValue;
    }

    @Override // com.google.android.gms.internal.common.zzac
    public final boolean zzf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.google.android.gms.internal.common.zzac
    @CheckForNull
    public final Object[] zzg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.zzc.zzg() : (Object[]) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.internal.common.zzag, java.util.List
    /* renamed from: zzh */
    public final zzag subList(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i, i2)) == null) {
            dp9.c(i, i2, this.zzb);
            zzag zzagVar = this.zzc;
            int i3 = this.zza;
            return zzagVar.subList(i + i3, i2 + i3);
        }
        return (zzag) invokeII.objValue;
    }
}
