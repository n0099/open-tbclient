package com.repackage;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.IMiddleRevenue;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
/* loaded from: classes7.dex */
public class z3a implements r3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public PayUIKitConfig c;
    public r4a d;

    public z3a(int i, int i2, PayUIKitConfig payUIKitConfig, r4a r4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig, r4aVar};
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
        this.d = r4aVar;
    }

    @Override // com.repackage.r3a
    public void a(Activity activity, PayFlowType payFlowType, v4a v4aVar, s4a s4aVar, AppCustomExpand appCustomExpand, IPayCallback iPayCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, payFlowType, v4aVar, s4aVar, appCustomExpand, iPayCallback, str}) == null) {
            r4a r4aVar = this.d;
            if (r4aVar == null) {
                RLog.error("PayCoreImpl", "payRequest error modelProvider null", new Object[0]);
                return;
            }
            w2a b = r4aVar.b(payFlowType);
            b.r(iPayCallback);
            b.p(activity);
            b.u(s4aVar.a);
            b.w(v4aVar.a);
            b.q(appCustomExpand);
            b.A(str);
            b.v(payFlowType.getTypeId());
            PayType payType = v4aVar.a;
            if (payType == PayType.DXM_PAY_KJ || payType == PayType.UNION_PAY) {
                b.x(u4a.b(this.c));
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
