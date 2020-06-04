package com.facebook.imagepipeline.b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.i;
import com.facebook.imagepipeline.memory.q;
/* loaded from: classes12.dex */
public class d implements com.facebook.common.g.a {
    private final b mvc;
    private final i mvd;

    public d(q qVar) {
        this.mvd = qVar.dBn();
        this.mvc = new b(qVar.dBq());
    }

    @Override // com.facebook.common.g.a
    @TargetApi(12)
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        com.facebook.imagepipeline.g.e eVar;
        BitmapFactory.Options a;
        int size;
        PooledByteBuffer pooledByteBuffer;
        com.facebook.common.references.a<byte[]> Hw;
        com.facebook.common.references.a<byte[]> aVar = null;
        com.facebook.common.references.a<PooledByteBuffer> b = this.mvc.b((short) i, (short) i2);
        try {
            com.facebook.imagepipeline.g.e eVar2 = new com.facebook.imagepipeline.g.e(b);
            try {
                eVar2.c(com.facebook.c.b.mtV);
                a = a(eVar2.getSampleSize(), config);
                size = b.get().size();
                pooledByteBuffer = b.get();
                Hw = this.mvd.Hw(size + 2);
            } catch (Throwable th) {
                th = th;
                eVar = eVar2;
            }
            try {
                byte[] bArr = Hw.get();
                pooledByteBuffer.c(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, a);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                com.facebook.common.references.a.c(Hw);
                com.facebook.imagepipeline.g.e.e(eVar2);
                com.facebook.common.references.a.c(b);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                aVar = Hw;
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
