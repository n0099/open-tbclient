package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import java.util.List;
/* loaded from: classes4.dex */
public class PayResultPoller {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public Handler mMainHandler;
    public IAppPayService payService;
    public IPayServiceCallback payServiceCallback;

    /* loaded from: classes4.dex */
    public interface PollerListener {
        void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str);

        void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult);
    }

    public PayResultPoller(IAppPayService iAppPayService, IPayServiceCallback iPayServiceCallback) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAppPayService, iPayServiceCallback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "PayResultPoller";
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.payServiceCallback = iPayServiceCallback;
        this.payService = iAppPayService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetChargeOrderStatusReqParams createOrderStatusReqParams(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65541, this, chargeCurrencyReqParams, i2, str)) == null) {
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
            getChargeOrderStatusReqParams.setAppId(i2);
            getChargeOrderStatusReqParams.setOrderId(str);
            getChargeOrderStatusReqParams.setUid(chargeCurrencyReqParams.getUid());
            getChargeOrderStatusReqParams.setToken(chargeCurrencyReqParams.getToken());
            getChargeOrderStatusReqParams.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
            getChargeOrderStatusReqParams.setUsedChannel(chargeCurrencyReqParams.getUsedChannel());
            getChargeOrderStatusReqParams.setSid(chargeCurrencyReqParams.getSid());
            return getChargeOrderStatusReqParams;
        }
        return (GetChargeOrderStatusReqParams) invokeLIL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doGetPayResult(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, PollingModeInfo pollingModeInfo, PollerListener pollerListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65542, this, chargeCurrencyReqParams, getChargeOrderStatusReqParams, pollingModeInfo, pollerListener) == null) {
            RLog.info("PayResultPoller", "doGetPayResult has hasPolledTimes:" + pollingModeInfo.hasPolledTimes);
            this.payService.queryChargeOrderStatus(getChargeOrderStatusReqParams, new IResult<GetChargeOrderStatusResult>(this, pollingModeInfo, chargeCurrencyReqParams, getChargeOrderStatusReqParams, pollerListener) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PayResultPoller this$0;
                public final /* synthetic */ PollerListener val$callback;
                public final /* synthetic */ ChargeCurrencyReqParams val$chargeCurrencyReqParams;
                public final /* synthetic */ GetChargeOrderStatusReqParams val$chargeOrderStatusReqParams;
                public final /* synthetic */ PollingModeInfo val$pollingModeInfo;

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
                    this.val$chargeCurrencyReqParams = chargeCurrencyReqParams;
                    this.val$chargeOrderStatusReqParams = getChargeOrderStatusReqParams;
                    this.val$callback = pollerListener;
                }

                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(1048576, this, i2, str, payCallBackBean) == null) {
                        RLog.error("PayResultPoller", "doGetPayResult onFail code:" + i2, new Object[0]);
                        this.this$0.tryGetPayResult(this.val$chargeCurrencyReqParams, this.val$chargeOrderStatusReqParams.getAppId(), this.val$chargeOrderStatusReqParams.getOrderId(), this.val$pollingModeInfo, this.val$callback);
                        PollerListener pollerListener2 = this.val$callback;
                        if (pollerListener2 != null) {
                            pollerListener2.onFail(this.val$chargeCurrencyReqParams, i2, str);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
                public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, PayCallBackBean payCallBackBean) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, getChargeOrderStatusResult, payCallBackBean) == null) {
                        RLog.info("PayResultPoller", "doGetPayResult onSuccess result:" + getChargeOrderStatusResult);
                        if (getChargeOrderStatusResult.getStatus() == 1) {
                            PollingModeInfo pollingModeInfo2 = this.val$pollingModeInfo;
                            pollingModeInfo2.hasPolledTimes = pollingModeInfo2.totalPollTimes;
                            this.this$0.notifyPollerResult(this.val$chargeCurrencyReqParams, this.val$chargeOrderStatusReqParams, getChargeOrderStatusResult);
                        } else if (getChargeOrderStatusResult.finish) {
                            PollingModeInfo pollingModeInfo3 = this.val$pollingModeInfo;
                            pollingModeInfo3.hasPolledTimes = pollingModeInfo3.totalPollTimes;
                            this.this$0.notifyPollerResult(this.val$chargeCurrencyReqParams, this.val$chargeOrderStatusReqParams, getChargeOrderStatusResult);
                        } else {
                            this.this$0.tryGetPayResult(this.val$chargeCurrencyReqParams, this.val$chargeOrderStatusReqParams.getAppId(), this.val$chargeOrderStatusReqParams.getOrderId(), this.val$pollingModeInfo, this.val$callback);
                        }
                        PollerListener pollerListener2 = this.val$callback;
                        if (pollerListener2 != null) {
                            pollerListener2.onSuccess(this.val$chargeCurrencyReqParams, getChargeOrderStatusResult);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPollerResult(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, this, chargeCurrencyReqParams, getChargeOrderStatusReqParams, getChargeOrderStatusResult) == null) {
            CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
            currencyChargeMessage.appid = getChargeOrderStatusReqParams.getAppId();
            currencyChargeMessage.usedChannel = getChargeOrderStatusReqParams.getUsedChannel();
            currencyChargeMessage.orderId = getChargeOrderStatusReqParams.getOrderId();
            currencyChargeMessage.uid = getChargeOrderStatusReqParams.getUid();
            currencyChargeMessage.amount = getChargeOrderStatusResult.amount;
            currencyChargeMessage.currencyAmount = getChargeOrderStatusResult.currencyAmount;
            currencyChargeMessage.currencyType = getChargeOrderStatusResult.currencyType;
            currencyChargeMessage.status = getChargeOrderStatusResult.status;
            currencyChargeMessage.message = getChargeOrderStatusResult.message;
            currencyChargeMessage.finish = getChargeOrderStatusResult.finish;
            currencyChargeMessage.appClientExpand = chargeCurrencyReqParams.getAppClientExpand();
            currencyChargeMessage.traceid = chargeCurrencyReqParams.getTraceid();
            currencyChargeMessage.cid = chargeCurrencyReqParams.getCid();
            currencyChargeMessage.payChannel = chargeCurrencyReqParams.getPayChannel();
            currencyChargeMessage.payMethod = chargeCurrencyReqParams.getPayMethod();
            List<GiftBagsInfo> list = getChargeOrderStatusResult.giftbags;
            if (list != null && list.size() > 0) {
                currencyChargeMessage.giftBagsInfo = getChargeOrderStatusResult.giftbags.get(0);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.payServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
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
                            this.this$0.payServiceCallback.onCurrencyChargeMessage(this.val$currencyChargeMessage);
                        }
                    }
                });
            }
        }
    }

    public void tryGetPayResult(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, PollingModeInfo pollingModeInfo, PollerListener pollerListener) {
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{chargeCurrencyReqParams, Integer.valueOf(i2), str, pollingModeInfo, pollerListener}) == null) {
            if (chargeCurrencyReqParams.getProtocolType() == ProtocolType.UNKNOW || chargeCurrencyReqParams.getProtocolType() != ProtocolType.HTTP) {
                RLog.error("PayResultPoller", "tryGetPayResult failed ProtocolType error", new Object[0]);
            } else if (pollingModeInfo != null && (i3 = pollingModeInfo.pollInterval) >= 0 && (i4 = pollingModeInfo.totalPollTimes) > 0) {
                int i5 = pollingModeInfo.hasPolledTimes;
                if (i5 >= i4) {
                    GetChargeOrderStatusReqParams createOrderStatusReqParams = createOrderStatusReqParams(chargeCurrencyReqParams, i2, str);
                    GetChargeOrderStatusResult getChargeOrderStatusResult = new GetChargeOrderStatusResult();
                    getChargeOrderStatusResult.status = 0;
                    getChargeOrderStatusResult.message = PayFailMsg.FAILED_GET_RESULT_TIME_OUT;
                    notifyPollerResult(chargeCurrencyReqParams, createOrderStatusReqParams, getChargeOrderStatusResult);
                    RLog.info("PayResultPoller", "tryGetPayResult all times pollingModeInfo:" + pollingModeInfo);
                    return;
                }
                if (i5 == 0) {
                    i3 = 2;
                }
                RLog.info("PayResultPoller", "tryGetPayResult post delay:" + i3 + " pollingModeInfo:" + pollingModeInfo);
                this.mMainHandler.postDelayed(new Runnable(this, chargeCurrencyReqParams, i2, str, pollingModeInfo, pollerListener) { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ PayResultPoller this$0;
                    public final /* synthetic */ int val$appId;
                    public final /* synthetic */ PollerListener val$callback;
                    public final /* synthetic */ ChargeCurrencyReqParams val$chargeCurrencyReqParams;
                    public final /* synthetic */ String val$orderId;
                    public final /* synthetic */ PollingModeInfo val$pollingModeInfo;

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
                        this.val$chargeCurrencyReqParams = chargeCurrencyReqParams;
                        this.val$appId = i2;
                        this.val$orderId = str;
                        this.val$pollingModeInfo = pollingModeInfo;
                        this.val$callback = pollerListener;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            GetChargeOrderStatusReqParams createOrderStatusReqParams2 = this.this$0.createOrderStatusReqParams(this.val$chargeCurrencyReqParams, this.val$appId, this.val$orderId);
                            PollingModeInfo pollingModeInfo2 = this.val$pollingModeInfo;
                            pollingModeInfo2.hasPolledTimes++;
                            this.this$0.doGetPayResult(this.val$chargeCurrencyReqParams, createOrderStatusReqParams2, pollingModeInfo2, this.val$callback);
                        }
                    }
                }, ((long) i3) * 1000);
            } else {
                RLog.error("PayResultPoller", "tryGetPayResult  params error pollingModeInfo:" + pollingModeInfo, new Object[0]);
                GetChargeOrderStatusReqParams createOrderStatusReqParams2 = createOrderStatusReqParams(chargeCurrencyReqParams, i2, str);
                GetChargeOrderStatusResult getChargeOrderStatusResult2 = new GetChargeOrderStatusResult();
                getChargeOrderStatusResult2.status = -1;
                getChargeOrderStatusResult2.message = "支付订单查询失败 error " + pollingModeInfo;
                notifyPollerResult(chargeCurrencyReqParams, createOrderStatusReqParams2, getChargeOrderStatusResult2);
            }
        }
    }
}
