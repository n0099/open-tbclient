package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetBannerConfigRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public String expand;
    public String seq;
    public int[] types;
    public long uid;
    public int usedChannel;

    public GetBannerConfigRequest(long j, int i, int i2, int[] iArr, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Integer.valueOf(i), Integer.valueOf(i2), iArr, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.usedChannel = 10002;
        this.expand = "";
        this.uid = j;
        this.appId = i;
        this.usedChannel = i2;
        this.seq = str;
        this.expand = str2;
        this.types = iArr;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payservice.revenueservice.request.IRequestProtocol
    public String getProtocol() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.types != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i : this.types) {
                        jSONArray.put(Integer.valueOf(i));
                    }
                    jSONObject.put("types", jSONArray);
                }
                jSONObject.put("cmd", RevenueServerConst.GetBannerConfigRequest);
                jSONObject.put("uid", this.uid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put("seq", this.seq);
                jSONObject.put("expand", this.expand);
                return jSONObject.toString();
            } catch (JSONException e) {
                RLog.error("GetBannerConfigRequest", "constructPSCIMessageRequest", e);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
