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
    protected static final byte[] meC = {-1, -39};
    private final com.facebook.imagepipeline.memory.a meD = com.facebook.imagepipeline.memory.b.dtk();

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options);

    abstract Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options);

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dsR = eVar.dsR();
        g.checkNotNull(dsR);
        try {
            return ac(a(dsR, a));
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsR);
        }
    }

    @Override // com.facebook.imagepipeline.i.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        BitmapFactory.Options a = a(eVar.getSampleSize(), config);
        com.facebook.common.references.a<PooledByteBuffer> dsR = eVar.dsR();
        g.checkNotNull(dsR);
        try {
            return ac(a(dsR, i, a));
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) dsR);
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
        return i >= 2 && pooledByteBuffer.Ga(i + (-2)) == -1 && pooledByteBuffer.Ga(i + (-1)) == -39;
    }

    public com.facebook.common.references.a<Bitmap> ac(Bitmap bitmap) {
        try {
            Bitmaps.ab(bitmap);
            if (!this.meD.W(bitmap)) {
                int ae = com.facebook.d.a.ae(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(ae), Integer.valueOf(this.meD.getCount()), Long.valueOf(this.meD.getSize()), Integer.valueOf(this.meD.dth()), Integer.valueOf(this.meD.getMaxSize())));
            }
            return com.facebook.common.references.a.a(bitmap, this.meD.dti());
        } catch (Exception e) {
            bitmap.recycle();
            throw l.y(e);
        }
    }
}
