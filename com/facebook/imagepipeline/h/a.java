package com.facebook.imagepipeline.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.core.util.Pools;
import com.facebook.common.internal.g;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes5.dex */
public class a implements e {
    private final com.facebook.imagepipeline.memory.c pHh;
    final Pools.SynchronizedPool<ByteBuffer> pLH;
    private static final Class<?> pyc = a.class;
    private static final byte[] pLI = {-1, -39};

    public a(com.facebook.imagepipeline.memory.c cVar, int i, Pools.SynchronizedPool synchronizedPool) {
        this.pHh = cVar;
        this.pLH = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.pLH.release(ByteBuffer.allocate(16384));
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
        boolean PO = eVar.PO(i);
        BitmapFactory.Options a2 = a(eVar, config);
        InputStream inputStream = eVar.getInputStream();
        g.checkNotNull(inputStream);
        InputStream aVar = eVar.getSize() > i ? new com.facebook.common.f.a(inputStream, i) : inputStream;
        InputStream bVar = !PO ? new com.facebook.common.f.b(aVar, pLI) : aVar;
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
    /* JADX WARN: Removed duplicated region for block: B:19:0x005e A[Catch: IllegalArgumentException -> 0x0097, all -> 0x00a9, RuntimeException -> 0x00be, TRY_LEAVE, TryCatch #7 {IllegalArgumentException -> 0x0097, RuntimeException -> 0x00be, blocks: (B:12:0x0040, B:17:0x0058, B:19:0x005e, B:32:0x0093, B:33:0x0096, B:28:0x008a), top: B:60:0x0040, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[Catch: IllegalArgumentException -> 0x0097, all -> 0x00a9, RuntimeException -> 0x00be, TryCatch #7 {IllegalArgumentException -> 0x0097, RuntimeException -> 0x00be, blocks: (B:12:0x0040, B:17:0x0058, B:19:0x005e, B:32:0x0093, B:33:0x0096, B:28:0x008a), top: B:60:0x0040, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected com.facebook.common.references.a<Bitmap> a(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        int i;
        int i2;
        Throwable th;
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
        Bitmap bitmap2 = this.pHh.get(com.facebook.d.a.i(i2, i, options.inPreferredConfig));
        if (bitmap2 == null) {
            throw new NullPointerException("BitmapPool.get returned null");
        }
        options.inBitmap = bitmap2;
        ByteBuffer acquire = this.pLH.acquire();
        ByteBuffer allocate = acquire == null ? ByteBuffer.allocate(16384) : acquire;
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
                                com.facebook.common.c.a.d(pyc, "Could not decode region %s, decoding full bitmap instead.", rect);
                                if (bitmapRegionDecoder != null) {
                                    bitmapRegionDecoder.recycle();
                                    bitmap = null;
                                    if (bitmap == null) {
                                    }
                                    this.pLH.release(allocate);
                                    if (bitmap2 == bitmap) {
                                    }
                                }
                                bitmap = null;
                                if (bitmap == null) {
                                }
                                this.pLH.release(allocate);
                                if (bitmap2 == bitmap) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bitmapRegionDecoder2 = bitmapRegionDecoder;
                            if (bitmapRegionDecoder2 != null) {
                                bitmapRegionDecoder2.recycle();
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        bitmapRegionDecoder = null;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bitmapRegionDecoder2 != null) {
                        }
                        throw th;
                    }
                    if (bitmap == null) {
                        bitmap = BitmapFactory.decodeStream(inputStream, null, options);
                    }
                    this.pLH.release(allocate);
                    if (bitmap2 == bitmap) {
                        this.pHh.release(bitmap2);
                        bitmap.recycle();
                        throw new IllegalStateException();
                    }
                    return com.facebook.common.references.a.a(bitmap, this.pHh);
                }
                bitmap = null;
                if (bitmap == null) {
                }
                this.pLH.release(allocate);
                if (bitmap2 == bitmap) {
                }
            } catch (Throwable th4) {
                this.pLH.release(allocate);
                throw th4;
            }
        } catch (IllegalArgumentException e3) {
            this.pHh.release(bitmap2);
            try {
                inputStream.reset();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                if (decodeStream == null) {
                    throw e3;
                }
                com.facebook.common.references.a<Bitmap> a2 = com.facebook.common.references.a.a(decodeStream, com.facebook.imagepipeline.a.g.evM());
                this.pLH.release(allocate);
                return a2;
            } catch (IOException e4) {
                throw e3;
            }
        } catch (RuntimeException e5) {
            this.pHh.release(bitmap2);
            throw e5;
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
