package com.kwad.sdk.core.c.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.ProfileGuideConfigItem;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ab implements com.kwad.sdk.core.c<ProfileGuideConfigItem.ProfileGuideConfig> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ab() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject a(ProfileGuideConfigItem.ProfileGuideConfig profileGuideConfig) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, profileGuideConfig)) == null) {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.o.a(jSONObject, "appearTime", profileGuideConfig.appearTime);
            com.kwad.sdk.utils.o.a(jSONObject, "showInterval", profileGuideConfig.showInterval);
            com.kwad.sdk.utils.o.a(jSONObject, "showCount", profileGuideConfig.showCount);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(ProfileGuideConfigItem.ProfileGuideConfig profileGuideConfig, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, profileGuideConfig, jSONObject) == null) || jSONObject == null) {
            return;
        }
        profileGuideConfig.appearTime = jSONObject.optLong("appearTime", new Long("2000").longValue());
        profileGuideConfig.showInterval = jSONObject.optInt("showInterval", new Integer("3").intValue());
        profileGuideConfig.showCount = jSONObject.optInt("showCount", new Integer("2").intValue());
    }
}
