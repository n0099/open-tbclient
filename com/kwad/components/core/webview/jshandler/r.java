package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class r implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c> a;

    /* loaded from: classes5.dex */
    public static class a extends com.kwad.sdk.core.download.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                r.b(this.a, 3, (i * 1.0f) / 100.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                r.b(this.a, 1, 0.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                r.b(this.a, 5, 1.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                r.b(this.a, 1, 0.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                r.b(this.a, 6, 1.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                r.b(this.a, 2, (i * 1.0f) / 100.0f);
            }
        }
    }

    @KsJson
    /* loaded from: classes5.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        public b() {
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
            this.a = -1L;
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwad.sdk.core.webview.kwai.c a;
        public com.kwad.components.core.c.a.b b;
        public AdTemplate c;
        public a d;

        public c(com.kwad.components.core.c.a.b bVar, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, adTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bVar;
            this.c = adTemplate;
        }

        public final void a() {
            com.kwad.components.core.c.a.b bVar;
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.b) == null || (aVar = this.d) == null) {
                return;
            }
            bVar.b(aVar);
        }

        public final void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                this.b.a(aVar);
                this.d = aVar;
            }
        }

        public final long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                AdTemplate adTemplate = this.c;
                if (adTemplate == null) {
                    return -1L;
                }
                return com.kwad.sdk.core.response.a.d.t(adTemplate);
            }
            return invokeV.longValue;
        }
    }

    public r(List<AdTemplate> list, List<com.kwad.components.core.c.a.b> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.a.add(new c(list2.get(i3), list.get(i3)));
        }
    }

    private c a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65537, this, j)) == null) {
            if (j == -1) {
                return null;
            }
            for (c cVar : this.a) {
                if (cVar.b() == j) {
                    return cVar;
                }
            }
            return null;
        }
        return (c) invokeJ.objValue;
    }

    public static void b(c cVar, int i, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{cVar, Integer.valueOf(i), Float.valueOf(f)}) == null) || cVar == null || cVar.a == null) {
            return;
        }
        com.kwad.sdk.core.d.b.a("MultiProgressListener", "notifyDownloadProgress: " + cVar.a + f);
        com.kwad.sdk.core.webview.kwai.c cVar2 = cVar.a;
        z.a aVar = new z.a();
        aVar.a = f;
        aVar.b = i;
        aVar.d = cVar.b();
        aVar.c = com.kwad.sdk.core.response.a.d.i(cVar.c).totalBytes;
        cVar2.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerMultiProgressListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) || str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            bVar.parseJson(jSONObject);
            c a2 = a(bVar.a);
            if (a2 != null) {
                a2.a = cVar;
                a2.a(new a(a2));
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c cVar : this.a) {
                cVar.a();
            }
        }
    }
}
