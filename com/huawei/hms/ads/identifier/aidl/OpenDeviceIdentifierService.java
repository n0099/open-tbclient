package com.huawei.hms.ads.identifier.aidl;

import android.os.IBinder;
import android.os.IInterface;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface OpenDeviceIdentifierService extends IInterface {

    /* loaded from: classes7.dex */
    public abstract class Stub {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
        public static final int TRANSACTION_GETOAID = 1;
        public static final int TRANSACTION_ISOAIDTRACKLIMITED = 2;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class Proxy implements OpenDeviceIdentifierService {
            public static /* synthetic */ Interceptable $ic;
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

            @Override // com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService
            public native String getOaid();

            @Override // com.huawei.hms.ads.identifier.aidl.OpenDeviceIdentifierService
            public native boolean isOaidTrackLimited();
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
                }
            }
        }

        public static native OpenDeviceIdentifierService asInterface(IBinder iBinder);
    }

    String getOaid();

    boolean isOaidTrackLimited();
}
