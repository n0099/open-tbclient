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
import com.kwad.components.ad.reward.i;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile boolean fq;
    public com.kwad.sdk.core.network.m<j, BaseResultData> fr;

    /* loaded from: classes8.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static i mi;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(818429244, "Lcom/kwad/components/ad/reward/i$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(818429244, "Lcom/kwad/components/ad/reward/i$a;");
                    return;
                }
            }
            mi = new i((byte) 0);
        }
    }

    public i() {
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
        this.fq = false;
    }

    public /* synthetic */ i(byte b) {
        this();
    }

    public static i fn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a.mi : (i) invokeV.objValue;
    }

    private void n(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, adTemplate) == null) || this.fq) {
            return;
        }
        this.fq = true;
        com.kwad.sdk.core.network.m<j, BaseResultData> mVar = new com.kwad.sdk.core.network.m<j, BaseResultData>(this, adTemplate) { // from class: com.kwad.components.ad.reward.i.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate kp;
            public final /* synthetic */ i mh;

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
                this.mh = this;
                this.kp = adTemplate;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: fo */
            public j createRequest() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeV = interceptable2.invokeV(65537, this)) == null) ? new j(this.kp) : (j) invokeV.objValue;
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final BaseResultData parseData(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                    BaseResultData baseResultData = new BaseResultData(this) { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ i.AnonymousClass1 this$1;

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
                            com.kwad.sdk.core.e.b.printStackTrace(th);
                        }
                    }
                    return baseResultData;
                }
                return (BaseResultData) invokeL.objValue;
            }
        };
        this.fr = mVar;
        mVar.request(new com.kwad.sdk.core.network.n<j, BaseResultData>(this, adTemplate) { // from class: com.kwad.components.ad.reward.i.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AdTemplate kp;
            public final /* synthetic */ i mh;

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
                this.mh = this;
                this.kp = adTemplate;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull j jVar, int i, String str) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(65537, this, jVar, i, str) == null) {
                    super.onError(jVar, i, str);
                    this.mh.fq = false;
                    com.kwad.components.core.j.a.og().c(this.kp, 1, str);
                    com.kwad.sdk.core.e.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.n, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull j jVar, @NonNull BaseResultData baseResultData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLL(65538, this, jVar, baseResultData) == null) {
                    super.onSuccess(jVar, baseResultData);
                    this.mh.fq = false;
                    com.kwad.components.core.j.a.og().c(this.kp, 0, "success");
                    com.kwad.sdk.core.e.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
                }
            }
        });
    }

    public final void m(AdTemplate adTemplate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, adTemplate) == null) {
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.be(bQ))) {
                r.b(adTemplate, bQ);
            } else {
                n(adTemplate);
            }
        }
    }

    public final void release() {
        com.kwad.sdk.core.network.m<j, BaseResultData> mVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (mVar = this.fr) == null) {
            return;
        }
        mVar.cancel();
    }
}
