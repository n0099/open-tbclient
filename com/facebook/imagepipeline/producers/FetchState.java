package com.facebook.imagepipeline.producers;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.common.BytesRange;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class FetchState {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Consumer mConsumer;
    public final ProducerContext mContext;
    public long mLastIntermediateResultTimeMs;
    public int mOnNewResultStatusFlags;
    @Nullable
    public BytesRange mResponseBytesRange;

    public FetchState(Consumer consumer, ProducerContext producerContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {consumer, producerContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConsumer = consumer;
        this.mContext = producerContext;
        this.mLastIntermediateResultTimeMs = 0L;
    }

    public Consumer getConsumer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mConsumer;
        }
        return (Consumer) invokeV.objValue;
    }

    public ProducerContext getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mContext;
        }
        return (ProducerContext) invokeV.objValue;
    }

    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mContext.getId();
        }
        return (String) invokeV.objValue;
    }

    public long getLastIntermediateResultTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mLastIntermediateResultTimeMs;
        }
        return invokeV.longValue;
    }

    public ProducerListener2 getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mContext.getProducerListener();
        }
        return (ProducerListener2) invokeV.objValue;
    }

    public String getLogTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mContext.getImageRequest().mLogTag;
        }
        return (String) invokeV.objValue;
    }

    public Map getNetRequestHeader() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mContext.getImageRequest().getNetRequestHeader();
        }
        return (Map) invokeV.objValue;
    }

    public int getOnNewResultStatusFlags() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mOnNewResultStatusFlags;
        }
        return invokeV.intValue;
    }

    @Nullable
    public BytesRange getResponseBytesRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mResponseBytesRange;
        }
        return (BytesRange) invokeV.objValue;
    }

    public String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mContext.getImageRequest().mTag;
        }
        return (String) invokeV.objValue;
    }

    public Uri getUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mContext.getImageRequest().getSourceUri();
        }
        return (Uri) invokeV.objValue;
    }

    public void setLastIntermediateResultTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.mLastIntermediateResultTimeMs = j;
        }
    }

    public void setOnNewResultStatusFlags(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mOnNewResultStatusFlags = i;
        }
    }

    public void setResponseBytesRange(BytesRange bytesRange) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bytesRange) == null) {
            this.mResponseBytesRange = bytesRange;
        }
    }
}
