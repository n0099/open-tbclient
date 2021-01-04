package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class a implements b {
    private final com.facebook.imagepipeline.h.e pBZ;
    @Nullable
    private final Map<com.facebook.c.c, b> pCA;
    private final b pCx;
    private final b pCy;
    private final b pCz;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pCz = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c ezj = eVar2.ezj();
                if (ezj == com.facebook.c.b.pyV) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (ezj == com.facebook.c.b.pyX) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (ezj == com.facebook.c.b.pzd) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (ezj == com.facebook.c.c.pzf) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pCx = bVar;
        this.pCy = bVar2;
        this.pBZ = eVar;
        this.pCA = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pAA != null) {
            return bVar.pAA.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c ezj = eVar.ezj();
        if (ezj == null || ezj == com.facebook.c.c.pzf) {
            ezj = com.facebook.c.d.y(eVar.getInputStream());
            eVar.c(ezj);
        }
        if (this.pCA != null && (bVar2 = this.pCA.get(ezj)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pCz.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pAz || this.pCx == null) ? a(eVar, bVar) : this.pCx.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pBZ.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pCU, eVar.ezf(), eVar.ezg());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pBZ.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.ezf(), eVar.ezg());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pCy.a(eVar, i, hVar, bVar);
    }
}
