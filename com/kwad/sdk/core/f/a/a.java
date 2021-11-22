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
import com.kwad.sdk.core.f.b.a;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f65452a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f65453b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f65454c;

    public a(Context context) {
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
        this.f65453b = new LinkedBlockingQueue<>(1);
        this.f65454c = new ServiceConnection(this) { // from class: com.kwad.sdk.core.f.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f65455a;

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
                this.f65455a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    try {
                        this.f65455a.f65453b.put(iBinder);
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
        this.f65452a = context;
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
                intent.setAction("com.asus.msa.action.ACCESS_DID");
                intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
                if (this.f65452a.bindService(intent, this.f65454c, 1)) {
                    try {
                        str = new a.C1944a(this.f65453b.take()).a();
                        com.kwad.sdk.core.d.a.c("ASUSDeviceIDHelper", "getOAID oaid:" + str);
                        context = this.f65452a;
                        serviceConnection = this.f65454c;
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        context = this.f65452a;
                        serviceConnection = this.f65454c;
                    }
                    context.unbindService(serviceConnection);
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.c("ASUSDeviceIDHelper", "getOAID asus service not found;");
                com.kwad.sdk.core.d.a.a(e3);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
