package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.image.QualityInfo;
/* loaded from: classes7.dex */
public interface ProgressiveJpegConfig {
    int getNextScanNumberToDecode(int i2);

    QualityInfo getQualityInfo(int i2);
}
