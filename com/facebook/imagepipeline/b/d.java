package com.facebook.imagepipeline.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.i;
import com.facebook.imagepipeline.memory.q;
/* loaded from: classes18.dex */
public class d implements com.facebook.common.g.a {
    private final b oTw;
    private final i oTx;

    public d(q qVar) {
        this.oTx = qVar.eqM();
        this.oTw = new b(qVar.eqP());
    }

    @Override // com.facebook.common.g.a
    @TargetApi(12)
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        com.facebook.imagepipeline.g.e eVar;
        BitmapFactory.Options a2;
        int size;
        PooledByteBuffer pooledByteBuffer;
        com.facebook.common.references.a<byte[]> OZ;
        com.facebook.common.references.a<byte[]> aVar = null;
        com.facebook.common.references.a<PooledByteBuffer> b = this.oTw.b((short) i, (short) i2);
        try {
            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar2.c(com.facebook.c.b.oSq);
                a2 = a(eVar2.getSampleSize(), config);
                size = b.get().size();
                pooledByteBuffer = b.get();
                OZ = this.oTx.OZ(size + 2);
            } catch (Throwable th) {
                th = th;
                eVar = eVar2;
            }
            try {
                byte[] bArr = OZ.get();
                pooledByteBuffer.c(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, a2);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                com.facebook.common.references.a.c(OZ);
                com.facebook.imagepipeline.g.e.e(eVar2);
                com.facebook.common.references.a.c(b);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                aVar = OZ;
                eVar = eVar2;
                com.facebook.common.references.a.c(aVar);
                com.facebook.imagepipeline.g.e.e(eVar);
                com.facebook.common.references.a.c(b);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            eVar = null;
        }
    }

    private static BitmapFactory.Options a(int i, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i;
        if (Build.VERSION.SDK_INT >= 11) {
            options.inMutable = true;
        }
        return options;
    }
}
