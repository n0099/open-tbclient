package com.kwad.sdk.contentalliance.coupon.model;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.kwai.a;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class CouponStatusInfo extends a implements b, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -6390497068195603159L;
    public transient /* synthetic */ FieldHolder $fh;
    public int couponLeftTimes;
    public double currTotalAmount;
    public boolean isNewUser;
    public int statusCode;
    public String statusName;

    public CouponStatusInfo() {
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
        this.statusCode = -1;
        this.statusName = "";
        this.currTotalAmount = 0.0d;
        this.couponLeftTimes = 0;
        this.isNewUser = false;
    }
}
