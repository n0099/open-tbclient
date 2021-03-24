package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public interface AnimatedImageDecoder {
    AnimatedImage decode(long j, int i);

    AnimatedImage decode(ByteBuffer byteBuffer);
}
