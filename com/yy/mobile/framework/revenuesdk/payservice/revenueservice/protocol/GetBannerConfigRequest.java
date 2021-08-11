package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
/* loaded from: classes10.dex */
public class GetBannerConfigRequest implements IRequestProtocol {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public String expand;
    public String seq;
    public int[] types;
    public long uid;
    public int usedChannel;

    public GetBannerConfigRequest(long j2, int i2, int i3, int[] iArr, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), iArr, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.usedChannel = 10002;
        this.expand = "";
        this.uid = j2;
        this.appId = i2;
        this.usedChannel = i3;
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
                    for (int i2 : this.types) {
                        jSONArray.put(Integer.valueOf(i2));
                    }
                    jSONObject.put("types", jSONArray);
                }
                jSONObject.put("cmd", RevenueServerConst.GetBannerConfigRequest);
                jSONObject.put("uid", this.uid);
                jSONObject.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, this.appId);
                jSONObject.put("usedChannel", this.usedChannel);
                jSONObject.put(IAdRequestParam.SEQ, this.seq);
                jSONObject.put("expand", this.expand);
                return jSONObject.toString();
            } catch (JSONException e2) {
                RLog.error("GetBannerConfigRequest", "constructPSCIMessageRequest", e2);
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
