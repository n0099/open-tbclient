package com.kwad.components.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0304a {
        void c(com.kwad.sdk.e.kwai.b bVar);

        void d(com.kwad.sdk.e.kwai.b bVar);

        void e(com.kwad.sdk.e.kwai.b bVar);
    }

    public static void a(Context context, com.kwad.sdk.e.kwai.b bVar, @NonNull InterfaceC0304a interfaceC0304a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, context, bVar, interfaceC0304a) == null) {
            com.kwad.sdk.core.e.b.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
            interfaceC0304a.c(bVar);
            bVar.N(System.currentTimeMillis());
            com.kwad.components.a.b.b.a(bVar, 1);
            r.dD(context);
            r.CZ();
            r.eq(bVar.packageUrl).g(bVar).en(bVar.aiv).bz(true).a(new m(interfaceC0304a, bVar) { // from class: com.kwad.components.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.e.kwai.b PP;
                public final /* synthetic */ InterfaceC0304a Qa;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {interfaceC0304a, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.Qa = interfaceC0304a;
                    this.PP = bVar;
                }

                @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
                public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, th) == null) {
                        super.a(aVar, th);
                        com.kwad.components.a.b.b.a(this.PP, 0, 1, th.getMessage());
                        this.Qa.e((com.kwad.sdk.e.kwai.b) aVar.getTag());
                    }
                }

                @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
                public final void c(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        super.c(aVar);
                        if (aVar.Ca() == -3) {
                            this.Qa.d(this.PP);
                            return;
                        }
                        this.Qa.e(this.PP);
                        com.kwad.sdk.e.kwai.b bVar2 = this.PP;
                        com.kwad.components.a.b.b.a(bVar2, 0, 1, "task.getStatus()=" + ((int) aVar.Ca()));
                    }
                }
            }).start();
        }
    }
}
