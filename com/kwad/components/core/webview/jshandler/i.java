package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class i implements com.kwad.sdk.core.webview.kwai.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final com.kwad.sdk.core.webview.b a;
    public final boolean b;
    public com.kwad.sdk.core.network.l<com.kwad.components.core.j.a, AdResultData> c;

    /* loaded from: classes5.dex */
    public static final class a implements com.kwad.sdk.core.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<AdTemplate> a;

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
                JSONArray jSONArray = new JSONArray();
                for (AdTemplate adTemplate : this.a) {
                    if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                        try {
                            jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                        } catch (JSONException e) {
                            com.kwad.sdk.core.d.b.a(e);
                        }
                    }
                    jSONArray.put(adTemplate.toJson());
                }
                com.kwad.sdk.utils.r.a(jSONObject, "impAdInfo", jSONArray);
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    public i(com.kwad.sdk.core.webview.b bVar) {
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
        this.a = bVar;
        this.b = false;
    }

    private void a(com.kwad.components.core.j.kwai.b bVar, com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, bVar, cVar) == null) {
            com.kwad.sdk.core.network.l<com.kwad.components.core.j.a, AdResultData> lVar = this.c;
            if (lVar != null) {
                lVar.cancel();
            }
            com.kwad.sdk.core.network.l<com.kwad.components.core.j.a, AdResultData> lVar2 = new com.kwad.sdk.core.network.l<com.kwad.components.core.j.a, AdResultData>(this, bVar) { // from class: com.kwad.components.core.webview.jshandler.i.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.components.core.j.kwai.b a;
                public final /* synthetic */ i b;

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
                    this.b = this;
                    this.a = bVar;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                @NonNull
                /* renamed from: a */
                public com.kwad.components.core.j.a createRequest() {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new com.kwad.components.core.j.a(this.a) : (com.kwad.components.core.j.a) invokeV.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.l
                @NonNull
                /* renamed from: a */
                public AdResultData parseData(String str) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(65538, this, str)) == null) {
                        JSONObject jSONObject = new JSONObject(str);
                        AdResultData adResultData = new AdResultData(this.a.a);
                        adResultData.parseJson(jSONObject);
                        return adResultData;
                    }
                    return (AdResultData) invokeL.objValue;
                }
            };
            this.c = lVar2;
            lVar2.request(new com.kwad.sdk.core.network.m<com.kwad.components.core.j.a, AdResultData>(this, cVar) { // from class: com.kwad.components.core.webview.jshandler.i.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.webview.kwai.c a;
                public final /* synthetic */ i b;

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
                    this.b = this;
                    this.a = cVar;
                }

                private void a(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(65537, this, i, str) == null) {
                        com.kwad.sdk.core.d.b.a("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                        this.b.a(this.a);
                    }
                }

                private void a(@NonNull AdResultData adResultData) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(65538, this, adResultData) == null) {
                        if (!adResultData.isAdResultDataEmpty()) {
                            az.a(new Runnable(this, adResultData) { // from class: com.kwad.components.core.webview.jshandler.i.2.2
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AdResultData a;
                                public final /* synthetic */ AnonymousClass2 b;

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
                                    this.b = this;
                                    this.a = adResultData;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        a aVar = new a();
                                        aVar.a = this.a.getAdTemplateList();
                                        this.b.a.a(aVar);
                                    }
                                }
                            });
                            return;
                        }
                        com.kwad.sdk.core.d.b.a("WebCardGetKsAdDataHandler", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(com.kwad.sdk.core.network.f.f.p), com.kwad.sdk.core.network.f.f.q));
                        az.a(new Runnable(this) { // from class: com.kwad.components.core.webview.jshandler.i.2.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass2 a;

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

                            @Override // java.lang.Runnable
                            public final void run() {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                    a aVar = new a();
                                    aVar.a = new ArrayList();
                                    this.a.a.a(aVar);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onError(@NonNull com.kwad.sdk.core.network.g gVar, int i, String str) {
                    a(i, str);
                }

                @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
                public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                    a((AdResultData) baseResultData);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, cVar) == null) {
            az.a(new Runnable(this, cVar) { // from class: com.kwad.components.core.webview.jshandler.i.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ com.kwad.sdk.core.webview.kwai.c a;
                public final /* synthetic */ i b;

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
                    this.b = this;
                    this.a = cVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        a aVar = new a();
                        aVar.a = new ArrayList();
                        this.a.a(aVar);
                    }
                }
            });
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    @NonNull
    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "getKsAdData" : (String) invokeV.objValue;
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.kwai.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, cVar) == null) {
            if (!this.b) {
                if (this.a.c()) {
                    cVar.a(-1, "native adTemplate is null");
                    return;
                }
                a aVar = new a();
                aVar.a = this.a.b();
                cVar.a(aVar);
                return;
            }
            AdTemplate a2 = this.a.a();
            com.kwad.components.core.j.kwai.b bVar = new com.kwad.components.core.j.kwai.b(a2.mAdScene);
            SceneImpl sceneImpl = a2.mAdScene;
            if (sceneImpl != null) {
                bVar.b = sceneImpl.getPageScene();
            }
            bVar.c = 106L;
            bVar.a.setAdNum(12);
            bVar.d = com.kwad.sdk.core.response.a.d.s(a2);
            a(bVar, cVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.kwai.a
    public final void b() {
        com.kwad.sdk.core.network.l<com.kwad.components.core.j.a, AdResultData> lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (lVar = this.c) == null) {
            return;
        }
        lVar.cancel();
    }
}
