package com.facebook.imagepipeline.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.util.Pools;
import com.facebook.common.internal.g;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes2.dex */
public class a implements e {
    private static final byte[] isL = {-1, -39};
    private final com.facebook.imagepipeline.memory.c ion;
    final Pools.SynchronizedPool<ByteBuffer> isK;

    public a(com.facebook.imagepipeline.memory.c cVar, int i, Pools.SynchronizedPool synchronizedPool) {
        this.ion = cVar;
        this.isK = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.isK.release(ByteBuffer.allocate(16384));
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config) {
        BitmapFactory.Options b = b(dVar, config);
        boolean z = b.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return a(dVar.getInputStream(), b);
        } catch (RuntimeException e) {
            if (z) {
                return a(dVar, Bitmap.Config.ARGB_8888);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config, int i) {
        boolean yD = dVar.yD(i);
        BitmapFactory.Options b = b(dVar, config);
        InputStream inputStream = dVar.getInputStream();
        g.checkNotNull(inputStream);
        InputStream aVar = dVar.getSize() > i ? new com.facebook.common.f.a(inputStream, i) : inputStream;
        InputStream bVar = !yD ? new com.facebook.common.f.b(aVar, isL) : aVar;
        boolean z = b.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return a(bVar, b);
        } catch (RuntimeException e) {
            if (z) {
                return a(dVar, Bitmap.Config.ARGB_8888);
            }
            throw e;
        }
    }

    protected com.facebook.common.references.a<Bitmap> a(InputStream inputStream, BitmapFactory.Options options) {
        g.checkNotNull(inputStream);
        Bitmap bitmap = this.ion.get(com.facebook.d.a.a(options.outWidth, options.outHeight, options.inPreferredConfig));
        if (bitmap == null) {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmap;
        ByteBuffer acquire = this.isK.acquire();
        ByteBuffer allocate = acquire == null ? ByteBuffer.allocate(16384) : acquire;
        try {
            try {
                options.inTempStorage = allocate.array();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                if (bitmap != decodeStream) {
                    this.ion.release(bitmap);
                    decodeStream.recycle();
                    throw new IllegalStateException();
                }
                return com.facebook.common.references.a.a(decodeStream, this.ion);
            } catch (RuntimeException e) {
                this.ion.release(bitmap);
                throw e;
            }
        } finally {
            this.isK.release(allocate);
        }
    }

    private static BitmapFactory.Options b(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = dVar.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(dVar.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }
}
