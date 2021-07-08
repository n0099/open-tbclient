package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(19)
/* loaded from: classes5.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFlexByteArrayPool = flexByteArrayPool;
    }

    public static void putEOI(byte[] bArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, bArr, i2) == null) {
            bArr[i2] = -1;
            bArr[i2 + 1] = -39;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, closeableReference, options)) == null) {
            PooledByteBuffer pooledByteBuffer = closeableReference.get();
            int size = pooledByteBuffer.size();
            CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(size);
            try {
                byte[] bArr = closeableReference2.get();
                pooledByteBuffer.read(0, bArr, 0, size);
                return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
            }
        }
        return (Bitmap) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, closeableReference, i2, options)) == null) {
            byte[] bArr = DalvikPurgeableDecoder.endsWithEOI(closeableReference, i2) ? null : DalvikPurgeableDecoder.EOI;
            PooledByteBuffer pooledByteBuffer = closeableReference.get();
            Preconditions.checkArgument(i2 <= pooledByteBuffer.size());
            int i3 = i2 + 2;
            CloseableReference<byte[]> closeableReference2 = this.mFlexByteArrayPool.get(i3);
            try {
                byte[] bArr2 = closeableReference2.get();
                pooledByteBuffer.read(0, bArr2, 0, i2);
                if (bArr != null) {
                    putEOI(bArr2, i2);
                    i2 = i3;
                }
                return (Bitmap) Preconditions.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i2, options), "BitmapFactory returned null");
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) closeableReference2);
            }
        }
        return (Bitmap) invokeLIL.objValue;
    }
}
