package com.kwad.sdk.core.imageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
/* loaded from: classes7.dex */
public final class DisplayImageOptionsCompat {
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
    public final int strokeColor;
    public final float strokeWidth;

    /* loaded from: classes7.dex */
    public static class Builder {
        public int blurRadius;
        public int cornerRound;
        public boolean isCircle;
        public boolean isFrameSequence;
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
            return this;
        }

        public Builder considerExifParams(boolean z) {
            this.considerExifParams = z;
            return this;
        }

        public Builder setBlurRadius(int i2) {
            this.blurRadius = i2;
            return this;
        }

        public Builder setCircle(boolean z) {
            this.isCircle = z;
            return this;
        }

        public Builder setCornerRound(int i2) {
            this.cornerRound = i2;
            return this;
        }

        public Builder setFrameSequence(boolean z) {
            this.isFrameSequence = z;
            return this;
        }

        public Builder setStrokeColor(int i2) {
            this.strokeColor = i2;
            return this;
        }

        public Builder setStrokeWidth(float f2) {
            if (f2 > 0.0f) {
                this.strokeWidth = f2;
                this.isCircle = true;
            }
            return this;
        }

        public Builder showImageForEmptyUri(int i2) {
            this.imageResForEmptyUri = i2;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public Builder showImageOnFail(int i2) {
            this.imageResOnFail = i2;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public Builder showImageOnLoading(int i2) {
            this.imageResOnLoading = i2;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }

        @Deprecated
        public Builder showStubImage(int i2) {
            this.imageResOnLoading = i2;
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
    }

    public static DisplayImageOptionsCompat createSimple() {
        return new Builder().build();
    }

    public int getBlurRadius() {
        return this.blurRadius;
    }

    public int getCornerRound() {
        return this.cornerRound;
    }

    public BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public Drawable getImageForEmptyUri(Resources resources) {
        int i2 = this.imageResForEmptyUri;
        return i2 != 0 ? resources.getDrawable(i2) : this.imageForEmptyUri;
    }

    public Drawable getImageOnFail(Resources resources) {
        int i2 = this.imageResOnFail;
        return i2 != 0 ? resources.getDrawable(i2) : this.imageOnFail;
    }

    public Drawable getImageOnLoading(Resources resources) {
        int i2 = this.imageResOnLoading;
        return i2 != 0 ? resources.getDrawable(i2) : this.imageOnLoading;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    public boolean isCircle() {
        return this.isCircle;
    }

    public boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public boolean isFrameSequence() {
        return this.isFrameSequence;
    }

    public boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public boolean shouldDelayBeforeLoading() {
        return this.delayBeforeLoading > 0;
    }

    public boolean shouldShowImageForEmptyUri() {
        return (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) ? false : true;
    }

    public boolean shouldShowImageOnFail() {
        return (this.imageOnFail == null && this.imageResOnFail == 0) ? false : true;
    }

    public boolean shouldShowImageOnLoading() {
        return (this.imageOnLoading == null && this.imageResOnLoading == 0) ? false : true;
    }
}
