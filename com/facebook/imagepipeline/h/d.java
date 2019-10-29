package com.facebook.imagepipeline.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.common.internal.g;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.i;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
@TargetApi(19)
/* loaded from: classes2.dex */
public class d extends b {
    private final i kgw;

    @Override // com.facebook.imagepipeline.h.b
    public /* bridge */ /* synthetic */ com.facebook.common.references.a Z(Bitmap bitmap) {
        return super.Z(bitmap);
    }

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config) {
        return super.a(dVar, config);
    }

    @Override // com.facebook.imagepipeline.h.b, com.facebook.imagepipeline.h.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.f.d dVar, Bitmap.Config config, int i) {
        return super.a(dVar, config, i);
    }

    public d(i iVar) {
        this.kgw = iVar;
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBuffer = aVar.get();
        int size = pooledByteBuffer.size();
        com.facebook.common.references.a<byte[]> CF = this.kgw.CF(size);
        try {
            byte[] bArr = CF.get();
            pooledByteBuffer.c(0, bArr, 0, size);
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) CF);
        }
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options) {
        byte[] bArr = a(aVar, i) ? null : kkV;
        PooledByteBuffer pooledByteBuffer = aVar.get();
        g.checkArgument(i <= pooledByteBuffer.size());
        com.facebook.common.references.a<byte[]> CF = this.kgw.CF(i + 2);
        try {
            byte[] bArr2 = CF.get();
            pooledByteBuffer.c(0, bArr2, 0, i);
            if (bArr != null) {
                r(bArr2, i);
                i += 2;
            }
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c((com.facebook.common.references.a<?>) CF);
        }
    }

    private static void r(byte[] bArr, int i) {
        bArr[i] = -1;
        bArr[i + 1] = -39;
    }
}
