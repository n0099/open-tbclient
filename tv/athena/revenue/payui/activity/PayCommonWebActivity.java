package tv.athena.revenue.payui.activity;

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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.Env;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PurchaseStatus;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import j.a.a.e.f.h;
import j.a.a.e.h.i;
import j.a.a.e.h.k;
import j.a.a.e.h.p;
import j.a.a.e.h.q;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsPayMessageReceiver;
import tv.athena.revenue.payui.view.YYPayWebView;
import tv.athena.revenue.payui.webview.UrlPageType;
import tv.athena.revenue.payui.widget.SimpleNavigationBar;
/* loaded from: classes9.dex */
public class PayCommonWebActivity extends YYPayBaseActivity implements YYPayWebView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public String TAG_PRE;
    public j.a.a.e.c.a.d immersionBar;
    public boolean mAllPayFlowRelease;
    public int mAppId;
    public FrameLayout mContainer;
    public int mLocalPageType;
    public PayFlowType mPayFlowType;
    public AbsPayMessageReceiver mReleasePayViewHandler;
    public String mRightTitle;
    public String mRightUrl;
    public SimpleNavigationBar mSimpleNavigationBar;
    public TextView mTestBannerBtn;
    public TextView mTestWalletBtn;
    public String mTitle;
    public String mUrl;
    public int mUserChannel;
    public YYPayWebView mYYPayWebView;

    /* loaded from: classes9.dex */
    public class a implements SimpleNavigationBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity a;

        public a(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payCommonWebActivity;
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void onBackPress() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.tryReportWalletClickClose();
                this.a.finish();
            }
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void onRightClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.tryStartWebActivity();
                this.a.tryReportWalletShowHelp();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends AbsPayMessageReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PayCommonWebActivity payCommonWebActivity, PayFlowType payFlowType) {
            super(payFlowType);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity, payFlowType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((PayFlowType) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = payCommonWebActivity;
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onAllPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RLog.info(this.this$0.TAG, "AbsReleasePayViewReceiver onAllPayFlowViewRelease");
                this.this$0.mAllPayFlowRelease = true;
                this.this$0.finish();
            }
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onDialogPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.info(this.this$0.TAG, "AbsReleasePayViewReceiver onDialogPayFlowViewRelease");
                this.this$0.finish();
            }
        }

        @Override // tv.athena.revenue.payui.view.AbsPayMessageReceiver
        public void onWalletPayFlowViewRelease() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.info(this.this$0.TAG, "AbsReleasePayViewReceiver onWalletPayFlowViewRelease");
                this.this$0.finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayCommonWebActivity f61493e;

        public c(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61493e = payCommonWebActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.a.a.e.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = YYPayUIKit.mTestFunListenerr) == null) {
                return;
            }
            bVar.b(view);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PayCommonWebActivity f61494e;

        public d(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61494e = payCommonWebActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.a.a.e.e.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (bVar = YYPayUIKit.mTestFunListenerr) == null) {
                return;
            }
            bVar.a(view);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity a;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f61495e;

            public a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f61495e = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61495e.a.mYYPayWebView == null || this.f61495e.a.mUrl == null || this.f61495e.a.mUrl.isEmpty()) {
                    return;
                }
                this.f61495e.a.mYYPayWebView.loadUrl(this.f61495e.a.mUrl);
            }
        }

        public e(PayCommonWebActivity payCommonWebActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {payCommonWebActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = payCommonWebActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) {
                RLog.debug(this.a.TAG, "onSuccess");
                if (!q.a.a(this.a)) {
                    RLog.info(this.a.TAG, "onSuccess activity not valid");
                } else {
                    this.a.runOnUiThread(new a(this));
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
            }
        }
    }

    public PayCommonWebActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "PayCommonWebActivity";
        this.TAG_PRE = "PayCommonWebActivity";
        this.mAppId = -1;
        this.mUserChannel = -1;
    }

    private void fetchPayParamsFromIntent() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mAppId = intent.getIntExtra(H5PayConstant.EXTRA_APP_ID, -1);
        this.mUserChannel = intent.getIntExtra(H5PayConstant.EXTRA_USER_CHANNEL, -1);
        this.mLocalPageType = intent.getIntExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 0);
        PayFlowType a2 = i.a(intent.getIntExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, 0));
        this.mPayFlowType = a2;
        if (a2 == null) {
            Toast.makeText(this, "error payFlowTypeId!", 1).show();
            RLog.error(this.TAG, "error payFlowTypeId", new Object[0]);
            finish();
        }
        String str = this.TAG;
        RLog.info(str, "fetchPayParamsFromIntent payFlowTypeId: " + this.mPayFlowType.getTypeId());
    }

    private boolean isDxmKjPayPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? this.mLocalPageType == 2 : invokeV.booleanValue;
    }

    private boolean isMockTestPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) ? Env.instance().isTestEnv() && this.mLocalPageType == 3 : invokeV.booleanValue;
    }

    private boolean isUnionPayPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) ? this.mLocalPageType == 4 : invokeV.booleanValue;
    }

    private boolean isWalletPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.mLocalPageType == 1 : invokeV.booleanValue;
    }

    private void onOpenPayChannelPage(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, nativeOperationParams) == null) {
            j.a.a.e.b.b(this.mAppId, this.mUserChannel, this, nativeOperationParams, new e(this));
        }
    }

    private void registerPayMessageReceiver() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            b bVar = new b(this, this.mPayFlowType);
            this.mReleasePayViewHandler = bVar;
            k.d(this, bVar);
        }
    }

    private void setTitleAndRight(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, str, str2) == null) {
            this.mSimpleNavigationBar.setTitle(str);
            this.mSimpleNavigationBar.setRight(str2);
        }
    }

    private void startLoadWebView() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65552, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra(H5PayConstant.EXTRA_URL);
        this.mUrl = stringExtra;
        RLog.info(this.TAG, "startLoadWebView: %s", p.a(stringExtra));
        String str = this.mUrl;
        if (str == null || str.isEmpty()) {
            return;
        }
        YYPayWebView yYPayWebView = new YYPayWebView(this);
        this.mYYPayWebView = yYPayWebView;
        yYPayWebView.setCallback(this);
        this.mYYPayWebView.loadUrl(this.mUrl);
        this.mContainer.addView(this.mYYPayWebView, -1, -1);
    }

    public static void startWebActivity(Context context, PayFlowType payFlowType, Intent intent, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{context, payFlowType, intent, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            j.a.a.e.a.b(str, i2, i3, payFlowType);
            intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, payFlowType.getTypeId());
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReportWalletClickClose() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65554, this) == null) && isWalletPage()) {
            j.a.a.e.g.b.b(this.mAppId, this.mUserChannel, UiEventType.walletclickClose);
            RLog.info(this.TAG, UiEventType.walletclickClose);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReportWalletShowHelp() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && isWalletPage()) {
            j.a.a.e.g.b.b(this.mAppId, this.mUserChannel, UiEventType.walletshowhelp);
            RLog.info(this.TAG, UiEventType.walletshowhelp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryStartWebActivity() {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (str = this.mRightUrl) == null || str.isEmpty() || (str2 = this.mRightTitle) == null || str2.isEmpty()) {
            return;
        }
        Intent intent = new Intent(this, PayCommonWebActivity.class);
        intent.putExtra(H5PayConstant.EXTRA_URL, this.mRightUrl);
        intent.putExtra(H5PayConstant.EXTRA_TITLE, this.mRightTitle);
        intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.mAppId);
        intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.mUserChannel);
        startWebActivity(this, this.mPayFlowType, intent, this.mAppId, this.mUserChannel, TextUtils.isEmpty(this.mRightTitle) ? p.a(this.mRightUrl) : this.mRightTitle);
    }

    private void tryVerifyPayOrder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            boolean isDxmKjPayPage = isDxmKjPayPage();
            boolean isMockTestPage = isMockTestPage();
            boolean isUnionPayPage = isUnionPayPage();
            String str = this.TAG;
            RLog.debug(str, "tryVerifyPayOrder() isDxmKjPayPage:" + isDxmKjPayPage + ", isMockTestPage:" + isMockTestPage + " isUnionPayPage:" + isUnionPayPage);
            if (isDxmKjPayPage || isMockTestPage || isUnionPayPage) {
                H5PayManager.getInstance().verifyPayOrder();
            }
        }
    }

    private void updateTestBannerView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            if (YYPayUIKit.mTestFunListenerr != null) {
                this.mTestBannerBtn.setVisibility(0);
                this.mTestBannerBtn.setOnClickListener(new c(this));
                this.mTestWalletBtn.setVisibility(0);
                this.mTestWalletBtn.setOnClickListener(new d(this));
                return;
            }
            this.mTestBannerBtn.setVisibility(8);
            this.mTestWalletBtn.setVisibility(8);
        }
    }

    private void updateTitleInfoView() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mTitle = intent.getStringExtra(H5PayConstant.EXTRA_TITLE);
        this.mRightTitle = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT);
        this.mRightUrl = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_URL);
        setTitleAndRight(this.mTitle, this.mRightTitle);
        this.TAG = this.TAG_PRE + "@" + hashCode() + "@title:" + this.mTitle;
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
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
        return (String) invokeV.objValue;
    }

    @Override // tv.athena.revenue.payui.activity.YYPayBaseActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.pay_ui_common_web_activity);
            this.TAG = this.TAG_PRE + "@" + hashCode();
            if (Build.VERSION.SDK_INT >= 19) {
                j.a.a.e.c.a.d H = j.a.a.e.c.a.d.H(this);
                H.g(true);
                H.F();
                H.z(17170443);
                H.q(false);
                H.B(true);
                H.i();
                this.immersionBar = H;
            }
            fetchPayParamsFromIntent();
            String str = this.TAG;
            RLog.info(str, "onCreate mPayFlowType:" + this.mPayFlowType);
            registerPayMessageReceiver();
            this.mTestBannerBtn = (TextView) findViewById(R.id.test_banner_btn);
            this.mTestWalletBtn = (TextView) findViewById(R.id.test_wallet_btn);
            this.mContainer = (FrameLayout) findViewById(R.id.fl_container);
            SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(R.id.simple_navigation_bar);
            this.mSimpleNavigationBar = simpleNavigationBar;
            simpleNavigationBar.setCallback(new a(this));
            updateTitleInfoView();
            updateTestBannerView();
            startLoadWebView();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            String str = this.TAG;
            RLog.info(str, "onDestroy mAllPayFlowRelease:" + this.mAllPayFlowRelease);
            j.a.a.e.c.a.d dVar = this.immersionBar;
            if (dVar != null) {
                dVar.f();
            }
            AbsPayMessageReceiver absPayMessageReceiver = this.mReleasePayViewHandler;
            if (absPayMessageReceiver != null) {
                k.e(this, absPayMessageReceiver);
                this.mReleasePayViewHandler = null;
            }
            if (this.mAllPayFlowRelease) {
                return;
            }
            j.a.a.e.a.a(TextUtils.isEmpty(this.mTitle) ? p.a(this.mUrl) : this.mTitle, this.mAppId, this.mUserChannel, this.mPayFlowType);
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onNativeOperation(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, nativeOperationParams) == null) {
            RLog.debug(this.TAG, "onNativeOperation: %s", nativeOperationParams);
            if (nativeOperationParams == null) {
                return;
            }
            int i2 = nativeOperationParams.opCode;
            if (i2 == 4) {
                onOpenPayChannelPage(nativeOperationParams);
            } else if (i2 == 5) {
                j.a.a.e.b.a(this.mAppId, this.mUserChannel, this.mPayFlowType, nativeOperationParams);
            } else if (i2 == 6) {
                j.a.a.e.b.c(this.mAppId, this.mUserChannel, this.mPayFlowType, nativeOperationParams);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onOpenNewUrl(j.a.a.e.f.i iVar, h hVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, iVar, hVar) == null) {
            RLog.info(this.TAG, "onOpenNewUrl: urlParams:%s, topUiParams:%s", iVar, hVar);
            if (iVar == null || (str = iVar.a) == null || str.isEmpty()) {
                return;
            }
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            String str2 = hVar.a;
            if (str2 != null && !str2.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_TITLE, hVar.a);
            }
            String str3 = hVar.f60912b;
            if (str3 != null && !str3.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT, hVar.f60912b);
            }
            intent.putExtra(H5PayConstant.EXTRA_URL, iVar.a);
            String str4 = hVar.f60913c;
            if (str4 != null && !str4.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_URL, hVar.f60913c);
            }
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.mAppId);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.mUserChannel);
            j.a.a.e.g.b.b(this.mAppId, this.mUserChannel, UiEventType.wallet_secondpage_title);
            RLog.warn(this.TAG, UiEventType.wallet_secondpage_title);
            if (iVar.f60914b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
                j.a.a.e.g.b.b(this.mAppId, this.mUserChannel, UiEventType.walletclickdetail);
                RLog.warn(this.TAG, UiEventType.walletclickClose);
            }
            startWebActivity(this, this.mPayFlowType, intent, this.mAppId, this.mUserChannel, TextUtils.isEmpty(hVar.a) ? p.a(iVar.a) : hVar.a);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStop();
            tryVerifyPayOrder();
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onUpdateTopUi(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, hVar) == null) {
            RLog.info(this.TAG, "onUpdateTopUi: %s", hVar);
            if (hVar != null) {
                String str = hVar.f60912b;
                if (str != null && !str.isEmpty()) {
                    this.mRightTitle = hVar.f60912b;
                }
                String str2 = hVar.f60913c;
                if (str2 != null && !str2.isEmpty()) {
                    this.mRightUrl = hVar.f60913c;
                }
                String str3 = hVar.a;
                if (str3 != null && !str3.isEmpty()) {
                    this.mTitle = hVar.a;
                }
                setTitleAndRight(this.mTitle, this.mRightTitle);
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onUrlLoading(WebView webView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048583, this, webView, str) == null) && Env.instance().isTestEnv() && this.mLocalPageType == 3) {
            RLog.info(this.TAG, "onUrlLoading url:%s", str);
            if (str.startsWith("https://payplf-gate-test.yy.com/tpay/return.do")) {
                finish();
            }
        }
    }
}
