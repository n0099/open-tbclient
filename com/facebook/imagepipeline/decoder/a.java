package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
public class a implements b {
    private final b lOZ;
    private final com.facebook.imagepipeline.i.e lOz;
    private final b lPa;
    private final b lPb;
    @Nullable
    private final Map<com.facebook.c.c, b> lPc;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.lPb = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dod = eVar2.dod();
                if (dod == com.facebook.c.b.lKR) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dod == com.facebook.c.b.lKT) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dod == com.facebook.c.b.lKZ) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dod == com.facebook.c.c.lLb) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.lOZ = bVar;
        this.lPa = bVar2;
        this.lOz = eVar;
        this.lPc = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.lNa != null) {
            return bVar.lNa.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dod = eVar.dod();
        if (dod == null || dod == com.facebook.c.c.lLb) {
            dod = com.facebook.c.d.v(eVar.getInputStream());
            eVar.c(dod);
        }
        if (this.lPc != null && (bVar2 = this.lPc.get(dod)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.lPb.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.lMZ || this.lOZ == null) ? a(eVar, bVar) : this.lOZ.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lOz.a(eVar, bVar.bitmapConfig, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.lPw, eVar.dnZ(), eVar.doa());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.lOz.a(eVar, bVar.bitmapConfig, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dnZ(), eVar.doa());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.lPa.a(eVar, i, hVar, bVar);
    }
}
