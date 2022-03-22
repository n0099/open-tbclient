package com.yy.mobile.framework.revenuesdk.payapi.bean;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
@Keep
/* loaded from: classes7.dex */
public class CurrencyChargeMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long amount;
    public Map<String, String> appClientExpand;
    public int appid;
    public int cid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public boolean finish;
    public GiftBagsInfo giftBagsInfo;
    public String message;
    public String orderId;
    public String payChannel;
    public String payMethod;
    public int status;
    public String traceid;
    public long uid;
    public int usedChannel;

    public CurrencyChargeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.traceid = "";
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "CurrencyChargeMessage{appid=" + this.appid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", message=" + this.message + ", finish=" + this.finish + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", orderId=" + this.orderId + ", expand='" + this.expand + "', status='" + this.status + "', cid='" + this.cid + "', traceid='" + this.traceid + "', appClientExpand='" + this.appClientExpand + "', payMethod='" + this.payMethod + "', payChannel='" + this.payChannel + "', giftBagsInfo='" + this.giftBagsInfo + "'}";
        }
        return (String) invokeV.objValue;
    }
}
