package com.repackage;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes6.dex */
public class l1a implements m0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public PayUIKitConfig c;
    public v1a d;

    public l1a(int i, int i2, PayUIKitConfig payUIKitConfig, v1a v1aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig, v1aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i;
        this.b = i2;
        this.c = payUIKitConfig;
        this.d = v1aVar;
    }

    @Override // com.repackage.m0a
    public void a(Activity activity, PayFlowType payFlowType, z1a z1aVar, w1a w1aVar, AppCustomExpand appCustomExpand, Map<String, String> map, IPayCallback iPayCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, payFlowType, z1aVar, w1aVar, appCustomExpand, map, iPayCallback, str}) == null) {
            v1a v1aVar = this.d;
            if (v1aVar == null) {
                RLog.error("PayCoreImpl", "payRequest error modelProvider null", new Object[0]);
                return;
            }
            qz9 b = v1aVar.b(payFlowType, map);
            b.r(iPayCallback);
            b.p(activity);
            b.u(w1aVar.a);
            b.w(z1aVar.a);
            b.q(appCustomExpand);
            b.A(str);
            b.v(payFlowType.getTypeId());
            PayType payType = z1aVar.a;
            if (payType == PayType.DXM_PAY_KJ || payType == PayType.UNION_PAY || payType == PayType.DXM_PAY_H5) {
                b.x(y1a.b(this.c));
            }
            IMiddleRevenue middleRevenue = RevenueManager.instance().getMiddleRevenue(this.a, this.b);
            if (middleRevenue != null && middleRevenue.getMiddlePayService() != null) {
                middleRevenue.getMiddlePayService().a(b);
            } else {
                RLog.error("PayCoreImpl", "requestPay error middleRevenue null", new Object[0]);
            }
        }
    }
}
