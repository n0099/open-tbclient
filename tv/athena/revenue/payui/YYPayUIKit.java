package tv.athena.revenue.payui;

import android.app.Activity;
import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import d.r.b.a.a.f.d.d;
import d.r.b.a.a.i.d.e;
import d.r.b.a.a.i.d.h;
import i.a.a.e.i.b;
import i.a.a.e.i.c;
import i.a.a.e.i.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.view.IYYPayAmountView;
@Keep
/* loaded from: classes8.dex */
public class YYPayUIKit {
    public static final String TAG = "YYPayUiKit";
    public static Map<String, YYPayUIKit> mPayUIKitMap = new HashMap();
    public int mAppId;
    public d.r.b.a.a.i.a mAppPayServiceListener;
    public c mIYYPayController;
    public i.a.a.e.i.a mModelProvider;
    public PayUIKitConfig mPayUIKitConfig;
    public int mUserChannel;
    public List<b> mYYPayListenerList = new ArrayList();

    /* loaded from: classes8.dex */
    public class a extends d.r.b.a.a.i.a {
        public a() {
        }

        @Override // d.r.b.a.a.i.a, d.r.b.a.a.i.b
        public void a(CurrencyChargeMessage currencyChargeMessage) {
            super.a(currencyChargeMessage);
            YYPayUIKit.this.notifyCurrencyChargeMessage(currencyChargeMessage);
        }
    }

    public YYPayUIKit(String str) {
        d.b(TAG, "YYPayUiKit construct mapKey:" + str);
    }

    public static synchronized YYPayUIKit createNewKitWithConfigure(int i2, int i3, PayUIKitConfig payUIKitConfig) {
        synchronized (YYPayUIKit.class) {
            String uIKitMapKey = getUIKitMapKey(i2, i3);
            if (mPayUIKitMap.containsKey(uIKitMapKey)) {
                d.h(TAG, "createNewKitWithConfigure error mapKey:" + uIKitMapKey + " exits");
                return mPayUIKitMap.get(uIKitMapKey);
            }
            if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                i.a.a.e.j.c.d(payUIKitConfig.revenueConfig.isTestEnv());
                YYPayUIKit yYPayUIKit = new YYPayUIKit(uIKitMapKey);
                yYPayUIKit.initYYPayUIKit(i2, i3, payUIKitConfig.revenueConfig);
                yYPayUIKit.setModelProvider(new i.a.a.e.i.d(payUIKitConfig.revenueConfig));
                yYPayUIKit.setPayUIKitConfig(payUIKitConfig);
                mPayUIKitMap.put(uIKitMapKey, yYPayUIKit);
                d.f(TAG, "createNewKitWithConfigure success mapKey:" + uIKitMapKey);
                return yYPayUIKit;
            }
            d.e(TAG, "createNewKitWithConfigure error revenueConfig null", new Object[0]);
            return null;
        }
    }

    private c getPayController() {
        if (this.mIYYPayController == null) {
            this.mIYYPayController = new f(this.mAppId, this.mUserChannel, this.mModelProvider, this.mPayUIKitConfig);
        }
        return this.mIYYPayController;
    }

    public static YYPayUIKit getUIKit(int i2, int i3) {
        String uIKitMapKey = getUIKitMapKey(i2, i3);
        YYPayUIKit yYPayUIKit = mPayUIKitMap.get(uIKitMapKey);
        if (yYPayUIKit == null) {
            d.e(TAG, "getUIKit error payUIKit null mapKey:" + uIKitMapKey, new Object[0]);
            return null;
        }
        d.f(TAG, "getUIKit success mapKey:" + uIKitMapKey);
        return yYPayUIKit;
    }

    public static String getUIKitMapKey(int i2, int i3) {
        return i2 + "-" + i3;
    }

    private void initYYPayUIKit(int i2, int i3, MiddleRevenueConfig middleRevenueConfig) {
        this.mAppId = i2;
        this.mUserChannel = i3;
        RevenueManager.instance().addRevenueConfig(middleRevenueConfig);
        IAppPayService a2 = i.a.a.e.l.a.a(i2, i3);
        if (a2 != null) {
            a aVar = new a();
            this.mAppPayServiceListener = aVar;
            a2.addPayListener(aVar);
            return;
        }
        d.e(TAG, "initYYPayUIKit null appPayService", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
        for (int i2 = 0; i2 < this.mYYPayListenerList.size(); i2++) {
            boolean a2 = this.mYYPayListenerList.get(i2).a(currencyChargeMessage);
            d.b(TAG, "notifyCurrencyChargeMessage handleMessage:" + a2);
        }
    }

    public static void setAlipaySdkProxy(d.r.b.a.a.i.d.c cVar) {
        d.b(TAG, "setAlipaySdkProxy");
        d.r.b.a.a.i.e.c.d().a(PayType.ALI_PAY, cVar);
    }

    public static void setDxmPaySdkProxy(e eVar) {
        d.b(TAG, "setDxmPaySdkProxy");
        d.r.b.a.a.i.e.c.d().a(PayType.DXM_PAY, eVar);
    }

    private void setModelProvider(i.a.a.e.i.a aVar) {
        this.mModelProvider = aVar;
    }

    private void setPayUIKitConfig(PayUIKitConfig payUIKitConfig) {
        this.mPayUIKitConfig = payUIKitConfig;
    }

    public static void setWechatSdkProxy(h hVar) {
        d.b(TAG, "setWechatSdkProxy");
        d.r.b.a.a.i.e.c.d().a(PayType.WECHAT_PAY, hVar);
    }

    public void addYYPayListener(b bVar) {
        if (bVar == null) {
            d.e(TAG, "addYYPayListener error listener null", new Object[0]);
        } else {
            this.mYYPayListenerList.add(bVar);
        }
    }

    public synchronized void destroy() {
        String uIKitMapKey = getUIKitMapKey(this.mAppId, this.mUserChannel);
        if (!mPayUIKitMap.containsKey(uIKitMapKey)) {
            d.e(TAG, "destroy error mapKey:" + uIKitMapKey + "not exits", new Object[0]);
            return;
        }
        release();
        if (this.mAppPayServiceListener != null) {
            IAppPayService a2 = i.a.a.e.l.a.a(this.mAppId, this.mUserChannel);
            if (a2 != null) {
                a2.removePayListener(this.mAppPayServiceListener);
            }
            this.mAppPayServiceListener = null;
        }
        mPayUIKitMap.remove(uIKitMapKey);
        RevenueManager.instance().removeRevenueConfig(this.mAppId, this.mUserChannel);
    }

    public PayUIKitConfig getPayUIKitConfig() {
        return this.mPayUIKitConfig;
    }

    public void onWxPayResult(int i2, String str) {
        int i3 = this.mAppId;
        if (i3 == 0) {
            d.e(TAG, "onWxPayResult error appid is 0", new Object[0]);
            return;
        }
        IAppPayService a2 = i.a.a.e.l.a.a(i3, this.mUserChannel);
        if (a2 == null) {
            d.e(TAG, "onWxPayResult error payService is null", new Object[0]);
        } else {
            a2.onWxPayResult(i2, str);
        }
    }

    public synchronized void release() {
        d.b(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
        if (this.mIYYPayController != null) {
            this.mIYYPayController.clear();
            this.mIYYPayController = null;
        }
    }

    public void removeYYPayListener(b bVar) {
        if (bVar == null) {
            d.e(TAG, "removeYYPayListener error listener null", new Object[0]);
        } else {
            this.mYYPayListenerList.remove(bVar);
        }
    }

    public void startPayDialog(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback iPayCallback) {
        getPayController().e(activity, viewParams, iPayCallback);
    }

    public void startWalletActivity(Activity activity) {
        getPayController().d(activity);
    }
}
