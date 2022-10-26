package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
/* loaded from: classes7.dex */
public interface ThumbnailProducer extends Producer {
    boolean canProvideImageForSize(ResizeOptions resizeOptions);
}
