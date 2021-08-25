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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import j.a.a.e.e;
import j.a.a.e.n.i;
import org.json.JSONObject;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.H5PayFlowModel;
import tv.athena.revenue.payui.model.NativeOperationParams;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.YYPayWebView;
import tv.athena.revenue.payui.webview.UrlPageType;
import tv.athena.revenue.payui.widget.SimpleNavigationBar;
/* loaded from: classes2.dex */
public class PayCommonWebActivity extends YYPayBaseActivity implements YYPayWebView.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public j.a.a.e.i.a.d immersionBar;
    public int mAppId;
    public FrameLayout mContainer;
    public int mLocalPageType;
    public d mLoginOutReceiver;
    public String mRightTitle;
    public String mRightUrl;
    public SimpleNavigationBar mSimpleNavigationBar;
    public String mTitle;
    public String mUrl;
    public int mUserChannel;
    public YYPayWebView mYYPayWebView;

    /* loaded from: classes2.dex */
    public class a implements SimpleNavigationBar.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PayCommonWebActivity f79692a;

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
            this.f79692a = payCommonWebActivity;
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void C() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f79692a.isWalletPage()) {
                    j.a.a.e.m.a.b(this.f79692a.mAppId, this.f79692a.mUserChannel, UiEventType.walletclickClose);
                    RLog.warn(this.f79692a.TAG, UiEventType.walletclickClose);
                }
                this.f79692a.finish();
            }
        }

        @Override // tv.athena.revenue.payui.widget.SimpleNavigationBar.c
        public void onRightClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.f79692a.mRightUrl != null && !this.f79692a.mRightUrl.isEmpty() && this.f79692a.mRightTitle != null && !this.f79692a.mRightTitle.isEmpty()) {
                    Intent intent = new Intent(this.f79692a, PayCommonWebActivity.class);
                    intent.putExtra(H5PayConstant.EXTRA_URL, this.f79692a.mRightUrl);
                    intent.putExtra(H5PayConstant.EXTRA_TITLE, this.f79692a.mRightTitle);
                    intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.f79692a.mAppId);
                    intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.f79692a.mUserChannel);
                    this.f79692a.startActivity(intent);
                }
                if (this.f79692a.isWalletPage()) {
                    j.a.a.e.m.a.b(this.f79692a.mAppId, this.f79692a.mUserChannel, UiEventType.walletshowhelp);
                    RLog.warn(this.f79692a.TAG, UiEventType.walletshowhelp);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements IPayCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PayCommonWebActivity f79693a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f79694e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79694e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f79694e.f79693a.mYYPayWebView == null || this.f79694e.f79693a.mUrl == null || this.f79694e.f79693a.mUrl.isEmpty()) {
                    return;
                }
                this.f79694e.f79693a.mYYPayWebView.loadUrl(this.f79694e.f79693a.mUrl);
            }
        }

        public b(PayCommonWebActivity payCommonWebActivity) {
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
            this.f79693a = payCommonWebActivity;
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                String str2 = this.f79693a.TAG;
                RLog.debug(str2, "onFail code:" + i2 + " failReason:" + str);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                RLog.debug(this.f79693a.TAG, "onPayStart");
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, purchaseStatus, payCallBackBean) == null) {
                RLog.debug(this.f79693a.TAG, "onPayStatus");
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onSuccess(Object obj, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, obj, payCallBackBean) == null) {
                RLog.debug(this.f79693a.TAG, "onSuccess");
                if (!i.f78937a.a(this.f79693a)) {
                    RLog.info(this.f79693a.TAG, "onSuccess activity not valid");
                } else {
                    this.f79693a.runOnUiThread(new a(this));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements IPayCallback<CurrencyChargeMessage> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PayCommonWebActivity f79695a;

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f79696e;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f79696e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f79696e.f79695a.mYYPayWebView == null || this.f79696e.f79695a.mUrl == null || this.f79696e.f79695a.mUrl.isEmpty()) {
                    return;
                }
                this.f79696e.f79695a.mYYPayWebView.loadUrl(this.f79696e.f79695a.mUrl);
            }
        }

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
            this.f79695a = payCommonWebActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(CurrencyChargeMessage currencyChargeMessage, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, currencyChargeMessage, payCallBackBean) == null) {
                RLog.debug(this.f79695a.TAG, "onSuccess");
                if (!i.f78937a.a(this.f79695a)) {
                    RLog.info(this.f79695a.TAG, "onSuccess activity not valid");
                } else {
                    this.f79695a.runOnUiThread(new a(this));
                }
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, payCallBackBean) == null) {
                String str2 = this.f79695a.TAG;
                RLog.debug(str2, "onFail code:" + i2 + " failReason:" + str);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                RLog.debug(this.f79695a.TAG, "onPayStart");
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.IPayCallback
        public void onPayStatus(PurchaseStatus purchaseStatus, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, purchaseStatus, payCallBackBean) == null) {
                RLog.debug(this.f79695a.TAG, "onPayStatus");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PayCommonWebActivity this$0;

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
            this.this$0 = payCommonWebActivity;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent != null && "tv.athena.revenue.payui.login_out_action".equals(intent.getAction())) {
                RLog.info(this.this$0.TAG, "onReceive login out");
                this.this$0.finish();
            }
        }

        public /* synthetic */ d(PayCommonWebActivity payCommonWebActivity, a aVar) {
            this(payCommonWebActivity);
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
        this.TAG = "PayCommonWebActivity-";
        this.mAppId = -1;
        this.mUserChannel = -1;
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

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWalletPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) ? this.mLocalPageType == 1 : invokeV.booleanValue;
    }

    private void loadWebView() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65549, this) == null) || (intent = getIntent()) == null) {
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
        this.mYYPayWebView.loadUrl(this.mUrl);
        this.mContainer.addView(this.mYYPayWebView, -1, -1);
    }

    private void onBannerClick(NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, nativeOperationParams) == null) {
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
    }

    private void onOpenPayChannelPage(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, nativeOperationParams) == null) {
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
                        bVar.f79702b = new j.a.a.e.l.a(productInfo, middleRevenueConfig.getCurrencyType());
                    } else {
                        bVar.f79702b = new j.a.a.e.l.a(productInfo);
                    }
                    RLog.info(this.TAG, "startPayChannelDialog: payAmount:%s", bVar.f79702b);
                    uIKit.startPayChannelDialog(this, bVar, new c(this));
                } catch (Exception e2) {
                    RLog.error(this.TAG, "get productInfo error:", e2.getLocalizedMessage());
                }
            }
        }
    }

    private void onOpenPayPage(NativeOperationParams nativeOperationParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, this, nativeOperationParams) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
            if (uIKit == null) {
                RLog.error(this.TAG, "onOpenPayPage onNativeOperation null yyPayUIKit", new Object[0]);
                return;
            }
            uIKit.startPayDialog(this, null, new b(this));
            j.a.a.e.m.a.b(this.mAppId, this.mUserChannel, UiEventType.walletclickcharge);
            RLog.warn(this.TAG, UiEventType.walletclickcharge);
        }
    }

    private void onOpenUrlPageCustom(NativeOperationParams nativeOperationParams) {
        AbsViewEventHandler absViewEventHandler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, nativeOperationParams) == null) {
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
    }

    private void setAppIdAndChannel() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mAppId = intent.getIntExtra(H5PayConstant.EXTRA_APP_ID, -1);
        this.mUserChannel = intent.getIntExtra(H5PayConstant.EXTRA_USER_CHANNEL, -1);
        this.mLocalPageType = intent.getIntExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 0);
    }

    private void setTitleAndRight(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, str, str2) == null) {
            this.mSimpleNavigationBar.setTitle(str);
            this.mSimpleNavigationBar.setRight(str2);
        }
    }

    private void setTitleInfo() {
        Intent intent;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65556, this) == null) || (intent = getIntent()) == null) {
            return;
        }
        this.mTitle = intent.getStringExtra(H5PayConstant.EXTRA_TITLE);
        this.mRightTitle = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT);
        this.mRightUrl = intent.getStringExtra(H5PayConstant.EXTRA_RIGHT_URL);
        setTitleAndRight(this.mTitle, this.mRightTitle);
        this.TAG += this.mTitle;
    }

    private void tryNotifyPayFlowFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            RLog.info(this.TAG, "tryNotifyPayFlowFinish");
            if (isWalletPage()) {
                YYPayUIKit uIKit = YYPayUIKit.getUIKit(this.mAppId, this.mUserChannel);
                if (uIKit == null) {
                    RLog.error(this.TAG, "tryNotifyPayFlowFinish null yyPayUIKit", new Object[0]);
                    return;
                }
                RLog.info(this.TAG, "do onPayFlowFinish");
                uIKit.onPayFlowFinish(PayFlowType.ACTIVITY_PAY_FLOW);
            }
        }
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

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(e.pay_ui_common_web_activity);
            if (Build.VERSION.SDK_INT >= 19) {
                j.a.a.e.i.a.d H = j.a.a.e.i.a.d.H(this);
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
            this.mContainer = (FrameLayout) findViewById(j.a.a.e.d.fl_container);
            SimpleNavigationBar simpleNavigationBar = (SimpleNavigationBar) findViewById(j.a.a.e.d.simple_navigation_bar);
            this.mSimpleNavigationBar = simpleNavigationBar;
            simpleNavigationBar.setCallback(new a(this));
            setTitleInfo();
            setAppIdAndChannel();
            loadWebView();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            j.a.a.e.i.a.d dVar = this.immersionBar;
            if (dVar != null) {
                dVar.f();
            }
            if (this.mLoginOutReceiver != null) {
                LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mLoginOutReceiver);
                this.mLoginOutReceiver = null;
            }
            tryNotifyPayFlowFinish();
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
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onOpenNewUrl(j.a.a.e.l.e eVar, j.a.a.e.l.d dVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, eVar, dVar) == null) {
            RLog.info(this.TAG, "onOpenNewUrl: urlParams:%s, topUiParams:%s", eVar, dVar);
            if (eVar == null || (str = eVar.f78934a) == null || str.isEmpty()) {
                return;
            }
            Intent intent = new Intent(this, PayCommonWebActivity.class);
            String str2 = dVar.f78931a;
            if (str2 != null && !str2.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_TITLE, dVar.f78931a);
            }
            String str3 = dVar.f78932b;
            if (str3 != null && !str3.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT, dVar.f78932b);
            }
            intent.putExtra(H5PayConstant.EXTRA_URL, eVar.f78934a);
            String str4 = dVar.f78933c;
            if (str4 != null && !str4.isEmpty()) {
                intent.putExtra(H5PayConstant.EXTRA_RIGHT_URL, dVar.f78933c);
            }
            intent.putExtra(H5PayConstant.EXTRA_APP_ID, this.mAppId);
            intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, this.mUserChannel);
            j.a.a.e.m.a.b(this.mAppId, this.mUserChannel, UiEventType.wallet_secondpage_title);
            RLog.warn(this.TAG, UiEventType.wallet_secondpage_title);
            if (eVar.f78935b == UrlPageType.WALLET_DETAIL_PAGE.ordinal()) {
                j.a.a.e.m.a.b(this.mAppId, this.mUserChannel, UiEventType.walletclickdetail);
                RLog.warn(this.TAG, UiEventType.walletclickClose);
            }
            startActivity(intent);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onStop();
            boolean isDxmKjPayPage = isDxmKjPayPage();
            boolean isMockTestPage = isMockTestPage();
            boolean isUnionPayPage = isUnionPayPage();
            String str = this.TAG;
            RLog.info(str, "onStop()->isDxmKjPayPage:" + isDxmKjPayPage + ", isMockTestPage:" + isMockTestPage + " isUnionPayPage:" + isUnionPayPage);
            if (isDxmKjPayPage || isMockTestPage || isUnionPayPage) {
                H5PayManager.getInstance().verifyPayOrder();
            }
        }
    }

    @Override // tv.athena.revenue.payui.view.YYPayWebView.c
    public void onUpdateTopUi(j.a.a.e.l.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, dVar) == null) {
            RLog.info(this.TAG, "onUpdateTopUi: %s", dVar);
            if (dVar != null) {
                String str = dVar.f78932b;
                if (str != null && !str.isEmpty()) {
                    this.mRightTitle = dVar.f78932b;
                }
                String str2 = dVar.f78933c;
                if (str2 != null && !str2.isEmpty()) {
                    this.mRightUrl = dVar.f78933c;
                }
                String str3 = dVar.f78931a;
                if (str3 != null && !str3.isEmpty()) {
                    this.mTitle = dVar.f78931a;
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
