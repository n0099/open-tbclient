package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(26)
/* loaded from: classes6.dex */
public class OreoDecoder extends DefaultDecoder {
    public OreoDecoder(BitmapPool bitmapPool, int i2, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i2, synchronizedPool);
    }

    public static boolean hasColorGamutMismatch(BitmapFactory.Options options) {
        ColorSpace colorSpace = options.outColorSpace;
        return (colorSpace == null || !colorSpace.isWideGamut() || options.inPreferredConfig == Bitmap.Config.RGBA_F16) ? false : true;
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int i2, int i3, BitmapFactory.Options options) {
        return hasColorGamutMismatch(options) ? i2 * i3 * 8 : BitmapUtil.getSizeInByteForBitmap(i2, i3, options.inPreferredConfig);
    }
}
