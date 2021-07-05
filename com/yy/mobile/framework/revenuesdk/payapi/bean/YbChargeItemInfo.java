package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class YbChargeItemInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String balance;
    public String comment;
    public String date;
    public String income;
    public String moneyType;
    public String other;
    public String outgo;
    public String status;
    public String tips;
    public String tradeType;

    public YbChargeItemInfo() {
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
            return "YbChargeItemInfo{comment=" + this.comment + ", date=" + this.date + ", status=" + this.status + ", other=" + this.other + ", tradeType=" + this.tradeType + ", tips=" + this.tips + ", balance=" + this.balance + ", moneyType=" + this.moneyType + ", income=" + this.income + ", outgo=" + this.outgo + '}';
        }
        return (String) invokeV.objValue;
    }
}
