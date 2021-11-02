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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes11.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DECODE_BUFFER_SIZE = 16384;
    public static final byte[] EOI_TAIL;
    public static final Class<?> TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool mBitmapPool;
    @VisibleForTesting
    public final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;
    @Nullable
    public final PreverificationHelper mPreverificationHelper;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1337056253, "Lcom/facebook/imagepipeline/platform/DefaultDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1337056253, "Lcom/facebook/imagepipeline/platform/DefaultDecoder;");
                return;
            }
        }
        TAG = DefaultDecoder.class;
        EOI_TAIL = new byte[]{-1, ExifInterface.MARKER_EOI};
    }

    public DefaultDecoder(BitmapPool bitmapPool, int i2, Pools.SynchronizedPool synchronizedPool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapPool, Integer.valueOf(i2), synchronizedPool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i5 = 0; i5 < i2; i5++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac A[Catch: all -> 0x00d6, RuntimeException -> 0x00d8, IllegalArgumentException -> 0x00e1, TryCatch #8 {IllegalArgumentException -> 0x00e1, RuntimeException -> 0x00d8, blocks: (B:32:0x0071, B:40:0x0090, B:55:0x00b3, B:47:0x00a4, B:51:0x00ac, B:52:0x00af), top: B:91:0x0071, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3 A[Catch: all -> 0x00d6, RuntimeException -> 0x00d8, IllegalArgumentException -> 0x00e1, TRY_LEAVE, TryCatch #8 {IllegalArgumentException -> 0x00e1, RuntimeException -> 0x00d8, blocks: (B:32:0x0071, B:40:0x0090, B:55:0x00b3, B:47:0x00a4, B:51:0x00ac, B:52:0x00af), top: B:91:0x0071, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CloseableReference<Bitmap> decodeFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeLLLL;
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapRegionDecoder bitmapRegionDecoder;
        PreverificationHelper preverificationHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, inputStream, options, rect, colorSpace)) == null) {
            Preconditions.checkNotNull(inputStream);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            if (rect != null) {
                i2 = rect.width() / options.inSampleSize;
                i3 = rect.height() / options.inSampleSize;
            }
            boolean z = Build.VERSION.SDK_INT >= 26 && (preverificationHelper = this.mPreverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
            BitmapRegionDecoder bitmapRegionDecoder2 = null;
            if (rect == null && z) {
                options.inMutable = false;
                bitmap = null;
            } else {
                if (rect != null && z) {
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
                bitmap = this.mBitmapPool.get(getBitmapSize(i2, i3, options));
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
                    options.inTempStorage = acquire.array();
                    if (Build.VERSION.SDK_INT >= 19 && rect != null && bitmap != null) {
                        try {
                            bitmap.reconfigure(i2, i3, options.inPreferredConfig);
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
            } catch (Throwable th3) {
                this.mDecodeBuffers.release(acquire);
                throw th3;
            }
        }
        return (CloseableReference) invokeLLLL.objValue;
    }

    public static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, encodedImage, config)) == null) {
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
        return (BitmapFactory.Options) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, encodedImage, config, rect)) == null) ? decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null) : (CloseableReference) invokeLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, config, rect, colorSpace)) == null) {
            BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
            boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
            try {
                return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, colorSpace);
            } catch (RuntimeException e2) {
                if (z) {
                    return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
                }
                throw e2;
            }
        }
        return (CloseableReference) invokeLLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, encodedImage, config, rect, i2)) == null) ? decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i2, null) : (CloseableReference) invokeLLLI.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i2, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{encodedImage, config, rect, Integer.valueOf(i2), colorSpace})) == null) {
            boolean isCompleteAt = encodedImage.isCompleteAt(i2);
            BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
            TailAppendingInputStream inputStream = encodedImage.getInputStream();
            Preconditions.checkNotNull(inputStream);
            if (encodedImage.getSize() > i2) {
                inputStream = new LimitedInputStream(inputStream, i2);
            }
            if (!isCompleteAt) {
                inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
            }
            boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
            try {
                return decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
            } catch (RuntimeException e2) {
                if (z) {
                    return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i2, colorSpace);
                }
                throw e2;
            }
        }
        return (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, inputStream, options, rect)) == null) ? decodeFromStream(inputStream, options, rect, null) : (CloseableReference) invokeLLL.objValue;
    }

    public abstract int getBitmapSize(int i2, int i3, BitmapFactory.Options options);
}
