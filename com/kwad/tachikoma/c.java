package com.kwad.tachikoma;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.tachikoma.api.TachikomaApi;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.api.core.ResContext;
import com.kwad.sdk.core.report.CommercialAction;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.plugin.g;
import com.kwad.sdk.utils.aq;
import com.kwad.tachikoma.config.TKConfigResultData;
import com.kwad.tachikoma.config.b;
import com.kwad.tachikoma.kwai.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes2.dex */
public class c extends g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TKConfigResultData a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f59814b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f59815c;

    public c() {
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
        this.f59814b = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, this, str) == null) {
            i.c("ad_client_error_log", new CommercialAction.TKDownloadMsg().setErrorReason(str).setDownloadState(2));
        }
    }

    private void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, context) == null) {
            i.c("ad_client_apm_log", new CommercialAction.TKDownloadMsg().setDownloadState(0));
            com.kwad.tachikoma.kwai.a.a(context, new a.InterfaceC2066a(this, context) { // from class: com.kwad.tachikoma.c.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ Context a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ c f59816b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f59816b = this;
                    this.a = context;
                }

                @Override // com.kwad.tachikoma.kwai.a.InterfaceC2066a
                public void a() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            com.kwad.a.b.a(this.a, "kwad-j2v8");
                            try {
                                com.kwad.a.b.a(this.a, "kwad-fb");
                                try {
                                    com.kwad.a.b.a(this.a, "kwad-yoga");
                                    this.f59816b.f59814b.set(true);
                                    com.kwai.sodler.lib.a.b("TachikomaPluginImpl", "loadSo success");
                                    this.f59816b.c(KsAdSDKImpl.get().getContext());
                                } catch (Throwable th) {
                                    c cVar = this.f59816b;
                                    cVar.a("kwad-yoga" + th.getMessage());
                                }
                            } catch (Throwable th2) {
                                com.kwai.sodler.lib.a.b("TachikomaPluginImpl", "loadSo fail:kwad-fb" + th2.getMessage());
                                c cVar2 = this.f59816b;
                                cVar2.a("kwad-fb" + th2.getMessage());
                            }
                        } catch (Throwable th3) {
                            com.kwai.sodler.lib.a.b("TachikomaPluginImpl", "loadSo fail:kwad-j2v8" + th3.getMessage());
                            c cVar3 = this.f59816b;
                            cVar3.a("kwad-j2v8" + th3.getMessage());
                        }
                    }
                }

                @Override // com.kwad.tachikoma.kwai.a.InterfaceC2066a
                public void a(int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                        this.f59816b.f59814b.set(false);
                        this.f59816b.a(String.valueOf(i2));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, context) == null) {
            if (context instanceof ResContext) {
                context = ((ResContext) context).getDelegatedContext();
            }
            TachikomaApi.getInstance().init((Application) context.getApplicationContext());
            TachikomaApi.getInstance().setInitResult(true);
            TachikomaApi.getInstance().setHostService(new b());
            i.c("ad_client_apm_log", new CommercialAction.TKDownloadMsg().setDownloadState(1));
        }
    }

    @Override // com.kwad.sdk.plugin.g
    public String a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) ? aq.e(context) : (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.plugin.d
    public synchronized void a(Context context, SdkConfig sdkConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, sdkConfig) == null) {
            synchronized (this) {
                if (context == null) {
                    return;
                }
                if (this.f59815c) {
                    this.f59815c = true;
                    return;
                }
                com.kwad.tachikoma.config.b.a(context, new b.a(this) { // from class: com.kwad.tachikoma.c.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ c a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.kwad.tachikoma.config.b.a
                    public void a(TKConfigResultData tKConfigResultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, tKConfigResultData) == null) {
                            this.a.a = tKConfigResultData;
                        }
                    }

                    @Override // com.kwad.tachikoma.config.b.a
                    public void b(@NonNull TKConfigResultData tKConfigResultData) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tKConfigResultData) == null) {
                            this.a.a = tKConfigResultData;
                        }
                    }
                });
                b(context);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.plugin.g
    /* renamed from: b */
    public d a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, str)) == null) {
            d dVar = new d(context);
            dVar.setJsFileName(str);
            return dVar;
        }
        return (d) invokeLL.objValue;
    }

    @Override // com.kwad.sdk.plugin.g
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TKConfigResultData tKConfigResultData = this.a;
            boolean z = tKConfigResultData != null && tKConfigResultData.data.f59820e != -1 && com.kwad.tachikoma.config.b.b() && this.f59814b.get();
            com.kwai.sodler.lib.a.b("TachikomaPluginImpl", "Tachikoma isReady:" + z + ", sIsTkSoLoaded:" + this.f59814b + ",loadFinish:" + com.kwad.tachikoma.config.b.b());
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.kwad.sdk.plugin.g
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            com.kwad.tachikoma.config.b.c();
        }
    }

    @Override // com.kwad.sdk.plugin.g
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? com.kwad.tachikoma.config.b.a() != null ? com.kwad.tachikoma.config.b.a().data.f59817b : "0.0.1" : (String) invokeV.objValue;
    }
}
