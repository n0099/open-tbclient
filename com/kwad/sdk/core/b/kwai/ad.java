package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.config.item.AvatarGuiderConfigItem;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ad implements com.kwad.sdk.core.d<AvatarGuiderConfigItem.AvatarGuiderConfig> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ad() {
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
    @Override // com.kwad.sdk.core.d
    public void a(AvatarGuiderConfigItem.AvatarGuiderConfig avatarGuiderConfig, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, avatarGuiderConfig, jSONObject) == null) || jSONObject == null) {
            return;
        }
        avatarGuiderConfig.showByPlayRate = jSONObject.optInt("showByPlayRate", new Integer("70").intValue());
        avatarGuiderConfig.showTimeLength = jSONObject.optInt("showTimeLength", new Integer("3000").intValue());
        avatarGuiderConfig.showMaxTimes = jSONObject.optInt("showMaxTimes", new Integer("7").intValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AvatarGuiderConfigItem.AvatarGuiderConfig avatarGuiderConfig, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, avatarGuiderConfig, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "showByPlayRate", avatarGuiderConfig.showByPlayRate);
            com.kwad.sdk.utils.t.a(jSONObject, "showTimeLength", avatarGuiderConfig.showTimeLength);
            com.kwad.sdk.utils.t.a(jSONObject, "showMaxTimes", avatarGuiderConfig.showMaxTimes);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
