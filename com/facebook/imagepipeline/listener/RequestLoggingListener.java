package com.facebook.imagepipeline.listener;

import android.os.SystemClock;
import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes2.dex */
public class RequestLoggingListener implements RequestListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "RequestLoggingListener";
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public final Map<Pair<String, String>, Long> mProducerStartTimeMap;
    @GuardedBy("this")
    public final Map<String, Long> mRequestStartTimeMap;

    public RequestLoggingListener() {
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
        this.mProducerStartTimeMap = new HashMap();
        this.mRequestStartTimeMap = new HashMap();
    }

    public static long getElapsedTime(@Nullable Long l, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, l, j2)) == null) {
            if (l != null) {
                return j2 - l.longValue();
            }
            return -1L;
        }
        return invokeLJ.longValue;
    }

    public static long getTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? SystemClock.uptimeMillis() : invokeV.longValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public void onDecoderFinishWithFailure(ImageRequest imageRequest, EncodedImage encodedImage, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, imageRequest, encodedImage, th, map) == null) {
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerEvent(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    FLog.v(TAG, "time %d: onProducerEvent: {requestId: %s, stage: %s, eventName: %s; elapsedTime: %d ms}", Long.valueOf(getTime()), str, str2, str3, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.get(Pair.create(str, str2)), getTime())));
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithCancellation(String str, String str2, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, map) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    Pair create = Pair.create(str, str2);
                    long time = getTime();
                    FLog.v(TAG, "time %d: onProducerFinishWithCancellation: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), map);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithFailure(String str, String str2, Throwable th, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, str, str2, th, map) == null) {
            synchronized (this) {
                if (FLog.isLoggable(5)) {
                    Pair create = Pair.create(str, str2);
                    long time = getTime();
                    FLog.w(TAG, th, "time %d: onProducerFinishWithFailure: {requestId: %s, stage: %s, elapsedTime: %d ms, extraMap: %s, throwable: %s}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), map, th.toString());
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerFinishWithSuccess(String str, String str2, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, map) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    Pair create = Pair.create(str, str2);
                    long time = getTime();
                    FLog.v(TAG, "time %d: onProducerFinishWithSuccess: {requestId: %s, producer: %s, elapsedTime: %d ms, extraMap: %s}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), map);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onProducerStart(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, str2) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    Pair<String, String> create = Pair.create(str, str2);
                    long time = getTime();
                    this.mProducerStartTimeMap.put(create, Long.valueOf(time));
                    FLog.v(TAG, "time %d: onProducerStart: {requestId: %s, producer: %s}", Long.valueOf(time), str, str2);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestCancellation(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    long time = getTime();
                    FLog.v(TAG, "time %d: onRequestCancellation: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(time), str, Long.valueOf(getElapsedTime(this.mRequestStartTimeMap.remove(str), time)));
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{imageRequest, str, th, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (FLog.isLoggable(5)) {
                    long time = getTime();
                    FLog.w(TAG, "time %d: onRequestFailure: {requestId: %s, elapsedTime: %d ms, throwable: %s}", Long.valueOf(time), str, Long.valueOf(getElapsedTime(this.mRequestStartTimeMap.remove(str), time)), th.toString());
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{imageRequest, obj, str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    FLog.v(TAG, "time %d: onRequestSubmit: {requestId: %s, callerContext: %s, isPrefetch: %b}", Long.valueOf(getTime()), str, obj, Boolean.valueOf(z));
                    this.mRequestStartTimeMap.put(str, Long.valueOf(getTime()));
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public synchronized void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048585, this, imageRequest, str, z) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    long time = getTime();
                    FLog.v(TAG, "time %d: onRequestSuccess: {requestId: %s, elapsedTime: %d ms}", Long.valueOf(time), str, Long.valueOf(getElapsedTime(this.mRequestStartTimeMap.remove(str), time)));
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public synchronized void onUltimateProducerReached(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048586, this, str, str2, z) == null) {
            synchronized (this) {
                if (FLog.isLoggable(2)) {
                    Pair create = Pair.create(str, str2);
                    long time = getTime();
                    FLog.v(TAG, "time %d: onUltimateProducerReached: {requestId: %s, producer: %s, elapsedTime: %d ms, success: %b}", Long.valueOf(time), str, str2, Long.valueOf(getElapsedTime(this.mProducerStartTimeMap.remove(create), time)), Boolean.valueOf(z));
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public boolean requiresExtraMap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) ? FLog.isLoggable(2) : invokeL.booleanValue;
    }
}
