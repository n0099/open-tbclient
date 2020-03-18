package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.f.q;
import com.google.android.exoplayer2.extractor.f.v;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public final class c implements h {
    private static final Constructor<? extends e> mfS;
    private int mfT;
    private int mfU;
    private int mfV;
    private int mfW;
    private int mfX = 1;
    private int mfY;

    static {
        Constructor<? extends e> constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        }
        mfS = constructor;
    }

    @Override // com.google.android.exoplayer2.extractor.h
    public synchronized e[] dvr() {
        e[] eVarArr;
        synchronized (this) {
            eVarArr = new e[mfS != null ? 12 : 11];
            eVarArr[0] = new com.google.android.exoplayer2.extractor.a.d(this.mfT);
            eVarArr[1] = new com.google.android.exoplayer2.extractor.c.e(this.mfV);
            eVarArr[2] = new com.google.android.exoplayer2.extractor.c.g(this.mfU);
            eVarArr[3] = new com.google.android.exoplayer2.extractor.b.b(this.mfW);
            eVarArr[4] = new com.google.android.exoplayer2.extractor.f.c();
            eVarArr[5] = new com.google.android.exoplayer2.extractor.f.a();
            eVarArr[6] = new v(this.mfX, this.mfY);
            eVarArr[7] = new com.google.android.exoplayer2.extractor.flv.b();
            eVarArr[8] = new com.google.android.exoplayer2.extractor.d.c();
            eVarArr[9] = new q();
            eVarArr[10] = new com.google.android.exoplayer2.extractor.g.a();
            if (mfS != null) {
                try {
                    eVarArr[11] = mfS.newInstance(new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                }
            }
        }
        return eVarArr;
    }
}
