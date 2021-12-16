package com.kwad.sdk.c;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.c.a.b;
import com.kwad.sdk.c.kwai.f;
import com.kwai.filedownloader.i;
import com.kwai.filedownloader.m;
import com.kwai.filedownloader.r;
/* loaded from: classes3.dex */
public class a implements com.kwad.sdk.c.a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

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
        this.a = context;
    }

    @Override // com.kwad.sdk.c.a.b
    public void a(com.kwad.sdk.c.kwai.d dVar, b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, dVar, aVar) == null) {
            com.kwad.sdk.c.b.b.a(dVar, 1);
            String d2 = dVar.d();
            String c2 = new f(d2).c();
            if (c2 == null) {
                return;
            }
            dVar.d(c2.substring(0, c2.indexOf(".zip")));
            String b2 = com.kwad.sdk.c.b.a.b(this.a, dVar.f());
            dVar.c(b2);
            r.a().a(d2).a(dVar).a(b2).a((i) new m(this, aVar, dVar) { // from class: com.kwad.sdk.c.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ b.a a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ com.kwad.sdk.c.kwai.d f57629b;

                /* renamed from: c  reason: collision with root package name */
                public final /* synthetic */ a f57630c;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar, dVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f57630c = this;
                    this.a = aVar;
                    this.f57629b = dVar;
                }

                @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
                public void a(com.kwai.filedownloader.a aVar2, Throwable th) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(1048576, this, aVar2, th) == null) {
                        super.a(aVar2, th);
                        com.kwad.sdk.c.b.b.a(this.f57629b, 1, th.getMessage());
                        b.a aVar3 = this.a;
                        if (aVar3 != null) {
                            aVar3.b((com.kwad.sdk.c.kwai.d) aVar2.z());
                        }
                    }
                }

                @Override // com.kwai.filedownloader.m, com.kwai.filedownloader.i
                public void c(com.kwai.filedownloader.a aVar2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar2) == null) {
                        super.c(aVar2);
                        if (this.a != null && aVar2.v() == -3) {
                            this.a.a((com.kwad.sdk.c.kwai.d) aVar2.z());
                            return;
                        }
                        b.a aVar3 = this.a;
                        if (aVar3 != null) {
                            aVar3.b((com.kwad.sdk.c.kwai.d) aVar2.z());
                            com.kwad.sdk.c.kwai.d dVar2 = this.f57629b;
                            com.kwad.sdk.c.b.b.a(dVar2, 1, "task.getStatus()=" + ((int) aVar2.v()));
                        }
                    }
                }
            }).e();
        }
    }
}
