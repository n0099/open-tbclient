package tv.athena.revenue.payui;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b6a;
import com.baidu.tieba.b7a;
import com.baidu.tieba.d5a;
import com.baidu.tieba.d6a;
import com.baidu.tieba.e6a;
import com.baidu.tieba.f6a;
import com.baidu.tieba.f8a;
import com.baidu.tieba.g7a;
import com.baidu.tieba.h7a;
import com.baidu.tieba.k7a;
import com.baidu.tieba.m7a;
import com.baidu.tieba.o5a;
import com.baidu.tieba.p5a;
import com.baidu.tieba.q5a;
import com.baidu.tieba.v7a;
import com.baidu.tieba.w6a;
import com.baidu.tieba.z5a;
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
import com.yy.mobile.framework.revenuesdk.payapi.IPaySignCallback;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PaySignInfo;
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
import tv.athena.revenue.api.pay.params.PayFlowType;
import tv.athena.revenue.payui.activity.PayCommonWebActivity;
import tv.athena.revenue.payui.controller.IYYPayListener;
import tv.athena.revenue.payui.model.PayFlowModel;
import tv.athena.revenue.payui.model.PayUIKitConfig;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.WindowParams;
@Keep
/* loaded from: classes9.dex */
public class YYPayUIKit extends o5a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "YYPayUiKit";
    public static IFeedbackServiceProxy mFeedbackServiceProxy;
    public static Map<String, YYPayUIKit> mPayUIKitMap;
    public static q5a mTestFunListenerr;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public int mAppId;
    public AppPayServiceListener mAppPayServiceListener;
    public p5a mControllerPayResultListener;
    public g7a mPayFlowLifecycleManager;
    public b7a mPayFrequencyManager;
    public PayUIKitConfig mPayUIKitConfig;
    public IThirdPartPayApi mThirdPartPayApi;
    public int mUserChannel;
    public b6a mYYPayController;
    public List<IYYPayListener> mYYPayListener;

    /* loaded from: classes9.dex */
    public class a implements p5a {
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

        @Override // com.baidu.tieba.p5a
        public void a(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeILL(1048576, this, i, str, payCallBackBean) != null) {
                return;
            }
            this.a.innerNotifyYYPayFailListener(i, str, payCallBackBean);
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
        H5PayManager.getInstance().setYYPayWebviewActClass(PayCommonWebActivity.class, new w6a());
        e6a.a(new f6a());
    }

    private void releaseThirdPartPayApi() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel + " mThirdPartPayApi:" + this.mThirdPartPayApi);
            IThirdPartPayApi iThirdPartPayApi = this.mThirdPartPayApi;
            if (iThirdPartPayApi != null) {
                iThirdPartPayApi.release();
                this.mThirdPartPayApi = null;
            }
        }
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

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                releaseAllPayFlowView();
                releasePayController();
                releaseThirdPartPayApi();
            }
        }
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
        this.mPayFlowLifecycleManager = new g7a(this);
        this.mPayFrequencyManager = new b7a();
    }

    public static String getUIKitMapKey(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65544, null, i, i2)) == null) {
            return i + "-" + i2;
        }
        return (String) invokeII.objValue;
    }

    public boolean isSupported(@NonNull Activity activity, @NonNull PayType payType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, activity, payType)) == null) {
            IAppPayService b2 = v7a.b(this.mAppId, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "isSupported error payService null", new Object[0]);
                return false;
            }
            return b2.isSupported(activity, payType);
        }
        return invokeLL.booleanValue;
    }

    public void startThirdPartDialogPay(ThirdPartPayDialogParams thirdPartPayDialogParams, z5a z5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, thirdPartPayDialogParams, z5aVar) == null) {
            IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
            if (orCreateThirdPartPayApi != null) {
                orCreateThirdPartPayApi.startPayDialog(thirdPartPayDialogParams, z5aVar);
            } else {
                RLog.error(TAG, "startThirdPartDialogPay error payApi null", new Object[0]);
            }
        }
    }

    public void startThirdPartDialogPayV2(ThirdPartPayDialogParams thirdPartPayDialogParams, z5a z5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, thirdPartPayDialogParams, z5aVar) == null) {
            IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
            if (orCreateThirdPartPayApi != null) {
                orCreateThirdPartPayApi.startPayDialogV2(thirdPartPayDialogParams, z5aVar);
            } else {
                RLog.error(TAG, "startThirdPartDialogPayV2 error payApi null", new Object[0]);
            }
        }
    }

    public void startThirdPartPay(ThirdPartPayParams thirdPartPayParams, z5a z5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, thirdPartPayParams, z5aVar) == null) {
            IThirdPartPayApi orCreateThirdPartPayApi = getOrCreateThirdPartPayApi();
            if (orCreateThirdPartPayApi != null) {
                orCreateThirdPartPayApi.startPlay(thirdPartPayParams, z5aVar);
            } else {
                RLog.error(TAG, "startThirdPartPay error payApi null", new Object[0]);
            }
        }
    }

    public void startWalletActivity(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, activity, viewParams) == null) {
            RLog.info(TAG, "startWalletActivity viewParams:" + viewParams);
            getOrCreatePayController().g(activity, viewParams);
        }
    }

    public void startPayChannelDialog(Activity activity, k7a k7aVar, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048597, this, activity, k7aVar, bVar, iPayCallback) == null) {
            RLog.info(TAG, "startPayChannelDialog");
            getOrCreatePayController().b(activity, bVar, k7aVar, iPayCallback);
        }
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

    public static void setAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, null, iAlipaySdkServiceProxy) == null) {
            RLog.info(TAG, "setAlipaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
        }
    }

    public static void setDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, iDxmSdkServiceProxy) == null) {
            RLog.info(TAG, "setDxmPaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
        }
    }

    public static void setTestFunListener(q5a q5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, q5aVar) == null) {
            mTestFunListenerr = q5aVar;
        }
    }

    public static void setWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, iWechatSdkServiceProxy) == null) {
            RLog.info(TAG, "setWechatSdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
        }
    }

    public PayFlowModel getPayFlowModel(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, payFlowType)) == null) {
            b6a b6aVar = this.mYYPayController;
            if (b6aVar != null) {
                return b6aVar.h(payFlowType);
            }
            return null;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    public synchronized void setFeedbackServiceProxy(IFeedbackServiceProxy iFeedbackServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, iFeedbackServiceProxy) == null) {
            synchronized (this) {
                RLog.info(TAG, "setFeedbackServiceProxy proxy:" + iFeedbackServiceProxy);
                mFeedbackServiceProxy = iFeedbackServiceProxy;
            }
        }
    }

    public void setIsPayFrequency(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            RLog.info(TAG, "setIsPayFrequency isPayFrequency:" + z);
            this.mPayFrequencyManager.e(z);
        }
    }

    public void startWalletActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, activity) == null) {
            RLog.info(TAG, "startWalletActivity");
            getOrCreatePayController().c(activity);
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
                    m7a.g(payUIKitConfig.revenueConfig.isTestEnv());
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
        return (YYPayUIKit) invokeIIL.objValue;
    }

    private b6a getOrCreatePayController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            if (this.mYYPayController == null) {
                this.mYYPayController = new h7a(this.mAppContext, this.mAppId, this.mUserChannel, this.mControllerPayResultListener, this.mPayUIKitConfig);
            }
            return this.mYYPayController;
        }
        return (b6a) invokeV.objValue;
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
            IAppPayService b2 = v7a.b(this.mAppId, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "registerPayServiceListener error null appPayService", new Object[0]);
                return;
            }
            b bVar = new b(this);
            this.mAppPayServiceListener = bVar;
            b2.addPayListener(bVar);
        }
    }

    private void unregisterPayServiceListener() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65555, this) == null) && this.mAppPayServiceListener != null) {
            IAppPayService b2 = v7a.b(this.mAppId, this.mUserChannel);
            if (b2 != null) {
                b2.removePayListener(this.mAppPayServiceListener);
            }
            this.mAppPayServiceListener = null;
        }
    }

    @Override // com.baidu.tieba.o5a
    public void cancelAllRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            IAppPayService b2 = v7a.b(this.mAppId, this.mUserChannel);
            if (b2 != null) {
                RLog.info(TAG, "cancelAllRequest");
                b2.cancelAllRequest();
                return;
            }
            RLog.error(TAG, "onPayFlowFinish error appPayService null ", new Object[0]);
        }
    }

    @Override // com.baidu.tieba.o5a
    public b6a getCurPayController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mYYPayController;
        }
        return (b6a) invokeV.objValue;
    }

    public IThirdPartPayApi getOrCreateThirdPartPayApi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mThirdPartPayApi == null) {
                this.mThirdPartPayApi = (IThirdPartPayApi) d5a.a.a(IThirdPartPayApi.class, this.mAppId, this.mUserChannel, this.mAppContext, this.mPayUIKitConfig, this);
            }
            return this.mThirdPartPayApi;
        }
        return (IThirdPartPayApi) invokeV.objValue;
    }

    public PayUIKitConfig getPayUIKitConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mPayUIKitConfig;
        }
        return (PayUIKitConfig) invokeV.objValue;
    }

    public d6a getViewLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mPayFlowLifecycleManager.e();
        }
        return (d6a) invokeV.objValue;
    }

    public boolean isPayFrequency() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mPayFrequencyManager.d();
        }
        return invokeV.booleanValue;
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

    public void signPay(Activity activity, PaySignInfo paySignInfo, IPaySignCallback iPaySignCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, activity, paySignInfo, iPaySignCallback) == null) {
            IAppPayService b2 = v7a.b(this.mAppId, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "isSupported error payService null", new Object[0]);
            } else {
                b2.signAliPay(activity, paySignInfo, iPaySignCallback);
            }
        }
    }

    public void startPayDialog(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048598, this, activity, viewParams, iPayCallback) == null) {
            RLog.info(TAG, "startPayDialog");
            getOrCreatePayController().f(activity, viewParams, iPayCallback);
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

    public void refreshWindowParams(WindowParams windowParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, windowParams) == null) {
            b6a b6aVar = this.mYYPayController;
            if (b6aVar != null) {
                b6aVar.refreshWindow(windowParams);
            }
            RLog.info(TAG, "refreshWindowParams params:" + windowParams + " mYYPayController:" + this.mYYPayController);
        }
    }

    public void removeYYPayListener(IYYPayListener iYYPayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, iYYPayListener) == null) {
            RLog.info(TAG, "removeYYPayListener listener:" + iYYPayListener);
            if (iYYPayListener == null) {
                RLog.error(TAG, "removeGlobalPayListener error listener null", new Object[0]);
            } else {
                this.mYYPayListener.remove(iYYPayListener);
            }
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
                this.mPayFrequencyManager.c();
                RevenueManager.instance().removeRevenueConfig(this.mAppId, this.mUserChannel);
            }
        }
    }

    public void onQQPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048587, this, i, str) == null) {
            RLog.info(TAG, "onQQPayResult code:" + i + " msg:" + str);
            int i2 = this.mAppId;
            if (i2 == 0) {
                RLog.error(TAG, "onQQPayResult error appid is 0", new Object[0]);
                return;
            }
            IAppPayService b2 = v7a.b(i2, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "onQQPayResult error payService is null", new Object[0]);
            } else {
                b2.onQQPayResult(i, str);
            }
        }
    }

    public void onWxPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            RLog.info(TAG, "onWxPayResult code:" + i + " msg:" + str);
            int i2 = this.mAppId;
            if (i2 == 0) {
                RLog.error(TAG, "onWxPayResult error appid is 0", new Object[0]);
                return;
            }
            IAppPayService b2 = v7a.b(i2, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "onWxPayResult error payService is null", new Object[0]);
            } else {
                b2.onWxPayResult(i, str);
            }
        }
    }

    @Override // com.baidu.tieba.o5a
    public synchronized void releaseAllPayFlowView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "releaseAllPayFlowView() mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                if (this.mAppContext != null) {
                    f8a.a(this.mAppContext);
                } else {
                    RLog.error(TAG, "releaseAllPayFlowView error mAppContext null", new Object[0]);
                }
            }
        }
    }

    @Override // com.baidu.tieba.o5a
    public synchronized void releasePayController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "releasePayController mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel + " mYYPayController:" + this.mYYPayController);
                if (this.mYYPayController != null) {
                    this.mYYPayController.release();
                    this.mYYPayController = null;
                }
            }
        }
    }
}
