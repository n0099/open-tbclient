package com.ksad.download.c;

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
import com.kwad.sdk.b.b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class a extends b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d f33537a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, Integer> f33538b;

    /* renamed from: c  reason: collision with root package name */
    public Service f33539c;

    /* renamed from: d  reason: collision with root package name */
    public final HandlerC0397a f33540d;

    /* renamed from: com.ksad.download.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class HandlerC0397a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<a> f33541a;

        public HandlerC0397a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33541a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && (aVar = this.f33541a.get()) != null && message.what == 1) {
                if (aVar.f33537a == null || !aVar.f33537a.d()) {
                    sendEmptyMessageDelayed(1, 30000L);
                } else {
                    aVar.f33539c.stopSelf();
                }
            }
        }
    }

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
        this.f33538b = new ConcurrentHashMap();
        this.f33540d = new HandlerC0397a(this);
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
            Integer num = this.f33538b.get(stringExtra);
            if (intExtra == 1) {
                this.f33538b.put(stringExtra, Integer.valueOf(this.f33537a.a(downloadRequest, (c) null)));
            } else if (intExtra == 2) {
                this.f33537a.d(num.intValue());
            } else if (intExtra == 3) {
                this.f33537a.e(num.intValue());
            } else if (intExtra == 4) {
                this.f33537a.c(num.intValue());
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, service) == null) || service == null) {
            return;
        }
        this.f33539c = service;
        this.f33537a = d.a();
        this.f33540d.sendEmptyMessageDelayed(1, 30000L);
    }

    @Override // com.kwad.sdk.b.b, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, service, intent, i2, i3)) == null) {
            a(intent);
            return super.onStartCommand(service, intent, i2, i3);
        }
        return invokeLLII.intValue;
    }
}
