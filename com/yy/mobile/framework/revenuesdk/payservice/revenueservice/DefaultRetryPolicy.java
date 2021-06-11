package com.yy.mobile.framework.revenuesdk.payservice.revenueservice;

import android.os.Handler;
import android.os.Looper;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes7.dex */
public abstract class DefaultRetryPolicy implements RetryPolicy {
    public static final int CANCEL = -1;
    public static final int DEFAULT_INTERVAL_MS = 3000;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_RETRY_TYPE = 0;
    public static final int DEFAULT_TIME_OUT_MS = 2500;
    public static final int FINISH = 1;
    public static final int RUNNING = 0;
    public static final String TAG = "DefaultRetryPolicy";
    public int mCurrentRetryCount;
    public Handler mHander;
    public final int mIntervalMs;
    public final int mMaxNumRetries;
    public final int mRetryType;
    public volatile int mStatus;
    public int mTimeoutMs;

    public DefaultRetryPolicy() {
        this(new Handler(Looper.getMainLooper()), 2500, 1, 3000, 0);
    }

    private boolean hasAttemptRemaining() {
        return this.mCurrentRetryCount < this.mMaxNumRetries;
    }

    public void call() {
        this.mCurrentRetryCount = 1;
        this.mStatus = 0;
        this.mHander.post(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.4
            @Override // java.lang.Runnable
            public void run() {
                DefaultRetryPolicy.this.onRetry();
            }
        });
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void cancel() {
        this.mStatus = -1;
        RLog.info(TAG, QueryResponse.Options.CANCEL);
    }

    public void done() {
        this.mStatus = 1;
        RLog.info(TAG, AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
    }

    public int getCurrentRetryCount() {
        return this.mCurrentRetryCount;
    }

    public abstract void onRetry();

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void retry() {
        RLog.info(TAG, "retry mTimeoutMs=" + this.mTimeoutMs + ", mMaxNumRetries=" + this.mMaxNumRetries + ",mIntervalMs=" + this.mIntervalMs);
        if (this.mStatus != 0) {
            return;
        }
        if (hasAttemptRemaining()) {
            if (this.mRetryType == 1) {
                int i2 = this.mCurrentRetryCount + 1;
                this.mCurrentRetryCount = i2;
                if (i2 <= this.mMaxNumRetries / 2) {
                    this.mHander.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RLog.info(DefaultRetryPolicy.TAG, "retry currentRetryCount=" + DefaultRetryPolicy.this.mCurrentRetryCount);
                            DefaultRetryPolicy.this.onRetry();
                        }
                    }, this.mIntervalMs);
                    return;
                } else {
                    this.mHander.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.2
                        @Override // java.lang.Runnable
                        public void run() {
                            RLog.info(DefaultRetryPolicy.TAG, "retry currentRetryCount=" + DefaultRetryPolicy.this.mCurrentRetryCount);
                            DefaultRetryPolicy.this.onRetry();
                        }
                    }, 60000L);
                    return;
                }
            }
            this.mCurrentRetryCount++;
            this.mHander.postDelayed(new Runnable() { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.3
                @Override // java.lang.Runnable
                public void run() {
                    RLog.info(DefaultRetryPolicy.TAG, "retry currentRetryCount=" + DefaultRetryPolicy.this.mCurrentRetryCount);
                    DefaultRetryPolicy.this.onRetry();
                }
            }, this.mIntervalMs);
            return;
        }
        retryCountExhaust();
        RLog.info(TAG, "retryCountExhaust");
    }

    public DefaultRetryPolicy(Handler handler, int i2, int i3, int i4, int i5) {
        this.mStatus = 0;
        this.mHander = handler;
        this.mTimeoutMs = i2;
        this.mMaxNumRetries = i3;
        this.mIntervalMs = i4;
        this.mRetryType = i5;
    }
}
