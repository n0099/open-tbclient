package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.ResizeOptions;
/* loaded from: classes2.dex */
public interface ThumbnailProducer<T> extends Producer<T> {
    boolean canProvideImageForSize(ResizeOptions resizeOptions);
}
