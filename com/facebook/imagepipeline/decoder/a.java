package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class a implements b {
    private final com.facebook.imagepipeline.h.e pDG;
    private final b pEe;
    private final b pEf;
    private final b pEg;
    @Nullable
    private final Map<com.facebook.c.c, b> pEh;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pEg = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c ezN = eVar2.ezN();
                if (ezN == com.facebook.c.b.pAg) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (ezN == com.facebook.c.b.pAi) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (ezN == com.facebook.c.b.pAo) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (ezN == com.facebook.c.c.pAq) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pEe = bVar;
        this.pEf = bVar2;
        this.pDG = eVar;
        this.pEh = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pCh != null) {
            return bVar.pCh.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c ezN = eVar.ezN();
        if (ezN == null || ezN == com.facebook.c.c.pAq) {
            ezN = com.facebook.c.d.y(eVar.getInputStream());
            eVar.c(ezN);
        }
        if (this.pEh != null && (bVar2 = this.pEh.get(ezN)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pEg.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pCg || this.pEe == null) ? a(eVar, bVar) : this.pEe.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pDG.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pEB, eVar.ezJ(), eVar.ezK());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pDG.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.ezJ(), eVar.ezK());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pEf.a(eVar, i, hVar, bVar);
    }
}
