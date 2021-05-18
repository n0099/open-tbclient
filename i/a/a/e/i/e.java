package i.a.a.e.i;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.widget.Toast;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayStatus;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import d.r.b.a.a.i.c.j;
import java.util.List;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayResultView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.DialogListener;
/* loaded from: classes8.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.i.c f68787a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.b.a.a.i.a f68788b;

    /* renamed from: c  reason: collision with root package name */
    public int f68789c;

    /* renamed from: d  reason: collision with root package name */
    public int f68790d;

    /* loaded from: classes8.dex */
    public class a implements DialogListener {
        public a() {
        }

        @Override // tv.athena.revenue.payui.view.dialog.DialogListener
        public void a(DialogListener.ClickArea clickArea) {
            e.this.p(clickArea);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IYYPayAmountView.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f68792a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f68793b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68794c;

        public b(Dialog dialog, Activity activity, IPayCallback iPayCallback) {
            this.f68792a = dialog;
            this.f68793b = activity;
            this.f68794c = iPayCallback;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onFail(int i2, String str) {
            d.r.b.a.a.f.d.d.e("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
            i.a.a.e.l.e.f68842a.b(this.f68792a);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<d.r.b.a.a.i.c.g> list) {
            d.r.b.a.a.f.d.d.f("YYPayDialogController", "showInputNumberDialog");
            i.a.a.e.l.e.f68842a.b(this.f68792a);
            e.this.l(activity, list, this.f68794c);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(i.a.a.e.j.b bVar, List<d.r.b.a.a.i.c.g> list) {
            d.r.b.a.a.f.d.d.f("YYPayDialogController", "toPayWayDialog");
            i.a.a.e.l.e.f68842a.b(this.f68792a);
            e.this.o(this.f68793b, bVar, list, this.f68794c);
            i.a.a.e.k.a.b(e.this.f68789c, e.this.f68790d, "purchasegotopay");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "purchasegotopay");
        }
    }

    /* loaded from: classes8.dex */
    public class c implements i.a.a.e.m.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f68796a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f68797b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68798c;

        public c(Activity activity, List list, IPayCallback iPayCallback) {
            this.f68796a = activity;
            this.f68797b = list;
            this.f68798c = iPayCallback;
        }

        @Override // i.a.a.e.m.c.b
        public void a(int i2) {
            j jVar = new j();
            jVar.f67789a = 0;
            jVar.A = "";
            jVar.f67794f = "";
            jVar.f67793e = Double.valueOf(i2);
            jVar.f67795g = i2 * 100;
            e.this.o(this.f68796a, new i.a.a.e.j.b(jVar), this.f68797b, this.f68798c);
        }

        @Override // i.a.a.e.m.c.b
        public void cancel() {
        }
    }

    /* loaded from: classes8.dex */
    public class d implements DialogListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f68800a;

        public d(IAppPayService iAppPayService) {
            this.f68800a = iAppPayService;
        }

        @Override // tv.athena.revenue.payui.view.dialog.DialogListener
        public void a(DialogListener.ClickArea clickArea) {
            d.r.b.a.a.f.d.d.f("YYPayDialogController", "on payWayDialog cancel");
            if (e.this.f68788b != null) {
                d.r.b.a.a.f.d.d.f("YYPayDialogController", "showPayWayDialog removePayListener");
                this.f68800a.removePayListener(e.this.f68788b);
                e.this.f68788b = null;
            }
            e.this.q(clickArea);
        }
    }

    /* renamed from: i.a.a.e.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1938e implements IYYPayWayView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f68802a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f68803b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f68804c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68805d;

        public C1938e(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
            this.f68802a = activity;
            this.f68803b = dialog;
            this.f68804c = iYYPayWayView;
            this.f68805d = iPayCallback;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(i.a.a.e.j.d dVar, i.a.a.e.j.b bVar) {
            e.this.k(this.f68802a, dVar, bVar, this.f68803b, this.f68804c, this.f68805d);
        }
    }

    /* loaded from: classes8.dex */
    public class f extends d.r.b.a.a.i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f68807a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f68808b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68809c;

        public f(Dialog dialog, Activity activity, IPayCallback iPayCallback) {
            this.f68807a = dialog;
            this.f68808b = activity;
            this.f68809c = iPayCallback;
        }

        @Override // d.r.b.a.a.i.a, d.r.b.a.a.i.b
        public void a(CurrencyChargeMessage currencyChargeMessage) {
            super.a(currencyChargeMessage);
            IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
            i.a.a.e.l.e.f68842a.b(this.f68807a);
            e.this.n(this.f68808b, bVar);
            IPayCallback iPayCallback = this.f68809c;
            if (iPayCallback != null) {
                int i2 = currencyChargeMessage.status;
                if (i2 == 1) {
                    iPayCallback.onSuccess(currencyChargeMessage, null);
                } else {
                    iPayCallback.onFail(i2, "", null);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements IPayCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68811a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f68812b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f68813c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f68814d;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.a.a.e.m.c.d.f68884b.c(g.this.f68813c);
                IYYPayWayView iYYPayWayView = g.this.f68814d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.WAITING_VIEW_STATE);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.a.a.e.m.c.d.f68884b.a(g.this.f68813c);
                IYYPayWayView iYYPayWayView = g.this.f68814d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.SELECTING_VIEW_STATE);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.a.a.e.m.c.d.f68884b.c(g.this.f68813c);
                IYYPayWayView iYYPayWayView = g.this.f68814d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.WAITING_VIEW_STATE);
                }
            }
        }

        /* loaded from: classes8.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IYYPayWayView iYYPayWayView = g.this.f68814d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.SELECTING_VIEW_STATE);
                }
                i.a.a.e.m.c.d.f68884b.a(g.this.f68813c);
            }
        }

        /* renamed from: i.a.a.e.i.e$g$e  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC1939e implements Runnable {
            public RunnableC1939e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                e.this.n(gVar.f68812b, new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null));
                i.a.a.e.l.e.f68842a.b(g.this.f68813c);
            }
        }

        public g(IPayCallback iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            this.f68811a = iPayCallback;
            this.f68812b = activity;
            this.f68813c = dialog;
            this.f68814d = iYYPayWayView;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
            IPayCallback iPayCallback = this.f68811a;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, bVar);
            }
            if (i.a.a.e.l.e.f68842a.a(this.f68812b)) {
                if (i2 == PayStatus.CANCEL.getCode()) {
                    d.r.b.a.a.f.d.d.b("YYPayDialogController", "取消支付 code:" + i2);
                    this.f68812b.runOnUiThread(new d());
                    return;
                }
                this.f68812b.runOnUiThread(new RunnableC1939e());
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onPayStart");
            IPayCallback iPayCallback = this.f68811a;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onPayStatus code " + purchaseStatus.getCode() + " msg: " + purchaseStatus.getMessage());
            IPayCallback iPayCallback = this.f68811a;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, bVar);
            }
            if (i.a.a.e.l.e.f68842a.a(this.f68812b)) {
                if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                    this.f68812b.runOnUiThread(new a());
                } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                } else {
                    this.f68812b.runOnUiThread(new b());
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onSuccess");
            IPayCallback iPayCallback = this.f68811a;
            if (iPayCallback != null) {
                iPayCallback.onSuccess(obj, bVar);
            }
            if (i.a.a.e.l.e.f68842a.a(this.f68812b)) {
                this.f68812b.runOnUiThread(new c());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements IYYPayResultView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f68821a;

        public h(e eVar, Dialog dialog) {
            this.f68821a = dialog;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void onClose() {
            Dialog dialog = this.f68821a;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public e(int i2, int i3, PayUIKitConfig payUIKitConfig, i.a.a.e.i.c cVar) {
        this.f68789c = i2;
        this.f68790d = i3;
        this.f68787a = cVar;
    }

    public final void k(Activity activity, i.a.a.e.j.d dVar, i.a.a.e.j.b bVar, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
        this.f68787a.c(activity, dVar, bVar, new g(iPayCallback, activity, dialog, iYYPayWayView));
    }

    public final void l(Activity activity, List<d.r.b.a.a.i.c.g> list, IPayCallback iPayCallback) {
        i.a.a.e.m.c.c.f68858a.f(activity, new c(activity, list, iPayCallback));
    }

    public void m(Activity activity, IPayCallback iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        if (!d.r.b.a.a.f.h.b.b(activity)) {
            Toast.makeText(activity, "网络不给力，请稍后重试", 1).show();
            d.r.b.a.a.f.d.d.e("YYPayDialogController", "showPayAmountDialog fail: network error", new Object[0]);
            return;
        }
        IYYPayAmountView g2 = this.f68787a.g(activity, viewParams);
        g2.refreshView();
        String string = activity.getString(i.a.a.e.e.yy_dialog_title);
        if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
            string = viewParams.payAmountDialogTitle;
        }
        g2.setCallback(new b(i.a.a.e.m.c.d.f68884b.b(activity, string, g2.getContentView(), new a()), activity, iPayCallback));
    }

    public final void n(Activity activity, IYYPayResultView.b bVar) {
        IYYPayResultView.c cVar = new IYYPayResultView.c();
        cVar.f69562a = bVar;
        IYYPayResultView b2 = this.f68787a.b(activity, cVar);
        b2.setCallback(new h(this, i.a.a.e.m.c.d.f68884b.b(activity, activity.getString(i.a.a.e.e.yy_dialog_pay_title), b2.getContentView(), null)));
    }

    public final void o(Activity activity, i.a.a.e.j.b bVar, List<d.r.b.a.a.i.c.g> list, IPayCallback iPayCallback) {
        IAppPayService a2 = i.a.a.e.l.a.a(this.f68789c, this.f68790d);
        if (a2 == null) {
            d.r.b.a.a.f.d.d.e("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
            return;
        }
        IYYPayWayView.b bVar2 = new IYYPayWayView.b();
        bVar2.f69564b = bVar;
        bVar2.f69563a = list;
        IYYPayWayView a3 = this.f68787a.a(activity, bVar2);
        Dialog b2 = i.a.a.e.m.c.d.f68884b.b(activity, activity.getString(i.a.a.e.e.yy_dialog_pay_title), a3.getContentView(), new d(a2));
        a3.setCallback(new C1938e(activity, b2, a3, iPayCallback));
        f fVar = new f(b2, activity, iPayCallback);
        this.f68788b = fVar;
        a2.addPayListener(fVar);
        d.r.b.a.a.f.d.d.f("YYPayDialogController", "showPayWayDialog addPayListener");
    }

    public final void p(DialogListener.ClickArea clickArea) {
        if (clickArea == DialogListener.ClickArea.BUTTOM_AREA) {
            i.a.a.e.k.a.b(this.f68789c, this.f68790d, "purchaseclose_bt");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "purchaseclose_bt");
        } else if (clickArea == DialogListener.ClickArea.EMPTY_AREA) {
            i.a.a.e.k.a.b(this.f68789c, this.f68790d, "purchaseclose_transparent");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "purchaseclose_transparent");
        }
    }

    public final void q(DialogListener.ClickArea clickArea) {
        if (clickArea == DialogListener.ClickArea.BUTTOM_AREA) {
            i.a.a.e.k.a.b(this.f68789c, this.f68790d, "paypageclose_bt");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "paypageclose_bt");
        } else if (clickArea == DialogListener.ClickArea.EMPTY_AREA) {
            i.a.a.e.k.a.b(this.f68789c, this.f68790d, "paypageclose_transparent");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "paypageclose_transparent");
        }
    }
}
