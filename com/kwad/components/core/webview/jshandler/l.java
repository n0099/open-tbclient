package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class l implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean LB;
    public final com.kwad.sdk.core.webview.b Lk;
    public com.kwad.sdk.core.network.m fr;

    /* loaded from: classes7.dex */
    public final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List LE;

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
        public final void parseJson(JSONObject jSONObject) {
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
                JSONArray jSONArray = new JSONArray();
                for (AdTemplate adTemplate : this.LE) {
                    if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                        try {
                            jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                        } catch (JSONException e) {
                            com.kwad.sdk.core.e.b.printStackTrace(e);
                        }
                    }
                    jSONArray.put(adTemplate.toJson());
                }
                com.kwad.sdk.utils.r.putValue(jSONObject, "impAdInfo", jSONArray);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public l(com.kwad.sdk.core.webview.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.Lk = bVar;
        this.LB = false;
    }

    private void a(com.kwad.components.core.k.kwai.b bVar, com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, bVar, cVar) == null) {
            com.kwad.sdk.core.network.m mVar = this.fr;
            if (mVar != null) {
                mVar.cancel();
            }
            com.kwad.sdk.core.network.m mVar2 = new com.kwad.sdk.core.network.m(this, bVar) { // from class: com.kwad.components.core.webview.jshandler.l.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l LC;
                public final /* synthetic */ com.kwad.components.core.k.kwai.b lK;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.LC = this;
                    this.lK = bVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.m
                /* renamed from: ah */
                public AdResultData parseData(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.lK.HS);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                /* renamed from: fe */
                public com.kwad.components.core.k.a createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65538, this)) == null) ? new com.kwad.components.core.k.a(this.lK) : (com.kwad.components.core.k.a) invokeV.objValue;
                }
            };
            this.fr = mVar2;
            mVar2.request(new com.kwad.sdk.core.network.n(this, cVar) { // from class: com.kwad.components.core.webview.jshandler.l.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l LC;
                public final /* synthetic */ com.kwad.sdk.core.webview.kwai.c hV;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.LC = this;
                    this.hV = cVar;
                }

                private void b(AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65537, this, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty()) {
                            bd.runOnUiThread(new Runnable(this, adResultData) { // from class: com.kwad.components.core.webview.jshandler.l.2.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 LD;
                                public final /* synthetic */ AdResultData fx;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, adResultData};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i = newInitContext.flag;
                                        if ((i & 1) != 0) {
                                            int i2 = i & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.LD = this;
                                    this.fx = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        a aVar = new a();
                                        aVar.LE = this.fx.getAdTemplateList();
                                        this.LD.hV.a(aVar);
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.e.b.d("WebCardGetKsAdDataHandler", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.f.Yd.errorCode), com.kwad.sdk.core.network.f.Yd.Qd));
                        bd.runOnUiThread(new Runnable(this) { // from class: com.kwad.components.core.webview.jshandler.l.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 LD;

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
                                this.LD = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    a aVar = new a();
                                    aVar.LE = new ArrayList();
                                    this.LD.hV.a(aVar);
                                }
                            }
                        });
                    }
                }

                private void c(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65538, this, i, str) == null) {
                        com.kwad.sdk.core.e.b.d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                        this.LC.a(this.hV);
                    }
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(com.kwad.sdk.core.network.g gVar, int i, String str) {
                    c(i, str);
                }

                @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.g gVar, BaseResultData baseResultData) {
                    b((AdResultData) baseResultData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, cVar) == null) {
            bd.runOnUiThread(new Runnable(this, cVar) { // from class: com.kwad.components.core.webview.jshandler.l.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ l LC;
                public final /* synthetic */ com.kwad.sdk.core.webview.kwai.c hV;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, cVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.LC = this;
                    this.hV = cVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a aVar = new a();
                        aVar.LE = new ArrayList();
                        this.hV.a(aVar);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) {
            if (!this.LB) {
                if (this.Lk.wh()) {
                    cVar.onError(-1, "native adTemplate is null");
                    return;
                }
                a aVar = new a();
                aVar.LE = this.Lk.wg();
                cVar.a(aVar);
                return;
            }
            AdTemplate adTemplate = this.Lk.getAdTemplate();
            com.kwad.components.core.k.kwai.b bVar = new com.kwad.components.core.k.kwai.b(adTemplate.mAdScene);
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null) {
                bVar.HT = sceneImpl.getPageScene();
            }
            bVar.HU = 106L;
            bVar.HS.setAdNum(12);
            bVar.sdkExtraData = com.kwad.sdk.core.response.a.d.bZ(adTemplate);
            a(bVar, cVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getKsAdData" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void onDestroy() {
        com.kwad.sdk.core.network.m mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (mVar = this.fr) == null) {
            return;
        }
        mVar.cancel();
    }
}
