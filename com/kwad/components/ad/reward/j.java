package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean a;
    public com.kwad.sdk.core.network.l<k, BaseResultData> b;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static j a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(818459035, "Lcom/kwad/components/ad/reward/j$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(818459035, "Lcom/kwad/components/ad/reward/j$a;");
                    return;
                }
            }
            a = new j((byte) 0);
        }
    }

    public j() {
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
        this.a = false;
    }

    public /* synthetic */ j(byte b) {
        this();
    }

    public static j a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? a.a : (j) invokeV.objValue;
    }

    private void b(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adTemplate) == null) || this.a) {
            return;
        }
        this.a = true;
        com.kwad.sdk.core.network.l<k, BaseResultData> lVar = new com.kwad.sdk.core.network.l<k, BaseResultData>(this, adTemplate) { // from class: com.kwad.components.ad.reward.j.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ j b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, adTemplate};
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
                this.a = adTemplate;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: a */
            public k createRequest() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new k(this.a) : (k) invokeV.objValue;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final BaseResultData parseData(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    BaseResultData baseResultData = new BaseResultData(this) { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ j.AnonymousClass1 this$1;

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
                            this.this$1 = this;
                        }
                    };
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            baseResultData.parseJson(new JSONObject(str));
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.a(th);
                        }
                    }
                    return baseResultData;
                }
                return (BaseResultData) invokeL.objValue;
            }
        };
        this.b = lVar;
        lVar.request(new com.kwad.sdk.core.network.m<k, BaseResultData>(this, adTemplate) { // from class: com.kwad.components.ad.reward.j.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate a;
            public final /* synthetic */ j b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, adTemplate};
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
                this.a = adTemplate;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull k kVar, int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(65537, this, kVar, i, str) == null) {
                    super.onError(kVar, i, str);
                    this.b.a = false;
                    com.kwad.components.core.i.a.a().b(this.a, 1, str);
                    com.kwad.sdk.core.d.b.c("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.m, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull k kVar, @NonNull BaseResultData baseResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(65538, this, kVar, baseResultData) == null) {
                    super.onSuccess(kVar, baseResultData);
                    this.b.a = false;
                    com.kwad.components.core.i.a.a().b(this.a, 0, "success");
                    com.kwad.sdk.core.d.b.c("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
                }
            }
        });
    }

    public final void a(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.av(i))) {
                s.a(adTemplate, i);
            } else {
                b(adTemplate);
            }
        }
    }

    public final void b() {
        com.kwad.sdk.core.network.l<k, BaseResultData> lVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (lVar = this.b) == null) {
            return;
        }
        lVar.cancel();
    }
}
