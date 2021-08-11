package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class H5PayManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CODE_FAIL = 2;
    public static final int CODE_SUCCESS = 1;
    public static final int RECHARGE_VERIFY_ORDER_INTERVAL = 1000;
    public static final int RECHARGE_VERIFY_ORDER_RETRY_MAX = 3;
    public static final String TAG = "H5PayManager";
    public static H5PayManager instance;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Activity> mAct;
    public Handler mHandler;
    public Map<String, H5PayVerifyTask> mOrderVerifyTaskMap;
    public Class mPayWebViewActivityClass;
    public String mReadyVerifyOrderId;

    public H5PayManager() {
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
        this.mReadyVerifyOrderId = null;
        this.mOrderVerifyTaskMap = new HashMap();
        this.mHandler = new Handler(Looper.getMainLooper());
    }

    private synchronized void doPay(String str, H5PayParams h5PayParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, h5PayParams) == null) {
            synchronized (this) {
                setReadyOrderId(str, h5PayParams);
                setActivity(h5PayParams.reqParams.getContext());
                if (this.mAct != null && this.mAct.get() != null) {
                    if (this.mPayWebViewActivityClass == null) {
                        RLog.error(TAG, "doPay error mPayWebviewActClass null", new Object[0]);
                        removeOrderVerifyTask(str);
                        return;
                    }
                    try {
                        Intent intent = new Intent(this.mAct.get(), this.mPayWebViewActivityClass);
                        PayType payType = h5PayParams.reqParams != null ? h5PayParams.reqParams.getPayType() : PayType.DXM_PAY_KJ;
                        if (PayType.MOCK_TEST_PAY.equals(payType)) {
                            intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 3);
                        } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                            intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 2);
                        }
                        intent.putExtra(H5PayConstant.EXTRA_URL, h5PayParams.payBackBean.getPayLoad());
                        intent.putExtra(H5PayConstant.EXTRA_APP_ID, h5PayParams.reqParams.getAppId());
                        intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, h5PayParams.reqParams.getUsedChannel());
                        if (this.mAct.get() != null) {
                            this.mAct.get().startActivity(intent);
                        } else {
                            removeOrderVerifyTask(str);
                            RLog.error(TAG, "dopay error mAct.get() null", new Object[0]);
                        }
                    } catch (Exception e2) {
                        RLog.error(TAG, "doPay exception:" + e2.getLocalizedMessage(), new Object[0]);
                        removeOrderVerifyTask(str);
                    }
                    return;
                }
                RLog.error(TAG, "doPay error mAct null", new Object[0]);
                removeOrderVerifyTask(str);
            }
        }
    }

    public static H5PayManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (instance == null) {
                synchronized (H5PayManager.class) {
                    if (instance == null) {
                        instance = new H5PayManager();
                    }
                }
            }
            return instance;
        }
        return (H5PayManager) invokeV.objValue;
    }

    private synchronized void notifyPollingForChargeResult(String str, H5PayParams h5PayParams, ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{str, h5PayParams, chargeCurrencyReqParams, getChargeOrderStatusResult, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                ChargeCurrencyReqParams chargeCurrencyReqParams2 = h5PayParams.reqParams;
                if (chargeCurrencyReqParams2 == null) {
                    RLog.error(TAG, "notifyPollingForChargeResult error reqParams null", new Object[0]);
                    return;
                }
                CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
                currencyChargeMessage.appid = chargeCurrencyReqParams2.getAppId();
                currencyChargeMessage.usedChannel = chargeCurrencyReqParams2.getUsedChannel();
                currencyChargeMessage.orderId = str;
                currencyChargeMessage.uid = chargeCurrencyReqParams2.getUid();
                currencyChargeMessage.amount = getChargeOrderStatusResult.amount;
                currencyChargeMessage.currencyAmount = getChargeOrderStatusResult.currencyAmount;
                currencyChargeMessage.currencyType = getChargeOrderStatusResult.currencyType;
                currencyChargeMessage.status = getChargeOrderStatusResult.status;
                currencyChargeMessage.payChannel = chargeCurrencyReqParams2.getPayChannel();
                currencyChargeMessage.timeout = z;
                currencyChargeMessage.appClientExpand = chargeCurrencyReqParams.getAppClientExpand();
                currencyChargeMessage.reqParams = chargeCurrencyReqParams;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    h5PayParams.payInnerLogic.onCurrencyChargeMessage(currencyChargeMessage);
                } else {
                    ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, h5PayParams, currencyChargeMessage) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.4
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ H5PayManager this$0;
                        public final /* synthetic */ CurrencyChargeMessage val$currencyChargeMessage;
                        public final /* synthetic */ H5PayParams val$payParams;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, h5PayParams, currencyChargeMessage};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$payParams = h5PayParams;
                            this.val$currencyChargeMessage = currencyChargeMessage;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                this.val$payParams.payInnerLogic.onCurrencyChargeMessage(this.val$currencyChargeMessage);
                            }
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOrderVerifyAck(int i2, String str, H5PayVerifyTask h5PayVerifyTask, GetChargeOrderStatusResult getChargeOrderStatusResult, ChargeCurrencyReqParams chargeCurrencyReqParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{Integer.valueOf(i2), str, h5PayVerifyTask, getChargeOrderStatusResult, chargeCurrencyReqParams}) == null) {
            synchronized (this) {
                H5PayParams h5PayParams = h5PayVerifyTask.h5PayParams;
                if (!this.mOrderVerifyTaskMap.containsKey(str)) {
                    RLog.error(TAG, "invalid order. maybe user generate a new order, or user switched.", new Object[0]);
                    return;
                }
                if (i2 == 1) {
                    removeOrderVerifyTask(str);
                    RLog.info(TAG, "recharge verify success, query balance now.");
                    notifyPollingForChargeResult(str, h5PayParams, chargeCurrencyReqParams, getChargeOrderStatusResult, false);
                } else {
                    int i3 = h5PayVerifyTask.mCurrentRetryCount;
                    int i4 = i3 + 1;
                    h5PayVerifyTask.mCurrentRetryCount = i4;
                    if (i3 < 3) {
                        h5PayVerifyTask.mCurrentRetryInterval = i4 * 1000;
                        verifyPayOrder(h5PayVerifyTask);
                        RLog.error(TAG, "retry verify again,current count is " + h5PayVerifyTask.mCurrentRetryCount, new Object[0]);
                    } else {
                        removeOrderVerifyTask(str);
                        RLog.error(TAG, "verify timeout!", new Object[0]);
                        notifyPollingForChargeResult(str, h5PayParams, chargeCurrencyReqParams, getChargeOrderStatusResult, true);
                    }
                }
            }
        }
    }

    private synchronized void removeOrderVerifyTask(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            synchronized (this) {
                if (str == null) {
                    return;
                }
                this.mOrderVerifyTaskMap.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyOrder(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, this, str) == null) {
            H5PayVerifyTask h5PayVerifyTask = this.mOrderVerifyTaskMap.get(str);
            H5PayParams h5PayParams = h5PayVerifyTask.h5PayParams;
            if (h5PayParams == null) {
                RLog.error(TAG, "verifyOrder error payParams null orderId:" + str, new Object[0]);
                return;
            }
            ChargeCurrencyReqParams chargeCurrencyReqParams = h5PayParams.reqParams;
            if (chargeCurrencyReqParams == null) {
                RLog.error(TAG, "verifyOrder error reqParams null orderId:" + str, new Object[0]);
                return;
            }
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
            getChargeOrderStatusReqParams.setUid(chargeCurrencyReqParams.getUid());
            getChargeOrderStatusReqParams.setAppId(chargeCurrencyReqParams.getAppId());
            getChargeOrderStatusReqParams.setUsedChannel(chargeCurrencyReqParams.getUsedChannel());
            getChargeOrderStatusReqParams.setSid(chargeCurrencyReqParams.getSid());
            getChargeOrderStatusReqParams.setOrderId(str);
            getChargeOrderStatusReqParams.setToken(chargeCurrencyReqParams.getToken());
            getChargeOrderStatusReqParams.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
            h5PayParams.appPayService.queryChargeOrderStatus(getChargeOrderStatusReqParams, new IResult<GetChargeOrderStatusResult>(this, str, h5PayVerifyTask, chargeCurrencyReqParams) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ H5PayManager this$0;
                public final /* synthetic */ String val$orderId;
                public final /* synthetic */ H5PayVerifyTask val$orderVerifyTask;
                public final /* synthetic */ ChargeCurrencyReqParams val$reqParams;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, h5PayVerifyTask, chargeCurrencyReqParams};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$orderId = str;
                    this.val$orderVerifyTask = h5PayVerifyTask;
                    this.val$reqParams = chargeCurrencyReqParams;
                }

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onFail(int i2, String str2, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str2, payCallBackBean) == null) {
                        this.this$0.onOrderVerifyAck(2, this.val$orderId, this.val$orderVerifyTask, null, this.val$reqParams);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getChargeOrderStatusResult, payCallBackBean) == null) {
                        if (getChargeOrderStatusResult.getStatus() == 1) {
                            this.this$0.onOrderVerifyAck(1, this.val$orderId, this.val$orderVerifyTask, getChargeOrderStatusResult, this.val$reqParams);
                        } else if (getChargeOrderStatusResult.finish) {
                            this.this$0.onOrderVerifyAck(1, this.val$orderId, this.val$orderVerifyTask, getChargeOrderStatusResult, this.val$reqParams);
                        } else {
                            this.this$0.onOrderVerifyAck(2, this.val$orderId, this.val$orderVerifyTask, getChargeOrderStatusResult, this.val$reqParams);
                        }
                    }
                }
            });
        }
    }

    public void onDisponse() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mAct = null;
        }
    }

    public synchronized void requestH5Pay(String str, H5PayParams h5PayParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, h5PayParams) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    RLog.error(TAG, "requestH5Pay error orderId null", new Object[0]);
                    return;
                }
                if (h5PayParams != null && h5PayParams.reqParams != null && h5PayParams.appPayService != null && h5PayParams.payInnerLogic != null) {
                    doPay(str, h5PayParams);
                    return;
                }
                RLog.error(TAG, "requestH5Pay error payParams null", new Object[0]);
            }
        }
    }

    public synchronized void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            synchronized (this) {
                this.mAct = new WeakReference<>(activity);
            }
        }
    }

    public synchronized void setReadyOrderId(String str, H5PayParams h5PayParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, h5PayParams) == null) {
            synchronized (this) {
                if (this.mOrderVerifyTaskMap.containsKey(str)) {
                    RLog.error(TAG, "setOrderId error has contain orderId", new Object[0]);
                    return;
                }
                this.mReadyVerifyOrderId = str;
                H5PayVerifyTask h5PayVerifyTask = new H5PayVerifyTask();
                h5PayVerifyTask.h5PayParams = h5PayParams;
                h5PayVerifyTask.mCurrentOrderId = str;
                h5PayVerifyTask.mCurrentRetryCount = 0;
                h5PayVerifyTask.mCurrentRetryInterval = 1;
                this.mOrderVerifyTaskMap.put(str, h5PayVerifyTask);
                RLog.info(TAG, "new order id is " + str);
            }
        }
    }

    public synchronized void setYYPayWebviewActClass(Class cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cls) == null) {
            synchronized (this) {
                this.mPayWebViewActivityClass = cls;
            }
        }
    }

    public synchronized void verifyPayOrder() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                RLog.info(TAG, "try verifyPayOrder");
                if (TextUtils.isEmpty(this.mReadyVerifyOrderId)) {
                    RLog.error(TAG, "try verifyPayOrder error mReadyVerifyOrderId null", new Object[0]);
                    return;
                }
                String str = this.mReadyVerifyOrderId;
                this.mReadyVerifyOrderId = null;
                this.mHandler.postDelayed(new Runnable(this, str) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ H5PayManager this$0;
                    public final /* synthetic */ String val$newVerifyOrderId;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$newVerifyOrderId = str;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if (!TextUtils.isEmpty(this.val$newVerifyOrderId)) {
                                this.this$0.verifyOrder(this.val$newVerifyOrderId);
                            } else {
                                RLog.error(H5PayManager.TAG, "postDelayed error newVerifyOrderId null", new Object[0]);
                            }
                        }
                    }
                }, 1000L);
            }
        }
    }

    private synchronized void verifyPayOrder(H5PayVerifyTask h5PayVerifyTask) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, h5PayVerifyTask) == null) {
            synchronized (this) {
                if (h5PayVerifyTask == null) {
                    RLog.error(TAG, "verifyPayOrder error orderVerifyTask null", new Object[0]);
                    return;
                }
                int i2 = h5PayVerifyTask.mCurrentRetryInterval;
                int i3 = h5PayVerifyTask.mCurrentRetryCount;
                RLog.debug(TAG, "verifyPayOrder mCurrentRetryInterval:" + i2 + " mCurrentRetryCount:" + i3);
                this.mHandler.postDelayed(new Runnable(this, h5PayVerifyTask) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ H5PayManager this$0;
                    public final /* synthetic */ H5PayVerifyTask val$orderVerifyTask;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, h5PayVerifyTask};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i4 = newInitContext.flag;
                            if ((i4 & 1) != 0) {
                                int i5 = i4 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$orderVerifyTask = h5PayVerifyTask;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        H5PayVerifyTask h5PayVerifyTask2;
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || (h5PayVerifyTask2 = this.val$orderVerifyTask) == null || TextUtils.isEmpty(h5PayVerifyTask2.mCurrentOrderId)) {
                            return;
                        }
                        this.this$0.verifyOrder(this.val$orderVerifyTask.mCurrentOrderId);
                    }
                }, (long) i2);
            }
        }
    }
}
