package tv.athena.revenue.payui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.b7c;
import com.baidu.tieba.c9c;
import com.baidu.tieba.d9c;
import com.baidu.tieba.eac;
import com.baidu.tieba.fac;
import com.baidu.tieba.g9c;
import com.baidu.tieba.h9c;
import com.baidu.tieba.q8c;
import com.baidu.tieba.r8c;
import com.baidu.tieba.s9c;
import com.baidu.tieba.u6c;
import com.baidu.tieba.u9c;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUIEventType;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsPayMessageReceiver;
import tv.athena.revenue.payui.view.impl.YYPayWebView;
import tv.athena.revenue.payui.webview.UrlPageType;
import tv.athena.revenue.payui.widget.SimpleNavigationBar;
/* loaded from: classes2.dex */
public class PayCommonWebActivity extends YYPayBaseActivity implements YYPayWebView.c {
    public SimpleNavigationBar c;
    public FrameLayout d;
    public AbsPayMessageReceiver e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public YYPayWebView o;
    public u6c p;
    public int q;
    public TextView r;
    public TextView s;
    public PayFlowType t;
    public boolean u;
    public String a = "PayCommonWebActivity";
    public String b = "PayCommonWebActivity";
    public int m = -1;
    public int n = -1;
    public boolean v = false;

    /* loaded from: classes2.dex */
    public class e implements IPaySignCallback {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PayCommonWebActivity.this.o != null && PayCommonWebActivity.this.i != null && !PayCommonWebActivity.this.i.isEmpty()) {
                    PayCommonWebActivity.this.o.k(PayCommonWebActivity.this.i);
                }
            }
        }

        public e() {
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback
        public void onPaySignFinish(int i, String str) {
            RLog.debug(PayCommonWebActivity.this.a, "onOpenSignPay finish");
            if (!fac.a.a(PayCommonWebActivity.this)) {
                RLog.info(PayCommonWebActivity.this.a, "onOpenSignPay finish activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements IPayCallback<CurrencyChargeMessage> {
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
        }

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PayCommonWebActivity.this.o != null && PayCommonWebActivity.this.i != null && !PayCommonWebActivity.this.i.isEmpty()) {
                    PayCommonWebActivity.this.o.k(PayCommonWebActivity.this.i);
                }
            }
        }

        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            RLog.debug(PayCommonWebActivity.this.a, "onSuccess");
            if (!fac.a.a(PayCommonWebActivity.this)) {
                RLog.info(PayCommonWebActivity.this.a, "onSuccess activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements IPayCallback<CurrencyChargeMessage> {
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
        }

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PayCommonWebActivity.this.o != null && PayCommonWebActivity.this.i != null && !PayCommonWebActivity.this.i.isEmpty()) {
                    PayCommonWebActivity.this.o.k(PayCommonWebActivity.this.i);
                }
            }
        }

        public g() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            RLog.debug(PayCommonWebActivity.this.a, "onSuccess");
            if (!fac.a.a(PayCommonWebActivity.this)) {
                RLog.info(PayCommonWebActivity.this.a, "onSuccess activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a implements SimpleNavigationBar.d {
        public a() {
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void a() {
            PayCommonWebActivity.this.E();
            PayCommonWebActivity.this.D();
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void onBackPress() {
            PayCommonWebActivity.this.C();
            PayCommonWebActivity.this.finish();
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void onRightClick() {
            PayCommonWebActivity.this.F();
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AbsPayMessageReceiver {
        public b(PayFlowType payFlowType) {
            super(payFlowType);
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onAllPayFlowViewRelease() {
            RLog.info(PayCommonWebActivity.this.a, "AbsReleasePayViewReceiver onAllPayFlowViewRelease");
            PayCommonWebActivity.this.u = true;
            PayCommonWebActivity.this.finish();
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onDialogPayFlowViewRelease() {
            RLog.info(PayCommonWebActivity.this.a, "AbsReleasePayViewReceiver onDialogPayFlowViewRelease");
            PayCommonWebActivity.this.finish();
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onWalletPayFlowViewRelease() {
            RLog.info(PayCommonWebActivity.this.a, "AbsReleasePayViewReceiver onWalletPayFlowViewRelease");
            PayCommonWebActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b7c b7cVar = YYPayUIKit.mTestFunListenerr;
            if (b7cVar != null) {
                b7cVar.b(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            b7c b7cVar = YYPayUIKit.mTestFunListenerr;
            if (b7cVar != null) {
                b7cVar.a(view2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public final /* synthetic */ NativeOperationParams a;

        public h(NativeOperationParams nativeOperationParams) {
            this.a = nativeOperationParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            RLog.info(PayCommonWebActivity.this.a, "onOpenSignPay in run");
            PayCommonWebActivity.this.x(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ NativeOperationParams b;

        public i(Activity activity, NativeOperationParams nativeOperationParams) {
            this.a = activity;
            this.b = nativeOperationParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            RLog.info(PayCommonWebActivity.this.a, "openThirdPartPayApp in run");
            q8c.k(PayCommonWebActivity.this.m, PayCommonWebActivity.this.n, this.a, this.b, PayCommonWebActivity.this.o);
        }
    }

    public final void C() {
        if (u()) {
            g9c.b(this.m, this.n, PayUIEventType.walletclickClose);
            RLog.info(this.a, PayUIEventType.walletclickClose);
        }
    }

    public final void D() {
        if (u()) {
            RLog.info(this.a, "walletShowSet");
            h9c.b(this.m, this.n, PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, "", "", "");
        }
    }

    public final void H() {
        if (YYPayUIKit.mTestFunListenerr != null) {
            this.r.setVisibility(0);
            this.r.setOnClickListener(new c());
            this.s.setVisibility(0);
            this.s.setOnClickListener(new d());
            return;
        }
        this.r.setVisibility(8);
        this.s.setVisibility(8);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        G();
    }

    public final boolean q() {
        if (this.q == 5) {
            return true;
        }
        return false;
    }

    public final boolean r() {
        if (this.q == 2) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        if (Env.instance().isTestEnv() && this.q == 3) {
            return true;
        }
        return false;
    }

    public final boolean t() {
        if (this.q == 4) {
            return true;
        }
        return false;
    }

    public final boolean u() {
        if (this.q == 1) {
            return true;
        }
        return false;
    }

    public final void y() {
        b bVar = new b(this.t);
        this.e = bVar;
        u9c.d(this, bVar);
    }

    public static void B(Context context, PayFlowType payFlowType, Intent intent, int i2, int i3, String str) {
        r8c.b(str, i2, i3, payFlowType);
        intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, payFlowType.getTypeId());
        context.startActivity(intent);
    }

    public final void v(NativeOperationParams nativeOperationParams) {
        q8c.e(this.m, this.n, this, nativeOperationParams, new g());
    }

    public final void w(NativeOperationParams nativeOperationParams) {
        q8c.f(this.m, this.n, this, nativeOperationParams, new f());
    }

    public final void x(NativeOperationParams nativeOperationParams) {
        this.v = true;
        q8c.g(this, this.m, this.n, nativeOperationParams, new e());
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void d(WebView webView, String str) {
        if (Env.instance().isTestEnv() && this.q == 3) {
            RLog.info(this.a, "onUrlLoading url:%s", str);
            if (str.startsWith("https://payplf-gate-test.yy.com/tpay/return.do")) {
                finish();
            }
        }
    }

    public final void A() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(H5PayConstant.EXTRA_URL);
        this.i = stringExtra;
        RLog.info(this.a, "startLoadWebView: %s", eac.a(stringExtra));
        String str = this.i;
        if (str != null && !str.isEmpty()) {
            YYPayWebView yYPayWebView = new YYPayWebView(this);
            this.o = yYPayWebView;
            yYPayWebView.setCallback(this);
            this.o.k(this.i);
            this.d.addView(this.o, -1, -1);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        String str;
        super.onResume();
        String str2 = this.a;
        RLog.info(str2, "onResume  isSignPayPage=" + this.v);
        if (this.v && this.o != null && (str = this.i) != null && !str.isEmpty()) {
            this.o.k(this.i);
        }
    }

    public final void E() {
        String str;
        String str2;
        String str3 = this.l;
        if (str3 != null && !str3.isEmpty() && (str = this.k) != null && !str.isEmpty()) {
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            intent.putExtra(H5PayConstant.EXTRA_URL, this.l);
            intent.putExtra(H5PayConstant.EXTRA_TITLE, this.k);
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.m);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.n);
            if (TextUtils.isEmpty(this.k)) {
                str2 = eac.a(this.l);
            } else {
                str2 = this.g;
            }
            B(this, this.t, intent, this.m, this.n, str2);
        }
    }

    public final void F() {
        String str;
        String str2;
        String str3 = this.f;
        if (str3 != null && !str3.isEmpty() && (str = this.g) != null && !str.isEmpty()) {
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            intent.putExtra(H5PayConstant.EXTRA_URL, this.f);
            intent.putExtra(H5PayConstant.EXTRA_TITLE, this.g);
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.m);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.n);
            if (TextUtils.isEmpty(this.g)) {
                str2 = eac.a(this.f);
            } else {
                str2 = this.g;
            }
            B(this, this.t, intent, this.m, this.n, str2);
        }
    }

    public final void G() {
        boolean r = r();
        boolean s = s();
        boolean t = t();
        boolean q = q();
        String str = this.a;
        RLog.debug(str, "tryVerifyPayOrder() isDxmKjPayPage:" + r + ", isMockTestPage:" + s + " isUnionPayPage:" + t + " isDxmH5PayPage:" + q);
        if (r || s || t || q) {
            H5PayManager.getInstance().verifyPayOrder();
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public String getToken() {
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.m, this.n);
        if (uIKit == null) {
            RLog.error(this.a, "getToken() yyPayUIKit null", new Object[0]);
            return "";
        }
        PayUIKitConfig payUIKitConfig = uIKit.getPayUIKitConfig();
        if (payUIKitConfig == null) {
            RLog.error(this.a, "getToken()  payUIKitConfig null", new Object[0]);
            return "";
        }
        MiddleRevenueConfig middleRevenueConfig = payUIKitConfig.revenueConfig;
        if (middleRevenueConfig == null) {
            RLog.error(this.a, "getToken()  revenueConfig null", new Object[0]);
            return "";
        }
        IToken tokenCallback = middleRevenueConfig.getTokenCallback();
        if (tokenCallback == null) {
            RLog.error(this.a, "getToken()  iToken null", new Object[0]);
            return "";
        }
        return tokenCallback.onUpdateToken();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        String str;
        super.onDestroy();
        String str2 = this.a;
        RLog.info(str2, "onDestroy mAllPayFlowRelease:" + this.u);
        u6c u6cVar = this.p;
        if (u6cVar != null) {
            u6cVar.f();
        }
        AbsPayMessageReceiver absPayMessageReceiver = this.e;
        if (absPayMessageReceiver != null) {
            u9c.e(this, absPayMessageReceiver);
            this.e = null;
        }
        if (!this.u) {
            if (TextUtils.isEmpty(this.h)) {
                str = eac.a(this.i);
            } else {
                str = this.h;
            }
            r8c.a(str, this.m, this.n, this.t);
        }
    }

    public final void p() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.m = intent.getIntExtra(H5PayConstant.EXTRA_APP_ID, -1);
        this.n = intent.getIntExtra(H5PayConstant.EXTRA_USER_CHANNEL, -1);
        this.q = intent.getIntExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 0);
        PayFlowType a2 = s9c.a(intent.getIntExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, 0));
        this.t = a2;
        if (a2 == null) {
            Toast.makeText(this, "error payFlowTypeId!", 1).show();
            RLog.error(this.a, "error payFlowTypeId", new Object[0]);
            finish();
        }
        String str = this.a;
        RLog.info(str, "fetchPayParamsFromIntent payFlowTypeId: " + this.t.getTypeId());
    }

    public final void I() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.h = intent.getStringExtra(H5PayConstant.EXTRA_TITLE);
        this.g = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT);
        this.f = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_URL);
        this.j = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_ICON);
        this.k = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_ICON_TITLE);
        this.l = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_ICON_URL);
        z(this.h, this.g, this.j);
        this.a = this.b + "@" + hashCode() + "@title:" + this.h;
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void b(NativeOperationParams nativeOperationParams) {
        RLog.debug(this.a, "onNativeOperation: %s", nativeOperationParams);
        if (nativeOperationParams == null) {
            return;
        }
        int i2 = nativeOperationParams.opCode;
        if (i2 == 4) {
            w(nativeOperationParams);
        } else if (i2 == 5) {
            q8c.c(this.m, this.n, this.t, nativeOperationParams);
        } else if (i2 == 6) {
            q8c.h(this.m, this.n, this.t, nativeOperationParams);
        } else if (i2 == 7) {
            q8c.d(this.m, this.n);
        } else if (i2 == 8) {
            ThreadPool.getDefault().networkIO().execute(new h(nativeOperationParams));
        } else if (i2 == 9) {
            ThreadPool.getDefault().networkIO().execute(new i(this, nativeOperationParams));
        } else if (i2 == 10) {
            v(nativeOperationParams);
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void e(c9c c9cVar) {
        RLog.info(this.a, "onUpdateTopUi: %s", c9cVar);
        if (c9cVar != null) {
            String str = c9cVar.b;
            if (str != null && !str.isEmpty()) {
                this.g = c9cVar.b;
            }
            String str2 = c9cVar.c;
            if (str2 != null && !str2.isEmpty()) {
                this.f = c9cVar.c;
            }
            String str3 = c9cVar.a;
            if (str3 != null && !str3.isEmpty()) {
                this.h = c9cVar.a;
            }
            String str4 = c9cVar.d;
            if (str4 != null && !str4.isEmpty()) {
                this.j = c9cVar.d;
            }
            String str5 = c9cVar.e;
            if (str5 != null && !str5.isEmpty()) {
                this.k = c9cVar.e;
            }
            String str6 = c9cVar.f;
            if (str6 != null && !str6.isEmpty()) {
                this.l = c9cVar.f;
            }
            z(this.h, this.g, this.j);
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void c(d9c d9cVar, c9c c9cVar) {
        String str;
        String str2;
        RLog.info(this.a, "onOpenNewUrl: urlParams:%s, topUiParams:%s", d9cVar, c9cVar);
        if (d9cVar != null && (str = d9cVar.a) != null && !str.isEmpty()) {
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            String str3 = c9cVar.a;
            if (str3 != null && !str3.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_TITLE, c9cVar.a);
            }
            String str4 = c9cVar.b;
            if (str4 != null && !str4.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT, c9cVar.b);
            }
            intent.putExtra(H5PayConstant.EXTRA_URL, d9cVar.a);
            String str5 = c9cVar.c;
            if (str5 != null && !str5.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_URL, c9cVar.c);
            }
            String str6 = c9cVar.d;
            if (str6 != null && !str6.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON, c9cVar.d);
            }
            String str7 = c9cVar.e;
            if (str7 != null && !str7.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON_TITLE, c9cVar.e);
            }
            String str8 = c9cVar.f;
            if (str8 != null && !str8.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON_URL, c9cVar.f);
            }
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.m);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.n);
            g9c.b(this.m, this.n, PayUIEventType.wallet_secondpage_title);
            RLog.warn(this.a, PayUIEventType.wallet_secondpage_title);
            if (d9cVar.b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
                g9c.b(this.m, this.n, PayUIEventType.walletclickdetail);
                RLog.warn(this.a, PayUIEventType.walletclickClose);
            }
            if (TextUtils.isEmpty(c9cVar.a)) {
                str2 = eac.a(d9cVar.a);
            } else {
                str2 = c9cVar.a;
            }
            B(this, this.t, intent, this.m, this.n, str2);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pay_ui_common_web_activity);
        this.a = this.b + "@" + hashCode();
        if (Build.VERSION.SDK_INT >= 19) {
            u6c H = u6c.H(this);
            H.g(true);
            H.F();
            H.z(17170443);
            H.q(false);
            H.B(true);
            H.i();
            this.p = H;
        }
        p();
        String str = this.a;
        RLog.info(str, "onCreate mPayFlowType:" + this.t);
        y();
        this.r = (TextView) findViewById(R.id.test_banner_btn);
        this.s = (TextView) findViewById(R.id.test_wallet_btn);
        this.d = (FrameLayout) findViewById(R.id.fl_container);
        SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(R.id.simple_navigation_bar);
        this.c = simpleNavigationBar;
        simpleNavigationBar.setCallback(new a());
        I();
        H();
        A();
    }

    public final void z(String str, String str2, String str3) {
        this.c.setTitle(str);
        this.c.setRight(str2);
        this.c.setRightIcon(str3);
    }
}
