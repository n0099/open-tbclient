package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class RevenueRecord {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONSUME = 3;
    public static final int RECHARGE = 18;
    public transient /* synthetic */ FieldHolder $fh;
    public long amountChange;
    public long amountRemain;
    public long currencyType;
    public String description;
    public long freezedChange;
    public long freezedRemain;
    public int id;
    public String optName;
    public long optTime;
    public int optType;
    public long uid;

    public RevenueRecord() {
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
}
