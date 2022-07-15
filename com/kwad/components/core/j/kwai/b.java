package com.kwad.components.core.j.kwai;

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
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.r;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SceneImpl a;
    public long b;
    public long c;
    public String d;

    public b(KsScene ksScene) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksScene};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = (SceneImpl) ksScene;
        this.b = 0L;
        this.c = 0L;
        if (aw.c() != 0) {
            this.a.setPosId(aw.c());
        }
    }

    @Nullable
    public final com.kwad.sdk.internal.api.a a() {
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
    public final String a(String str) {
        InterceptResult invokeL;
        Map<String, String> rewardCallbackExtraData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            SceneImpl sceneImpl = this.a;
            if (sceneImpl == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
                return null;
            }
            return rewardCallbackExtraData.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject json = this.a.toJson();
            r.a(json, "pageScene", this.b);
            r.a(json, "subPageScene", this.c);
            r.a(json, "sdkExtraData", this.d);
            String a = a(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            if (a != null) {
                r.a(json, PrefetchEvent.EVENT_DATA_EXTRA_DATA, a);
            }
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
