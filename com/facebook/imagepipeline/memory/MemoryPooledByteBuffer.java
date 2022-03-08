package com.facebook.imagepipeline.memory;

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

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {closeableReference, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Preconditions.checkNotNull(closeableReference);
        Preconditions.checkArgument(i2 >= 0 && i2 <= closeableReference.get().getSize());
        this.mBufRef = closeableReference.m111clone();
        this.mSize = i2;
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

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized long getNativePtr() throws UnsupportedOperationException {
        InterceptResult invokeV;
        long nativePtr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                z = !CloseableReference.isValid(this.mBufRef);
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte read(int i2) {
        InterceptResult invokeI;
        byte read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            synchronized (this) {
                ensureValid();
                boolean z = true;
                Preconditions.checkArgument(i2 >= 0);
                if (i2 >= this.mSize) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                read = this.mBufRef.get().read(i2);
            }
            return read;
        }
        return invokeI.byteValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                ensureValid();
                i2 = this.mSize;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int read(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            synchronized (this) {
                ensureValid();
                Preconditions.checkArgument(i2 + i4 <= this.mSize);
                read = this.mBufRef.get().read(i2, bArr, i3, i4);
            }
            return read;
        }
        return invokeCommon.intValue;
    }
}
