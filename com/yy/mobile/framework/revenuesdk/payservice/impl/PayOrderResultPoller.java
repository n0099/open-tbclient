package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.os.Handler;
import android.os.Looper;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.PayFailMsg;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.bean.GiftBagsInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PollingModeInfo;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayFlowEventType;
import java.util.List;
import tv.athena.revenue.api.pay.params.PayFlowType;
/* loaded from: classes2.dex */
public class PayOrderResultPoller {
    public final String TAG = "PayResultPoller";
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public IPayEventStatisticsApi mPayEventRepoter;
    public IAppPayService payService;
    public IPayServiceCallback payServiceCallback;

    /* loaded from: classes2.dex */
    public interface PollerListener {
        void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams, int i, String str);

        void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult);
    }

    public PayOrderResultPoller(IAppPayService iAppPayService, IPayServiceCallback iPayServiceCallback, IPayEventStatisticsApi iPayEventStatisticsApi) {
        this.payServiceCallback = iPayServiceCallback;
        this.payService = iAppPayService;
        this.mPayEventRepoter = iPayEventStatisticsApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetChargeOrderStatusReqParams createOrderStatusReqParams(ChargeCurrencyReqParams chargeCurrencyReqParams, int i, String str) {
        GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
        getChargeOrderStatusReqParams.setAppId(i);
        getChargeOrderStatusReqParams.setOrderId(str);
        getChargeOrderStatusReqParams.setUid(chargeCurrencyReqParams.getUid());
        getChargeOrderStatusReqParams.setToken(chargeCurrencyReqParams.getToken());
        getChargeOrderStatusReqParams.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
        getChargeOrderStatusReqParams.setUsedChannel(chargeCurrencyReqParams.getUsedChannel());
        getChargeOrderStatusReqParams.setSid(chargeCurrencyReqParams.getSid());
        return getChargeOrderStatusReqParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doGetPayResult(final ChargeCurrencyReqParams chargeCurrencyReqParams, final GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, final PollingModeInfo pollingModeInfo, final PollerListener pollerListener) {
        RLog.info("PayResultPoller", "doGetPayResult has hasPolledTimes:" + pollingModeInfo.hasPolledTimes);
        this.payService.queryChargeOrderStatus(getChargeOrderStatusReqParams, new IResult<GetChargeOrderStatusResult>() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller.2
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onFail(int i, String str, PayCallBackBean payCallBackBean) {
                RLog.error("PayResultPoller", "doGetPayResult onFail code:" + i, new Object[0]);
                PayOrderResultPoller.this.tryGetPayResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getOrderId(), pollingModeInfo, pollerListener);
                PollerListener pollerListener2 = pollerListener;
                if (pollerListener2 != null) {
                    pollerListener2.onFail(chargeCurrencyReqParams, i, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, PayCallBackBean payCallBackBean) {
                RLog.info("PayResultPoller", "doGetPayResult onSuccess result:" + getChargeOrderStatusResult);
                if (getChargeOrderStatusResult.getStatus() == 1) {
                    PollingModeInfo pollingModeInfo2 = pollingModeInfo;
                    pollingModeInfo2.hasPolledTimes = pollingModeInfo2.totalPollTimes;
                    PayOrderResultPoller.this.notifyPollerResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams, getChargeOrderStatusResult);
                } else if (getChargeOrderStatusResult.finish) {
                    PollingModeInfo pollingModeInfo3 = pollingModeInfo;
                    pollingModeInfo3.hasPolledTimes = pollingModeInfo3.totalPollTimes;
                    PayOrderResultPoller.this.notifyPollerResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams, getChargeOrderStatusResult);
                } else {
                    PayOrderResultPoller.this.tryGetPayResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getOrderId(), pollingModeInfo, pollerListener);
                }
                PollerListener pollerListener2 = pollerListener;
                if (pollerListener2 != null) {
                    pollerListener2.onSuccess(chargeCurrencyReqParams, getChargeOrderStatusResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPollerResult(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult) {
        final CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
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
        currencyChargeMessage.splitRecordItemList = getChargeOrderStatusResult.splitRecordItemList;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.payServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller.3
                @Override // java.lang.Runnable
                public void run() {
                    PayOrderResultPoller.this.payServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
                }
            });
        }
        reportPayOrderStatusEvent(getChargeOrderStatusResult, chargeCurrencyReqParams, currencyChargeMessage);
    }

    private void reportPayOrderStatusEvent(GetChargeOrderStatusResult getChargeOrderStatusResult, ChargeCurrencyReqParams chargeCurrencyReqParams, CurrencyChargeMessage currencyChargeMessage) {
        String str;
        if (this.mPayEventRepoter != null) {
            if (chargeCurrencyReqParams.getPayFlowTypeId() == PayFlowType.WALLET_PAY_FLOW.getTypeId()) {
                str = AccountConstants.LOGIN_TYPE_NATIVE_SRC_WALLET;
            } else {
                str = "dialog";
            }
            IPayEventStatisticsApi iPayEventStatisticsApi = this.mPayEventRepoter;
            String str2 = getChargeOrderStatusResult.getStatus() + "";
            String str3 = currencyChargeMessage.orderId;
            iPayEventStatisticsApi.reportPayFlowEvent(PayFlowEventType.paychargeorderStatus, str2, "order result", str3, "" + chargeCurrencyReqParams.getRequestTime(), chargeCurrencyReqParams.getProductId(), chargeCurrencyReqParams.getPayType().getChannel(), chargeCurrencyReqParams.getTraceid(), str);
            RLog.info("PayResultPoller", "notifyPollerResult reportPayFlowEvent status:" + getChargeOrderStatusResult.getStatus());
        }
    }

    public void tryGetPayResult(final ChargeCurrencyReqParams chargeCurrencyReqParams, final int i, final String str, final PollingModeInfo pollingModeInfo, final PollerListener pollerListener) {
        int i2;
        int i3;
        if (chargeCurrencyReqParams.getProtocolType() != ProtocolType.UNKNOW && chargeCurrencyReqParams.getProtocolType() == ProtocolType.HTTP) {
            if (pollingModeInfo != null && (i2 = pollingModeInfo.pollInterval) >= 0 && (i3 = pollingModeInfo.totalPollTimes) > 0) {
                int i4 = pollingModeInfo.hasPolledTimes;
                if (i4 >= i3) {
                    GetChargeOrderStatusReqParams createOrderStatusReqParams = createOrderStatusReqParams(chargeCurrencyReqParams, i, str);
                    GetChargeOrderStatusResult getChargeOrderStatusResult = new GetChargeOrderStatusResult();
                    getChargeOrderStatusResult.status = 0;
                    getChargeOrderStatusResult.message = PayFailMsg.FAILED_GET_RESULT_TIME_OUT;
                    notifyPollerResult(chargeCurrencyReqParams, createOrderStatusReqParams, getChargeOrderStatusResult);
                    RLog.info("PayResultPoller", "tryGetPayResult all times pollingModeInfo:" + pollingModeInfo);
                    return;
                }
                if (i4 == 0) {
                    i2 = 2;
                }
                RLog.info("PayResultPoller", "tryGetPayResult post delay:" + i2 + " pollingModeInfo:" + pollingModeInfo);
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayOrderResultPoller.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GetChargeOrderStatusReqParams createOrderStatusReqParams2 = PayOrderResultPoller.this.createOrderStatusReqParams(chargeCurrencyReqParams, i, str);
                        PollingModeInfo pollingModeInfo2 = pollingModeInfo;
                        pollingModeInfo2.hasPolledTimes++;
                        PayOrderResultPoller.this.doGetPayResult(chargeCurrencyReqParams, createOrderStatusReqParams2, pollingModeInfo2, pollerListener);
                    }
                }, ((long) i2) * 1000);
                return;
            }
            RLog.error("PayResultPoller", "tryGetPayResult  params error pollingModeInfo:" + pollingModeInfo, new Object[0]);
            GetChargeOrderStatusReqParams createOrderStatusReqParams2 = createOrderStatusReqParams(chargeCurrencyReqParams, i, str);
            GetChargeOrderStatusResult getChargeOrderStatusResult2 = new GetChargeOrderStatusResult();
            getChargeOrderStatusResult2.status = -1;
            getChargeOrderStatusResult2.message = "支付订单查询失败 error " + pollingModeInfo;
            notifyPollerResult(chargeCurrencyReqParams, createOrderStatusReqParams2, getChargeOrderStatusResult2);
            return;
        }
        RLog.error("PayResultPoller", "tryGetPayResult failed ProtocolType error", new Object[0]);
    }
}
