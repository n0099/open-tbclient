package com.facebook.drawee.backends.pipeline.info;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Objects;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class ImagePerfData {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final Object mCallerContext;
    @Nullable
    public final String mComponentTag;
    public final long mControllerCancelTimeMs;
    public final long mControllerFailureTimeMs;
    public final long mControllerFinalImageSetTimeMs;
    @Nullable
    public final ImageRequest[] mControllerFirstAvailableImageRequests;
    @Nullable
    public final String mControllerId;
    @Nullable
    public final ImageRequest mControllerImageRequest;
    public final long mControllerIntermediateImageSetTimeMs;
    @Nullable
    public final ImageRequest mControllerLowResImageRequest;
    public final long mControllerSubmitTimeMs;
    @Nullable
    public final DimensionsInfo mDimensionsInfo;
    @Nullable
    public final Throwable mErrorThrowable;
    @Nullable
    public final ControllerListener2.Extras mExtraData;
    public final long mImageDrawTimeMs;
    @Nullable
    public final ImageInfo mImageInfo;
    public final int mImageOrigin;
    @Nullable
    public final ImageRequest mImageRequest;
    public final long mImageRequestEndTimeMs;
    public final long mImageRequestStartTimeMs;
    public final long mInvisibilityEventTimeMs;
    public final boolean mIsPrefetch;
    public final int mOnScreenHeightPx;
    public final int mOnScreenWidthPx;
    @Nullable
    public final String mRequestId;
    @Nullable
    public final String mUltimateProducerName;
    public final long mVisibilityEventTimeMs;
    public final int mVisibilityState;

    public ImagePerfData(@Nullable String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable ImageInfo imageInfo, @Nullable ImageRequest imageRequest2, @Nullable ImageRequest imageRequest3, @Nullable ImageRequest[] imageRequestArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i2, @Nullable String str3, boolean z, int i3, int i4, @Nullable Throwable th, int i5, long j8, long j9, @Nullable String str4, long j10, @Nullable DimensionsInfo dimensionsInfo, @Nullable ControllerListener2.Extras extras) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, imageRequest, obj, imageInfo, imageRequest2, imageRequest3, imageRequestArr, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Integer.valueOf(i2), str3, Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), th, Integer.valueOf(i5), Long.valueOf(j8), Long.valueOf(j9), str4, Long.valueOf(j10), dimensionsInfo, extras};
            interceptable.invokeUnInit(65536, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mControllerId = str;
        this.mRequestId = str2;
        this.mImageRequest = imageRequest;
        this.mCallerContext = obj;
        this.mImageInfo = imageInfo;
        this.mControllerImageRequest = imageRequest2;
        this.mControllerLowResImageRequest = imageRequest3;
        this.mControllerFirstAvailableImageRequests = imageRequestArr;
        this.mControllerSubmitTimeMs = j;
        this.mControllerIntermediateImageSetTimeMs = j2;
        this.mControllerFinalImageSetTimeMs = j3;
        this.mControllerFailureTimeMs = j4;
        this.mControllerCancelTimeMs = j5;
        this.mImageRequestStartTimeMs = j6;
        this.mImageRequestEndTimeMs = j7;
        this.mImageOrigin = i2;
        this.mUltimateProducerName = str3;
        this.mIsPrefetch = z;
        this.mOnScreenWidthPx = i3;
        this.mOnScreenHeightPx = i4;
        this.mErrorThrowable = th;
        this.mVisibilityState = i5;
        this.mVisibilityEventTimeMs = j8;
        this.mInvisibilityEventTimeMs = j9;
        this.mComponentTag = str4;
        this.mImageDrawTimeMs = j10;
        this.mDimensionsInfo = dimensionsInfo;
        this.mExtraData = extras;
    }

    public String createDebugString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Objects.toStringHelper(this).add("controller ID", this.mControllerId).add("request ID", this.mRequestId).add("controller image request", this.mControllerImageRequest).add("controller low res image request", this.mControllerLowResImageRequest).add("controller first available image requests", this.mControllerFirstAvailableImageRequests).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add("origin", ImageOriginUtils.toString(this.mImageOrigin)).add("ultimateProducerName", this.mUltimateProducerName).add(PrefetchEvent.MODULE, this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", this.mImageRequest).add("image info", this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).add("component tag", this.mComponentTag).add("visibility event", this.mVisibilityEventTimeMs).add("invisibility event", this.mInvisibilityEventTimeMs).add("image draw event", this.mImageDrawTimeMs).add("dimensions info", this.mDimensionsInfo).add("extra data", this.mExtraData).toString() : (String) invokeV.objValue;
    }

    @Nullable
    public Object getCallerContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCallerContext : invokeV.objValue;
    }

    @Nullable
    public String getComponentTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mComponentTag : (String) invokeV.objValue;
    }

    public long getControllerFailureTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mControllerFailureTimeMs : invokeV.longValue;
    }

    public long getControllerFinalImageSetTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mControllerFinalImageSetTimeMs : invokeV.longValue;
    }

    @Nullable
    public ImageRequest[] getControllerFirstAvailableImageRequests() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mControllerFirstAvailableImageRequests : (ImageRequest[]) invokeV.objValue;
    }

    @Nullable
    public String getControllerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mControllerId : (String) invokeV.objValue;
    }

    @Nullable
    public ImageRequest getControllerImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mControllerImageRequest : (ImageRequest) invokeV.objValue;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mControllerIntermediateImageSetTimeMs : invokeV.longValue;
    }

    @Nullable
    public ImageRequest getControllerLowResImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mControllerLowResImageRequest : (ImageRequest) invokeV.objValue;
    }

    public long getControllerSubmitTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mControllerSubmitTimeMs : invokeV.longValue;
    }

    @Nullable
    public DimensionsInfo getDimensionsInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mDimensionsInfo : (DimensionsInfo) invokeV.objValue;
    }

    @Nullable
    public Throwable getErrorThrowable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mErrorThrowable : (Throwable) invokeV.objValue;
    }

    @Nullable
    public ControllerListener2.Extras getExtraData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mExtraData : (ControllerListener2.Extras) invokeV.objValue;
    }

    public long getFinalImageLoadTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (getImageRequestEndTimeMs() == -1 || getImageRequestStartTimeMs() == -1) {
                return -1L;
            }
            return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
        }
        return invokeV.longValue;
    }

    public long getImageDrawTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mImageDrawTimeMs : invokeV.longValue;
    }

    @Nullable
    public ImageInfo getImageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mImageInfo : (ImageInfo) invokeV.objValue;
    }

    public int getImageOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mImageOrigin : invokeV.intValue;
    }

    @Nullable
    public ImageRequest getImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mImageRequest : (ImageRequest) invokeV.objValue;
    }

    public long getImageRequestEndTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mImageRequestEndTimeMs : invokeV.longValue;
    }

    public long getImageRequestStartTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mImageRequestStartTimeMs : invokeV.longValue;
    }

    public long getIntermediateImageLoadTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (getControllerIntermediateImageSetTimeMs() == -1 || getControllerSubmitTimeMs() == -1) {
                return -1L;
            }
            return getControllerIntermediateImageSetTimeMs() - getControllerSubmitTimeMs();
        }
        return invokeV.longValue;
    }

    public long getInvisibilityEventTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mInvisibilityEventTimeMs : invokeV.longValue;
    }

    public int getOnScreenHeightPx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mOnScreenHeightPx : invokeV.intValue;
    }

    public int getOnScreenWidthPx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.mOnScreenWidthPx : invokeV.intValue;
    }

    @Nullable
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.mRequestId : (String) invokeV.objValue;
    }

    @Nullable
    public String getUltimateProducerName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mUltimateProducerName : (String) invokeV.objValue;
    }

    public long getVisibilityEventTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mVisibilityEventTimeMs : invokeV.longValue;
    }

    public int getVisibilityState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mVisibilityState : invokeV.intValue;
    }

    public boolean isPrefetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.mIsPrefetch : invokeV.booleanValue;
    }
}
