package com.facebook.imagepipeline.i;

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
/* loaded from: classes9.dex */
public class c extends b {
    private static Method lQy;

    @Override // com.facebook.imagepipeline.i.b, com.facebook.imagepipeline.i.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        return super.a(eVar, config, rect);
    }

    @Override // com.facebook.imagepipeline.i.b, com.facebook.imagepipeline.i.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        return super.a(eVar, config, rect, i);
    }

    @Override // com.facebook.imagepipeline.i.b
    public /* bridge */ /* synthetic */ com.facebook.common.references.a ab(Bitmap bitmap) {
        return super.ab(bitmap);
    }

    @Override // com.facebook.imagepipeline.i.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        return a(aVar, aVar.get().size(), (byte[]) null, options);
    }

    @Override // com.facebook.imagepipeline.i.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options) {
        return a(aVar, i, b(aVar, i) ? null : lQw, options);
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
                    com.facebook.common.internal.a.e(aVar3, outputStream);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.internal.b.r(hVar2);
                    com.facebook.common.internal.b.r(aVar3);
                    com.facebook.common.internal.b.close(outputStream, true);
                    return memoryFile;
                } catch (Throwable th2) {
                    th = th2;
                    aVar2 = aVar3;
                    hVar = hVar2;
                    com.facebook.common.references.a.c(aVar);
                    com.facebook.common.internal.b.r(hVar);
                    com.facebook.common.internal.b.r(aVar2);
                    com.facebook.common.internal.b.close(outputStream, true);
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

    private synchronized Method doW() {
        if (lQy == null) {
            try {
                lQy = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw l.u(e);
            }
        }
        return lQy;
    }

    private FileDescriptor a(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) doW().invoke(memoryFile, new Object[0]);
        } catch (Exception e) {
            throw l.u(e);
        }
    }

    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, byte[] bArr, BitmapFactory.Options options) {
        MemoryFile memoryFile = null;
        try {
            try {
                memoryFile = a(aVar, i, bArr);
                return (Bitmap) g.checkNotNull(com.facebook.common.g.c.lEU.decodeFileDescriptor(a(memoryFile), null, options), "BitmapFactory returned null");
            } catch (IOException e) {
                throw l.u(e);
            }
        } finally {
            if (memoryFile != null) {
                memoryFile.close();
            }
        }
    }
}
