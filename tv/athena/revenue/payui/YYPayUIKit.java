package tv.athena.revenue.payui;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b6a;
import com.repackage.c5a;
import com.repackage.k6a;
import com.repackage.m4a;
import com.repackage.n4a;
import com.repackage.q5a;
import com.repackage.s4a;
import com.repackage.t5a;
import com.repackage.v4a;
import com.repackage.v5a;
import com.repackage.w4a;
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
import tv.athena.revenue.payui.view.IYYPayAmountView;
import tv.athena.revenue.payui.view.IYYPayWayView;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
@Keep
/* loaded from: classes8.dex */
public class YYPayUIKit {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "YYPayUiKit";
    public static Map<String, YYPayUIKit> mPayUIKitMap;
    public static n4a mTestFunListenerr;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mAppContext;
    public int mAppId;
    public AppPayServiceListener mAppPayServiceListener;
    public s4a mPayFlowLifecycle;
    public PayUIKitConfig mPayUIKitConfig;
    public q5a mQueryParamsProvider;
    public int mUserChannel;
    public v4a mYYPayController;
    public List<IYYPayListener> mYYPayListener;
    public w4a mYYPayResultListener;

    /* loaded from: classes8.dex */
    public class a implements s4a {
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

        @Override // com.repackage.s4a
        public void a(PayFlowType payFlowType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, payFlowType) == null) {
                this.a.notifyPayFlowWork(payFlowType);
            }
        }

        @Override // com.repackage.s4a
        public void b(String str, PayFlowType payFlowType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, payFlowType) == null) {
                this.a.activityDestroyRecord(str, payFlowType);
            }
        }

        @Override // com.repackage.s4a
        public void c(String str, PayFlowType payFlowType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, payFlowType) == null) {
                this.a.activityVisitRecord(str, payFlowType);
            }
        }

        @Override // com.repackage.s4a
        public void d(PayFlowType payFlowType, PayDialogType payDialogType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, payFlowType, payDialogType) == null) {
                this.a.notifyPayDialogTypeChange(payFlowType, payDialogType);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements w4a {
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

        @Override // com.repackage.w4a
        public void a(int i, String str, PayCallBackBean payCallBackBean) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, payCallBackBean) == null) {
                this.a.innerNotifyYYPayFailListener(i, str, payCallBackBean);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends AppPayServiceListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ YYPayUIKit a;

        public c(YYPayUIKit yYPayUIKit) {
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
        H5PayManager.getInstance().setYYPayWebviewActClass(PayCommonWebActivity.class, new m4a());
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
        preparePayFlowLifecycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void activityDestroyRecord(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, this, str, payFlowType) == null) {
            synchronized (this) {
                RLog.info(TAG, "activityDestroyRecord name:" + str + " payFlowType:" + payFlowType.name() + " mYYPayController:" + this.mYYPayController);
                if (this.mYYPayController != null) {
                    this.mYYPayController.j(str, payFlowType);
                }
                tryNotifyPayFlowRelease(payFlowType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void activityVisitRecord(String str, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, this, str, payFlowType) == null) {
            synchronized (this) {
                RLog.info(TAG, "activityVisitRecord name:" + str + " payFlowType:" + payFlowType.name() + " mYYPayController:" + this.mYYPayController);
                if (this.mYYPayController != null) {
                    this.mYYPayController.f(str, payFlowType);
                }
            }
        }
    }

    public static synchronized void addLogDelegate(IRLogDelegate iRLogDelegate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, iRLogDelegate) == null) {
            synchronized (YYPayUIKit.class) {
                RLog.info(TAG, "addLogDelegate");
                RevenueManager.instance().addLogDelegate(iRLogDelegate);
            }
        }
    }

    public static synchronized YYPayUIKit createNewKitWithConfigure(int i, int i2, PayUIKitConfig payUIKitConfig) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65547, null, i, i2, payUIKitConfig)) == null) {
            synchronized (YYPayUIKit.class) {
                String uIKitMapKey = getUIKitMapKey(i, i2);
                if (mPayUIKitMap.containsKey(uIKitMapKey)) {
                    RLog.warn(TAG, "createNewKitWithConfigure error mapKey:" + uIKitMapKey + " exits");
                    return mPayUIKitMap.get(uIKitMapKey);
                }
                if (payUIKitConfig != null && payUIKitConfig.revenueConfig != null) {
                    t5a.e(payUIKitConfig.revenueConfig.isTestEnv());
                    YYPayUIKit yYPayUIKit = new YYPayUIKit(uIKitMapKey);
                    yYPayUIKit.initYYPayUIKit(i, i2, payUIKitConfig.revenueConfig);
                    yYPayUIKit.mQueryParamsProvider = new v5a(payUIKitConfig.revenueConfig);
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

    private v4a getPayController() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            if (this.mYYPayController == null) {
                this.mYYPayController = new c5a(this.mAppContext, this.mAppId, this.mUserChannel, this.mQueryParamsProvider, this.mYYPayResultListener, this.mPayUIKitConfig);
            }
            return this.mYYPayController;
        }
        return (v4a) invokeV.objValue;
    }

    public static YYPayUIKit getUIKit(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65549, null, i, i2)) == null) {
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
        if (interceptable == null || (invokeII = interceptable.invokeII(65550, null, i, i2)) == null) {
            return i + "-" + i2;
        }
        return (String) invokeII.objValue;
    }

    private void initYYPayUIKit(int i, int i2, MiddleRevenueConfig middleRevenueConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65551, this, i, i2, middleRevenueConfig) == null) {
            this.mAppId = i;
            this.mUserChannel = i2;
            RevenueManager.instance().addRevenueConfig(middleRevenueConfig);
            registerPayServiceListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerNotifyYYPayFailListener(int i, String str, PayCallBackBean payCallBackBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65552, this, i, str, payCallBackBean) == null) {
            RLog.info(TAG, "innerNotifyYYPayFailListener onFail reason:" + str + " code:" + i);
            for (int i2 = 0; i2 < this.mYYPayListener.size(); i2++) {
                this.mYYPayListener.get(i2).onFail(i, str, payCallBackBean);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void innerNotifyYYPayListener(CurrencyChargeMessage currencyChargeMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, currencyChargeMessage) == null) {
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

    private synchronized void innerReleasePayController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "innerReleasePayController mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel + " mYYPayController:" + this.mYYPayController);
                if (this.mYYPayController != null) {
                    this.mYYPayController.release();
                    this.mYYPayController = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPayDialogTypeChange(PayFlowType payFlowType, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, this, payFlowType, payDialogType) == null) {
            RLog.info(TAG, "notifyPayDialogTypeChange payFlowType:" + payFlowType.name() + " payDialogType:" + payDialogType + " mYYPayController:" + this.mYYPayController);
            if (payDialogType == PayDialogType.PAY_NONE_DIALOG) {
                tryNotifyPayFlowRelease(payFlowType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPayFlowWork(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, payFlowType) == null) {
            RLog.info(TAG, "notifyPayFlowWork payFlowType:" + payFlowType.name() + " mYYPayController:" + this.mYYPayController);
        }
    }

    private void preparePayFlowLifecycle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            RLog.info(TAG, "preparePayFlowLifecycle");
            this.mPayFlowLifecycle = new a(this);
        }
    }

    private void preparePayResultListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            RLog.info(TAG, "preparePayResultListener");
            this.mYYPayResultListener = new b(this);
        }
    }

    private void registerPayServiceListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            IAppPayService b2 = b6a.b(this.mAppId, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "registerPayServiceListener error null appPayService", new Object[0]);
                return;
            }
            c cVar = new c(this);
            this.mAppPayServiceListener = cVar;
            b2.addPayListener(cVar);
        }
    }

    private synchronized void releaseAllPayFlowView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "releaseAllPayFlowView() mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                if (this.mAppContext != null) {
                    k6a.a(this.mAppContext);
                } else {
                    RLog.error(TAG, "releaseAllPayFlowView error mAppContext null", new Object[0]);
                }
            }
        }
    }

    private void releasePayController() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, this) == null) {
            RLog.info(TAG, "releasePayController() mYYPayController:" + this.mYYPayController);
            innerReleasePayController();
            IAppPayService b2 = b6a.b(this.mAppId, this.mUserChannel);
            if (b2 != null) {
                b2.cancelAllRequest();
            } else {
                RLog.error(TAG, "onPayFlowFinish error appPayService null ", new Object[0]);
            }
        }
    }

    public static void setAlipaySdkProxy(IAlipaySdkServiceProxy iAlipaySdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, iAlipaySdkServiceProxy) == null) {
            RLog.info(TAG, "setAlipaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.ALI_PAY, iAlipaySdkServiceProxy);
        }
    }

    public static void setDxmPaySdkProxy(IDxmSdkServiceProxy iDxmSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65563, null, iDxmSdkServiceProxy) == null) {
            RLog.info(TAG, "setDxmPaySdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.DXM_PAY, iDxmSdkServiceProxy);
        }
    }

    public static void setTestFunListener(n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65564, null, n4aVar) == null) {
            mTestFunListenerr = n4aVar;
        }
    }

    public static void setWechatSdkProxy(IWechatSdkServiceProxy iWechatSdkServiceProxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65565, null, iWechatSdkServiceProxy) == null) {
            RLog.info(TAG, "setWechatSdkProxy");
            PayMethodProxyFactory.instance().addPayServiceProxyMap(PayType.WECHAT_PAY, iWechatSdkServiceProxy);
        }
    }

    private synchronized void tryNotifyPayFlowRelease(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, this, payFlowType) == null) {
            synchronized (this) {
                boolean z = this.mYYPayController != null && this.mYYPayController.g(payFlowType);
                RLog.info(TAG, "tryNotifyPayFlowRelease payFlowType:" + payFlowType.name() + " shouldReleasePayFlow:" + z + " mYYPayController:" + this.mYYPayController);
                if (z) {
                    this.mYYPayController.d(payFlowType);
                }
                tryReleasePayController(payFlowType);
            }
        }
    }

    private void tryReleasePayController(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65567, this, payFlowType) == null) {
            v4a v4aVar = this.mYYPayController;
            boolean z = v4aVar != null && v4aVar.e();
            RLog.info(TAG, "tryReleasePayController payFlowType:" + payFlowType.name() + " shouldReleasePayController:" + z + " mYYPayController:" + this.mYYPayController);
            if (z) {
                releasePayController();
            }
        }
    }

    private void unregisterPayServiceListener() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65568, this) == null) || this.mAppPayServiceListener == null) {
            return;
        }
        IAppPayService b2 = b6a.b(this.mAppId, this.mUserChannel);
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
                unregisterPayServiceListener();
                mPayUIKitMap.remove(uIKitMapKey);
                this.mYYPayListener.clear();
                RevenueManager.instance().removeRevenueConfig(this.mAppId, this.mUserChannel);
            }
        }
    }

    public s4a getPayFlowLifecycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mPayFlowLifecycle : (s4a) invokeV.objValue;
    }

    public PayFlowModel getPayFlowModel(PayFlowType payFlowType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, payFlowType)) == null) {
            v4a v4aVar = this.mYYPayController;
            if (v4aVar != null) {
                return v4aVar.a(payFlowType);
            }
            return null;
        }
        return (PayFlowModel) invokeL.objValue;
    }

    public PayUIKitConfig getPayUIKitConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mPayUIKitConfig : (PayUIKitConfig) invokeV.objValue;
    }

    public void onQQPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048581, this, i, str) == null) {
            RLog.info(TAG, "onQQPayResult code:" + i + " msg:" + str);
            int i2 = this.mAppId;
            if (i2 == 0) {
                RLog.error(TAG, "onQQPayResult error appid is 0", new Object[0]);
                return;
            }
            IAppPayService b2 = b6a.b(i2, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "onQQPayResult error payService is null", new Object[0]);
            } else {
                b2.onQQPayResult(i, str);
            }
        }
    }

    public void onWxPayResult(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) {
            RLog.info(TAG, "onWxPayResult code:" + i + " msg:" + str);
            int i2 = this.mAppId;
            if (i2 == 0) {
                RLog.error(TAG, "onWxPayResult error appid is 0", new Object[0]);
                return;
            }
            IAppPayService b2 = b6a.b(i2, this.mUserChannel);
            if (b2 == null) {
                RLog.error(TAG, "onWxPayResult error payService is null", new Object[0]);
            } else {
                b2.onWxPayResult(i, str);
            }
        }
    }

    public synchronized void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "release mAppId:" + this.mAppId + " userChannel:" + this.mUserChannel);
                releaseAllPayFlowView();
                innerReleasePayController();
            }
        }
    }

    public void removeYYPayListener(IYYPayListener iYYPayListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iYYPayListener) == null) {
            RLog.info(TAG, "removeYYPayListener listener:" + iYYPayListener);
            if (iYYPayListener == null) {
                RLog.error(TAG, "removeGlobalPayListener error listener null", new Object[0]);
            } else {
                this.mYYPayListener.remove(iYYPayListener);
            }
        }
    }

    public void startPayChannelDialog(Activity activity, IYYPayWayView.b bVar, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, activity, bVar, iPayCallback) == null) {
            RLog.info(TAG, "startPayChannelDialog");
            getPayController().c(activity, bVar, iPayCallback);
        }
    }

    public void startPayDialog(Activity activity, IYYPayAmountView.ViewParams viewParams, IPayCallback<CurrencyChargeMessage> iPayCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, activity, viewParams, iPayCallback) == null) {
            RLog.info(TAG, "startPayDialog");
            getPayController().h(activity, viewParams, iPayCallback);
        }
    }

    public void startWalletActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, activity) == null) {
            RLog.info(TAG, "startWalletActivity");
            getPayController().b(activity);
        }
    }

    public void startWalletActivity(Activity activity, IYYPayAmountView.ViewParams viewParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, activity, viewParams) == null) {
            RLog.info(TAG, "startWalletActivity viewParams:" + viewParams);
            getPayController().i(activity, viewParams);
        }
    }
}
