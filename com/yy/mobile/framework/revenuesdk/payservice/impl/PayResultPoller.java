package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
/* loaded from: classes6.dex */
public class PayResultPoller {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public Handler mMainHandler;
    public IPayInnerLogic payInnerLogic;
    public IAppPayService payService;

    /* loaded from: classes6.dex */
    public interface PollerListener {
        void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str);

        void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult);
    }

    public PayResultPoller(IAppPayService iAppPayService, IPayInnerLogic iPayInnerLogic) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAppPayService, iPayInnerLogic};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "AppPayServiceImpl-Poller";
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.payInnerLogic = iPayInnerLogic;
        this.payService = iAppPayService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPollingForChargeResult(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, PollingModeInfo pollingModeInfo, PollerListener pollerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TRACKBALL, this, chargeCurrencyReqParams, getChargeOrderStatusReqParams, pollingModeInfo, pollerListener) == null) {
            RLog.info("AppPayServiceImpl-Poller", "do pollingForChargeResult has finishTimes:" + pollingModeInfo.finishTimes);
            this.payService.queryChargeOrderStatus(getChargeOrderStatusReqParams, new IResult<GetChargeOrderStatusResult>(this, pollingModeInfo, chargeCurrencyReqParams, getChargeOrderStatusReqParams, pollerListener) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayResultPoller this$0;
                public final /* synthetic */ PollerListener val$callback;
                public final /* synthetic */ GetChargeOrderStatusReqParams val$params;
                public final /* synthetic */ PollingModeInfo val$pollingModeInfo;
                public final /* synthetic */ ChargeCurrencyReqParams val$reqParams;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, pollingModeInfo, chargeCurrencyReqParams, getChargeOrderStatusReqParams, pollerListener};
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
                    this.val$pollingModeInfo = pollingModeInfo;
                    this.val$reqParams = chargeCurrencyReqParams;
                    this.val$params = getChargeOrderStatusReqParams;
                    this.val$callback = pollerListener;
                }

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                        RLog.error("AppPayServiceImpl-Poller", "doPollingForChargeResult onFail code:" + i2, new Object[0]);
                        this.this$0.pollingForChargeResult(this.val$reqParams, this.val$params.getAppId(), this.val$params.getOrderId(), this.val$pollingModeInfo, this.val$callback);
                        PollerListener pollerListener2 = this.val$callback;
                        if (pollerListener2 != null) {
                            pollerListener2.onFail(this.val$reqParams, i2, str);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getChargeOrderStatusResult, payCallBackBean) == null) {
                        RLog.info("AppPayServiceImpl-Poller", "doPollingForChargeResult onSuccess result:" + getChargeOrderStatusResult);
                        if (getChargeOrderStatusResult.getStatus() == 1) {
                            PollingModeInfo pollingModeInfo2 = this.val$pollingModeInfo;
                            pollingModeInfo2.finishTimes = pollingModeInfo2.times;
                            this.this$0.notifyPollingForChargeResult(this.val$reqParams, this.val$params, getChargeOrderStatusResult, false);
                        } else if (getChargeOrderStatusResult.finish) {
                            PollingModeInfo pollingModeInfo3 = this.val$pollingModeInfo;
                            pollingModeInfo3.finishTimes = pollingModeInfo3.times;
                            this.this$0.notifyPollingForChargeResult(this.val$reqParams, this.val$params, getChargeOrderStatusResult, false);
                        } else {
                            this.this$0.pollingForChargeResult(this.val$reqParams, this.val$params.getAppId(), this.val$params.getOrderId(), this.val$pollingModeInfo, this.val$callback);
                        }
                        PollerListener pollerListener2 = this.val$callback;
                        if (pollerListener2 != null) {
                            pollerListener2.onSuccess(this.val$reqParams, getChargeOrderStatusResult);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPollingForChargeResult(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{chargeCurrencyReqParams, getChargeOrderStatusReqParams, getChargeOrderStatusResult, Boolean.valueOf(z)}) == null) {
            CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
            currencyChargeMessage.appid = getChargeOrderStatusReqParams.getAppId();
            currencyChargeMessage.usedChannel = getChargeOrderStatusReqParams.getUsedChannel();
            currencyChargeMessage.orderId = getChargeOrderStatusReqParams.getOrderId();
            currencyChargeMessage.uid = getChargeOrderStatusReqParams.getUid();
            currencyChargeMessage.amount = getChargeOrderStatusResult.amount;
            currencyChargeMessage.currencyAmount = getChargeOrderStatusResult.currencyAmount;
            currencyChargeMessage.currencyType = getChargeOrderStatusResult.currencyType;
            currencyChargeMessage.status = getChargeOrderStatusResult.status;
            currencyChargeMessage.timeout = z;
            currencyChargeMessage.appClientExpand = chargeCurrencyReqParams.getAppClientExpand();
            currencyChargeMessage.reqParams = chargeCurrencyReqParams;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.payInnerLogic.onCurrencyChargeMessage(currencyChargeMessage);
            } else {
                ThreadPool.getDefault().mainThreadIO().execute(new Runnable(this, currencyChargeMessage) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PayResultPoller this$0;
                    public final /* synthetic */ CurrencyChargeMessage val$currencyChargeMessage;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, currencyChargeMessage};
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
                        this.val$currencyChargeMessage = currencyChargeMessage;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.payInnerLogic.onCurrencyChargeMessage(this.val$currencyChargeMessage);
                        }
                    }
                });
            }
        }
    }

    public void pollingForChargeResult(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, PollingModeInfo pollingModeInfo, PollerListener pollerListener) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{chargeCurrencyReqParams, Integer.valueOf(i2), str, pollingModeInfo, pollerListener}) == null) {
            if (chargeCurrencyReqParams.getProtocolType() == ProtocolType.UNKNOW) {
                RLog.error("AppPayServiceImpl-Poller", "pollingForChargeResult error ProtocolType unknow", new Object[0]);
            } else if (chargeCurrencyReqParams.getProtocolType() != ProtocolType.HTTP) {
                RLog.debug("AppPayServiceImpl-Poller", "pollingForChargeResult but not http");
            } else if (pollingModeInfo == null) {
                RLog.debug("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo null");
            } else {
                int i4 = pollingModeInfo.interval;
                if (i4 >= 0 && (i3 = pollingModeInfo.times) > 0) {
                    int i5 = pollingModeInfo.finishTimes;
                    if (i5 >= i3) {
                        GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
                        getChargeOrderStatusReqParams.setUid(chargeCurrencyReqParams.getUid());
                        getChargeOrderStatusReqParams.setToken(chargeCurrencyReqParams.getToken());
                        getChargeOrderStatusReqParams.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
                        getChargeOrderStatusReqParams.setAppId(i2);
                        getChargeOrderStatusReqParams.setUsedChannel(chargeCurrencyReqParams.getUsedChannel());
                        getChargeOrderStatusReqParams.setSid(chargeCurrencyReqParams.getSid());
                        getChargeOrderStatusReqParams.setOrderId(str);
                        GetChargeOrderStatusResult getChargeOrderStatusResult = new GetChargeOrderStatusResult();
                        getChargeOrderStatusResult.status = 0;
                        notifyPollingForChargeResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams, getChargeOrderStatusResult, true);
                        RLog.info("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo all times");
                        return;
                    }
                    if (i5 == 0) {
                        i4 = 2;
                    }
                    RLog.info("AppPayServiceImpl-Poller", "pollingForChargeResult post delaye interval:" + pollingModeInfo.interval + " has finish times:" + pollingModeInfo.finishTimes + " delay:" + i4);
                    this.mMainHandler.postDelayed(new Runnable(this, chargeCurrencyReqParams, i2, str, pollingModeInfo, pollerListener) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ PayResultPoller this$0;
                        public final /* synthetic */ int val$appId;
                        public final /* synthetic */ PollerListener val$callback;
                        public final /* synthetic */ String val$orderId;
                        public final /* synthetic */ PollingModeInfo val$pollingModeInfo;
                        public final /* synthetic */ ChargeCurrencyReqParams val$reqParams;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, chargeCurrencyReqParams, Integer.valueOf(i2), str, pollingModeInfo, pollerListener};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i6 = newInitContext.flag;
                                if ((i6 & 1) != 0) {
                                    int i7 = i6 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                            this.val$reqParams = chargeCurrencyReqParams;
                            this.val$appId = i2;
                            this.val$orderId = str;
                            this.val$pollingModeInfo = pollingModeInfo;
                            this.val$callback = pollerListener;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                GetChargeOrderStatusReqParams getChargeOrderStatusReqParams2 = new GetChargeOrderStatusReqParams();
                                getChargeOrderStatusReqParams2.setUid(this.val$reqParams.getUid());
                                getChargeOrderStatusReqParams2.setAppId(this.val$appId);
                                getChargeOrderStatusReqParams2.setUsedChannel(this.val$reqParams.getUsedChannel());
                                getChargeOrderStatusReqParams2.setSid(this.val$reqParams.getSid());
                                getChargeOrderStatusReqParams2.setOrderId(this.val$orderId);
                                getChargeOrderStatusReqParams2.setToken(this.val$reqParams.getToken());
                                getChargeOrderStatusReqParams2.setTokenCallback(this.val$reqParams.getTokenCallback());
                                PollingModeInfo pollingModeInfo2 = this.val$pollingModeInfo;
                                pollingModeInfo2.finishTimes++;
                                this.this$0.doPollingForChargeResult(this.val$reqParams, getChargeOrderStatusReqParams2, pollingModeInfo2, this.val$callback);
                            }
                        }
                    }, ((long) i4) * 1000);
                    return;
                }
                RLog.debug("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo params error");
            }
        }
    }
}
