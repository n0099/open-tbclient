package tv.athena.revenue.payui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import i.a.a.e.c;
import i.a.a.e.h.a.d;
import i.a.a.e.j.f;
import i.a.a.e.l.e;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.YYPayWebCommonView;
import tv.athena.revenue.payui.webview.UrlPageType;
import tv.athena.revenue.payui.widget.SimpleNavigationBar;
/* loaded from: classes7.dex */
public class PayCommonWebActivity extends YYPayBaseActivity implements YYPayWebCommonView.a {
    public static final String EXTRA_APP_ID = "EXTRA_APP_ID";
    public static final int EXTRA_INVALID_ID = -1;
    public static final String EXTRA_PAGE_TYPE = "EXTRA_PAGE_TYPE";
    public static final String EXTRA_RIGHT = "EXTRA_RIGHT";
    public static final String EXTRA_RIGHT_URL = "EXTRA_RIGHT_URL";
    public static final String EXTRA_TITLE = "EXTRA_TITLE";
    public static final String EXTRA_URL = "EXTRA_URL";
    public static final String EXTRA_USER_CHANNEL = "EXTRA_USER_CHANNEL";
    public d immersionBar;
    public FrameLayout mContainer;
    public int mPageType;
    public String mRightTitle;
    public String mRightUrl;
    public SimpleNavigationBar mSimpleNavigationBar;
    public String mTitle;
    public String mUrl;
    public YYPayWebCommonView mYYPayWebCommonView;
    public String TAG = "PayCommonWebActivity-";
    public int mAppId = -1;
    public int mUserChannel = -1;

    /* loaded from: classes7.dex */
    public class a implements SimpleNavigationBar.c {
        public a() {
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void D() {
            if (PayCommonWebActivity.this.isWalletPage()) {
                i.a.a.e.k.a.b(PayCommonWebActivity.this.mAppId, PayCommonWebActivity.this.mUserChannel, "walletclickClose");
                d.r.b.a.a.f.d.d.h(PayCommonWebActivity.this.TAG, "walletclickClose");
            }
            PayCommonWebActivity.this.finish();
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void onRightClick() {
            if (PayCommonWebActivity.this.mRightUrl != null && !PayCommonWebActivity.this.mRightUrl.isEmpty() && PayCommonWebActivity.this.mRightTitle != null && !PayCommonWebActivity.this.mRightTitle.isEmpty()) {
                Intent intent = new Intent(PayCommonWebActivity.this, PayCommonWebActivity.class);
                intent.putExtra(PayCommonWebActivity.EXTRA_URL, PayCommonWebActivity.this.mRightUrl);
                intent.putExtra(PayCommonWebActivity.EXTRA_TITLE, PayCommonWebActivity.this.mRightTitle);
                intent.putExtra(PayCommonWebActivity.EXTRA_APP_ID, PayCommonWebActivity.this.mAppId);
                intent.putExtra(PayCommonWebActivity.EXTRA_USER_CHANNEL, PayCommonWebActivity.this.mUserChannel);
                PayCommonWebActivity.this.startActivity(intent);
            }
            if (PayCommonWebActivity.this.isWalletPage()) {
                i.a.a.e.k.a.b(PayCommonWebActivity.this.mAppId, PayCommonWebActivity.this.mUserChannel, "walletshowhelp");
                d.r.b.a.a.f.d.d.h(PayCommonWebActivity.this.TAG, "walletshowhelp");
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IPayCallback {

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (PayCommonWebActivity.this.mYYPayWebCommonView == null || PayCommonWebActivity.this.mUrl == null || PayCommonWebActivity.this.mUrl.isEmpty()) {
                    return;
                }
                PayCommonWebActivity.this.mYYPayWebCommonView.d(PayCommonWebActivity.this.mUrl);
            }
        }

        public b() {
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b(PayCommonWebActivity.this.TAG, "onFail");
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            d.r.b.a.a.f.d.d.b(PayCommonWebActivity.this.TAG, "onPayStart");
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b(PayCommonWebActivity.this.TAG, "onPayStatus");
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b(PayCommonWebActivity.this.TAG, "onSuccess");
            if (!e.f68162a.a(PayCommonWebActivity.this)) {
                d.r.b.a.a.f.d.d.f(PayCommonWebActivity.this.TAG, "onSuccess activity not valid");
            } else {
                PayCommonWebActivity.this.runOnUiThread(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWalletPage() {
        return this.mPageType == ActivityPageType.WALLET.ordinal();
    }

    private void loadWebView() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(EXTRA_URL);
        this.mUrl = stringExtra;
        d.r.b.a.a.f.d.d.g(this.TAG, "loadWeb: %s", stringExtra);
        String str = this.mUrl;
        if (str == null || str.isEmpty()) {
            return;
        }
        YYPayWebCommonView yYPayWebCommonView = new YYPayWebCommonView(this);
        this.mYYPayWebCommonView = yYPayWebCommonView;
        yYPayWebCommonView.setCallback(this);
        this.mYYPayWebCommonView.d(this.mUrl);
        this.mContainer.addView(this.mYYPayWebCommonView, -1, -1);
    }

    private void setAppIdAndChannel() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        this.mAppId = intent.getIntExtra(EXTRA_APP_ID, -1);
        this.mUserChannel = intent.getIntExtra(EXTRA_USER_CHANNEL, -1);
        this.mPageType = intent.getIntExtra(EXTRA_PAGE_TYPE, 0);
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
        this.mTitle = intent.getStringExtra(EXTRA_TITLE);
        this.mRightTitle = intent.getStringExtra(EXTRA_RIGHT);
        this.mRightUrl = intent.getStringExtra(EXTRA_RIGHT_URL);
        setTitleAndRight(this.mTitle, this.mRightTitle);
        this.TAG += this.mTitle;
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebCommonView.a
    public String getToken() {
        YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
        if (uIKit == null) {
            d.r.b.a.a.f.d.d.e(this.TAG, "getToken() yyPayUIKit null", new Object[0]);
            return "";
        }
        PayUIKitConfig payUIKitConfig = uIKit.getPayUIKitConfig();
        if (payUIKitConfig == null) {
            d.r.b.a.a.f.d.d.e(this.TAG, "getToken()  payUIKitConfig null", new Object[0]);
            return "";
        }
        MiddleRevenueConfig middleRevenueConfig = payUIKitConfig.revenueConfig;
        if (middleRevenueConfig == null) {
            d.r.b.a.a.f.d.d.e(this.TAG, "getToken()  revenueConfig null", new Object[0]);
            return "";
        }
        IToken tokenCallback = middleRevenueConfig.getTokenCallback();
        if (tokenCallback == null) {
            d.r.b.a.a.f.d.d.e(this.TAG, "getToken()  iToken null", new Object[0]);
            return "";
        }
        return tokenCallback.onUpdateToken();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.a.a.e.d.yy_common_web_activity);
        if (Build.VERSION.SDK_INT >= 19) {
            d H = d.H(this);
            H.g(true);
            H.F();
            H.z(17170443);
            H.q(false);
            H.B(true);
            H.i();
            this.immersionBar = H;
        }
        this.mContainer = (FrameLayout) findViewById(c.fl_container);
        SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(c.simple_navigation_bar);
        this.mSimpleNavigationBar = simpleNavigationBar;
        simpleNavigationBar.setCallback(new a());
        setTitleInfo();
        setAppIdAndChannel();
        loadWebView();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d dVar = this.immersionBar;
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebCommonView.a
    public void onNativeOperation(i.a.a.e.j.a aVar) {
        d.r.b.a.a.f.d.d.g(this.TAG, "onNativeOperation: %s", aVar);
        if (aVar != null && aVar.f68149a == 2) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
            if (uIKit == null) {
                d.r.b.a.a.f.d.d.e(this.TAG, "onNativeOperation null yyPayUIKit", new Object[0]);
                return;
            }
            uIKit.startPayDialog(this, null, new b());
            i.a.a.e.k.a.b(this.mAppId, this.mUserChannel, "walletclickcharge");
            d.r.b.a.a.f.d.d.h(this.TAG, "walletclickcharge");
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebCommonView.a
    public void onOpenNewUrl(f fVar, i.a.a.e.j.e eVar) {
        String str;
        d.r.b.a.a.f.d.d.g(this.TAG, "onOpenNewUrl: urlParams:%s, topUiParams:%s", fVar, eVar);
        if (fVar == null || (str = fVar.f68160a) == null || str.isEmpty()) {
            return;
        }
        Intent intent = new Intent(this, PayCommonWebActivity.class);
        String str2 = eVar.f68157a;
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra(EXTRA_TITLE, eVar.f68157a);
        }
        String str3 = eVar.f68158b;
        if (str3 != null && !str3.isEmpty()) {
            intent.putExtra(EXTRA_RIGHT, eVar.f68158b);
        }
        intent.putExtra(EXTRA_URL, fVar.f68160a);
        String str4 = eVar.f68159c;
        if (str4 != null && !str4.isEmpty()) {
            intent.putExtra(EXTRA_RIGHT_URL, eVar.f68159c);
        }
        intent.putExtra(EXTRA_APP_ID, this.mAppId);
        intent.putExtra(EXTRA_USER_CHANNEL, this.mUserChannel);
        i.a.a.e.k.a.b(this.mAppId, this.mUserChannel, "wallet_secondpage_title");
        d.r.b.a.a.f.d.d.h(this.TAG, "wallet_secondpage_title");
        if (fVar.f68161b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
            i.a.a.e.k.a.b(this.mAppId, this.mUserChannel, "walletclickdetail");
            d.r.b.a.a.f.d.d.h(this.TAG, "walletclickClose");
        }
        startActivity(intent);
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebCommonView.a
    public void onUpdateTopUi(i.a.a.e.j.e eVar) {
        d.r.b.a.a.f.d.d.g(this.TAG, "onUpdateTopUi: %s", eVar);
        if (eVar != null) {
            String str = eVar.f68158b;
            if (str != null && !str.isEmpty()) {
                this.mRightTitle = eVar.f68158b;
            }
            String str2 = eVar.f68159c;
            if (str2 != null && !str2.isEmpty()) {
                this.mRightUrl = eVar.f68159c;
            }
            String str3 = eVar.f68157a;
            if (str3 != null && !str3.isEmpty()) {
                this.mTitle = eVar.f68157a;
            }
            setTitleAndRight(this.mTitle, this.mRightTitle);
        }
    }
}
