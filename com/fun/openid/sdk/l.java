package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.f;
import com.samsung.android.deviceidservice.IDeviceIdService;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class l implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final LinkedBlockingQueue<IBinder> a;

    /* renamed from: b  reason: collision with root package name */
    public ServiceConnection f38668b;

    /* loaded from: classes6.dex */
    public class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l a;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                try {
                    this.a.a.put(iBinder);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new LinkedBlockingQueue<>(1);
        this.f38668b = new a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
        if (com.fun.openid.sdk.FunOpenIDSdk.isLogEnabled() != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0029  */
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
                if (FunOpenIDSdk.isLogEnabled()) {
                    Log.e(FunOpenIDSdk.TAG, "===========当前设备不支持获取OAID");
                }
                aVar.a(false, null);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (context.bindService(intent, this.f38668b, 1)) {
                try {
                    IBinder take = this.a.take();
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    obtain.writeInterfaceToken(IDeviceIdService.Stub.DESCRIPTOR);
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
                        Log.e(FunOpenIDSdk.TAG, "===========获取OAID出错，需重试");
                    }
                    aVar.a(true, null);
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }
}
