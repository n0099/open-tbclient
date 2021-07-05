package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolFactory;
/* loaded from: classes6.dex */
public class HoneycombBitmapCreator implements BitmapCreator {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FlexByteArrayPool mFlexByteArrayPool;
    public final EmptyJpegGenerator mJpegGenerator;

    public HoneycombBitmapCreator(PoolFactory poolFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {poolFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFlexByteArrayPool = poolFactory.getFlexByteArrayPool();
        this.mJpegGenerator = new EmptyJpegGenerator(poolFactory.getPooledByteBufferFactory());
    }

    public static BitmapFactory.Options getBitmapFactoryOptions(int i2, Bitmap.Config config) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, config)) == null) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inDither = true;
            options.inPreferredConfig = config;
            options.inPurgeable = true;
            options.inInputShareable = true;
            options.inSampleSize = i2;
            if (Build.VERSION.SDK_INT >= 11) {
                options.inMutable = true;
            }
            return options;
        }
        return (BitmapFactory.Options) invokeIL.objValue;
    }

    @Override // com.facebook.common.webp.BitmapCreator
    @TargetApi(12)
    public Bitmap createNakedBitmap(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        EncodedImage encodedImage;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, config)) != null) {
            return (Bitmap) invokeIIL.objValue;
        }
        CloseableReference<PooledByteBuffer> generate = this.mJpegGenerator.generate((short) i2, (short) i3);
        CloseableReference<byte[]> closeableReference = null;
        try {
            encodedImage = new EncodedImage(generate);
            try {
                encodedImage.setImageFormat(DefaultImageFormats.JPEG);
                BitmapFactory.Options bitmapFactoryOptions = getBitmapFactoryOptions(encodedImage.getSampleSize(), config);
                int size = generate.get().size();
                closeableReference = this.mFlexByteArrayPool.get(size + 2);
                byte[] bArr = closeableReference.get();
                generate.get().read(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, bitmapFactoryOptions);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(generate);
                return decodeByteArray;
            } catch (Throwable th) {
                th = th;
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely(generate);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            encodedImage = null;
        }
    }
}
