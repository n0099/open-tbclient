package com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface IDeviceIdManager extends IInterface {

    /* loaded from: classes7.dex */
    public static abstract class a extends Binder implements IDeviceIdManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.coolpad.deviceidsupport.IDeviceIdManager$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static class C0508a implements IDeviceIdManager {
            public static /* synthetic */ Interceptable $ic;
            public static IDeviceIdManager b;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder a;

            public C0508a(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (IBinder) invokeV.objValue;
            }

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public String getAAID(String str) {
                InterceptResult invokeL;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        if (this.a.transact(4, obtain, obtain2, 0) || a.a() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = a.a().getAAID(str);
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public String getCoolOsVersion() {
                InterceptResult invokeV;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                        if (this.a.transact(7, obtain, obtain2, 0) || a.a() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = a.a().getCoolOsVersion();
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public String getIMEI(String str) {
                InterceptResult invokeL;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        if (this.a.transact(5, obtain, obtain2, 0) || a.a() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = a.a().getIMEI(str);
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public String getOAID(String str) {
                InterceptResult invokeL;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        if (this.a.transact(2, obtain, obtain2, 0) || a.a() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = a.a().getOAID(str);
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public String getUDID(String str) {
                InterceptResult invokeL;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        if (this.a.transact(1, obtain, obtain2, 0) || a.a() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = a.a().getUDID(str);
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public String getVAID(String str) {
                InterceptResult invokeL;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                        obtain.writeString(str);
                        if (this.a.transact(3, obtain, obtain2, 0) || a.a() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = a.a().getVAID(str);
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeL.objValue;
            }

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public boolean isCoolOs() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                        if (this.a.transact(6, obtain, obtain2, 0) || a.a() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return a.a().isCoolOs();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }
        }

        public static IDeviceIdManager a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? C0508a.b : (IDeviceIdManager) invokeV.objValue;
        }

        public static IDeviceIdManager a(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof IDeviceIdManager)) ? new C0508a(iBinder) : (IDeviceIdManager) queryLocalInterface;
            }
            return (IDeviceIdManager) invokeL.objValue;
        }
    }

    String getAAID(String str);

    String getCoolOsVersion();

    String getIMEI(String str);

    String getOAID(String str);

    String getUDID(String str);

    String getVAID(String str);

    boolean isCoolOs();
}
