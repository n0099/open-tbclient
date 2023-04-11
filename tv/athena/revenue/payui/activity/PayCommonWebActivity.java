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
import com.baidu.tieba.aab;
import com.baidu.tieba.bab;
import com.baidu.tieba.c9b;
import com.baidu.tieba.d7b;
import com.baidu.tieba.d9b;
import com.baidu.tieba.e9b;
import com.baidu.tieba.q9b;
import com.baidu.tieba.r8b;
import com.baidu.tieba.s8b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.v6b;
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
/* loaded from: classes9.dex */
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
    public v6b p;
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

    /* loaded from: classes9.dex */
    public class e implements IPaySignCallback {

        /* loaded from: classes9.dex */
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
            if (!bab.a.a(PayCommonWebActivity.this)) {
                RLog.info(PayCommonWebActivity.this.a, "onOpenSignPay finish activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* loaded from: classes9.dex */
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

        /* loaded from: classes9.dex */
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
            if (!bab.a.a(PayCommonWebActivity.this)) {
                RLog.info(PayCommonWebActivity.this.a, "onSuccess activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class a implements SimpleNavigationBar.d {
        public a() {
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void a() {
            PayCommonWebActivity.this.C();
            PayCommonWebActivity.this.B();
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void onBackPress() {
            PayCommonWebActivity.this.A();
            PayCommonWebActivity.this.finish();
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.d
        public void onRightClick() {
            PayCommonWebActivity.this.D();
        }
    }

    /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d7b d7bVar = YYPayUIKit.mTestFunListenerr;
            if (d7bVar != null) {
                d7bVar.b(view2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            d7b d7bVar = YYPayUIKit.mTestFunListenerr;
            if (d7bVar != null) {
                d7bVar.a(view2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ NativeOperationParams b;

        public g(Activity activity, NativeOperationParams nativeOperationParams) {
            this.a = activity;
            this.b = nativeOperationParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            RLog.info(PayCommonWebActivity.this.a, "openThirdPartPayApp in run");
            r8b.j(PayCommonWebActivity.this.m, PayCommonWebActivity.this.n, this.a, this.b, PayCommonWebActivity.this.o);
        }
    }

    public final void A() {
        if (t()) {
            e9b.b(this.m, this.n, PayUIEventType.walletclickClose);
            RLog.info(this.a, PayUIEventType.walletclickClose);
        }
    }

    public final void B() {
        if (t()) {
            RLog.info(this.a, "walletShowSet");
            e9b.d(this.m, this.n, PayUVEventType.PAY_WALLET_RIGHT_SET_BTN_CLICK, "", "", "");
        }
    }

    public final void F() {
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
        E();
    }

    public final boolean p() {
        if (this.q == 5) {
            return true;
        }
        return false;
    }

    public final boolean q() {
        if (this.q == 2) {
            return true;
        }
        return false;
    }

    public final boolean r() {
        if (Env.instance().isTestEnv() && this.q == 3) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        if (this.q == 4) {
            return true;
        }
        return false;
    }

    public final boolean t() {
        if (this.q == 1) {
            return true;
        }
        return false;
    }

    public final void w() {
        b bVar = new b(this.t);
        this.e = bVar;
        s9b.d(this, bVar);
    }

    public final void u(NativeOperationParams nativeOperationParams) {
        r8b.e(this.m, this.n, this, nativeOperationParams, new f());
    }

    public final void v(NativeOperationParams nativeOperationParams) {
        this.v = true;
        r8b.f(this, this.m, this.n, nativeOperationParams, new e());
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

    public static void z(Context context, PayFlowType payFlowType, Intent intent, int i, int i2, String str) {
        s8b.b(str, i, i2, payFlowType);
        intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, payFlowType.getTypeId());
        context.startActivity(intent);
    }

    public final void C() {
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
                str2 = aab.a(this.l);
            } else {
                str2 = this.g;
            }
            z(this, this.t, intent, this.m, this.n, str2);
        }
    }

    public final void D() {
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
                str2 = aab.a(this.f);
            } else {
                str2 = this.g;
            }
            z(this, this.t, intent, this.m, this.n, str2);
        }
    }

    public final void E() {
        boolean q = q();
        boolean r = r();
        boolean s = s();
        boolean p = p();
        String str = this.a;
        RLog.debug(str, "tryVerifyPayOrder() isDxmKjPayPage:" + q + ", isMockTestPage:" + r + " isUnionPayPage:" + s + " isDxmH5PayPage:" + p);
        if (q || r || s || p) {
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

    public final void o() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.m = intent.getIntExtra(H5PayConstant.EXTRA_APP_ID, -1);
        this.n = intent.getIntExtra(H5PayConstant.EXTRA_USER_CHANNEL, -1);
        this.q = intent.getIntExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 0);
        PayFlowType a2 = q9b.a(intent.getIntExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, 0));
        this.t = a2;
        if (a2 == null) {
            Toast.makeText(this, "error payFlowTypeId!", 1).show();
            RLog.error(this.a, "error payFlowTypeId", new Object[0]);
            finish();
        }
        String str = this.a;
        RLog.info(str, "fetchPayParamsFromIntent payFlowTypeId: " + this.t.getTypeId());
    }

    @Override // android.app.Activity
    public void onDestroy() {
        String str;
        super.onDestroy();
        String str2 = this.a;
        RLog.info(str2, "onDestroy mAllPayFlowRelease:" + this.u);
        v6b v6bVar = this.p;
        if (v6bVar != null) {
            v6bVar.f();
        }
        AbsPayMessageReceiver absPayMessageReceiver = this.e;
        if (absPayMessageReceiver != null) {
            s9b.e(this, absPayMessageReceiver);
            this.e = null;
        }
        if (!this.u) {
            if (TextUtils.isEmpty(this.h)) {
                str = aab.a(this.i);
            } else {
                str = this.h;
            }
            s8b.a(str, this.m, this.n, this.t);
        }
    }

    public final void G() {
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
        x(this.h, this.g, this.j);
        this.a = this.b + "@" + hashCode() + "@title:" + this.h;
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void b(NativeOperationParams nativeOperationParams) {
        RLog.debug(this.a, "onNativeOperation: %s", nativeOperationParams);
        if (nativeOperationParams == null) {
            return;
        }
        int i = nativeOperationParams.opCode;
        if (i == 4) {
            u(nativeOperationParams);
        } else if (i == 5) {
            r8b.c(this.m, this.n, this.t, nativeOperationParams);
        } else if (i == 6) {
            r8b.g(this.m, this.n, this.t, nativeOperationParams);
        } else if (i == 7) {
            r8b.d(this.m, this.n);
        } else if (i == 8) {
            v(nativeOperationParams);
        } else if (i == 9) {
            ThreadPool.getDefault().networkIO().execute(new g(this, nativeOperationParams));
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void c(d9b d9bVar, c9b c9bVar) {
        String str;
        String str2;
        RLog.info(this.a, "onOpenNewUrl: urlParams:%s, topUiParams:%s", d9bVar, c9bVar);
        if (d9bVar != null && (str = d9bVar.a) != null && !str.isEmpty()) {
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            String str3 = c9bVar.a;
            if (str3 != null && !str3.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_TITLE, c9bVar.a);
            }
            String str4 = c9bVar.b;
            if (str4 != null && !str4.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT, c9bVar.b);
            }
            intent.putExtra(H5PayConstant.EXTRA_URL, d9bVar.a);
            String str5 = c9bVar.c;
            if (str5 != null && !str5.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_URL, c9bVar.c);
            }
            String str6 = c9bVar.d;
            if (str6 != null && !str6.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON, c9bVar.d);
            }
            String str7 = c9bVar.e;
            if (str7 != null && !str7.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON_TITLE, c9bVar.e);
            }
            String str8 = c9bVar.f;
            if (str8 != null && !str8.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_ICON_URL, c9bVar.f);
            }
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.m);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.n);
            e9b.b(this.m, this.n, PayUIEventType.wallet_secondpage_title);
            RLog.warn(this.a, PayUIEventType.wallet_secondpage_title);
            if (d9bVar.b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
                e9b.b(this.m, this.n, PayUIEventType.walletclickdetail);
                RLog.warn(this.a, PayUIEventType.walletclickClose);
            }
            if (TextUtils.isEmpty(c9bVar.a)) {
                str2 = aab.a(d9bVar.a);
            } else {
                str2 = c9bVar.a;
            }
            z(this, this.t, intent, this.m, this.n, str2);
        }
    }

    @Override // tv.athena.revenue.payui.view.impl.YYPayWebView.c
    public void e(c9b c9bVar) {
        RLog.info(this.a, "onUpdateTopUi: %s", c9bVar);
        if (c9bVar != null) {
            String str = c9bVar.b;
            if (str != null && !str.isEmpty()) {
                this.g = c9bVar.b;
            }
            String str2 = c9bVar.c;
            if (str2 != null && !str2.isEmpty()) {
                this.f = c9bVar.c;
            }
            String str3 = c9bVar.a;
            if (str3 != null && !str3.isEmpty()) {
                this.h = c9bVar.a;
            }
            String str4 = c9bVar.d;
            if (str4 != null && !str4.isEmpty()) {
                this.j = c9bVar.d;
            }
            String str5 = c9bVar.e;
            if (str5 != null && !str5.isEmpty()) {
                this.k = c9bVar.e;
            }
            String str6 = c9bVar.f;
            if (str6 != null && !str6.isEmpty()) {
                this.l = c9bVar.f;
            }
            x(this.h, this.g, this.j);
        }
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pay_ui_common_web_activity);
        this.a = this.b + "@" + hashCode();
        if (Build.VERSION.SDK_INT >= 19) {
            v6b H = v6b.H(this);
            H.g(true);
            H.F();
            H.z(17170443);
            H.q(false);
            H.B(true);
            H.i();
            this.p = H;
        }
        o();
        String str = this.a;
        RLog.info(str, "onCreate mPayFlowType:" + this.t);
        w();
        this.r = (TextView) findViewById(R.id.test_banner_btn);
        this.s = (TextView) findViewById(R.id.test_wallet_btn);
        this.d = (FrameLayout) findViewById(R.id.fl_container);
        SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(R.id.simple_navigation_bar);
        this.c = simpleNavigationBar;
        simpleNavigationBar.setCallback(new a());
        G();
        F();
        y();
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

    public final void y() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(H5PayConstant.EXTRA_URL);
        this.i = stringExtra;
        RLog.info(this.a, "startLoadWebView: %s", aab.a(stringExtra));
        String str = this.i;
        if (str != null && !str.isEmpty()) {
            YYPayWebView yYPayWebView = new YYPayWebView(this);
            this.o = yYPayWebView;
            yYPayWebView.setCallback(this);
            this.o.k(this.i);
            this.d.addView(this.o, -1, -1);
        }
    }

    public final void x(String str, String str2, String str3) {
        this.c.setTitle(str);
        this.c.setRight(str2);
        this.c.setRightIcon(str3);
    }
}
