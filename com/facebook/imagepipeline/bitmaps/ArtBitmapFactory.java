package com.facebook.imagepipeline.bitmaps;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(21)
/* loaded from: classes11.dex */
public class ArtBitmapFactory extends PlatformBitmapFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BitmapPool mBitmapPool;
    public final CloseableReferenceFactory mCloseableReferenceFactory;

    public ArtBitmapFactory(BitmapPool bitmapPool, CloseableReferenceFactory closeableReferenceFactory) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapPool, closeableReferenceFactory};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBitmapPool = bitmapPool;
        this.mCloseableReferenceFactory = closeableReferenceFactory;
    }

    @Override // com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory
    public CloseableReference<Bitmap> createBitmapInternal(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i2, i3, config)) == null) {
            Bitmap bitmap = this.mBitmapPool.get(BitmapUtil.getSizeInByteForBitmap(i2, i3, config));
            Preconditions.checkArgument(bitmap.getAllocationByteCount() >= (i2 * i3) * BitmapUtil.getPixelSizeForBitmapConfig(config));
            bitmap.reconfigure(i2, i3, config);
            return this.mCloseableReferenceFactory.create(bitmap, this.mBitmapPool);
        }
        return (CloseableReference) invokeIIL.objValue;
    }
}
