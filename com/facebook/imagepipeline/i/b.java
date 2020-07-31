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
/* loaded from: classes4.dex */
abstract class b implements e {
    protected static final byte[] ndO = {-1, -39};
    private final com.facebook.imagepipeline.memory.a ndP = com.facebook.imagepipeline.memory.b.dII();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dIq = eVar.dIq();
        g.checkNotNull(dIq);
        try {
            return ah(a(dIq, a));
        } finally {
            com.facebook.common.references.a.c(dIq);
        }
    }

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dIq = eVar.dIq();
        g.checkNotNull(dIq);
        try {
            return ah(a(dIq, i, a));
        } finally {
            com.facebook.common.references.a.c(dIq);
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
        return i >= 2 && pooledByteBuffer.Iq(i + (-2)) == -1 && pooledByteBuffer.Iq(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> ah(Bitmap bitmap) {
        try {
            Bitmaps.ag(bitmap);
            if (!this.ndP.ab(bitmap)) {
                int aj = com.facebook.d.a.aj(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(aj), Integer.valueOf(this.ndP.getCount()), Long.valueOf(this.ndP.getSize()), Integer.valueOf(this.ndP.bBV()), Integer.valueOf(this.ndP.getMaxSize())));
            }
            return com.facebook.common.references.a.a(bitmap, this.ndP.dIG());
        } catch (Exception e) {
            bitmap.recycle();
            throw l.x(e);
        }
    }
}
