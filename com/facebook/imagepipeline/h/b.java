package com.facebook.imagepipeline.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.nativecode.Bitmaps;
/* loaded from: classes2.dex */
abstract class b implements e {
    protected static final byte[] jJh = {-1, -39};
    private final com.facebook.imagepipeline.memory.a jJi = com.facebook.imagepipeline.memory.b.cyV();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config) {
        BitmapFactory.Options a = a(dVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> cyI = dVar.cyI();
        g.checkNotNull(cyI);
        try {
            return aa(a(cyI, a));
        } finally {
            com.facebook.common.references.a.c(cyI);
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config, int i) {
        BitmapFactory.Options a = a(dVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> cyI = dVar.cyI();
        g.checkNotNull(cyI);
        try {
            return aa(a(cyI, i, a));
        } finally {
            com.facebook.common.references.a.c(cyI);
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
    public static boolean a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i) {
        PooledByteBuffer pooledByteBuffer = aVar.get();
        return i >= 2 && pooledByteBuffer.BL(i + (-2)) == -1 && pooledByteBuffer.BL(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> aa(Bitmap bitmap) {
        try {
            Bitmaps.Z(bitmap);
            if (!this.jJi.U(bitmap)) {
                bitmap.recycle();
                throw new TooManyBitmapsException();
            }
            return com.facebook.common.references.a.a(bitmap, this.jJi.cyT());
        } catch (Exception e) {
            bitmap.recycle();
            throw k.s(e);
        }
    }
}
