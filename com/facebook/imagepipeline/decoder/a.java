package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a implements b {
    private final b pmU;
    private final b pmV;
    private final b pmW;
    @Nullable
    private final Map<com.facebook.c.c, b> pmX;
    private final com.facebook.imagepipeline.h.e pmw;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pmW = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c evC = eVar2.evC();
                if (evC == com.facebook.c.b.piU) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (evC == com.facebook.c.b.piW) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (evC == com.facebook.c.b.pjc) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (evC == com.facebook.c.c.pje) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pmU = bVar;
        this.pmV = bVar2;
        this.pmw = eVar;
        this.pmX = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pkX != null) {
            return bVar.pkX.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c evC = eVar.evC();
        if (evC == null || evC == com.facebook.c.c.pje) {
            evC = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(evC);
        }
        if (this.pmX != null && (bVar2 = this.pmX.get(evC)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pmW.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pkV || this.pmU == null) ? a(eVar, bVar) : this.pmU.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pmw.a(eVar, bVar.pkW, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pnr, eVar.evy(), eVar.evz());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pmw.a(eVar, bVar.pkW, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.evy(), eVar.evz());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pmV.a(eVar, i, hVar, bVar);
    }
}
