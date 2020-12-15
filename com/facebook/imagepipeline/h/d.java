package com.facebook.imagepipeline.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.facebook.common.internal.g;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.i;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(19)
/* loaded from: classes15.dex */
public class d extends b {
    private final i pjS;

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        return super.a(eVar, config, rect);
    }

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        return super.a(eVar, config, rect, i);
    }

    @Override // com.facebook.imagepipeline.h.b
    public /* bridge */ /* synthetic */ com.facebook.common.references.a ak(Bitmap bitmap) {
        return super.ak(bitmap);
    }

    public d(i iVar) {
        this.pjS = iVar;
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBuffer = aVar.get();
        int size = pooledByteBuffer.size();
        com.facebook.common.references.a<byte[]> Qy = this.pjS.Qy(size);
        try {
            byte[] bArr = Qy.get();
            pooledByteBuffer.c(0, bArr, 0, size);
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c(Qy);
        }
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options) {
        byte[] bArr = b(aVar, i) ? null : pou;
        PooledByteBuffer pooledByteBuffer = aVar.get();
        g.checkArgument(i <= pooledByteBuffer.size());
        com.facebook.common.references.a<byte[]> Qy = this.pjS.Qy(i + 2);
        try {
            byte[] bArr2 = Qy.get();
            pooledByteBuffer.c(0, bArr2, 0, i);
            if (bArr != null) {
                x(bArr2, i);
                i += 2;
            }
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c(Qy);
        }
    }

    private static void x(byte[] bArr, int i) {
        bArr[i] = -1;
        bArr[i + 1] = -39;
    }
}
