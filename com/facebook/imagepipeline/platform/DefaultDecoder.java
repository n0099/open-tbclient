package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(11)
/* loaded from: classes9.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    public static final int DECODE_BUFFER_SIZE = 16384;
    public final BitmapPool mBitmapPool;
    @VisibleForTesting
    public final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;
    @Nullable
    public final PreverificationHelper mPreverificationHelper;
    public static final Class<?> TAG = DefaultDecoder.class;
    public static final byte[] EOI_TAIL = {-1, ExifInterface.MARKER_EOI};

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        PreverificationHelper preverificationHelper;
        if (Build.VERSION.SDK_INT >= 26) {
            preverificationHelper = new PreverificationHelper();
        } else {
            preverificationHelper = null;
        }
        this.mPreverificationHelper = preverificationHelper;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
    }

    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: com.facebook.imagepipeline.platform.DefaultDecoder */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00af A[Catch: all -> 0x00d2, RuntimeException -> 0x00d4, IllegalArgumentException -> 0x00dd, TRY_LEAVE, TryCatch #4 {RuntimeException -> 0x00d4, blocks: (B:30:0x006d, B:38:0x008c, B:53:0x00af, B:45:0x00a0, B:49:0x00a8, B:50:0x00ab), top: B:83:0x006d, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ba A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CloseableReference<Bitmap> decodeFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        boolean z;
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapRegionDecoder bitmapRegionDecoder;
        PreverificationHelper preverificationHelper;
        Preconditions.checkNotNull(inputStream);
        int i = options.outWidth;
        int i2 = options.outHeight;
        ?? r0 = i;
        if (rect != null) {
            int width = rect.width() / options.inSampleSize;
            i2 = rect.height() / options.inSampleSize;
            r0 = width;
        }
        if (Build.VERSION.SDK_INT >= 26 && (preverificationHelper = this.mPreverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig)) {
            z = true;
        } else {
            z = false;
        }
        BitmapRegionDecoder bitmapRegionDecoder2 = null;
        if (rect == null && z) {
            options.inMutable = false;
            bitmap = null;
        } else {
            if (rect != null && z) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            bitmap = this.mBitmapPool.get(getBitmapSize(r0, i2, options));
            if (bitmap == null) {
                throw new NullPointerException("BitmapPool.get returned null");
            }
        }
        options.inBitmap = bitmap;
        if (Build.VERSION.SDK_INT >= 26) {
            if (colorSpace == null) {
                colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
            options.inPreferredColorSpace = colorSpace;
        }
        ByteBuffer acquire = this.mDecodeBuffers.acquire();
        if (acquire == null) {
            acquire = ByteBuffer.allocate(16384);
        }
        try {
            try {
                try {
                    options.inTempStorage = acquire.array();
                    if (Build.VERSION.SDK_INT >= 19 && rect != null) {
                        try {
                            if (bitmap != null) {
                                try {
                                    bitmap.reconfigure(r0, i2, options.inPreferredConfig);
                                    bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, true);
                                    try {
                                        bitmap2 = bitmapRegionDecoder.decodeRegion(rect, options);
                                        if (bitmapRegionDecoder != null) {
                                            bitmapRegionDecoder.recycle();
                                        }
                                    } catch (IOException unused) {
                                        FLog.e(TAG, "Could not decode region %s, decoding full bitmap instead.", rect);
                                        if (bitmapRegionDecoder != null) {
                                            bitmapRegionDecoder.recycle();
                                        }
                                        bitmap2 = null;
                                        if (bitmap2 == null) {
                                        }
                                        this.mDecodeBuffers.release(acquire);
                                        if (bitmap == null) {
                                        }
                                        return CloseableReference.of(bitmap2, this.mBitmapPool);
                                    }
                                } catch (IOException unused2) {
                                    bitmapRegionDecoder = null;
                                } catch (Throwable th) {
                                    th = th;
                                    if (bitmapRegionDecoder2 != null) {
                                        bitmapRegionDecoder2.recycle();
                                    }
                                    throw th;
                                }
                                if (bitmap2 == null) {
                                    bitmap2 = BitmapFactory.decodeStream(inputStream, null, options);
                                }
                                this.mDecodeBuffers.release(acquire);
                                if (bitmap == null && bitmap != bitmap2) {
                                    this.mBitmapPool.release(bitmap);
                                    bitmap2.recycle();
                                    throw new IllegalStateException();
                                }
                                return CloseableReference.of(bitmap2, this.mBitmapPool);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bitmapRegionDecoder2 = r0;
                        }
                    }
                    bitmap2 = null;
                    if (bitmap2 == null) {
                    }
                    this.mDecodeBuffers.release(acquire);
                    if (bitmap == null) {
                    }
                    return CloseableReference.of(bitmap2, this.mBitmapPool);
                } catch (Throwable th3) {
                    this.mDecodeBuffers.release(acquire);
                    throw th3;
                }
            } catch (RuntimeException e) {
                if (bitmap != null) {
                    this.mBitmapPool.release(bitmap);
                }
                throw e;
            }
        } catch (IllegalArgumentException e2) {
            if (bitmap != null) {
                this.mBitmapPool.release(bitmap);
            }
            try {
                inputStream.reset();
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                if (decodeStream != null) {
                    CloseableReference<Bitmap> of = CloseableReference.of(decodeStream, SimpleBitmapReleaser.getInstance());
                    this.mDecodeBuffers.release(acquire);
                    return of;
                }
                throw e2;
            } catch (IOException unused3) {
                throw e2;
            }
        }
    }

    public static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth != -1 && options.outHeight != -1) {
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPreferredConfig = config;
            options.inMutable = true;
            return options;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        boolean z;
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        if (decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888) {
            z = true;
        } else {
            z = false;
        }
        try {
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        boolean z;
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        TailAppendingInputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!isCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        if (decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888) {
            z = true;
        } else {
            z = false;
        }
        try {
            return decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
            }
            throw e;
        }
    }
}
