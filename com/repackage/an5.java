package com.repackage;

import android.net.Uri;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class an5 extends ShareItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public an5() {
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

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.y0 : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.x0 : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.w0 : (String) invokeV.objValue;
    }

    public JSONArray o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.z0 : (JSONArray) invokeV.objValue;
    }

    public void p(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jSONObject) == null) {
            this.r0 = true;
            this.t = jSONObject.getString("title");
            this.v = jSONObject.getString("linkUrl");
            this.u = jSONObject.optString("content");
            this.y = jSONObject.optString("imageUrl");
            this.w0 = jSONObject.optString("mediaType");
            String optString = StringUtils.isNull(this.y) ? jSONObject.optString("iconUrl") : this.y;
            this.y = optString;
            this.x = Uri.parse(optString);
            JSONObject optJSONObject = jSONObject.optJSONObject("categoryInfo");
            if (optJSONObject != null) {
                this.s0 = optJSONObject.optString("source2");
                this.u0 = optJSONObject.optString("source3");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("command");
            if (optJSONObject2 != null) {
                this.t0 = 2;
                this.z0 = optJSONObject2.optJSONArray("cmd_pannel");
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("info");
                this.A0 = optJSONObject3;
                if (optJSONObject3 != null) {
                    this.x0 = optJSONObject3.optString("key");
                    this.y0 = this.A0.optString("content");
                    return;
                }
                return;
            }
            this.t0 = "url".equals(jSONObject.optString("type")) ? 1 : 3;
        }
    }
}
