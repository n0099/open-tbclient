package com.coolpad.deviceidsupport;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public interface IDeviceIdManager extends IInterface {

    @Keep
    /* loaded from: classes8.dex */
    public static class Default implements IDeviceIdManager {
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
        @Keep
        public native IBinder asBinder();

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        @Keep
        public native String getAAID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        @Keep
        public native String getCoolOsVersion();

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        @Keep
        public native String getIMEI(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        @Keep
        public native String getOAID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        @Keep
        public native String getUDID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        @Keep
        public native String getVAID(String str);

        @Override // com.coolpad.deviceidsupport.IDeviceIdManager
        @Keep
        public native boolean isCoolOs();
    }

    @Keep
    /* loaded from: classes8.dex */
    public static abstract class Stub extends Binder implements IDeviceIdManager {
        public static /* synthetic */ Interceptable $ic = null;
        @Keep
        public static final String DESCRIPTOR = "com.coolpad.deviceidsupport.IDeviceIdManager";
        @Keep
        public static final int TRANSACTION_getAAID = 4;
        @Keep
        public static final int TRANSACTION_getCoolOsVersion = 7;
        @Keep
        public static final int TRANSACTION_getIMEI = 5;
        @Keep
        public static final int TRANSACTION_getOAID = 2;
        @Keep
        public static final int TRANSACTION_getUDID = 1;
        @Keep
        public static final int TRANSACTION_getVAID = 3;
        @Keep
        public static final int TRANSACTION_isCoolOs = 6;
        public transient /* synthetic */ FieldHolder $fh;

        @Keep
        /* loaded from: classes8.dex */
        public static class Proxy implements IDeviceIdManager {
            public static /* synthetic */ Interceptable $ic;
            @Keep
            public static IDeviceIdManager sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            @Keep
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
            @Keep
            public native IBinder asBinder();

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            @Keep
            public native String getAAID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            @Keep
            public native String getCoolOsVersion();

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            @Keep
            public native String getIMEI(String str);

            @Keep
            public native String getInterfaceDescriptor();

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            @Keep
            public native String getOAID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            @Keep
            public native String getUDID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            @Keep
            public native String getVAID(String str);

            @Override // com.coolpad.deviceidsupport.IDeviceIdManager
            @Keep
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

        @Keep
        public static native IDeviceIdManager asInterface(IBinder iBinder);

        @Keep
        public static native IDeviceIdManager getDefaultImpl();

        @Keep
        public static native boolean setDefaultImpl(IDeviceIdManager iDeviceIdManager);

        @Override // android.os.IInterface
        @Keep
        public native IBinder asBinder();

        @Override // android.os.Binder
        @Keep
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    @Keep
    String getAAID(String str);

    @Keep
    String getCoolOsVersion();

    @Keep
    String getIMEI(String str);

    @Keep
    String getOAID(String str);

    @Keep
    String getUDID(String str);

    @Keep
    String getVAID(String str);

    @Keep
    boolean isCoolOs();
}
