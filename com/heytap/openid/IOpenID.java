package com.heytap.openid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface IOpenID extends IInterface {

    /* loaded from: classes7.dex */
    public class Default implements IOpenID {
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

        @Override // com.heytap.openid.IOpenID
        public native String getSerID(String str, String str2, String str3);
    }

    /* loaded from: classes7.dex */
    public abstract class Stub extends Binder implements IOpenID {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.heytap.openid.IOpenID";
        public static final int TRANSACTION_getSerID = 1;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class Proxy implements IOpenID {
            public static /* synthetic */ Interceptable $ic;
            public static IOpenID sDefaultImpl;
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

            public native String getInterfaceDescriptor();

            @Override // com.heytap.openid.IOpenID
            public native String getSerID(String str, String str2, String str3);
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

        public static native IOpenID asInterface(IBinder iBinder);

        public static native IOpenID getDefaultImpl();

        public static native boolean setDefaultImpl(IOpenID iOpenID);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getSerID(String str, String str2, String str3);
}
