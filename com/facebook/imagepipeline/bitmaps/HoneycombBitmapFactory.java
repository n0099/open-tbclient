package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(11)
/* loaded from: classes7.dex */
public class HoneycombBitmapFactory extends PlatformBitmapFactory {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HoneycombBitmapFactory";
    public transient /* synthetic */ FieldHolder $fh;
    public final CloseableReferenceFactory mCloseableReferenceFactory;
    public boolean mImmutableBitmapFallback;
    public final EmptyJpegGenerator mJpegGenerator;
    public final PlatformDecoder mPurgeableDecoder;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1260612496, "Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1260612496, "Lcom/facebook/imagepipeline/bitmaps/HoneycombBitmapFactory;");
        }
    }

    public HoneycombBitmapFactory(EmptyJpegGenerator emptyJpegGenerator, PlatformDecoder platformDecoder, CloseableReferenceFactory closeableReferenceFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {emptyJpegGenerator, platformDecoder, closeableReferenceFactory};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mJpegGenerator = emptyJpegGenerator;
        this.mPurgeableDecoder = platformDecoder;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    private CloseableReference<Bitmap> createFallbackBitmap(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(65538, this, i2, i3, config)) == null) ? this.mCloseableReferenceFactory.create(Bitmap.createBitmap(i2, i3, config), SimpleBitmapReleaser.getInstance()) : (CloseableReference) invokeIIL.objValue;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    @TargetApi(12)
    public CloseableReference<Bitmap> createBitmapInternal(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, config)) == null) {
            if (this.mImmutableBitmapFallback) {
                return createFallbackBitmap(i2, i3, config);
            }
            CloseableReference<PooledByteBuffer> generate = this.mJpegGenerator.generate((short) i2, (short) i3);
            try {
                EncodedImage encodedImage = new EncodedImage(generate);
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                CloseableReference<Bitmap> decodeJPEGFromEncodedImage = this.mPurgeableDecoder.decodeJPEGFromEncodedImage(encodedImage, config, null, generate.get().size());
                if (!decodeJPEGFromEncodedImage.get().isMutable()) {
                    CloseableReference.closeSafely(decodeJPEGFromEncodedImage);
                    this.mImmutableBitmapFallback = true;
                    FLog.wtf(TAG, "Immutable bitmap returned by decoder");
                    CloseableReference<Bitmap> createFallbackBitmap = createFallbackBitmap(i2, i3, config);
                    EncodedImage.closeSafely(encodedImage);
                    return createFallbackBitmap;
                }
                decodeJPEGFromEncodedImage.get().setHasAlpha(true);
                decodeJPEGFromEncodedImage.get().eraseColor(0);
                EncodedImage.closeSafely(encodedImage);
                return decodeJPEGFromEncodedImage;
            } finally {
                generate.close();
            }
        }
        return (CloseableReference) invokeIIL.objValue;
    }
}
