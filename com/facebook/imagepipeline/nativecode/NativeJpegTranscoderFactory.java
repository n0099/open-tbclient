package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import javax.annotation.Nullable;
@DoNotStrip
/* loaded from: classes6.dex */
public class NativeJpegTranscoderFactory implements ImageTranscoderFactory {
    public final int mMaxBitmapSize;
    public final boolean mUseDownSamplingRatio;

    @DoNotStrip
    public NativeJpegTranscoderFactory(int i2, boolean z) {
        this.mMaxBitmapSize = i2;
        this.mUseDownSamplingRatio = z;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    @DoNotStrip
    @Nullable
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        if (imageFormat != DefaultImageFormats.JPEG) {
            return null;
        }
        return new NativeJpegTranscoder(z, this.mMaxBitmapSize, this.mUseDownSamplingRatio);
    }
}
