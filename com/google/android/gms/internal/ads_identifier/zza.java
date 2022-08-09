package com.google.android.gms.internal.ads_identifier;

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
/* loaded from: classes5.dex */
public class zza implements IInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final IBinder zza;
    public final String zzb;

    public zza(IBinder iBinder, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iBinder, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zza = iBinder;
        this.zzb = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.zza : (IBinder) invokeV.objValue;
    }

    public final Parcel zza() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Parcel obtain = Parcel.obtain();
            obtain.writeInterfaceToken(this.zzb);
            return obtain;
        }
        return (Parcel) invokeV.objValue;
    }

    public final Parcel zzb(int i, Parcel parcel) throws RemoteException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, parcel)) == null) {
            Parcel obtain = Parcel.obtain();
            try {
                try {
                    this.zza.transact(i, parcel, obtain, 0);
                    obtain.readException();
                    return obtain;
                } catch (RuntimeException e) {
                    obtain.recycle();
                    throw e;
                }
            } finally {
                parcel.recycle();
            }
        }
        return (Parcel) invokeIL.objValue;
    }
}
