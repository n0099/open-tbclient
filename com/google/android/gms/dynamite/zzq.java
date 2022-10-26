package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.dynamic.IObjectWrapper;
/* loaded from: classes7.dex */
public final class zzq extends com.google.android.gms.internal.common.zza implements IInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
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

    public final int zze() throws RemoteException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Parcel zzB = zzB(6, zza());
            int readInt = zzB.readInt();
            zzB.recycle();
            return readInt;
        }
        return invokeV.intValue;
    }

    public final int zzf(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iObjectWrapper, str, z)) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
            zza.writeString(str);
            com.google.android.gms.internal.common.zzc.zzb(zza, z);
            Parcel zzB = zzB(3, zza);
            int readInt = zzB.readInt();
            zzB.recycle();
            return readInt;
        }
        return invokeLLZ.intValue;
    }

    public final int zzg(IObjectWrapper iObjectWrapper, String str, boolean z) throws RemoteException {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, iObjectWrapper, str, z)) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
            zza.writeString(str);
            com.google.android.gms.internal.common.zzc.zzb(zza, z);
            Parcel zzB = zzB(5, zza);
            int readInt = zzB.readInt();
            zzB.recycle();
            return readInt;
        }
        return invokeLLZ.intValue;
    }

    public final IObjectWrapper zzh(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048579, this, iObjectWrapper, str, i)) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
            zza.writeString(str);
            zza.writeInt(i);
            Parcel zzB = zzB(2, zza);
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
            zzB.recycle();
            return asInterface;
        }
        return (IObjectWrapper) invokeLLI.objValue;
    }

    public final IObjectWrapper zzj(IObjectWrapper iObjectWrapper, String str, int i) throws RemoteException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048581, this, iObjectWrapper, str, i)) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
            zza.writeString(str);
            zza.writeInt(i);
            Parcel zzB = zzB(4, zza);
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
            zzB.recycle();
            return asInterface;
        }
        return (IObjectWrapper) invokeLLI.objValue;
    }

    public final IObjectWrapper zzi(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(1048580, this, iObjectWrapper, str, i, iObjectWrapper2)) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
            zza.writeString(str);
            zza.writeInt(i);
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper2);
            Parcel zzB = zzB(8, zza);
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
            zzB.recycle();
            return asInterface;
        }
        return (IObjectWrapper) invokeLLIL.objValue;
    }

    public final IObjectWrapper zzk(IObjectWrapper iObjectWrapper, String str, boolean z, long j) throws RemoteException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{iObjectWrapper, str, Boolean.valueOf(z), Long.valueOf(j)})) == null) {
            Parcel zza = zza();
            com.google.android.gms.internal.common.zzc.zze(zza, iObjectWrapper);
            zza.writeString(str);
            com.google.android.gms.internal.common.zzc.zzb(zza, z);
            zza.writeLong(j);
            Parcel zzB = zzB(7, zza);
            IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
            zzB.recycle();
            return asInterface;
        }
        return (IObjectWrapper) invokeCommon.objValue;
    }
}
