package com.kwad.sdk.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class l implements com.kwad.sdk.core.webview.a.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.core.webview.a f72879a;

    /* loaded from: classes10.dex */
    public static final class a extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f72881a;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b extends com.kwad.sdk.core.response.a.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public double f72882a;

        /* renamed from: b  reason: collision with root package name */
        public int f72883b;

        /* renamed from: c  reason: collision with root package name */
        public long f72884c;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    private KsAppDownloadListener a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65536, this, str)) == null) ? new com.kwad.sdk.core.download.b.c(this, str) { // from class: com.kwad.sdk.core.webview.jshandler.l.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ l f72880b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(str);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, str};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((String) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f72880b = this;
            }

            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048576, this, i2) == null) || this.f72880b.f72879a.f72747g == null) {
                    return;
                }
                this.f72880b.a(3, (i2 * 1.0f) / 100.0f, this.f72880b.f72879a.f72747g.b(a()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f72880b.f72879a.f72747g == null) {
                    return;
                }
                this.f72880b.a(1, 0.0f, this.f72880b.f72879a.f72747g.b(a()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.f72880b.f72879a.f72747g == null) {
                    return;
                }
                this.f72880b.a(5, 1.0f, this.f72880b.f72879a.f72747g.b(a()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048579, this) == null) || this.f72880b.f72879a.f72747g == null) {
                    return;
                }
                this.f72880b.a(1, 0.0f, this.f72880b.f72879a.f72747g.b(a()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeV(1048580, this) == null) || this.f72880b.f72879a.f72747g == null) {
                    return;
                }
                this.f72880b.a(6, 1.0f, this.f72880b.f72879a.f72747g.b(a()));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeI(1048581, this, i2) == null) || this.f72880b.f72879a.f72747g == null) {
                    return;
                }
                this.f72880b.a(2, (i2 * 1.0f) / 100.0f, this.f72880b.f72879a.f72747g.b(a()));
            }
        } : (KsAppDownloadListener) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, float f2, com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), cVar}) == null) || cVar == null) {
            return;
        }
        b bVar = new b();
        bVar.f72882a = f2;
        bVar.f72883b = i2;
        bVar.f72884c = com.kwad.sdk.core.response.b.c.i(this.f72879a.f72742b).totalBytes;
        cVar.a(bVar);
    }

    @Override // com.kwad.sdk.core.webview.a.a
    @NonNull
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "registerProgressListener" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void a(String str, @NonNull com.kwad.sdk.core.webview.a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            a aVar = new a();
            AdTemplate adTemplate = new AdTemplate();
            try {
                aVar.parseJson(new JSONObject(str));
                adTemplate.parseJson(new JSONObject(aVar.f72881a));
            } catch (Exception e2) {
                adTemplate = null;
                com.kwad.sdk.core.d.a.b(e2);
            }
            if (adTemplate == null || !com.kwad.sdk.core.response.b.c.b(adTemplate) || this.f72879a.f72747g == null) {
                return;
            }
            com.kwad.sdk.core.download.b.b bVar = new com.kwad.sdk.core.download.b.b(adTemplate);
            String a2 = bVar.a();
            bVar.a(a(a2));
            this.f72879a.f72747g.a(a2, bVar);
            this.f72879a.f72747g.a(a2, cVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.a.a
    public void b() {
        y yVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (yVar = this.f72879a.f72747g) == null) {
            return;
        }
        yVar.a();
    }
}
