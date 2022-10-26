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
/* loaded from: classes7.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();
    }

    public static MemoryFile copyToMemoryFile(CloseableReference closeableReference, int i, @Nullable byte[] bArr) throws IOException {
        InterceptResult invokeLIL;
        int length;
        OutputStream outputStream;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65537, null, closeableReference, i, bArr)) == null) {
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            PooledByteBufferInputStream pooledByteBufferInputStream2 = null;
            OutputStream outputStream2 = null;
            MemoryFile memoryFile = new MemoryFile(null, length + i);
            memoryFile.allowPurging(false);
            try {
                pooledByteBufferInputStream = new PooledByteBufferInputStream((PooledByteBuffer) closeableReference.get());
                try {
                    limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream, i);
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
                    memoryFile.writeBytes(bArr, 0, i, bArr.length);
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

    private Bitmap decodeFileDescriptorAsPurgeable(CloseableReference closeableReference, int i, byte[] bArr, BitmapFactory.Options options) {
        InterceptResult invokeLILL;
        MemoryFile copyToMemoryFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLILL = interceptable.invokeLILL(65538, this, closeableReference, i, bArr, options)) == null) {
            MemoryFile memoryFile = null;
            try {
                try {
                    copyToMemoryFile = copyToMemoryFile(closeableReference, i, bArr);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
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
            } catch (IOException e2) {
                e = e2;
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
                    } catch (Exception e) {
                        throw Throwables.propagate(e);
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
            } catch (Exception e) {
                throw Throwables.propagate(e);
            }
        }
        return (FileDescriptor) invokeL.objValue;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference closeableReference, BitmapFactory.Options options) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, closeableReference, options)) == null) {
            return decodeFileDescriptorAsPurgeable(closeableReference, ((PooledByteBuffer) closeableReference.get()).size(), null, options);
        }
        return (Bitmap) invokeLL.objValue;
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference closeableReference, int i, BitmapFactory.Options options) {
        InterceptResult invokeLIL;
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, closeableReference, i, options)) == null) {
            if (DalvikPurgeableDecoder.endsWithEOI(closeableReference, i)) {
                bArr = null;
            } else {
                bArr = DalvikPurgeableDecoder.EOI;
            }
            return decodeFileDescriptorAsPurgeable(closeableReference, i, bArr, options);
        }
        return (Bitmap) invokeLIL.objValue;
    }
}
