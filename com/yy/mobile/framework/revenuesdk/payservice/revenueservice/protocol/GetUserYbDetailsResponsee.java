package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.bean.YbChargeItemInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetUserYbDetailsResult;
import com.yy.mobile.framework.revenuesdk.payservice.revenueservice.RevenueServerConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00107\u001a\u00020\u0005¢\u0006\u0004\b8\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\f\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\tR\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001d\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010\tR\"\u0010$\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010\tR\"\u0010*\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\f\u001a\u0004\b+\u0010\u000e\"\u0004\b,\u0010\u0010R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u00104\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\f\u001a\u0004\b5\u0010\u000e\"\u0004\b6\u0010\u0010¨\u00069"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/protocol/GetUserYbDetailsResponsee;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/IBaseJsonResponse;", "Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/GetUserYbDetailsResult;", "getResponse", "()Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/GetUserYbDetailsResult;", "", "jsonMsg", "", "parserResponse", "(Ljava/lang/String;)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "getAppId", "()I", "setAppId", "(I)V", "", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/YbChargeItemInfo;", "chargeOrderList", "Ljava/util/List;", "getChargeOrderList", "()Ljava/util/List;", "setChargeOrderList", "(Ljava/util/List;)V", "cmd", "getCmd", "setCmd", "expand", "Ljava/lang/String;", "getExpand", "()Ljava/lang/String;", "setExpand", "message", "getMessage", "setMessage", "result", "getResult", "setResult", IAdRequestParam.SEQ, "getSeq", "setSeq", "total", "getTotal", "setTotal", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "usedChannel", "getUsedChannel", "setUsedChannel", "rspData", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class GetUserYbDetailsResponsee implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appId;
    public List<YbChargeItemInfo> chargeOrderList;
    public int cmd;
    public String expand;
    public String message;
    public int result;
    public String seq;
    public int total;
    public long uid;
    public int usedChannel;

    public GetUserYbDetailsResponsee(String str) {
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
        this.cmd = RevenueServerConst.GetUserYbDetailsResponse;
        this.seq = "";
        this.result = -1;
        this.message = "";
        this.expand = "";
        this.chargeOrderList = new ArrayList();
        parserResponse(str);
    }

    public final int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appId : invokeV.intValue;
    }

    public final List<YbChargeItemInfo> getChargeOrderList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.chargeOrderList : (List) invokeV.objValue;
    }

    public final int getCmd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.cmd : invokeV.intValue;
    }

    public final String getExpand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.expand : (String) invokeV.objValue;
    }

    public final String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    public final GetUserYbDetailsResult getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new GetUserYbDetailsResult(this.result, this.total, this.chargeOrderList) : (GetUserYbDetailsResult) invokeV.objValue;
    }

    public final int getResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.result : invokeV.intValue;
    }

    public final String getSeq() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.seq : (String) invokeV.objValue;
    }

    public final int getTotal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.total : invokeV.intValue;
    }

    public final long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.uid : invokeV.longValue;
    }

    public final int getUsedChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.usedChannel : invokeV.intValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            boolean z = true;
            int length = str.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = str.charAt(!z2 ? i2 : length) <= ' ';
                if (z2) {
                    if (!z3) {
                        break;
                    }
                    length--;
                } else if (z3) {
                    i2++;
                } else {
                    z2 = true;
                }
            }
            if (Intrinsics.areEqual("", str.subSequence(i2, length + 1).toString())) {
                RLog.error("GetUserYbDetailsResponsee", "parserResponse error, jsonMsg is empty.", new Object[0]);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("cmd");
                if (this.cmd == optInt) {
                    this.uid = jSONObject.optLong("uid");
                    String optString = jSONObject.optString(IAdRequestParam.SEQ);
                    Intrinsics.checkExpressionValueIsNotNull(optString, "jsonObject.optString(\"seq\")");
                    this.seq = optString;
                    this.result = jSONObject.optInt("result");
                    String optString2 = jSONObject.optString("message");
                    Intrinsics.checkExpressionValueIsNotNull(optString2, "jsonObject.optString(\"message\")");
                    this.message = optString2;
                    this.appId = jSONObject.optInt(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                    this.usedChannel = jSONObject.optInt("usedChannel");
                    String optString3 = jSONObject.optString("expand");
                    Intrinsics.checkExpressionValueIsNotNull(optString3, "jsonObject.optString(\"expand\")");
                    this.expand = optString3;
                    this.total = jSONObject.optInt("total");
                    JSONArray optJSONArray = jSONObject.optJSONArray("dataList");
                    if (optJSONArray != null) {
                        if (optJSONArray.length() <= 0) {
                            z = false;
                        }
                        if (!z) {
                            optJSONArray = null;
                        }
                        if (optJSONArray != null) {
                            int length2 = optJSONArray.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                                YbChargeItemInfo ybChargeItemInfo = new YbChargeItemInfo();
                                ybChargeItemInfo.balance = optJSONObject.optString("balance");
                                ybChargeItemInfo.comment = optJSONObject.optString("comment");
                                ybChargeItemInfo.date = optJSONObject.optString("date");
                                ybChargeItemInfo.income = optJSONObject.optString("income");
                                ybChargeItemInfo.moneyType = optJSONObject.optString("moneyType");
                                ybChargeItemInfo.other = optJSONObject.optString("other");
                                ybChargeItemInfo.outgo = optJSONObject.optString("outgo");
                                ybChargeItemInfo.tips = optJSONObject.optString("tips");
                                ybChargeItemInfo.tradeType = optJSONObject.optString("tradeType");
                                ybChargeItemInfo.status = optJSONObject.optString("status");
                                this.chargeOrderList.add(ybChargeItemInfo);
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new Exception(String.valueOf(this.cmd) + " != " + optInt);
            } catch (JSONException e2) {
                RLog.error("GetUserYbDetailsResponsee", "parserResponse error.", e2);
            } catch (Exception e3) {
                RLog.error("GetUserYbDetailsResponsee", "parserResponse error.", e3);
            }
        }
    }

    public final void setAppId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.appId = i2;
        }
    }

    public final void setChargeOrderList(List<YbChargeItemInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, list) == null) {
            this.chargeOrderList = list;
        }
    }

    public final void setCmd(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.cmd = i2;
        }
    }

    public final void setExpand(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.expand = str;
        }
    }

    public final void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.message = str;
        }
    }

    public final void setResult(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.result = i2;
        }
    }

    public final void setSeq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.seq = str;
        }
    }

    public final void setTotal(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.total = i2;
        }
    }

    public final void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.uid = j;
        }
    }

    public final void setUsedChannel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.usedChannel = i2;
        }
    }
}
