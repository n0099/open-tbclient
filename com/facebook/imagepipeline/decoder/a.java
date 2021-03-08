package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements b {
    private final com.facebook.imagepipeline.h.e pLT;
    private final b pMr;
    private final b pMs;
    private final b pMt;
    @Nullable
    private final Map<com.facebook.c.c, b> pMu;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pMt = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c eyF = eVar2.eyF();
                if (eyF == com.facebook.c.b.pIt) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (eyF == com.facebook.c.b.pIv) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (eyF == com.facebook.c.b.pIB) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (eyF == com.facebook.c.c.pID) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pMr = bVar;
        this.pMs = bVar2;
        this.pLT = eVar;
        this.pMu = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pKu != null) {
            return bVar.pKu.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c eyF = eVar.eyF();
        if (eyF == null || eyF == com.facebook.c.c.pID) {
            eyF = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(eyF);
        }
        if (this.pMu != null && (bVar2 = this.pMu.get(eyF)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pMt.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pKt || this.pMr == null) ? a(eVar, bVar) : this.pMr.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pLT.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pMO, eVar.eyB(), eVar.eyC());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pLT.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.eyB(), eVar.eyC());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pMs.a(eVar, i, hVar, bVar);
    }
}
