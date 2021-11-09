package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.f.b.b;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f64543a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f64544b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f64545c;

    public b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64544b = new LinkedBlockingQueue<>(1);
        this.f64545c = new ServiceConnection(this) { // from class: com.kwad.sdk.core.f.a.b.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f64546a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f64546a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    try {
                        com.kwad.sdk.core.d.a.c("HWDeviceIDHelper", "onServiceConnected");
                        this.f64546a.f64544b.put(iBinder);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                }
            }
        };
        this.f64543a = context;
    }

    public String a() {
        InterceptResult invokeV;
        Context context;
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            try {
                Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
                intent.setPackage("com.huawei.hwid");
                if (this.f64543a.bindService(intent, this.f64545c, 1)) {
                    try {
                        b.a aVar = new b.a(this.f64544b.take());
                        str = aVar.a();
                        boolean b2 = aVar.b();
                        com.kwad.sdk.core.d.a.c("HWDeviceIDHelper", "getOAID oaid:" + str + "--boos:" + b2);
                        context = this.f64543a;
                        serviceConnection = this.f64545c;
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        context = this.f64543a;
                        serviceConnection = this.f64545c;
                    }
                    context.unbindService(serviceConnection);
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.c("HWDeviceIDHelper", "getOAID hw service not found");
                com.kwad.sdk.core.d.a.b(e3);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
