package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.t;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SceneImpl a;

    /* renamed from: b  reason: collision with root package name */
    public long f58364b;

    /* renamed from: c  reason: collision with root package name */
    public long f58365c;

    /* renamed from: d  reason: collision with root package name */
    public String f58366d;

    public f(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (SceneImpl) ksScene;
        this.f58364b = 0L;
        this.f58365c = 0L;
    }

    @Nullable
    public com.kwad.sdk.internal.api.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            SceneImpl sceneImpl = this.a;
            if (sceneImpl == null) {
                return null;
            }
            return sceneImpl.mKsAdLabel;
        }
        return (com.kwad.sdk.internal.api.a) invokeV.objValue;
    }

    @Nullable
    public String a(String str) {
        InterceptResult invokeL;
        SceneImpl sceneImpl;
        Map<String, String> rewardCallbackExtraData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null || (sceneImpl = this.a) == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
                return null;
            }
            return rewardCallbackExtraData.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject json = this.a.toJson();
            t.a(json, "pageScene", this.f58364b);
            t.a(json, "subPageScene", this.f58365c);
            t.a(json, "sdkExtraData", this.f58366d);
            String a = a(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            if (a != null) {
                t.a(json, PrefetchEvent.EVENT_DATA_EXTRA_DATA, a);
            }
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
