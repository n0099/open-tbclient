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
/* loaded from: classes3.dex */
public class d extends b {
    private final i pwE;

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

    public d(i iVar) {
        this.pwE = iVar;
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBuffer = aVar.get();
        int size = pooledByteBuffer.size();
        com.facebook.common.references.a<byte[]> Pf = this.pwE.Pf(size);
        try {
            byte[] bArr = Pf.get();
            pooledByteBuffer.c(0, bArr, 0, size);
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c(Pf);
        }
    }

    @Override // com.facebook.imagepipeline.h.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options) {
        byte[] bArr = b(aVar, i) ? null : pBb;
        PooledByteBuffer pooledByteBuffer = aVar.get();
        g.checkArgument(i <= pooledByteBuffer.size());
        com.facebook.common.references.a<byte[]> Pf = this.pwE.Pf(i + 2);
        try {
            byte[] bArr2 = Pf.get();
            pooledByteBuffer.c(0, bArr2, 0, i);
            if (bArr != null) {
                w(bArr2, i);
                i += 2;
            }
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c(Pf);
        }
    }

    private static void w(byte[] bArr, int i) {
        bArr[i] = -1;
        bArr[i + 1] = -39;
    }
}
