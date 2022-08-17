package tv.athena.revenue.payui;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a2a;
import com.repackage.g2a;
import com.repackage.h0a;
import com.repackage.i0a;
import com.repackage.j0a;
import com.repackage.j1a;
import com.repackage.q2a;
import com.repackage.r0a;
import com.repackage.r1a;
import com.repackage.s0a;
import com.repackage.s1a;
import com.repackage.u0a;
import com.repackage.v0a;
import com.repackage.v1a;
import com.repackage.w0a;
import com.repackage.xz9;
import com.repackage.y1a;
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
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IFeedbackServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payproxy.IWechatSdkServiceProxy;
import com.yy.mobile.framework.revenuesdk.payapi.payservice.PayMethodProxyFactory;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
import tv.athena.revenue.api.MiddleRevenueConfig;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.controller.IYYPayListener;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
@Keep
/* loaded from: classes9.dex */
public class YYPayUIKit extends h0a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "YYPayUiKit";
    public static IFeedbackServiceProxy mFeedbackServiceProxy;
    public static Map<String, YYPayUIKit> mPayUIKitMap;
    public static j0a mTestFunListenerr;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public int mAppId;
    public AppPayServiceListener mAppPayServiceListener;
    public i0a mControllerPayResultListener;
    public r1a mPayFlowLifecycleManager;
    public PayUIKitConfig mPayUIKitConfig;
    public v1a mQueryParamsProvider;
    public IThirdPartPayApi mThirdPartPayApi;
    public int mUserChannel;
    public s0a mYYPayController;
    public List<IYYPayListener> mYYPayListener;

    /* loaded from: classes9.dex */
    public class a implements i0a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayUIKit a;

        public a(YYPayUIKit yYPayUIKit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayUIKit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayUIKit;
        }

        @Override // com.repackage.i0a
        public void a(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, payCallBackBean) == null) {
                this.a.innerNotifyYYPayFailListener(i, str, payCallBackBean);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayUIKit a;

        public b(YYPayUIKit yYPayUIKit) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yYPayUIKit};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yYPayUIKit;
        }

        @Override // com.yy.mobile.framework.revenuesdk.payapi.AppPayServiceListener, com.yy.mobile.framework.revenuesdk.payapi.IAppPayServiceListener
        public void onCurrencyChargeMessage(CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, currencyChargeMessage) == null) {
                super.onCurrencyChargeMessage(currencyChargeMessage);
                this.a.innerNotifyYYPayListener(currencyChargeMessage);
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
        mFeedbackServiceProxy = null;
        H5PayManager.getInstance().setYYPayWebviewActClass(PayCommonWebActivity.class, new j1a());
        v0a.a(new w0a());
    }

    public YYPayUIKit(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mYYPayListener = new ArrayList();
        RLog.info(TAG, "create YYPayUiKit mapKey:" + str);
        preparePayResultListener();
        this.mPayFlowLifecycleManager = new r1a(this);
    }

    public static synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iRLogDelegate) == null) {
            synchronized (YYPayUIKit.class) {
                RLog.info(TAG, "addLogDelegate");
                RevenueManager.instance().addLogDelegate(iRLogDelegate);
            }
        }
    }

    public static synchronized YYPayUIKit createNewKitWithConfigure(int i, int i2, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65541, null, i, i2, payUIKitConfig)) == null) {
            synchronized (YYPayUIKit.class) {
                String uIKitMapKey = getUIKitMapKey(i, i2);
                if (mPayUIKitMap.containsKey(uIKitMapKey)) {
                    RLog.warn(TAG, "createNewKitWithConfigure error mapKey:" + uIKitMapKey + " exits");
                    return mPayUIKitMap.get(uIKitMapKey);
                }
                if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                    y1a.g(payUIKitConfig.revenueConfig.isTestEnv());
                    YYPayUIKit yYPayUIKit = new YYPayUIKit(uIKitMapKey);
                    yYPayUIKit.initYYPayUIKit(i, i2, payUIKitConfig.revenueConfig);
                    yYPayUIKit.mQueryParamsProvider = new a2a(payUIKitConfig.revenueConfig);
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
        return (YYPayUIKit) invokeIIL.objValue;
    }

    private s0a getOrCreatePayController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.mYYPayController == null) {
                this.mYYPayController = new s1a(this.mAppContext, this.mAppId, this.mUserChannel, this.mQueryParamsProvider, this.mControllerPayResultListener, this.mPayUIKitConfig);
            }
            return this.mYYPayController;
        }
        return (s0a) invokeV.objValue;
    }

    public static YYPayUIKit getUIKit(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65543, null, i, i2)) == null) {
            String uIKitMapKey = getUIKitMapKey(i, i2);
            YYPayUIKit yYPayUIKit = mPayUIKitMap.get(uIKitMapKey);
            if (yYPayUIKit == null) {
                RLog.warn(TAG, "getUIKit null mapKey:" + uIKitMapKey + " please createNewKitWithConfigure first");
                return null;
            }
            return yYPayUIKit;
        }
        return (YYPayUIKit) invokeII.objValue;
    }

    public static String getUIKitMapKey(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i, i2)) == null) {
            return i + "-" + i2;
        }
        return (String) invokeII.objValue;
    }

    private void initYYPayUIKit(int i, int i2, MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65545, this, i, i2, middleRevenueConfig) == null) {
            this.mAppId = i;
            this.mUserChannel = i2;
            RLog.info(TAG, "initYYPayUIKit USE_BD_DOMAIN:false");
            RevenueManager.instance().addRevenueConfig(middleRevenueConfig);
            registerPayServiceListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerNotifyYYPayFailListener(int i, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, this, i, str, payCallBackBean) == null) {
            RLog.info(TAG, "innerNotifyYYPayFailListener onFail reason:" + str + " code:" + i);
            for (int i2 = 0; i2 < this.mYYPayListener.size(); i2++) {
                this.mYYPayListener.get(i2).onFail(i, str, payCallBackBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerNotifyYYPayListener(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, currencyChargeMessage) == null) {
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
    }

    private void preparePayResultListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            RLog.info(TAG, "preparePayResultListener");
            this.mControllerPayResultListener = new a(this);
        }
    }

    private void registerPayServiceListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            IAppPayService b2 = g2a.b(this.mAppId, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "registerPayServiceListener error null appPayService", new Object[0]);
                return;
            }
            b bVar = new b(this);
            this.mAppPayServiceListener = bVar;
            b2.addPayListener(bVar);
        }
    }

    public static void setAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, null, iAlipaySdkServiceProxy) == null) {
            RLog.info(TAG, "setAlipaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
        }
    }

    public static void setDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, iDxmSdkServiceProxy) == null) {
            RLog.info(TAG, "setDxmPaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
        }
    }

    public static void setTestFunListener(j0a j0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, j0aVar) == null) {
            mTestFunListenerr = j0aVar;
        }
    }

    public static void setWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, iWechatSdkServiceProxy) == null) {
            RLog.info(TAG, "setWechatSdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
        }
    }

    private void unregisterPayServiceListener() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65554, this) == null) || this.mAppPayServiceListener == null) {
            return;
        }
        IAppPayService b2 = g2a.b(this.mAppId, this.mUserChannel);
        if (b2 != null) {
            b2.removePayListener(this.mAppPayServiceListener);
        }
        this.mAppPayServiceListener = null;
    }

    public void addYYPayListener(IYYPayListener iYYPayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iYYPayListener) == null) {
            RLog.info(TAG, "addYYPayListener listener:" + iYYPayListener);
            if (iYYPayListener == null) {
                RLog.error(TAG, "addGlobalPayListener error listener null", new Object[0]);
            } else {
                this.mYYPayListener.add(iYYPayListener);
            }
        }
    }

    @Override // com.repackage.h0a
    public void cancelAllRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IAppPayService b2 = g2a.b(this.mAppId, this.mUserChannel);
            if (b2 != null) {
                RLog.info(TAG, "cancelAllRequest");
                b2.cancelAllRequest();
                return;
            }
            RLog.error(TAG, "onPayFlowFinish error appPayService null ", new Object[0]);
        }
    }

    public synchronized void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
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
                RevenueManager.instance().removeRevenueConfig(this.mAppId, this.mUserChannel);
            }
        }
    }

    @Override // com.repackage.h0a
    public s0a getCurPayController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mYYPayController : (s0a) invokeV.objValue;
    }

    public synchronized IFeedbackServiceProxy getFeedbackServiceProxy() {
        InterceptResult invokeV;
        IFeedbackServiceProxy iFeedbackServiceProxy;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                RLog.info(TAG, "getFeedbackServiceProxy mFeedbackServiceProxy:" + mFeedbackServiceProxy);
                iFeedbackServiceProxy = mFeedbackServiceProxy;
            }
            return iFeedbackServiceProxy;
        }
        return (IFeedbackServiceProxy) invokeV.objValue;
    }

    public IThirdPartPayApi getOrCreateThirdPartPayApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mThirdPartPayApi == null) {
                this.mThirdPartPayApi = (IThirdPartPayApi) xz9.a.a(IThirdPartPayApi.class, this.mAppId, this.mUserChannel, this.mAppContext, this.mPayUIKitConfig);
            }
            return this.mThirdPartPayApi;
        }
        return (IThirdPartPayApi) invokeV.objValue;
    }

    public PayFlowModel getPayFlowModel(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, payFlowType)) == null) {
            s0a s0aVar = this.mYYPayController;
            if (s0aVar != null) {
                return s0aVar.a(payFlowType);
            }
            return null;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    public PayUIKitConfig getPayUIKitConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mPayUIKitConfig : (PayUIKitConfig) invokeV.objValue;
    }

    public u0a getViewLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mPayFlowLifecycleManager.e() : (u0a) invokeV.objValue;
    }

    public boolean isSupported(@NonNull Activity activity, @NonNull PayType payType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, activity, payType)) == null) {
            IAppPayService b2 = g2a.b(this.mAppId, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "isSupported error payService null", new Object[0]);
                return false;
            }
            return b2.isSupported(activity, payType);
        }
        return invokeLL.booleanValue;
    }

    public void onQQPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048586, this, i, str) == null) {
            RLog.info(TAG, "onQQPayResult code:" + i + " msg:" + str);
            int i2 = this.mAppId;
            if (i2 == 0) {
                RLog.error(TAG, "onQQPayResult error appid is 0", new Object[0]);
                return;
            }
            IAppPayService b2 = g2a.b(i2, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "onQQPayResult error payService is null", new Object[0]);
            } else {
                b2.onQQPayResult(i, str);
            }
        }
    }

    public void onWxPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            RLog.info(TAG, "onWxPayResult code:" + i + " msg:" + str);
            int i2 = this.mAppId;
            if (i2 == 0) {
                RLog.error(TAG, "onWxPayResult error appid is 0", new Object[0]);
                return;
            }
            IAppPayService b2 = g2a.b(i2, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "onWxPayResult error payService is null", new Object[0]);
            } else {
                b2.onWxPayResult(i, str);
            }
        }
    }

    public void refreshWindowParams(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, windowParams) == null) {
            s0a s0aVar = this.mYYPayController;
            if (s0aVar != null) {
                s0aVar.refreshWindow(windowParams);
            }
            RLog.info(TAG, "refreshWindowParams params:" + windowParams + " mYYPayController:" + this.mYYPayController);
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                releaseAllPayFlowView();
                releasePayController();
                if (this.mThirdPartPayApi != null) {
                    this.mThirdPartPayApi.release();
                    this.mThirdPartPayApi = null;
                }
            }
        }
    }

    @Override // com.repackage.h0a
    public synchronized void releaseAllPayFlowView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "releaseAllPayFlowView() mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                if (this.mAppContext != null) {
                    q2a.a(this.mAppContext);
                } else {
                    RLog.error(TAG, "releaseAllPayFlowView error mAppContext null", new Object[0]);
                }
            }
        }
    }

    @Override // com.repackage.h0a
    public synchronized void releasePayController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "releasePayController mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel + " mYYPayController:" + this.mYYPayController);
                if (this.mYYPayController != null) {
                    this.mYYPayController.release();
                    this.mYYPayController = null;
                }
            }
        }
    }

    public void removeYYPayListener(IYYPayListener iYYPayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iYYPayListener) == null) {
            RLog.info(TAG, "removeYYPayListener listener:" + iYYPayListener);
            if (iYYPayListener == null) {
                RLog.error(TAG, "removeGlobalPayListener error listener null", new Object[0]);
            } else {
                this.mYYPayListener.remove(iYYPayListener);
            }
        }
    }

    public synchronized void setFeedbackServiceProxy(IFeedbackServiceProxy iFeedbackServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iFeedbackServiceProxy) == null) {
            synchronized (this) {
                RLog.info(TAG, "setFeedbackServiceProxy proxy:" + iFeedbackServiceProxy);
                mFeedbackServiceProxy = iFeedbackServiceProxy;
            }
        }
    }

    public void startPayChannelDialog(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, activity, bVar, iPayCallback) == null) {
            RLog.info(TAG, "startPayChannelDialog");
            getOrCreatePayController().d(activity, bVar, iPayCallback);
        }
    }

    public void startPayDialog(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, activity, viewParams, iPayCallback) == null) {
            RLog.info(TAG, "startPayDialog");
            getOrCreatePayController().h(activity, viewParams, iPayCallback);
        }
    }

    public void startThirdPartDialogPay(ThirdPartPayDialogParams thirdPartPayDialogParams, r0a r0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, thirdPartPayDialogParams, r0aVar) == null) {
            IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
            if (orCreateThirdPartPayApi != null) {
                orCreateThirdPartPayApi.startPayDialog(thirdPartPayDialogParams, r0aVar);
            } else {
                RLog.error(TAG, "startThirdPartDialogPay error payApi null", new Object[0]);
            }
        }
    }

    public void startThirdPartPay(ThirdPartPayParams thirdPartPayParams, r0a r0aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, thirdPartPayParams, r0aVar) == null) {
            IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
            if (orCreateThirdPartPayApi != null) {
                orCreateThirdPartPayApi.startPlay(thirdPartPayParams, r0aVar);
            } else {
                RLog.error(TAG, "startThirdPartPay error payApi null", new Object[0]);
            }
        }
    }

    public void startWalletActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, activity) == null) {
            RLog.info(TAG, "startWalletActivity");
            getOrCreatePayController().c(activity);
        }
    }

    public void startWalletActivity(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, activity, viewParams) == null) {
            RLog.info(TAG, "startWalletActivity viewParams:" + viewParams);
            getOrCreatePayController().i(activity, viewParams);
        }
    }
}
