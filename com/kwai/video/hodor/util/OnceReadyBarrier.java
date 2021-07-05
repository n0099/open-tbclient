package com.kwai.video.hodor.util;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class OnceReadyBarrier {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsReady;
    public final Object mReadyLock;

    public OnceReadyBarrier() {
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
        this.mIsReady = false;
        this.mReadyLock = new Object();
    }

    public void setReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this.mReadyLock) {
                this.mIsReady = true;
                this.mReadyLock.notifyAll();
            }
            Timber.d("setReady", new Object[0]);
        }
    }

    public void waitReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (!this.mIsReady) {
                synchronized (this.mReadyLock) {
                    try {
                        Timber.d("waitReady to wait, " + Log.getStackTraceString(new Throwable()), new Object[0]);
                        this.mReadyLock.wait();
                        Timber.d("waitReady finish wait", new Object[0]);
                    } catch (InterruptedException e2) {
                        Timber.e("[waitReady] get InterruptedException, continue to wait anyway", new Object[0]);
                        e2.printStackTrace();
                    }
                }
            }
            Timber.i("waitReady finish", new Object[0]);
        }
    }
}
