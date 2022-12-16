package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAppDownloadListener;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class ac implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public KsAppDownloadListener KW;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c Lb;
    public final com.kwad.components.core.c.a.c mApkDownloadHelper;
    public final com.kwad.sdk.core.webview.b mJsBridgeContext;

    /* loaded from: classes8.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float MO;
        public long creativeId;
        public int status;
        public long totalBytes;

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

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                com.kwad.sdk.utils.r.putValue(jSONObject, "progress", this.MO);
                com.kwad.sdk.utils.r.putValue(jSONObject, "status", this.status);
                com.kwad.sdk.utils.r.putValue(jSONObject, "totalBytes", this.totalBytes);
                com.kwad.sdk.utils.r.putValue(jSONObject, "creativeId", this.creativeId);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public ac(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mJsBridgeContext = bVar;
        this.mApkDownloadHelper = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || this.Lb == null) {
            return;
        }
        a aVar = new a();
        aVar.MO = f;
        aVar.status = i;
        aVar.totalBytes = com.kwad.sdk.core.response.a.d.bQ(this.mJsBridgeContext.getAdTemplate()).totalBytes;
        this.Lb.a(aVar);
    }

    private KsAppDownloadListener pu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.webview.jshandler.ac.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ac MN;

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
                this.MN = this;
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.MN.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.MN.a(5, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.MN.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.MN.a(6, 1.0f);
                }
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void onPaused(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048580, this, i) == null) {
                    this.MN.a(3, (i * 1.0f) / 100.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    this.MN.a(2, (i * 1.0f) / 100.0f);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (this.mJsBridgeContext.wh()) {
                cVar.onError(-1, "native photo is null");
                return;
            }
            this.Lb = cVar;
            com.kwad.components.core.c.a.c cVar2 = this.mApkDownloadHelper;
            if (cVar2 != null) {
                KsAppDownloadListener ksAppDownloadListener = this.KW;
                if (ksAppDownloadListener != null) {
                    cVar2.d(ksAppDownloadListener);
                    return;
                }
                KsAppDownloadListener pu = pu();
                this.KW = pu;
                this.mApkDownloadHelper.b(pu);
            }
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
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.Lb = null;
            com.kwad.components.core.c.a.c cVar = this.mApkDownloadHelper;
            if (cVar == null || (ksAppDownloadListener = this.KW) == null) {
                return;
            }
            cVar.c(ksAppDownloadListener);
            this.KW = null;
        }
    }
}
