package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.b.a;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.PayCallBackBean;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.utils.ThreadPool;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import com.yy.mobile.framework.revenuesdk.payservice.IH5PayActivityVisit;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayFlowEventType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes9.dex */
public class H5PayManager {
    public static final int QUERY_RESULT_FAIL = 2;
    public static final int QUERY_RESULT_SUCCESS = 1;
    public static final int RECHARGE_VERIFY_ORDER_INTERVAL = 1000;
    public static final int RECHARGE_VERIFY_ORDER_RETRY_MAX = 3;
    public static final String TAG = "H5PayManager";
    public static H5PayManager instance;
    public WeakReference<Activity> mAct;
    public IH5PayActivityVisit mH5PayActivityVisit;
    public Class mPayWebViewActivityClass;
    public String mReadyVerifyOrderId = null;
    public Map<String, H5PayVerifyTask> mOrderVerifyTaskMap = new HashMap();
    public Handler mHandler = new Handler(Looper.getMainLooper());

    public static H5PayManager getInstance() {
        if (instance == null) {
            synchronized (H5PayManager.class) {
                if (instance == null) {
                    instance = new H5PayManager();
                }
            }
        }
        return instance;
    }

    public void release() {
        RLog.info(TAG, "release()");
        this.mAct = null;
        this.mOrderVerifyTaskMap.clear();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public synchronized void verifyPayOrder() {
        RLog.info(TAG, "try verifyPayOrder");
        if (TextUtils.isEmpty(this.mReadyVerifyOrderId)) {
            RLog.error(TAG, "try verifyPayOrder error mReadyVerifyOrderId null", new Object[0]);
            return;
        }
        final String str = this.mReadyVerifyOrderId;
        this.mReadyVerifyOrderId = null;
        this.mHandler.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.1
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    H5PayManager.this.verifyOrder(str);
                } else {
                    RLog.error(H5PayManager.TAG, "postDelayed error newVerifyOrderId null", new Object[0]);
                }
            }
        }, 1000L);
    }

    public synchronized void setYYPayWebviewActClass(Class cls, IH5PayActivityVisit iH5PayActivityVisit) {
        RLog.info(TAG, "setYYPayWebviewActClass payWebviewActClass:" + cls + " h5PayActivityVisit:" + iH5PayActivityVisit);
        this.mPayWebViewActivityClass = cls;
        this.mH5PayActivityVisit = iH5PayActivityVisit;
    }

    private synchronized void doPay(Activity activity, String str, H5PayParams h5PayParams) {
        PayType payType;
        setReadyOrderId(str, h5PayParams);
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        this.mAct = weakReference;
        if (weakReference != null && weakReference.get() != null) {
            if (this.mPayWebViewActivityClass == null) {
                RLog.error(TAG, "doPay error mPayWebviewActClass null", new Object[0]);
                removeOrderVerifyTask(str);
                return;
            }
            try {
                Intent intent = new Intent(this.mAct.get(), this.mPayWebViewActivityClass);
                if (h5PayParams.payType != null) {
                    payType = h5PayParams.payType;
                } else {
                    payType = PayType.DXM_PAY_KJ;
                }
                if (PayType.MOCK_TEST_PAY.equals(payType)) {
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 3);
                    intent.putExtra(H5PayConstant.EXTRA_TITLE, "MOCK支付");
                } else if (PayType.DXM_PAY_KJ.equals(payType)) {
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 2);
                    intent.putExtra(H5PayConstant.EXTRA_TITLE, "银行卡支付");
                } else if (PayType.UNION_PAY.equals(payType)) {
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 4);
                    intent.putExtra(H5PayConstant.EXTRA_TITLE, "银联支付");
                } else if (PayType.DXM_PAY_H5.equals(payType)) {
                    intent.putExtra(H5PayConstant.EXTRA_LOCAL_PAGE_TYPE, 5);
                    intent.putExtra(H5PayConstant.EXTRA_TITLE, "度小满支付");
                }
                intent.putExtra(H5PayConstant.EXTRA_URL, h5PayParams.payBackBean.getPayLoad());
                intent.putExtra(H5PayConstant.EXTRA_APP_ID, h5PayParams.appId);
                intent.putExtra(H5PayConstant.EXTRA_USER_CHANNEL, h5PayParams.usedChannel);
                intent.putExtra(H5PayConstant.EXTRA_PAY_FLOW_TYPE_ID, h5PayParams.payFlowTypeId);
                if (this.mAct.get() != null) {
                    if (this.mH5PayActivityVisit != null) {
                        this.mH5PayActivityVisit.notifyPayFlowActivityVisit("H5Pay:" + str, h5PayParams.appId, h5PayParams.usedChannel, h5PayParams.payFlowTypeId);
                    }
                    this.mAct.get().startActivity(intent);
                } else {
                    removeOrderVerifyTask(str);
                    RLog.error(TAG, "dopay error mAct.get() null", new Object[0]);
                }
            } catch (Exception e) {
                RLog.error(TAG, "doPay exception:" + e.getLocalizedMessage(), new Object[0]);
                removeOrderVerifyTask(str);
            }
            return;
        }
        RLog.error(TAG, "doPay error mAct null", new Object[0]);
        removeOrderVerifyTask(str);
    }

    private synchronized void notifyPayResult(String str, final H5PayParams h5PayParams, GetChargeOrderStatusResult getChargeOrderStatusResult) {
        final CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
        currencyChargeMessage.appid = h5PayParams.appId;
        currencyChargeMessage.usedChannel = h5PayParams.usedChannel;
        currencyChargeMessage.orderId = str;
        currencyChargeMessage.uid = h5PayParams.uid;
        currencyChargeMessage.amount = getChargeOrderStatusResult.amount;
        currencyChargeMessage.currencyAmount = getChargeOrderStatusResult.currencyAmount;
        currencyChargeMessage.currencyType = getChargeOrderStatusResult.currencyType;
        currencyChargeMessage.status = getChargeOrderStatusResult.status;
        currencyChargeMessage.message = getChargeOrderStatusResult.message;
        currencyChargeMessage.finish = getChargeOrderStatusResult.finish;
        currencyChargeMessage.payChannel = h5PayParams.payChannel;
        currencyChargeMessage.payMethod = h5PayParams.payMethod;
        currencyChargeMessage.traceid = h5PayParams.traceid;
        currencyChargeMessage.cid = h5PayParams.cid;
        currencyChargeMessage.appClientExpand = h5PayParams.appClientExpand;
        if (getChargeOrderStatusResult.giftbags != null && getChargeOrderStatusResult.giftbags.size() > 0) {
            currencyChargeMessage.giftBagsInfo = getChargeOrderStatusResult.giftbags.get(0);
        }
        currencyChargeMessage.splitRecordItemList = getChargeOrderStatusResult.splitRecordItemList;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h5PayParams.payServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
        } else {
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.4
                @Override // java.lang.Runnable
                public void run() {
                    h5PayParams.payServiceCallback.onCurrencyChargeMessage(currencyChargeMessage);
                }
            });
        }
        reportPayOrderStatusEvent(h5PayParams, getChargeOrderStatusResult, currencyChargeMessage);
    }

    private void reportPayOrderStatusEvent(H5PayParams h5PayParams, GetChargeOrderStatusResult getChargeOrderStatusResult, CurrencyChargeMessage currencyChargeMessage) {
        IRevenue revenue = RevenueManager.instance().getRevenue(h5PayParams.appId, h5PayParams.usedChannel);
        if (revenue == null) {
            RLog.error(TAG, "getSDKReporter error revenue null appId:" + h5PayParams.appId + " usedChannel:" + h5PayParams.usedChannel, new Object[0]);
        } else if (revenue.getPayEventStatistic() != null) {
            revenue.getPayEventStatistic().reportPayFlowEvent(PayFlowEventType.paychargeorderStatus, getChargeOrderStatusResult.getStatus() + "", "h5 order result", currencyChargeMessage.orderId, "", currencyChargeMessage.cid + "", currencyChargeMessage.payChannel, currencyChargeMessage.traceid);
            RLog.info(TAG, "notifyPayResult reportPayFlowEvent status:" + getChargeOrderStatusResult.getStatus());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOrderVerifyAck(int i, String str, H5PayVerifyTask h5PayVerifyTask, GetChargeOrderStatusResult getChargeOrderStatusResult) {
        RLog.info(TAG, "onOrderVerifyAck orderId:" + str);
        synchronized (this) {
            H5PayParams h5PayParams = h5PayVerifyTask.h5PayParams;
            if (!this.mOrderVerifyTaskMap.containsKey(str)) {
                RLog.error(TAG, "invalid order. maybe user generate a new order, or user switched.", new Object[0]);
                return;
            }
            if (i == 1) {
                removeOrderVerifyTask(str);
                RLog.info(TAG, "verify order status success, notifyPayResult now.");
                notifyPayResult(str, h5PayParams, getChargeOrderStatusResult);
            } else {
                int i2 = h5PayVerifyTask.mCurrentRetryCount;
                int i3 = i2 + 1;
                h5PayVerifyTask.mCurrentRetryCount = i3;
                if (i2 < 3) {
                    h5PayVerifyTask.mCurrentRetryInterval = i3 * 1000;
                    verifyPayOrder(h5PayVerifyTask);
                    RLog.error(TAG, "retry verify order status again, count is " + h5PayVerifyTask.mCurrentRetryCount, new Object[0]);
                } else {
                    removeOrderVerifyTask(str);
                    RLog.error(TAG, "verify order status timeout! notifyPayResult", new Object[0]);
                    notifyPayResult(str, h5PayParams, getChargeOrderStatusResult);
                }
            }
        }
    }

    private synchronized void removeOrderVerifyTask(String str) {
        if (str == null) {
            return;
        }
        this.mOrderVerifyTaskMap.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyOrder(final String str) {
        final H5PayVerifyTask h5PayVerifyTask = this.mOrderVerifyTaskMap.get(str);
        H5PayParams h5PayParams = h5PayVerifyTask.h5PayParams;
        if (h5PayParams == null) {
            RLog.error(TAG, "verifyOrder error payParams null orderId:" + str, new Object[0]);
            return;
        }
        GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
        getChargeOrderStatusReqParams.setUid(h5PayParams.uid);
        getChargeOrderStatusReqParams.setAppId(h5PayParams.appId);
        getChargeOrderStatusReqParams.setUsedChannel(h5PayParams.usedChannel);
        getChargeOrderStatusReqParams.setSid(h5PayParams.sid);
        getChargeOrderStatusReqParams.setOrderId(str);
        getChargeOrderStatusReqParams.setToken(h5PayParams.token);
        getChargeOrderStatusReqParams.setTokenCallback(h5PayParams.tokenCallback);
        h5PayParams.appPayService.queryChargeOrderStatus(getChargeOrderStatusReqParams, new IResult<GetChargeOrderStatusResult>() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.3
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onFail(int i, String str2, PayCallBackBean payCallBackBean) {
                RLog.error(H5PayManager.TAG, "verifyOrder onFail code:" + i + " failReason:" + str2, new Object[0]);
                GetChargeOrderStatusResult getChargeOrderStatusResult = new GetChargeOrderStatusResult();
                getChargeOrderStatusResult.status = 0;
                getChargeOrderStatusResult.message = "onFail failReason:" + str2 + " code:" + i;
                H5PayManager.this.onOrderVerifyAck(2, str, h5PayVerifyTask, getChargeOrderStatusResult);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, PayCallBackBean payCallBackBean) {
                String str2;
                if (getChargeOrderStatusResult.getStatus() == 1) {
                    H5PayManager.this.onOrderVerifyAck(1, str, h5PayVerifyTask, getChargeOrderStatusResult);
                    str2 = "success";
                } else if (getChargeOrderStatusResult.finish) {
                    H5PayManager.this.onOrderVerifyAck(1, str, h5PayVerifyTask, getChargeOrderStatusResult);
                    str2 = a.g0;
                } else {
                    H5PayManager.this.onOrderVerifyAck(2, str, h5PayVerifyTask, getChargeOrderStatusResult);
                    str2 = "unknow";
                }
                RLog.info(H5PayManager.TAG, "verifyOrder onSuccess orderId:" + str + " orderStatus:" + str2);
            }
        });
    }

    private synchronized void verifyPayOrder(final H5PayVerifyTask h5PayVerifyTask) {
        if (h5PayVerifyTask == null) {
            RLog.error(TAG, "verifyPayOrder error orderVerifyTask null", new Object[0]);
            return;
        }
        int i = h5PayVerifyTask.mCurrentRetryInterval;
        int i2 = h5PayVerifyTask.mCurrentRetryCount;
        RLog.debug(TAG, "verifyPayOrder mCurrentRetryInterval:" + i + " mCurrentRetryCount:" + i2);
        this.mHandler.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.2
            @Override // java.lang.Runnable
            public void run() {
                H5PayVerifyTask h5PayVerifyTask2 = h5PayVerifyTask;
                if (h5PayVerifyTask2 != null && !TextUtils.isEmpty(h5PayVerifyTask2.mCurrentOrderId)) {
                    H5PayManager.this.verifyOrder(h5PayVerifyTask.mCurrentOrderId);
                }
            }
        }, (long) i);
    }

    public synchronized void requestH5Pay(Activity activity, String str, H5PayParams h5PayParams) {
        if (TextUtils.isEmpty(str)) {
            RLog.error(TAG, "requestH5Pay error orderId null", new Object[0]);
            return;
        }
        if (h5PayParams != null && h5PayParams.appPayService != null && h5PayParams.payServiceCallback != null) {
            doPay(activity, str, h5PayParams);
            return;
        }
        RLog.error(TAG, "requestH5Pay error payParams null", new Object[0]);
    }

    public synchronized void setReadyOrderId(String str, H5PayParams h5PayParams) {
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
        RLog.info(TAG, "setReadyOrderId order id is " + str);
    }
}
