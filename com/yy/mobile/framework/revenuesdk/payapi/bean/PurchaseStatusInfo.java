package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes8.dex */
public class PurchaseStatusInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String chorderid;
    public String orderId;
    public String productId;
    public String purchaseData;
    public String purchaseSign;
    public int status;
    public long uid;

    public PurchaseStatusInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.productId = "";
        this.orderId = "";
        this.uid = 0L;
        this.status = 0;
        this.chorderid = "";
        this.purchaseData = "";
        this.purchaseSign = "";
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "PurchaseStatusInfo{productId=" + this.productId + ", orderId=" + this.orderId + ", status='" + this.status + ", chorderid='" + this.chorderid + ", purchaseData='" + this.purchaseData + ", purchaseSign='" + this.purchaseSign + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
