package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class u implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c> mHolders;

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.core.download.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c Mz;

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
            this.Mz = cVar;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                u.a(this.Mz, 1, 0.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                u.a(this.Mz, 5, 1.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                u.a(this.Mz, 1, 0.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                u.a(this.Mz, 6, 1.0f);
            }
        }

        @Override // com.kwad.sdk.core.download.kwai.a
        public final void onPaused(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                u.a(this.Mz, 3, (i * 1.0f) / 100.0f);
            }
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                u.a(this.Mz, 2, (i * 1.0f) / 100.0f);
            }
        }
    }

    @KsJson
    /* loaded from: classes7.dex */
    public static class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long creativeId;

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
            this.creativeId = -1L;
        }
    }

    /* loaded from: classes7.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public com.kwad.components.core.c.a.c MA;
        public a MB;
        public com.kwad.sdk.core.webview.kwai.c kr;
        public AdTemplate mAdTemplate;

        public c(com.kwad.components.core.c.a.c cVar, AdTemplate adTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, adTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.MA = cVar;
            this.mAdTemplate = adTemplate;
        }

        public final void a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.MA.b(aVar);
                this.MB = aVar;
            }
        }

        public final void destroy() {
            com.kwad.components.core.c.a.c cVar;
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (cVar = this.MA) == null || (aVar = this.MB) == null) {
                return;
            }
            cVar.c(aVar);
        }

        public final long pv() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                AdTemplate adTemplate = this.mAdTemplate;
                if (adTemplate == null) {
                    return -1L;
                }
                return com.kwad.sdk.core.response.a.d.ca(adTemplate);
            }
            return invokeV.longValue;
        }
    }

    public u(List<AdTemplate> list, List<com.kwad.components.core.c.a.c> list2) {
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
        this.mHolders = new ArrayList();
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mHolders.add(new c(list2.get(i3), list.get(i3)));
        }
    }

    public static void a(c cVar, int i, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{cVar, Integer.valueOf(i), Float.valueOf(f)}) == null) || cVar == null || cVar.kr == null) {
            return;
        }
        com.kwad.sdk.core.e.b.d("MultiProgressListener", "notifyDownloadProgress: " + cVar.kr + f);
        com.kwad.sdk.core.webview.kwai.c cVar2 = cVar.kr;
        ac.a aVar = new ac.a();
        aVar.MO = f;
        aVar.status = i;
        aVar.creativeId = cVar.pv();
        aVar.totalBytes = com.kwad.sdk.core.response.a.d.bQ(cVar.mAdTemplate).totalBytes;
        cVar2.a(aVar);
    }

    private c t(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65539, this, j)) == null) {
            if (j == -1) {
                return null;
            }
            for (c cVar : this.mHolders) {
                if (cVar.pv() == j) {
                    return cVar;
                }
            }
            return null;
        }
        return (c) invokeJ.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) || str == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            bVar.parseJson(jSONObject);
            c t = t(bVar.creativeId);
            if (t != null) {
                t.kr = cVar;
                t.a(new a(t));
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "registerMultiProgressListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            for (c cVar : this.mHolders) {
                cVar.destroy();
            }
        }
    }
}
