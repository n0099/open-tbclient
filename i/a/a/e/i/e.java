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
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public i.a.a.e.i.c f68107a;

    /* renamed from: b  reason: collision with root package name */
    public d.r.b.a.a.i.a f68108b;

    /* renamed from: c  reason: collision with root package name */
    public int f68109c;

    /* renamed from: d  reason: collision with root package name */
    public int f68110d;

    /* loaded from: classes7.dex */
    public class a implements DialogListener {
        public a() {
        }

        @Override // tv.athena.revenue.payui.view.dialog.DialogListener
        public void a(DialogListener.ClickArea clickArea) {
            e.this.p(clickArea);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IYYPayAmountView.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f68112a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f68113b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68114c;

        public b(Dialog dialog, Activity activity, IPayCallback iPayCallback) {
            this.f68112a = dialog;
            this.f68113b = activity;
            this.f68114c = iPayCallback;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void onFail(int i2, String str) {
            d.r.b.a.a.f.d.d.e("YYPayDialogController", "showPayAmountDialog onFail code:" + i2 + " failReason:" + str, new Object[0]);
            i.a.a.e.l.e.f68162a.b(this.f68112a);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void showInputNumberDialog(Activity activity, List<d.r.b.a.a.i.c.g> list) {
            d.r.b.a.a.f.d.d.f("YYPayDialogController", "showInputNumberDialog");
            i.a.a.e.l.e.f68162a.b(this.f68112a);
            e.this.l(activity, list, this.f68114c);
        }

        @Override // tv.athena.revenue.payui.view.IYYPayAmountView.Callback
        public void toPayWayDialog(i.a.a.e.j.b bVar, List<d.r.b.a.a.i.c.g> list) {
            d.r.b.a.a.f.d.d.f("YYPayDialogController", "toPayWayDialog");
            i.a.a.e.l.e.f68162a.b(this.f68112a);
            e.this.o(this.f68113b, bVar, list, this.f68114c);
            i.a.a.e.k.a.b(e.this.f68109c, e.this.f68110d, "purchasegotopay");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "purchasegotopay");
        }
    }

    /* loaded from: classes7.dex */
    public class c implements i.a.a.e.m.c.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f68116a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f68117b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68118c;

        public c(Activity activity, List list, IPayCallback iPayCallback) {
            this.f68116a = activity;
            this.f68117b = list;
            this.f68118c = iPayCallback;
        }

        @Override // i.a.a.e.m.c.b
        public void a(int i2) {
            j jVar = new j();
            jVar.f67103a = 0;
            jVar.A = "";
            jVar.f67108f = "";
            jVar.f67107e = Double.valueOf(i2);
            jVar.f67109g = i2 * 100;
            e.this.o(this.f68116a, new i.a.a.e.j.b(jVar), this.f68117b, this.f68118c);
        }

        @Override // i.a.a.e.m.c.b
        public void cancel() {
        }
    }

    /* loaded from: classes7.dex */
    public class d implements DialogListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IAppPayService f68120a;

        public d(IAppPayService iAppPayService) {
            this.f68120a = iAppPayService;
        }

        @Override // tv.athena.revenue.payui.view.dialog.DialogListener
        public void a(DialogListener.ClickArea clickArea) {
            d.r.b.a.a.f.d.d.f("YYPayDialogController", "on payWayDialog cancel");
            if (e.this.f68108b != null) {
                d.r.b.a.a.f.d.d.f("YYPayDialogController", "showPayWayDialog removePayListener");
                this.f68120a.removePayListener(e.this.f68108b);
                e.this.f68108b = null;
            }
            e.this.q(clickArea);
        }
    }

    /* renamed from: i.a.a.e.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1875e implements IYYPayWayView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f68122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Dialog f68123b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f68124c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68125d;

        public C1875e(Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
            this.f68122a = activity;
            this.f68123b = dialog;
            this.f68124c = iYYPayWayView;
            this.f68125d = iPayCallback;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayWayView.a
        public void a(i.a.a.e.j.d dVar, i.a.a.e.j.b bVar) {
            e.this.k(this.f68122a, dVar, bVar, this.f68123b, this.f68124c, this.f68125d);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends d.r.b.a.a.i.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f68127a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f68128b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68129c;

        public f(Dialog dialog, Activity activity, IPayCallback iPayCallback) {
            this.f68127a = dialog;
            this.f68128b = activity;
            this.f68129c = iPayCallback;
        }

        @Override // d.r.b.a.a.i.a, d.r.b.a.a.i.b
        public void a(CurrencyChargeMessage currencyChargeMessage) {
            super.a(currencyChargeMessage);
            IYYPayResultView.b bVar = new IYYPayResultView.b(currencyChargeMessage.status == 1 ? IYYPayResultView.Result.PAY_SUUCESS : IYYPayResultView.Result.PAY_FAIL, currencyChargeMessage);
            i.a.a.e.l.e.f68162a.b(this.f68127a);
            e.this.n(this.f68128b, bVar);
            IPayCallback iPayCallback = this.f68129c;
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

    /* loaded from: classes7.dex */
    public class g implements IPayCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ IPayCallback f68131a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f68132b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Dialog f68133c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IYYPayWayView f68134d;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.a.a.e.m.c.d.f68204b.c(g.this.f68133c);
                IYYPayWayView iYYPayWayView = g.this.f68134d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.WAITING_VIEW_STATE);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.a.a.e.m.c.d.f68204b.a(g.this.f68133c);
                IYYPayWayView iYYPayWayView = g.this.f68134d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.SELECTING_VIEW_STATE);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.a.a.e.m.c.d.f68204b.c(g.this.f68133c);
                IYYPayWayView iYYPayWayView = g.this.f68134d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.WAITING_VIEW_STATE);
                }
            }
        }

        /* loaded from: classes7.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                IYYPayWayView iYYPayWayView = g.this.f68134d;
                if (iYYPayWayView != null) {
                    iYYPayWayView.setViewState(IYYPayWayView.PayViewState.SELECTING_VIEW_STATE);
                }
                i.a.a.e.m.c.d.f68204b.a(g.this.f68133c);
            }
        }

        /* renamed from: i.a.a.e.i.e$g$e  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1876e implements Runnable {
            public RunnableC1876e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.this;
                e.this.n(gVar.f68132b, new IYYPayResultView.b(IYYPayResultView.Result.PAY_FAIL, null));
                i.a.a.e.l.e.f68162a.b(g.this.f68133c);
            }
        }

        public g(IPayCallback iPayCallback, Activity activity, Dialog dialog, IYYPayWayView iYYPayWayView) {
            this.f68131a = iPayCallback;
            this.f68132b = activity;
            this.f68133c = dialog;
            this.f68134d = iYYPayWayView;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onFail code:" + i2 + " failReason:" + str);
            IPayCallback iPayCallback = this.f68131a;
            if (iPayCallback != null) {
                iPayCallback.onFail(i2, str, bVar);
            }
            if (i.a.a.e.l.e.f68162a.a(this.f68132b)) {
                if (i2 == PayStatus.CANCEL.getCode()) {
                    d.r.b.a.a.f.d.d.b("YYPayDialogController", "取消支付 code:" + i2);
                    this.f68132b.runOnUiThread(new d());
                    return;
                }
                this.f68132b.runOnUiThread(new RunnableC1876e());
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onPayStart");
            IPayCallback iPayCallback = this.f68131a;
            if (iPayCallback != null) {
                iPayCallback.onPayStart();
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onPayStatus code " + purchaseStatus.getCode() + " msg: " + purchaseStatus.getMessage());
            IPayCallback iPayCallback = this.f68131a;
            if (iPayCallback != null) {
                iPayCallback.onPayStatus(purchaseStatus, bVar);
            }
            if (i.a.a.e.l.e.f68162a.a(this.f68132b)) {
                if (purchaseStatus != null && purchaseStatus == PurchaseStatus.ORDER_START) {
                    this.f68132b.runOnUiThread(new a());
                } else if ((purchaseStatus == null || purchaseStatus != PurchaseStatus.ORDER_SUCCESS) && purchaseStatus != PurchaseStatus.ORDER_FAIL) {
                } else {
                    this.f68132b.runOnUiThread(new b());
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("YYPayDialogController", "requestPayInternal onSuccess");
            IPayCallback iPayCallback = this.f68131a;
            if (iPayCallback != null) {
                iPayCallback.onSuccess(obj, bVar);
            }
            if (i.a.a.e.l.e.f68162a.a(this.f68132b)) {
                this.f68132b.runOnUiThread(new c());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements IYYPayResultView.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Dialog f68141a;

        public h(e eVar, Dialog dialog) {
            this.f68141a = dialog;
        }

        @Override // tv.athena.revenue.payui.view.IYYPayResultView.a
        public void onClose() {
            Dialog dialog = this.f68141a;
            if (dialog != null) {
                dialog.dismiss();
            }
        }
    }

    public e(int i2, int i3, PayUIKitConfig payUIKitConfig, i.a.a.e.i.c cVar) {
        this.f68109c = i2;
        this.f68110d = i3;
        this.f68107a = cVar;
    }

    public final void k(Activity activity, i.a.a.e.j.d dVar, i.a.a.e.j.b bVar, Dialog dialog, IYYPayWayView iYYPayWayView, IPayCallback iPayCallback) {
        this.f68107a.c(activity, dVar, bVar, new g(iPayCallback, activity, dialog, iYYPayWayView));
    }

    public final void l(Activity activity, List<d.r.b.a.a.i.c.g> list, IPayCallback iPayCallback) {
        i.a.a.e.m.c.c.f68178a.f(activity, new c(activity, list, iPayCallback));
    }

    public void m(Activity activity, IPayCallback iPayCallback, IYYPayAmountView.ViewParams viewParams) {
        if (!d.r.b.a.a.f.h.b.b(activity)) {
            Toast.makeText(activity, "网络不给力，请稍后重试", 1).show();
            d.r.b.a.a.f.d.d.e("YYPayDialogController", "showPayAmountDialog fail: network error", new Object[0]);
            return;
        }
        IYYPayAmountView g2 = this.f68107a.g(activity, viewParams);
        g2.refreshView();
        String string = activity.getString(i.a.a.e.e.yy_dialog_title);
        if (viewParams != null && !TextUtils.isEmpty(viewParams.payAmountDialogTitle)) {
            string = viewParams.payAmountDialogTitle;
        }
        g2.setCallback(new b(i.a.a.e.m.c.d.f68204b.b(activity, string, g2.getContentView(), new a()), activity, iPayCallback));
    }

    public final void n(Activity activity, IYYPayResultView.b bVar) {
        IYYPayResultView.c cVar = new IYYPayResultView.c();
        cVar.f68880a = bVar;
        IYYPayResultView b2 = this.f68107a.b(activity, cVar);
        b2.setCallback(new h(this, i.a.a.e.m.c.d.f68204b.b(activity, activity.getString(i.a.a.e.e.yy_dialog_pay_title), b2.getContentView(), null)));
    }

    public final void o(Activity activity, i.a.a.e.j.b bVar, List<d.r.b.a.a.i.c.g> list, IPayCallback iPayCallback) {
        IAppPayService a2 = i.a.a.e.l.a.a(this.f68109c, this.f68110d);
        if (a2 == null) {
            d.r.b.a.a.f.d.d.e("YYPayDialogController", "showPayWayDialog null appPayService", new Object[0]);
            return;
        }
        IYYPayWayView.b bVar2 = new IYYPayWayView.b();
        bVar2.f68882b = bVar;
        bVar2.f68881a = list;
        IYYPayWayView a3 = this.f68107a.a(activity, bVar2);
        Dialog b2 = i.a.a.e.m.c.d.f68204b.b(activity, activity.getString(i.a.a.e.e.yy_dialog_pay_title), a3.getContentView(), new d(a2));
        a3.setCallback(new C1875e(activity, b2, a3, iPayCallback));
        f fVar = new f(b2, activity, iPayCallback);
        this.f68108b = fVar;
        a2.addPayListener(fVar);
        d.r.b.a.a.f.d.d.f("YYPayDialogController", "showPayWayDialog addPayListener");
    }

    public final void p(DialogListener.ClickArea clickArea) {
        if (clickArea == DialogListener.ClickArea.BUTTOM_AREA) {
            i.a.a.e.k.a.b(this.f68109c, this.f68110d, "purchaseclose_bt");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "purchaseclose_bt");
        } else if (clickArea == DialogListener.ClickArea.EMPTY_AREA) {
            i.a.a.e.k.a.b(this.f68109c, this.f68110d, "purchaseclose_transparent");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "purchaseclose_transparent");
        }
    }

    public final void q(DialogListener.ClickArea clickArea) {
        if (clickArea == DialogListener.ClickArea.BUTTOM_AREA) {
            i.a.a.e.k.a.b(this.f68109c, this.f68110d, "paypageclose_bt");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "paypageclose_bt");
        } else if (clickArea == DialogListener.ClickArea.EMPTY_AREA) {
            i.a.a.e.k.a.b(this.f68109c, this.f68110d, "paypageclose_transparent");
            d.r.b.a.a.f.d.d.h("YYPayDialogController", "paypageclose_transparent");
        }
    }
}
