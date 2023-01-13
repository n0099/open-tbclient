package com.facebook.imagepipeline.memory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @VisibleForTesting
    @GuardedBy("this")
    public CloseableReference<MemoryChunk> mBufRef;
    public final int mSize;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReference, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(closeableReference);
        if (i >= 0 && i <= closeableReference.get().getSize()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.mBufRef = closeableReference.mo81clone();
        this.mSize = i;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                CloseableReference.closeSafely(this.mBufRef);
                this.mBufRef = null;
            }
        }
    }

    public synchronized void ensureValid() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                if (isClosed()) {
                    throw new PooledByteBuffer.ClosedException();
                }
            }
        }
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    @Nullable
    public synchronized ByteBuffer getByteBuffer() {
        InterceptResult invokeV;
        ByteBuffer byteBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            synchronized (this) {
                byteBuffer = this.mBufRef.get().getByteBuffer();
            }
            return byteBuffer;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @VisibleForTesting
    @GuardedBy("this")
    public CloseableReference<MemoryChunk> getCloseableReference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mBufRef;
        }
        return (CloseableReference) invokeV.objValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long getNativePtr() throws UnsupportedOperationException {
        InterceptResult invokeV;
        long nativePtr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                ensureValid();
                nativePtr = this.mBufRef.get().getNativePtr();
            }
            return nativePtr;
        }
        return invokeV.longValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                z = !CloseableReference.isValid(this.mBufRef);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                ensureValid();
                i = this.mSize;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte read(int i) {
        InterceptResult invokeI;
        boolean z;
        byte read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            synchronized (this) {
                ensureValid();
                boolean z2 = true;
                if (i >= 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                if (i >= this.mSize) {
                    z2 = false;
                }
                Preconditions.checkArgument(z2);
                read = this.mBufRef.get().read(i);
            }
            return read;
        }
        return invokeI.byteValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        InterceptResult invokeCommon;
        boolean z;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), bArr, Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            synchronized (this) {
                ensureValid();
                if (i + i3 <= this.mSize) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z);
                read = this.mBufRef.get().read(i, bArr, i2, i3);
            }
            return read;
        }
        return invokeCommon.intValue;
    }
}
