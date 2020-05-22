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
    protected static final byte[] myt = {-1, -39};
    private final com.facebook.imagepipeline.memory.a myu = com.facebook.imagepipeline.memory.b.dAC();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dAk = eVar.dAk();
        g.checkNotNull(dAk);
        try {
            return ae(a(dAk, a));
        } finally {
            com.facebook.common.references.a.c(dAk);
        }
    }

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dAk = eVar.dAk();
        g.checkNotNull(dAk);
        try {
            return ae(a(dAk, i, a));
        } finally {
            com.facebook.common.references.a.c(dAk);
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
        return i >= 2 && pooledByteBuffer.GM(i + (-2)) == -1 && pooledByteBuffer.GM(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> ae(Bitmap bitmap) {
        try {
            Bitmaps.ad(bitmap);
            if (!this.myu.Y(bitmap)) {
                int ag = com.facebook.d.a.ag(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(ag), Integer.valueOf(this.myu.getCount()), Long.valueOf(this.myu.getSize()), Integer.valueOf(this.myu.bvJ()), Integer.valueOf(this.myu.getMaxSize())));
            }
            return com.facebook.common.references.a.a(bitmap, this.myu.dAA());
        } catch (Exception e) {
            bitmap.recycle();
            throw l.y(e);
        }
    }
}
