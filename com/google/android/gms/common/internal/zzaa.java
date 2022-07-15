package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.internal.common.zza;
import com.repackage.ul9;
/* loaded from: classes4.dex */
public final class zzaa extends zza implements IGmsCallbacks {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
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

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i, iBinder, bundle) == null) {
            Parcel zza = zza();
            zza.writeInt(i);
            zza.writeStrongBinder(iBinder);
            ul9.c(zza, bundle);
            zzC(1, zza);
        }
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzb(int i, Bundle bundle) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bundle) == null) {
            throw null;
        }
    }

    @Override // com.google.android.gms.common.internal.IGmsCallbacks
    public final void zzc(int i, IBinder iBinder, zzj zzjVar) throws RemoteException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, iBinder, zzjVar) == null) {
            throw null;
        }
    }
}
