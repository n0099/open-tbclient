package com.repackage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class o90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String b;
    public String c;
    public String d;
    public m90 e;
    public q90 f;
    public s90 g;
    public LiveFeedWrapData h;
    public n90 i;

    public o90() {
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

    public void a(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, str, i, str2) == null) {
            this.a = i;
            this.b = str2;
            s90 s90Var = new s90();
            this.g = s90Var;
            s90Var.b(null, b(str), this.a);
            n90 n90Var = new n90();
            this.i = n90Var;
            n90Var.a(null, b(str));
        }
    }

    public final boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? "banner,tab,feed,follow,config".equals(str) : invokeL.booleanValue;
    }

    public void c(JSONObject jSONObject, String str, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, jSONObject, str, i) == null) || jSONObject == null) {
            return;
        }
        this.a = jSONObject.optInt("errno");
        this.b = jSONObject.optString("msg");
        this.c = jSONObject.optString("logid");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null) {
            return;
        }
        this.d = optJSONObject.optString("resource");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(SpeedStatsUtils.UBC_VALUE_BANNER);
        if (optJSONObject2 != null) {
            m90 m90Var = new m90();
            this.e = m90Var;
            m90Var.a(optJSONObject2);
        }
        JSONObject optJSONObject3 = optJSONObject.optJSONObject("follow");
        if (optJSONObject3 != null) {
            q90 q90Var = new q90();
            this.f = q90Var;
            q90Var.a(optJSONObject3);
        }
        JSONObject optJSONObject4 = optJSONObject.optJSONObject("tab");
        if (optJSONObject4 != null) {
            s90 s90Var = new s90();
            this.g = s90Var;
            s90Var.b(optJSONObject4, b(str), this.a);
        }
        JSONObject optJSONObject5 = optJSONObject.optJSONObject(ExternalTransferSpeedStats.FEED_PAGE);
        if (optJSONObject5 != null) {
            LiveFeedWrapData liveFeedWrapData = new LiveFeedWrapData();
            this.h = liveFeedWrapData;
            liveFeedWrapData.parserJson(optJSONObject5, i);
        }
        JSONObject optJSONObject6 = optJSONObject.optJSONObject(UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME);
        if (optJSONObject6 != null) {
            n90 n90Var = new n90();
            this.i = n90Var;
            n90Var.a(optJSONObject6, b(str));
        }
    }
}
