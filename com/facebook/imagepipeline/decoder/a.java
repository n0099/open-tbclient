package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes15.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e oXF;
    private final b oYd;
    private final b oYe;
    private final b oYf;
    @Nullable
    private final Map<com.facebook.c.c, b> oYg;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.oYf = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c epW = eVar2.epW();
                if (epW == com.facebook.c.b.oTT) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (epW == com.facebook.c.b.oTV) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (epW == com.facebook.c.b.oUb) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (epW == com.facebook.c.c.oUd) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.oYd = bVar;
        this.oYe = bVar2;
        this.oXF = eVar;
        this.oYg = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.oWg != null) {
            return bVar.oWg.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c epW = eVar.epW();
        if (epW == null || epW == com.facebook.c.c.oUd) {
            epW = com.facebook.c.d.u(eVar.getInputStream());
            eVar.c(epW);
        }
        if (this.oYg != null && (bVar2 = this.oYg.get(epW)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.oYf.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.oWe || this.oYd == null) ? a(eVar, bVar) : this.oYd.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.oXF.a(eVar, bVar.oWf, null);
        try {
            return new com.facebook.imagepipeline.g.d(a2, g.oYA, eVar.epS(), eVar.epT());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a2 = this.oXF.a(eVar, bVar.oWf, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a2, hVar, eVar.epS(), eVar.epT());
        } finally {
            a2.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.oYe.a(eVar, i, hVar, bVar);
    }
}
