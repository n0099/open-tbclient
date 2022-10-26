package com.facebook.fresco.animation.bitmap.cache;

import android.graphics.Bitmap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.references.CloseableReference;
import com.facebook.fresco.animation.bitmap.BitmapFrameCache;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class KeepLastFrameCache implements BitmapFrameCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FRAME_NUMBER_UNSET = -1;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public BitmapFrameCache.FrameCacheListener mFrameCacheListener;
    @Nullable
    public CloseableReference mLastBitmapReference;
    public int mLastFrameNumber;

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void onFramePrepared(int i, CloseableReference closeableReference, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), closeableReference, Integer.valueOf(i2)}) == null) {
        }
    }

    public KeepLastFrameCache() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLastFrameNumber = -1;
    }

    private synchronized void closeAndResetLastBitmapReference() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                if (this.mFrameCacheListener != null && this.mLastFrameNumber != -1) {
                    this.mFrameCacheListener.onFrameEvicted(this, this.mLastFrameNumber);
                }
                CloseableReference.closeSafely(this.mLastBitmapReference);
                this.mLastBitmapReference = null;
                this.mLastFrameNumber = -1;
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                closeAndResetLastBitmapReference();
            }
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized int getSizeInBytes() {
        InterceptResult invokeV;
        int sizeInBytes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                if (this.mLastBitmapReference == null) {
                    sizeInBytes = 0;
                } else {
                    sizeInBytes = BitmapUtil.getSizeInBytes((Bitmap) this.mLastBitmapReference.get());
                }
            }
            return sizeInBytes;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized boolean contains(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            synchronized (this) {
                if (i == this.mLastFrameNumber) {
                    if (CloseableReference.isValid(this.mLastBitmapReference)) {
                        z = true;
                    }
                }
                z = false;
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference getCachedFrame(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            synchronized (this) {
                if (this.mLastFrameNumber == i) {
                    return CloseableReference.cloneOrNull(this.mLastBitmapReference);
                }
                return null;
            }
        }
        return (CloseableReference) invokeI.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    @Nullable
    public synchronized CloseableReference getFallbackFrame(int i) {
        InterceptResult invokeI;
        CloseableReference cloneOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            synchronized (this) {
                cloneOrNull = CloseableReference.cloneOrNull(this.mLastBitmapReference);
            }
            return cloneOrNull;
        }
        return (CloseableReference) invokeI.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public void setFrameCacheListener(BitmapFrameCache.FrameCacheListener frameCacheListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, frameCacheListener) == null) {
            this.mFrameCacheListener = frameCacheListener;
        }
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized CloseableReference getBitmapToReuseForFrame(int i, int i2, int i3) {
        InterceptResult invokeIII;
        CloseableReference cloneOrNull;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            synchronized (this) {
                cloneOrNull = CloseableReference.cloneOrNull(this.mLastBitmapReference);
                closeAndResetLastBitmapReference();
            }
            return cloneOrNull;
        }
        return (CloseableReference) invokeIII.objValue;
    }

    @Override // com.facebook.fresco.animation.bitmap.BitmapFrameCache
    public synchronized void onFrameRendered(int i, CloseableReference closeableReference, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), closeableReference, Integer.valueOf(i2)}) == null) {
            synchronized (this) {
                if (closeableReference != null) {
                    if (this.mLastBitmapReference != null && ((Bitmap) closeableReference.get()).equals(this.mLastBitmapReference.get())) {
                        return;
                    }
                }
                CloseableReference.closeSafely(this.mLastBitmapReference);
                if (this.mFrameCacheListener != null && this.mLastFrameNumber != -1) {
                    this.mFrameCacheListener.onFrameEvicted(this, this.mLastFrameNumber);
                }
                this.mLastBitmapReference = CloseableReference.cloneOrNull(closeableReference);
                if (this.mFrameCacheListener != null) {
                    this.mFrameCacheListener.onFrameCached(this, i);
                }
                this.mLastFrameNumber = i;
            }
        }
    }
}
