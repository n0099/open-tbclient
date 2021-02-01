package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements b {
    private final b pJM;
    private final b pJN;
    private final b pJO;
    @Nullable
    private final Map<com.facebook.c.c, b> pJP;
    private final com.facebook.imagepipeline.h.e pJo;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pJO = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c eyo = eVar2.eyo();
                if (eyo == com.facebook.c.b.pFO) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (eyo == com.facebook.c.b.pFQ) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (eyo == com.facebook.c.b.pFW) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (eyo == com.facebook.c.c.pFY) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pJM = bVar;
        this.pJN = bVar2;
        this.pJo = eVar;
        this.pJP = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pHP != null) {
            return bVar.pHP.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c eyo = eVar.eyo();
        if (eyo == null || eyo == com.facebook.c.c.pFY) {
            eyo = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(eyo);
        }
        if (this.pJP != null && (bVar2 = this.pJP.get(eyo)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pJO.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pHO || this.pJM == null) ? a(eVar, bVar) : this.pJM.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pJo.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pKj, eVar.eyk(), eVar.eyl());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pJo.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.eyk(), eVar.eyl());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pJN.a(eVar, i, hVar, bVar);
    }
}
