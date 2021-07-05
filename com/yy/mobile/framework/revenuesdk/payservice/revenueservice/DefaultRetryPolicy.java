package com.yy.mobile.framework.revenuesdk.payservice.revenueservice;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
/* loaded from: classes8.dex */
public abstract class DefaultRetryPolicy implements RetryPolicy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CANCEL = -1;
    public static final int DEFAULT_INTERVAL_MS = 3000;
    public static final int DEFAULT_MAX_RETRIES = 1;
    public static final int DEFAULT_RETRY_TYPE = 0;
    public static final int DEFAULT_TIME_OUT_MS = 2500;
    public static final int FINISH = 1;
    public static final int RUNNING = 0;
    public static final String TAG = "DefaultRetryPolicy";
    public transient /* synthetic */ FieldHolder $fh;
    public int mCurrentRetryCount;
    public Handler mHander;
    public final int mIntervalMs;
    public final int mMaxNumRetries;
    public final int mRetryType;
    public volatile int mStatus;
    public int mTimeoutMs;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultRetryPolicy() {
        this(new Handler(Looper.getMainLooper()), 2500, 1, 3000, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this((Handler) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private boolean hasAttemptRemaining() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.mCurrentRetryCount < this.mMaxNumRetries : invokeV.booleanValue;
    }

    public void call() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCurrentRetryCount = 1;
            this.mStatus = 0;
            this.mHander.post(new Runnable(this) { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ DefaultRetryPolicy this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
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
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.onRetry();
                    }
                }
            });
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mStatus = -1;
            RLog.info(TAG, QueryResponse.Options.CANCEL);
        }
    }

    public void done() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mStatus = 1;
            RLog.info(TAG, AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE);
        }
    }

    public int getCurrentRetryCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCurrentRetryCount : invokeV.intValue;
    }

    public abstract void onRetry();

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.RetryPolicy
    public void retry() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            RLog.info(TAG, "retry mTimeoutMs=" + this.mTimeoutMs + ", mMaxNumRetries=" + this.mMaxNumRetries + ",mIntervalMs=" + this.mIntervalMs);
            if (this.mStatus != 0) {
                return;
            }
            if (hasAttemptRemaining()) {
                if (this.mRetryType == 1) {
                    int i2 = this.mCurrentRetryCount + 1;
                    this.mCurrentRetryCount = i2;
                    if (i2 <= this.mMaxNumRetries / 2) {
                        this.mHander.postDelayed(new Runnable(this) { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ DefaultRetryPolicy this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    RLog.info(DefaultRetryPolicy.TAG, "retry currentRetryCount=" + this.this$0.mCurrentRetryCount);
                                    this.this$0.onRetry();
                                }
                            }
                        }, this.mIntervalMs);
                        return;
                    } else {
                        this.mHander.postDelayed(new Runnable(this) { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.2
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ DefaultRetryPolicy this$0;

                            {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this};
                                    interceptable2.invokeUnInit(65536, newInitContext);
                                    int i3 = newInitContext.flag;
                                    if ((i3 & 1) != 0) {
                                        int i4 = i3 & 2;
                                        newInitContext.thisArg = this;
                                        interceptable2.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$0 = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                    RLog.info(DefaultRetryPolicy.TAG, "retry currentRetryCount=" + this.this$0.mCurrentRetryCount);
                                    this.this$0.onRetry();
                                }
                            }
                        }, 60000L);
                        return;
                    }
                }
                this.mCurrentRetryCount++;
                this.mHander.postDelayed(new Runnable(this) { // from class: com.yy.mobile.framework.revenuesdk.payservice.revenueservice.DefaultRetryPolicy.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DefaultRetryPolicy this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            RLog.info(DefaultRetryPolicy.TAG, "retry currentRetryCount=" + this.this$0.mCurrentRetryCount);
                            this.this$0.onRetry();
                        }
                    }
                }, this.mIntervalMs);
                return;
            }
            retryCountExhaust();
            RLog.info(TAG, "retryCountExhaust");
        }
    }

    public DefaultRetryPolicy(Handler handler, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStatus = 0;
        this.mHander = handler;
        this.mTimeoutMs = i2;
        this.mMaxNumRetries = i3;
        this.mIntervalMs = i4;
        this.mRetryType = i5;
    }
}
