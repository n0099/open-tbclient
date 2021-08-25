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
import com.kwad.sdk.core.f.b.f;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f71560a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f71561b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f71562c;

    public j(Context context) {
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
        this.f71561b = new LinkedBlockingQueue<>(1);
        this.f71562c = new ServiceConnection(this) { // from class: com.kwad.sdk.core.f.a.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f71563a;

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
                this.f71563a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    try {
                        com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "onServiceConnected");
                        this.f71563a.f71561b.put(iBinder);
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
        this.f71560a = context;
    }

    public String a() {
        InterceptResult invokeV;
        Context context;
        ServiceConnection serviceConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            try {
                Intent intent = new Intent();
                intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
                intent.setAction("com.bun.msa.action.bindto.service");
                intent.putExtra("com.bun.msa.param.pkgname", this.f71560a.getPackageName());
                boolean bindService = this.f71560a.bindService(intent, this.f71562c, 1);
                com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID isBind=" + bindService);
                if (bindService) {
                    try {
                        str = new f.a(this.f71561b.take()).a();
                        com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID oaid:" + str);
                        context = this.f71560a;
                        serviceConnection = this.f71562c;
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        context = this.f71560a;
                        serviceConnection = this.f71562c;
                    }
                    context.unbindService(serviceConnection);
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID hw service not found");
                com.kwad.sdk.core.d.a.a(e3);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
