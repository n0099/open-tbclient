package com.facebook.imagepipeline.platform;

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
/* loaded from: classes7.dex */
public abstract class DefaultDecoder implements PlatformDecoder {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DECODE_BUFFER_SIZE = 16384;
    public static final byte[] EOI_TAIL;
    public static final Class TAG;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool mBitmapPool;
    public final Pools.SynchronizedPool mDecodeBuffers;
    @Nullable
    public final PreverificationHelper mPreverificationHelper;

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

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

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        PreverificationHelper preverificationHelper;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapPool, Integer.valueOf(i), synchronizedPool};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            preverificationHelper = new PreverificationHelper();
        } else {
            preverificationHelper = null;
        }
        this.mPreverificationHelper = preverificationHelper;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = synchronizedPool;
        for (int i4 = 0; i4 < i; i4++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ac A[Catch: all -> 0x00d6, RuntimeException -> 0x00d8, IllegalArgumentException -> 0x00e1, TryCatch #8 {IllegalArgumentException -> 0x00e1, RuntimeException -> 0x00d8, blocks: (B:32:0x0071, B:40:0x0090, B:55:0x00b3, B:47:0x00a4, B:51:0x00ac, B:52:0x00af), top: B:91:0x0071, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3 A[Catch: all -> 0x00d6, RuntimeException -> 0x00d8, IllegalArgumentException -> 0x00e1, TRY_LEAVE, TryCatch #8 {IllegalArgumentException -> 0x00e1, RuntimeException -> 0x00d8, blocks: (B:32:0x0071, B:40:0x0090, B:55:0x00b3, B:47:0x00a4, B:51:0x00ac, B:52:0x00af), top: B:91:0x0071, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private CloseableReference decodeFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeLLLL;
        boolean z;
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapRegionDecoder bitmapRegionDecoder;
        PreverificationHelper preverificationHelper;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, this, inputStream, options, rect, colorSpace)) == null) {
            Preconditions.checkNotNull(inputStream);
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (rect != null) {
                i = rect.width() / options.inSampleSize;
                i2 = rect.height() / options.inSampleSize;
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
                bitmap = (Bitmap) this.mBitmapPool.get(getBitmapSize(i, i2, options));
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
            ByteBuffer byteBuffer = (ByteBuffer) this.mDecodeBuffers.acquire();
            if (byteBuffer == null) {
                byteBuffer = ByteBuffer.allocate(16384);
            }
            try {
                try {
                    options.inTempStorage = byteBuffer.array();
                    if (Build.VERSION.SDK_INT >= 19 && rect != null && bitmap != null) {
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
                                    this.mDecodeBuffers.release(byteBuffer);
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
                        this.mDecodeBuffers.release(byteBuffer);
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
                    this.mDecodeBuffers.release(byteBuffer);
                    if (bitmap == null) {
                    }
                    return CloseableReference.of(bitmap2, this.mBitmapPool);
                } catch (IllegalArgumentException e) {
                    if (bitmap != null) {
                        this.mBitmapPool.release(bitmap);
                    }
                    try {
                        inputStream.reset();
                        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                        if (decodeStream != null) {
                            CloseableReference of = CloseableReference.of(decodeStream, SimpleBitmapReleaser.getInstance());
                            this.mDecodeBuffers.release(byteBuffer);
                            return of;
                        }
                        throw e;
                    } catch (IOException unused3) {
                        throw e;
                    }
                } catch (RuntimeException e2) {
                    if (bitmap != null) {
                        this.mBitmapPool.release(bitmap);
                    }
                    throw e2;
                }
            } catch (Throwable th3) {
                this.mDecodeBuffers.release(byteBuffer);
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
    public CloseableReference decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, encodedImage, config, rect)) == null) {
            return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
        }
        return (CloseableReference) invokeLLL.objValue;
    }

    public CloseableReference decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, inputStream, options, rect)) == null) {
            return decodeFromStream(inputStream, options, rect, null);
        }
        return (CloseableReference) invokeLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeLLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, config, rect, colorSpace)) == null) {
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
        return (CloseableReference) invokeLLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(Constants.METHOD_SEND_USER_MSG, this, encodedImage, config, rect, i)) == null) {
            return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
        }
        return (CloseableReference) invokeLLLI.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{encodedImage, config, rect, Integer.valueOf(i), colorSpace})) == null) {
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
        return (CloseableReference) invokeCommon.objValue;
    }
}
