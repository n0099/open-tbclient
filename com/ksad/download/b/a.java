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
import com.ksad.download.d;
import com.kwad.sdk.h.c;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f38775b;

    /* renamed from: c  reason: collision with root package name */
    public Service f38776c;

    /* renamed from: d  reason: collision with root package name */
    public final HandlerC1938a f38777d;

    /* renamed from: com.ksad.download.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC1938a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<a> a;

        public HandlerC1938a(a aVar) {
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
        public void handleMessage(Message message) {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (aVar = this.a.get()) != null && message.what == 1) {
                if (aVar.a == null || !aVar.a.d()) {
                    sendEmptyMessageDelayed(1, 30000L);
                } else {
                    aVar.f38776c.stopSelf();
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
        this.f38775b = new ConcurrentHashMap();
        this.f38777d = new HandlerC1938a(this);
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
            Integer num = this.f38775b.get(stringExtra);
            if (intExtra == 1) {
                this.f38775b.put(stringExtra, Integer.valueOf(this.a.a(downloadRequest, (com.ksad.download.c) null)));
            } else if (intExtra == 2) {
                this.a.d(num.intValue());
            } else if (intExtra == 3) {
                this.a.e(num.intValue());
            } else if (intExtra == 4) {
                this.a.c(num.intValue());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, service) == null) || service == null) {
            return;
        }
        this.f38776c = service;
        this.a = d.a();
        this.f38777d.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.h.c, com.kwad.sdk.api.proxy.IServiceProxy
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
