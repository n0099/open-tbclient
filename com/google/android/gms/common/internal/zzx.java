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
public final class zzx extends com.google.android.gms.internal.common.zza implements zzz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
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

    @Override // com.google.android.gms.common.internal.zzz
    public final int zzc() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Parcel zzB = zzB(2, zza());
            int readInt = zzB.readInt();
            zzB.recycle();
            return readInt;
        }
        return invokeV.intValue;
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final IObjectWrapper zzd() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Parcel zzB = zzB(1, zza());
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
            zzB.recycle();
            return asInterface;
        }
        return (IObjectWrapper) invokeV.objValue;
    }
}
