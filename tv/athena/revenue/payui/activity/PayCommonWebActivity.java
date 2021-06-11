package tv.athena.revenue.payui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import i.a.a.e.e;
import i.a.a.e.n.h;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.H5PayFlowModel;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.YYPayWebView;
import tv.athena.revenue.payui.webview.UrlPageType;
import tv.athena.revenue.payui.widget.SimpleNavigationBar;
/* loaded from: classes8.dex */
public class PayCommonWebActivity extends YYPayBaseActivity implements YYPayWebView.c {
    public i.a.a.e.i.a.d immersionBar;
    public FrameLayout mContainer;
    public int mLocalPageType;
    public d mLoginOutReceiver;
    public String mRightTitle;
    public String mRightUrl;
    public SimpleNavigationBar mSimpleNavigationBar;
    public String mTitle;
    public String mUrl;
    public YYPayWebView mYYPayWebView;
    public String TAG = "PayCommonWebActivity-";
    public int mAppId = -1;
    public int mUserChannel = -1;

    /* loaded from: classes8.dex */
    public class a implements SimpleNavigationBar.c {
        public a() {
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void D() {
            if (PayCommonWebActivity.this.isWalletPage()) {
                i.a.a.e.m.a.b(PayCommonWebActivity.this.mAppId, PayCommonWebActivity.this.mUserChannel, UiEventType.walletclickClose);
                RLog.warn(PayCommonWebActivity.this.TAG, UiEventType.walletclickClose);
            }
            PayCommonWebActivity.this.finish();
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void onRightClick() {
            if (PayCommonWebActivity.this.mRightUrl != null && !PayCommonWebActivity.this.mRightUrl.isEmpty() && PayCommonWebActivity.this.mRightTitle != null && !PayCommonWebActivity.this.mRightTitle.isEmpty()) {
                Intent intent = new Intent(PayCommonWebActivity.this, PayCommonWebActivity.class);
                intent.putExtra(H5PayConstant.EXTRA_URL, PayCommonWebActivity.this.mRightUrl);
                intent.putExtra(H5PayConstant.EXTRA_TITLE, PayCommonWebActivity.this.mRightTitle);
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, PayCommonWebActivity.this.mAppId);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, PayCommonWebActivity.this.mUserChannel);
                PayCommonWebActivity.this.startActivity(intent);
            }
            if (PayCommonWebActivity.this.isWalletPage()) {
                i.a.a.e.m.a.b(PayCommonWebActivity.this.mAppId, PayCommonWebActivity.this.mUserChannel, UiEventType.walletshowhelp);
                RLog.warn(PayCommonWebActivity.this.TAG, UiEventType.walletshowhelp);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements IPayCallback {

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PayCommonWebActivity.this.mYYPayWebView == null || PayCommonWebActivity.this.mUrl == null || PayCommonWebActivity.this.mUrl.isEmpty()) {
                    return;
                }
                PayCommonWebActivity.this.mYYPayWebView.h(PayCommonWebActivity.this.mUrl);
            }
        }

        public b() {
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            String str2 = PayCommonWebActivity.this.TAG;
            RLog.debug(str2, "onFail code:" + i2 + " failReason:" + str);
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            RLog.debug(PayCommonWebActivity.this.TAG, "onPayStart");
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            RLog.debug(PayCommonWebActivity.this.TAG, "onPayStatus");
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            RLog.debug(PayCommonWebActivity.this.TAG, "onSuccess");
            if (!h.f72168a.a(PayCommonWebActivity.this)) {
                RLog.info(PayCommonWebActivity.this.TAG, "onSuccess activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements IPayCallback<CurrencyChargeMessage> {

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PayCommonWebActivity.this.mYYPayWebView == null || PayCommonWebActivity.this.mUrl == null || PayCommonWebActivity.this.mUrl.isEmpty()) {
                    return;
                }
                PayCommonWebActivity.this.mYYPayWebView.h(PayCommonWebActivity.this.mUrl);
            }
        }

        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            RLog.debug(PayCommonWebActivity.this.TAG, "onSuccess");
            if (!h.f72168a.a(PayCommonWebActivity.this)) {
                RLog.info(PayCommonWebActivity.this.TAG, "onSuccess activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            String str2 = PayCommonWebActivity.this.TAG;
            RLog.debug(str2, "onFail code:" + i2 + " failReason:" + str);
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            RLog.debug(PayCommonWebActivity.this.TAG, "onPayStart");
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            RLog.debug(PayCommonWebActivity.this.TAG, "onPayStatus");
        }
    }

    /* loaded from: classes8.dex */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !"tv.athena.revenue.payui.login_out_action".equals(intent.getAction())) {
                return;
            }
            RLog.info(PayCommonWebActivity.this.TAG, "onReceive login out");
            PayCommonWebActivity.this.finish();
        }

        public /* synthetic */ d(PayCommonWebActivity payCommonWebActivity, a aVar) {
            this();
        }
    }

    private boolean isDxmKjPayPage() {
        return this.mLocalPageType == 2;
    }

    private boolean isMockTestPage() {
        return Env.instance().isTestEnv() && this.mLocalPageType == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWalletPage() {
        return this.mLocalPageType == 1;
    }

    private void loadWebView() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(H5PayConstant.EXTRA_URL);
        this.mUrl = stringExtra;
        RLog.info(this.TAG, "loadWeb: %s", stringExtra);
        String str = this.mUrl;
        if (str == null || str.isEmpty()) {
            return;
        }
        YYPayWebView yYPayWebView = new YYPayWebView(this);
        this.mYYPayWebView = yYPayWebView;
        yYPayWebView.setCallback(this);
        this.mYYPayWebView.h(this.mUrl);
        this.mContainer.addView(this.mYYPayWebView, -1, -1);
    }

    private void onBannerClick(NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
        if (uIKit == null) {
            RLog.error(this.TAG, "onNativeOperation null yyPayUIKit", new Object[0]);
        } else if (nativeOperationParams.params == null) {
            RLog.error(this.TAG, "onNativeOperation error h5 params null", new Object[0]);
        } else {
            BannerConfigItem.BannerInfo bannerInfo = new BannerConfigItem.BannerInfo();
            try {
                JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                bannerInfo.id = jSONObject.optString("id");
                bannerInfo.jumpType = jSONObject.optInt("jumpType");
                bannerInfo.jumpData = jSONObject.optString("jumpData", "");
                bannerInfo.imageUrl = jSONObject.optString("imageUrl", "");
                H5PayFlowModel h5PayFlowModel = uIKit.getH5PayFlowModel();
                if (h5PayFlowModel != null && (absViewEventHandler = h5PayFlowModel.viewEventListener) != null) {
                    absViewEventHandler.onBannerClick(bannerInfo);
                } else {
                    RLog.error(this.TAG, "onNativeOperation error h5PayFlowModel null", new Object[0]);
                }
            } catch (Exception e2) {
                RLog.error(this.TAG, "get bannerInfo error:", e2.getLocalizedMessage());
            }
        }
    }

    private void onOpenPayChannelPage(NativeOperationParams nativeOperationParams) {
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
        if (uIKit == null) {
            RLog.error(this.TAG, "onNativeOperation null yyPayUIKit", new Object[0]);
        } else if (nativeOperationParams.params == null) {
            RLog.error(this.TAG, "onNativeOperation error h5 params null", new Object[0]);
        } else {
            ProductInfo productInfo = new ProductInfo();
            try {
                JSONObject jSONObject = new JSONObject(nativeOperationParams.params);
                productInfo.cid = jSONObject.optInt(IAdRequestParam.CELL_ID);
                productInfo.productId = jSONObject.optString("productId", "");
                productInfo.srcCurrencySymbol = jSONObject.optString("srcCurrencySymbol", "");
                productInfo.destAmount = jSONObject.optInt("destAmount");
                productInfo.srcAmount = Double.valueOf(jSONObject.optDouble("srcAmount", 0.0d));
                IYYPayWayView.b bVar = new IYYPayWayView.b();
                PayUIKitConfig payUIKitConfig = uIKit.getPayUIKitConfig();
                MiddleRevenueConfig middleRevenueConfig = payUIKitConfig != null ? payUIKitConfig.revenueConfig : null;
                if (middleRevenueConfig != null) {
                    bVar.f72921b = new i.a.a.e.l.a(productInfo, middleRevenueConfig.getCurrencyType());
                } else {
                    bVar.f72921b = new i.a.a.e.l.a(productInfo);
                }
                RLog.info(this.TAG, "startPayChannelDialog: payAmount:%s", bVar.f72921b);
                uIKit.startPayChannelDialog(this, bVar, new c());
            } catch (Exception e2) {
                RLog.error(this.TAG, "get productInfo error:", e2.getLocalizedMessage());
            }
        }
    }

    private void onOpenPayPage(NativeOperationParams nativeOperationParams) {
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
        if (uIKit == null) {
            RLog.error(this.TAG, "onOpenPayPage onNativeOperation null yyPayUIKit", new Object[0]);
            return;
        }
        uIKit.startPayDialog(this, null, new b());
        i.a.a.e.m.a.b(this.mAppId, this.mUserChannel, UiEventType.walletclickcharge);
        RLog.warn(this.TAG, UiEventType.walletclickcharge);
    }

    private void onOpenUrlPageCustom(NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
        if (uIKit == null) {
            RLog.error(this.TAG, "onNativeOperation null yyPayUIKit", new Object[0]);
            return;
        }
        H5PayFlowModel h5PayFlowModel = uIKit.getH5PayFlowModel();
        if (h5PayFlowModel != null && (absViewEventHandler = h5PayFlowModel.viewEventListener) != null) {
            absViewEventHandler.onHandleUrl(nativeOperationParams.params);
        } else {
            RLog.error(this.TAG, "onNativeOperation error h5PayFlowModel null", new Object[0]);
        }
    }

    private void setAppIdAndChannel() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mAppId = intent.getIntExtra(H5PayConstant.EXTRA_APP_ID, -1);
        this.mUserChannel = intent.getIntExtra(H5PayConstant.EXTRA_USER_CHANNEL, -1);
        this.mLocalPageType = intent.getIntExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 0);
    }

    private void setTitleAndRight(String str, String str2) {
        this.mSimpleNavigationBar.setTitle(str);
        this.mSimpleNavigationBar.setRight(str2);
    }

    private void setTitleInfo() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mTitle = intent.getStringExtra(H5PayConstant.EXTRA_TITLE);
        this.mRightTitle = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT);
        this.mRightUrl = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_URL);
        setTitleAndRight(this.mTitle, this.mRightTitle);
        this.TAG += this.mTitle;
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public String getToken() {
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
        if (uIKit == null) {
            RLog.error(this.TAG, "getToken() yyPayUIKit null", new Object[0]);
            return "";
        }
        PayUIKitConfig payUIKitConfig = uIKit.getPayUIKitConfig();
        if (payUIKitConfig == null) {
            RLog.error(this.TAG, "getToken()  payUIKitConfig null", new Object[0]);
            return "";
        }
        MiddleRevenueConfig middleRevenueConfig = payUIKitConfig.revenueConfig;
        if (middleRevenueConfig == null) {
            RLog.error(this.TAG, "getToken()  revenueConfig null", new Object[0]);
            return "";
        }
        IToken tokenCallback = middleRevenueConfig.getTokenCallback();
        if (tokenCallback == null) {
            RLog.error(this.TAG, "getToken()  iToken null", new Object[0]);
            return "";
        }
        return tokenCallback.onUpdateToken();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.pay_ui_common_web_activity);
        if (Build.VERSION.SDK_INT >= 19) {
            i.a.a.e.i.a.d H = i.a.a.e.i.a.d.H(this);
            H.g(true);
            H.F();
            H.z(17170443);
            H.q(false);
            H.B(true);
            H.i();
            this.immersionBar = H;
        }
        this.mLoginOutReceiver = new d(this, null);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mLoginOutReceiver, new IntentFilter("tv.athena.revenue.payui.login_out_action"));
        this.mContainer = (FrameLayout) findViewById(i.a.a.e.d.fl_container);
        SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(i.a.a.e.d.simple_navigation_bar);
        this.mSimpleNavigationBar = simpleNavigationBar;
        simpleNavigationBar.setCallback(new a());
        setTitleInfo();
        setAppIdAndChannel();
        loadWebView();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        i.a.a.e.i.a.d dVar = this.immersionBar;
        if (dVar != null) {
            dVar.f();
        }
        if (this.mLoginOutReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mLoginOutReceiver);
            this.mLoginOutReceiver = null;
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onNativeOperation(NativeOperationParams nativeOperationParams) {
        RLog.debug(this.TAG, "onNativeOperation: %s", nativeOperationParams);
        if (nativeOperationParams == null) {
            return;
        }
        int i2 = nativeOperationParams.opCode;
        if (i2 == 2) {
            onOpenPayPage(nativeOperationParams);
        } else if (i2 == 4) {
            onOpenPayChannelPage(nativeOperationParams);
        } else if (i2 == 5) {
            onBannerClick(nativeOperationParams);
        } else if (i2 == 6) {
            onOpenUrlPageCustom(nativeOperationParams);
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onOpenNewUrl(i.a.a.e.l.e eVar, i.a.a.e.l.d dVar) {
        String str;
        RLog.info(this.TAG, "onOpenNewUrl: urlParams:%s, topUiParams:%s", eVar, dVar);
        if (eVar == null || (str = eVar.f72165a) == null || str.isEmpty()) {
            return;
        }
        Intent intent = new Intent(this, PayCommonWebActivity.class);
        String str2 = dVar.f72162a;
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra(H5PayConstant.EXTRA_TITLE, dVar.f72162a);
        }
        String str3 = dVar.f72163b;
        if (str3 != null && !str3.isEmpty()) {
            intent.putExtra(H5PayConstant.EXTRA_RIGHT, dVar.f72163b);
        }
        intent.putExtra(H5PayConstant.EXTRA_URL, eVar.f72165a);
        String str4 = dVar.f72164c;
        if (str4 != null && !str4.isEmpty()) {
            intent.putExtra(H5PayConstant.EXTRA_RIGHT_URL, dVar.f72164c);
        }
        intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.mAppId);
        intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.mUserChannel);
        i.a.a.e.m.a.b(this.mAppId, this.mUserChannel, UiEventType.wallet_secondpage_title);
        RLog.warn(this.TAG, UiEventType.wallet_secondpage_title);
        if (eVar.f72166b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
            i.a.a.e.m.a.b(this.mAppId, this.mUserChannel, UiEventType.walletclickdetail);
            RLog.warn(this.TAG, UiEventType.walletclickClose);
        }
        startActivity(intent);
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        boolean isDxmKjPayPage = isDxmKjPayPage();
        boolean isMockTestPage = isMockTestPage();
        String str = this.TAG;
        RLog.debug(str, "onStop()->isDxmKjPayPage:" + isDxmKjPayPage + ", isMockTestPage:" + isMockTestPage);
        if (isDxmKjPayPage || isMockTestPage) {
            H5PayManager.getInstance().verifyPayOrder();
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onUpdateTopUi(i.a.a.e.l.d dVar) {
        RLog.info(this.TAG, "onUpdateTopUi: %s", dVar);
        if (dVar != null) {
            String str = dVar.f72163b;
            if (str != null && !str.isEmpty()) {
                this.mRightTitle = dVar.f72163b;
            }
            String str2 = dVar.f72164c;
            if (str2 != null && !str2.isEmpty()) {
                this.mRightUrl = dVar.f72164c;
            }
            String str3 = dVar.f72162a;
            if (str3 != null && !str3.isEmpty()) {
                this.mTitle = dVar.f72162a;
            }
            setTitleAndRight(this.mTitle, this.mRightTitle);
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onUrlLoading(WebView webView, String str) {
        if (Env.instance().isTestEnv() && this.mLocalPageType == 3) {
            RLog.info(this.TAG, "onUrlLoading url:%s", str);
            if (str.startsWith("https://payplf-gate-test.yy.com/tpay/return.do")) {
                finish();
            }
        }
    }
}
