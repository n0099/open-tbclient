package com.zui.deviceidservice;

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
/* loaded from: classes10.dex */
public interface IDeviceidInterface extends IInterface {

    @Keep
    /* loaded from: classes10.dex */
    public static abstract class Stub extends Binder implements IDeviceidInterface {
        public static /* synthetic */ Interceptable $ic = null;
        @Keep
        public static final String DESCRIPTOR = "com.zui.deviceidservice.IDeviceidInterface";
        @Keep
        public static final int TRANSACTION_createAAIDForPackageName = 6;
        @Keep
        public static final int TRANSACTION_getAAID = 5;
        @Keep
        public static final int TRANSACTION_getOAID = 1;
        @Keep
        public static final int TRANSACTION_getUDID = 2;
        @Keep
        public static final int TRANSACTION_getVAID = 4;
        @Keep
        public static final int TRANSACTION_isSupport = 3;
        public transient /* synthetic */ FieldHolder $fh;

        @Keep
        /* loaded from: classes10.dex */
        public static class Proxy implements IDeviceidInterface {
            public static /* synthetic */ Interceptable $ic;
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

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @Keep
            public native boolean createAAIDForPackageName(String str);

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @Keep
            public native String getAAID(String str);

            @Keep
            public native String getInterfaceDescriptor();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @Keep
            public native String getOAID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @Keep
            public native String getUDID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @Keep
            public native String getVAID(String str);

            @Override // com.zui.deviceidservice.IDeviceidInterface
            @Keep
            public native boolean isSupport();
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
        public static native IDeviceidInterface asInterface(IBinder iBinder);

        @Override // android.os.IInterface
        @Keep
        public native IBinder asBinder();

        @Override // android.os.Binder
        @Keep
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    @Keep
    boolean createAAIDForPackageName(String str);

    @Keep
    String getAAID(String str);

    @Keep
    String getOAID();

    @Keep
    String getUDID();

    @Keep
    String getVAID(String str);

    @Keep
    boolean isSupport();
}
