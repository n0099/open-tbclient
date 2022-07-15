package com.kwad.components.ad.e.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class c extends com.kwad.components.ad.e.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Integer> c;
    public volatile boolean d;

    public c() {
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
        this.d = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, this, j) == null) {
            int ceil = (int) Math.ceil(((float) j) / 1000.0f);
            List<Integer> list = this.c;
            if (list == null || list.isEmpty()) {
                return;
            }
            for (Integer num : this.c) {
                if (ceil >= num.intValue()) {
                    com.kwad.sdk.core.report.a.b(((com.kwad.components.ad.e.kwai.a) this).a.d, ceil, (JSONObject) null);
                    this.c.remove(num);
                    return;
                }
            }
        }
    }

    @Override // com.kwad.components.ad.e.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.a();
            this.c = com.kwad.sdk.core.response.a.a.Z(com.kwad.sdk.core.response.a.d.i(((com.kwad.components.ad.e.kwai.a) this).a.d));
            com.kwad.components.core.video.h hVar = new com.kwad.components.core.video.h(this) { // from class: com.kwad.components.ad.e.a.c.1
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = this;
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void a(long j, long j2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
                        this.a.a(j2);
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void b() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.d) {
                        return;
                    }
                    this.a.d = true;
                    com.kwad.components.core.i.a.a().a(((com.kwad.components.ad.e.kwai.a) this.a).a.d, System.currentTimeMillis(), 1);
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void c() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.a.d = false;
                        if (!((com.kwad.components.ad.e.kwai.a) this.a).a.d.mPvReported) {
                            ((com.kwad.components.ad.e.kwai.a) this.a).a.a.a();
                        }
                        com.kwad.components.core.l.c.a().a(((com.kwad.components.ad.e.kwai.a) this.a).a.d, null, null);
                        com.kwad.sdk.core.report.a.h(((com.kwad.components.ad.e.kwai.a) this.a).a.d);
                    }
                }

                @Override // com.kwad.components.core.video.h, com.kwad.components.core.video.g
                public final void d() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                        com.kwad.sdk.core.report.a.i(((com.kwad.components.ad.e.kwai.a) this.a).a.d);
                    }
                }
            };
            ((com.kwad.components.ad.e.kwai.a) this).b = hVar;
            ((com.kwad.components.ad.e.kwai.a) this).a.f.a(hVar);
        }
    }
}
