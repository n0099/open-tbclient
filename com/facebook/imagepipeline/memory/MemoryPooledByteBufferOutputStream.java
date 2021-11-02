package com.facebook.imagepipeline.memory;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import javax.annotation.concurrent.NotThreadSafe;
@NotThreadSafe
/* loaded from: classes11.dex */
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CloseableReference<MemoryChunk> mBufRef;
    public int mCount;
    public final MemoryChunkPool mPool;

    /* loaded from: classes11.dex */
    public static class InvalidStreamException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidStreamException() {
            super("OutputStream no longer valid");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool) {
        this(memoryChunkPool, memoryChunkPool.getMinBufferSize());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryChunkPool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((MemoryChunkPool) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void ensureValid() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, this) == null) && !CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            CloseableReference.closeSafely(this.mBufRef);
            this.mBufRef = null;
            this.mCount = -1;
            super.close();
        }
    }

    @VisibleForTesting
    public void realloc(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            ensureValid();
            if (i2 <= this.mBufRef.get().getSize()) {
                return;
            }
            MemoryChunk memoryChunk = this.mPool.get(i2);
            this.mBufRef.get().copy(0, memoryChunk, 0, this.mCount);
            this.mBufRef.close();
            this.mBufRef = CloseableReference.of(memoryChunk, this.mPool);
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCount : invokeV.intValue;
    }

    @Override // java.io.OutputStream
    public void write(int i2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            write(new byte[]{(byte) i2});
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryChunkPool, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 > 0);
        MemoryChunkPool memoryChunkPool2 = (MemoryChunkPool) Preconditions.checkNotNull(memoryChunkPool);
        this.mPool = memoryChunkPool2;
        this.mCount = 0;
        this.mBufRef = CloseableReference.of(memoryChunkPool2.get(i2), this.mPool);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferOutputStream
    public MemoryPooledByteBuffer toByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ensureValid();
            return new MemoryPooledByteBuffer(this.mBufRef, this.mCount);
        }
        return (MemoryPooledByteBuffer) invokeV.objValue;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, bArr, i2, i3) == null) {
            if (i2 >= 0 && i3 >= 0 && i2 + i3 <= bArr.length) {
                ensureValid();
                realloc(this.mCount + i3);
                this.mBufRef.get().write(this.mCount, bArr, i2, i3);
                this.mCount += i3;
                return;
            }
            throw new ArrayIndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
    }
}
