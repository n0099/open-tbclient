package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class ImageDecodeOptionsBuilder {
    @Nullable
    public BitmapTransformation mBitmapTransformation;
    @Nullable
    public ImageDecoder mCustomImageDecoder;
    public boolean mDecodeAllFrames;
    public boolean mDecodePreviewFrame;
    public boolean mForceStaticImage;
    public boolean mTransformToSRGB;
    public boolean mUseLastFrameForPreview;
    public int mMinDecodeIntervalMs = 100;
    public Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;

    public ImageDecodeOptions build() {
        return new ImageDecodeOptions(this);
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    @Nullable
    public ImageDecoder getCustomImageDecoder() {
        return this.mCustomImageDecoder;
    }

    public boolean getDecodeAllFrames() {
        return this.mDecodeAllFrames;
    }

    public boolean getDecodePreviewFrame() {
        return this.mDecodePreviewFrame;
    }

    public boolean getForceStaticImage() {
        return this.mForceStaticImage;
    }

    public int getMinDecodeIntervalMs() {
        return this.mMinDecodeIntervalMs;
    }

    public boolean getTransformToSRGB() {
        return this.mTransformToSRGB;
    }

    public boolean getUseLastFrameForPreview() {
        return this.mUseLastFrameForPreview;
    }

    public ImageDecodeOptionsBuilder setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public ImageDecodeOptionsBuilder setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        this.mBitmapTransformation = bitmapTransformation;
        return this;
    }

    public ImageDecodeOptionsBuilder setCustomImageDecoder(@Nullable ImageDecoder imageDecoder) {
        this.mCustomImageDecoder = imageDecoder;
        return this;
    }

    public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean z) {
        this.mDecodeAllFrames = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean z) {
        this.mDecodePreviewFrame = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setForceStaticImage(boolean z) {
        this.mForceStaticImage = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
        this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
        this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
        this.mForceStaticImage = imageDecodeOptions.forceStaticImage;
        this.mBitmapConfig = imageDecodeOptions.bitmapConfig;
        this.mCustomImageDecoder = imageDecodeOptions.customImageDecoder;
        this.mTransformToSRGB = imageDecodeOptions.transformToSRGB;
        this.mBitmapTransformation = imageDecodeOptions.bitmapTransformation;
        return this;
    }

    public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int i2) {
        this.mMinDecodeIntervalMs = i2;
        return this;
    }

    public ImageDecodeOptionsBuilder setTransformToSRGB(boolean z) {
        this.mTransformToSRGB = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean z) {
        this.mUseLastFrameForPreview = z;
        return this;
    }
}
