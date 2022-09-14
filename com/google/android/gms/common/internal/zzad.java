package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes7.dex */
public final class zzad extends com.google.android.gms.internal.common.zza implements zzaf {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzad(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iBinder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((IBinder) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final com.google.android.gms.common.zzq zze(com.google.android.gms.common.zzn zznVar) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zznVar)) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zzc(zza, zznVar);
            Parcel zzB = zzB(6, zza);
            com.google.android.gms.common.zzq zzqVar = (com.google.android.gms.common.zzq) com.google.android.gms.internal.common.zzc.zza(zzB, com.google.android.gms.common.zzq.CREATOR);
            zzB.recycle();
            return zzqVar;
        }
        return (com.google.android.gms.common.zzq) invokeL.objValue;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzf(com.google.android.gms.common.zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zzsVar, iObjectWrapper)) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zzc(zza, zzsVar);
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
            Parcel zzB = zzB(5, zza);
            boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
            zzB.recycle();
            return zzf;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzg() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Parcel zzB = zzB(7, zza());
            boolean zzf = com.google.android.gms.internal.common.zzc.zzf(zzB);
            zzB.recycle();
            return zzf;
        }
        return invokeV.booleanValue;
    }
}
