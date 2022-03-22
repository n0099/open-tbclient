package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
/* loaded from: classes6.dex */
public interface ThumbnailProducer<T> extends Producer<T> {
    boolean canProvideImageForSize(ResizeOptions resizeOptions);
}
