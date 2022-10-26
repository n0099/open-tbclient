package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
/* loaded from: classes7.dex */
public class KitKatPurgeableDecoder extends DalvikPurgeableDecoder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FlexByteArrayPool mFlexByteArrayPool;

    public KitKatPurgeableDecoder(FlexByteArrayPool flexByteArrayPool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flexByteArrayPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFlexByteArrayPool = flexByteArrayPool;
    }

    public static void putEOI(byte[] bArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, bArr, i) == null) {
            bArr[i] = -1;
            bArr[i + 1] = ExifInterface.MARKER_EOI;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference closeableReference, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, closeableReference, options)) == null) {
            PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.get();
            int size = pooledByteBuffer.size();
            CloseableReference closeableReference2 = this.mFlexByteArrayPool.get(size);
            try {
                byte[] bArr = (byte[]) closeableReference2.get();
                pooledByteBuffer.read(0, bArr, 0, size);
                return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
            } finally {
                CloseableReference.closeSafely(closeableReference2);
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference closeableReference, int i, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        byte[] bArr;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, closeableReference, i, options)) == null) {
            if (DalvikPurgeableDecoder.endsWithEOI(closeableReference, i)) {
                bArr = null;
            } else {
                bArr = DalvikPurgeableDecoder.EOI;
            }
            PooledByteBuffer pooledByteBuffer = (PooledByteBuffer) closeableReference.get();
            if (i <= pooledByteBuffer.size()) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            int i2 = i + 2;
            CloseableReference closeableReference2 = this.mFlexByteArrayPool.get(i2);
            try {
                byte[] bArr2 = (byte[]) closeableReference2.get();
                pooledByteBuffer.read(0, bArr2, 0, i);
                if (bArr != null) {
                    putEOI(bArr2, i);
                    i = i2;
                }
                return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
            } finally {
                CloseableReference.closeSafely(closeableReference2);
            }
        }
        return (Bitmap) invokeLIL.objValue;
    }
}
