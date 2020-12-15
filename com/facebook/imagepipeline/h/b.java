package com.facebook.imagepipeline.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import java.util.Locale;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
abstract class b implements e {
    protected static final byte[] pou = {-1, -39};
    private final com.facebook.imagepipeline.memory.a pov = com.facebook.imagepipeline.memory.b.evQ();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options a2 = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> evB = eVar.evB();
        g.checkNotNull(evB);
        try {
            return ak(a(evB, a2));
        } finally {
            com.facebook.common.references.a.c(evB);
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        BitmapFactory.Options a2 = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> evB = eVar.evB();
        g.checkNotNull(evB);
        try {
            return ak(a(evB, i, a2));
        } finally {
            com.facebook.common.references.a.c(evB);
        }
    }

    private static BitmapFactory.Options a(int i, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        if (Build.VERSION.SDK_INT >= 11) {
            options.inMutable = true;
        }
        return options;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(com.facebook.common.references.a<PooledByteBuffer> aVar, int i) {
        PooledByteBuffer pooledByteBuffer = aVar.get();
        return i >= 2 && pooledByteBuffer.PS(i + (-2)) == -1 && pooledByteBuffer.PS(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> ak(Bitmap bitmap) {
        try {
            Bitmaps.aj(bitmap);
            if (!this.pov.ae(bitmap)) {
                int am = com.facebook.d.a.am(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(am), Integer.valueOf(this.pov.getCount()), Long.valueOf(this.pov.getSize()), Integer.valueOf(this.pov.bYq()), Integer.valueOf(this.pov.getMaxSize())));
            }
            return com.facebook.common.references.a.a(bitmap, this.pov.evO());
        } catch (Exception e) {
            bitmap.recycle();
            throw l.v(e);
        }
    }
}
