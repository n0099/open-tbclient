package com.yy.mobile.framework.revenuesdk.payservice.revenueservice.protocol;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.ExchangeResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00102\u001a\u00020\u0005¢\u0006\u0004\b3\u0010\tJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\tR\"\u0010#\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\"\u0010&\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!\"\u0004\b(\u0010\tR\"\u0010)\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u0010,\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\f\u001a\u0004\b-\u0010\u000e\"\u0004\b.\u0010\u0010R\"\u0010/\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\f\u001a\u0004\b0\u0010\u000e\"\u0004\b1\u0010\u0010¨\u00064"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/revenueservice/protocol/ExchangeCurrencyResponse;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/IBaseJsonResponse;", "Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/ExchangeResult;", "getResponse", "()Lcom/yy/mobile/framework/revenuesdk/payapi/callbackresult/ExchangeResult;", "", "jsonMsg", "", "parserResponse", "(Ljava/lang/String;)V", "", "descRemainAmount", "J", "getDescRemainAmount", "()J", "setDescRemainAmount", "(J)V", "", "destCurrencyType", "I", "getDestCurrencyType", "()I", "setDestCurrencyType", "(I)V", "exchangeAmount", "getExchangeAmount", "setExchangeAmount", "exchangeDestAmount", "getExchangeDestAmount", "setExchangeDestAmount", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", TiebaStatic.LogFields.RESULT, "getResult", "setResult", "seq", "getSeq", "setSeq", "srcCurrencyType", "getSrcCurrencyType", "setSrcCurrencyType", "srcRemainAmount", "getSrcRemainAmount", "setSrcRemainAmount", "uid", "getUid", "setUid", "rspData", "<init>", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class ExchangeCurrencyResponse implements IBaseJsonResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long descRemainAmount;
    public int destCurrencyType;
    public int exchangeAmount;
    public long exchangeDestAmount;
    public String message;
    public int result;
    public String seq;
    public int srcCurrencyType;
    public long srcRemainAmount;
    public long uid;

    public ExchangeCurrencyResponse(String str) {
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
        this.seq = "";
        this.result = -1;
        this.message = "";
        parserResponse(str);
    }

    public final long getDescRemainAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.descRemainAmount : invokeV.longValue;
    }

    public final int getDestCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.destCurrencyType : invokeV.intValue;
    }

    public final int getExchangeAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.exchangeAmount : invokeV.intValue;
    }

    public final long getExchangeDestAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.exchangeDestAmount : invokeV.longValue;
    }

    public final String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.message : (String) invokeV.objValue;
    }

    public final ExchangeResult getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new ExchangeResult(this.srcCurrencyType, this.srcRemainAmount, this.destCurrencyType, this.descRemainAmount, this.exchangeDestAmount, this.exchangeAmount) : (ExchangeResult) invokeV.objValue;
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

    public final int getSrcCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.srcCurrencyType : invokeV.intValue;
    }

    public final long getSrcRemainAmount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.srcRemainAmount : invokeV.longValue;
    }

    public final long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.uid : invokeV.longValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IBaseJsonResponse
    public void parserResponse(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("seq", "");
            Intrinsics.checkExpressionValueIsNotNull(optString, "jObject.optString(\"seq\", \"\")");
            this.seq = optString;
            this.uid = jSONObject.optLong("uid", 0L);
            this.result = jSONObject.optInt(TiebaStatic.LogFields.RESULT, 0);
            String optString2 = jSONObject.optString("message", "");
            Intrinsics.checkExpressionValueIsNotNull(optString2, "jObject.optString(\"message\", \"\")");
            this.message = optString2;
            this.srcCurrencyType = jSONObject.optInt("srcCurrencyType", 0);
            this.srcRemainAmount = jSONObject.optLong("srcRemainAmount", 0L);
            this.destCurrencyType = jSONObject.optInt("destCurrencyType", 0);
            this.descRemainAmount = jSONObject.optLong("descRemainAmount", 0L);
            this.exchangeDestAmount = jSONObject.optLong("exchangeDestAmount", 0L);
            this.exchangeAmount = jSONObject.optInt("exchangeAmount", 0);
        }
    }

    public final void setDescRemainAmount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j) == null) {
            this.descRemainAmount = j;
        }
    }

    public final void setDestCurrencyType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.destCurrencyType = i;
        }
    }

    public final void setExchangeAmount(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.exchangeAmount = i;
        }
    }

    public final void setExchangeDestAmount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.exchangeDestAmount = j;
        }
    }

    public final void setMessage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.message = str;
        }
    }

    public final void setResult(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.result = i;
        }
    }

    public final void setSeq(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.seq = str;
        }
    }

    public final void setSrcCurrencyType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.srcCurrencyType = i;
        }
    }

    public final void setSrcRemainAmount(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.srcRemainAmount = j;
        }
    }

    public final void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.uid = j;
        }
    }
}
