package com.facebook.drawee.backends.pipeline.info;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.facebook.common.internal.Objects;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class ImagePerfData {
    public static final int UNSET = -1;
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

    public ImagePerfData(@Nullable String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable ImageInfo imageInfo, @Nullable ImageRequest imageRequest2, @Nullable ImageRequest imageRequest3, @Nullable ImageRequest[] imageRequestArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, @Nullable String str3, boolean z, int i2, int i3, @Nullable Throwable th, int i4, long j8, long j9, @Nullable String str4, long j10, @Nullable DimensionsInfo dimensionsInfo, @Nullable ControllerListener2.Extras extras) {
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
        this.mImageOrigin = i;
        this.mUltimateProducerName = str3;
        this.mIsPrefetch = z;
        this.mOnScreenWidthPx = i2;
        this.mOnScreenHeightPx = i3;
        this.mErrorThrowable = th;
        this.mVisibilityState = i4;
        this.mVisibilityEventTimeMs = j8;
        this.mInvisibilityEventTimeMs = j9;
        this.mComponentTag = str4;
        this.mImageDrawTimeMs = j10;
        this.mDimensionsInfo = dimensionsInfo;
        this.mExtraData = extras;
    }

    public String createDebugString() {
        return Objects.toStringHelper(this).add("controller ID", this.mControllerId).add("request ID", this.mRequestId).add("controller image request", this.mControllerImageRequest).add("controller low res image request", this.mControllerLowResImageRequest).add("controller first available image requests", this.mControllerFirstAvailableImageRequests).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add("origin", ImageOriginUtils.toString(this.mImageOrigin)).add("ultimateProducerName", this.mUltimateProducerName).add(PrefetchEvent.MODULE, this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", this.mImageRequest).add("image info", this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).add("component tag", this.mComponentTag).add("visibility event", this.mVisibilityEventTimeMs).add("invisibility event", this.mInvisibilityEventTimeMs).add("image draw event", this.mImageDrawTimeMs).add("dimensions info", this.mDimensionsInfo).add("extra data", this.mExtraData).toString();
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    @Nullable
    public String getComponentTag() {
        return this.mComponentTag;
    }

    public long getControllerFailureTimeMs() {
        return this.mControllerFailureTimeMs;
    }

    public long getControllerFinalImageSetTimeMs() {
        return this.mControllerFinalImageSetTimeMs;
    }

    @Nullable
    public ImageRequest[] getControllerFirstAvailableImageRequests() {
        return this.mControllerFirstAvailableImageRequests;
    }

    @Nullable
    public String getControllerId() {
        return this.mControllerId;
    }

    @Nullable
    public ImageRequest getControllerImageRequest() {
        return this.mControllerImageRequest;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        return this.mControllerIntermediateImageSetTimeMs;
    }

    @Nullable
    public ImageRequest getControllerLowResImageRequest() {
        return this.mControllerLowResImageRequest;
    }

    public long getControllerSubmitTimeMs() {
        return this.mControllerSubmitTimeMs;
    }

    @Nullable
    public DimensionsInfo getDimensionsInfo() {
        return this.mDimensionsInfo;
    }

    @Nullable
    public Throwable getErrorThrowable() {
        return this.mErrorThrowable;
    }

    @Nullable
    public ControllerListener2.Extras getExtraData() {
        return this.mExtraData;
    }

    public long getFinalImageLoadTimeMs() {
        if (getImageRequestEndTimeMs() == -1 || getImageRequestStartTimeMs() == -1) {
            return -1L;
        }
        return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
    }

    public long getImageDrawTimeMs() {
        return this.mImageDrawTimeMs;
    }

    @Nullable
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getImageOrigin() {
        return this.mImageOrigin;
    }

    @Nullable
    public ImageRequest getImageRequest() {
        return this.mImageRequest;
    }

    public long getImageRequestEndTimeMs() {
        return this.mImageRequestEndTimeMs;
    }

    public long getImageRequestStartTimeMs() {
        return this.mImageRequestStartTimeMs;
    }

    public long getIntermediateImageLoadTimeMs() {
        if (getControllerIntermediateImageSetTimeMs() == -1 || getControllerSubmitTimeMs() == -1) {
            return -1L;
        }
        return getControllerIntermediateImageSetTimeMs() - getControllerSubmitTimeMs();
    }

    public long getInvisibilityEventTimeMs() {
        return this.mInvisibilityEventTimeMs;
    }

    public int getOnScreenHeightPx() {
        return this.mOnScreenHeightPx;
    }

    public int getOnScreenWidthPx() {
        return this.mOnScreenWidthPx;
    }

    @Nullable
    public String getRequestId() {
        return this.mRequestId;
    }

    @Nullable
    public String getUltimateProducerName() {
        return this.mUltimateProducerName;
    }

    public long getVisibilityEventTimeMs() {
        return this.mVisibilityEventTimeMs;
    }

    public int getVisibilityState() {
        return this.mVisibilityState;
    }

    public boolean isPrefetch() {
        return this.mIsPrefetch;
    }
}
