package com.yy.mobile.framework.revenuesdk.payservice.impl;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class H5PayVerifyTask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public H5PayParams h5PayParams;
    public String mCurrentOrderId;
    public int mCurrentRetryCount;
    public int mCurrentRetryInterval;

    public H5PayVerifyTask() {
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
        this.mCurrentOrderId = null;
        this.mCurrentRetryCount = 0;
        this.mCurrentRetryInterval = 1;
    }
}
