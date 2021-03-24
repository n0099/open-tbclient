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
@TargetApi(21)
/* loaded from: classes.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    public static final int DECODE_BUFFER_SIZE = 16384;
    public final BitmapPool mBitmapPool;
    @VisibleForTesting
    public final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;
    @Nullable
    public final PreverificationHelper mPreverificationHelper;
    public static final Class<?> TAG = DefaultDecoder.class;
    public static final byte[] EOI_TAIL = {-1, ExifInterface.MARKER_EOI};

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a2 A[Catch: all -> 0x00cc, RuntimeException -> 0x00ce, IllegalArgumentException -> 0x00d7, TryCatch #8 {IllegalArgumentException -> 0x00d7, RuntimeException -> 0x00ce, blocks: (B:29:0x006d, B:35:0x0086, B:50:0x00a9, B:42:0x009a, B:46:0x00a2, B:47:0x00a5), top: B:83:0x006d, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a9 A[Catch: all -> 0x00cc, RuntimeException -> 0x00ce, IllegalArgumentException -> 0x00d7, TRY_LEAVE, TryCatch #8 {IllegalArgumentException -> 0x00d7, RuntimeException -> 0x00ce, blocks: (B:29:0x006d, B:35:0x0086, B:50:0x00a9, B:42:0x009a, B:46:0x00a2, B:47:0x00a5), top: B:83:0x006d, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b4 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CloseableReference<Bitmap> decodeFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect, boolean z) {
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapRegionDecoder bitmapRegionDecoder;
        PreverificationHelper preverificationHelper;
        Preconditions.checkNotNull(inputStream);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (rect != null) {
            i = rect.width() / options.inSampleSize;
            i2 = rect.height() / options.inSampleSize;
        }
        boolean z2 = Build.VERSION.SDK_INT >= 26 && (preverificationHelper = this.mPreverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
        BitmapRegionDecoder bitmapRegionDecoder2 = null;
        if (rect == null && z2) {
            options.inMutable = false;
            bitmap = null;
        } else {
            if (rect != null && z2) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            }
            bitmap = this.mBitmapPool.get(getBitmapSize(i, i2, options));
            if (bitmap == null) {
                throw new NullPointerException("BitmapPool.get returned null");
            }
        }
        options.inBitmap = bitmap;
        if (Build.VERSION.SDK_INT >= 26 && z) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        ByteBuffer acquire = this.mDecodeBuffers.acquire();
        if (acquire == null) {
            acquire = ByteBuffer.allocate(16384);
        }
        try {
            try {
                options.inTempStorage = acquire.array();
                if (rect != null && bitmap != null) {
                    try {
                        bitmap.reconfigure(i, i2, options.inPreferredConfig);
                        bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, true);
                        try {
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
                        } catch (Throwable th) {
                            th = th;
                            bitmapRegionDecoder2 = bitmapRegionDecoder;
                            if (bitmapRegionDecoder2 != null) {
                                bitmapRegionDecoder2.recycle();
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        bitmapRegionDecoder = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bitmapRegionDecoder2 != null) {
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
        } catch (RuntimeException e3) {
            if (bitmap != null) {
                this.mBitmapPool.release(bitmap);
            }
            throw e3;
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
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, false);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, boolean z) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z2 = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, z);
        } catch (RuntimeException e2) {
            if (z2) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, z);
            }
            throw e2;
        }
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, false);
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, boolean z) {
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
        boolean z2 = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(inputStream, decodeOptionsForStream, rect, z);
        } catch (RuntimeException e2) {
            if (z2) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, z);
            }
            throw e2;
        }
    }

    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, false);
    }

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);
}
