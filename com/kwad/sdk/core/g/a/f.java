package com.kwad.sdk.core.g.a;

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
import com.kwad.sdk.utils.q;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class f implements com.kwad.sdk.core.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SceneImpl f71602a;

    /* renamed from: b  reason: collision with root package name */
    public long f71603b;

    /* renamed from: c  reason: collision with root package name */
    public long f71604c;

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
        this.f71602a = (SceneImpl) ksScene;
        this.f71603b = 0L;
        this.f71604c = 0L;
    }

    @Nullable
    public String a(String str) {
        InterceptResult invokeL;
        SceneImpl sceneImpl;
        Map<String, String> rewardCallbackExtraData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || (sceneImpl = this.f71602a) == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
                return null;
            }
            return rewardCallbackExtraData.get(str);
        }
        return (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            JSONObject json = this.f71602a.toJson();
            q.a(json, "pageScene", this.f71603b);
            q.a(json, "subPageScene", this.f71604c);
            String a2 = a(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
            if (a2 != null) {
                q.a(json, PrefetchEvent.EVENT_DATA_EXTRA_DATA, a2);
            }
            return json;
        }
        return (JSONObject) invokeV.objValue;
    }
}
