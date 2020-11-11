package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class a implements b {
    private final b oWA;
    private final b oWB;
    private final b oWC;
    @Nullable
    private final Map<com.facebook.c.c, b> oWD;
    private final com.facebook.imagepipeline.i.e oWc;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.oWC = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c epY = eVar2.epY();
                if (epY == com.facebook.c.b.oSq) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (epY == com.facebook.c.b.oSs) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (epY == com.facebook.c.b.oSy) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (epY == com.facebook.c.c.oSA) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.oWA = bVar;
        this.oWB = bVar2;
        this.oWc = eVar;
        this.oWD = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.oUD != null) {
            return bVar.oUD.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c epY = eVar.epY();
        if (epY == null || epY == com.facebook.c.c.oSA) {
            epY = com.facebook.c.d.u(eVar.getInputStream());
            eVar.c(epY);
        }
        if (this.oWD != null && (bVar2 = this.oWD.get(epY)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.oWC.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.oUB || this.oWA == null) ? a(eVar, bVar) : this.oWA.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.oWc.a(eVar, bVar.oUC, null);
        try {
            return new com.facebook.imagepipeline.g.d(a2, g.oWX, eVar.epU(), eVar.epV());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.oWc.a(eVar, bVar.oUC, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a2, hVar, eVar.epU(), eVar.epV());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.oWB.a(eVar, i, hVar, bVar);
    }
}
