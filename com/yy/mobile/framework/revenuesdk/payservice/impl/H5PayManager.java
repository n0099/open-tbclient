package com.yy.mobile.framework.revenuesdk.payservice.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
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
/* loaded from: classes7.dex */
public class H5PayManager {
    public static final int CODE_FAIL = 2;
    public static final int CODE_SUCCESS = 1;
    public static final int RECHARGE_VERIFY_ORDER_INTERVAL = 1000;
    public static final int RECHARGE_VERIFY_ORDER_RETRY_MAX = 3;
    public static final String TAG = "H5PayManager";
    public static H5PayManager instance;
    public WeakReference<Activity> mAct;
    public Class mPayWebViewActivityClass;
    public String mReadyVerifyOrderId = null;
    public Map<String, H5PayVerifyTask> mOrderVerifyTaskMap = new HashMap();
    public Handler mHandler = new Handler(Looper.getMainLooper());

    private synchronized void doPay(String str, H5PayParams h5PayParams) {
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

    private synchronized void notifyPollingForChargeResult(String str, final H5PayParams h5PayParams, ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult, boolean z) {
        ChargeCurrencyReqParams chargeCurrencyReqParams2 = h5PayParams.reqParams;
        if (chargeCurrencyReqParams2 == null) {
            RLog.error(TAG, "notifyPollingForChargeResult error reqParams null", new Object[0]);
            return;
        }
        final CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
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
            ThreadPool.getDefault().mainThreadIO().execute(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.4
                @Override // java.lang.Runnable
                public void run() {
                    h5PayParams.payInnerLogic.onCurrencyChargeMessage(currencyChargeMessage);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOrderVerifyAck(int i2, String str, H5PayVerifyTask h5PayVerifyTask, GetChargeOrderStatusResult getChargeOrderStatusResult, ChargeCurrencyReqParams chargeCurrencyReqParams) {
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
        final ChargeCurrencyReqParams chargeCurrencyReqParams = h5PayParams.reqParams;
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
        h5PayParams.appPayService.queryChargeOrderStatus(getChargeOrderStatusReqParams, new IResult<GetChargeOrderStatusResult>() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.3
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onFail(int i2, String str2, PayCallBackBean payCallBackBean) {
                H5PayManager.this.onOrderVerifyAck(2, str, h5PayVerifyTask, null, chargeCurrencyReqParams);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
            public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, PayCallBackBean payCallBackBean) {
                if (getChargeOrderStatusResult.getStatus() == 1) {
                    H5PayManager.this.onOrderVerifyAck(1, str, h5PayVerifyTask, getChargeOrderStatusResult, chargeCurrencyReqParams);
                } else if (getChargeOrderStatusResult.finish) {
                    H5PayManager.this.onOrderVerifyAck(1, str, h5PayVerifyTask, getChargeOrderStatusResult, chargeCurrencyReqParams);
                } else {
                    H5PayManager.this.onOrderVerifyAck(2, str, h5PayVerifyTask, getChargeOrderStatusResult, chargeCurrencyReqParams);
                }
            }
        });
    }

    public void onDisponse() {
        this.mAct = null;
    }

    public synchronized void requestH5Pay(String str, H5PayParams h5PayParams) {
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

    public synchronized void setActivity(Activity activity) {
        this.mAct = new WeakReference<>(activity);
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
        RLog.info(TAG, "new order id is " + str);
    }

    public synchronized void setYYPayWebviewActClass(Class cls) {
        this.mPayWebViewActivityClass = cls;
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

    private synchronized void verifyPayOrder(final H5PayVerifyTask h5PayVerifyTask) {
        if (h5PayVerifyTask == null) {
            RLog.error(TAG, "verifyPayOrder error orderVerifyTask null", new Object[0]);
            return;
        }
        int i2 = h5PayVerifyTask.mCurrentRetryInterval;
        int i3 = h5PayVerifyTask.mCurrentRetryCount;
        RLog.debug(TAG, "verifyPayOrder mCurrentRetryInterval:" + i2 + " mCurrentRetryCount:" + i3);
        this.mHandler.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayManager.2
            @Override // java.lang.Runnable
            public void run() {
                H5PayVerifyTask h5PayVerifyTask2 = h5PayVerifyTask;
                if (h5PayVerifyTask2 == null || TextUtils.isEmpty(h5PayVerifyTask2.mCurrentOrderId)) {
                    return;
                }
                H5PayManager.this.verifyOrder(h5PayVerifyTask.mCurrentOrderId);
            }
        }, (long) i2);
    }
}
