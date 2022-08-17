package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.an9;
/* loaded from: classes5.dex */
public interface IGmsServiceBroker extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Stub() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @NonNull
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, @NonNull Parcel parcel, @Nullable Parcel parcel2, int i2) throws RemoteException {
            InterceptResult invokeCommon;
            IGmsCallbacks zzaaVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), parcel, parcel2, Integer.valueOf(i2)})) == null) {
                if (i > 16777215) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaaVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                    zzaaVar = queryLocalInterface instanceof IGmsCallbacks ? (IGmsCallbacks) queryLocalInterface : new zzaa(readStrongBinder);
                }
                if (i == 46) {
                    getService(zzaaVar, parcel.readInt() != 0 ? GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
                    an9.d(parcel2);
                    parcel2.writeNoException();
                    return true;
                } else if (i == 47) {
                    if (parcel.readInt() != 0) {
                        zzaj.CREATOR.createFromParcel(parcel);
                    }
                    throw new UnsupportedOperationException();
                } else {
                    parcel.readInt();
                    if (i != 4) {
                        parcel.readString();
                        if (i != 1) {
                            if (i != 2 && i != 23 && i != 25 && i != 27) {
                                if (i != 30) {
                                    if (i == 34) {
                                        parcel.readString();
                                    } else if (i != 41 && i != 43 && i != 37 && i != 38) {
                                        switch (i) {
                                            case 9:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                parcel.readString();
                                                parcel.readStrongBinder();
                                                parcel.readString();
                                                if (parcel.readInt() != 0) {
                                                    Bundle bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                            case 10:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                break;
                                            case 19:
                                                parcel.readStrongBinder();
                                                if (parcel.readInt() != 0) {
                                                    Bundle bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                }
                                parcel.createStringArray();
                                parcel.readString();
                                if (parcel.readInt() != 0) {
                                    Bundle bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                                }
                            }
                            if (parcel.readInt() != 0) {
                                Bundle bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                        } else {
                            parcel.readString();
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                                Bundle bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                            }
                        }
                    }
                    throw new UnsupportedOperationException();
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    void getService(@NonNull IGmsCallbacks iGmsCallbacks, @Nullable GetServiceRequest getServiceRequest) throws RemoteException;
}
