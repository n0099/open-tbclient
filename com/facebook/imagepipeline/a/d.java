package com.facebook.imagepipeline.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.i;
import com.facebook.imagepipeline.memory.q;
/* loaded from: classes5.dex */
public class d implements com.facebook.common.g.a {
    private final b pJq;
    private final i pJr;

    public d(q qVar) {
        this.pJr = qVar.ezp();
        this.pJq = new b(qVar.ezs());
    }

    @Override // com.facebook.common.g.a
    @TargetApi(12)
    public Bitmap e(int i, int i2, Bitmap.Config config) {
        com.facebook.common.references.a<byte[]> aVar;
        com.facebook.imagepipeline.f.e eVar;
        BitmapFactory.Options c;
        int size;
        PooledByteBuffer pooledByteBuffer;
        com.facebook.common.references.a<byte[]> PF;
        com.facebook.common.references.a<PooledByteBuffer> b = this.pJq.b((short) i, (short) i2);
        try {
            eVar = new com.facebook.imagepipeline.f.e(b);
            try {
                eVar.c(com.facebook.c.b.pIt);
                c = c(eVar.getSampleSize(), config);
                size = b.get().size();
                pooledByteBuffer = b.get();
                PF = this.pJr.PF(size + 2);
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            try {
                byte[] bArr = PF.get();
                pooledByteBuffer.c(0, bArr, 0, size);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, size, c);
                decodeByteArray.setHasAlpha(true);
                decodeByteArray.eraseColor(0);
                com.facebook.common.references.a.c(PF);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(b);
                return decodeByteArray;
            } catch (Throwable th2) {
                th = th2;
                aVar = PF;
                com.facebook.common.references.a.c(aVar);
                com.facebook.imagepipeline.f.e.e(eVar);
                com.facebook.common.references.a.c(b);
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
