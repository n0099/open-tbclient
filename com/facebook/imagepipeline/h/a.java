package com.facebook.imagepipeline.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.support.v4.util.Pools;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes15.dex */
public class a implements e {
    private static final Class<?> paD = a.class;
    private static final byte[] poq = {-1, -39};
    private final com.facebook.imagepipeline.memory.c pjL;
    final Pools.SynchronizedPool<ByteBuffer> poo;

    public a(com.facebook.imagepipeline.memory.c cVar, int i, Pools.SynchronizedPool synchronizedPool) {
        this.pjL = cVar;
        this.poo = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.poo.release(ByteBuffer.allocate(16384));
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        BitmapFactory.Options a2 = a(eVar, config);
        boolean z = a2.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return a(eVar.getInputStream(), a2, rect);
        } catch (RuntimeException e) {
            if (z) {
                return a(eVar, Bitmap.Config.ARGB_8888, rect);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.h.e
    public com.facebook.common.references.a<Bitmap> a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        boolean QL = eVar.QL(i);
        BitmapFactory.Options a2 = a(eVar, config);
        InputStream inputStream = eVar.getInputStream();
        g.checkNotNull(inputStream);
        InputStream aVar = eVar.getSize() > i ? new com.facebook.common.f.a(inputStream, i) : inputStream;
        InputStream bVar = !QL ? new com.facebook.common.f.b(aVar, poq) : aVar;
        boolean z = a2.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return a(bVar, a2, rect);
        } catch (RuntimeException e) {
            if (z) {
                return a(eVar, Bitmap.Config.ARGB_8888, rect);
            }
            throw e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [169=4] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[Catch: IllegalArgumentException -> 0x0096, all -> 0x00a8, RuntimeException -> 0x00bd, TRY_LEAVE, TryCatch #3 {RuntimeException -> 0x00bd, blocks: (B:12:0x0040, B:17:0x0058, B:19:0x005e, B:31:0x0092, B:32:0x0095, B:28:0x008a), top: B:59:0x0040, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092 A[Catch: IllegalArgumentException -> 0x0096, all -> 0x00a8, RuntimeException -> 0x00bd, TryCatch #3 {RuntimeException -> 0x00bd, blocks: (B:12:0x0040, B:17:0x0058, B:19:0x005e, B:31:0x0092, B:32:0x0095, B:28:0x008a), top: B:59:0x0040, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected com.facebook.common.references.a<Bitmap> a(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        int i;
        int i2;
        BitmapRegionDecoder bitmapRegionDecoder;
        Bitmap bitmap;
        BitmapRegionDecoder bitmapRegionDecoder2 = null;
        g.checkNotNull(inputStream);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (rect != null) {
            int width = rect.width();
            i = rect.height();
            i2 = width;
        } else {
            i = i4;
            i2 = i3;
        }
        Bitmap bitmap2 = this.pjL.get(com.facebook.d.a.e(i2, i, options.inPreferredConfig));
        if (bitmap2 == null) {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmap2;
        ByteBuffer acquire = this.poo.acquire();
        ByteBuffer allocate = acquire == null ? ByteBuffer.allocate(16384) : acquire;
        try {
            try {
                try {
                    options.inTempStorage = allocate.array();
                    if (rect != null) {
                        try {
                            bitmap2.reconfigure(i2, i, options.inPreferredConfig);
                            bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, true);
                            try {
                                try {
                                    Bitmap decodeRegion = bitmapRegionDecoder.decodeRegion(rect, options);
                                    if (bitmapRegionDecoder != null) {
                                        bitmapRegionDecoder.recycle();
                                        bitmap = decodeRegion;
                                    } else {
                                        bitmap = decodeRegion;
                                    }
                                } catch (IOException e) {
                                    com.facebook.common.c.a.d(paD, "Could not decode region %s, decoding full bitmap instead.", rect);
                                    if (bitmapRegionDecoder != null) {
                                        bitmapRegionDecoder.recycle();
                                        bitmap = null;
                                        if (bitmap == null) {
                                        }
                                        this.poo.release(allocate);
                                        if (bitmap2 == bitmap) {
                                        }
                                    }
                                    bitmap = null;
                                    if (bitmap == null) {
                                    }
                                    this.poo.release(allocate);
                                    if (bitmap2 == bitmap) {
                                    }
                                }
                            } catch (Throwable th) {
                                bitmapRegionDecoder2 = bitmapRegionDecoder;
                                th = th;
                                if (bitmapRegionDecoder2 != null) {
                                    bitmapRegionDecoder2.recycle();
                                }
                                throw th;
                            }
                        } catch (IOException e2) {
                            bitmapRegionDecoder = null;
                        } catch (Throwable th2) {
                            th = th2;
                            if (bitmapRegionDecoder2 != null) {
                            }
                            throw th;
                        }
                        if (bitmap == null) {
                            bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                        }
                        this.poo.release(allocate);
                        if (bitmap2 == bitmap) {
                            this.pjL.release(bitmap2);
                            bitmap.recycle();
                            throw new IllegalStateException();
                        }
                        return com.facebook.common.references.a.a(bitmap, this.pjL);
                    }
                    bitmap = null;
                    if (bitmap == null) {
                    }
                    this.poo.release(allocate);
                    if (bitmap2 == bitmap) {
                    }
                } catch (RuntimeException e3) {
                    this.pjL.release(bitmap2);
                    throw e3;
                }
            } catch (IllegalArgumentException e4) {
                this.pjL.release(bitmap2);
                try {
                    inputStream.reset();
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    if (decodeStream == null) {
                        throw e4;
                    }
                    com.facebook.common.references.a<Bitmap> a2 = com.facebook.common.references.a.a(decodeStream, com.facebook.imagepipeline.a.g.esT());
                    this.poo.release(allocate);
                    return a2;
                } catch (IOException e5) {
                    throw e4;
                }
            }
        } catch (Throwable th3) {
            this.poo.release(allocate);
            throw th3;
        }
    }

    private static BitmapFactory.Options a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = eVar.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(eVar.getInputStream(), null, options);
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
