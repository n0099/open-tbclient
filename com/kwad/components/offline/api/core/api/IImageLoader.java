package com.kwad.components.offline.api.core.api;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.io.InputStream;
/* loaded from: classes8.dex */
public interface IImageLoader {

    /* loaded from: classes8.dex */
    public static final class DisplayImageOptionsCompat {
        public final int blurRadius;
        public final boolean cacheInMemory;
        public final boolean cacheOnDisk;
        public final boolean considerExifParams;
        public final int cornerRound;
        public final BitmapFactory.Options decodingOptions;
        public final int delayBeforeLoading;
        public final Drawable imageForEmptyUri;
        public final Drawable imageOnFail;
        public final Drawable imageOnLoading;
        public final int imageResForEmptyUri;
        public final int imageResOnFail;
        public final int imageResOnLoading;
        public final boolean isCircle;
        public final boolean isFrameSequence;
        public final boolean isSyncLoading;
        public final boolean resetViewBeforeLoading;
        public final Resources resources;
        public final int strokeColor;
        public final float strokeWidth;

        /* loaded from: classes8.dex */
        public static class Builder {
            public int blurRadius;
            public int cornerRound;
            public boolean isCircle;
            public boolean isFrameSequence;
            public Resources resources;
            public int strokeColor;
            public float strokeWidth;
            public int imageResOnLoading = 0;
            public int imageResForEmptyUri = 0;
            public int imageResOnFail = 0;
            public Drawable imageOnLoading = null;
            public Drawable imageForEmptyUri = null;
            public Drawable imageOnFail = null;
            public boolean resetViewBeforeLoading = false;
            public boolean cacheInMemory = false;
            public boolean cacheOnDisk = false;
            public BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
            public int delayBeforeLoading = 0;
            public boolean considerExifParams = false;
            public boolean isSyncLoading = false;

            public Builder bitmapConfig(Bitmap.Config config) {
                if (config != null) {
                    this.decodingOptions.inPreferredConfig = config;
                    return this;
                }
                throw new IllegalArgumentException("bitmapConfig can't be null");
            }

            public DisplayImageOptionsCompat build() {
                return new DisplayImageOptionsCompat(this);
            }

            @Deprecated
            public Builder cacheInMemory() {
                this.cacheInMemory = true;
                return this;
            }

            public Builder cacheInMemory(boolean z) {
                this.cacheInMemory = z;
                return this;
            }

            @Deprecated
            public Builder cacheOnDisc() {
                return cacheOnDisk(true);
            }

            @Deprecated
            public Builder cacheOnDisc(boolean z) {
                return cacheOnDisk(z);
            }

            public Builder cacheOnDisk(boolean z) {
                this.cacheOnDisk = z;
                return this;
            }

            public Builder cloneFrom(DisplayImageOptionsCompat displayImageOptionsCompat) {
                this.imageResOnLoading = displayImageOptionsCompat.imageResOnLoading;
                this.imageResForEmptyUri = displayImageOptionsCompat.imageResForEmptyUri;
                this.imageResOnFail = displayImageOptionsCompat.imageResOnFail;
                this.imageOnLoading = displayImageOptionsCompat.imageOnLoading;
                this.imageForEmptyUri = displayImageOptionsCompat.imageForEmptyUri;
                this.imageOnFail = displayImageOptionsCompat.imageOnFail;
                this.resetViewBeforeLoading = displayImageOptionsCompat.resetViewBeforeLoading;
                this.cacheInMemory = displayImageOptionsCompat.cacheInMemory;
                this.cacheOnDisk = displayImageOptionsCompat.cacheOnDisk;
                this.decodingOptions = displayImageOptionsCompat.decodingOptions;
                this.delayBeforeLoading = displayImageOptionsCompat.delayBeforeLoading;
                this.considerExifParams = displayImageOptionsCompat.considerExifParams;
                this.isSyncLoading = displayImageOptionsCompat.isSyncLoading;
                this.blurRadius = displayImageOptionsCompat.blurRadius;
                this.isFrameSequence = displayImageOptionsCompat.isFrameSequence;
                this.cornerRound = displayImageOptionsCompat.cornerRound;
                this.isCircle = displayImageOptionsCompat.isCircle;
                this.strokeColor = displayImageOptionsCompat.strokeColor;
                this.strokeWidth = displayImageOptionsCompat.strokeWidth;
                this.resources = displayImageOptionsCompat.resources;
                return this;
            }

            public Builder considerExifParams(boolean z) {
                this.considerExifParams = z;
                return this;
            }

            public Builder setBlurRadius(int i) {
                this.blurRadius = i;
                return this;
            }

            public Builder setCircle(boolean z) {
                this.isCircle = z;
                return this;
            }

            public Builder setCornerRound(int i) {
                this.cornerRound = i;
                return this;
            }

            public Builder setFrameSequence(boolean z) {
                this.isFrameSequence = z;
                return this;
            }

            public Builder setResources(Resources resources) {
                this.resources = resources;
                return this;
            }

            public Builder setStrokeColor(int i) {
                this.strokeColor = i;
                return this;
            }

            public Builder setStrokeWidth(float f) {
                if (f > 0.0f) {
                    this.strokeWidth = f;
                    this.isCircle = true;
                }
                return this;
            }

            public Builder showImageForEmptyUri(int i) {
                this.imageResForEmptyUri = i;
                return this;
            }

            public Builder showImageForEmptyUri(Drawable drawable) {
                this.imageForEmptyUri = drawable;
                return this;
            }

            public Builder showImageOnFail(int i) {
                this.imageResOnFail = i;
                return this;
            }

            public Builder showImageOnFail(Drawable drawable) {
                this.imageOnFail = drawable;
                return this;
            }

            public Builder showImageOnLoading(int i) {
                this.imageResOnLoading = i;
                return this;
            }

            public Builder showImageOnLoading(Drawable drawable) {
                this.imageOnLoading = drawable;
                return this;
            }

            @Deprecated
            public Builder showStubImage(int i) {
                this.imageResOnLoading = i;
                return this;
            }
        }

        public DisplayImageOptionsCompat(Builder builder) {
            this.imageResOnLoading = builder.imageResOnLoading;
            this.imageResForEmptyUri = builder.imageResForEmptyUri;
            this.imageResOnFail = builder.imageResOnFail;
            this.imageOnLoading = builder.imageOnLoading;
            this.imageForEmptyUri = builder.imageForEmptyUri;
            this.imageOnFail = builder.imageOnFail;
            this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
            this.cacheInMemory = builder.cacheInMemory;
            this.cacheOnDisk = builder.cacheOnDisk;
            this.decodingOptions = builder.decodingOptions;
            this.delayBeforeLoading = builder.delayBeforeLoading;
            this.considerExifParams = builder.considerExifParams;
            this.isSyncLoading = builder.isSyncLoading;
            this.blurRadius = builder.blurRadius;
            this.isFrameSequence = builder.isFrameSequence;
            this.cornerRound = builder.cornerRound;
            this.isCircle = builder.isCircle;
            this.strokeColor = builder.strokeColor;
            this.strokeWidth = builder.strokeWidth;
            this.resources = builder.resources;
        }

        public static DisplayImageOptionsCompat createSimple() {
            return new Builder().build();
        }

        public final int getBlurRadius() {
            return this.blurRadius;
        }

        public final int getCornerRound() {
            return this.cornerRound;
        }

        public final BitmapFactory.Options getDecodingOptions() {
            return this.decodingOptions;
        }

        public final int getDelayBeforeLoading() {
            return this.delayBeforeLoading;
        }

        public final Drawable getImageForEmptyUri() {
            int i = this.imageResForEmptyUri;
            return i != 0 ? this.resources.getDrawable(i) : this.imageForEmptyUri;
        }

        public final Drawable getImageOnFail() {
            int i = this.imageResOnFail;
            return i != 0 ? this.resources.getDrawable(i) : this.imageOnFail;
        }

        public final Drawable getImageOnLoading() {
            int i = this.imageResOnLoading;
            return i != 0 ? this.resources.getDrawable(i) : this.imageOnLoading;
        }

        public final int getStrokeColor() {
            return this.strokeColor;
        }

        public final float getStrokeWidth() {
            return this.strokeWidth;
        }

        public final boolean isCacheInMemory() {
            return this.cacheInMemory;
        }

        public final boolean isCacheOnDisk() {
            return this.cacheOnDisk;
        }

        public final boolean isCircle() {
            return this.isCircle;
        }

        public final boolean isConsiderExifParams() {
            return this.considerExifParams;
        }

        public final boolean isFrameSequence() {
            return this.isFrameSequence;
        }

        public final boolean isResetViewBeforeLoading() {
            return this.resetViewBeforeLoading;
        }

        public final boolean shouldDelayBeforeLoading() {
            return this.delayBeforeLoading > 0;
        }

        public final boolean shouldShowImageForEmptyUri() {
            return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
        }

        public final boolean shouldShowImageOnFail() {
            return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
        }

        public final boolean shouldShowImageOnLoading() {
            return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
        }
    }

    /* loaded from: classes8.dex */
    public interface ImageLoadingListener {
        boolean onDecode(String str, InputStream inputStream, Bitmap bitmap);

        void onLoadingCancelled(String str, View view2);

        void onLoadingComplete(String str, View view2, Bitmap bitmap);

        void onLoadingFailed(String str, View view2, String str2, Throwable th);

        void onLoadingStarted(String str, View view2);
    }

    void loadImage(ImageView imageView, @Nullable String str);

    void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat);

    void loadImage(ImageView imageView, @Nullable String str, DisplayImageOptionsCompat displayImageOptionsCompat, ImageLoadingListener imageLoadingListener);

    void loadImage(ImageView imageView, @Nullable String str, ImageLoadingListener imageLoadingListener);
}
