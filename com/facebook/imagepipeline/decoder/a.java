package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a implements b {
    private final b nVP;
    private final b nVQ;
    private final b nVR;
    @Nullable
    private final Map<com.facebook.c.c, b> nVS;
    private final com.facebook.imagepipeline.i.e nVr;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.nVR = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c ecj = eVar2.ecj();
                if (ecj == com.facebook.c.b.nRF) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (ecj == com.facebook.c.b.nRH) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (ecj == com.facebook.c.b.nRN) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (ecj == com.facebook.c.c.nRP) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.nVP = bVar;
        this.nVQ = bVar2;
        this.nVr = eVar;
        this.nVS = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.nTS != null) {
            return bVar.nTS.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c ecj = eVar.ecj();
        if (ecj == null || ecj == com.facebook.c.c.nRP) {
            ecj = com.facebook.c.d.u(eVar.getInputStream());
            eVar.c(ecj);
        }
        if (this.nVS != null && (bVar2 = this.nVS.get(ecj)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.nVR.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.nTQ || this.nVP == null) ? a(eVar, bVar) : this.nVP.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.nVr.a(eVar, bVar.nTR, null);
        try {
            return new com.facebook.imagepipeline.g.d(a2, g.nWm, eVar.ecf(), eVar.ecg());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.nVr.a(eVar, bVar.nTR, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a2, hVar, eVar.ecf(), eVar.ecg());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.nVQ.a(eVar, i, hVar, bVar);
    }
}
