package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
/* loaded from: classes11.dex */
public interface ImageDecoder {
    CloseableImage decode(EncodedImage encodedImage, int i2, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions);
}
