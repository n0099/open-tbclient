package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    public static /* synthetic */ Interceptable $ic;
    public static Method sGetFileDescriptorMethod;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public final WebpBitmapFactory mWebpBitmapFactory;

    public GingerbreadPurgeableDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
    }

    public static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> closeableReference, int i2, @Nullable byte[] bArr) throws IOException {
        InterceptResult invokeLIL;
        OutputStream outputStream;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, closeableReference, i2, bArr)) == null) {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = null;
            OutputStream outputStream2 = null;
            MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i2);
            memoryFile.allowPurging(false);
            try {
                pooledByteBufferInputStream = new PooledByteBufferInputStream(closeableReference.get());
                try {
                    limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream, i2);
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    limitedInputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                limitedInputStream = null;
            }
            try {
                outputStream2 = memoryFile.getOutputStream();
                ByteStreams.copy(limitedInputStream, outputStream2);
                if (bArr != null) {
                    memoryFile.writeBytes(bArr, 0, i2, bArr.length);
                }
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream);
                Closeables.closeQuietly(limitedInputStream);
                Closeables.close(outputStream2, true);
                return memoryFile;
            } catch (Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                pooledByteBufferInputStream2 = pooledByteBufferInputStream;
                CloseableReference.closeSafely(closeableReference);
                Closeables.closeQuietly(pooledByteBufferInputStream2);
                Closeables.closeQuietly(limitedInputStream);
                Closeables.close(outputStream, true);
                throw th;
            }
        }
        return (MemoryFile) invokeLIL.objValue;
    }

    private Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, byte[] bArr, BitmapFactory.Options options) {
        InterceptResult invokeLILL;
        MemoryFile copyToMemoryFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, this, closeableReference, i2, bArr, options)) == null) {
            MemoryFile memoryFile = null;
            try {
                try {
                    copyToMemoryFile = copyToMemoryFile(closeableReference, i2, bArr);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                FileDescriptor memoryFileDescriptor = getMemoryFileDescriptor(copyToMemoryFile);
                if (this.mWebpBitmapFactory != null) {
                    Bitmap bitmap = (Bitmap) Preconditions.checkNotNull(this.mWebpBitmapFactory.decodeFileDescriptor(memoryFileDescriptor, null, options), "BitmapFactory returned null");
                    if (copyToMemoryFile != null) {
                        copyToMemoryFile.close();
                    }
                    return bitmap;
                }
                throw new IllegalStateException("WebpBitmapFactory is null");
            } catch (IOException e3) {
                e = e3;
                throw Throwables.propagate(e);
            } catch (Throwable th2) {
                th = th2;
                memoryFile = copyToMemoryFile;
                if (memoryFile != null) {
                    memoryFile.close();
                }
                throw th;
            }
        }
        return (Bitmap) invokeLILL.objValue;
    }

    private synchronized Method getFileDescriptorMethod() {
        InterceptResult invokeV;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                if (sGetFileDescriptorMethod == null) {
                    try {
                        sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
                    } catch (Exception e2) {
                        throw Throwables.propagate(e2);
                    }
                }
                method = sGetFileDescriptorMethod;
            }
            return method;
        }
        return (Method) invokeV.objValue;
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile memoryFile) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, memoryFile)) == null) {
            try {
                return (FileDescriptor) getFileDescriptorMethod().invoke(memoryFile, new Object[0]);
            } catch (Exception e2) {
                throw Throwables.propagate(e2);
            }
        }
        return (FileDescriptor) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, closeableReference, options)) == null) ? decodeFileDescriptorAsPurgeable(closeableReference, closeableReference.get().size(), null, options) : (Bitmap) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, closeableReference, i2, options)) == null) {
            return decodeFileDescriptorAsPurgeable(closeableReference, i2, DalvikPurgeableDecoder.endsWithEOI(closeableReference, i2) ? null : DalvikPurgeableDecoder.EOI, options);
        }
        return (Bitmap) invokeLIL.objValue;
    }
}
