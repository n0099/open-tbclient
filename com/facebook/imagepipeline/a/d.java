package com.facebook.imagepipeline.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.i;
import com.facebook.imagepipeline.memory.q;
/* loaded from: classes3.dex */
public class d implements com.facebook.common.g.a {
    private final b pBd;
    private final i pBe;

    public d(q qVar) {
        this.pBe = qVar.eAy();
        this.pBd = new b(qVar.eAB());
    }

    @Override // com.facebook.common.g.a
    @TargetApi(12)
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<byte[]> aVar;
        com.facebook.imagepipeline.f.e eVar;
        BitmapFactory.Options c;
        int size;
        PooledByteBuffer pooledByteBuffer;
        com.facebook.common.references.a<byte[]> QM;
        com.facebook.common.references.a<PooledByteBuffer> b2 = this.pBd.b((short) i, (short) i2);
        try {
            eVar = new com.facebook.imagepipeline.f.e(b2);
            try {
                eVar.c(com.facebook.c.b.pAg);
                c = c(eVar.getSampleSize(), config);
                size = b2.get().size();
                pooledByteBuffer = b2.get();
                QM = this.pBe.QM(size + 2);
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            try {
                byte[] bArr = QM.get();
                pooledByteBuffer.c(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, c);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                com.facebook.common.references.a.c(QM);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(b2);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                aVar = QM;
                com.facebook.common.references.a.c(aVar);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(b2);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            aVar = null;
            eVar = null;
        }
    }

    private static BitmapFactory.Options c(int i, Bitmap.Config config) {
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
