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
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
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
    public final String mControllerId;
    public final long mControllerIntermediateImageSetTimeMs;
    public final long mControllerSubmitTimeMs;
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
    public final long mVisibilityEventTimeMs;
    public final int mVisibilityState;

    public ImagePerfData(@Nullable String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable ImageInfo imageInfo, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i2, boolean z, int i3, int i4, int i5, long j9, long j10, @Nullable String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, imageRequest, obj, imageInfo, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7), Long.valueOf(j8), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Long.valueOf(j9), Long.valueOf(j10), str3};
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
        this.mControllerSubmitTimeMs = j2;
        this.mControllerIntermediateImageSetTimeMs = j3;
        this.mControllerFinalImageSetTimeMs = j4;
        this.mControllerFailureTimeMs = j5;
        this.mControllerCancelTimeMs = j6;
        this.mImageRequestStartTimeMs = j7;
        this.mImageRequestEndTimeMs = j8;
        this.mImageOrigin = i2;
        this.mIsPrefetch = z;
        this.mOnScreenWidthPx = i3;
        this.mOnScreenHeightPx = i4;
        this.mVisibilityState = i5;
        this.mVisibilityEventTimeMs = j9;
        this.mInvisibilityEventTimeMs = j10;
        this.mComponentTag = str3;
    }

    public String createDebugString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Objects.toStringHelper(this).add("controller ID", this.mControllerId).add("request ID", this.mRequestId).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add("origin", ImageOriginUtils.toString(this.mImageOrigin)).add(PrefetchEvent.MODULE, this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", this.mImageRequest).add("image info", this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).add("component tag", this.mComponentTag).toString() : (String) invokeV.objValue;
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
    public String getControllerId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mControllerId : (String) invokeV.objValue;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mControllerIntermediateImageSetTimeMs : invokeV.longValue;
    }

    public long getControllerSubmitTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mControllerSubmitTimeMs : invokeV.longValue;
    }

    public long getFinalImageLoadTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (getImageRequestEndTimeMs() == -1 || getImageRequestStartTimeMs() == -1) {
                return -1L;
            }
            return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
        }
        return invokeV.longValue;
    }

    @Nullable
    public ImageInfo getImageInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mImageInfo : (ImageInfo) invokeV.objValue;
    }

    public int getImageOrigin() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mImageOrigin : invokeV.intValue;
    }

    @Nullable
    public ImageRequest getImageRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mImageRequest : (ImageRequest) invokeV.objValue;
    }

    public long getImageRequestEndTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mImageRequestEndTimeMs : invokeV.longValue;
    }

    public long getImageRequestStartTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mImageRequestStartTimeMs : invokeV.longValue;
    }

    public long getIntermediateImageLoadTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mInvisibilityEventTimeMs : invokeV.longValue;
    }

    public int getOnScreenHeightPx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.mOnScreenHeightPx : invokeV.intValue;
    }

    public int getOnScreenWidthPx() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mOnScreenWidthPx : invokeV.intValue;
    }

    @Nullable
    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mRequestId : (String) invokeV.objValue;
    }

    public long getVisibilityEventTimeMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.mVisibilityEventTimeMs : invokeV.longValue;
    }

    public int getVisibilityState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.mVisibilityState : invokeV.intValue;
    }

    public boolean isPrefetch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mIsPrefetch : invokeV.booleanValue;
    }
}
