package com.facebook.imagepipeline.memory;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MemoryChunkPool mPool;
    public final PooledByteStreams mPooledByteStreams;

    public MemoryPooledByteBufferFactory(MemoryChunkPool memoryChunkPool, PooledByteStreams pooledByteStreams) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {memoryChunkPool, pooledByteStreams};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPool = memoryChunkPool;
        this.mPooledByteStreams = pooledByteStreams;
    }

    @VisibleForTesting
    public MemoryPooledByteBuffer newByteBuf(InputStream inputStream, MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, inputStream, memoryPooledByteBufferOutputStream)) == null) {
            this.mPooledByteStreams.copy(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.toByteBuffer();
        }
        return (MemoryPooledByteBuffer) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            return new MemoryPooledByteBufferOutputStream(this.mPool, i);
        }
        return (MemoryPooledByteBufferOutputStream) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i > 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z);
            CloseableReference of = CloseableReference.of(this.mPool.get(i), this.mPool);
            try {
                return new MemoryPooledByteBuffer(of, i);
            } finally {
                of.close();
            }
        }
        return (MemoryPooledByteBuffer) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, inputStream)) == null) {
            MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool);
            try {
                return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
            } finally {
                memoryPooledByteBufferOutputStream.close();
            }
        }
        return (MemoryPooledByteBuffer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(InputStream inputStream, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, inputStream, i)) == null) {
            MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, i);
            try {
                return newByteBuf(inputStream, memoryPooledByteBufferOutputStream);
            } finally {
                memoryPooledByteBufferOutputStream.close();
            }
        }
        return (MemoryPooledByteBuffer) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBuffer newByteBuffer(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr)) == null) {
            MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, bArr.length);
            try {
                try {
                    memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                    return memoryPooledByteBufferOutputStream.toByteBuffer();
                } catch (IOException e) {
                    throw Throwables.propagate(e);
                }
            } finally {
                memoryPooledByteBufferOutputStream.close();
            }
        }
        return (MemoryPooledByteBuffer) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public MemoryPooledByteBufferOutputStream newOutputStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new MemoryPooledByteBufferOutputStream(this.mPool);
        }
        return (MemoryPooledByteBufferOutputStream) invokeV.objValue;
    }
}
