package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
@DoNotStrip
/* loaded from: classes5.dex */
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "NativeMemoryChunk";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsClosed;
    public final long mNativePtr;
    public final int mSize;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-660984397, "Lcom/facebook/imagepipeline/memory/NativeMemoryChunk;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-660984397, "Lcom/facebook/imagepipeline/memory/NativeMemoryChunk;");
                return;
            }
        }
        ImagePipelineNativeLoader.load();
    }

    public NativeMemoryChunk(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Preconditions.checkArgument(i2 > 0);
        this.mSize = i2;
        this.mNativePtr = nativeAllocate(i2);
        this.mIsClosed = false;
    }

    private void doCopy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), memoryChunk, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            if (memoryChunk instanceof NativeMemoryChunk) {
                Preconditions.checkState(!isClosed());
                Preconditions.checkState(!memoryChunk.isClosed());
                MemoryChunkUtil.checkBounds(i2, memoryChunk.getSize(), i3, i4, this.mSize);
                nativeMemcpy(memoryChunk.getNativePtr() + i3, this.mNativePtr + i2, i4);
                return;
            }
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
    }

    @DoNotStrip
    public static native long nativeAllocate(int i2);

    @DoNotStrip
    public static native void nativeCopyFromByteArray(long j, byte[] bArr, int i2, int i3);

    @DoNotStrip
    public static native void nativeCopyToByteArray(long j, byte[] bArr, int i2, int i3);

    @DoNotStrip
    public static native void nativeFree(long j);

    @DoNotStrip
    public static native void nativeMemcpy(long j, long j2, int i2);

    @DoNotStrip
    public static native byte nativeReadByte(long j);

    @Override // com.facebook.imagepipeline.memory.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (this) {
                if (!this.mIsClosed) {
                    this.mIsClosed = true;
                    nativeFree(this.mNativePtr);
                }
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i2, MemoryChunk memoryChunk, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), memoryChunk, Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            Preconditions.checkNotNull(memoryChunk);
            if (memoryChunk.getUniqueId() == getUniqueId()) {
                Log.w(TAG, "Copying from NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(this)) + " to NativeMemoryChunk " + Integer.toHexString(System.identityHashCode(memoryChunk)) + " which share the same address " + Long.toHexString(this.mNativePtr));
                Preconditions.checkArgument(false);
            }
            if (memoryChunk.getUniqueId() < getUniqueId()) {
                synchronized (memoryChunk) {
                    synchronized (this) {
                        doCopy(i2, memoryChunk, i3, i4);
                    }
                }
                return;
            }
            synchronized (this) {
                synchronized (memoryChunk) {
                    doCopy(i2, memoryChunk, i3, i4);
                }
            }
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || isClosed()) {
            return;
        }
        Log.w(TAG, "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    @Nullable
    public ByteBuffer getByteBuffer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mNativePtr : invokeV.longValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mSize : invokeV.intValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mNativePtr : invokeV.longValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                z = this.mIsClosed;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        int adjustByteCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(bArr);
                Preconditions.checkState(!isClosed());
                adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
                MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
                nativeCopyToByteArray(this.mNativePtr + i2, bArr, i3, adjustByteCount);
            }
            return adjustByteCount;
        }
        return invokeCommon.intValue;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i2, byte[] bArr, int i3, int i4) {
        InterceptResult invokeCommon;
        int adjustByteCount;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            synchronized (this) {
                Preconditions.checkNotNull(bArr);
                Preconditions.checkState(!isClosed());
                adjustByteCount = MemoryChunkUtil.adjustByteCount(i2, i4, this.mSize);
                MemoryChunkUtil.checkBounds(i2, bArr.length, i3, adjustByteCount, this.mSize);
                nativeCopyFromByteArray(this.mNativePtr + i2, bArr, i3, adjustByteCount);
            }
            return adjustByteCount;
        }
        return invokeCommon.intValue;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mSize = 0;
        this.mNativePtr = 0L;
        this.mIsClosed = true;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i2) {
        InterceptResult invokeI;
        byte nativeReadByte;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            synchronized (this) {
                boolean z = true;
                Preconditions.checkState(!isClosed());
                Preconditions.checkArgument(i2 >= 0);
                if (i2 >= this.mSize) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                nativeReadByte = nativeReadByte(this.mNativePtr + i2);
            }
            return nativeReadByte;
        }
        return invokeI.byteValue;
    }
}
