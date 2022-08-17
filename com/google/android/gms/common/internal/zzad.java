package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.repackage.ro9;
/* loaded from: classes5.dex */
public final class zzad extends zza implements zzaf {
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
    public final zzq zze(zzn zznVar) throws RemoteException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zznVar)) == null) {
            Parcel zza = zza();
            ro9.c(zza, zznVar);
            Parcel zzB = zzB(6, zza);
            zzq zzqVar = (zzq) ro9.a(zzB, zzq.CREATOR);
            zzB.recycle();
            return zzqVar;
        }
        return (zzq) invokeL.objValue;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzf(zzs zzsVar, IObjectWrapper iObjectWrapper) throws RemoteException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zzsVar, iObjectWrapper)) == null) {
            Parcel zza = zza();
            ro9.c(zza, zzsVar);
            ro9.e(zza, iObjectWrapper);
            Parcel zzB = zzB(5, zza);
            boolean f = ro9.f(zzB);
            zzB.recycle();
            return f;
        }
        return invokeLL.booleanValue;
    }

    @Override // com.google.android.gms.common.internal.zzaf
    public final boolean zzg() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Parcel zzB = zzB(7, zza());
            boolean f = ro9.f(zzB);
            zzB.recycle();
            return f;
        }
        return invokeV.booleanValue;
    }
}
