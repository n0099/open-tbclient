package tv.athena.revenue.payui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.IRLogDelegate;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IAlipaySdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IDxmSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.PayMethodProxyFactory;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import i.a.a.e.k.b;
import i.a.a.e.k.c;
import i.a.a.e.k.d;
import i.a.a.e.k.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.controller.IYYPayListener;
import tv.athena.revenue.payui.model.H5PayFlowModel;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
@Keep
/* loaded from: classes8.dex */
public class YYPayUIKit implements c {
    public static final String TAG = "YYPayUiKit";
    public static Map<String, YYPayUIKit> mPayUIKitMap = new HashMap();
    public Context mAppContext;
    public int mAppId;
    public AppPayServiceListener mAppPayServiceListener;
    public b mIYYPayController;
    public i.a.a.e.k.a mModelProvider;
    public PayUIKitConfig mPayUIKitConfig;
    public int mUserChannel;
    public List<IYYPayListener> mYYPayListener = new ArrayList();

    /* loaded from: classes8.dex */
    public class a extends AppPayServiceListener {
        public a() {
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            super.onCurrencyChargeMessage(currencyChargeMessage);
            YYPayUIKit.this.notifyYYPayListener(currencyChargeMessage);
        }
    }

    public YYPayUIKit(String str) {
        RLog.debug(TAG, "YYPayUiKit construct mapKey:" + str);
    }

    public static synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        synchronized (YYPayUIKit.class) {
            RLog.info(TAG, "addLogDelegate");
            RevenueManager.instance().addLogDelegate(iRLogDelegate);
        }
    }

    public static synchronized YYPayUIKit createNewKitWithConfigure(int i2, int i3, PayUIKitConfig payUIKitConfig) {
        synchronized (YYPayUIKit.class) {
            String uIKitMapKey = getUIKitMapKey(i2, i3);
            if (mPayUIKitMap.containsKey(uIKitMapKey)) {
                RLog.warn(TAG, "createNewKitWithConfigure error mapKey:" + uIKitMapKey + " exits");
                return mPayUIKitMap.get(uIKitMapKey);
            }
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                i.a.a.e.l.b.e(payUIKitConfig.revenueConfig.isTestEnv());
                YYPayUIKit yYPayUIKit = new YYPayUIKit(uIKitMapKey);
                yYPayUIKit.initYYPayUIKit(i2, i3, payUIKitConfig.revenueConfig);
                yYPayUIKit.mModelProvider = new d(payUIKitConfig.revenueConfig);
                yYPayUIKit.mPayUIKitConfig = payUIKitConfig;
                yYPayUIKit.mAppContext = payUIKitConfig.revenueConfig.getAppContext();
                mPayUIKitMap.put(uIKitMapKey, yYPayUIKit);
                RLog.info(TAG, "createNewKitWithConfigure success mapKey:" + uIKitMapKey + " config:" + payUIKitConfig.revenueConfig.toString());
                H5PayManager.getInstance().setYYPayWebviewActClass(PayCommonWebActivity.class);
                return yYPayUIKit;
            }
            RLog.error(TAG, "createNewKitWithConfigure error revenueConfig null", new Object[0]);
            return null;
        }
    }

    private b getPayController() {
        if (this.mIYYPayController == null) {
            this.mIYYPayController = new g(this.mAppId, this.mUserChannel, this.mModelProvider, this);
        }
        return this.mIYYPayController;
    }

    public static YYPayUIKit getUIKit(int i2, int i3) {
        String uIKitMapKey = getUIKitMapKey(i2, i3);
        YYPayUIKit yYPayUIKit = mPayUIKitMap.get(uIKitMapKey);
        if (yYPayUIKit == null) {
            RLog.error(TAG, "getUIKit error payUIKit null mapKey:" + uIKitMapKey, new Object[0]);
            return null;
        }
        RLog.info(TAG, "getUIKit success mapKey:" + uIKitMapKey);
        return yYPayUIKit;
    }

    public static String getUIKitMapKey(int i2, int i3) {
        return i2 + "-" + i3;
    }

    private void initYYPayUIKit(int i2, int i3, MiddleRevenueConfig middleRevenueConfig) {
        this.mAppId = i2;
        this.mUserChannel = i3;
        RevenueManager.instance().addRevenueConfig(middleRevenueConfig);
        IAppPayService a2 = i.a.a.e.n.a.a(i2, i3);
        if (a2 != null) {
            a aVar = new a();
            this.mAppPayServiceListener = aVar;
            a2.addPayListener(aVar);
            return;
        }
        RLog.error(TAG, "initYYPayUIKit null appPayService", new Object[0]);
    }

    public static void setAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        RLog.info(TAG, "setAlipaySdkProxy");
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
    }

    public static void setDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        RLog.info(TAG, "setDxmPaySdkProxy");
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
    }

    public static void setWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        RLog.info(TAG, "setWechatSdkProxy");
        PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
    }

    public void addYYPayListener(IYYPayListener iYYPayListener) {
        if (iYYPayListener == null) {
            RLog.error(TAG, "addGlobalPayListener error listener null", new Object[0]);
        } else {
            this.mYYPayListener.add(iYYPayListener);
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
        if (this.mAppPayServiceListener != null) {
            IAppPayService a2 = i.a.a.e.n.a.a(this.mAppId, this.mUserChannel);
            if (a2 != null) {
                a2.removePayListener(this.mAppPayServiceListener);
            }
            this.mAppPayServiceListener = null;
        }
        mPayUIKitMap.remove(uIKitMapKey);
        this.mYYPayListener.clear();
        RevenueManager.instance().removeRevenueConfig(this.mAppId, this.mUserChannel);
    }

    public H5PayFlowModel getH5PayFlowModel() {
        b bVar = this.mIYYPayController;
        if (bVar != null) {
            return bVar.k();
        }
        return null;
    }

    @Override // i.a.a.e.k.c
    public PayUIKitConfig getPayUIKitConfig() {
        return this.mPayUIKitConfig;
    }

    @Override // i.a.a.e.k.c
    public void notifyYYPayFailListener(int i2, String str, PayCallBackBean payCallBackBean) {
        for (int i3 = 0; i3 < this.mYYPayListener.size(); i3++) {
            this.mYYPayListener.get(i3).onFail(i2, str, payCallBackBean);
            RLog.debug(TAG, "notifyGlobalPayListener onFail reason:" + str + " code:" + i2);
        }
    }

    public void notifyYYPayListener(CurrencyChargeMessage currencyChargeMessage) {
        if (currencyChargeMessage.status == 1) {
            for (int i2 = 0; i2 < this.mYYPayListener.size(); i2++) {
                this.mYYPayListener.get(i2).onSuccess(currencyChargeMessage);
                RLog.debug(TAG, "notifyGlobalPayListener onSuccess message:" + currencyChargeMessage);
            }
            return;
        }
        String str = currencyChargeMessage.timeout ? "查询订单次数已用完" : "服务订单状态结果失败";
        PayCallBackBean payCallBackBean = new PayCallBackBean();
        payCallBackBean.setOrderId(currencyChargeMessage.orderId);
        payCallBackBean.setAppClientExpand(currencyChargeMessage.appClientExpand);
        notifyYYPayFailListener(currencyChargeMessage.status, str, payCallBackBean);
    }

    public void onWxPayResult(int i2, String str) {
        int i3 = this.mAppId;
        if (i3 == 0) {
            RLog.error(TAG, "onWxPayResult error appid is 0", new Object[0]);
            return;
        }
        IAppPayService a2 = i.a.a.e.n.a.a(i3, this.mUserChannel);
        if (a2 == null) {
            RLog.error(TAG, "onWxPayResult error payService is null", new Object[0]);
        } else {
            a2.onWxPayResult(i2, str);
        }
    }

    public synchronized void release() {
        RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
        sendLoginOutBroadcast();
        if (this.mIYYPayController != null) {
            this.mIYYPayController.clear();
            this.mIYYPayController = null;
        }
    }

    public void removeYYPayListener(IYYPayListener iYYPayListener) {
        if (iYYPayListener == null) {
            RLog.error(TAG, "removeGlobalPayListener error listener null", new Object[0]);
        } else {
            this.mYYPayListener.remove(iYYPayListener);
        }
    }

    public synchronized void sendLoginOutBroadcast() {
        RLog.info(TAG, "sendLoginOutBroadcast() mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
        if (this.mAppContext != null) {
            LocalBroadcastManager.getInstance(this.mAppContext).sendBroadcast(new Intent("tv.athena.revenue.payui.login_out_action"));
        } else {
            RLog.error(TAG, "onDestory mAppContext null", new Object[0]);
        }
    }

    public void startPayChannelDialog(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        getPayController().e(activity, bVar, iPayCallback);
    }

    public void startPayDialog(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        getPayController().f(activity, viewParams, iPayCallback);
    }

    public void startWalletActivity(Activity activity) {
        getPayController().d(activity);
    }

    public void startWalletActivity(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        getPayController().g(activity, viewParams);
    }
}
