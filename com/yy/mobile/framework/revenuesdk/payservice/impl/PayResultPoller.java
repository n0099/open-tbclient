package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.os.Handler;
import android.os.Looper;
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
/* loaded from: classes7.dex */
public class PayResultPoller {
    public final String TAG = "AppPayServiceImpl-Poller";
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public IPayInnerLogic payInnerLogic;
    public IAppPayService payService;

    /* loaded from: classes7.dex */
    public interface PollerListener {
        void onFail(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str);

        void onSuccess(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult);
    }

    public PayResultPoller(IAppPayService iAppPayService, IPayInnerLogic iPayInnerLogic) {
        this.payInnerLogic = iPayInnerLogic;
        this.payService = iAppPayService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPollingForChargeResult(final ChargeCurrencyReqParams chargeCurrencyReqParams, final GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, final PollingModeInfo pollingModeInfo, final PollerListener pollerListener) {
        RLog.info("AppPayServiceImpl-Poller", "do pollingForChargeResult has finishTimes:" + pollingModeInfo.finishTimes);
        this.payService.queryChargeOrderStatus(getChargeOrderStatusReqParams, new IResult<GetChargeOrderStatusResult>() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.2
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onFail(int i2, String str, PayCallBackBean payCallBackBean) {
                RLog.error("AppPayServiceImpl-Poller", "doPollingForChargeResult onFail code:" + i2, new Object[0]);
                PayResultPoller.this.pollingForChargeResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getOrderId(), pollingModeInfo, pollerListener);
                PollerListener pollerListener2 = pollerListener;
                if (pollerListener2 != null) {
                    pollerListener2.onFail(chargeCurrencyReqParams, i2, str);
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, PayCallBackBean payCallBackBean) {
                RLog.info("AppPayServiceImpl-Poller", "doPollingForChargeResult onSuccess result:" + getChargeOrderStatusResult);
                if (getChargeOrderStatusResult.getStatus() == 1) {
                    PollingModeInfo pollingModeInfo2 = pollingModeInfo;
                    pollingModeInfo2.finishTimes = pollingModeInfo2.times;
                    PayResultPoller.this.notifyPollingForChargeResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams, getChargeOrderStatusResult, false);
                } else if (getChargeOrderStatusResult.finish) {
                    PollingModeInfo pollingModeInfo3 = pollingModeInfo;
                    pollingModeInfo3.finishTimes = pollingModeInfo3.times;
                    PayResultPoller.this.notifyPollingForChargeResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams, getChargeOrderStatusResult, false);
                } else {
                    PayResultPoller.this.pollingForChargeResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams.getAppId(), getChargeOrderStatusReqParams.getOrderId(), pollingModeInfo, pollerListener);
                }
                PollerListener pollerListener2 = pollerListener;
                if (pollerListener2 != null) {
                    pollerListener2.onSuccess(chargeCurrencyReqParams, getChargeOrderStatusResult);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPollingForChargeResult(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult, boolean z) {
        final CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
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
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.3
                @Override // java.lang.Runnable
                public void run() {
                    PayResultPoller.this.payInnerLogic.onCurrencyChargeMessage(currencyChargeMessage);
                }
            });
        }
    }

    public void pollingForChargeResult(final ChargeCurrencyReqParams chargeCurrencyReqParams, final int i2, final String str, final PollingModeInfo pollingModeInfo, final PollerListener pollerListener) {
        int i3;
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
                this.mMainHandler.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.PayResultPoller.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GetChargeOrderStatusReqParams getChargeOrderStatusReqParams2 = new GetChargeOrderStatusReqParams();
                        getChargeOrderStatusReqParams2.setUid(chargeCurrencyReqParams.getUid());
                        getChargeOrderStatusReqParams2.setAppId(i2);
                        getChargeOrderStatusReqParams2.setUsedChannel(chargeCurrencyReqParams.getUsedChannel());
                        getChargeOrderStatusReqParams2.setSid(chargeCurrencyReqParams.getSid());
                        getChargeOrderStatusReqParams2.setOrderId(str);
                        getChargeOrderStatusReqParams2.setToken(chargeCurrencyReqParams.getToken());
                        getChargeOrderStatusReqParams2.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
                        PollingModeInfo pollingModeInfo2 = pollingModeInfo;
                        pollingModeInfo2.finishTimes++;
                        PayResultPoller.this.doPollingForChargeResult(chargeCurrencyReqParams, getChargeOrderStatusReqParams2, pollingModeInfo2, pollerListener);
                    }
                }, ((long) i4) * 1000);
                return;
            }
            RLog.debug("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo params error");
        }
    }
}
