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
/* loaded from: classes5.dex */
public final class z implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public final com.kwad.components.core.c.a.b b;
    @Nullable
    public com.kwad.sdk.core.webview.kwai.c c;
    @Nullable
    public KsAppDownloadListener d;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public int b;
        public long c;
        public long d;

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
                com.kwad.sdk.utils.r.a(jSONObject, "progress", this.a);
                com.kwad.sdk.utils.r.a(jSONObject, "status", this.b);
                com.kwad.sdk.utils.r.a(jSONObject, "totalBytes", this.c);
                com.kwad.sdk.utils.r.a(jSONObject, "creativeId", this.d);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public z(com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.c.a.b bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = bVar;
        this.b = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)}) == null) || this.c == null) {
            return;
        }
        a aVar = new a();
        aVar.a = f;
        aVar.b = i;
        aVar.c = com.kwad.sdk.core.response.a.d.i(this.a.a()).totalBytes;
        this.c.a(aVar);
    }

    private KsAppDownloadListener c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? new com.kwad.sdk.core.download.kwai.a(this) { // from class: com.kwad.components.core.webview.jshandler.z.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ z a;

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

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void a(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) {
                    this.a.a(3, (i * 1.0f) / 100.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    this.a.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.a.a(5, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048579, this) == null) {
                    this.a.a(1, 0.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    this.a.a(6, 1.0f);
                }
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    this.a.a(2, (i * 1.0f) / 100.0f);
                }
            }
        } : (KsAppDownloadListener) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerProgressListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (this.a.c()) {
                cVar.a(-1, "native photo is null");
                return;
            }
            this.c = cVar;
            com.kwad.components.core.c.a.b bVar = this.b;
            if (bVar != null) {
                KsAppDownloadListener ksAppDownloadListener = this.d;
                if (ksAppDownloadListener != null) {
                    bVar.c(ksAppDownloadListener);
                    return;
                }
                KsAppDownloadListener c = c();
                this.d = c;
                this.b.a(c);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        KsAppDownloadListener ksAppDownloadListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c = null;
            com.kwad.components.core.c.a.b bVar = this.b;
            if (bVar == null || (ksAppDownloadListener = this.d) == null) {
                return;
            }
            bVar.b(ksAppDownloadListener);
            this.d = null;
        }
    }
}
