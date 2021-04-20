package com.facebook.imagepipeline.platform;

import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.PoolFactory;
/* loaded from: classes5.dex */
public class PlatformDecoderFactory {
    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new OreoDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads));
        } else if (i >= 21) {
            int flexByteArrayPoolMaxNumThreads2 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads2, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads2));
        } else if (z && i < 19) {
            return new GingerbreadPurgeableDecoder();
        } else {
            return new KitKatPurgeableDecoder(poolFactory.getFlexByteArrayPool());
        }
    }
}
