package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public interface AnimatedImageDecoder {
    AnimatedImage decode(long j2, int i2);

    AnimatedImage decode(ByteBuffer byteBuffer);
}
