package com.kwad.components.core.k.kwai;

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
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.r;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class b implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SceneImpl HS;
    public long HT;
    public long HU;
    public String sdkExtraData;

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
        this.HS = (SceneImpl) ksScene;
        this.HT = 0L;
        this.HU = 0L;
        if (ba.getPosId() != 0) {
            this.HS.setPosId(ba.getPosId());
        }
    }

    @Nullable
    public final String av(String str) {
        InterceptResult invokeL;
        Map<String, String> rewardCallbackExtraData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            SceneImpl sceneImpl = this.HS;
            if (sceneImpl == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
                return null;
            }
            return rewardCallbackExtraData.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public final com.kwad.sdk.internal.api.a op() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            SceneImpl sceneImpl = this.HS;
            if (sceneImpl == null) {
                return null;
            }
            return sceneImpl.mKsAdLabel;
        }
        return (com.kwad.sdk.internal.api.a) invokeV.objValue;
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
            JSONObject json = this.HS.toJson();
            r.putValue(json, "pageScene", this.HT);
            r.putValue(json, "subPageScene", this.HU);
            r.putValue(json, "sdkExtraData", this.sdkExtraData);
            String av = av(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            if (av != null) {
                r.putValue(json, PrefetchEvent.EVENT_DATA_EXTRA_DATA, av);
            }
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
