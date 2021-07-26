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
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class d implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f32958a;

        /* renamed from: b  reason: collision with root package name */
        public final LinkedBlockingQueue<IBinder> f32959b;

        public a() {
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
            this.f32958a = false;
            this.f32959b = new LinkedBlockingQueue<>();
        }

        public IBinder a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.f32958a) {
                    throw new IllegalStateException();
                }
                this.f32958a = true;
                return this.f32959b.poll(5L, TimeUnit.SECONDS);
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName, iBinder) == null) {
                try {
                    this.f32959b.put(iBinder);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, componentName) == null) {
            }
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.fun.openid.sdk.f
    public void a(Context context, f.a aVar) {
        IBinder a2;
        Parcel obtain;
        Parcel obtain2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, aVar) == null) {
            a aVar2 = new a();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (!context.bindService(intent, aVar2, 1)) {
                    ((e.a) aVar).a(false, null);
                    return;
                }
                try {
                    a2 = aVar2.a();
                    obtain = Parcel.obtain();
                    obtain2 = Parcel.obtain();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    ((e.a) aVar).a(true, null);
                }
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    a2.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    ((e.a) aVar).a(true, obtain2.readString());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            } finally {
                context.unbindService(aVar2);
            }
        }
    }
}
