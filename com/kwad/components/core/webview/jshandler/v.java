package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class v implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b mJsBridgeContext;

    @KsJson
    /* loaded from: classes8.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String Mw;

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
                }
            }
        }
    }

    @KsJson
    /* loaded from: classes8.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double MD;
        public int status;
        public long totalBytes;

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
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), cVar}) == null) || cVar == null) {
            return;
        }
        b bVar = new b();
        bVar.MD = f;
        bVar.status = i;
        bVar.totalBytes = com.kwad.sdk.core.response.a.d.bQ(this.mJsBridgeContext.getAdTemplate()).totalBytes;
        cVar.a(bVar);
    }

    private KsAppDownloadListener aE(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? new com.kwad.sdk.core.download.kwai.a(this, str) { // from class: com.kwad.components.core.webview.jshandler.v.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ v MC;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.MC = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.MC.mJsBridgeContext.age == null) {
                    return;
                }
                this.MC.a(1, 0.0f, this.MC.mJsBridgeContext.age.dL(mJ()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.MC.mJsBridgeContext.age == null) {
                    return;
                }
                this.MC.a(5, 1.0f, this.MC.mJsBridgeContext.age.dL(mJ()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.MC.mJsBridgeContext.age == null) {
                    return;
                }
                this.MC.a(1, 0.0f, this.MC.mJsBridgeContext.age.dL(mJ()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.MC.mJsBridgeContext.age == null) {
                    return;
                }
                this.MC.a(6, 1.0f, this.MC.mJsBridgeContext.age.dL(mJ()));
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) || this.MC.mJsBridgeContext.age == null) {
                    return;
                }
                this.MC.a(3, (i * 1.0f) / 100.0f, this.MC.mJsBridgeContext.age.dL(mJ()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) || this.MC.mJsBridgeContext.age == null) {
                    return;
                }
                this.MC.a(2, (i * 1.0f) / 100.0f, this.MC.mJsBridgeContext.age.dL(mJ()));
            }
        } : (KsAppDownloadListener) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            a aVar = new a();
            AdTemplate adTemplate = new AdTemplate();
            try {
                aVar.parseJson(new JSONObject(str));
                adTemplate.parseJson(new JSONObject(aVar.Mw));
            } catch (Exception e) {
                adTemplate = null;
                com.kwad.sdk.core.e.b.printStackTraceOnly(e);
            }
            if (adTemplate == null || !com.kwad.sdk.core.response.a.d.bI(adTemplate) || this.mJsBridgeContext.age == null) {
                return;
            }
            com.kwad.components.core.c.a.c cVar2 = new com.kwad.components.core.c.a.c(adTemplate);
            String mJ = cVar2.mJ();
            cVar2.b(aE(mJ));
            this.mJsBridgeContext.age.a(mJ, cVar2);
            this.mJsBridgeContext.age.b(mJ, cVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "registerProgressListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        com.kwad.sdk.utils.ad adVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (adVar = this.mJsBridgeContext.age) == null) {
            return;
        }
        adVar.release();
    }
}
