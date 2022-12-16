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
/* loaded from: classes8.dex */
public final class t implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b Lk;
    public final Handler Ll;
    @Nullable
    public final b Mp;

    @KsJson
    /* loaded from: classes8.dex */
    public static final class a extends com.kwad.sdk.core.response.kwai.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean Mv;
        public String Mw;
        public int Mx;
        public com.kwad.sdk.core.webview.a.a.c My;

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

    /* loaded from: classes8.dex */
    public interface b {
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        com.kwad.components.core.c.a.c cVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            a aVar = new a();
            AdTemplate adTemplate = new AdTemplate();
            try {
                aVar.parseJson(new JSONObject(str));
                adTemplate.parseJson(new JSONObject(aVar.Mw));
            } catch (JSONException e) {
                com.kwad.sdk.core.e.b.printStackTrace(e);
            }
            if (com.kwad.sdk.core.response.a.d.bI(adTemplate)) {
                if (this.Lk.age != null) {
                    cVar2 = (com.kwad.components.core.c.a.c) this.Lk.age.dK(com.kwad.sdk.core.response.a.d.bQ(adTemplate).downloadId);
                } else {
                    cVar2 = null;
                }
                if (this.Lk.agf) {
                    this.Ll.post(new Runnable(this, aVar, adTemplate, cVar2) { // from class: com.kwad.components.core.webview.jshandler.t.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ a Mq;
                        public final /* synthetic */ AdTemplate Mr;
                        public final /* synthetic */ com.kwad.components.core.c.a.c Ms;
                        public final /* synthetic */ t Mt;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, aVar, adTemplate, cVar2};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.Mt = this;
                            this.Mq = aVar;
                            this.Mr = adTemplate;
                            this.Ms = cVar2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                u.b bVar = new u.b();
                                bVar.Mn = this.Mq.My.Mn;
                                com.kwad.components.core.c.a.a.a(new a.C0594a(this.Mt.Lk.Gl.getContext()).L(this.Mr).b(this.Ms).ae(this.Mq.Mx).aj(true).a(bVar).al(true).a(new a.b(this) { // from class: com.kwad.components.core.webview.jshandler.t.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 Mu;

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
                                        this.Mu = this;
                                    }

                                    @Override // com.kwad.components.core.c.a.a.b
                                    public final void onAdClicked() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        }
                                    }
                                }));
                            }
                        }
                    });
                } else if (this.Mp != null) {
                    this.Ll.post(new Runnable(this) { // from class: com.kwad.components.core.webview.jshandler.t.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ t Mt;

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
                            this.Mt = this;
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
    @NonNull
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "clickAction" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.Ll.removeCallbacksAndMessages(null);
        }
    }
}
