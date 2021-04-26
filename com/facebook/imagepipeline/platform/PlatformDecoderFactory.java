package com.facebook.imagepipeline.platform;

import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.PoolFactory;
/* loaded from: classes6.dex */
public class PlatformDecoderFactory {
    public static PlatformDecoder buildPlatformDecoder(PoolFactory poolFactory, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            int flexByteArrayPoolMaxNumThreads = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new OreoDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads));
        } else if (i2 >= 21) {
            int flexByteArrayPoolMaxNumThreads2 = poolFactory.getFlexByteArrayPoolMaxNumThreads();
            return new ArtDecoder(poolFactory.getBitmapPool(), flexByteArrayPoolMaxNumThreads2, new Pools.SynchronizedPool(flexByteArrayPoolMaxNumThreads2));
        } else if (z && i2 < 19) {
            return new GingerbreadPurgeableDecoder();
        } else {
            return new KitKatPurgeableDecoder(poolFactory.getFlexByteArrayPool());
        }
    }
}
