package com.ksad.download.b;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.download.DownloadTask;
import com.ksad.download.c;
import com.ksad.download.d;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class a extends com.kwad.sdk.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;
    public final Map<String, Integer> b;
    public Service c;
    public final HandlerC0286a d;

    /* renamed from: com.ksad.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class HandlerC0286a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<a> a;

        public HandlerC0286a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (aVar = this.a.get()) != null && message.what == 1) {
                if (aVar.a == null || !aVar.a.b()) {
                    sendEmptyMessageDelayed(1, 30000L);
                } else {
                    aVar.c.stopSelf();
                }
            }
        }
    }

    public a() {
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
        this.b = new ConcurrentHashMap();
        this.d = new HandlerC0286a(this);
    }

    private void a(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, this, intent) == null) || intent == null) {
            return;
        }
        try {
            int intExtra = intent.getIntExtra("download_service_type_tag", 0);
            String stringExtra = intent.getStringExtra("download_service_id_tag");
            DownloadTask.DownloadRequest downloadRequest = (DownloadTask.DownloadRequest) intent.getSerializableExtra("download_service_args_tag");
            Integer num = this.b.get(stringExtra);
            if (intExtra == 1) {
                this.b.put(stringExtra, Integer.valueOf(this.a.a(downloadRequest, (c) null)));
            } else if (intExtra == 2) {
                this.a.c(num.intValue());
            } else if (intExtra == 3) {
                this.a.d(num.intValue());
            } else if (intExtra != 4) {
            } else {
                this.a.b(num.intValue());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, service) == null) || service == null) {
            return;
        }
        this.c = service;
        this.a = d.a();
        this.d.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.h.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, service, intent, i, i2)) == null) {
            a(intent);
            return super.onStartCommand(service, intent, i, i2);
        }
        return invokeLLII.intValue;
    }
}
