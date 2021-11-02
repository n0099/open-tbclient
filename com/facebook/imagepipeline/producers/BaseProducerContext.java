package com.facebook.imagepipeline.producers;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
/* loaded from: classes11.dex */
public class BaseProducerContext implements ProducerContext {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Set<String> INITIAL_KEYS;
    public static final String ORIGIN_SUBCATEGORY_DEFAULT = "default";
    public transient /* synthetic */ FieldHolder $fh;
    @GuardedBy("this")
    public final List<ProducerContextCallbacks> mCallbacks;
    public final Object mCallerContext;
    public EncodedImageOrigin mEncodedImageOrigin;
    public final Map<String, Object> mExtras;
    public final String mId;
    public final ImagePipelineConfig mImagePipelineConfig;
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
    public final ProducerListener2 mProducerListener;
    @Nullable
    public final String mUiComponentId;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1228632190, "Lcom/facebook/imagepipeline/producers/BaseProducerContext;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1228632190, "Lcom/facebook/imagepipeline/producers/BaseProducerContext;");
                return;
            }
        }
        INITIAL_KEYS = ImmutableSet.of((Object[]) new String[]{"id", ProducerContext.ExtraKeys.SOURCE_URI});
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        this(imageRequest, str, null, producerListener2, obj, requestLevel, z, z2, priority, imagePipelineConfig);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {imageRequest, str, producerListener2, obj, requestLevel, Boolean.valueOf(z), Boolean.valueOf(z2), priority, imagePipelineConfig};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ImageRequest) objArr2[0], (String) objArr2[1], (String) objArr2[2], (ProducerListener2) objArr2[3], objArr2[4], (ImageRequest.RequestLevel) objArr2[5], ((Boolean) objArr2[6]).booleanValue(), ((Boolean) objArr2[7]).booleanValue(), (Priority) objArr2[8], (ImagePipelineConfig) objArr2[9]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void callOnCancellationRequested(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, list) == null) || list == null) {
            return;
        }
        for (ProducerContextCallbacks producerContextCallbacks : list) {
            producerContextCallbacks.onCancellationRequested();
        }
    }

    public static void callOnIsIntermediateResultExpectedChanged(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) || list == null) {
            return;
        }
        for (ProducerContextCallbacks producerContextCallbacks : list) {
            producerContextCallbacks.onIsIntermediateResultExpectedChanged();
        }
    }

    public static void callOnIsPrefetchChanged(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, list) == null) || list == null) {
            return;
        }
        for (ProducerContextCallbacks producerContextCallbacks : list) {
            producerContextCallbacks.onIsPrefetchChanged();
        }
    }

    public static void callOnPriorityChanged(@Nullable List<ProducerContextCallbacks> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, list) == null) || list == null) {
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
    public EncodedImageOrigin getEncodedImageOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEncodedImageOrigin : (EncodedImageOrigin) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @Nullable
    public <T> T getExtra(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) ? (T) this.mExtras.get(str) : (T) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Map<String, Object> getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mExtras : (Map) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mId : (String) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImagePipelineConfig getImagePipelineConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mImagePipelineConfig : (ImagePipelineConfig) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest getImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mImageRequest : (ImageRequest) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mLowestPermittedRequestLevel : (ImageRequest.RequestLevel) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized Priority getPriority() {
        InterceptResult invokeV;
        Priority priority;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                priority = this.mPriority;
            }
            return priority;
        }
        return (Priority) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ProducerListener2 getProducerListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mProducerListener : (ProducerListener2) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @Nullable
    public String getUiComponentId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.mUiComponentId : (String) invokeV.objValue;
    }

    public synchronized boolean isCancelled() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            synchronized (this) {
                z = this.mIsPrefetch;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putExtras(@Nullable Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, map) == null) || map == null) {
            return;
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            setExtra(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, str, str2) == null) {
            this.mExtras.put("origin", str);
            this.mExtras.put(ProducerContext.ExtraKeys.ORIGIN_SUBCATEGORY, str2);
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void setEncodedImageOrigin(EncodedImageOrigin encodedImageOrigin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, encodedImageOrigin) == null) {
            this.mEncodedImageOrigin = encodedImageOrigin;
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void setExtra(String str, @Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, obj) == null) || INITIAL_KEYS.contains(str)) {
            return;
        }
        this.mExtras.put(str, obj);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> setIsIntermediateResultExpectedNoCallbacks(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048599, this, z)) == null) {
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
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, priority)) == null) {
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

    public BaseProducerContext(ImageRequest imageRequest, String str, @Nullable String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfig imagePipelineConfig) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {imageRequest, str, str2, producerListener2, obj, requestLevel, Boolean.valueOf(z), Boolean.valueOf(z2), priority, imagePipelineConfig};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mEncodedImageOrigin = EncodedImageOrigin.NOT_SET;
        this.mImageRequest = imageRequest;
        this.mId = str;
        HashMap hashMap = new HashMap();
        this.mExtras = hashMap;
        hashMap.put("id", this.mId);
        this.mExtras.put(ProducerContext.ExtraKeys.SOURCE_URI, imageRequest == null ? "null-request" : imageRequest.getSourceUri());
        this.mUiComponentId = str2;
        this.mProducerListener = producerListener2;
        this.mCallerContext = obj;
        this.mLowestPermittedRequestLevel = requestLevel;
        this.mIsPrefetch = z;
        this.mPriority = priority;
        this.mIsIntermediateResultExpected = z2;
        this.mIsCancelled = false;
        this.mCallbacks = new ArrayList();
        this.mImagePipelineConfig = imagePipelineConfig;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    @Nullable
    public <E> E getExtra(String str, E e2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, e2)) == null) {
            E e3 = (E) this.mExtras.get(str);
            return e3 == null ? e2 : e3;
        }
        return (E) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void putOriginExtra(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            putOriginExtra(str, "default");
        }
    }
}
