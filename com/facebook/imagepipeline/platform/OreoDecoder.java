package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import androidx.core.util.Pools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(26)
/* loaded from: classes7.dex */
public class OreoDecoder extends DefaultDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OreoDecoder(BitmapPool bitmapPool, int i, Pools.SynchronizedPool synchronizedPool) {
        super(bitmapPool, i, synchronizedPool);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmapPool, Integer.valueOf(i), synchronizedPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BitmapPool) objArr2[0], ((Integer) objArr2[1]).intValue(), (Pools.SynchronizedPool) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean hasColorGamutMismatch(BitmapFactory.Options options) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, options)) == null) {
            ColorSpace colorSpace = options.outColorSpace;
            if (colorSpace != null && colorSpace.isWideGamut() && options.inPreferredConfig != Bitmap.Config.RGBA_F16) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.facebook.imagepipeline.platform.DefaultDecoder
    public int getBitmapSize(int i, int i2, BitmapFactory.Options options) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048576, this, i, i2, options)) == null) {
            if (hasColorGamutMismatch(options)) {
                return i * i2 * 8;
            }
            return BitmapUtil.getSizeInByteForBitmap(i, i2, options.inPreferredConfig);
        }
        return invokeIIL.intValue;
    }
}
