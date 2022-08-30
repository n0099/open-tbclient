package com.facebook.drawee.backends.pipeline.info;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class ImagePerfState {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public Object mCallerContext;
    @Nullable
    public String mComponentTag;
    public long mControllerCancelTimeMs;
    public long mControllerFailureTimeMs;
    public long mControllerFinalImageSetTimeMs;
    @Nullable
    public ImageRequest[] mControllerFirstAvailableImageRequests;
    @Nullable
    public String mControllerId;
    @Nullable
    public ImageRequest mControllerImageRequest;
    public long mControllerIntermediateImageSetTimeMs;
    @Nullable
    public ImageRequest mControllerLowResImageRequest;
    public long mControllerSubmitTimeMs;
    @Nullable
    public DimensionsInfo mDimensionsInfo;
    @Nullable
    public Throwable mErrorThrowable;
    @Nullable
    public ControllerListener2.Extras mExtraData;
    public long mImageDrawTimeMs;
    @Nullable
    public ImageInfo mImageInfo;
    public int mImageLoadStatus;
    public int mImageOrigin;
    @Nullable
    public ImageRequest mImageRequest;
    public long mImageRequestEndTimeMs;
    public long mImageRequestStartTimeMs;
    public long mInvisibilityEventTimeMs;
    public boolean mIsPrefetch;
    public int mOnScreenHeightPx;
    public int mOnScreenWidthPx;
    @Nullable
    public String mRequestId;
    @Nullable
    public String mUltimateProducerName;
    public long mVisibilityEventTimeMs;
    public int mVisibilityState;

    public ImagePerfState() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mControllerSubmitTimeMs = -1L;
        this.mControllerIntermediateImageSetTimeMs = -1L;
        this.mControllerFinalImageSetTimeMs = -1L;
        this.mControllerFailureTimeMs = -1L;
        this.mControllerCancelTimeMs = -1L;
        this.mImageRequestStartTimeMs = -1L;
        this.mImageRequestEndTimeMs = -1L;
        this.mImageOrigin = 1;
        this.mOnScreenWidthPx = -1;
        this.mOnScreenHeightPx = -1;
        this.mImageLoadStatus = -1;
        this.mVisibilityState = -1;
        this.mVisibilityEventTimeMs = -1L;
        this.mInvisibilityEventTimeMs = -1L;
        this.mImageDrawTimeMs = -1L;
    }

    @Nullable
    public DimensionsInfo getDimensionsInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDimensionsInfo : (DimensionsInfo) invokeV.objValue;
    }

    @Nullable
    public Object getExtraData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mExtraData : invokeV.objValue;
    }

    public long getImageDrawTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mImageDrawTimeMs : invokeV.longValue;
    }

    public int getImageLoadStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mImageLoadStatus : invokeV.intValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mRequestId = null;
            this.mImageRequest = null;
            this.mCallerContext = null;
            this.mImageInfo = null;
            this.mControllerImageRequest = null;
            this.mControllerLowResImageRequest = null;
            this.mControllerFirstAvailableImageRequests = null;
            this.mImageOrigin = 1;
            this.mUltimateProducerName = null;
            this.mIsPrefetch = false;
            this.mOnScreenWidthPx = -1;
            this.mOnScreenHeightPx = -1;
            this.mErrorThrowable = null;
            this.mImageLoadStatus = -1;
            this.mVisibilityState = -1;
            this.mComponentTag = null;
            this.mDimensionsInfo = null;
            this.mExtraData = null;
            resetPointsTimestamps();
        }
    }

    public void resetPointsTimestamps() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mImageRequestStartTimeMs = -1L;
            this.mImageRequestEndTimeMs = -1L;
            this.mControllerSubmitTimeMs = -1L;
            this.mControllerFinalImageSetTimeMs = -1L;
            this.mControllerFailureTimeMs = -1L;
            this.mControllerCancelTimeMs = -1L;
            this.mVisibilityEventTimeMs = -1L;
            this.mInvisibilityEventTimeMs = -1L;
            this.mImageDrawTimeMs = -1L;
        }
    }

    public void setCallerContext(@Nullable Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
            this.mCallerContext = obj;
        }
    }

    public void setComponentTag(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.mComponentTag = str;
        }
    }

    public void setControllerCancelTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.mControllerCancelTimeMs = j;
        }
    }

    public void setControllerFailureTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.mControllerFailureTimeMs = j;
        }
    }

    public void setControllerFinalImageSetTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.mControllerFinalImageSetTimeMs = j;
        }
    }

    public void setControllerId(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mControllerId = str;
        }
    }

    public void setControllerImageRequests(@Nullable ImageRequest imageRequest, @Nullable ImageRequest imageRequest2, @Nullable ImageRequest[] imageRequestArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, imageRequest, imageRequest2, imageRequestArr) == null) {
            this.mControllerImageRequest = imageRequest;
            this.mControllerLowResImageRequest = imageRequest2;
            this.mControllerFirstAvailableImageRequests = imageRequestArr;
        }
    }

    public void setControllerIntermediateImageSetTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048589, this, j) == null) {
            this.mControllerIntermediateImageSetTimeMs = j;
        }
    }

    public void setControllerSubmitTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
            this.mControllerSubmitTimeMs = j;
        }
    }

    public void setDimensionsInfo(DimensionsInfo dimensionsInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, dimensionsInfo) == null) {
            this.mDimensionsInfo = dimensionsInfo;
        }
    }

    public void setErrorThrowable(@Nullable Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, th) == null) {
            this.mErrorThrowable = th;
        }
    }

    public void setExtraData(@Nullable ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, extras) == null) {
            this.mExtraData = extras;
        }
    }

    public void setImageDrawTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.mImageDrawTimeMs = j;
        }
    }

    public void setImageInfo(@Nullable ImageInfo imageInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, imageInfo) == null) {
            this.mImageInfo = imageInfo;
        }
    }

    public void setImageLoadStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.mImageLoadStatus = i;
        }
    }

    public void setImageOrigin(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.mImageOrigin = i;
        }
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, imageRequest) == null) {
            this.mImageRequest = imageRequest;
        }
    }

    public void setImageRequestEndTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.mImageRequestEndTimeMs = j;
        }
    }

    public void setImageRequestStartTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.mImageRequestStartTimeMs = j;
        }
    }

    public void setInvisibilityEventTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.mInvisibilityEventTimeMs = j;
        }
    }

    public void setOnScreenHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.mOnScreenHeightPx = i;
        }
    }

    public void setOnScreenWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.mOnScreenWidthPx = i;
        }
    }

    public void setPrefetch(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.mIsPrefetch = z;
        }
    }

    public void setRequestId(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.mRequestId = str;
        }
    }

    public void setUltimateProducerName(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.mUltimateProducerName = str;
        }
    }

    public void setVisibilityEventTimeMs(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            this.mVisibilityEventTimeMs = j;
        }
    }

    public void setVisible(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.mVisibilityState = z ? 1 : 2;
        }
    }

    public ImagePerfData snapshot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? new ImagePerfData(this.mControllerId, this.mRequestId, this.mImageRequest, this.mCallerContext, this.mImageInfo, this.mControllerImageRequest, this.mControllerLowResImageRequest, this.mControllerFirstAvailableImageRequests, this.mControllerSubmitTimeMs, this.mControllerIntermediateImageSetTimeMs, this.mControllerFinalImageSetTimeMs, this.mControllerFailureTimeMs, this.mControllerCancelTimeMs, this.mImageRequestStartTimeMs, this.mImageRequestEndTimeMs, this.mImageOrigin, this.mUltimateProducerName, this.mIsPrefetch, this.mOnScreenWidthPx, this.mOnScreenHeightPx, this.mErrorThrowable, this.mVisibilityState, this.mVisibilityEventTimeMs, this.mInvisibilityEventTimeMs, this.mComponentTag, this.mImageDrawTimeMs, this.mDimensionsInfo, this.mExtraData) : (ImagePerfData) invokeV.objValue;
    }
}
