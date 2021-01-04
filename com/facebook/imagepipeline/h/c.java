package com.facebook.imagepipeline.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.MemoryFile;
import com.facebook.common.internal.g;
import com.facebook.common.internal.l;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.h;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class c extends b {
    private static Method pDW;

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        return super.a(eVar, config, rect);
    }

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        return super.a(eVar, config, rect, i);
    }

    @Override // com.facebook.imagepipeline.h.b
    public /* bridge */ /* synthetic */ com.facebook.common.references.a ai(Bitmap bitmap) {
        return super.ai(bitmap);
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        return a(aVar, aVar.get().size(), (byte[]) null, options);
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options) {
        return a(aVar, i, b(aVar, i) ? null : pDU, options);
    }

    private static MemoryFile a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, @Nullable byte[] bArr) throws IOException {
        OutputStream outputStream;
        com.facebook.common.f.a aVar2;
        h hVar;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            hVar = new h(aVar.get());
            try {
                aVar2 = new com.facebook.common.f.a(hVar, i);
                try {
                    outputStream = memoryFile.getOutputStream();
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                }
                try {
                    com.facebook.common.internal.a.copy(aVar2, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.internal.b.u(hVar);
                    com.facebook.common.internal.b.u(aVar2);
                    com.facebook.common.internal.b.close(outputStream, true);
                    return memoryFile;
                } catch (Throwable th2) {
                    th = th2;
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.internal.b.u(hVar);
                    com.facebook.common.internal.b.u(aVar2);
                    com.facebook.common.internal.b.close(outputStream, true);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                aVar2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            aVar2 = null;
            hVar = null;
        }
    }

    private synchronized Method eAb() {
        if (pDW == null) {
            try {
                pDW = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw l.t(e);
            }
        }
        return pDW;
    }

    private FileDescriptor a(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) eAb().invoke(memoryFile, new Object[0]);
        } catch (Exception e) {
            throw l.t(e);
        }
    }

    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile memoryFile = null;
        try {
            try {
                memoryFile = a(aVar, i, bArr);
                return (Bitmap) g.checkNotNull(com.facebook.common.g.c.ptR.decodeFileDescriptor(a(memoryFile), null, options), "BitmapFactory returned null");
            } catch (IOException e) {
                throw l.t(e);
            }
        } finally {
            if (memoryFile != null) {
                memoryFile.close();
            }
        }
    }
}
