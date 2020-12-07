package com.facebook.imagepipeline.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.i;
import com.facebook.imagepipeline.memory.q;
/* loaded from: classes15.dex */
public class d implements com.facebook.common.g.a {
    private final b pjP;
    private final i pjQ;

    public d(q qVar) {
        this.pjQ = qVar.ewm();
        this.pjP = new b(qVar.ewp());
    }

    @Override // com.facebook.common.g.a
    @TargetApi(12)
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        com.facebook.imagepipeline.f.e eVar;
        BitmapFactory.Options a2;
        int size;
        PooledByteBuffer pooledByteBuffer;
        com.facebook.common.references.a<byte[]> Qy;
        com.facebook.common.references.a<byte[]> aVar = null;
        com.facebook.common.references.a<PooledByteBuffer> b = this.pjP.b((short) i, (short) i2);
        try {
            com.facebook.imagepipeline.f.e eVar2 = new com.facebook.imagepipeline.f.e(b);
            try {
                eVar2.c(com.facebook.c.b.piS);
                a2 = a(eVar2.getSampleSize(), config);
                size = b.get().size();
                pooledByteBuffer = b.get();
                Qy = this.pjQ.Qy(size + 2);
            } catch (Throwable th) {
                th = th;
                eVar = eVar2;
            }
            try {
                byte[] bArr = Qy.get();
                pooledByteBuffer.c(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, a2);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                com.facebook.common.references.a.c(Qy);
                com.facebook.imagepipeline.f.e.e(eVar2);
                com.facebook.common.references.a.c(b);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                aVar = Qy;
                eVar = eVar2;
                com.facebook.common.references.a.c(aVar);
                com.facebook.imagepipeline.f.e.e(eVar);
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
