package j.a.a.e.k;

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
/* loaded from: classes3.dex */
public class j implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f64100b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f64101c;

    /* renamed from: d  reason: collision with root package name */
    public j.a.a.e.l.b f64102d;

    public j(int i2, int i3, PayUIKitConfig payUIKitConfig, j.a.a.e.l.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), payUIKitConfig, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = i2;
        this.f64100b = i3;
        this.f64101c = payUIKitConfig;
        this.f64102d = bVar;
    }

    @Override // j.a.a.e.k.b
    public void a(Activity activity, PayFlowType payFlowType, j.a.a.e.l.f fVar, j.a.a.e.l.c cVar, AppCustomExpand appCustomExpand, IPayCallback iPayCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{activity, payFlowType, fVar, cVar, appCustomExpand, iPayCallback, str}) == null) {
            j.a.a.e.l.b bVar = this.f64102d;
            if (bVar == null) {
                RLog.error("PayCoreImpl", "payRequest error modelProvider null", new Object[0]);
                return;
            }
            j.a.a.b.b.a.a b2 = bVar.b(payFlowType);
            b2.q(iPayCallback);
            b2.o(activity);
            b2.t(cVar.a);
            b2.u(fVar.a);
            b2.p(appCustomExpand);
            b2.y(str);
            PayType payType = fVar.a;
            if (payType == PayType.DXM_PAY_KJ || payType == PayType.UNION_PAY) {
                b2.v(j.a.a.e.l.e.b(this.f64101c));
            }
            IMiddleRevenue middleRevenue = RevenueManager.instance().getMiddleRevenue(this.a, this.f64100b);
            if (middleRevenue != null && middleRevenue.getMiddlePayService() != null) {
                middleRevenue.getMiddlePayService().a(b2);
            } else {
                RLog.error("PayCoreImpl", "requestPay error middleRevenue null", new Object[0]);
            }
        }
    }
}
