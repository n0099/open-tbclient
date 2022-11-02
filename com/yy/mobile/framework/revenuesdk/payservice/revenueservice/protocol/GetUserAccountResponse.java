package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import com.baidu.searchbox.retrieve.log.bean.FetchLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.MyBalanceInfo;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class GetUserAccountResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, MyBalanceInfo.Account> accountList;
    public Map<Integer, MyBalanceInfo.AccountPeriod> accountPeriodList;
    public long imid;
    public String message;
    public long minAmountLimit;
    public int result;
    public String seq;
    public long uid;

    public GetUserAccountResponse(String str) {
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
        parserResponse(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.seq = jSONObject.optString("seq", "");
                this.uid = jSONObject.optLong("uid", 0L);
                this.result = jSONObject.optInt(TiebaStatic.LogFields.RESULT, 0);
                this.message = jSONObject.optString("message", "");
                this.imid = jSONObject.optLong("imid", 0L);
                this.minAmountLimit = jSONObject.optLong("minAmountLimit", 0L);
                JSONArray optJSONArray = jSONObject.optJSONArray("accountList");
                this.accountList = new HashMap();
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            MyBalanceInfo.Account account = new MyBalanceInfo.Account();
                            account.currencyType = optJSONObject.optInt("currencyType", 0);
                            account.amount = optJSONObject.optLong(PayUiEventContent.AMOUNT, 0L);
                            account.freezed = optJSONObject.optLong("freezed", 0L);
                            account.accountFrozen = optJSONObject.optInt("accountFrozen", 0);
                            this.accountList.put(Integer.valueOf(account.currencyType), account);
                        }
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("accountPeriodList");
                this.accountPeriodList = new HashMap();
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            MyBalanceInfo.AccountPeriod accountPeriod = new MyBalanceInfo.AccountPeriod();
                            accountPeriod.currencyType = optJSONObject2.optInt("currencyType", 0);
                            accountPeriod.amount = optJSONObject2.optInt(PayUiEventContent.AMOUNT, 0);
                            accountPeriod.startTime = optJSONObject2.optLong(FetchLog.START_TIME, 0L);
                            accountPeriod.endTime = optJSONObject2.optLong(FetchLog.END_TIME, 0L);
                            this.accountPeriodList.put(Integer.valueOf(accountPeriod.currencyType), accountPeriod);
                        }
                    }
                }
            } catch (JSONException e) {
                RLog.error("GetUserAccountResponse", "parserResponse error.", e);
            }
        }
    }
}
