package tv.athena.revenue.payui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import j.a.a.e.k.b;
import j.a.a.e.k.c;
import j.a.a.e.k.d;
import j.a.a.e.k.g;
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
/* loaded from: classes2.dex */
public class YYPayUIKit implements c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "YYPayUiKit";
    public static Map<String, YYPayUIKit> mPayUIKitMap;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public int mAppId;
    public AppPayServiceListener mAppPayServiceListener;
    public b mIYYPayController;
    public j.a.a.e.k.a mModelProvider;
    public PayUIKitConfig mPayUIKitConfig;
    public int mUserChannel;
    public List<IYYPayListener> mYYPayListener;

    /* loaded from: classes2.dex */
    public class a extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayUIKit f79489a;

        public a(YYPayUIKit yYPayUIKit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayUIKit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f79489a = yYPayUIKit;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                super.onCurrencyChargeMessage(currencyChargeMessage);
                this.f79489a.notifyYYPayListener(currencyChargeMessage);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1347530224, "Ltv/athena/revenue/payui/YYPayUIKit;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1347530224, "Ltv/athena/revenue/payui/YYPayUIKit;");
                return;
            }
        }
        mPayUIKitMap = new HashMap();
    }

    public YYPayUIKit(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mYYPayListener = new ArrayList();
        RLog.debug(TAG, "YYPayUiKit construct mapKey:" + str);
    }

    public static synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, iRLogDelegate) == null) {
            synchronized (YYPayUIKit.class) {
                RLog.info(TAG, "addLogDelegate");
                RevenueManager.instance().addLogDelegate(iRLogDelegate);
            }
        }
    }

    public static synchronized YYPayUIKit createNewKitWithConfigure(int i2, int i3, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65539, null, i2, i3, payUIKitConfig)) == null) {
            synchronized (YYPayUIKit.class) {
                String uIKitMapKey = getUIKitMapKey(i2, i3);
                if (mPayUIKitMap.containsKey(uIKitMapKey)) {
                    RLog.warn(TAG, "createNewKitWithConfigure error mapKey:" + uIKitMapKey + " exits");
                    return mPayUIKitMap.get(uIKitMapKey);
                }
                if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                    j.a.a.e.l.b.e(payUIKitConfig.revenueConfig.isTestEnv());
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
        return (YYPayUIKit) invokeIIL.objValue;
    }

    private b getPayController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.mIYYPayController == null) {
                this.mIYYPayController = new g(this.mAppId, this.mUserChannel, this.mModelProvider, this);
            }
            return this.mIYYPayController;
        }
        return (b) invokeV.objValue;
    }

    public static YYPayUIKit getUIKit(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) {
            String uIKitMapKey = getUIKitMapKey(i2, i3);
            YYPayUIKit yYPayUIKit = mPayUIKitMap.get(uIKitMapKey);
            if (yYPayUIKit == null) {
                RLog.error(TAG, "getUIKit error payUIKit null mapKey:" + uIKitMapKey, new Object[0]);
                return null;
            }
            RLog.info(TAG, "getUIKit success mapKey:" + uIKitMapKey);
            return yYPayUIKit;
        }
        return (YYPayUIKit) invokeII.objValue;
    }

    public static String getUIKitMapKey(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.BAIDU_LOGO_ID, null, i2, i3)) == null) {
            return i2 + "-" + i3;
        }
        return (String) invokeII.objValue;
    }

    private void initYYPayUIKit(int i2, int i3, MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65543, this, i2, i3, middleRevenueConfig) == null) {
            this.mAppId = i2;
            this.mUserChannel = i3;
            RevenueManager.instance().addRevenueConfig(middleRevenueConfig);
            IAppPayService a2 = j.a.a.e.n.a.a(i2, i3);
            if (a2 != null) {
                a aVar = new a(this);
                this.mAppPayServiceListener = aVar;
                a2.addPayListener(aVar);
                return;
            }
            RLog.error(TAG, "initYYPayUIKit null appPayService", new Object[0]);
        }
    }

    public static void setAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, iAlipaySdkServiceProxy) == null) {
            RLog.info(TAG, "setAlipaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
        }
    }

    public static void setDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, iDxmSdkServiceProxy) == null) {
            RLog.info(TAG, "setDxmPaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
        }
    }

    public static void setWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, iWechatSdkServiceProxy) == null) {
            RLog.info(TAG, "setWechatSdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
        }
    }

    public void addYYPayListener(IYYPayListener iYYPayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iYYPayListener) == null) {
            if (iYYPayListener == null) {
                RLog.error(TAG, "addGlobalPayListener error listener null", new Object[0]);
            } else {
                this.mYYPayListener.add(iYYPayListener);
            }
        }
    }

    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "destroy()");
                String uIKitMapKey = getUIKitMapKey(this.mAppId, this.mUserChannel);
                if (!mPayUIKitMap.containsKey(uIKitMapKey)) {
                    RLog.error(TAG, "destroy error mapKey:" + uIKitMapKey + "not exits", new Object[0]);
                    return;
                }
                release();
                if (this.mAppPayServiceListener != null) {
                    IAppPayService a2 = j.a.a.e.n.a.a(this.mAppId, this.mUserChannel);
                    if (a2 != null) {
                        a2.removePayListener(this.mAppPayServiceListener);
                    }
                    this.mAppPayServiceListener = null;
                }
                mPayUIKitMap.remove(uIKitMapKey);
                this.mYYPayListener.clear();
                RevenueManager.instance().removeRevenueConfig(this.mAppId, this.mUserChannel);
            }
        }
    }

    public H5PayFlowModel getH5PayFlowModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            b bVar = this.mIYYPayController;
            if (bVar != null) {
                return bVar.k();
            }
            return null;
        }
        return (H5PayFlowModel) invokeV.objValue;
    }

    @Override // j.a.a.e.k.c
    public PayUIKitConfig getPayUIKitConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mPayUIKitConfig : (PayUIKitConfig) invokeV.objValue;
    }

    @Override // j.a.a.e.k.c
    public void notifyYYPayFailListener(int i2, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048580, this, i2, str, payCallBackBean) == null) {
            for (int i3 = 0; i3 < this.mYYPayListener.size(); i3++) {
                this.mYYPayListener.get(i3).onFail(i2, str, payCallBackBean);
                RLog.debug(TAG, "notifyGlobalPayListener onFail reason:" + str + " code:" + i2);
            }
        }
    }

    public void notifyYYPayListener(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, currencyChargeMessage) == null) {
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
    }

    public void onWxPayResult(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            int i3 = this.mAppId;
            if (i3 == 0) {
                RLog.error(TAG, "onWxPayResult error appid is 0", new Object[0]);
                return;
            }
            IAppPayService a2 = j.a.a.e.n.a.a(i3, this.mUserChannel);
            if (a2 == null) {
                RLog.error(TAG, "onWxPayResult error payService is null", new Object[0]);
            } else {
                a2.onWxPayResult(i2, str);
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                sendLoginOutBroadcast();
                if (this.mIYYPayController != null) {
                    this.mIYYPayController.clear();
                    this.mIYYPayController = null;
                }
            }
        }
    }

    public void removeYYPayListener(IYYPayListener iYYPayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iYYPayListener) == null) {
            if (iYYPayListener == null) {
                RLog.error(TAG, "removeGlobalPayListener error listener null", new Object[0]);
            } else {
                this.mYYPayListener.remove(iYYPayListener);
            }
        }
    }

    public synchronized void sendLoginOutBroadcast() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "sendLoginOutBroadcast() mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                if (this.mAppContext != null) {
                    LocalBroadcastManager.getInstance(this.mAppContext).sendBroadcast(new Intent("tv.athena.revenue.payui.login_out_action"));
                } else {
                    RLog.error(TAG, "onDestory mAppContext null", new Object[0]);
                }
            }
        }
    }

    public void startPayChannelDialog(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, activity, bVar, iPayCallback) == null) {
            getPayController().e(activity, bVar, iPayCallback);
        }
    }

    public void startPayDialog(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, activity, viewParams, iPayCallback) == null) {
            getPayController().f(activity, viewParams, iPayCallback);
        }
    }

    public void startWalletActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, activity) == null) {
            getPayController().d(activity);
        }
    }

    public void startWalletActivity(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, activity, viewParams) == null) {
            getPayController().g(activity, viewParams);
        }
    }
}
