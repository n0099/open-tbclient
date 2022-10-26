package com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface IDeviceIdManager extends IInterface {

    /* loaded from: classes7.dex */
    public class Default implements IDeviceIdManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Default() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        public native String getAAID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        public native String getCoolOsVersion();

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        public native String getIMEI(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        public native String getOAID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        public native String getUDID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        public native String getVAID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        public native boolean isCoolOs();
    }

    /* loaded from: classes7.dex */
    public abstract class Stub extends Binder implements IDeviceIdManager {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        public static final int TRANSACTION_getAAID = 4;
        public static final int TRANSACTION_getCoolOsVersion = 7;
        public static final int TRANSACTION_getIMEI = 5;
        public static final int TRANSACTION_getOAID = 2;
        public static final int TRANSACTION_getUDID = 1;
        public static final int TRANSACTION_getVAID = 3;
        public static final int TRANSACTION_isCoolOs = 6;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class Proxy implements IDeviceIdManager {
            public static /* synthetic */ Interceptable $ic;
            public static IDeviceIdManager sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
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
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public native String getAAID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public native String getCoolOsVersion();

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public native String getIMEI(String str);

            public native String getInterfaceDescriptor();

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public native String getOAID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public native String getUDID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public native String getVAID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            public native boolean isCoolOs();
        }

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
            attachInterface(this, DESCRIPTOR);
        }

        public static native IDeviceIdManager asInterface(IBinder iBinder);

        public static native IDeviceIdManager getDefaultImpl();

        public static native boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID(String str);

    String getCoolOsVersion();

    String getIMEI(String str);

    String getOAID(String str);

    String getUDID(String str);

    String getVAID(String str);

    boolean isCoolOs();
}
