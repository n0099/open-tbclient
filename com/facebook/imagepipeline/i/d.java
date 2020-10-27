package com.facebook.imagepipeline.i;

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
/* loaded from: classes18.dex */
public class d extends b {
    private final i oKe;

    @Override // com.facebook.imagepipeline.i.b, com.facebook.imagepipeline.i.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect) {
        return super.a(eVar, config, rect);
    }

    @Override // com.facebook.imagepipeline.i.b, com.facebook.imagepipeline.i.e
    public /* bridge */ /* synthetic */ com.facebook.common.references.a a(com.facebook.imagepipeline.g.e eVar, Bitmap.Config config, @Nullable Rect rect, int i) {
        return super.a(eVar, config, rect, i);
    }

    @Override // com.facebook.imagepipeline.i.b
    public /* bridge */ /* synthetic */ com.facebook.common.references.a ak(Bitmap bitmap) {
        return super.ak(bitmap);
    }

    public d(i iVar) {
        this.oKe = iVar;
    }

    @Override // com.facebook.imagepipeline.i.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBuffer = aVar.get();
        int size = pooledByteBuffer.size();
        com.facebook.common.references.a<byte[]> OE = this.oKe.OE(size);
        try {
            byte[] bArr = OE.get();
            pooledByteBuffer.c(0, bArr, 0, size);
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr, 0, size, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c(OE);
        }
    }

    @Override // com.facebook.imagepipeline.i.b
    protected Bitmap a(com.facebook.common.references.a<PooledByteBuffer> aVar, int i, BitmapFactory.Options options) {
        byte[] bArr = b(aVar, i) ? null : oOE;
        PooledByteBuffer pooledByteBuffer = aVar.get();
        g.checkArgument(i <= pooledByteBuffer.size());
        com.facebook.common.references.a<byte[]> OE = this.oKe.OE(i + 2);
        try {
            byte[] bArr2 = OE.get();
            pooledByteBuffer.c(0, bArr2, 0, i);
            if (bArr != null) {
                w(bArr2, i);
                i += 2;
            }
            return (Bitmap) g.checkNotNull(BitmapFactory.decodeByteArray(bArr2, 0, i, options), "BitmapFactory returned null");
        } finally {
            com.facebook.common.references.a.c(OE);
        }
    }

    private static void w(byte[] bArr, int i) {
        bArr[i] = -1;
        bArr[i + 1] = -39;
    }
}
