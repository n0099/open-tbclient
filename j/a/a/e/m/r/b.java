package j.a.a.e.m.r;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes4.dex */
public class b implements j.a.a.e.q.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j.a.a.e.m.f a;

    /* renamed from: b  reason: collision with root package name */
    public AbsViewEventHandler f62348b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f62349c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f62350d;

    /* renamed from: e  reason: collision with root package name */
    public List<PayWayInfo> f62351e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f62352f;

    /* renamed from: g  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f62353g;

    public b(j.a.a.e.m.f fVar, AbsViewEventHandler absViewEventHandler, PayUIKitConfig payUIKitConfig, Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, absViewEventHandler, payUIKitConfig, activity, list, viewParams, iPayCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        RLog.info("AmountInputDialogListener", "create AmountInputDialogListener");
        this.a = fVar;
        this.f62348b = absViewEventHandler;
        this.f62349c = payUIKitConfig;
        this.f62350d = activity;
        this.f62351e = list;
        this.f62352f = viewParams;
        this.f62353g = iPayCallback;
    }

    @Override // j.a.a.e.q.g.d
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountInputDialogListener", "InputDialog notifyCancelType clickArea:" + cancelType);
            this.a.c(cancelType, this.f62348b);
        }
    }

    @Override // j.a.a.e.q.g.d
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            j.a.a.e.n.c a = j.a.a.e.p.b.a((int) (i2 * 100.0d), this.f62349c);
            RLog.info("AmountInputDialogListener", "showInputDialog: mPayAmountCustom:%s", a);
            this.a.g(this.f62350d, a, this.f62351e, this.f62352f, this.f62353g);
        }
    }
}
