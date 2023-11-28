package com.kwad.sdk.core.imageloader.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.kwad.sdk.core.imageloader.core.assist.ImageScaleType;
import com.kwad.sdk.core.imageloader.core.display.BitmapDisplayer;
import com.kwad.sdk.core.imageloader.core.process.BitmapProcessor;
/* loaded from: classes10.dex */
public final class DisplayImageOptions {
    public final boolean cacheInMemory;
    public final boolean cacheOnDisk;
    public final boolean considerExifParams;
    public final BitmapFactory.Options decodingOptions;
    public final int delayBeforeLoading;
    public final BitmapDisplayer displayer;
    public final Object extraForDownloader;
    public final Handler handler;
    public final Drawable imageForEmptyUri;
    public final Drawable imageOnFail;
    public final Drawable imageOnLoading;
    public final int imageResForEmptyUri;
    public final int imageResOnFail;
    public final int imageResOnLoading;
    public final ImageScaleType imageScaleType;
    public final boolean isSyncLoading;
    public final BitmapProcessor postProcessor;
    public final BitmapProcessor preProcessor;
    public final boolean resetViewBeforeLoading;

    public DisplayImageOptions(Builder builder) {
        this.imageResOnLoading = builder.imageResOnLoading;
        this.imageResForEmptyUri = builder.imageResForEmptyUri;
        this.imageResOnFail = builder.imageResOnFail;
        this.imageOnLoading = builder.imageOnLoading;
        this.imageForEmptyUri = builder.imageForEmptyUri;
        this.imageOnFail = builder.imageOnFail;
        this.resetViewBeforeLoading = builder.resetViewBeforeLoading;
        this.cacheInMemory = builder.cacheInMemory;
        this.cacheOnDisk = builder.cacheOnDisk;
        this.imageScaleType = builder.imageScaleType;
        this.decodingOptions = builder.decodingOptions;
        this.delayBeforeLoading = builder.delayBeforeLoading;
        this.considerExifParams = builder.considerExifParams;
        this.extraForDownloader = builder.extraForDownloader;
        this.preProcessor = builder.preProcessor;
        this.postProcessor = builder.postProcessor;
        this.displayer = builder.displayer;
        this.handler = builder.handler;
        this.isSyncLoading = builder.isSyncLoading;
    }

    /* loaded from: classes10.dex */
    public static class Builder {
        public int imageResOnLoading = 0;
        public int imageResForEmptyUri = 0;
        public int imageResOnFail = 0;
        public Drawable imageOnLoading = null;
        public Drawable imageForEmptyUri = null;
        public Drawable imageOnFail = null;
        public boolean resetViewBeforeLoading = false;
        public boolean cacheInMemory = false;
        public boolean cacheOnDisk = false;
        public ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
        public BitmapFactory.Options decodingOptions = new BitmapFactory.Options();
        public int delayBeforeLoading = 0;
        public boolean considerExifParams = false;
        public Object extraForDownloader = null;
        public BitmapProcessor preProcessor = null;
        public BitmapProcessor postProcessor = null;
        public BitmapDisplayer displayer = DefaultConfigurationFactory.createBitmapDisplayer();
        public Handler handler = null;
        public boolean isSyncLoading = false;

        public Builder setBlurRadius(int i) {
            return this;
        }

        public Builder bitmapConfig(Bitmap.Config config) {
            if (config != null) {
                this.decodingOptions.inPreferredConfig = config;
                return this;
            }
            throw new IllegalArgumentException("bitmapConfig can't be null");
        }

        public Builder cacheInMemory(boolean z) {
            this.cacheInMemory = z;
            return this;
        }

        @Deprecated
        public Builder cacheOnDisc(boolean z) {
            return cacheOnDisk(z);
        }

        public Builder cacheOnDisk(boolean z) {
            this.cacheOnDisk = z;
            return this;
        }

        public Builder considerExifParams(boolean z) {
            this.considerExifParams = z;
            return this;
        }

        public Builder decodingOptions(BitmapFactory.Options options) {
            if (options != null) {
                this.decodingOptions = options;
                return this;
            }
            throw new IllegalArgumentException("decodingOptions can't be null");
        }

        public Builder delayBeforeLoading(int i) {
            this.delayBeforeLoading = i;
            return this;
        }

        public Builder displayer(BitmapDisplayer bitmapDisplayer) {
            if (bitmapDisplayer != null) {
                this.displayer = bitmapDisplayer;
                return this;
            }
            throw new IllegalArgumentException("displayer can't be null");
        }

        public Builder extraForDownloader(Object obj) {
            this.extraForDownloader = obj;
            return this;
        }

        public Builder handler(Handler handler) {
            this.handler = handler;
            return this;
        }

        public Builder imageScaleType(ImageScaleType imageScaleType) {
            this.imageScaleType = imageScaleType;
            return this;
        }

        public Builder postProcessor(BitmapProcessor bitmapProcessor) {
            this.postProcessor = bitmapProcessor;
            return this;
        }

        public Builder preProcessor(BitmapProcessor bitmapProcessor) {
            this.preProcessor = bitmapProcessor;
            return this;
        }

        public Builder resetViewBeforeLoading(boolean z) {
            this.resetViewBeforeLoading = z;
            return this;
        }

        public Builder showImageForEmptyUri(int i) {
            this.imageResForEmptyUri = i;
            return this;
        }

        public Builder showImageOnFail(int i) {
            this.imageResOnFail = i;
            return this;
        }

        public Builder showImageOnLoading(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        @Deprecated
        public Builder showStubImage(int i) {
            this.imageResOnLoading = i;
            return this;
        }

        public Builder syncLoading(boolean z) {
            this.isSyncLoading = z;
            return this;
        }

        public DisplayImageOptions build() {
            return new DisplayImageOptions(this);
        }

        @Deprecated
        public Builder cacheInMemory() {
            this.cacheInMemory = true;
            return this;
        }

        @Deprecated
        public Builder cacheOnDisc() {
            return cacheOnDisk(true);
        }

        public Builder resetViewBeforeLoading() {
            this.resetViewBeforeLoading = true;
            return this;
        }

        public Builder cloneFrom(DisplayImageOptions displayImageOptions) {
            this.imageResOnLoading = displayImageOptions.imageResOnLoading;
            this.imageResForEmptyUri = displayImageOptions.imageResForEmptyUri;
            this.imageResOnFail = displayImageOptions.imageResOnFail;
            this.imageOnLoading = displayImageOptions.imageOnLoading;
            this.imageForEmptyUri = displayImageOptions.imageForEmptyUri;
            this.imageOnFail = displayImageOptions.imageOnFail;
            this.resetViewBeforeLoading = displayImageOptions.resetViewBeforeLoading;
            this.cacheInMemory = displayImageOptions.cacheInMemory;
            this.cacheOnDisk = displayImageOptions.cacheOnDisk;
            this.imageScaleType = displayImageOptions.imageScaleType;
            this.decodingOptions = displayImageOptions.decodingOptions;
            this.delayBeforeLoading = displayImageOptions.delayBeforeLoading;
            this.considerExifParams = displayImageOptions.considerExifParams;
            this.extraForDownloader = displayImageOptions.extraForDownloader;
            this.preProcessor = displayImageOptions.preProcessor;
            this.postProcessor = displayImageOptions.postProcessor;
            this.displayer = displayImageOptions.displayer;
            this.handler = displayImageOptions.handler;
            this.isSyncLoading = displayImageOptions.isSyncLoading;
            return this;
        }

        public Builder showImageForEmptyUri(Drawable drawable) {
            this.imageForEmptyUri = drawable;
            return this;
        }

        public Builder showImageOnFail(Drawable drawable) {
            this.imageOnFail = drawable;
            return this;
        }

        public Builder showImageOnLoading(Drawable drawable) {
            this.imageOnLoading = drawable;
            return this;
        }
    }

    public final Drawable getImageForEmptyUri(Resources resources) {
        int i = this.imageResForEmptyUri;
        if (i != 0) {
            return resources.getDrawable(i);
        }
        return this.imageForEmptyUri;
    }

    public final Drawable getImageOnFail(Resources resources) {
        int i = this.imageResOnFail;
        if (i != 0) {
            return resources.getDrawable(i);
        }
        return this.imageOnFail;
    }

    public final Drawable getImageOnLoading(Resources resources) {
        int i = this.imageResOnLoading;
        if (i != 0) {
            return resources.getDrawable(i);
        }
        return this.imageOnLoading;
    }

    public static DisplayImageOptions createSimple() {
        return new Builder().build();
    }

    public final BitmapFactory.Options getDecodingOptions() {
        return this.decodingOptions;
    }

    public final int getDelayBeforeLoading() {
        return this.delayBeforeLoading;
    }

    public final BitmapDisplayer getDisplayer() {
        return this.displayer;
    }

    public final Object getExtraForDownloader() {
        return this.extraForDownloader;
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final ImageScaleType getImageScaleType() {
        return this.imageScaleType;
    }

    public final BitmapProcessor getPostProcessor() {
        return this.postProcessor;
    }

    public final BitmapProcessor getPreProcessor() {
        return this.preProcessor;
    }

    public final boolean isCacheInMemory() {
        return this.cacheInMemory;
    }

    public final boolean isCacheOnDisk() {
        return this.cacheOnDisk;
    }

    public final boolean isConsiderExifParams() {
        return this.considerExifParams;
    }

    public final boolean isResetViewBeforeLoading() {
        return this.resetViewBeforeLoading;
    }

    public final boolean isSyncLoading() {
        return this.isSyncLoading;
    }

    public final boolean shouldDelayBeforeLoading() {
        if (this.delayBeforeLoading > 0) {
            return true;
        }
        return false;
    }

    public final boolean shouldPostProcess() {
        if (this.postProcessor != null) {
            return true;
        }
        return false;
    }

    public final boolean shouldPreProcess() {
        if (this.preProcessor != null) {
            return true;
        }
        return false;
    }

    public final boolean shouldShowImageForEmptyUri() {
        if (this.imageForEmptyUri == null && this.imageResForEmptyUri == 0) {
            return false;
        }
        return true;
    }

    public final boolean shouldShowImageOnFail() {
        if (this.imageOnFail == null && this.imageResOnFail == 0) {
            return false;
        }
        return true;
    }

    public final boolean shouldShowImageOnLoading() {
        if (this.imageOnLoading == null && this.imageResOnLoading == 0) {
            return false;
        }
        return true;
    }
}
