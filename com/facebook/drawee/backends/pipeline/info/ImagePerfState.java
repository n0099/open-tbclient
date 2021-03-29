package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ImagePerfState {
    @Nullable
    public Object mCallerContext;
    @Nullable
    public String mComponentTag;
    @Nullable
    public String mControllerId;
    @Nullable
    public ImageInfo mImageInfo;
    @Nullable
    public ImageRequest mImageRequest;
    public boolean mIsPrefetch;
    @Nullable
    public String mRequestId;
    public long mControllerSubmitTimeMs = -1;
    public long mControllerIntermediateImageSetTimeMs = -1;
    public long mControllerFinalImageSetTimeMs = -1;
    public long mControllerFailureTimeMs = -1;
    public long mControllerCancelTimeMs = -1;
    public long mImageRequestStartTimeMs = -1;
    public long mImageRequestEndTimeMs = -1;
    public int mImageOrigin = -1;
    public int mOnScreenWidthPx = -1;
    public int mOnScreenHeightPx = -1;
    public int mImageLoadStatus = -1;
    public int mVisibilityState = -1;
    public long mVisibilityEventTimeMs = -1;
    public long mInvisibilityEventTimeMs = -1;

    public int getImageLoadStatus() {
        return this.mImageLoadStatus;
    }

    public void reset() {
        this.mRequestId = null;
        this.mImageRequest = null;
        this.mCallerContext = null;
        this.mImageInfo = null;
        this.mControllerSubmitTimeMs = -1L;
        this.mControllerFinalImageSetTimeMs = -1L;
        this.mControllerFailureTimeMs = -1L;
        this.mControllerCancelTimeMs = -1L;
        this.mImageRequestStartTimeMs = -1L;
        this.mImageRequestEndTimeMs = -1L;
        this.mImageOrigin = 1;
        this.mIsPrefetch = false;
        this.mOnScreenWidthPx = -1;
        this.mOnScreenHeightPx = -1;
        this.mImageLoadStatus = -1;
        this.mVisibilityState = -1;
        this.mVisibilityEventTimeMs = -1L;
        this.mInvisibilityEventTimeMs = -1L;
        this.mComponentTag = null;
    }

    public void setCallerContext(@Nullable Object obj) {
        this.mCallerContext = obj;
    }

    public void setComponentTag(@Nullable String str) {
        this.mComponentTag = str;
    }

    public void setControllerCancelTimeMs(long j) {
        this.mControllerCancelTimeMs = j;
    }

    public void setControllerFailureTimeMs(long j) {
        this.mControllerFailureTimeMs = j;
    }

    public void setControllerFinalImageSetTimeMs(long j) {
        this.mControllerFinalImageSetTimeMs = j;
    }

    public void setControllerId(@Nullable String str) {
        this.mControllerId = str;
    }

    public void setControllerIntermediateImageSetTimeMs(long j) {
        this.mControllerIntermediateImageSetTimeMs = j;
    }

    public void setControllerSubmitTimeMs(long j) {
        this.mControllerSubmitTimeMs = j;
    }

    public void setImageInfo(@Nullable ImageInfo imageInfo) {
        this.mImageInfo = imageInfo;
    }

    public void setImageLoadStatus(int i) {
        this.mImageLoadStatus = i;
    }

    public void setImageOrigin(int i) {
        this.mImageOrigin = i;
    }

    public void setImageRequest(@Nullable ImageRequest imageRequest) {
        this.mImageRequest = imageRequest;
    }

    public void setImageRequestEndTimeMs(long j) {
        this.mImageRequestEndTimeMs = j;
    }

    public void setImageRequestStartTimeMs(long j) {
        this.mImageRequestStartTimeMs = j;
    }

    public void setInvisibilityEventTimeMs(long j) {
        this.mInvisibilityEventTimeMs = j;
    }

    public void setOnScreenHeight(int i) {
        this.mOnScreenHeightPx = i;
    }

    public void setOnScreenWidth(int i) {
        this.mOnScreenWidthPx = i;
    }

    public void setPrefetch(boolean z) {
        this.mIsPrefetch = z;
    }

    public void setRequestId(@Nullable String str) {
        this.mRequestId = str;
    }

    public void setVisibilityEventTimeMs(long j) {
        this.mVisibilityEventTimeMs = j;
    }

    public void setVisible(boolean z) {
        this.mVisibilityState = z ? 1 : 2;
    }

    public ImagePerfData snapshot() {
        return new ImagePerfData(this.mControllerId, this.mRequestId, this.mImageRequest, this.mCallerContext, this.mImageInfo, this.mControllerSubmitTimeMs, this.mControllerIntermediateImageSetTimeMs, this.mControllerFinalImageSetTimeMs, this.mControllerFailureTimeMs, this.mControllerCancelTimeMs, this.mImageRequestStartTimeMs, this.mImageRequestEndTimeMs, this.mImageOrigin, this.mIsPrefetch, this.mOnScreenWidthPx, this.mOnScreenHeightPx, this.mVisibilityState, this.mVisibilityEventTimeMs, this.mInvisibilityEventTimeMs, this.mComponentTag);
    }
}
