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
    public i.a.a.e.k.b f72191a;

    /* renamed from: b  reason: collision with root package name */
    public PayUIKitConfig f72192b;

    /* renamed from: c  reason: collision with root package name */
    public AppPayServiceListener f72193c;

    /* renamed from: d  reason: collision with root package name */
    public i.a.a.e.k.c f72194d;

    /* renamed from: e  reason: collision with root package name */
    public String f72195e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f72196f = false;

    /* renamed from: g  reason: collision with root package name */
    public int f72197g;

    /* renamed from: h  reason: collision with root package name */
    public int f72198h;

    /* loaded from: classes8.dex */
    public class a implements i.a.a.e.o.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72199a;

        public a(AbsViewEventHandler absViewEventHandler) {
            this.f72199a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "dismissPayAmountDialog");
            e.this.r(cancelType, this.f72199a);
            i.a.a.e.k.f.a(e.this.f72197g, e.this.f72198h, cancelType);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IYYPayAmountView.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f72201a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72202b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f72203c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72204d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72205e;

        public b(Dialog dialog, Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            this.f72201a = dialog;
            this.f72202b = activity;
            this.f72203c = viewParams;
            this.f72204d = iPayCallback;
            this.f72205e = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onRefreshViewFail(int i2, String str) {
            RLog.error("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
            i.a.a.e.n.h.f72272a.b(this.f72201a);
            e.this.s(this.f72205e, PayDialogType.PAY_NONE_DIALOG);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<PayWayInfo> list) {
            RLog.info("YYPayDialogController", "showInputNumberDialog");
            i.a.a.e.n.h.f72272a.b(this.f72201a);
            e.this.v(activity, list, this.f72203c, this.f72204d);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(i.a.a.e.l.a aVar, List<PayWayInfo> list) {
            RLog.info("YYPayDialogController", "toPayWayDialog");
            i.a.a.e.n.h.f72272a.b(this.f72201a);
            e.this.z(this.f72202b, aVar, list, this.f72203c, this.f72204d);
            i.a.a.e.m.a.b(e.this.f72197g, e.this.f72198h, UiEventType.purchasegotopay);
            RLog.warn("YYPayDialogController", UiEventType.purchasegotopay);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i.a.a.e.o.d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72207a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72208b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f72209c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayAmountView.ViewParams f72210d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72211e;

        public c(AbsViewEventHandler absViewEventHandler, Activity activity, List list, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
            this.f72207a = absViewEventHandler;
            this.f72208b = activity;
            this.f72209c = list;
            this.f72210d = viewParams;
            this.f72211e = iPayCallback;
        }

        @Override // i.a.a.e.o.d.c
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "dismissInputDialog");
            e.this.r(cancelType, this.f72207a);
        }

        @Override // i.a.a.e.o.d.c
        public void b(int i2) {
            i.a.a.e.l.a p = e.this.p((int) (i2 * 100.0d));
            RLog.info("YYPayDialogController", "showPayWayDialog: mPayAmountCustom:%s", p);
            e.this.z(this.f72208b, p, this.f72209c, this.f72210d, this.f72211e);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements i.a.a.e.o.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f72213a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72214b;

        public d(IAppPayService iAppPayService, AbsViewEventHandler absViewEventHandler) {
            this.f72213a = iAppPayService;
            this.f72214b = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "on payWayDialog cancel");
            if (e.this.f72193c != null) {
                RLog.debug("YYPayDialogController", "showPayWayDialog removePayListener");
                this.f72213a.removePayListener(e.this.f72193c);
                e.this.f72193c = null;
                e.this.f72195e = null;
            }
            e.this.r(cancelType, this.f72214b);
            i.a.a.e.k.f.b(e.this.f72197g, e.this.f72198h, cancelType);
            RLog.info("YYPayDialogController", "dismissPayWayDialog");
        }
    }

    /* renamed from: i.a.a.e.k.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1996e implements IYYPayWayView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f72216a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f72217b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72218c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72219d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72220e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72221f;

        public C1996e(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar, IPayCallback iPayCallback, AbsViewEventHandler absViewEventHandler) {
            this.f72216a = activity;
            this.f72217b = dialog;
            this.f72218c = iYYPayWayView;
            this.f72219d = bVar;
            this.f72220e = iPayCallback;
            this.f72221f = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, AppCustomExpand appCustomExpand) {
            e.this.u(this.f72216a, cVar, aVar, this.f72217b, this.f72218c, appCustomExpand, this.f72219d, this.f72220e);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void onRefreshViewFail(int i2, String str) {
            Dialog dialog = this.f72217b;
            if (dialog != null) {
                dialog.dismiss();
            }
            e.this.s(this.f72221f, PayDialogType.PAY_NONE_DIALOG);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends AppPayServiceListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f72223a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72224b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f72225c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72226d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72227e;

        public f(Activity activity, IYYPayWayView.b bVar, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
            this.f72223a = activity;
            this.f72224b = bVar;
            this.f72225c = dialog;
            this.f72226d = iYYPayWayView;
            this.f72227e = iPayCallback;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            super.onCurrencyChargeMessage(currencyChargeMessage);
            String traceid = currencyChargeMessage.reqParams.getTraceid();
            RLog.info("YYPayDialogController", "onCurrencyChargeMessage messgaeTraceId:" + traceid + " message:" + currencyChargeMessage.toString());
            if (!traceid.equals(e.this.f72195e)) {
                RLog.warn("YYPayDialogController", "messgaeTraceId not equal mTraceId");
                return;
            }
            boolean z = false;
            boolean z2 = currencyChargeMessage.status == 1;
            if (i.a.a.e.n.h.f72272a.a(this.f72223a)) {
                IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
                IYYPayWayView.b bVar2 = this.f72224b;
                z = (z2 && (bVar2 != null && bVar2.f73027d)) ? true : true;
                currencyChargeMessage.payMethod = currencyChargeMessage.reqParams.getPayMethod();
                if (z) {
                    e.this.x(this.f72223a, currencyChargeMessage, this.f72225c, bVar, this.f72226d, this.f72224b);
                } else {
                    i.a.a.e.n.h.f72272a.b(this.f72225c);
                }
            }
            IPayCallback iPayCallback = this.f72227e;
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
                IYYPayWayView.b bVar3 = this.f72224b;
                i.a.a.e.m.a.d(e.this.f72197g, currencyChargeMessage.usedChannel, (bVar3 == null || bVar3.f73029f != PaySource.WALLET) ? "7" : "14", payChannel, payMethod, String.valueOf(cid));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements IPayCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f72229a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f72230b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f72231c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f72232d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i.a.a.e.l.c f72233e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView.b f72234f;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                e.this.t(gVar.f72231c, gVar.f72232d, true);
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                e.this.t(gVar.f72231c, gVar.f72232d, false);
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!i.a.a.e.n.e.a(g.this.f72233e.f72263a) && !PayType.MOCK_TEST_PAY.getChannel().equals(g.this.f72233e.f72263a.getChannel())) {
                    g gVar = g.this;
                    e.this.t(gVar.f72231c, gVar.f72232d, true);
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
                e.this.t(gVar.f72231c, gVar.f72232d, false);
            }
        }

        /* renamed from: i.a.a.e.k.e$g$e  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1997e implements Runnable {
            public RunnableC1997e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IYYPayResultView.c cVar = new IYYPayResultView.c();
                cVar.f73022a = new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null);
                IYYPayWayView.b bVar = g.this.f72234f;
                if (bVar != null) {
                    cVar.f73023b = bVar.f73028e;
                    PaySource paySource = bVar.f73029f;
                }
                g gVar = g.this;
                e.this.y(gVar.f72230b, cVar);
                i.a.a.e.n.h.f72272a.b(g.this.f72231c);
            }
        }

        public g(IPayCallback iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, i.a.a.e.l.c cVar, IYYPayWayView.b bVar) {
            this.f72229a = iPayCallback;
            this.f72230b = activity;
            this.f72231c = dialog;
            this.f72232d = iYYPayWayView;
            this.f72233e = cVar;
            this.f72234f = bVar;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            RLog.info("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
            e.this.f72196f = false;
            IPayCallback iPayCallback = this.f72229a;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, payCallBackBean);
            }
            e.this.q(i2, str, payCallBackBean);
            if (i.a.a.e.n.h.f72272a.a(this.f72230b)) {
                if (i2 == PayStatus.CANCEL.getCode()) {
                    RLog.info("YYPayDialogController", "取消支付 code:" + i2);
                    this.f72230b.runOnUiThread(new d());
                    return;
                }
                this.f72230b.runOnUiThread(new RunnableC1997e());
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            RLog.info("YYPayDialogController", "requestPayInternal onPayStart");
            IPayCallback iPayCallback = this.f72229a;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            RLog.info("YYPayDialogController", "requestPayInternal onPayStatus code " + purchaseStatus.getCode() + " msg: " + purchaseStatus.getMessage());
            IPayCallback iPayCallback = this.f72229a;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, payCallBackBean);
            }
            if (i.a.a.e.n.h.f72272a.a(this.f72230b)) {
                if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                    this.f72230b.runOnUiThread(new a());
                } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                } else {
                    this.f72230b.runOnUiThread(new b());
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            RLog.info("YYPayDialogController", "requestPayInternal onSuccess");
            e.this.f72196f = false;
            if (i.a.a.e.n.h.f72272a.a(this.f72230b)) {
                this.f72230b.runOnUiThread(new c());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements i.a.a.e.o.d.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72241a;

        public h(AbsViewEventHandler absViewEventHandler) {
            this.f72241a = absViewEventHandler;
        }

        @Override // i.a.a.e.o.d.b
        public void a(CancelType cancelType) {
            RLog.info("YYPayDialogController", "dismissPayResultDialog");
            e.this.r(cancelType, this.f72241a);
        }
    }

    /* loaded from: classes8.dex */
    public class i implements IYYPayResultView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f72243a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AbsViewEventHandler f72244b;

        public i(Dialog dialog, AbsViewEventHandler absViewEventHandler) {
            this.f72243a = dialog;
            this.f72244b = absViewEventHandler;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void a() {
            Dialog dialog = this.f72243a;
            if (dialog != null) {
                dialog.dismiss();
            }
            e.this.s(this.f72244b, PayDialogType.PAY_NONE_DIALOG);
        }
    }

    public e(int i2, int i3, i.a.a.e.k.c cVar, i.a.a.e.k.b bVar) {
        this.f72197g = i2;
        this.f72198h = i3;
        this.f72194d = cVar;
        this.f72192b = cVar != null ? cVar.getPayUIKitConfig() : null;
        this.f72191a = bVar;
        RLog.info("YYPayDialogController", "new PayDialogController mOnPayRequest:" + this.f72196f);
    }

    public void A(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        IAppPayService a2 = i.a.a.e.n.a.a(this.f72197g, this.f72198h);
        if (a2 == null) {
            RLog.error("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
            return;
        }
        IYYPayWayView b2 = this.f72191a.b(activity, bVar);
        b2.refreshView();
        AbsViewEventHandler absViewEventHandler = bVar != null ? bVar.f73028e : null;
        s(absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
        RLog.info("YYPayDialogController", "showPayWayDialog");
        Dialog c2 = i.a.a.e.o.d.e.f72330b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), b2.getContentView(), new d(a2, absViewEventHandler), absViewEventHandler, PayDialogType.PAY_WAY_DIALOG);
        b2.setCallback(new C1996e(activity, c2, b2, bVar, iPayCallback, absViewEventHandler));
        f fVar = new f(activity, bVar, c2, b2, iPayCallback);
        this.f72193c = fVar;
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
        PayUIKitConfig payUIKitConfig = this.f72192b;
        if (payUIKitConfig != null && (middleRevenueConfig = payUIKitConfig.revenueConfig) != null && middleRevenueConfig.getCurrencyType() == 4) {
            productInfo.destAmount = i2;
            return new i.a.a.e.l.a(productInfo, 4);
        }
        productInfo.destAmount = i2;
        return new i.a.a.e.l.a(productInfo);
    }

    public final void q(int i2, String str, PayCallBackBean payCallBackBean) {
        i.a.a.e.k.c cVar = this.f72194d;
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
            i.a.a.e.o.d.e.f72330b.d(dialog);
        } else {
            i.a.a.e.o.d.e.f72330b.b(dialog);
        }
    }

    public final void u(Activity activity, i.a.a.e.l.c cVar, i.a.a.e.l.a aVar, Dialog dialog, IYYPayWayView iYYPayWayView, AppCustomExpand appCustomExpand, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        RLog.info("YYPayDialogController", " requestPayInternal mOnPayRequest:" + this.f72196f);
        if (this.f72196f) {
            RLog.info("YYPayDialogController", " requestPayInternal but OnPayRequest now");
            return;
        }
        g gVar = new g(iPayCallback, activity, dialog, iYYPayWayView, cVar, bVar);
        this.f72195e = TraceIdUtil.newTraceId();
        this.f72196f = true;
        RLog.info("YYPayDialogController", " requestPayInternal new mTraceId:" + this.f72195e + " mOnPayRequest:" + this.f72196f);
        this.f72191a.a(activity, cVar, aVar, appCustomExpand, gVar, this.f72195e);
    }

    public final void v(Activity activity, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        AbsViewEventHandler absViewEventHandler = viewParams != null ? viewParams.viewEventListener : null;
        s(absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG);
        RLog.info("YYPayDialogController", "showInputDialog");
        i.a.a.e.o.d.d.f72299a.f(activity, new c(absViewEventHandler, activity, list, viewParams, iPayCallback), absViewEventHandler, PayDialogType.PAY_INPUT_DIALOG, this.f72192b);
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
            IYYPayAmountView i3 = this.f72191a.i(activity, viewParams);
            i3.refreshView();
            String string = activity.getString(i.a.a.e.f.pay_ui_dialog_title);
            if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
                string = viewParams.payAmountDialogTitle;
            }
            RLog.info("YYPayDialogController", "showPayAmountDialog");
            s(absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG);
            i3.setCallback(new b(i.a.a.e.o.d.e.f72330b.c(activity, string, i3.getContentView(), new a(absViewEventHandler), absViewEventHandler, PayDialogType.PAY_AMOUNT_DIALOG), activity, viewParams, iPayCallback, absViewEventHandler));
        }
    }

    public final void x(Activity activity, CurrencyChargeMessage currencyChargeMessage, Dialog dialog, IYYPayResultView.b bVar, IYYPayWayView iYYPayWayView, IYYPayWayView.b bVar2) {
        if (!i.a.a.e.n.e.b(currencyChargeMessage.payChannel, currencyChargeMessage.payMethod) && !PayType.MOCK_TEST_PAY.getChannel().equals(currencyChargeMessage.payChannel)) {
            i.a.a.e.n.h.f72272a.b(dialog);
            IYYPayResultView.c cVar = new IYYPayResultView.c();
            cVar.f73022a = bVar;
            cVar.f73023b = bVar2.f73028e;
            PaySource paySource = bVar2.f73029f;
            y(activity, cVar);
            return;
        }
        t(dialog, iYYPayWayView, false);
    }

    public final void y(Activity activity, IYYPayResultView.c cVar) {
        AbsViewEventHandler absViewEventHandler = cVar != null ? cVar.f73023b : null;
        s(absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG);
        IYYPayResultView c2 = this.f72191a.c(activity, cVar);
        RLog.info("YYPayDialogController", "showPayResultDialog");
        c2.setCallback(new i(i.a.a.e.o.d.e.f72330b.c(activity, activity.getString(i.a.a.e.f.pay_ui_dialog_pay_title), c2.getContentView(), new h(absViewEventHandler), absViewEventHandler, PayDialogType.PAY_RESULT_DIALOG), absViewEventHandler));
    }

    public void z(Activity activity, i.a.a.e.l.a aVar, List<PayWayInfo> list, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        IYYPayWayView.b bVar = new IYYPayWayView.b();
        bVar.f73025b = aVar;
        bVar.f73024a = list;
        if (viewParams != null) {
            bVar.f73026c = viewParams.appCustomExpand;
            bVar.f73027d = viewParams.closeOnSuccess;
            bVar.f73028e = viewParams.viewEventListener;
        }
        A(activity, bVar, iPayCallback);
    }
}
