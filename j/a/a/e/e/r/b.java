package j.a.a.e.e.r;

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
/* loaded from: classes8.dex */
public class b implements j.a.a.e.i.g.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j.a.a.e.e.f a;

    /* renamed from: b  reason: collision with root package name */
    public AbsViewEventHandler f60865b;

    /* renamed from: c  reason: collision with root package name */
    public PayUIKitConfig f60866c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f60867d;

    /* renamed from: e  reason: collision with root package name */
    public List<PayWayInfo> f60868e;

    /* renamed from: f  reason: collision with root package name */
    public IYYPayAmountView.ViewParams f60869f;

    /* renamed from: g  reason: collision with root package name */
    public IPayCallback<CurrencyChargeMessage> f60870g;

    public b(j.a.a.e.e.f fVar, AbsViewEventHandler absViewEventHandler, PayUIKitConfig payUIKitConfig, Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
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
        this.f60865b = absViewEventHandler;
        this.f60866c = payUIKitConfig;
        this.f60867d = activity;
        this.f60868e = list;
        this.f60869f = viewParams;
        this.f60870g = iPayCallback;
    }

    @Override // j.a.a.e.i.g.d
    public void a(CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cancelType) == null) {
            RLog.info("AmountInputDialogListener", "InputDialog notifyCancelType clickArea:" + cancelType);
            this.a.c(cancelType, this.f60865b);
        }
    }

    @Override // j.a.a.e.i.g.d
    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            j.a.a.e.f.c a = j.a.a.e.h.b.a((int) (i2 * 100.0d), this.f60866c);
            RLog.info("AmountInputDialogListener", "showInputDialog: mPayAmountCustom:%s", a);
            this.a.g(this.f60867d, a, this.f60868e, this.f60869f, this.f60870g);
        }
    }
}
