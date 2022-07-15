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
/* loaded from: classes5.dex */
public final class s implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;

    @KsJson
    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

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
    /* loaded from: classes5.dex */
    public static final class b extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public double a;
        public int b;
        public long c;

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

    private KsAppDownloadListener a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, this, str)) == null) ? new com.kwad.sdk.core.download.kwai.a(this, str) { // from class: com.kwad.components.core.webview.jshandler.s.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s a;

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
                this.a = this;
            }

            @Override // com.kwad.sdk.core.download.kwai.a
            public final void a(int i) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i) == null) || this.a.a.f == null) {
                    return;
                }
                this.a.a(3, (i * 1.0f) / 100.0f, this.a.a.f.b(o()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.a.f == null) {
                    return;
                }
                this.a.a(1, 0.0f, this.a.a.f.b(o()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.a.a.f == null) {
                    return;
                }
                this.a.a(5, 1.0f, this.a.a.f.b(o()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onIdle() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.a.a.f == null) {
                    return;
                }
                this.a.a(1, 0.0f, this.a.a.f.b(o()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.a.a.f == null) {
                    return;
                }
                this.a.a(6, 1.0f, this.a.a.f.b(o()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public final void onProgressUpdate(int i) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) || this.a.a.f == null) {
                    return;
                }
                this.a.a(2, (i * 1.0f) / 100.0f, this.a.a.f.b(o()));
            }
        } : (KsAppDownloadListener) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, float f, com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), cVar}) == null) || cVar == null) {
            return;
        }
        b bVar = new b();
        bVar.a = f;
        bVar.b = i;
        bVar.c = com.kwad.sdk.core.response.a.d.i(this.a.a()).totalBytes;
        cVar.a(bVar);
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
            a aVar = new a();
            AdTemplate adTemplate = new AdTemplate();
            try {
                aVar.parseJson(new JSONObject(str));
                adTemplate.parseJson(new JSONObject(aVar.a));
            } catch (Exception e) {
                adTemplate = null;
                com.kwad.sdk.core.d.b.b(e);
            }
            if (adTemplate == null || !com.kwad.sdk.core.response.a.d.a(adTemplate) || this.a.f == null) {
                return;
            }
            com.kwad.components.core.c.a.b bVar = new com.kwad.components.core.c.a.b(adTemplate);
            String b2 = bVar.b();
            bVar.a(a(b2));
            this.a.f.a(b2, bVar);
            this.a.f.a(b2, cVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        com.kwad.sdk.utils.ab abVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (abVar = this.a.f) == null) {
            return;
        }
        abVar.a();
    }
}
