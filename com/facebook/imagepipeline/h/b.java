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
    protected static final byte[] igG = {-1, -39};
    private final com.facebook.imagepipeline.memory.a igH = com.facebook.imagepipeline.memory.b.bWL();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config) {
        BitmapFactory.Options a = a(dVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> bWy = dVar.bWy();
        g.checkNotNull(bWy);
        try {
            return S(a(bWy, a));
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bWy);
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config, int i) {
        BitmapFactory.Options a = a(dVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> bWy = dVar.bWy();
        g.checkNotNull(bWy);
        try {
            return S(a(bWy, i, a));
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) bWy);
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
        return i >= 2 && pooledByteBuffer.xd(i + (-2)) == -1 && pooledByteBuffer.xd(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> S(Bitmap bitmap) {
        try {
            Bitmaps.R(bitmap);
            if (!this.igH.M(bitmap)) {
                bitmap.recycle();
                throw new TooManyBitmapsException();
            }
            return com.facebook.common.references.a.a(bitmap, this.igH.bWJ());
        } catch (Exception e) {
            bitmap.recycle();
            throw k.r(e);
        }
    }
}
