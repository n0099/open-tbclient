package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes25.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e nFY;
    private final b nGA;
    @Nullable
    private final Map<com.facebook.c.c, b> nGB;
    private final b nGy;
    private final b nGz;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.nGA = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dYy = eVar2.dYy();
                if (dYy == com.facebook.c.b.nCm) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dYy == com.facebook.c.b.nCo) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dYy == com.facebook.c.b.nCu) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dYy == com.facebook.c.c.nCw) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.nGy = bVar;
        this.nGz = bVar2;
        this.nFY = eVar;
        this.nGB = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.nEz != null) {
            return bVar.nEz.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dYy = eVar.dYy();
        if (dYy == null || dYy == com.facebook.c.c.nCw) {
            dYy = com.facebook.c.d.t(eVar.getInputStream());
            eVar.c(dYy);
        }
        if (this.nGB != null && (bVar2 = this.nGB.get(dYy)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.nGA.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.nEx || this.nGy == null) ? a(eVar, bVar) : this.nGy.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nFY.a(eVar, bVar.nEy, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.nGV, eVar.dYu(), eVar.dYv());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nFY.a(eVar, bVar.nEy, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dYu(), eVar.dYv());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.nGz.a(eVar, i, hVar, bVar);
    }
}
