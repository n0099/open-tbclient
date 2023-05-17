package com.fun.ad.sdk.internal.api;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class BiddingConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BIDDING_STATUS_FAIL = 2;
    public static final int BIDDING_STATUS_LOAD_ERR = 5;
    public static final int BIDDING_STATUS_NORMAL = 0;
    public static final int BIDDING_STATUS_NOTLOAD = 3;
    public static final int BIDDING_STATUS_STARTED = 4;
    public static final int BIDDING_STATUS_SUCCESS = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public BiddingConstants() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
