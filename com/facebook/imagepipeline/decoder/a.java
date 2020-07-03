package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e mTM;
    private final b mUn;
    private final b mUo;
    private final b mUp;
    @Nullable
    private final Map<com.facebook.c.c, b> mUq;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.mUp = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dFb = eVar2.dFb();
                if (dFb == com.facebook.c.b.mPU) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dFb == com.facebook.c.b.mPW) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dFb == com.facebook.c.b.mQc) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dFb == com.facebook.c.c.mQe) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.mUn = bVar;
        this.mUo = bVar2;
        this.mTM = eVar;
        this.mUq = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.mSi != null) {
            return bVar.mSi.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dFb = eVar.dFb();
        if (dFb == null || dFb == com.facebook.c.c.mQe) {
            dFb = com.facebook.c.d.t(eVar.getInputStream());
            eVar.c(dFb);
        }
        if (this.mUq != null && (bVar2 = this.mUq.get(dFb)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.mUp.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.mSg || this.mUn == null) ? a(eVar, bVar) : this.mUn.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mTM.a(eVar, bVar.mSh, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.mUK, eVar.dEX(), eVar.dEY());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.mTM.a(eVar, bVar.mSh, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dEX(), eVar.dEY());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.mUo.a(eVar, i, hVar, bVar);
    }
}
