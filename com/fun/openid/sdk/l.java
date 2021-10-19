package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes9.dex */
public class l implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f70389a;

    /* renamed from: b  reason: collision with root package name */
    public ServiceConnection f70390b;

    /* loaded from: classes9.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f70391a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70391a = lVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    this.f70391a.f70389a.put(iBinder);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            }
        }
    }

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70389a = new LinkedBlockingQueue<>(1);
        this.f70390b = new a(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    @Override // com.fun.openid.sdk.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, f.a aVar) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, context, aVar) != null) {
            return;
        }
        if (context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null) {
            z = true;
            if (z) {
                FunOpenIDSdk.isLogEnabled();
                aVar.a(false, null);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (context.bindService(intent, this.f70390b, 1)) {
                try {
                    IBinder take = this.f70389a.take();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    take.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    aVar.a(true, readString);
                    return;
                } catch (Exception e2) {
                    if (FunOpenIDSdk.isLogEnabled()) {
                        e2.printStackTrace();
                    }
                }
            } else {
                FunOpenIDSdk.isLogEnabled();
            }
            aVar.a(true, null);
            return;
        }
        z = false;
        if (z) {
        }
    }
}
