package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.BannerConfigResult;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetBannerConfigResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<BannerConfigItem> bannerConfigItemList;
    public int cmd;
    public String expand;
    public String message;
    public int result;
    public String seq;
    public long uid;

    public GetBannerConfigResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cmd = RevenueServerConst.GetBannerConfigResponse;
        this.bannerConfigItemList = new ArrayList();
        parserResponse(str);
    }

    public BannerConfigResult getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new BannerConfigResult(this.bannerConfigItemList) : (BannerConfigResult) invokeV.objValue;
    }

    public List<BannerConfigItem> optBannerConfigItemList(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    BannerConfigItem bannerConfigItem = new BannerConfigItem();
                    bannerConfigItem.type = optJSONObject.optInt("type");
                    bannerConfigItem.autoPlayTime = optJSONObject.optInt("autoPlayTime");
                    ArrayList arrayList2 = new ArrayList();
                    bannerConfigItem.bannerInfoList = arrayList2;
                    arrayList2.addAll(optBannerInfoList(optJSONObject.optJSONArray("bannerInfoList")));
                    arrayList.add(bannerConfigItem);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public List<BannerConfigItem.BannerInfo> optBannerInfoList(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    BannerConfigItem.BannerInfo bannerInfo = new BannerConfigItem.BannerInfo();
                    bannerInfo.id = optJSONObject.optString("id");
                    bannerInfo.imageUrl = optJSONObject.optString("imageUrl");
                    bannerInfo.jumpData = optJSONObject.optString("jumpData");
                    bannerInfo.jumpType = optJSONObject.optInt("jumpType");
                    arrayList.add(bannerInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null && !"".equals(str.trim())) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("cmd");
                    if (this.cmd == optInt) {
                        this.result = jSONObject.optInt("result");
                        this.uid = jSONObject.optLong("uid");
                        this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                        this.expand = jSONObject.optString("expand");
                        this.message = jSONObject.optString("message");
                        this.bannerConfigItemList.addAll(optBannerConfigItemList(jSONObject.optJSONArray("confList")));
                        return;
                    }
                    throw new Exception(this.cmd + " != " + optInt);
                } catch (Exception e2) {
                    RLog.error("GetBannerConfigResponse", "parserResponse error.", e2);
                    return;
                }
            }
            RLog.error("ChargeCurrencyResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
        }
    }
}
