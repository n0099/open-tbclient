package com.kwad.components.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.kwad.components.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0456a {
        void a(com.kwad.sdk.e.kwai.b bVar);

        void b(com.kwad.sdk.e.kwai.b bVar);

        void c(com.kwad.sdk.e.kwai.b bVar);
    }

    public static void a(Context context, com.kwad.sdk.e.kwai.b bVar, @NonNull InterfaceC0456a interfaceC0456a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, context, bVar, interfaceC0456a) == null) {
            com.kwad.sdk.core.d.b.a("HybridDownloader", "reportHybrid: download+++url " + bVar.e);
            interfaceC0456a.a(bVar);
            bVar.a(System.currentTimeMillis());
            com.kwad.components.a.b.b.a(bVar, 1);
            r.a(context);
            r.a();
            r.a(bVar.e).a(bVar).a(bVar.c).a((i) new m(interfaceC0456a, bVar) { // from class: com.kwad.components.a.a.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ InterfaceC0456a a;
                public final /* synthetic */ com.kwad.sdk.e.kwai.b b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {interfaceC0456a, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = interfaceC0456a;
                    this.b = bVar;
                }

                @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
                public final void a(com.kwai.filedownloader.a aVar, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar, th) == null) {
                        super.a(aVar, th);
                        com.kwad.components.a.b.b.a(this.b, 0, 1, th.getMessage());
                        this.a.c((com.kwad.sdk.e.kwai.b) aVar.z());
                    }
                }

                @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
                public final void c(com.kwai.filedownloader.a aVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                        super.c(aVar);
                        if (aVar.v() == -3) {
                            this.a.b(this.b);
                            return;
                        }
                        this.a.c(this.b);
                        com.kwad.sdk.e.kwai.b bVar2 = this.b;
                        com.kwad.components.a.b.b.a(bVar2, 0, 1, "task.getStatus()=" + ((int) aVar.v()));
                    }
                }
            }).e();
        }
    }
}
