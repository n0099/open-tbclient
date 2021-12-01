package com.kwad.sdk.core.b.kwai;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.live.mode.LiveInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class en implements com.kwad.sdk.core.d<LiveInfo.User> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public en() {
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
    public void a(LiveInfo.User user, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, user, jSONObject) == null) || jSONObject == null) {
            return;
        }
        user.headurls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headurls");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                LiveInfo.User.HeadUrl headUrl = new LiveInfo.User.HeadUrl();
                headUrl.parseJson(optJSONArray.optJSONObject(i2));
                user.headurls.add(headUrl);
            }
        }
        user.user_id = jSONObject.optLong("user_id");
        user.user_name = jSONObject.optString("user_name");
        if (jSONObject.opt("user_name") == JSONObject.NULL) {
            user.user_name = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(LiveInfo.User user, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, user, jSONObject)) == null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            com.kwad.sdk.utils.t.a(jSONObject, "headurls", user.headurls);
            com.kwad.sdk.utils.t.a(jSONObject, "user_id", user.user_id);
            com.kwad.sdk.utils.t.a(jSONObject, "user_name", user.user_name);
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }
}
