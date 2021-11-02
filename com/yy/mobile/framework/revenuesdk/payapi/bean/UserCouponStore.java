package com.yy.mobile.framework.revenuesdk.payapi.bean;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class UserCouponStore {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long acquireTime;
    public int appid;
    public double couponAmount;
    public int couponId;
    public double couponLimitAmount;
    public String couponName;
    public int couponType;
    public int couponUseWay;
    public String couponUseWayInfo;
    public String humanId;
    public int id;
    public long lockReleaseTime;
    public int srcType;
    public int status;
    public long uid;
    public long validEndTime;
    public long validStartTime;

    public UserCouponStore() {
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
