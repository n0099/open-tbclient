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
/* loaded from: classes9.dex */
abstract class b implements e {
    protected static final byte[] lQw = {-1, -39};
    private final com.facebook.imagepipeline.memory.a lQx = com.facebook.imagepipeline.memory.b.dos();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> doc = eVar.doc();
        g.checkNotNull(doc);
        try {
            return ab(a(doc, a));
        } finally {
            com.facebook.common.references.a.c(doc);
        }
    }

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> doc = eVar.doc();
        g.checkNotNull(doc);
        try {
            return ab(a(doc, i, a));
        } finally {
            com.facebook.common.references.a.c(doc);
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
        return i >= 2 && pooledByteBuffer.Hj(i + (-2)) == -1 && pooledByteBuffer.Hj(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> ab(Bitmap bitmap) {
        try {
            Bitmaps.aa(bitmap);
            if (!this.lQx.V(bitmap)) {
                int ac = com.facebook.d.a.ac(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(ac), Integer.valueOf(this.lQx.getCount()), Long.valueOf(this.lQx.getSize()), Integer.valueOf(this.lQx.dop()), Integer.valueOf(this.lQx.getMaxSize())));
            }
            return com.facebook.common.references.a.a(bitmap, this.lQx.doq());
        } catch (Exception e) {
            bitmap.recycle();
            throw l.u(e);
        }
    }
}
