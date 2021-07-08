package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.RevenueRecord;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class GetUserAccountHistoryResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public int cmd;
    public boolean hasMore;
    public String message;
    public int result;
    public String seq;
    public long uid;
    public List<RevenueRecord> userAccountHistoryInfos;

    public GetUserAccountHistoryResponse(String str) {
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
        this.cmd = RevenueServerConst.GetUserAccountHistoryResponse;
        this.userAccountHistoryInfos = new ArrayList();
        parserResponse(str);
    }

    private List<RevenueRecord> optHistoryInfo(JSONArray jSONArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, jSONArray)) == null) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray == null) {
                return arrayList;
            }
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    RevenueRecord revenueRecord = new RevenueRecord();
                    revenueRecord.id = optJSONObject.optInt("id");
                    revenueRecord.uid = optJSONObject.optLong("uid");
                    revenueRecord.currencyType = optJSONObject.optLong("currencyType");
                    revenueRecord.amountChange = optJSONObject.optLong("amountChange");
                    revenueRecord.amountRemain = optJSONObject.optLong("amountRemain");
                    revenueRecord.freezedChange = optJSONObject.optLong("freezedChange");
                    revenueRecord.freezedRemain = optJSONObject.optLong("freezedRemain");
                    revenueRecord.optType = optJSONObject.optInt("optType");
                    revenueRecord.optTime = optJSONObject.optLong("optTime");
                    revenueRecord.optName = optJSONObject.optString("optName");
                    revenueRecord.description = optJSONObject.optString("description");
                    arrayList.add(revenueRecord);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str != null && !"".equals(str.trim())) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int optInt = jSONObject.optInt("cmd");
                    if (this.cmd == optInt) {
                        this.uid = jSONObject.optLong("uid");
                        this.seq = jSONObject.optString(IAdRequestParam.SEQ);
                        this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                        this.result = jSONObject.optInt("result");
                        this.message = jSONObject.optString("message");
                        this.userAccountHistoryInfos.addAll(optHistoryInfo(jSONObject.optJSONArray("userAccountHistoryInfos")));
                        this.hasMore = jSONObject.optBoolean("hasMore");
                        return;
                    }
                    throw new Exception(this.cmd + " != " + optInt);
                } catch (JSONException e2) {
                    RLog.error("GetUserAccountHistoryResponse", "parserResponse error.", e2);
                    return;
                } catch (Exception e3) {
                    RLog.error("GetUserAccountHistoryResponse", "parserResponse error.", e3);
                    return;
                }
            }
            RLog.error("GetUserAccountHistoryResponse", "parserResponse error, jsonMsg is empty.", new Object[0]);
        }
    }
}
