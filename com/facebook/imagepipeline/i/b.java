package com.facebook.imagepipeline.i;

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
/* loaded from: classes12.dex */
abstract class b implements e {
    protected static final byte[] mzD = {-1, -39};
    private final com.facebook.imagepipeline.memory.a mzE = com.facebook.imagepipeline.memory.b.dAQ();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dAy = eVar.dAy();
        g.checkNotNull(dAy);
        try {
            return ae(a(dAy, a));
        } finally {
            com.facebook.common.references.a.c(dAy);
        }
    }

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dAy = eVar.dAy();
        g.checkNotNull(dAy);
        try {
            return ae(a(dAy, i, a));
        } finally {
            com.facebook.common.references.a.c(dAy);
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
        return i >= 2 && pooledByteBuffer.GO(i + (-2)) == -1 && pooledByteBuffer.GO(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> ae(Bitmap bitmap) {
        try {
            Bitmaps.ad(bitmap);
            if (!this.mzE.Y(bitmap)) {
                int ag = com.facebook.d.a.ag(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(ag), Integer.valueOf(this.mzE.getCount()), Long.valueOf(this.mzE.getSize()), Integer.valueOf(this.mzE.bvL()), Integer.valueOf(this.mzE.getMaxSize())));
            }
            return com.facebook.common.references.a.a(bitmap, this.mzE.dAO());
        } catch (Exception e) {
            bitmap.recycle();
            throw l.y(e);
        }
    }
}
