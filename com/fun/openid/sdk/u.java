package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.t;
import com.fun.openid.sdk.v;
import com.zui.deviceidservice.IDeviceidInterface;
/* loaded from: classes4.dex */
public class u implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ v a;

    public u(v vVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = vVar;
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        t c0272a;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
            synchronized (this) {
                v vVar = this.a;
                int i = t.a.a;
                if (iBinder == null) {
                    c0272a = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface(IDeviceidInterface.Stub.DESCRIPTOR);
                    c0272a = (queryLocalInterface == null || !(queryLocalInterface instanceof t)) ? new t.a.C0272a(iBinder) : (t) queryLocalInterface;
                }
                vVar.b = c0272a;
                v vVar2 = this.a;
                v.a aVar = vVar2.d;
                if (aVar != null) {
                    aVar.a("Deviceid Service Connected", vVar2);
                }
                this.a.getClass();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
            this.a.b = null;
        }
    }
}
