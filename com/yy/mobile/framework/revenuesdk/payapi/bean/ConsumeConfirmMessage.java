package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ConsumeConfirmMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int appid;
    public int business_type;
    public String expand;
    public int props_buy_count;
    public double props_buy_currency_amount;
    public int props_buy_currency_type;
    public int props_count;
    public int props_id;
    public String recv_nick_name;
    public long recv_uid;
    public String recv_yy_num;
    public int result;
    public String seq;
    public long uid;
    public String user_nick_name;
    public String user_yy_num;
    public int version;

    public ConsumeConfirmMessage() {
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
