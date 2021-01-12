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
/* loaded from: classes3.dex */
abstract class b implements e {
    protected static final byte[] pBa = {-1, -39};
    private final com.facebook.imagepipeline.memory.a pBb = com.facebook.imagepipeline.memory.b.ewj();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options c = c(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> evU = eVar.evU();
        g.checkNotNull(evU);
        try {
            return ai(a(evU, c));
        } finally {
            com.facebook.common.references.a.c(evU);
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        BitmapFactory.Options c = c(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> evU = eVar.evU();
        g.checkNotNull(evU);
        try {
            return ai(a(evU, i, c));
        } finally {
            com.facebook.common.references.a.c(evU);
        }
    }

    private static BitmapFactory.Options c(int i, Bitmap.Config config) {
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
        return i >= 2 && pooledByteBuffer.Oz(i + (-2)) == -1 && pooledByteBuffer.Oz(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> ai(Bitmap bitmap) {
        try {
            Bitmaps.ah(bitmap);
            if (!this.pBb.ac(bitmap)) {
                int ak = com.facebook.d.a.ak(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(ak), Integer.valueOf(this.pBb.getCount()), Long.valueOf(this.pBb.getSize()), Integer.valueOf(this.pBb.bXe()), Integer.valueOf(this.pBb.getMaxSize())));
            }
            return com.facebook.common.references.a.a(bitmap, this.pBb.ewh());
        } catch (Exception e) {
            bitmap.recycle();
            throw l.t(e);
        }
    }
}
