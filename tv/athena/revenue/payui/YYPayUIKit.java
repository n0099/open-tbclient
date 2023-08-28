package tv.athena.revenue.payui;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.baidu.tieba.afc;
import com.baidu.tieba.cgc;
import com.baidu.tieba.dec;
import com.baidu.tieba.fec;
import com.baidu.tieba.ffc;
import com.baidu.tieba.ghc;
import com.baidu.tieba.hdc;
import com.baidu.tieba.hec;
import com.baidu.tieba.iec;
import com.baidu.tieba.jec;
import com.baidu.tieba.kfc;
import com.baidu.tieba.lfc;
import com.baidu.tieba.mgc;
import com.baidu.tieba.ofc;
import com.baidu.tieba.rfc;
import com.baidu.tieba.sdc;
import com.baidu.tieba.tdc;
import com.baidu.tieba.wdc;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IPaySignServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.PayMethodProxyFactory;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.PaySignMethodProxyFactory;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.controller.IYYPayListener;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.WindowParams;
@Keep
/* loaded from: classes2.dex */
public class YYPayUIKit implements wdc {
    public static final String TAG = "YYPayUiKit";
    public static Map<String, YYPayUIKit> mPayUIKitMap = new HashMap();
    public static tdc mTestFunListenerr;
    public Context mAppContext;
    public int mAppId;
    public AppPayServiceListener mAppPayServiceListener;
    public sdc mControllerPayResultListener;
    public kfc mPayFlowLifecycleManager;
    public ffc mPayFrequencyManager;
    public PayUIKitConfig mPayUIKitConfig;
    public IThirdPartPayApi mThirdPartPayApi;
    public int mUserChannel;
    public fec mYYPayController;
    public IFeedbackServiceProxy mFeedbackServiceProxy = null;
    public List<IYYPayListener> mYYPayListener = new ArrayList();

    /* loaded from: classes2.dex */
    public class a implements sdc {
        public a() {
        }

        @Override // com.baidu.tieba.sdc
        public void a(int i, String str, PayCallBackBean payCallBackBean) {
            YYPayUIKit.this.innerNotifyYYPayFailListener(i, str, payCallBackBean);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AppPayServiceListener {
        public b() {
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            super.onCurrencyChargeMessage(currencyChargeMessage);
            YYPayUIKit.this.innerNotifyYYPayListener(currencyChargeMessage);
        }
    }

    static {
        H5PayManager.getInstance().setYYPayWebviewActClass(PayCommonWebActivity.class, new afc());
        iec.a(new jec());
    }

    private fec getOrCreatePayController() {
        if (this.mYYPayController == null) {
            this.mYYPayController = new lfc(this.mAppContext, this.mAppId, this.mUserChannel, this.mControllerPayResultListener, this.mPayUIKitConfig);
        }
        return this.mYYPayController;
    }

    private void preparePayResultListener() {
        RLog.info(TAG, "preparePayResultListener");
        this.mControllerPayResultListener = new a();
    }

    private void registerPayServiceListener() {
        IAppPayService b2 = cgc.b(this.mAppId, this.mUserChannel);
        if (b2 == null) {
            RLog.error(TAG, "registerPayServiceListener error null appPayService", new Object[0]);
            return;
        }
        b bVar = new b();
        this.mAppPayServiceListener = bVar;
        b2.addPayListener(bVar);
    }

    private void unregisterPayServiceListener() {
        if (this.mAppPayServiceListener != null) {
            IAppPayService b2 = cgc.b(this.mAppId, this.mUserChannel);
            if (b2 != null) {
                b2.removePayListener(this.mAppPayServiceListener);
            }
            this.mAppPayServiceListener = null;
        }
    }

    @Override // com.baidu.tieba.wdc
    public void cancelAllRequest() {
        IAppPayService b2 = cgc.b(this.mAppId, this.mUserChannel);
        if (b2 != null) {
            RLog.info(TAG, "cancelAllRequest");
            b2.cancelAllRequest();
            return;
        }
        RLog.error(TAG, "onPayFlowFinish error appPayService null ", new Object[0]);
    }

    @Override // com.baidu.tieba.wdc
    public fec getCurPayController() {
        return this.mYYPayController;
    }

    public synchronized IFeedbackServiceProxy getFeedbackServiceProxy() {
        RLog.info(TAG, "getFeedbackServiceProxy mFeedbackServiceProxy:" + this.mFeedbackServiceProxy);
        return this.mFeedbackServiceProxy;
    }

    public IThirdPartPayApi getOrCreateThirdPartPayApi() {
        if (this.mThirdPartPayApi == null) {
            this.mThirdPartPayApi = (IThirdPartPayApi) hdc.a.a(IThirdPartPayApi.class, this.mAppId, this.mUserChannel, this.mAppContext, this.mPayUIKitConfig, this);
        }
        return this.mThirdPartPayApi;
    }

    public PayUIKitConfig getPayUIKitConfig() {
        return this.mPayUIKitConfig;
    }

    public hec getViewLifecycle() {
        return this.mPayFlowLifecycleManager.e();
    }

    public boolean isPayFrequency() {
        return this.mPayFrequencyManager.d();
    }

    public synchronized void release() {
        RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
        releaseAllPayFlowView();
        releasePayController(false);
        releaseThirdPartPayApi();
    }

    public YYPayUIKit(String str) {
        RLog.info(TAG, "create YYPayUiKit mapKey:" + str);
        preparePayResultListener();
        this.mPayFlowLifecycleManager = new kfc(this);
        this.mPayFrequencyManager = new ffc();
    }

    @Override // com.baidu.tieba.wdc
    public synchronized void releasePayController(boolean z) {
        RLog.info(TAG, "releasePayController mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel + " mYYPayController:" + this.mYYPayController + " innerRelease:" + z);
        if (this.mYYPayController != null) {
            this.mYYPayController.b(z);
            this.mYYPayController = null;
        }
    }

    public static YYPayUIKit getUIKit(int i, int i2) {
        String uIKitMapKey = getUIKitMapKey(i, i2);
        YYPayUIKit yYPayUIKit = mPayUIKitMap.get(uIKitMapKey);
        if (yYPayUIKit == null) {
            RLog.warn(TAG, "getUIKit null mapKey:" + uIKitMapKey + " please createNewKitWithConfigure first");
            return null;
        }
        return yYPayUIKit;
    }

    public static String getUIKitMapKey(int i, int i2) {
        return i + "-" + i2;
    }

    public boolean isSupported(@NonNull Activity activity, @NonNull PayType payType) {
        IAppPayService b2 = cgc.b(this.mAppId, this.mUserChannel);
        if (b2 == null) {
            RLog.error(TAG, "isSupported error payService null", new Object[0]);
            return false;
        }
        return b2.isSupported(activity, payType);
    }

    public void startThirdPartDialogPay(ThirdPartPayDialogParams thirdPartPayDialogParams, dec decVar) {
        IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
        if (orCreateThirdPartPayApi != null) {
            orCreateThirdPartPayApi.startPayDialog(thirdPartPayDialogParams, decVar);
        } else {
            RLog.error(TAG, "startThirdPartDialogPay error payApi null", new Object[0]);
        }
    }

    public void startThirdPartDialogPayV2(ThirdPartPayDialogParams thirdPartPayDialogParams, dec decVar) {
        IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
        if (orCreateThirdPartPayApi != null) {
            orCreateThirdPartPayApi.startPayDialogV2(thirdPartPayDialogParams, decVar);
        } else {
            RLog.error(TAG, "startThirdPartDialogPayV2 error payApi null", new Object[0]);
        }
    }

    public void startThirdPartPay(ThirdPartPayParams thirdPartPayParams, dec decVar) {
        IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
        if (orCreateThirdPartPayApi != null) {
            orCreateThirdPartPayApi.startPlay(thirdPartPayParams, decVar);
        } else {
            RLog.error(TAG, "startThirdPartPay error payApi null", new Object[0]);
        }
    }

    public void startWalletActivity(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        RLog.info(TAG, "startWalletActivity viewParams:" + viewParams);
        getOrCreatePayController().i(activity, viewParams);
    }

    public void innerPayWayDialogForWeb(Activity activity, ofc ofcVar, ghc.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        RLog.info(TAG, "innerPayWayDialogForWeb");
        getOrCreatePayController().h(activity, bVar, ofcVar, iPayCallback);
    }

    public static synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        synchronized (YYPayUIKit.class) {
            RLog.info(TAG, "addLogDelegate");
            RevenueManager.instance().addLogDelegate(iRLogDelegate);
        }
    }

    public static void setAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        RLog.info(TAG, "setAlipaySdkProxy");
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
    }

    public static void setDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        RLog.info(TAG, "setDxmPaySdkProxy");
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
    }

    public static void setPaySignProxy(IPaySignServiceProxy iPaySignServiceProxy) {
        RLog.info(TAG, "setPaySignProxy");
        PaySignMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY_SIGN, iPaySignServiceProxy);
    }

    public static void setTestFunListener(tdc tdcVar) {
        mTestFunListenerr = tdcVar;
    }

    public static void setWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        RLog.info(TAG, "setWechatSdkProxy");
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
    }

    public void addYYPayListener(IYYPayListener iYYPayListener) {
        RLog.info(TAG, "addYYPayListener listener:" + iYYPayListener);
        if (iYYPayListener == null) {
            RLog.error(TAG, "addGlobalPayListener error listener null", new Object[0]);
        } else {
            this.mYYPayListener.add(iYYPayListener);
        }
    }

    public PayFlowModel getPayFlowModel(PayFlowType payFlowType) {
        fec fecVar = this.mYYPayController;
        if (fecVar != null) {
            return fecVar.j(payFlowType);
        }
        return null;
    }

    public void refreshWindowParams(WindowParams windowParams) {
        fec fecVar = this.mYYPayController;
        if (fecVar != null) {
            fecVar.refreshWindow(windowParams);
        }
        RLog.info(TAG, "refreshWindowParams params:" + windowParams + " mYYPayController:" + this.mYYPayController);
    }

    public void removeYYPayListener(IYYPayListener iYYPayListener) {
        RLog.info(TAG, "removeYYPayListener listener:" + iYYPayListener);
        if (iYYPayListener == null) {
            RLog.error(TAG, "removeGlobalPayListener error listener null", new Object[0]);
        } else {
            this.mYYPayListener.remove(iYYPayListener);
        }
    }

    public synchronized void setFeedbackServiceProxy(IFeedbackServiceProxy iFeedbackServiceProxy) {
        RLog.info(TAG, "setFeedbackServiceProxy proxy:" + iFeedbackServiceProxy);
        this.mFeedbackServiceProxy = iFeedbackServiceProxy;
    }

    public void setIsPayFrequency(boolean z) {
        RLog.info(TAG, "setIsPayFrequency isPayFrequency:" + z);
        this.mPayFrequencyManager.e(z);
    }

    public void startWalletActivity(Activity activity) {
        RLog.info(TAG, "startWalletActivity");
        getOrCreatePayController().a(activity);
    }

    public void startWebPayActivity(Activity activity) {
        RLog.info(TAG, "startWebPayActivity currentActivity:" + activity);
        getOrCreatePayController().m(activity);
    }

    public static synchronized YYPayUIKit createNewKitWithConfigure(int i, int i2, PayUIKitConfig payUIKitConfig) {
        synchronized (YYPayUIKit.class) {
            String uIKitMapKey = getUIKitMapKey(i, i2);
            if (mPayUIKitMap.containsKey(uIKitMapKey)) {
                RLog.warn(TAG, "createNewKitWithConfigure error mapKey:" + uIKitMapKey + " exits");
                return mPayUIKitMap.get(uIKitMapKey);
            }
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                rfc.h(payUIKitConfig.revenueConfig.isTestEnv());
                YYPayUIKit yYPayUIKit = new YYPayUIKit(uIKitMapKey);
                yYPayUIKit.initYYPayUIKit(i, i2, payUIKitConfig.revenueConfig);
                yYPayUIKit.mPayUIKitConfig = payUIKitConfig;
                yYPayUIKit.mAppContext = payUIKitConfig.revenueConfig.getAppContext();
                mPayUIKitMap.put(uIKitMapKey, yYPayUIKit);
                RLog.info(TAG, "createNewKitWithConfigure success mapKey:" + uIKitMapKey + " config:" + payUIKitConfig.revenueConfig.toString());
                return yYPayUIKit;
            }
            RLog.error(TAG, "createNewKitWithConfigure error revenueConfig null", new Object[0]);
            return null;
        }
    }

    private void initYYPayUIKit(int i, int i2, MiddleRevenueConfig middleRevenueConfig) {
        this.mAppId = i;
        this.mUserChannel = i2;
        RLog.info(TAG, "initYYPayUIKit USE_BD_DOMAIN:false");
        RevenueManager.instance().addRevenueConfig(middleRevenueConfig);
        registerPayServiceListener();
    }

    public void innerPayAmountDialogForWeb(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        RLog.info(TAG, "innerPayAmountDialogForWeb");
        getOrCreatePayController().f(activity, viewParams, iPayCallback);
    }

    public void signPay(Activity activity, PaySignInfo paySignInfo, IPaySignCallback iPaySignCallback) {
        IAppPayService b2 = cgc.b(this.mAppId, this.mUserChannel);
        if (b2 == null) {
            RLog.error(TAG, "isSupported error payService null", new Object[0]);
        } else {
            b2.signAliPay(activity, paySignInfo, iPaySignCallback);
        }
    }

    public void startPayDialog(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        RLog.info(TAG, "startPayDialog");
        getOrCreatePayController().g(activity, viewParams, iPayCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerNotifyYYPayFailListener(int i, String str, PayCallBackBean payCallBackBean) {
        RLog.info(TAG, "innerNotifyYYPayFailListener onFail reason:" + str + " code:" + i);
        for (int i2 = 0; i2 < this.mYYPayListener.size(); i2++) {
            this.mYYPayListener.get(i2).onFail(i, str, payCallBackBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerNotifyYYPayListener(CurrencyChargeMessage currencyChargeMessage) {
        RLog.info(TAG, "innerNotifyYYPayListener message:" + currencyChargeMessage);
        if (currencyChargeMessage.status == 1) {
            RLog.info(TAG, "innerNotifyYYPayListener onSuccess message:" + currencyChargeMessage);
            for (int i = 0; i < this.mYYPayListener.size(); i++) {
                this.mYYPayListener.get(i).onSuccess(currencyChargeMessage);
            }
            return;
        }
        String str = currencyChargeMessage.message;
        if (str == null) {
            str = "服务订单状态结果失败";
        }
        PayCallBackBean payCallBackBean = new PayCallBackBean();
        payCallBackBean.setOrderId(currencyChargeMessage.orderId);
        payCallBackBean.setAppClientExpand(currencyChargeMessage.appClientExpand);
        innerNotifyYYPayFailListener(currencyChargeMessage.status, str, payCallBackBean);
    }

    private void releaseThirdPartPayApi() {
        RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel + " mThirdPartPayApi:" + this.mThirdPartPayApi);
        IThirdPartPayApi iThirdPartPayApi = this.mThirdPartPayApi;
        if (iThirdPartPayApi != null) {
            iThirdPartPayApi.release();
            this.mThirdPartPayApi = null;
        }
    }

    public synchronized void releaseAllPayFlowView() {
        RLog.info(TAG, "releaseAllPayFlowView() mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
        if (this.mAppContext != null) {
            mgc.a(this.mAppContext);
        } else {
            RLog.error(TAG, "releaseAllPayFlowView error mAppContext null", new Object[0]);
        }
    }

    public synchronized void destroy() {
        RLog.info(TAG, "destroy()");
        String uIKitMapKey = getUIKitMapKey(this.mAppId, this.mUserChannel);
        if (!mPayUIKitMap.containsKey(uIKitMapKey)) {
            RLog.error(TAG, "destroy error mapKey:" + uIKitMapKey + "not exits", new Object[0]);
            return;
        }
        release();
        unregisterPayServiceListener();
        mPayUIKitMap.remove(uIKitMapKey);
        this.mYYPayListener.clear();
        this.mPayFrequencyManager.c();
        RevenueManager.instance().removeRevenueConfig(this.mAppId, this.mUserChannel);
    }

    public void onQQPayResult(int i, String str) {
        RLog.info(TAG, "onQQPayResult code:" + i + " msg:" + str);
        int i2 = this.mAppId;
        if (i2 == 0) {
            RLog.error(TAG, "onQQPayResult error appid is 0", new Object[0]);
            return;
        }
        IAppPayService b2 = cgc.b(i2, this.mUserChannel);
        if (b2 == null) {
            RLog.error(TAG, "onQQPayResult error payService is null", new Object[0]);
        } else {
            b2.onQQPayResult(i, str);
        }
    }

    public void onWxPayResult(int i, String str) {
        RLog.info(TAG, "onWxPayResult code:" + i + " msg:" + str);
        int i2 = this.mAppId;
        if (i2 == 0) {
            RLog.error(TAG, "onWxPayResult error appid is 0", new Object[0]);
            return;
        }
        IAppPayService b2 = cgc.b(i2, this.mUserChannel);
        if (b2 == null) {
            RLog.error(TAG, "onWxPayResult error payService is null", new Object[0]);
        } else {
            b2.onWxPayResult(i, str);
        }
    }
}
