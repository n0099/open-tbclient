package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.IH5PayActivityVisit;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes6.dex */
public class o0a implements IH5PayActivityVisit {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o0a() {
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

    @Override // com.yy.mobile.framework.revenuesdk.payservice.IH5PayActivityVisit
    public void notifyPayFlowActivityVisit(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, str, i, i2, i3) == null) {
            RLog.info("H5PayActivityVisitImpl", "notifyPayFlowActivityVisit mAppId:" + i + " mUserChannel:" + i2 + " name:" + str);
            PayFlowType a = k2a.a(i3);
            if (a == null) {
                RLog.error("H5PayActivityVisitImpl", "notifyPayFlowActivityVisit mAppId:" + i + " mUserChannel:" + i2 + " name:" + str + " payFlowType null", new Object[0]);
                return;
            }
            e0a.b(str, i, i2, a);
        }
    }
}
