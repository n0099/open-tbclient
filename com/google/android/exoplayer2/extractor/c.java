package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.f.q;
import com.google.android.exoplayer2.extractor.f.v;
import java.lang.reflect.Constructor;
/* loaded from: classes5.dex */
public final class c implements h {
    private static final Constructor<? extends e> mdo;
    private int mdp;
    private int mdq;
    private int mdr;
    private int mds;
    private int mdt = 1;
    private int mdu;

    static {
        Constructor<? extends e> constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        }
        mdo = constructor;
    }

    @Override // com.google.android.exoplayer2.extractor.h
    public synchronized e[] dtE() {
        e[] eVarArr;
        synchronized (this) {
            eVarArr = new e[mdo != null ? 12 : 11];
            eVarArr[0] = new com.google.android.exoplayer2.extractor.a.d(this.mdp);
            eVarArr[1] = new com.google.android.exoplayer2.extractor.c.e(this.mdr);
            eVarArr[2] = new com.google.android.exoplayer2.extractor.c.g(this.mdq);
            eVarArr[3] = new com.google.android.exoplayer2.extractor.b.b(this.mds);
            eVarArr[4] = new com.google.android.exoplayer2.extractor.f.c();
            eVarArr[5] = new com.google.android.exoplayer2.extractor.f.a();
            eVarArr[6] = new v(this.mdt, this.mdu);
            eVarArr[7] = new com.google.android.exoplayer2.extractor.flv.b();
            eVarArr[8] = new com.google.android.exoplayer2.extractor.d.c();
            eVarArr[9] = new q();
            eVarArr[10] = new com.google.android.exoplayer2.extractor.g.a();
            if (mdo != null) {
                try {
                    eVarArr[11] = mdo.newInstance(new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                }
            }
        }
        return eVarArr;
    }
}
