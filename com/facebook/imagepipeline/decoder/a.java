package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.f.g;
import com.facebook.imagepipeline.f.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a implements b {
    private final b pmS;
    private final b pmT;
    private final b pmU;
    @Nullable
    private final Map<com.facebook.c.c, b> pmV;
    private final com.facebook.imagepipeline.h.e pmu;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.h.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.pmU = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c evB = eVar2.evB();
                if (evB == com.facebook.c.b.piS) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (evB == com.facebook.c.b.piU) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (evB == com.facebook.c.b.pja) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (evB == com.facebook.c.c.pjc) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.pmS = bVar;
        this.pmT = bVar2;
        this.pmu = eVar;
        this.pmV = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.f.c a(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.pkV != null) {
            return bVar.pkV.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c evB = eVar.evB();
        if (evB == null || evB == com.facebook.c.c.pjc) {
            evB = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(evB);
        }
        if (this.pmV != null && (bVar2 = this.pmV.get(evB)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.pmU.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.c b(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.pkT || this.pmS == null) ? a(eVar, bVar) : this.pmS.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.f.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pmu.a(eVar, bVar.pkU, null);
        try {
            return new com.facebook.imagepipeline.f.d(a2, g.pnp, eVar.evx(), eVar.evy());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.d c(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.pmu.a(eVar, bVar.pkU, null, i);
        try {
            return new com.facebook.imagepipeline.f.d(a2, hVar, eVar.evx(), eVar.evy());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.f.c d(com.facebook.imagepipeline.f.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.pmT.a(eVar, i, hVar, bVar);
    }
}
