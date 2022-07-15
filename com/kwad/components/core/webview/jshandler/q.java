package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.core.c.a.a;
import com.kwad.sdk.core.report.u;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class q implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public final Handler b;
    @Nullable
    public final b c;

    @KsJson
    /* loaded from: classes5.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public String b;
        public int c;
        public com.kwad.sdk.core.webview.a.a.c d;

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

    /* loaded from: classes5.dex */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "clickAction" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            a aVar = new a();
            AdTemplate adTemplate = new AdTemplate();
            try {
                aVar.parseJson(new JSONObject(str));
                adTemplate.parseJson(new JSONObject(aVar.b));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.b.a(e);
            }
            if (com.kwad.sdk.core.response.a.d.a(adTemplate)) {
                if (this.a.f != null) {
                    bVar = (com.kwad.components.core.c.a.b) this.a.f.a(com.kwad.sdk.core.response.a.d.i(adTemplate).downloadId);
                } else {
                    bVar = null;
                }
                if (this.a.g) {
                    this.b.post(new Runnable(this, aVar, adTemplate, bVar) { // from class: com.kwad.components.core.webview.jshandler.q.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a a;
                        public final /* synthetic */ AdTemplate b;
                        public final /* synthetic */ com.kwad.components.core.c.a.b c;
                        public final /* synthetic */ q d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar, adTemplate, bVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.d = this;
                            this.a = aVar;
                            this.b = adTemplate;
                            this.c = bVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                u.b bVar2 = new u.b();
                                bVar2.j = this.a.d.b;
                                com.kwad.components.core.c.a.a.a(new a.C0507a(this.d.a.d.getContext()).a(this.b).a(this.c).a(this.a.c).a(true).a(bVar2).c(true).a(new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.q.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 a;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.a = this;
                                    }

                                    @Override // com.kwad.components.core.c.a.a.b
                                    public final void a() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        }
                                    }
                                }));
                            }
                        }
                    });
                } else if (this.c != null) {
                    this.b.post(new Runnable(this) { // from class: com.kwad.components.core.webview.jshandler.q.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ q a;

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

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            }
                        }
                    });
                }
                cVar.a(null);
            }
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b.removeCallbacksAndMessages(null);
        }
    }
}
