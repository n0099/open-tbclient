package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(19)
/* loaded from: classes6.dex */
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    public final FlexByteArrayPool mFlexByteArrayPool;

    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        this.mFlexByteArrayPool = flexByteArrayPool;
    }

    public static void putEOI(byte[] bArr, int i2) {
        bArr[i2] = -1;
        bArr[i2 + 1] = -39;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBuffer = closeableReference.get();
        int size = pooledByteBuffer.size();
        CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(size);
        try {
            byte[] bArr = closeableReference2.get();
            pooledByteBuffer.read(0, bArr, 0, size);
            return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, BitmapFactory.Options options) {
        byte[] bArr = DalvikPurgeableDecoder.endsWithEOI(closeableReference, i2) ? null : DalvikPurgeableDecoder.EOI;
        PooledByteBuffer pooledByteBuffer = closeableReference.get();
        Preconditions.checkArgument(i2 <= pooledByteBuffer.size());
        int i3 = i2 + 2;
        CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(i3);
        try {
            byte[] bArr2 = closeableReference2.get();
            pooledByteBuffer.read(0, bArr2, 0, i2);
            if (bArr != null) {
                putEOI(bArr2, i2);
                i2 = i3;
            }
            return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i2, options), "BitmapFactory returned null");
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
        }
    }
}
