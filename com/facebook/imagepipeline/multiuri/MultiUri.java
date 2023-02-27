package com.facebook.imagepipeline.multiuri;

import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class MultiUri {
    @Nullable
    public ImageRequest mHighResImageRequest;
    @Nullable
    public ImageRequest mLowResImageRequest;
    @Nullable
    public ImageRequest[] mMultiImageRequests;

    /* loaded from: classes7.dex */
    public static class Builder {
        @Nullable
        public ImageRequest mHighResImageRequest;
        @Nullable
        public ImageRequest mLowResImageRequest;
        @Nullable
        public ImageRequest[] mMultiImageRequests;

        public Builder() {
        }

        public MultiUri build() {
            return new MultiUri(this);
        }

        public Builder setHighResImageRequest(@Nullable ImageRequest imageRequest) {
            this.mHighResImageRequest = imageRequest;
            return this;
        }

        public Builder setImageRequests(@Nullable ImageRequest... imageRequestArr) {
            this.mMultiImageRequests = imageRequestArr;
            return this;
        }

        public Builder setLowResImageRequest(@Nullable ImageRequest imageRequest) {
            this.mLowResImageRequest = imageRequest;
            return this;
        }
    }

    public MultiUri(Builder builder) {
        this.mLowResImageRequest = builder.mLowResImageRequest;
        this.mHighResImageRequest = builder.mHighResImageRequest;
        this.mMultiImageRequests = builder.mMultiImageRequests;
    }

    public static Builder create() {
        return new Builder();
    }

    @Nullable
    public ImageRequest getHighResImageRequest() {
        return this.mHighResImageRequest;
    }

    @Nullable
    public ImageRequest getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    @Nullable
    public ImageRequest[] getMultiImageRequests() {
        return this.mMultiImageRequests;
    }
}
