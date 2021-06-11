package i.a.a.e.k;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.container.util.cache.CacheEngine;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.NetworkUtil;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.TraceIdUtil;
import com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayStatus;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import java.util.List;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PaySource;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.CancelType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.k.b f72087a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f72088b;

    /* renamed from: c  reason: collision with root package name */
    public AppPayServiceListener f72089c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.k.c f72090d;

    /* renamed from: e  reason: collision with root package name */
    public String f72091e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72092f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f72093g;

    /* renamed from: h  reason: collision with root package name */
    public int f72094h;

    /* loaded from: classes8.dex */
    public class a implements i.a.a.e.o.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72095a;

        public a(AbsViewEventHandler absViewEventHandler) {
            this.f72095a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "dismissPayAmountDialog");
            e.this.r(cancelType, this.f72095a);
            i.a.a.e.k.f.a(e.this.f72093g, e.this.f72094h, cancelType);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IYYPayAmountView.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f72097a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72098b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f72099c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72100d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72101e;

        public b(Dialog dialog, Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            this.f72097a = dialog;
            this.f72098b = activity;
            this.f72099c = viewParams;
            this.f72100d = iPayCallback;
            this.f72101e = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onRefreshViewFail(int i2, String str) {
            RLog.error("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
            i.a.a.e.n.h.f72168a.b(this.f72097a);
            e.this.s(this.f72101e, PayDialogType.PAY_NONE_DIALOG);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
            RLog.info("YYPayDialogController", "showInputNumberDialog");
            i.a.a.e.n.h.f72168a.b(this.f72097a);
            e.this.v(activity, list, this.f72099c, this.f72100d);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(i.a.a.e.l.a aVar, List<PayWayInfo> list) {
            RLog.info("YYPayDialogController", "toPayWayDialog");
            i.a.a.e.n.h.f72168a.b(this.f72097a);
            e.this.z(this.f72098b, aVar, list, this.f72099c, this.f72100d);
            i.a.a.e.m.a.b(e.this.f72093g, e.this.f72094h, UiEventType.purchasegotopay);
            RLog.warn("YYPayDialogController", UiEventType.purchasegotopay);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i.a.a.e.o.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72103a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72104b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f72105c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f72106d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72107e;

        public c(AbsViewEventHandler absViewEventHandler, Activity activity, List list, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
            this.f72103a = absViewEventHandler;
            this.f72104b = activity;
            this.f72105c = list;
            this.f72106d = viewParams;
            this.f72107e = iPayCallback;
        }

        @Override // i.a.a.e.o.d.c
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "dismissInputDialog");
            e.this.r(cancelType, this.f72103a);
        }

        @Override // i.a.a.e.o.d.c
        public void b(int i2) {
            i.a.a.e.l.a p = e.this.p((int) (i2 * 100.0d));
            RLog.info("YYPayDialogController", "showPayWayDialog: mPayAmountCustom:%s", p);
            e.this.z(this.f72104b, p, this.f72105c, this.f72106d, this.f72107e);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements i.a.a.e.o.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f72109a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72110b;

        public d(IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
            this.f72109a = iAppPayService;
            this.f72110b = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "on payWayDialog cancel");
            if (e.this.f72089c != null) {
                RLog.debug("YYPayDialogController", "showPayWayDialog removePayListener");
                this.f72109a.removePayListener(e.this.f72089c);
                e.this.f72089c = null;
                e.this.f72091e = null;
            }
            e.this.r(cancelType, this.f72110b);
            i.a.a.e.k.f.b(e.this.f72093g, e.this.f72094h, cancelType);
            RLog.info("YYPayDialogController", "dismissPayWayDialog");
        }
    }

    /* renamed from: i.a.a.e.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1993e implements IYYPayWayView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f72112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f72113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72114c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72115d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72116e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72117f;

        public C1993e(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            this.f72112a = activity;
            this.f72113b = dialog;
            this.f72114c = iYYPayWayView;
            this.f72115d = bVar;
            this.f72116e = iPayCallback;
            this.f72117f = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand) {
            e.this.u(this.f72112a, cVar, aVar, this.f72113b, this.f72114c, appCustomExpand, this.f72115d, this.f72116e);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void onRefreshViewFail(int i2, String str) {
            Dialog dialog = this.f72113b;
            if (dialog != null) {
                dialog.dismiss();
            }
            e.this.s(this.f72117f, PayDialogType.PAY_NONE_DIALOG);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends AppPayServiceListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f72119a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72120b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f72121c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72122d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72123e;

        public f(Activity activity, IYYPayWayView.b bVar, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
            this.f72119a = activity;
            this.f72120b = bVar;
            this.f72121c = dialog;
            this.f72122d = iYYPayWayView;
            this.f72123e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            super.onCurrencyChargeMessage(currencyChargeMessage);
            String traceid = currencyChargeMessage.reqParams.getTraceid();
            RLog.info("YYPayDialogController", "onCurrencyChargeMessage messgaeTraceId:" + traceid + " message:" + currencyChargeMessage.toString());
            if (!traceid.equals(e.this.f72091e)) {
                RLog.warn("YYPayDialogController", "messgaeTraceId not equal mTraceId");
                return;
            }
            boolean z = false;
            boolean z2 = currencyChargeMessage.status == 1;
            if (i.a.a.e.n.h.f72168a.a(this.f72119a)) {
                IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                IYYPayWayView.b bVar2 = this.f72120b;
                z = (z2 && (bVar2 != null && bVar2.f72923d)) ? true : true;
                currencyChargeMessage.payMethod = currencyChargeMessage.reqParams.getPayMethod();
                if (z) {
                    e.this.x(this.f72119a, currencyChargeMessage, this.f72121c, bVar, this.f72122d, this.f72120b);
                } else {
                    i.a.a.e.n.h.f72168a.b(this.f72121c);
                }
            }
            IPayCallback iPayCallback = this.f72123e;
            if (iPayCallback != null) {
                if (z2) {
                    iPayCallback.onSuccess(currencyChargeMessage, null);
                } else {
                    iPayCallback.onFail(currencyChargeMessage.status, "", null);
                }
            }
            if (z2) {
                int cid = currencyChargeMessage.reqParams.getCid();
                String payChannel = currencyChargeMessage.reqParams.getPayChannel();
                String payMethod = currencyChargeMessage.reqParams.getPayMethod();
                IYYPayWayView.b bVar3 = this.f72120b;
                i.a.a.e.m.a.d(e.this.f72093g, currencyChargeMessage.usedChannel, (bVar3 == null || bVar3.f72925f != PaySource.WALLET) ? "7" : "14", payChannel, payMethod, String.valueOf(cid));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements IPayCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72125a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72126b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f72127c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72128d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.l.c f72129e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72130f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                e.this.t(gVar.f72127c, gVar.f72128d, true);
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                e.this.t(gVar.f72127c, gVar.f72128d, false);
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!i.a.a.e.n.e.a(g.this.f72129e.f72159a) && !PayType.MOCK_TEST_PAY.getChannel().equals(g.this.f72129e.f72159a.getChannel())) {
                    g gVar = g.this;
                    e.this.t(gVar.f72127c, gVar.f72128d, true);
                    return;
                }
                RLog.info("YYPayDialogController", "requestPayInternal onSuccess h5 not loadding");
            }
        }

        /* loaded from: classes8.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                e.this.t(gVar.f72127c, gVar.f72128d, false);
            }
        }

        /* renamed from: i.a.a.e.k.e$g$e  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1994e implements Runnable {
            public RunnableC1994e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                cVar.f72918a = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                IYYPayWayView.b bVar = g.this.f72130f;
                if (bVar != null) {
                    cVar.f72919b = bVar.f72924e;
                    PaySource paySource = bVar.f72925f;
                }
                g gVar = g.this;
                e.this.y(gVar.f72126b, cVar);
                i.a.a.e.n.h.f72168a.b(g.this.f72127c);
            }
        }

        public g(IPayCallback iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, i.a.a.e.l.c cVar, IYYPayWayView.b bVar) {
            this.f72125a = iPayCallback;
            this.f72126b = activity;
            this.f72127c = dialog;
            this.f72128d = iYYPayWayView;
            this.f72129e = cVar;
            this.f72130f = bVar;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            RLog.info("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
            e.this.f72092f = false;
            IPayCallback iPayCallback = this.f72125a;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, payCallBackBean);
            }
            e.this.q(i2, str, payCallBackBean);
            if (i.a.a.e.n.h.f72168a.a(this.f72126b)) {
                if (i2 == PayStatus.CANCEL.getCode()) {
                    RLog.info("YYPayDialogController", "取消支付 code:" + i2);
                    this.f72126b.runOnUiThread(new d());
                    return;
                }
                this.f72126b.runOnUiThread(new RunnableC1994e());
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            RLog.info("YYPayDialogController", "requestPayInternal onPayStart");
            IPayCallback iPayCallback = this.f72125a;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            RLog.info("YYPayDialogController", "requestPayInternal onPayStatus code " + purchaseStatus.getCode() + " msg: " + purchaseStatus.getMessage());
            IPayCallback iPayCallback = this.f72125a;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
            if (i.a.a.e.n.h.f72168a.a(this.f72126b)) {
                if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                    this.f72126b.runOnUiThread(new a());
                } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                } else {
                    this.f72126b.runOnUiThread(new b());
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            RLog.info("YYPayDialogController", "requestPayInternal onSuccess");
            e.this.f72092f = false;
            if (i.a.a.e.n.h.f72168a.a(this.f72126b)) {
                this.f72126b.runOnUiThread(new c());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements i.a.a.e.o.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72137a;

        public h(AbsViewEventHandler absViewEventHandler) {
            this.f72137a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "dismissPayResultDialog");
            e.this.r(cancelType, this.f72137a);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements IYYPayResultView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f72139a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72140b;

        public i(Dialog dialog, AbsViewEventHandler absViewEventHandler) {
            this.f72139a = dialog;
            this.f72140b = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void a() {
            Dialog dialog = this.f72139a;
            if (dialog != null) {
                dialog.dismiss();
            }
            e.this.s(this.f72140b, PayDialogType.PAY_NONE_DIALOG);
        }
    }

    public e(int i2, int i3, i.a.a.e.k.c cVar, i.a.a.e.k.b bVar) {
        this.f72093g = i2;
        this.f72094h = i3;
        this.f72090d = cVar;
        this.f72088b = cVar != null ? cVar.getPayUIKitConfig() : null;
        this.f72087a = bVar;
        RLog.info("YYPayDialogController", "new PayDialogController mOnPayRequest:" + this.f72092f);
    }

    public void A(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        IAppPayService a2 = i.a.a.e.n.a.a(this.f72093g, this.f72094h);
        if (a2 == null) {
            RLog.error("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
            return;
        }
        IYYPayWayView b2 = this.f72087a.b(activity, bVar);
        b2.refreshView();
        AbsViewEventHandler absViewEventHandler = bVar != null ? bVar.f72924e : null;
        s(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
        RLog.info("YYPayDialogController", "showPayWayDialog");
        Dialog c2 = i.a.a.e.o.d.e.f72226b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), b2.getContentView(), new d(a2, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
        b2.setCallback(new C1993e(activity, c2, b2, bVar, iPayCallback, absViewEventHandler));
        f fVar = new f(activity, bVar, c2, b2, iPayCallback);
        this.f72089c = fVar;
        a2.addPayListener(fVar);
        RLog.debug("YYPayDialogController", "showPayWayDialog addPayListener");
    }

    public i.a.a.e.l.a p(int i2) {
        MiddleRevenueConfig middleRevenueConfig;
        ProductInfo productInfo = new ProductInfo();
        productInfo.cid = 0;
        productInfo.productId = "";
        productInfo.srcCurrencySymbol = "";
        productInfo.srcAmount = Double.valueOf(i2 / 100.0d);
        PayUIKitConfig payUIKitConfig = this.f72088b;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null && middleRevenueConfig.getCurrencyType() == 4) {
            productInfo.destAmount = i2;
            return new i.a.a.e.l.a(productInfo, 4);
        }
        productInfo.destAmount = i2;
        return new i.a.a.e.l.a(productInfo);
    }

    public final void q(int i2, String str, PayCallBackBean payCallBackBean) {
        i.a.a.e.k.c cVar = this.f72090d;
        if (cVar != null) {
            cVar.notifyYYPayFailListener(i2, str, payCallBackBean);
        }
    }

    public final void r(CancelType cancelType, AbsViewEventHandler absViewEventHandler) {
        RLog.info("YYPayDialogController", "notifyViewFlowClose");
        if (absViewEventHandler == null) {
            RLog.info("YYPayDialogController", "notifyViewFlowClose listener null");
        } else if (cancelType == CancelType.BUTTOM_AREA_CLICK || cancelType == CancelType.EMPTY_AREA_CLICK || cancelType == CancelType.ON_DIALOG_CANCEL || cancelType == CancelType.ON_START_SHOW_FAIL) {
            s(absViewEventHandler, PayDialogType.PAY_NONE_DIALOG);
        }
    }

    public final void s(AbsViewEventHandler absViewEventHandler, PayDialogType payDialogType) {
        if (absViewEventHandler != null && payDialogType != null) {
            RLog.info("YYPayDialogController", "notifyViewStateChange payDialogType:" + payDialogType.name());
            absViewEventHandler.onViewStateChange(payDialogType);
            return;
        }
        RLog.info("YYPayDialogController", "notifyViewStateChange null");
    }

    public final void t(Dialog dialog, IYYPayWayView iYYPayWayView, boolean z) {
        IYYPayWayView.PayViewState payViewState = z ? IYYPayWayView.PayViewState.WAITING_VIEW_STATE : IYYPayWayView.PayViewState.SELECTING_VIEW_STATE;
        if (iYYPayWayView != null) {
            iYYPayWayView.setViewState(payViewState);
        }
        if (z) {
            i.a.a.e.o.d.e.f72226b.d(dialog);
        } else {
            i.a.a.e.o.d.e.f72226b.b(dialog);
        }
    }

    public final void u(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        RLog.info("YYPayDialogController", " requestPayInternal mOnPayRequest:" + this.f72092f);
        if (this.f72092f) {
            RLog.info("YYPayDialogController", " requestPayInternal but OnPayRequest now");
            return;
        }
        g gVar = new g(iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar);
        this.f72091e = TraceIdUtil.newTraceId();
        this.f72092f = true;
        RLog.info("YYPayDialogController", " requestPayInternal new mTraceId:" + this.f72091e + " mOnPayRequest:" + this.f72092f);
        this.f72087a.a(activity, cVar, aVar, appCustomExpand, gVar, this.f72091e);
    }

    public final void v(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
        s(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
        RLog.info("YYPayDialogController", "showInputDialog");
        i.a.a.e.o.d.d.f72195a.f(activity, new c(absViewEventHandler, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f72088b);
    }

    public void w(Activity activity, IPayCallback<CurrencyChargeMessage> iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        int i2;
        AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
        if (!NetworkUtil.isNetworkStrictlyAvailable(activity)) {
            Toast.makeText(activity, "网络不给力，请稍后重试", 1).show();
            RLog.error("YYPayDialogController", "showPayAmountDialog fail: network error", new Object[0]);
            r(CancelType.ON_START_SHOW_FAIL, absViewEventHandler);
        } else if (viewParams != null && (i2 = viewParams.targetAmount) > 0) {
            if (i2 > 5.0E7d) {
                viewParams.targetAmount = CacheEngine.MAX_DISK_CACHE;
            }
            z(activity, p(viewParams.targetAmount), null, viewParams, iPayCallback);
            RLog.info("YYPayDialogController", "showPayAmountDialog targetAmount:" + viewParams.targetAmount);
        } else {
            IYYPayAmountView i3 = this.f72087a.i(activity, viewParams);
            i3.refreshView();
            String string = activity.getString(i.a.a.e.f.pay_ui_dialog_title);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            RLog.info("YYPayDialogController", "showPayAmountDialog");
            s(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            i3.setCallback(new b(i.a.a.e.o.d.e.f72226b.c(activity, string, i3.getContentView(), new a(absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG), activity, viewParams, iPayCallback, absViewEventHandler));
        }
    }

    public final void x(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        if (!i.a.a.e.n.e.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod) && !PayType.MOCK_TEST_PAY.getChannel().equals(currencyChargeMessage.payChannel)) {
            i.a.a.e.n.h.f72168a.b(dialog);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.f72918a = bVar;
            cVar.f72919b = bVar2.f72924e;
            PaySource paySource = bVar2.f72925f;
            y(activity, cVar);
            return;
        }
        t(dialog, iYYPayWayView, false);
    }

    public final void y(Activity activity, IYYPayResultView.c cVar) {
        AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f72919b : null;
        s(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
        IYYPayResultView c2 = this.f72087a.c(activity, cVar);
        RLog.info("YYPayDialogController", "showPayResultDialog");
        c2.setCallback(new i(i.a.a.e.o.d.e.f72226b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), c2.getContentView(), new h(absViewEventHandler), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG), absViewEventHandler));
    }

    public void z(Activity activity, i.a.a.e.l.a aVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        IYYPayWayView.b bVar = new IYYPayWayView.b();
        bVar.f72921b = aVar;
        bVar.f72920a = list;
        if (viewParams != null) {
            bVar.f72922c = viewParams.appCustomExpand;
            bVar.f72923d = viewParams.closeOnSuccess;
            bVar.f72924e = viewParams.viewEventListener;
        }
        A(activity, bVar, iPayCallback);
    }
}
