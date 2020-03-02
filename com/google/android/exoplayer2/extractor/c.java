package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.f.q;
import com.google.android.exoplayer2.extractor.f.v;
import java.lang.reflect.Constructor;
/* loaded from: classes6.dex */
public final class c implements h {
    private static final Constructor<? extends e> meb;
    private int mec;
    private int med;
    private int mee;
    private int mef;
    private int meg = 1;
    private int meh;

    static {
        Constructor<? extends e> constructor = null;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(e.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException e) {
        } catch (NoSuchMethodException e2) {
        }
        meb = constructor;
    }

    @Override // com.google.android.exoplayer2.extractor.h
    public synchronized e[] duT() {
        e[] eVarArr;
        synchronized (this) {
            eVarArr = new e[meb != null ? 12 : 11];
            eVarArr[0] = new com.google.android.exoplayer2.extractor.a.d(this.mec);
            eVarArr[1] = new com.google.android.exoplayer2.extractor.c.e(this.mee);
            eVarArr[2] = new com.google.android.exoplayer2.extractor.c.g(this.med);
            eVarArr[3] = new com.google.android.exoplayer2.extractor.b.b(this.mef);
            eVarArr[4] = new com.google.android.exoplayer2.extractor.f.c();
            eVarArr[5] = new com.google.android.exoplayer2.extractor.f.a();
            eVarArr[6] = new v(this.meg, this.meh);
            eVarArr[7] = new com.google.android.exoplayer2.extractor.flv.b();
            eVarArr[8] = new com.google.android.exoplayer2.extractor.d.c();
            eVarArr[9] = new q();
            eVarArr[10] = new com.google.android.exoplayer2.extractor.g.a();
            if (meb != null) {
                try {
                    eVarArr[11] = meb.newInstance(new Object[0]);
                } catch (Exception e) {
                    throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
                }
            }
        }
        return eVarArr;
    }
}
