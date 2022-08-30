package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ap9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
/* loaded from: classes7.dex */
public final class zzr extends zza implements IInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
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

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048576, this, iObjectWrapper, str, i, iObjectWrapper2)) == null) {
            Parcel zza = zza();
            ap9.e(zza, iObjectWrapper);
            zza.writeString(str);
            zza.writeInt(i);
            ap9.e(zza, iObjectWrapper2);
            Parcel zzB = zzB(2, zza);
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
            zzB.recycle();
            return asInterface;
        }
        return (IObjectWrapper) invokeLLIL.objValue;
    }

    public final IObjectWrapper zzf(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iObjectWrapper, str, i, iObjectWrapper2)) == null) {
            Parcel zza = zza();
            ap9.e(zza, iObjectWrapper);
            zza.writeString(str);
            zza.writeInt(i);
            ap9.e(zza, iObjectWrapper2);
            Parcel zzB = zzB(3, zza);
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
            zzB.recycle();
            return asInterface;
        }
        return (IObjectWrapper) invokeLLIL.objValue;
    }
}
