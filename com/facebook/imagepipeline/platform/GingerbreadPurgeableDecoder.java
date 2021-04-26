package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
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
/* loaded from: classes6.dex */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {
    public static Method sGetFileDescriptorMethod;
    @Nullable
    public final WebpBitmapFactory mWebpBitmapFactory = WebpSupportStatus.loadWebpBitmapFactoryIfExists();

    public static MemoryFile copyToMemoryFile(CloseableReference<PooledByteBuffer> closeableReference, int i2, @Nullable byte[] bArr) throws IOException {
        OutputStream outputStream;
        LimitedInputStream limitedInputStream;
        PooledByteBufferInputStream pooledByteBufferInputStream = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i2);
        memoryFile.allowPurging(false);
        try {
            PooledByteBufferInputStream pooledByteBufferInputStream2 = new PooledByteBufferInputStream(closeableReference.get());
            try {
                limitedInputStream = new LimitedInputStream(pooledByteBufferInputStream2, i2);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    ByteStreams.copy(limitedInputStream, outputStream2);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i2, bArr.length);
                    }
                    CloseableReference.closeSafely(closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream2);
                    Closeables.closeQuietly(limitedInputStream);
                    Closeables.close(outputStream2, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    pooledByteBufferInputStream = pooledByteBufferInputStream2;
                    CloseableReference.closeSafely(closeableReference);
                    Closeables.closeQuietly(pooledByteBufferInputStream);
                    Closeables.closeQuietly(limitedInputStream);
                    Closeables.close(outputStream, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                limitedInputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            limitedInputStream = null;
        }
    }

    private Bitmap decodeFileDescriptorAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile copyToMemoryFile;
        MemoryFile memoryFile = null;
        try {
            try {
                copyToMemoryFile = copyToMemoryFile(closeableReference, i2, bArr);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
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
            memoryFile = copyToMemoryFile;
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

    private synchronized Method getFileDescriptorMethod() {
        if (sGetFileDescriptorMethod == null) {
            try {
                sGetFileDescriptorMethod = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e2) {
                throw Throwables.propagate(e2);
            }
        }
        return sGetFileDescriptorMethod;
    }

    private FileDescriptor getMemoryFileDescriptor(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) getFileDescriptorMethod().invoke(memoryFile, new Object[0]);
        } catch (Exception e2) {
            throw Throwables.propagate(e2);
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, closeableReference.get().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> closeableReference, int i2, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(closeableReference, i2, DalvikPurgeableDecoder.endsWithEOI(closeableReference, i2) ? null : DalvikPurgeableDecoder.EOI, options);
    }
}
