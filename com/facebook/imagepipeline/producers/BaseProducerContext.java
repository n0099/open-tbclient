package com.facebook.imagepipeline.producers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes6.dex */
public class BaseProducerContext implements ProducerContext {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public final List<ProducerContextCallbacks> mCallbacks;
    public final Object mCallerContext;
    public final String mId;
    public final ImageRequest mImageRequest;
    @GuardedBy("this")
    public boolean mIsCancelled;
    @GuardedBy("this")
    public boolean mIsIntermediateResultExpected;
    @GuardedBy("this")
    public boolean mIsPrefetch;
    public final ImageRequest.RequestLevel mLowestPermittedRequestLevel;
    @GuardedBy("this")
    public Priority mPriority;
    public final ProducerListener mProducerListener;

    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener producerListener, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageRequest, str, producerListener, obj, requestLevel, Boolean.valueOf(z), Boolean.valueOf(z2), priority};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mImageRequest = imageRequest;
        this.mId = str;
        this.mProducerListener = producerListener;
        this.mCallerContext = obj;
        this.mLowestPermittedRequestLevel = requestLevel;
        this.mIsPrefetch = z;
        this.mPriority = priority;
        this.mIsIntermediateResultExpected = z2;
        this.mIsCancelled = false;
        this.mCallbacks = new ArrayList();
    }

    public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, list) == null) || list == null) {
            return;
        }
        for (ProducerContextCallbacks producerContextCallbacks : list) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, list) == null) || list == null) {
            return;
        }
        for (ProducerContextCallbacks producerContextCallbacks : list) {
            producerContextCallbacks.onIsIntermediateResultExpectedChanged();
        }
    }

    public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, list) == null) || list == null) {
            return;
        }
        for (ProducerContextCallbacks producerContextCallbacks : list) {
            producerContextCallbacks.onIsPrefetchChanged();
        }
    }

    public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) || list == null) {
            return;
        }
        for (ProducerContextCallbacks producerContextCallbacks : list) {
            producerContextCallbacks.onPriorityChanged();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void addCallbacks(ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, producerContextCallbacks) == null) {
            synchronized (this) {
                this.mCallbacks.add(producerContextCallbacks);
                z = this.mIsCancelled;
            }
            if (z) {
                producerContextCallbacks.onCancellationRequested();
            }
        }
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            callOnCancellationRequested(cancelNoCallbacks());
        }
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> cancelNoCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                if (this.mIsCancelled) {
                    return null;
                }
                this.mIsCancelled = true;
                return new ArrayList(this.mCallbacks);
            }
        }
        return (List) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Object getCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mCallerContext : invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest getImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mImageRequest : (ImageRequest) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ProducerListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mProducerListener : (ProducerListener) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLowestPermittedRequestLevel : (ImageRequest.RequestLevel) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized Priority getPriority() {
        InterceptResult invokeV;
        Priority priority;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                priority = this.mPriority;
            }
            return priority;
        }
        return (Priority) invokeV.objValue;
    }

    public synchronized boolean isCancelled() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            synchronized (this) {
                z = this.mIsCancelled;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isIntermediateResultExpected() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                z = this.mIsIntermediateResultExpected;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean isPrefetch() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            synchronized (this) {
                z = this.mIsPrefetch;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            synchronized (this) {
                if (z == this.mIsIntermediateResultExpected) {
                    return null;
                }
                this.mIsIntermediateResultExpected = z;
                return new ArrayList(this.mCallbacks);
            }
        }
        return (List) invokeZ.objValue;
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsPrefetchNoCallbacks(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048589, this, z)) == null) {
            synchronized (this) {
                if (z == this.mIsPrefetch) {
                    return null;
                }
                this.mIsPrefetch = z;
                return new ArrayList(this.mCallbacks);
            }
        }
        return (List) invokeZ.objValue;
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setPriorityNoCallbacks(Priority priority) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, priority)) == null) {
            synchronized (this) {
                if (priority == this.mPriority) {
                    return null;
                }
                this.mPriority = priority;
                return new ArrayList(this.mCallbacks);
            }
        }
        return (List) invokeL.objValue;
    }
}
