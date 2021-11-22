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
/* loaded from: classes2.dex */
public class b implements i.a.a.e.o.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.c f73220a;

    /* renamed from: b  reason: collision with root package name */
    public AbsViewEventHandler f73221b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f73222c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f73223d;

    /* renamed from: e  reason: collision with root package name */
    public List<PayWayInfo> f73224e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f73225f;

    /* renamed from: g  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f73226g;

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
        this.f73220a = cVar;
        this.f73221b = absViewEventHandler;
        this.f73222c = payUIKitConfig;
        this.f73223d = activity;
        this.f73224e = list;
        this.f73225f = viewParams;
        this.f73226g = iPayCallback;
    }

    @Override // i.a.a.e.o.g.d
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountInputDialogListener", "InputDialog notifyCancelType clickArea:" + cancelType);
            this.f73220a.b(cancelType, this.f73221b);
        }
    }

    @Override // i.a.a.e.o.g.d
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            i.a.a.e.l.c a2 = i.a.a.e.n.b.a((int) (i2 * 100.0d), this.f73222c);
            RLog.info("AmountInputDialogListener", "showInputDialog: mPayAmountCustom:%s", a2);
            this.f73220a.e(this.f73223d, a2, this.f73224e, this.f73225f, this.f73226g);
        }
    }
}
