package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetSplitOrderConfigResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public String bottomGuideMsg;
    public int cmd;
    public String expand;
    public String hintMsg;
    public String message;
    public boolean needSplit;
    public int result;
    public String seq;
    public String splitId;
    public List<SplitRecordItem> splitRecordItemList;
    public long uid;
    public int usedChannel;

    public GetSplitOrderConfigResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cmd = RevenueServerConst.GetChargeCurrencySplitResponse;
        this.splitRecordItemList = new ArrayList();
        parserResponse(str);
    }

    public List<SplitRecordItem> optSplitRecordItemList(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    SplitRecordItem splitRecordItem = new SplitRecordItem();
                    splitRecordItem.type = optJSONObject.optInt("type");
                    splitRecordItem.id = optJSONObject.optString("id");
                    splitRecordItem.name = optJSONObject.optString("name");
                    splitRecordItem.value = optJSONObject.optString("value");
                    arrayList.add(splitRecordItem);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            if (str != null && !"".equals(str.trim())) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("cmd");
                    if (this.cmd == optInt) {
                        this.result = jSONObject.optInt("result");
                        this.uid = jSONObject.optLong("uid");
                        this.seq = jSONObject.optString("seq");
                        this.expand = jSONObject.optString("expand");
                        this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                        this.message = jSONObject.optString("message");
                        this.needSplit = jSONObject.optBoolean("needSplit");
                        this.splitId = jSONObject.optString("splitId");
                        this.hintMsg = jSONObject.optString("hintMsg");
                        this.splitRecordItemList.addAll(optSplitRecordItemList(jSONObject.optJSONArray("splitDetailList")));
                        this.bottomGuideMsg = jSONObject.optString("bottomGuideMsg");
                        return;
                    }
                    throw new Exception(this.cmd + " != " + optInt);
                } catch (JSONException e) {
                    RLog.error("GetSplitOrderConfigResponse", "parserResponse error.", e);
                    return;
                } catch (Exception e2) {
                    RLog.error("GetSplitOrderConfigResponse", "parserResponse error.", e2);
                    return;
                }
            }
            RLog.error("GetSplitOrderConfigResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
        }
    }
}
