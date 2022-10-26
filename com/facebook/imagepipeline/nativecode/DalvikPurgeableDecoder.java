package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
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
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import java.util.Locale;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public abstract class DalvikPurgeableDecoder implements PlatformDecoder {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] EOI;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapCounter mUnpooledBitmapsCounter;

    public static native void nativePinBitmap(Bitmap bitmap);

    public abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference closeableReference, BitmapFactory.Options options);

    public abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference closeableReference, int i, BitmapFactory.Options options);

    /* loaded from: classes7.dex */
    public class OreoUtils {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public OreoUtils() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static void setColorSpace(BitmapFactory.Options options, @Nullable ColorSpace colorSpace) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, options, colorSpace) == null) {
                if (colorSpace == null) {
                    colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                }
                options.inPreferredColorSpace = colorSpace;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-99979031, "Lcom/facebook/imagepipeline/nativecode/DalvikPurgeableDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-99979031, "Lcom/facebook/imagepipeline/nativecode/DalvikPurgeableDecoder;");
                return;
            }
        }
        ImagePipelineNativeLoader.load();
        EOI = new byte[]{-1, ExifInterface.MARKER_EOI};
    }

    public DalvikPurgeableDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUnpooledBitmapsCounter = BitmapCounterProvider.get();
    }

    public static boolean endsWithEOI(CloseableReference closeableReference, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, closeableReference, i)) == null) {
            PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.get();
            if (i >= 2 && pooledByteBuffer.read(i - 2) == -1 && pooledByteBuffer.read(i - 1) == -39) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    public static BitmapFactory.Options getBitmapFactoryOptions(int i, Bitmap.Config config) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, config)) == null) {
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
        return (BitmapFactory.Options) invokeIL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, encodedImage, config, rect)) == null) {
            return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, null);
        }
        return (CloseableReference) invokeLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, encodedImage, config, rect, colorSpace)) == null) {
            BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
            if (Build.VERSION.SDK_INT >= 26) {
                OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
            }
            CloseableReference byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                return pinBitmap(decodeByteArrayAsPurgeable(byteBufferRef, bitmapFactoryOptions));
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        }
        return (CloseableReference) invokeLLLL.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048580, this, encodedImage, config, rect, i)) == null) {
            return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, null);
        }
        return (CloseableReference) invokeLLLI.objValue;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{encodedImage, config, rect, Integer.valueOf(i), colorSpace})) == null) {
            BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
            if (Build.VERSION.SDK_INT >= 26) {
                OreoUtils.setColorSpace(bitmapFactoryOptions, colorSpace);
            }
            CloseableReference byteBufferRef = encodedImage.getByteBufferRef();
            Preconditions.checkNotNull(byteBufferRef);
            try {
                return pinBitmap(decodeJPEGByteArrayAsPurgeable(byteBufferRef, i, bitmapFactoryOptions));
            } finally {
                CloseableReference.closeSafely(byteBufferRef);
            }
        }
        return (CloseableReference) invokeCommon.objValue;
    }

    public CloseableReference pinBitmap(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bitmap)) == null) {
            Preconditions.checkNotNull(bitmap);
            try {
                nativePinBitmap(bitmap);
                if (this.mUnpooledBitmapsCounter.increase(bitmap)) {
                    return CloseableReference.of(bitmap, this.mUnpooledBitmapsCounter.getReleaser());
                }
                int sizeInBytes = BitmapUtil.getSizeInBytes(bitmap);
                bitmap.recycle();
                throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", Integer.valueOf(sizeInBytes), Integer.valueOf(this.mUnpooledBitmapsCounter.getCount()), Long.valueOf(this.mUnpooledBitmapsCounter.getSize()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxCount()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxSize())));
            } catch (Exception e) {
                bitmap.recycle();
                throw Throwables.propagate(e);
            }
        }
        return (CloseableReference) invokeL.objValue;
    }
}
