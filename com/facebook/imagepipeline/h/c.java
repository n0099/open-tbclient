package com.facebook.imagepipeline.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.internal.g;
import com.facebook.common.internal.k;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.h;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class c extends b {
    private static Method kko;

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config) {
        return super.a(dVar, config);
    }

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config, int i) {
        return super.a(dVar, config, i);
    }

    @Override // com.facebook.imagepipeline.h.b
    public /* bridge */ /* synthetic */ com.facebook.common.references.a ab(Bitmap bitmap) {
        return super.ab(bitmap);
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        return a(aVar, aVar.get().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options) {
        return a(aVar, i, a(aVar, i) ? null : kkm, options);
    }

    private static MemoryFile a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, @Nullable byte[] bArr) throws IOException {
        OutputStream outputStream;
        h hVar;
        com.facebook.common.f.a aVar2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            h hVar2 = new h(aVar.get());
            try {
                com.facebook.common.f.a aVar3 = new com.facebook.common.f.a(hVar2, i);
                try {
                    outputStream = memoryFile.getOutputStream();
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    aVar2 = aVar3;
                    hVar = hVar2;
                }
                try {
                    com.facebook.common.internal.a.g(aVar3, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.internal.b.q(hVar2);
                    com.facebook.common.internal.b.q(aVar3);
                    com.facebook.common.internal.b.a(outputStream, true);
                    return memoryFile;
                } catch (Throwable th2) {
                    th = th2;
                    aVar2 = aVar3;
                    hVar = hVar2;
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.internal.b.q(hVar);
                    com.facebook.common.internal.b.q(aVar2);
                    com.facebook.common.internal.b.a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                hVar = hVar2;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream = null;
            hVar = null;
        }
    }

    private synchronized Method cKV() {
        if (kko == null) {
            try {
                kko = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw k.r(e);
            }
        }
        return kko;
    }

    private FileDescriptor a(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) cKV().invoke(memoryFile, new Object[0]);
        } catch (Exception e) {
            throw k.r(e);
        }
    }

    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile memoryFile = null;
        try {
            try {
                memoryFile = a(aVar, i, bArr);
                return (Bitmap) g.checkNotNull(com.facebook.common.g.c.kbq.a(a(memoryFile), null, options), "BitmapFactory returned null");
            } catch (IOException e) {
                throw k.r(e);
            }
        } finally {
            if (memoryFile != null) {
                memoryFile.close();
            }
        }
    }
}
