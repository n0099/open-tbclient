package com.yy.mobile.framework.revenuesdk.payapi.bean;

import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import java.util.Map;
@Keep
/* loaded from: classes6.dex */
public class CurrencyChargeMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long amount;
    public Map<String, String> appClientExpand;
    public int appid;
    public long currencyAmount;
    public int currencyType;
    public String expand;
    public String orderId;
    public String payChannel;
    public String payMethod;
    public ChargeCurrencyReqParams reqParams;
    public int status;
    public boolean timeout;
    public long uid;
    public int usedChannel;

    public CurrencyChargeMessage() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "CurrencyChargeMessage{appid=" + this.appid + ", uid=" + this.uid + ", usedChannel=" + this.usedChannel + ", currencyType=" + this.currencyType + ", amount=" + this.amount + ", currencyAmount=" + this.currencyAmount + ", orderId=" + this.orderId + ", expand='" + this.expand + "', status='" + this.status + "', timeout='" + this.timeout + "', appClientExpand='" + this.appClientExpand + "', payMethod='" + this.payMethod + "'}";
        }
        return (String) invokeV.objValue;
    }
}
