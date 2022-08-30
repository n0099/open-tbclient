package com.kwai.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.webkit.WebView;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwad.sdk.utils.an;
import java.lang.ref.WeakReference;
@KsAdSdkDynamicImpl(FileDownloadService.class)
@Keep
@SuppressLint({"Registered"})
/* loaded from: classes7.dex */
public class FileDownloadServiceProxy extends com.kwad.sdk.g.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "filedownloader";
    public transient /* synthetic */ FieldHolder $fh;
    public Service context;
    public i handler;

    @KsAdSdkDynamicImpl(FileDownloadService.SeparateProcessService.class)
    @Keep
    /* loaded from: classes7.dex */
    public static class SeparateProcessServiceProxy extends FileDownloadServiceProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SeparateProcessServiceProxy() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwai.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, service) == null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        WebView.setDataDirectorySuffix(an.getProcessName(service.getApplicationContext()));
                    } catch (Exception unused) {
                    }
                }
                super.onCreate(service);
            }
        }
    }

    @KsAdSdkDynamicImpl(FileDownloadService.SharedMainProcessService.class)
    @Keep
    /* loaded from: classes7.dex */
    public static class SharedMainProcessServiceProxy extends FileDownloadServiceProxy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public SharedMainProcessServiceProxy() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.kwai.filedownloader.services.FileDownloadServiceProxy, com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
        public void onCreate(Service service) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, service) == null) {
                super.onCreate(service);
            }
        }
    }

    public FileDownloadServiceProxy() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
    public IBinder onBind(Service service, Intent intent) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, service, intent)) == null) ? this.handler.ED() : (IBinder) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onCreate(Service service) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, service) == null) || service == null) {
            return;
        }
        this.context = service;
        com.kwai.filedownloader.e.c.D(service);
        try {
            com.kwai.filedownloader.e.f.cF(com.kwai.filedownloader.e.e.EL().awM);
            com.kwai.filedownloader.e.f.ac(com.kwai.filedownloader.e.e.EL().awN);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        g gVar = new g();
        this.handler = com.kwai.filedownloader.e.e.EL().awP ? new e(new WeakReference(this), gVar) : new d(new WeakReference(this), gVar);
    }

    @Override // com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
    public void onDestroy(Service service) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, service) == null) {
            this.handler.onDestroy();
        }
    }

    @Override // com.kwad.sdk.g.a, com.kwad.sdk.api.proxy.IServiceProxy
    public int onStartCommand(Service service, Intent intent, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(1048579, this, service, intent, i, i2)) == null) {
            this.handler.EC();
            return 1;
        }
        return invokeLLII.intValue;
    }
}
