package com.facebook.imagepipeline.decoder;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.g.g;
import com.facebook.imagepipeline.g.h;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class a implements b {
    private final b nwB;
    private final b nwC;
    private final b nwD;
    @Nullable
    private final Map<com.facebook.c.c, b> nwE;
    private final com.facebook.imagepipeline.i.e nwb;

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar) {
        this(bVar, bVar2, eVar, null);
    }

    public a(b bVar, b bVar2, com.facebook.imagepipeline.i.e eVar, @Nullable Map<com.facebook.c.c, b> map) {
        this.nwD = new b() { // from class: com.facebook.imagepipeline.decoder.a.1
            @Override // com.facebook.imagepipeline.decoder.b
            public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar2, int i, h hVar, com.facebook.imagepipeline.common.b bVar3) {
                com.facebook.c.c dUA = eVar2.dUA();
                if (dUA == com.facebook.c.b.nso) {
                    return a.this.c(eVar2, i, hVar, bVar3);
                }
                if (dUA == com.facebook.c.b.nsq) {
                    return a.this.b(eVar2, i, hVar, bVar3);
                }
                if (dUA == com.facebook.c.b.nsw) {
                    return a.this.d(eVar2, i, hVar, bVar3);
                }
                if (dUA == com.facebook.c.c.nsy) {
                    throw new DecodeException("unknown image format", eVar2);
                }
                return a.this.a(eVar2, bVar3);
            }
        };
        this.nwB = bVar;
        this.nwC = bVar2;
        this.nwb = eVar;
        this.nwE = map;
    }

    @Override // com.facebook.imagepipeline.decoder.b
    public com.facebook.imagepipeline.g.c a(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        b bVar2;
        if (bVar.nuC != null) {
            return bVar.nuC.a(eVar, i, hVar, bVar);
        }
        com.facebook.c.c dUA = eVar.dUA();
        if (dUA == null || dUA == com.facebook.c.c.nsy) {
            dUA = com.facebook.c.d.t(eVar.getInputStream());
            eVar.c(dUA);
        }
        if (this.nwE != null && (bVar2 = this.nwE.get(dUA)) != null) {
            return bVar2.a(eVar, i, hVar, bVar);
        }
        return this.nwD.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.c b(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return (bVar.nuA || this.nwB == null) ? a(eVar, bVar) : this.nwB.a(eVar, i, hVar, bVar);
    }

    public com.facebook.imagepipeline.g.d a(com.facebook.imagepipeline.g.e eVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nwb.a(eVar, bVar.nuB, null);
        try {
            return new com.facebook.imagepipeline.g.d(a, g.nwY, eVar.dUw(), eVar.dUx());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.d c(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        com.facebook.common.references.a<Bitmap> a = this.nwb.a(eVar, bVar.nuB, null, i);
        try {
            return new com.facebook.imagepipeline.g.d(a, hVar, eVar.dUw(), eVar.dUx());
        } finally {
            a.close();
        }
    }

    public com.facebook.imagepipeline.g.c d(com.facebook.imagepipeline.g.e eVar, int i, h hVar, com.facebook.imagepipeline.common.b bVar) {
        return this.nwC.a(eVar, i, hVar, bVar);
    }
}
