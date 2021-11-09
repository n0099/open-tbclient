package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.f.b.d;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes2.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f64553a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f64554b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f64555c;

    public f(Context context) {
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
        this.f64554b = new LinkedBlockingQueue<>(1);
        this.f64555c = new ServiceConnection(this) { // from class: com.kwad.sdk.core.f.a.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f64556a;

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
                this.f64556a = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(1048576, this, componentName, iBinder) == null) {
                    com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "onServiceConnected");
                    try {
                        this.f64556a.f64554b.put(iBinder);
                    } catch (InterruptedException e2) {
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
        this.f64553a = context;
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            try {
                Signature[] signatureArr = this.f64553a.getPackageManager().getPackageInfo(this.f64553a.getPackageName(), 64).signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    return null;
                }
                byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                }
                return sb.toString();
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
                return null;
            }
        }
        return (String) invokeV.objValue;
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
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                boolean bindService = this.f64553a.bindService(intent, this.f64555c, 1);
                com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID isBin=" + bindService);
                if (bindService) {
                    try {
                        str = new d.a(this.f64554b.take()).a(this.f64553a.getPackageName(), b(), "OUID");
                        com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID oaid" + str);
                        context = this.f64553a;
                        serviceConnection = this.f64555c;
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.a.a(e2);
                        context = this.f64553a;
                        serviceConnection = this.f64555c;
                    }
                    context.unbindService(serviceConnection);
                }
            } catch (Exception e3) {
                com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID service not found");
                com.kwad.sdk.core.d.a.b(e3);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }
}
