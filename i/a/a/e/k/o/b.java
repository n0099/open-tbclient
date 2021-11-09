package i.a.a.e.k.o;

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
/* loaded from: classes3.dex */
public class b implements i.a.a.e.o.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.c f72301a;

    /* renamed from: b  reason: collision with root package name */
    public AbsViewEventHandler f72302b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f72303c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f72304d;

    /* renamed from: e  reason: collision with root package name */
    public List<PayWayInfo> f72305e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f72306f;

    /* renamed from: g  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f72307g;

    public b(i.a.a.e.k.c cVar, AbsViewEventHandler absViewEventHandler, PayUIKitConfig payUIKitConfig, Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, absViewEventHandler, payUIKitConfig, activity, list, viewParams, iPayCallback};
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
        this.f72301a = cVar;
        this.f72302b = absViewEventHandler;
        this.f72303c = payUIKitConfig;
        this.f72304d = activity;
        this.f72305e = list;
        this.f72306f = viewParams;
        this.f72307g = iPayCallback;
    }

    @Override // i.a.a.e.o.g.d
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountInputDialogListener", "InputDialog notifyCancelType clickArea:" + cancelType);
            this.f72301a.b(cancelType, this.f72302b);
        }
    }

    @Override // i.a.a.e.o.g.d
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            i.a.a.e.l.c a2 = i.a.a.e.n.b.a((int) (i2 * 100.0d), this.f72303c);
            RLog.info("AmountInputDialogListener", "showInputDialog: mPayAmountCustom:%s", a2);
            this.f72301a.e(this.f72304d, a2, this.f72305e, this.f72306f, this.f72307g);
        }
    }
}
