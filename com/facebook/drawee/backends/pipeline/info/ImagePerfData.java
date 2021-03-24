package com.facebook.drawee.backends.pipeline.info;

import com.facebook.common.internal.Objects;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
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

    public ImagePerfData(@Nullable String str, @Nullable String str2, @Nullable ImageRequest imageRequest, @Nullable Object obj, @Nullable ImageInfo imageInfo, long j, long j2, long j3, long j4, long j5, long j6, long j7, int i, boolean z, int i2, int i3, int i4, long j8, long j9, @Nullable String str3) {
        this.mControllerId = str;
        this.mRequestId = str2;
        this.mImageRequest = imageRequest;
        this.mCallerContext = obj;
        this.mImageInfo = imageInfo;
        this.mControllerSubmitTimeMs = j;
        this.mControllerIntermediateImageSetTimeMs = j2;
        this.mControllerFinalImageSetTimeMs = j3;
        this.mControllerFailureTimeMs = j4;
        this.mControllerCancelTimeMs = j5;
        this.mImageRequestStartTimeMs = j6;
        this.mImageRequestEndTimeMs = j7;
        this.mImageOrigin = i;
        this.mIsPrefetch = z;
        this.mOnScreenWidthPx = i2;
        this.mOnScreenHeightPx = i3;
        this.mVisibilityState = i4;
        this.mVisibilityEventTimeMs = j8;
        this.mInvisibilityEventTimeMs = j9;
        this.mComponentTag = str3;
    }

    public String createDebugString() {
        return Objects.toStringHelper(this).add("controller ID", this.mControllerId).add("request ID", this.mRequestId).add("controller submit", this.mControllerSubmitTimeMs).add("controller final image", this.mControllerFinalImageSetTimeMs).add("controller failure", this.mControllerFailureTimeMs).add("controller cancel", this.mControllerCancelTimeMs).add("start time", this.mImageRequestStartTimeMs).add("end time", this.mImageRequestEndTimeMs).add("origin", ImageOriginUtils.toString(this.mImageOrigin)).add("prefetch", this.mIsPrefetch).add("caller context", this.mCallerContext).add("image request", this.mImageRequest).add("image info", this.mImageInfo).add("on-screen width", this.mOnScreenWidthPx).add("on-screen height", this.mOnScreenHeightPx).add("visibility state", this.mVisibilityState).add("component tag", this.mComponentTag).toString();
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
    public String getControllerId() {
        return this.mControllerId;
    }

    public long getControllerIntermediateImageSetTimeMs() {
        return this.mControllerIntermediateImageSetTimeMs;
    }

    public long getControllerSubmitTimeMs() {
        return this.mControllerSubmitTimeMs;
    }

    public long getFinalImageLoadTimeMs() {
        if (getImageRequestEndTimeMs() == -1 || getImageRequestStartTimeMs() == -1) {
            return -1L;
        }
        return getImageRequestEndTimeMs() - getImageRequestStartTimeMs();
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
