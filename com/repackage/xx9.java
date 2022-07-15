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
public class xx9 implements px9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public PayUIKitConfig c;
    public py9 d;

    public xx9(int i, int i2, PayUIKitConfig payUIKitConfig, py9 py9Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), payUIKitConfig, py9Var};
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
        this.d = py9Var;
    }

    @Override // com.repackage.px9
    public void a(Activity activity, PayFlowType payFlowType, ty9 ty9Var, qy9 qy9Var, AppCustomExpand appCustomExpand, IPayCallback iPayCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, payFlowType, ty9Var, qy9Var, appCustomExpand, iPayCallback, str}) == null) {
            py9 py9Var = this.d;
            if (py9Var == null) {
                RLog.error("PayCoreImpl", "payRequest error modelProvider null", new Object[0]);
                return;
            }
            uw9 b = py9Var.b(payFlowType);
            b.r(iPayCallback);
            b.p(activity);
            b.u(qy9Var.a);
            b.w(ty9Var.a);
            b.q(appCustomExpand);
            b.A(str);
            b.v(payFlowType.getTypeId());
            PayType payType = ty9Var.a;
            if (payType == PayType.DXM_PAY_KJ || payType == PayType.UNION_PAY) {
                b.x(sy9.b(this.c));
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
