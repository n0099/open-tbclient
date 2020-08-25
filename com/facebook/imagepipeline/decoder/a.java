package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a implements b {
    private final com.facebook.imagepipeline.i.e nvJ;
    private final b nwj;
    private final b nwk;
    private final b nwl;
    @Nullable
    private final Map<com.facebook.c.c, b> nwm;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.nwl = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dUr = eVar2.dUr();
                if (dUr == com.facebook.c.b.nrW) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dUr == com.facebook.c.b.nrY) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dUr == com.facebook.c.b.nse) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dUr == com.facebook.c.c.nsg) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.nwj = bVar;
        this.nwk = bVar2;
        this.nvJ = eVar;
        this.nwm = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.nuj != null) {
            return bVar.nuj.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dUr = eVar.dUr();
        if (dUr == null || dUr == com.facebook.c.c.nsg) {
            dUr = com.facebook.c.d.t(eVar.getInputStream());
            eVar.c(dUr);
        }
        if (this.nwm != null && (bVar2 = this.nwm.get(dUr)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.nwl.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.nuh || this.nwj == null) ? a(eVar, bVar) : this.nwj.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nvJ.a(eVar, bVar.nui, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.nwG, eVar.dUn(), eVar.dUo());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nvJ.a(eVar, bVar.nui, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dUn(), eVar.dUo());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.nwk.a(eVar, i, hVar, bVar);
    }
}
