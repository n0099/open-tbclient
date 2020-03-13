package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class a implements b {
    private final b lTK;
    private final b lTL;
    private final b lTM;
    @Nullable
    private final Map<com.facebook.c.c, b> lTN;
    private final com.facebook.imagepipeline.i.e lTk;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.lTM = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dqA = eVar2.dqA();
                if (dqA == com.facebook.c.b.lPB) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dqA == com.facebook.c.b.lPD) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dqA == com.facebook.c.b.lPJ) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dqA == com.facebook.c.c.lPL) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.lTK = bVar;
        this.lTL = bVar2;
        this.lTk = eVar;
        this.lTN = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.lRL != null) {
            return bVar.lRL.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dqA = eVar.dqA();
        if (dqA == null || dqA == com.facebook.c.c.lPL) {
            dqA = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(dqA);
        }
        if (this.lTN != null && (bVar2 = this.lTN.get(dqA)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.lTM.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.lRK || this.lTK == null) ? a(eVar, bVar) : this.lTK.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lTk.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.lUh, eVar.dqw(), eVar.dqx());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lTk.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dqw(), eVar.dqx());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.lTL.a(eVar, i, hVar, bVar);
    }
}
